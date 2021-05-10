package com.cmpe202.creditcard.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cmpe202.creditcard.validator.CreditCard;

public class XMLParser implements IParse {
	
	private String path;

	@Override
	public List<CreditCard> parse() {
        List<CreditCard> ccList = new ArrayList<CreditCard>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        
		try {
			builder = factory.newDocumentBuilder();
	        try {
    			  Document document = builder.parse(new File(path));
		          NodeList nodeList = document.getDocumentElement().getChildNodes();
		          for (int i = 0; i < nodeList.getLength(); i++) {
		               Node node = nodeList.item(i);
		 
		               if (node.getNodeType() == Node.ELEMENT_NODE) {
		                    Element elem = (Element) node;
		 
		                    String CardNumber = elem.getElementsByTagName("CardNumber")
                            .item(0).getChildNodes().item(0).getNodeValue();

		                    String ExpirationDate = elem.getElementsByTagName("ExpirationDate")
	                                .item(0).getChildNodes().item(0).getNodeValue();

		                    String NameOfCardholder = elem.getElementsByTagName("NameOfCardholder")
	                                .item(0).getChildNodes().item(0).getNodeValue();

		                    CreditCard cc = new CreditCard();
		                    cc.setCardNumber(CardNumber);
		                    cc.setExpirationDate(ExpirationDate);
		                    cc.setNameOfCardholder(NameOfCardholder);
		                    
		                    ccList.add(cc);
		               }
		          }
				
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Load the input XML document, parse it and return an instance of the
        // Document class.

        
		return ccList;
	}

	@Override
	public IParse setPath(String path) {
		// TODO Auto-generated method stub
		this.path = path;
		return null;
	}

	@Override
	public IParse setSeparator(String separator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(List<String> result, String path) {
		// TODO Auto-generated method stub
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
	        // root element
	        Element root = document.createElement("root");
	        document.appendChild(root);

			for (String r : result) {
				String[] rec_arr = r.split(",");
				Element row = document.createElement("row");
				
	            Element cardNumber = document.createElement("CardNumber");
	            cardNumber.appendChild(document.createTextNode(rec_arr[0]));
	            row.appendChild(cardNumber);

	            Element cardType = document.createElement("CardType");
	            cardType.appendChild(document.createTextNode(rec_arr[1]));
	            row.appendChild(cardType);
	            
	            Element status = document.createElement("Status");
	            status.appendChild(document.createTextNode(rec_arr[2]));
	            row.appendChild(status);
	            
	            root.appendChild(row);
			}
			
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        DOMSource domSource = new DOMSource(document);
	        StreamResult streamResult = new StreamResult(new File(path));

	        transformer.transform(domSource, streamResult);	
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	
	}

}
