package com.coderscampus.assignmen4.sort;

public class STAT extends Sorted{

//	public STAT(String id, String name, String course, int grade) {
//		super(id, name, course, grade);
//		// TODO Auto-generated constructor stub
//	}
	public STAT(String id, String name, int grade) {
        // Call the Sorted constructor with hardcoded "STAT" for the course
        new Sorted(id, name, "STAT", grade);
    }
}

