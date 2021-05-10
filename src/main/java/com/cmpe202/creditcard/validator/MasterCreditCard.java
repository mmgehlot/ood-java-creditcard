package com.cmpe202.creditcard.validator;

public class MasterCreditCard extends CreditCard implements ICCValidator{

	@Override
	public boolean validate(String creditCardNumber) {
		int x = Integer.parseInt(String.valueOf(creditCardNumber.charAt(1)));
		boolean inRange = (x>=1 && x<=5) ? true: false;
		
		return ((creditCardNumber.charAt(0) == '5') 
				&& inRange
				&& (creditCardNumber.length() == 16));

	}

}
