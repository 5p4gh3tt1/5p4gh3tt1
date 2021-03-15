package uk.ac.ous.i2p.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//Implement the interface to this class, each file will 
public class Students implements ContactTracing {
	
	
	//Create the containers that will hold the maps
	public Map<String, String> map_student;
	public Map<String, String> map_course;
	public Map<String, String> map_email;
	public Map<String, String> map_studentcourse;
	
	//Create the container that will hold the COVID results
	public Map<String, String> covid_result;
	
	public List<String> list1 = new ArrayList<>();
	
	
	//Define the methods in the interface file
	public void loadStudentList(Map<String, String> studentEntry) {
		//Create the map for the object being referenced
		this.map_student = new HashMap<>();
		//put the map defined in the method parameters into the object being referenced
		this.map_student.putAll(studentEntry);
		//System.out.print(studentEntry);
		
	}

	public void loadCourseList(Map<String, String> courseEntry) {
		this.map_course = new HashMap<>();
		this.map_course.putAll(courseEntry);
		//System.out.print(courseEntry);
		
	}

	public void loadEmailList(Map<String, String> emailEntry) {
		this.map_email = new HashMap<>();
		this.map_email.putAll(emailEntry);
		//System.out.print(emailEntry);
		
	}

	public void loadStudentCourseList(Map<String, String> studentCourseEntry) {
		this.map_studentcourse = new HashMap<>();
		this.map_studentcourse.putAll(studentCourseEntry);
		//System.out.print(studentCourseEntry);
		
	}

	public List<String> findMatchingCourses(String inputStudentNumber) {
		String match = map_studentcourse.get(inputStudentNumber);
		if (map_studentcourse.containsKey(inputStudentNumber)) {;
			list1.add(match);			
		}		
		//return as a list, so it can be used in the next method
		return list1;
	}

	public List<String> findMatchingStudents(List<String> matchingCourseList) {
		for (String i : matchingCourseList) {
			map_course.get(i);
			System.out.print(i);
		}
		
		return null;
	}

	public List<String> contactTracing(String inputStudentNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
 }
