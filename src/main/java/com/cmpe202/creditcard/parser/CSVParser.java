package com.cmpe202.creditcard.parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cmpe202.creditcard.validator.CreditCard;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class CSVParser implements IParse {
	private String separator;
	private String path;
	
	public static Reader getReader(String relativePath) {
		try {
//			System.out.println(relativePath);
			return new InputStreamReader(CSVParser.class.getResourceAsStream(relativePath), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
			throw new IllegalStateException("Unable to read input", e);
		}catch (Exception e) {
			System.out.println(e.toString());
			throw new IllegalStateException("Unable to read input", e);
		}
		
	}
	
	public CSVParser setPath(String path) {
		this.path = path;
		return this;
	}

	public CSVParser setSeparator(String separator) {
		this.separator = separator;
		return this;
	}

	@Override
	public List<CreditCard> parse() {
		CsvParserSettings settings = new CsvParserSettings();
//		settings.getFormat().setLineSeparator(separator);
		settings.setHeaderExtractionEnabled(true);
		
		CsvParser parser = new CsvParser(settings);
		List<Record> allRecords = parser.parseAllRecords(getReader(path));
		
		List<CreditCard> ccList = new ArrayList<CreditCard>();
		
		for(Record record : allRecords){
			
			CreditCard cc = new CreditCard();
//			System.out.println(record.getString(0));
//			System.out.println(record.getString(1));
//			System.out.println(record.getString(2));
//			
//			cc.setCcNumber(record.getString(0));
//		    cc.setExpDate(record.getString(1));
//		    cc.setNameOnCard(record.getString(2));

		    
		    String[] out = record.getString(0).split("\t");		    
//		    System.out.println(out[0] + out[1] + out[2]);
			cc.setCardNumber(out[0].trim());
		    cc.setExpirationDate(out[1].trim());
		    cc.setNameOfCardholder(out[2].trim());

		    
//		    System.out.println(cc.getCcNumber());
		    
		    ccList.add(cc);
		}
		
//		for(String[] row : parser.iterate(getReader(path))){
//		    System.out.println(Arrays.toString(row));
//		}
		return ccList;
	}

	@Override
	public void write(List<String> result, String path) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write("CardNumber, CardType, Status\n");
			for(String row : result) {
				row += "\n";
				writer.write(row);	
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
