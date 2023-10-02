package com.smallworld.simulator.test;

import org.junit.Assert;
import org.junit.Test;

import com.smallworld.simulator.util.InvertPhraseUtil;

public class InvertedPhraseUtilTest {
	
	private InvertPhraseUtil invertedPhraseUtil= new InvertPhraseUtil();
	
	@Test
	public void invertePhraseObjNotNull() {
		Assert.assertNotNull(invertedPhraseUtil);
	}
	
	@Test
	public void invertStrTest1() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr("Good afternoon"),"afternoon Good");
	}
	
	@Test
	public void invertStrTest2() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr("Hello, how are you?"),"?you are how, Hello");
	}
	
	
	@Test
	public void invertStrTest3() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr("Are you twenty-one years old?"),"?old years twenty-one you Are");
	}
	
	@Test
	public void invertStr2Test1() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr2("Good afternoon"),"afternoon Good");
	}
	
	@Test
	public void invertStr2Test2() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr2("Hello, how are you?"),"?you are how, Hello");
	}
	@Test
	public void invertStr2Test3() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr2("Are you twenty-one years old?"),"?old years twenty-one you Are");
	}
	
	@Test
	public void invertStr2Test4() {
	 Assert.assertEquals(invertedPhraseUtil.invertStr2("Are you twenty-one, years old?"),"?old years, twenty-one you Are");
	}

	@Test
	public void traverseEachWordElementTest() {
	 Assert.assertEquals("afternoon Good",invertedPhraseUtil.traverseEachWordElement("Good afternoon".trim().split(" ")));
	}
	
	@Test
	public void invalidOutPut() {
	 Assert.assertNotSame(invertedPhraseUtil.invertStr2("Good afternoon"),"afternoon Good!");
	}
	
	
}
