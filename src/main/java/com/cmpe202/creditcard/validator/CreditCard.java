package com.cmpe202.creditcard.validator;

public class CreditCard {
	protected String ccNumber;
	protected String expDate;
	
	protected String CardNumber;
	protected String ExpirationDate;
	protected String NameOfCardholder;	
	
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	public String getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}
	public String getNameOfCardholder() {
		return NameOfCardholder;
	}
	public void setNameOfCardholder(String nameOfCardholder) {
		NameOfCardholder = nameOfCardholder;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	protected String nameOnCard;
}
