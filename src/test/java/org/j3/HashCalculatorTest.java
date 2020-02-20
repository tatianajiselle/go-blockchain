package org.j3;

import java.security.NoSuchAlgorithmException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashCalculatorTest{

	@Test
	public void can_calculate_hash_yo() throws NoSuchAlgorithmException{
		String hash = HashCalculator.calculateHash(1, "prev", 666, "hello world");
		Assert.assertNotNull(hash);
	}

}
