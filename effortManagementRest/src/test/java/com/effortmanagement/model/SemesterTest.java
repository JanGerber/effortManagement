package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SemesterTest {

	Semester s1;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Semester();
		s1 = new Semester(1, "Sem1", "01.01.01", "01.01.02", 100);
	}

	@Test
	public void testGetSemesterId() {
		assertEquals(1,s1.getSemesterId());
	}

	@Test
	public void testSetSemesterId() {
		s1.setSemesterId(2);
		assertEquals(2,s1.getSemesterId());
	}

	@Test
	public void testGetSemesterName() {
		assertEquals("Sem1",s1.getSemesterName());
	}

	@Test
	public void testSetSemesterName() {
		s1.setSemesterName("Sem2");
		assertEquals("Sem2",s1.getSemesterName());
	}

	@Test
	public void testGetStartDatum() {
		assertEquals("01.01.01",s1.getStartDatum());
	}

	@Test
	public void testSetStartDatum() {
		s1.setStartDatum("02.02.02");
		assertEquals("02.02.02",s1.getStartDatum());
	}

	@Test
	public void testGetEndDatum() {
		assertEquals("01.01.02",s1.getEndDatum());
	}

	@Test
	public void testSetEndDatum() {
		s1.setEndDatum("03.03.03");
		assertEquals("03.03.03",s1.getEndDatum());
	}

	@Test
	public void testGetUser_Id() {
		assertEquals(100,s1.getUser_Id());
	}

	@Test
	public void testSetUser_Id() {
		s1.setUser_Id(101);
		assertEquals(101,s1.getUser_Id());	
	}

}
