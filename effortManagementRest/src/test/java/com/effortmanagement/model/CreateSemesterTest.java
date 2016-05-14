package com.effortmanagement.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreateSemesterTest {

	CreateSemester cs1;
	
	@Before
	public void setUp() throws Exception { //int semesterId, String semesterName, String startDatum, String endDatum, int user_Id
		cs1 = new CreateSemester();
		cs1 = new CreateSemester(1,"Sem1","01.01.01","01.01.02",100);
	}

	@Test
	public void testGetSemesterName() {
		assertEquals("Sem1",cs1.getSemesterName());
	}

	@Test
	public void testSetSemesterName() {
		cs1.setSemesterName("Sem2");
		assertEquals("Sem2",cs1.getSemesterName());
	}

	@Test
	public void testGetStartDatum() {
		assertEquals("01.01.01",cs1.getStartDatum());
	}

	@Test
	public void testSetStartDatum() {
		cs1.setStartDatum("02.02.02");
		assertEquals("02.02.02",cs1.getStartDatum());
	}

	@Test
	public void testGetEndDatum() {
		assertEquals("01.01.02",cs1.getEndDatum());
	}

	@Test
	public void testSetEndDatum() {
		cs1.setEndDatum("03.03.03");
		assertEquals("03.03.03",cs1.getEndDatum());
	}

	@Test
	public void testGetUser_Id() {
		assertEquals(100,cs1.getUser_Id());
	}

	@Test
	public void testSetUser_Id() {
		cs1.setUser_Id(200);
		assertEquals(200,cs1.getUser_Id());
	}

}
