package com.cmpe202.creditcard.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.cmpe202.creditcard.validator.CCValidator;
import com.cmpe202.creditcard.validator.CreditCard;
import com.cmpe202.creditcard.validator.CreditCardResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.reflect.TypeToken;



public class JSONParser implements IParse {
	private String path;
	
	Gson gson;
	
	public JSONParser() {
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
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
	

	@Override
	public List<CreditCard> parse() {
		Type ccListType = new TypeToken<ArrayList<CreditCard>>(){}.getType();
		ArrayList<CreditCard> ccList = gson.fromJson(getReader(path), ccListType);
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
	public void write(List<String> results, String path) {
		// TODO Auto-generated method stub
		
		List<CreditCardResult> recList = new ArrayList<CreditCardResult>();
		CreditCardResult result;
		FileWriter file;
		try {
			file = new FileWriter(path);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			
			for (String row : results) {
				String[] out = row.split(",");
				result = new CreditCardResult(out[0], out[1], out[2]);
				recList.add(result);
			}
			gson.toJson(recList, file);
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
