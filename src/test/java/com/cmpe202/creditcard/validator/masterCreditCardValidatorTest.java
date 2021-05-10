package com.cmpe202.creditcard.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class masterCreditCardValidatorTest {

	@Test
	public void testValidate() {
		MasterCreditCard masterCC = new MasterCreditCard();
		assertEquals(true, masterCC.validate("5410000000000000"));
	}
}
