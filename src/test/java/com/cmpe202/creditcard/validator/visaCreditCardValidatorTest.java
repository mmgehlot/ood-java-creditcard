package com.cmpe202.creditcard.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class visaCreditCardValidatorTest {

	@Test
	public void testValidate() {
		VisaCreditCard visaCC = new VisaCreditCard();
		assertEquals(true, visaCC.validate("4120000000000"));
	}
}
