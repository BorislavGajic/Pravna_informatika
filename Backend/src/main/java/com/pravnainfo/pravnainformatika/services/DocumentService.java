package com.pravnainfo.pravnainformatika.services;

import com.pravnainfo.pravnainformatika.dto.TipDelaDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface DocumentService {
    String parsePDF(String brZakona, String docName);
    String parseCriminalLaw();
    String makeFactsRdf(TipDelaDTO dto) throws IOException, IllegalAccessException, InterruptedException, ParserConfigurationException, SAXException;

}
