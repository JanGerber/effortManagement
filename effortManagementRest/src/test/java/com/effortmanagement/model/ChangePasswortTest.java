package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChangePasswortTest {

	ChangePasswort pw1;
	
	@Before
	public void SetUp() throws Exception {
		pw1 = new ChangePasswort(); //default Constructor
		pw1 = new ChangePasswort("a","b"); //ChangePasswort(oldPW,newPW)
	}

	@Test
	public void testGetOldPasswort() {
		assertEquals("a",pw1.getOldPasswort());
	}

	@Test
	public void testSetOldPasswort() {
		pw1.setOldPasswort("A");
		assertEquals("A",pw1.getOldPasswort());
	}

	@Test
	public void testGetNewPasswort() {
		assertEquals("b",pw1.getNewPasswort());
	}

	@Test
	public void testSetNewPasswort() {
		pw1.setNewPasswort("B");
		assertEquals("B",pw1.getNewPasswort());
	}

}
