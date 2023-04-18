package com.pravnainfo.pravnainformatika.jcolibri.model;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaseDescription implements CaseComponent {

	private int id;
	private String sud;
	private String poslovniBroj;
	private String sudija;
	private String tuzilac;
	private String okrivljeni;
	private String krivicnoDelo;
	private List<String> telesnePovrede = new ArrayList<String>();
	private String vrstaPresude;
	private List<String> primenjeniPropisi = new ArrayList<String>();
	private String kazna;
	
	@Override
	public String toString() {
		return "CaseDescription [id=" + id + ", sud=" + sud + ", poslovniBroj=" + poslovniBroj + ", sudija=" + sudija
				+ ", tuzilac=" + tuzilac + ", okrivljeni=" + okrivljeni + ", krivicnoDelo=" + krivicnoDelo
				+ ", telesnePovrede=" + telesnePovrede + ", vrstaPresude=" + vrstaPresude + ", primenjeniPropisi="
				+ primenjeniPropisi + " ,kazna=" + kazna + "]";
	}
	
	@Override
	public Attribute getIdAttribute() {
		return new Attribute("id", this.getClass());
	}
	
	
	
}
