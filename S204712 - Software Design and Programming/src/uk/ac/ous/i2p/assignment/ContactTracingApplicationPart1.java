package uk.ac.ous.i2p.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ContactTracingApplicationPart1 {
	public static void main(String[] args) {
		/*Initial phase of the script where the data is hard coded and the Maps are created as
		objects with the type of the interface */
		
		//Create the first map of the students 
		Map<String, String> studentNameNum = new HashMap<>();
		//Add the data to the map
		studentNameNum.put("Clint Eastwood", "S101");
		studentNameNum.put("Jamie Foxx", "S102");
		studentNameNum.put("Olivia Wilde", "S103");
		studentNameNum.put("Bob Geldoff", "S104");
		studentNameNum.put("George Clooney", "S105");
		
		//Create the second map of the student emails
		Map<String, String> studentNumEmail = new HashMap<>();
		studentNumEmail.put("S101", "abc@uos.ac.uk");
		studentNumEmail.put("S102", "bvbv@uos.ac.uk");
		studentNumEmail.put("S103", "xyz@uos.ac.uk");
		studentNumEmail.put("S104", "klm@uos.ac.uk");
		studentNumEmail.put("S105", "yttyty@uos.ac.uk");
		
		//Create the third map of the courses at the university
		Map<String, String> courseNameID = new HashMap<>();
		courseNameID.put("Software Engineering", "SE01");
		courseNameID.put("Network Engineering", "NE02");
		courseNameID.put("Cyber Security", "CS03");
		
		//Create the Maps identifying which student is on which course
		Map<String, String> studentCourseIDNE02 = new HashMap<>();
		studentCourseIDNE02.put("S101", "NE02");
		studentCourseIDNE02.put("S103", "NE02");
		studentCourseIDNE02.put("S105", "NE02");
		
		Map <String, String> studentCourseIDSE01 = new HashMap<>();
		studentCourseIDSE01.put("S102", "SE01");
		studentCourseIDSE01.put("S103", "SE01");
		studentCourseIDSE01.put("S104", "SE01");
		
		Map <String, String> studentCourseIDCS03 = new HashMap<>();
		studentCourseIDCS03.put("S101", "CS03");
		studentCourseIDCS03.put("S102", "CS03");
		studentCourseIDCS03.put("S103", "CS03");
		
		/*Create the Objects with the type of the Interface, we can then use the empty methods
		that are referenced in Students to add the previously created maps to the object
		 */
		
		//Define the objects for each course list
		ContactTracing courseNE02 = new Students();
		courseNE02.loadCourseList(courseNameID);
		courseNE02.loadStudentCourseList(studentCourseIDNE02);
		courseNE02.loadEmailList(studentNumEmail);
		
		ContactTracing courseSE01 = new Students();
		courseSE01.loadCourseList(courseNameID);
		courseSE01.loadStudentCourseList(studentCourseIDSE01);
		courseSE01.loadEmailList(studentNumEmail);
		
		ContactTracing courseCS03 = new Students();
		courseCS03.loadCourseList(courseNameID);
		courseCS03.loadStudentCourseList(studentCourseIDCS03);
		courseCS03.loadEmailList(studentNumEmail);
		
		//Define the student who has tested positive or has been told to self isolate
		Scanner positive_student = new Scanner(System.in);
		System.out.println("Please enter the number of the student who has tested positive:");
		
		String student_number = positive_student.nextLine();
		positive_student.close();
		      
        //Perform the contract tracing method on each of the course objects.
        List <String> s1 = courseSE01.contactTracing(student_number);
        List <String> s2 = courseNE02.contactTracing(student_number);
        List <String> s3 = courseCS03.contactTracing(student_number);
        
        System.out.println("Software Engineering: " + s1 );
		System.out.println("Network Engineering: " + s2);
		System.out.println("Cyber Security: " + s3);
			
	}
}