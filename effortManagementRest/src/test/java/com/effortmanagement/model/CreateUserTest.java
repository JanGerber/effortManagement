package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreateUserTest {

	CreateUser cu1;
	
	@Before
	public void setUp() throws Exception { //String userName, String passwort, String email, String hochschule
		cu1 = new CreateUser();
		cu1 = new CreateUser("Peter","geheim","peter@gmail.com", "DHBW");
	}

	@Test
	public void testGetUserName() {
		assertEquals("Peter", cu1.getUserName());
	}

	@Test
	public void testSetUserName() {
		cu1.setUserName("Horst");
		assertEquals("Horst", cu1.getUserName());
	}

	@Test
	public void testGetPasswort() {
		assertEquals("geheim",cu1.getPasswort());
	}

	@Test
	public void testSetPasswort() {
		cu1.setPasswort("strenggeheim");
		assertEquals("strenggeheim",cu1.getPasswort());
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
