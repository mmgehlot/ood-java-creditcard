package com.cmpe202.creditcard.parser;

import java.util.List;

import com.cmpe202.creditcard.validator.CCValidator;
import com.cmpe202.creditcard.validator.CreditCard;

public interface IParse {
	public List<CreditCard> parse();
	public void write(List<String> result, String path);
	public IParse setPath(String path);
	public IParse setSeparator(String separator);
}
