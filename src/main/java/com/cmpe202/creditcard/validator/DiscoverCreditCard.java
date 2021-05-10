package com.cmpe202.creditcard.validator;

public class DiscoverCreditCard extends CreditCard implements ICCValidator{

	@Override
	public boolean validate(String creditCardNumber) {
		return (creditCardNumber.substring(0, 4).equals("6011")) 
				&& (creditCardNumber.length() == 16);
	}

}
