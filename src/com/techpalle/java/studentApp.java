package com.techpalle.java;

import com.techaplle.jdbc.*;

public class studentApp {

	public static void main(String[] args) {
    //here First write this code
		//create student table
		//StudentService.creating(); after create table put into comment lines
		
	//Insert two student details into table
//		StudentService.inserting("kishore", "java","k!gmail.com");
//		StudentService.inserting("ravi", "java","r@gmail.com");  after insert the data,put in the comments otherwise get exception
		
		//delete second row from the table
	//	StudentService.deleting(2);   after delete put into comments for other operation update
		
		//update kishore mail and sub
	//	StudentService.updating(1,"kishore@gmail.com","java full stack");
		
		//Display the all student data
		StudentService.reading();
	}

}
