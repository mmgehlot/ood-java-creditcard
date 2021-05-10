package com.cmpe202.creditcard.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class discoverCreditCardValidatorTest {

	@Test
	public void testValidate() {
		DiscoverCreditCard discoverCC = new DiscoverCreditCard();
		assertEquals(true, discoverCC.validate("6011000000000000"));
	}
}
