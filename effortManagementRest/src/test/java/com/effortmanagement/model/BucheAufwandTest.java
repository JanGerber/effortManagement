package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BucheAufwandTest {
	
	BucheAufwand bucheAufwand1;
	
	@Before
	public void setUp() throws Exception { //Erstellt ein Objekt der zu testenden Klasse und setzt Argumente
		bucheAufwand1 = new BucheAufwand();
		bucheAufwand1.setVorlesungId(1);
		bucheAufwand1.setZeit(1);
		
	}
	
	@Test
	public void testGetVorlesungId() {
		assertEquals(1, bucheAufwand1.getVorlesungId());
	}

	@Test
	public void testSetVorlesungId() {
		bucheAufwand1.setVorlesungId(2);
		assertEquals(2,bucheAufwand1.getVorlesungId());
	}

	@Test
	public void testGetZeit() {
		assertEquals(1, bucheAufwand1.getZeit(),0);//Zweite 0 steht für die Abweichung, muss bei Gleitkommazahlen angegeben werden 
	}

	@Test
	public void testSetZeit() {
		bucheAufwand1.setZeit(2);
		assertEquals(2,bucheAufwand1.getZeit(),0);
	}

}
