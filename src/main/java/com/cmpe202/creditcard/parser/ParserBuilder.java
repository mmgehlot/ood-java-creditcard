package com.cmpe202.creditcard.parser;

public class ParserBuilder {
	
	private CSVParser csvParser;
	private String type;
	
	public ParserBuilder() {
		
	}
	
	public ParserBuilder setParser(String type, IParse parser) {
		switch (type){
		case "csv":
			this.csvParser = (CSVParser) parser;
			this.type = type;
		}
		return this;
	}
	
	public ParserBuilder setDelimeter(char delimeter) {
		
		return this;
	}
	
	public IParse Build() {
		switch(this.type) {
		case "csv":
			return new CSVParser();
		default:
			return new CSVParser();
		}
	}

}
