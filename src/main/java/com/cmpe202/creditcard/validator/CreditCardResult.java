package com.cmpe202.creditcard.validator;

public class CreditCardResult {
	private	String cardNumber;
	private String cardType;
	private String status;

	public CreditCardResult(String cardNumber, String cardType, String status) {
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.status = status;
	}

}
