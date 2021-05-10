package com.cmpe202.creditcard.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class amexCreditCardValidatorTest {

	@Test
	public void testValidate() {
		AmexCreditCard amexCC = new AmexCreditCard();
		assertEquals(true, amexCC.validate("341000000000000"));
	}
}
