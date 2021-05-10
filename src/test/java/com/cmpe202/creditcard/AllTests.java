package com.cmpe202.creditcard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cmpe202.creditcard.parser.csvParserTest;
import com.cmpe202.creditcard.parser.jsonParserTest;
import com.cmpe202.creditcard.parser.xmlParserTest;
import com.cmpe202.creditcard.validator.amexCreditCardValidatorTest;
import com.cmpe202.creditcard.validator.discoverCreditCardValidatorTest;
import com.cmpe202.creditcard.validator.masterCreditCardValidatorTest;
import com.cmpe202.creditcard.validator.visaCreditCardValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({
	amexCreditCardValidatorTest.class,
	visaCreditCardValidatorTest.class,
	masterCreditCardValidatorTest.class,
	discoverCreditCardValidatorTest.class,
	csvParserTest.class,
	jsonParserTest.class,
	xmlParserTest.class
})
public class AllTests {

}
