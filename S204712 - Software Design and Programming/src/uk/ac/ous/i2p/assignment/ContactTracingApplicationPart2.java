package uk.ac.ous.i2p.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class ContactTracingApplicationPart2 {

	public static void main(String[] args) {
		
		ContactTracingApplicationPart2 app = new ContactTracingApplicationPart2();
		List<String> email_list;
		List<String> positive_list = new ArrayList<>();
		
		Scanner get_name = new Scanner(System.in);
		System.out.println("Please Enter the name of the student who has tested positive:");
		
		String student_name = get_name.nextLine();		
		positive_list.add(student_name);
		
		System.out.println("Please Enter the number of the student who has tested positive:");
		String student_num = get_name.nextLine();
		positive_list.add(student_num);
		positive_list.add("COVID Positive");
		
		get_name.close();
		String file_name1 = "postiveResultFile_" + student_name + ".txt";
		
		try {
			FileWriter positive_file = new FileWriter(file_name1);
			positive_file.write(positive_list.toString());
			positive_file.close();
			System.out.println("Positive result file created at location: " + file_name1);
		} catch	(IOException e) {
			System.out.println("Unable to create a file for that student");	
			e.printStackTrace();
		}
		
		String file_name2 = "contactTracedFile_" + student_name + ".txt";
		
		try {
			FileWriter contact_file = new FileWriter(file_name2);
			email_list = app.populate_map(student_num);
			contact_file.write("List of students to contact regarding " + student_name + "'s positive result");
			contact_file.write(email_list.toString());
			contact_file.close();
			System.out.println("Contact tracing file created at location: " + file_name2);
		} catch (IOException e) {
			System.out.println("Unable to create the contact tracing file for that student");
			e.printStackTrace();
		}
		
		}
		
	public List<String> populate_map(String student_number) {
		Map<String, String> studentNameNum = new HashMap<>();
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
		
        String s1 =  courseSE01.contactTracing(student_number).toString();
        String s2 = courseNE02.contactTracing(student_number).toString();
        String s3 = courseCS03.contactTracing(student_number).toString();
        
		List <String> final_list = new ArrayList<>();
		final_list.add(s1);
		final_list.add(s2);
		final_list.add(s3);
		
		return final_list;

	}

}
