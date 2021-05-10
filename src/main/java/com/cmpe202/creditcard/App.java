package com.cmpe202.creditcard;

import java.util.List;
import java.util.logging.Logger;

import com.cmpe202.creditcard.parser.CSVParser;
import com.cmpe202.creditcard.parser.JSONParser;
import com.cmpe202.creditcard.parser.Parser;
import com.cmpe202.creditcard.parser.XMLParser;
import com.cmpe202.creditcard.validator.AmexCreditCard;
import com.cmpe202.creditcard.validator.CCValidator;
import com.cmpe202.creditcard.validator.CCValidatorBuilder;
import com.cmpe202.creditcard.validator.CreditCard;
import com.cmpe202.creditcard.validator.DiscoverCreditCard;
import com.cmpe202.creditcard.validator.MasterCreditCard;
import com.cmpe202.creditcard.validator.VisaCreditCard;

public class App {
	static Logger logger = Logger.getGlobal();
	
	static void ParseCSV(CCValidator validator) {
		logger.info("Parsing CSV ....");
		
		Parser parser = new Parser("/csv.txt", "\t"); 
		parser.setStrategy(new CSVParser());
		
		 try { 
			 List<CreditCard> ccList = parser.parse(); 
			 List<String> results = validator.validate(ccList);
			 parser.write(results, "./resources/output/csv_out.csv");
			 logger.info("Done creating csv File\n");	
		  
		  } catch (Exception e) { 
			  e.printStackTrace(); 
		  }
	}
	
	static void ParseJSON(CCValidator validator) {
		logger.info("Parsing JSON ....");
		Parser parser = new Parser("/json.txt", "\t");
		parser.setStrategy(new JSONParser());

		try {
			List<CreditCard> ccList = parser.parse();
			List<String> results = validator.validate(ccList);
			parser.write(results, "./resources/output/json_out.json");
			
			logger.info("Done creating json File\n");	

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void ParseXML(CCValidator validator) {
		logger.info("Parsing XML ....");
		Parser parser = new Parser("./resources/xml.txt", "\t");
		parser.setStrategy(new XMLParser());

		try {
			List<CreditCard> ccList = parser.parse();
			List<String> results = validator.validate(ccList);
			parser.write(results, "./resources/output/xml_out.xml");

            logger.info("Done creating XML File\n");			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		logger.info("Registering credit cards !!!!\n");
		
		CCValidator validator = new CCValidatorBuilder().setSubscriber("amex", new AmexCreditCard())
				.setSubscriber("visa", new VisaCreditCard()).setSubscriber("master", new MasterCreditCard())
				.setSubscriber("discover", new DiscoverCreditCard()).Build();
		
		ParseCSV(validator);
		ParseJSON(validator);
		ParseXML(validator);
	}
}
