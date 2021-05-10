package com.cmpe202.creditcard.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cmpe202.creditcard.validator.CreditCard;

public class csvParserTest {

	@Test
	public void testParse() {
		List<CreditCard> ccList = new ArrayList<CreditCard>();
		CreditCard cc1 = new CreditCard();
		cc1.setCardNumber("5410000000000000");
		cc1.setExpirationDate("3/20/2030");
		cc1.setNameOfCardholder("Alice");

		CreditCard cc2 = new CreditCard();
		cc2.setCardNumber("4120000000000");
		cc2.setExpirationDate("4/20/2030");
		cc2.setNameOfCardholder("Bob");

		CreditCard cc3 = new CreditCard();
		cc3.setCardNumber("341000000000000");
		cc3.setExpirationDate("5/20/2030");
		cc3.setNameOfCardholder("Eve");

		CreditCard cc4 = new CreditCard();
		cc4.setCardNumber("6011000000000000");
		cc4.setExpirationDate("6/20/2030");
		cc4.setNameOfCardholder("Richard");

		ccList.add(cc1);
		ccList.add(cc2);
		ccList.add(cc3);
		ccList.add(cc4);
		
		Parser parser = new Parser("/csv.txt", "\t");
		parser.setStrategy(new CSVParser());
		
		try {
			List<CreditCard> parsedCCList = parser.parse();
			assertEquals(parsedCCList.size(), ccList.size());
			
			Iterator<CreditCard> ccIterator = ccList.iterator();
			CreditCard tmp;
			for(CreditCard cc : parsedCCList) {
				tmp = ccIterator.next();
//				System.out.println(cc.getCardNumber() + ":" +tmp.getCardNumber());
				assertEquals(cc.getCardNumber(), tmp.getCardNumber());
				assertEquals(cc.getExpirationDate(), tmp.getExpirationDate());
				assertEquals(cc.getNameOfCardholder(), tmp.getNameOfCardholder());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
