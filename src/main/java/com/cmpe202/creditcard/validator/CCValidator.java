package com.cmpe202.creditcard.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.logging.Logger;

public class CCValidator {
	private HashMap<String, ICCValidator> subscribers;
	Logger logger = Logger.getGlobal();
	
	public CCValidator() {
		this.subscribers = new HashMap<String, ICCValidator>();
	}
	
	public CCValidator(HashMap<String, ICCValidator> subscribers) {
		this.subscribers = subscribers;
	}

	public void subscribe(String ccType, ICCValidator creditCard) {
		this.subscribers.put(ccType, creditCard);
		logger.info("Subscribed credit card type: " + ccType + "\n");
	}
	
	public boolean unsubscribe(String ccType) {
		if (subscribers.containsKey(ccType)) {
			subscribers.remove(ccType);
			logger.info("Unsubscribed credit card type: " + ccType);
			return true;
		}
		
		logger.info("Credit card type '" + ccType + "' not subscribed !!!");
		return false;
	}
	
	public List<String> validate(List<CreditCard> ccList){
		List<String> result = new ArrayList<String>();
		for(CreditCard cc: ccList) {
			String record = this.notify(cc.getCardNumber());
			result.add(record);
		}
		return result;
	}
	
	public String notify(String ccNumber) {
		
		for(Entry<String, ICCValidator> cc : subscribers.entrySet()) {
			boolean found = cc.getValue().validate(ccNumber.trim());
			String record = ccNumber.trim() + "," + cc.getKey() + ",invalid";
			if(found) {
				record = ccNumber.trim() + "," + cc.getKey() + ",valid";
				return record;
			}
		}
		
		return ccNumber + ",unknown,invalid";
		
	}
}
