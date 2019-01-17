package com.example.samuli.testapplication;

import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Elokuvateatterit {
    public ArrayList<String> paikkakunta_array;
    public ArrayList<String> elokuva_array;
    public ArrayList<String> Tennispalatsi_elokuvat;
    public ArrayList<String> Kinopalatsi_elokuvat;


    public void readXML(){
        try {
            paikkakunta_array = new ArrayList<String>();
            elokuva_array = new ArrayList<String>();
            Tennispalatsi_elokuvat= new ArrayList<String>();
            Kinopalatsi_elokuvat=new ArrayList<String>();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Schedule/?area=1029&dt=07.12.2018";
            Document doc =  builder.parse(urlString);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getElementsByTagName("Show");
            for(int i = 0; i<nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (!paikkakunta_array.contains(element.getElementsByTagName("Theatre").item(0).getTextContent())) {
                        paikkakunta_array.add(element.getElementsByTagName("Theatre").item(0).getTextContent());
                    }
                    if (element.getElementsByTagName("Theatre").item(0).getTextContent().contains("Tennispalatsi, Helsinki") && !Tennispalatsi_elokuvat.contains(element.getElementsByTagName("Title").item(0).getTextContent())) {
                        Tennispalatsi_elokuvat.add(element.getElementsByTagName("Title").item(0).getTextContent());
                    }
                    if (element.getElementsByTagName("Theatre").item(0).getTextContent().contains("Kinopalatsi, Helsinki") && !Kinopalatsi_elokuvat.contains(element.getElementsByTagName("Title").item(0).getTextContent())) {
                        Kinopalatsi_elokuvat.add(element.getElementsByTagName("Title").item(0).getTextContent());
                    }
                }
            }
            System.out.println("Tennispalatsin elokuvat: "+Tennispalatsi_elokuvat);
           System.out.println("Paikkakunnat: "+paikkakunta_array);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}



