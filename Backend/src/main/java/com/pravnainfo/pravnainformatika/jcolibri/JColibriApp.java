package com.pravnainfo.pravnainformatika.jcolibri;


import com.pravnainfo.pravnainformatika.jcolibri.model.CaseDescription;
import com.pravnainfo.pravnainformatika.jcolibri.similarity.TabularSimilarity;
import com.pravnainfo.pravnainformatika.model.KrivicnoDelo;
import com.pravnainfo.pravnainformatika.model.Propis;
import com.pravnainfo.pravnainformatika.model.TelesnaPovreda;
import com.pravnainfo.pravnainformatika.dto.PresudaDTO;
import com.pravnainfo.pravnainformatika.jcolibri.connector.CsvConnector;
import es.ucm.fdi.gaia.jcolibri.casebase.LinealCaseBase;
import es.ucm.fdi.gaia.jcolibri.cbraplications.StandardCBRApplication;
import es.ucm.fdi.gaia.jcolibri.cbrcore.*;
import es.ucm.fdi.gaia.jcolibri.exception.ExecutionException;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Equal;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.RetrievalResult;
import es.ucm.fdi.gaia.jcolibri.method.retrieve.selection.SelectCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JColibriApp implements StandardCBRApplication {
	
	Connector _connector;  /** Connector object */
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new CsvConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
		
		simConfig.addMapping(new Attribute("krivicnoDelo", CaseDescription.class), new Equal());
		TabularSimilarity slicnostPovreda = new TabularSimilarity(Arrays.asList(new String[] {"laka", "teska"}));
		slicnostPovreda.setSimilarity("laka", "teska", .5);
		simConfig.addMapping(new Attribute("telesnePovrede", CaseDescription.class), slicnostPovreda);
		TabularSimilarity slicnostPropisa = new TabularSimilarity(Arrays.asList(new String[] {
				"cl. 42 st. 1 ZOBSNP",
				"cl. 43 st. 1 ZOBSNP",
				"cl. 47 st. 1 ZOBSNP",
				"cl. 47 st. 3 ZOBSNP",
				"cl. 47 st. 4 ZOBSNP"}));
		slicnostPropisa.setSimilarity("cl. 42 st. 1 ZOBSNP", "cl. 43 st. 1 ZOBSNP", .5);
		slicnostPropisa.setSimilarity("cl. 47 st. 1 ZOBSNP", "cl. 47 st. 3 ZOBSNP", .5);
		slicnostPropisa.setSimilarity("cl. 47 st. 3 ZOBSNP", "cl. 47 st. 4 ZOBSNP", .5);
		slicnostPropisa.setSimilarity("cl. 47 st. 1 ZOBSNP", "cl. 47 st. 4 ZOBSNP", .5);
		simConfig.addMapping(new Attribute("primenjeniPropisi", CaseDescription.class), slicnostPropisa);
		
		// Equal - returns 1 if both individuals are equal, otherwise returns 0
		// Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
		// Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
		// EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
		// MaxString - returns a similarity value depending of the biggest substring that belong to both strings
		// EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
		// EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
		// Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
		// TabularSimilarity - calculates similarity between two strings or two lists of strings on the basis of tabular similarities
	}

	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 5);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		Collection<CBRCase> cases = _caseBase.getCases();
//		for (CBRCase c: cases)
//			System.out.println(c.getDescription());
		return _caseBase;
	}

	public static void jcolibri() {
		StandardCBRApplication recommender = new JColibriApp();
		try {
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			CaseDescription caseDescription = new CaseDescription();
			
			caseDescription.setKrivicnoDelo("cl. 289 st. 3 KZ");
			List<String> primenjeniPropisi = new ArrayList();
			primenjeniPropisi.add("cl. 55 st. 3 tac. 15 ZOBSNP");
			primenjeniPropisi.add("cl. 43 st. 1 ZOBSNP");
			caseDescription.setPrimenjeniPropisi(primenjeniPropisi);
			List<String> telesnePovrede = new ArrayList();
			telesnePovrede.add("lake");
			caseDescription.setTelesnePovrede(telesnePovrede);
			
			query.setDescription( caseDescription );

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String jcolibriNew(PresudaDTO presudaDto) {
		JColibriApp recommender = new JColibriApp();
		String rezultat = "";
		try {
			recommender.configure();

			recommender.preCycle();
			
			CBRQuery query = new CBRQuery();
			CaseDescription caseDescription = new CaseDescription();
			
			
			String krivicnaDela = "";
			List<KrivicnoDelo> delaLista = presudaDto.getKrivicnaDela();
			for (int i = 0; i < delaLista.size(); i++) {
				krivicnaDela = krivicnaDela + delaLista.get(i).getNaziv();
				if(i != delaLista.size() - 1)
					krivicnaDela = krivicnaDela + ",";
			}
			caseDescription.setKrivicnoDelo(krivicnaDela);
			
			
			List<String> primenjeniPropisi = new ArrayList();
			for (Propis propis : presudaDto.getPrimenjeniPropisi()) {
				primenjeniPropisi.add(propis.getOpis());
			}
			caseDescription.setPrimenjeniPropisi(primenjeniPropisi);
			
			
			List<String> telesnePovrede = new ArrayList();
			for (TelesnaPovreda povreda : presudaDto.getTelesnePovrede()) {
				primenjeniPropisi.add(povreda.getOpis());
			}
			caseDescription.setTelesnePovrede(telesnePovrede);
			
			query.setDescription( caseDescription );

			Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(recommender._caseBase.getCases(), query, recommender.simConfig);
			eval = SelectCases.selectTopKRR(eval, 5);
			System.out.println("Retrieved cases:");
			
			rezultat = rezultat + "Predlog presuda na osnovu tri najsličnije presude u sistemu:\n\n";
			for (RetrievalResult nse : eval) {
				System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
				
				String kazna = nse.get_case().getDescription().toString().split(",")[10];
				
				rezultat = rezultat + kazna;
				
			}
			
			recommender.postCycle();
			
			return rezultat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}