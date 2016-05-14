package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VorlesungAufwandTest {

	VorlesungAufwand va1;
	
	@Before
	public void setUp() throws Exception {
		va1 = new VorlesungAufwand();
		va1 = new VorlesungAufwand(1, 1, "Vorlesung1", 100, 100, 1, 1, 100, 10, 1, 100);
	}

	@Test
	public void testGetAufwandNutzen() {
		assertEquals(1,va1.getAufwandNutzen());
	}

	@Test
	public void testSetAufwandNutzen() {
		va1.setAufwandNutzen(2);
		assertEquals(2,va1.getAufwandNutzen());
	}

	@Test
	public void testGetVorlesungId() {
		assertEquals(1,va1.getVorlesungId());
	}

	@Test
	public void testSetVorlesungId() {
		va1.setVorlesungId(2);
		assertEquals(2,va1.getVorlesungId());
	}

	@Test
	public void testGetVorlesungName() {
		assertEquals("Vorlesung1",va1.getVorlesungName());
	}

	@Test
	public void testSetVorlesungName() {
		va1.setVorlesungName("Vorlesung2");
		assertEquals("Vorlesung2",va1.getVorlesungName());
	}

	@Test
	public void testGetAufwand() {
		assertEquals(100,va1.getAufwand());
	}

	@Test
	public void testSetAufwand() {
		va1.setAufwand(200);
		assertEquals(200,va1.getAufwand());
	}

	@Test
	public void testGetGeplanterAufwand() {
		assertEquals(100,va1.getGeplanterAufwand());
	}

	@Test
	public void testSetGeplanterAufwand() {
		va1.setGeplanterAufwand(200);
		assertEquals(200,va1.getGeplanterAufwand());
	}

	@Test
	public void testGetAngestrebteNote() {
		assertEquals(1.0,va1.getAngestrebteNote(),0);
	}

	@Test
	public void testSetAngestrebteNote() {
		va1.setAngestrebteNote(2.5);
		assertEquals(2.5,va1.getAngestrebteNote(),0);
	}

	@Test
	public void testGetEndNote() {
		assertEquals(1.0,va1.getEndNote(),0);
	}

	@Test
	public void testSetEndNote() {
		va1.setEndNote(2.5);
		assertEquals(2.5,va1.getEndNote(),0);
	}

	@Test
	public void testGetLernzeit() {
		assertEquals(100,va1.getLernzeit(),0);
	}

	@Test
	public void testSetLernzeit() {
		va1.setLernzeit(200.5);
		assertEquals(200.5,va1.getLernzeit(),0);
	}

	@Test
	public void testGetCreditPoints() {
		assertEquals(10,va1.getCreditPoints());
	}

	@Test
	public void testSetCreditPoints() {
		va1.setCreditPoints(5);
		assertEquals(5,va1.getCreditPoints());
	}

	@Test
	public void testGetSemesterId() {
		assertEquals(1,va1.getSemesterId());
	}

	@Test
	public void testSetSemesterId() {
		va1.setSemesterId(2);
		assertEquals(2,va1.getSemesterId());
	}

	@Test
	public void testGetUserId() {
		assertEquals(100,va1.getUserId());
	}

	@Test
	public void testSetUserId() {
		va1.setUserId(101);
		assertEquals(101,va1.getUserId());
	}

}
