package com.cmpe202.creditcard.validator;

public class AmexCreditCard extends CreditCard  implements ICCValidator {
	
	private static final int AmexCCNumberLength = 16;

	@Override
	public boolean validate(String creditCardNumber) {
		return ((creditCardNumber.charAt(0) == '3') 
				&& ((creditCardNumber.charAt(1) == '4' ) || (creditCardNumber.charAt(1) == '7'))
				&& (creditCardNumber.length() == 15));
	}

}