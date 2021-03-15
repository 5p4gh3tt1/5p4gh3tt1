package uk.ac.ous.i2p.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Implement the interface to this class, each file will 
public class Students implements ContactTracing {
	
	
	//Create the containers that will hold the maps
	public Map<String, String> map_student;
	public Map<String, String> map_course;
	public Map<String, String> map_email;
	public Map<String, String> map_studentcourse;
	
	//Create the lists that will hold the matching entries 
	public List<String> list_matchingCourses = new ArrayList<>();
	public List<String> list_studentCourses = new ArrayList<>();
	public List<String> list_email = new ArrayList<>();
	
	
	//Define the methods in the interface file
	public void loadStudentList(Map<String, String> studentEntry) {
		//Create the map for the object being referenced
		this.map_student = new HashMap<>();
		//put the map defined in the method parameters into the object being referenced
		this.map_student.putAll(studentEntry);
		
	}

	public void loadCourseList(Map<String, String> courseEntry) {
		this.map_course = new HashMap<>();
		this.map_course.putAll(courseEntry);
		
	}

	public void loadEmailList(Map<String, String> emailEntry) {
		this.map_email = new HashMap<>();
		this.map_email.putAll(emailEntry);
		
	}

	public void loadStudentCourseList(Map<String, String> studentCourseEntry) {
		this.map_studentcourse = new HashMap<>();
		this.map_studentcourse.putAll(studentCourseEntry);
		
	}

	public List<String> findMatchingCourses(String inputStudentNumber) {
		//List type must be string, so put matches into a String variable
		String match = map_studentcourse.get(inputStudentNumber);
		if (map_studentcourse.containsKey(inputStudentNumber)) {;
			list_matchingCourses.add(match);			
		}		
		//return as a list, so it can be used in the next method
		return list_matchingCourses;
	}

	public List<String> findMatchingStudents(List<String> matchingCourseList) {
		for (String i : matchingCourseList) {
			if (map_studentcourse.containsValue(i)) {
				for (Map.Entry<String, String> entry : map_studentcourse.entrySet()) {
					if (entry.getValue()==i) {						
						list_studentCourses.add(entry.getKey());
					}
				}
			}
		}
		return list_studentCourses;
	}

	public List<String> contactTracing(String inputStudentNumber) {
		List <String> courses = findMatchingCourses(inputStudentNumber);
		List <String> students = findMatchingStudents(courses);
		
		for (String student : students) {
			if (map_email.containsKey(student)) {
				list_email.add(map_email.get(student));
			}
		}
		return list_email;
	}
	
 }
