package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChangeUserTest {

	ChangeUser cu1;
	
	@Before
	public void setUp() throws Exception {
		cu1 = new ChangeUser();
		cu1 = new ChangeUser("Peter","peter@gmail.com","DHBW"); //String userName, String eMail, String hochschule
	}

	@Test
	public void testGetUserName() {
		assertEquals("Peter",cu1.getUserName());
	}

	@Test
	public void testSetUserName() {
		cu1.setUserName("Rolf");
		assertEquals("Rolf",cu1.getUserName());
	}

	@Test
	public void testGetHochschule() {
		assertEquals("DHBW",cu1.getHochschule());
	}

	@Test
	public void testSetHochschule() {
		cu1.setHochschule("DHNRW");
		assertEquals("DHNRW",cu1.getHochschule());
	}

	@Test
	public void testGetEmail() {
		assertEquals("peter@gmail.com",cu1.getEmail());
	}

	@Test
	public void testSetEmail() {
		cu1.setEmail("peter@web.de");
		assertEquals("peter@web.de",cu1.getEmail());
	}
}
