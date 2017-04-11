package test.optus.service.impl;

import org.junit.Assert;
import org.junit.Test;

import test.optus.service.StringHandlingService;

public class StringhandlingServiceTest {

	StringHandlingService handlService = new StringHandlingServiceImpl();
	
	@Test
	public void test() {
		String result = handlService.truncateString("1234567890", 5);
		Assert.assertEquals(result, "1234567890");
		
		result = handlService.truncateString("123456789012345678901234567890", 31);
		Assert.assertEquals(result, "123456789012345678901234567890");
		result = handlService.truncateString("123456789012345678901234567890", 25);
		Assert.assertTrue(result.length() == 25);
		Assert.assertEquals(result, "12 ... (truncated) ... 90");
	}
}
