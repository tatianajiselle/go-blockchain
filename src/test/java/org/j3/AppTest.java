package org.j3;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest{

	private Block genesisBlock;

	private static boolean isValidNewBlock(Block newBlock, Block previousBlock){
		if(previousBlock.index + 1 != newBlock.index){
			return false;
		}

		if(!newBlock.previousHash.equals(previousBlock.hash)){
			return false;
		}
		return true;
	}

	@BeforeMethod
	public void setUp(){
		genesisBlock = new Block(
				0, "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7", null, 1465154705, "my genesis" +
				" " +
				"block!!"
		);
	}

	@Test
	public void runApp(){

		List<Block> blockChain = new ArrayList<>();

		blockChain.add(genesisBlock);
	}

	@Test
	public void new_block_is_invalid_if_new_index_is_not_one_greater(){
		Block newBlock = new Block(666, "hash2", genesisBlock.previousHash, 1234, "blah");

		assertFalse(AppTest.isValidNewBlock(newBlock, genesisBlock));
	}

	@Test
	public void invalid_if_previous_hash_does_not_match_hash(){
		Block newBlock = new Block(1, "hash2", "NOT PREVIOUS HASH", 1234, "blah");

		assertFalse(AppTest.isValidNewBlock(newBlock, genesisBlock));
	}
}
