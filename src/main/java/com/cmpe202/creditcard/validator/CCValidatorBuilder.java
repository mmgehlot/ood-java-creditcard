package com.cmpe202.creditcard.validator;

import java.util.HashMap;

public class CCValidatorBuilder {
	private CCValidator ccValidator;
	
	public CCValidatorBuilder() {
		ccValidator = new CCValidator();
	}

	public CCValidatorBuilder setSubscriber(String ccType, ICCValidator validator) {
		this.ccValidator.subscribe(ccType, validator);
		return this;
	}
	
	public CCValidator Build() {
		return this.ccValidator;
	}
}
