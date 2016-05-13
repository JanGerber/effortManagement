package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VorlesungTest {

	Vorlesung v1;
	
	@Before
	public void setUp() throws Exception {
		v1 = new Vorlesung();
		v1 = new Vorlesung(1, "Vorlesung1", 100, 100, 1, 1, 100, 10, 1, 100);
	}

	@Test
	public void testGetVorlesungId() {
		assertEquals(1,v1.getVorlesungId());
	}

	@Test
	public void testSetVorlesungId() {
		v1.setVorlesungId(2);
		assertEquals(2,v1.getVorlesungId());
	}

	@Test
	public void testGetVorlesungName() {
		assertEquals("Vorlesung1",v1.getVorlesungName());
	}

	@Test
	public void testSetVorlesungName() {
		v1.setVorlesungName("Vorlesung2");
		assertEquals("Vorlesung2",v1.getVorlesungName());
	}

	@Test
	public void testGetAufwand() {
		assertEquals(100,v1.getAufwand());
	}

	@Test
	public void testSetAufwand() {
		v1.setAufwand(200);
		assertEquals(200,v1.getAufwand());
	}

	@Test
	public void testGetGeplanterAufwand() {
		assertEquals(100,v1.getGeplanterAufwand());
	}

	@Test
	public void testSetGeplanterAufwand() {
		v1.setGeplanterAufwand(200);
		assertEquals(200,v1.getGeplanterAufwand());
	}

	@Test
	public void testGetAngestrebteNote() {
		assertEquals(1.0,v1.getAngestrebteNote(),0);
	}

	@Test
	public void testSetAngestrebteNote() {
		v1.setAngestrebteNote(2.5);
		assertEquals(2.5,v1.getAngestrebteNote(),0);
	}

	@Test
	public void testGetEndNote() {
		assertEquals(1.0,v1.getEndNote(),0);
	}

	@Test
	public void testSetEndNote() {
		v1.setEndNote(2.5);
		assertEquals(2.5,v1.getEndNote(),0);
	}

	@Test
	public void testGetLernzeit() {
		assertEquals(100,v1.getLernzeit(),0);
	}

	@Test
	public void testSetLernzeit() {
		v1.setLernzeit(200.5);
		assertEquals(200.5,v1.getLernzeit(),0);
	}

	@Test
	public void testGetCreditPoints() {
		assertEquals(10,v1.getCreditPoints());
	}

	@Test
	public void testSetCreditPoints() {
		v1.setCreditPoints(5);
		assertEquals(5,v1.getCreditPoints());
	}

	@Test
	public void testGetSemesterId() {
		assertEquals(1,v1.getSemesterId());
	}

	@Test
	public void testSetSemesterId() {
		v1.setSemesterId(2);
		assertEquals(2,v1.getSemesterId());
	}

	@Test
	public void testGetUserId() {
		assertEquals(100,v1.getUserId());
	}

	@Test
	public void testSetUserId() {
		v1.setUserId(200);
		assertEquals(200,v1.getUserId());
	}

}
