package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User u1;
	
	@Before
	public void setUp() throws Exception {
		u1 = new User();
		u1 = new User("Peter", "geheim", "peter@gmail.com", "DHBW");
	}

	/* UserID wird im Konstruktor nicht gesetzt...!?
	@Test
	public void testGetUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserId() {
		fail("Not yet implemented");
	}
	*/

	@Test
	public void testGetUserName() {
		assertEquals("Peter",u1.getUserName());
	}

	@Test
	public void testSetUserName() {
		u1.setUserName("Horst");
		assertEquals("Horst",u1.getUserName());
	}

	@Test
	public void testGetPasswort() {
		assertEquals("geheim",u1.getPasswort());
	}

	@Test
	public void testSetPasswort() {
		u1.setPasswort("strenggeheim");
		assertEquals("strenggeheim",u1.getPasswort());
	}

	@Test
	public void testGetHochschule() {
		assertEquals("DHBW",u1.getHochschule());
	}

	@Test
	public void testSetHochschule() {
		u1.setHochschule("DHNRW");
		assertEquals("DHNRW",u1.getHochschule());
	}

	@Test
	public void testGetEmail() {
		assertEquals("peter@gmail.com",u1.getEmail());
	}

	@Test
	public void testSetEmail() {
		u1.setEmail("peter@web.de");
		assertEquals("peter@web.de",u1.getEmail());
	}

}
