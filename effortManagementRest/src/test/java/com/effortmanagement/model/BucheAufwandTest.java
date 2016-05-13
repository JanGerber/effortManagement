package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BucheAufwandTest {
		
	@Test
	public void testGetVorlesungId() {
		BucheAufwand bucheAufwand = new BucheAufwand();
		bucheAufwand.setVorlesungId(12);
		assertEquals(12, bucheAufwand.getVorlesungId());
	}

	@Test
	public void testSetVorlesungId() {
		BucheAufwand bucheAufwand = new BucheAufwand();
		bucheAufwand.setVorlesungId(12);
		assertTrue(bucheAufwand.getVorlesungId() == 12);
	}

	@Test
	public void testGetZeit() {
		BucheAufwand bucheAufwand = new BucheAufwand();
		bucheAufwand.setZeit(0);
		assertEquals(0, bucheAufwand.getZeit(),0);
	}

	@Test
	public void testSetZeit() {
		BucheAufwand bucheAufwand = new BucheAufwand();
		bucheAufwand.setZeit(0);
		assertTrue(bucheAufwand.getZeit() == 0);
	}

}
