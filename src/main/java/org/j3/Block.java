package org.j3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block{

	public int index;
	public String hash;
	public String previousHash;
	public int timestamp;
	public String data;

	public Block(int index, String hash, String previousHash, int timestamp, String data){
		this.index = index;
		this.hash = hash;
		this.previousHash = previousHash;
		this.timestamp = timestamp;
		this.data = data;
	}

	public static String calculateHash(int index, String previousHash, int timestamp, String data) throws NoSuchAlgorithmException{
		return new String(MessageDigest.getInstance("SHA-256").digest((index + previousHash + timestamp + data).getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
	}
}
