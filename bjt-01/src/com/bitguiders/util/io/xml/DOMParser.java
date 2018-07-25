package com.bitguiders.util.io.xml;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class DOMParser {
	Document doc=null;
	HashSet<String> data=new HashSet<String>();
	
	private Document getDocument(File file) {
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder;
	        Document doc = null;
	        try {
	            builder = factory.newDocumentBuilder();
	            doc = builder.parse(file);
	            //doc = (Document) Jsoup.parse(file, "utf-8");
	        } catch (SAXException | IOException | ParserConfigurationException e) {
	            e.printStackTrace();
	        }
	        return doc;
	}
	private void parse(File file,String tagName,String attributeName,String attributeValue) {
		System.out.println("Parsing:"+file.getAbsolutePath());
       
		doc = getDocument(file);
		
        System.out.println("Root : " + doc.getDocumentElement().getNodeName());
        System.out.println("\n<"+tagName+" "+attributeName+"='"+attributeValue+"'>");
        
        
        NodeList tagsList = doc.getElementsByTagName(tagName);
        
        
        for (int i = 0; i < tagsList.getLength(); i++) {
            Element e = (Element) tagsList.item(i);
       
            String attributeVlue = (e.hasAttributes()?e.getAttribute(attributeName):null);
            if(null!=attributeVlue && attributeVlue.equals(attributeValue)) {
            	 System.out.println(e.getNodeName() + " : " + e.getTextContent());
            }else {
            	System.out.println("Other attr:"+attributeVlue);
            }
        }
	}
	private HashSet<String> getAttributeValues(File file,String tagName,String attributeName) {
		HashSet<String> attributeValues = new HashSet<String>();
       
		doc = getDocument(file);
		
        NodeList tagsList = doc.getElementsByTagName(tagName);
        
        for (int i = 0; i < tagsList.getLength(); i++) {
            Element e = (Element) tagsList.item(i);
       
            String attributeVlue = (e.hasAttributes()?e.getAttribute(attributeName):null);
            if(null!=attributeVlue) {
            	 attributeValues.add(attributeVlue);
            }
        }
        return attributeValues;
	}
	private HashSet<String> getAttributeByValue(File file,String tagName,String attributeName,String attributeValue) {
		HashSet<String> attributeValues = new HashSet<String>();
       
		doc = getDocument(file);
		
        NodeList tagsList = doc.getElementsByTagName(tagName);
        
        for (int i = 0; i < tagsList.getLength(); i++) {
            Element e = (Element) tagsList.item(i);
       
            String attrValue = (e.hasAttributes()?e.getAttribute(attributeName):null);
            if(null!=attrValue && attrValue.contains(attributeValue)) {
            	 attributeValues.add(attrValue);
            }
        }
        return attributeValues;
	}
	private HashSet<String> parse(String path,String tagName,String attributeName,String attributeValue) {
		File file = new File(path);
		if(file.isDirectory()) {
			for(File f:file.listFiles()) {
				parse(f.getAbsolutePath(),tagName,attributeName,attributeValue);
			}
		}else {
			if(null==attributeValue) {
				data.addAll(getAttributeValues(file, tagName, attributeName));
			}else {
				data.addAll(getAttributeByValue(file,tagName,attributeName,attributeValue));
			}
		}
		return data;
	}
    public static void main(String[] args) {
        String path = "D:\\workspaces\\bitguiders\\training\\bjt-01\\bjt-01\\src\\com\\bitguiders\\util\\io\\xml\\data\\data.xml";
        String path2 = "D:\\workspaces\\bitguiders\\training\\bjt-01\\bjt-01\\src\\com\\bitguiders\\util\\io\\xml\\data\\";
        DOMParser parser = new DOMParser();
       // parser.parse(path,"name","brand","apple");
        for(String v:parser.parse(path,"name","brand",null)) {
        	System.out.println(v);
        }
    }
 
}