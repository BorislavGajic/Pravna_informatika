package com.pravnainfo.pravnainformatika.services;

import com.pravnainfo.pravnainformatika.dto.TipDelaDTO;
import com.pravnainfo.pravnainformatika.utils.PDFParser;
import liquibase.pro.packaged.B;
import lombok.SneakyThrows;
import org.apache.catalina.connector.InputBuffer;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@Service
public class DocumentServiceImpl implements DocumentService {
    public static PDFParser parser;

    static {
        try {
            parser = PDFParser.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public String parsePDF(String brZakona, String docName) {
        return parser.convertPDFToString(brZakona, docName);
    }

    public String parseCriminalLaw() {
        return parser.convertCrimanlLawPdfToString();
    }

    @Override
    public String makeFactsRdf(TipDelaDTO dto) throws IOException, IllegalAccessException, InterruptedException, ParserConfigurationException, SAXException {
        String filer = makeFiler(dto);

        String currentDir = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDir).getParent().resolve("dr-device").resolve("facts.rdf");

        FileWriter fileWriter = new FileWriter(filePath.toFile());
        fileWriter.write(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                        "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                        "        xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n" +
                        "        xmlns:xsd=\"http://www.w3.org/2001/XMLSchema#\"\n" +
                        "        xmlns:lc=\"http://informatika.ftn.uns.ac.rs/legal-case.rdf#\">\n" +
                        "    <lc:case rdf:about=\"http://informatika.ftn.uns.ac.rs/legal-case.rdf#case01\">\n" +
                        "        <lc:name>case 01</lc:name>\n" +
                        "        <lc:defendant>Cvele</lc:defendant>\n" +
                        filer +
                        "    </lc:case>\n" +
                        "</rdf:RDF>"
        );

        fileWriter.close();

        doStartBat(currentDir);
        parseExport();

        return null;
    }

    public String makeFiler(TipDelaDTO dto) throws IllegalAccessException {
        StringBuilder res = new StringBuilder();
        Class cls = dto.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().getName().equals("java.lang.String")) {
                Object value = field.get(dto);
                String name = field.getName();
                if (value == null) {
                    res.append("\t<lc:" + name + ">no</lc:" + name + ">\n");
                } else {
                    if (value.equals("no")) {
                        res.append("\t<lc:" + name + ">no</lc:" + name + ">\n");
                    } else if (value.equals("yes")) {
                        res.append("\t<lc:" + name + ">yes</lc:" + name + ">\n");
                    } else {
                        res.append("\t<lc:" + name + ">no</lc:" + name + ">\n");
                    }
                }
            }
        }

        System.out.println(res.toString());
        return res.toString();
    }

    public void doStartBat(String currentDir) throws IOException, InterruptedException {
        String workingDir = Paths.get(currentDir).getParent().resolve("dr-device").toString();
        String startBatPath = workingDir + "\\" + "start.bat";


        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", startBatPath);
        builder.directory(new File(workingDir));

        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int execCode = process.waitFor();
        System.out.println("start.bat exited with code: " + execCode);
    }

    public void parseExport() throws ParserConfigurationException, IOException, SAXException {
        Path filePath = Paths.get(System.getProperty("user.dir")).
                getParent().
                resolve("dr-device").
                resolve("export.rdf");
        File xmlFile = new File(filePath.toUri());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        NodeList nodeList = doc.getElementsByTagName("*");

        String optuzeni = "";
        HashMap<String, String> tackaOptuznice = new HashMap<>();
        HashMap<String, String> godine = new HashMap<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE &&
                    node.getNodeName().toString().matches("export(.*)") &&
                    node.getTextContent().toString().contains("\n")) {
                System.out.println("=========================================================================================");
                String tagName = node.getNodeName();
                String value = node.getTextContent();
                if (optuzeni.equals("")) {
                    optuzeni = value.split("\n")[1].strip();
                }

                if (tagName.contains("t:zk_")) {
                    String zkname = tagName.split(":")[1];
                    String positive_negative = value.split("\n")[2].strip();
                    tackaOptuznice.put(zkname, positive_negative);
                } else {
                    String kazna = tagName.split(":")[1].strip();
                    String vreme = value.split("\n")[1].strip();
                    godine.put(kazna, vreme);
                }

                System.out.println("This is nodename: ->" + tagName + "<-: ->" + value + "<-");
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("optuzeni: " + optuzeni);
        System.out.println("tackaOptuznice: " + tackaOptuznice);
        System.out.println("godine: " + godine);
    }
}
