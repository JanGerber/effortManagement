package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginUserTest {

	LoginUser lu1;
	
	@Before
	public void setUp() throws Exception {
		lu1 = new LoginUser();
		lu1 = new LoginUser("Peter", "geheim");
	}

	@Test
	public void testGetUserName() {
		assertEquals("Peter",lu1.getUserName());
	}

	@Test
	public void testSetUserName() {
		lu1.setUserName("Harald");
		assertEquals("Harald",lu1.getUserName());
	}

	@Test
	public void testGetPasswort() {
		assertEquals("geheim",lu1.getPasswort());
	}

	@Test
	public void testSetPasswort() {
		lu1.setPasswort("strenggeheim");
		assertEquals("strenggeheim",lu1.getPasswort());
	}

}
