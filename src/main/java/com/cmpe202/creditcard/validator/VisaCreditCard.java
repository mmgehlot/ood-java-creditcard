package com.cmpe202.creditcard.validator;

public class VisaCreditCard extends CreditCard  implements ICCValidator {

	@Override
	public boolean validate(String creditCardNumber) {
		return ((creditCardNumber.charAt(0) == '4') 
				&& ((creditCardNumber.length() == 13) || creditCardNumber.length() == 16));
	}

}
