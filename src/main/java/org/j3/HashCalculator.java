package org.j3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCalculator{
	public static String calculateHash(int index, String previousHash, int timestamp, String data) throws NoSuchAlgorithmException{
		return new String(MessageDigest.getInstance("SHA-256").digest((index + previousHash + timestamp + data).getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
	}
}
