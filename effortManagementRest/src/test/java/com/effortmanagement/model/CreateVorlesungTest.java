package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreateVorlesungTest {

	CreateVorlesung cv1;
	/*
	private int userId;
	private String vorlesungName;
	private int aufwand;
	private int geplanterAufwand;
	private double angestrebteNote; 
	private int creditPoints;
	private int semesterId;
	 */
	@Before
	public void setUp() throws Exception {
		cv1 = new CreateVorlesung();
		cv1 = new CreateVorlesung(100, "Mathe", 100, 100, 1.0, 10, 1);
	}

	@Test
	public void testGetVorlesungName() {
		assertEquals("Mathe",cv1.getVorlesungName());
	}

	@Test
	public void testSetVorlesungName() {
		cv1.setVorlesungName("Physik");
		assertEquals("Physik",cv1.getVorlesungName());
	}

	@Test
	public void testGetAufwand() {
		assertEquals(100,cv1.getAufwand());
	}

	@Test
	public void testSetAufwand() {
		cv1.setAufwand(200);
		assertEquals(200,cv1.getAufwand());
	}

	@Test
	public void testGetGeplanterAufwand() {
		assertEquals(100,cv1.getGeplanterAufwand());
	}

	@Test
	public void testSetGeplanterAufwand() {
		cv1.setGeplanterAufwand(200);
		assertEquals(200,cv1.getGeplanterAufwand());
	}

	@Test
	public void testGetAngestrebteNote() {
		assertEquals(1.0,cv1.getAngestrebteNote(),0);
	}

	@Test
	public void testSetAngestrebteNote() {
		cv1.setAngestrebteNote(2.8);
		assertEquals(2.8,cv1.getAngestrebteNote(),0);
	}

	@Test
	public void testGetCreditPoints() {
		assertEquals(10,cv1.getCreditPoints());
	}

	@Test
	public void testSetCreditPoints() {
		cv1.setCreditPoints(5);
		assertEquals(5,cv1.getCreditPoints());
	}

	@Test
	public void testGetSemesterId() {
		assertEquals(1,cv1.getSemesterId());
	}

	@Test
	public void testSetSemesterId() {
		cv1.setSemesterId(2);
		assertEquals(2,cv1.getSemesterId());
	}

	@Test
	public void testGetUserId() {
		assertEquals(100,cv1.getUserId());
	}

	@Test
	public void testSetUserId() {
		cv1.setUserId(101);
		assertEquals(101,cv1.getUserId());
	}

}
