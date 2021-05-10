package com.cmpe202.creditcard.parser;

import java.util.List;

import com.cmpe202.creditcard.validator.CreditCard;

public class Parser {
	
	private IParse iParse;
	private String path;
	private String separator;
	
	public Parser(String path, String separator) {
		this.path = path;
		this.separator = separator;
	}
	
	public void setStrategy(IParse iParse) {
			this.iParse = iParse;
			this.iParse.setPath(this.path);
			this.iParse.setSeparator(this.separator);
	}
	
	public List<CreditCard> parse() throws Exception {
		if (this.path == null) {
			throw new Exception("Please provide file path !!!");
		}
		return this.iParse.parse();
	}
	
	public void write(List<String> results, String path) {
		this.iParse.write(results, path);
	}

}
