//Student Name: Doan Huy Tran
//Student ID: 500983653

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class StudentRegistrySimulator 
{
  	public static void main(String[] args) throws Exception
  	{
		try {
			Registry registry = new Registry();
			Scheduler schedule = new Scheduler(registry.getCourses());
	  		Scanner scanner = new Scanner(System.in);
	  		System.out.print(">");
	  
	  		while (scanner.hasNextLine())
	  		{
		  		String inputLine = scanner.nextLine();
		  		if (inputLine == null || inputLine.equals("")) continue;
		  
		  		Scanner commandLine = new Scanner(inputLine);
		  		String command = commandLine.next();
		  
		  		if (command == null || command.equals("")) continue;
		  
		  		else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  		{
			  		registry.printAllStudents();
		  		}
		  		else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
					break;
		  		else if (command.equalsIgnoreCase("REG"))
		  		{
			  		// register a new student in registry
			  		// get name and student id string 
			  		// e.g. reg JohnBoy 74345
			  		// Checks:
			  		//  ensure name is all alphabetic characters
					//  ensure id string is all numeric characters
					String name;
					String id;
					try {
			  			name = commandLine.next();
						id = commandLine.next(); 
					} catch (NoSuchElementException e) {
						System.out.println("Name and id required");
						System.out.println("");
						continue;
					}
					if (!isStringOnlyAlphabet(name)) {
						System.out.println("Invalid characters in Name " + name);
					} else if (!isNumeric(id)) {
						System.out.println("Invalid characters in ID " + id);
					} else {
						registry.addNewStudent(name, id);
					}
		  		}
		  		else if (command.equalsIgnoreCase("DEL"))
		  		{
			  	// delete a student from registry
			  	// get student id
			  	// ensure numeric
				// remove student from registry
					try {
						String id = commandLine.next();
						if (!isNumeric(id)) {
							System.out.println("Invalid characters in ID " + id);
						} else {
							registry.removeStudent(id);
						}
					} catch (NoSuchElementException e) {
						System.out.println("Missing Student ID");
					}
		  		}
		  		else if (command.equalsIgnoreCase("ADDC"))
		  		{
				// add a student to an active course
			 	// get student id and course code strings
				// add student to course (see class Registry)
					try {
			 			String id = commandLine.next();
			 			String courseCode = commandLine.next();
						registry.addCourse(id, courseCode);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
		  		}
		  		else if (command.equalsIgnoreCase("DROPC"))
		  		{
			  		// get student id and course code strings
					// drop student from course (see class Registry)
					try {
			  			String id = commandLine.next();
			  			String courseCode = commandLine.next();
						registry.dropCourse(id, courseCode);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
		  		}
		  		else if (command.equalsIgnoreCase("PAC"))
		  		{
			  		// print all active courses
			  		registry.printActiveCourses();
		  		}		  
		  		else if (command.equalsIgnoreCase("PCL"))
		  		{
			  		// get course code string
					// print class list (i.e. students) for this course
					String courseCode;
					try {
						courseCode = commandLine.next();
					} catch (NoSuchElementException e) {
						System.out.println("Missing courseCode");
						System.out.print("");
						continue;
					}

					try {
						registry.printClassList(courseCode);
					} catch (UnknownCourseException e) {
						System.out.println(e);
						System.out.println("");
						continue;
					} 
		  		}
		  		else if (command.equalsIgnoreCase("PGR"))
		  		{
			  		// get course code string
					// print name, id and grade of all students in active course
					String courseCode;
					try {
						courseCode = commandLine.next();
					} catch (NoSuchElementException e) {
						System.out.println("Missing courseCode");
						System.out.println("");
						continue;
					}

					try {
						registry.printGrades(courseCode);
					} catch (UnknownCourseException e) {
						System.out.println(e);
						System.out.println("");
						continue;
					}
		  		}		
		  		else if (command.equalsIgnoreCase("PSC"))
		  		{
			  		// get student id string
				  	// print all credit courses of student
					try {  
			  			String id = commandLine.next();
				  		registry.printStudentCourses(id);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
		  		}
		  		else if (command.equalsIgnoreCase("PST"))
		  		{
			  		// get student id string
					// print student transcript
					try {
						String id = commandLine.next();
						registry.printStudentTranscript(id);
					} catch (NoSuchElementException e) {
						System.out.println("Missing Student ID");
					}  
		  		}
		  		else if (command.equalsIgnoreCase("SFG"))
		  		{
			  		// set final grade of student
			  		// get course code, student id, numeric grade
					// use registry to set final grade of this student (see class Registry)
					try {
			  			String courseCode = commandLine.next();
			  			String id = commandLine.next();
			  			double grade = commandLine.nextDouble();
						registry.setFinalGrade(courseCode, id, grade);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
			  		// registry.dropCourse(id, courseCode);
		  		}
		  		else if (command.equalsIgnoreCase("SCN"))
		  		{
			  		// get course code
			  		// sort list of students in course by name (i.e. alphabetically)
					// see class Registry
					try {
			  			String courseCode = commandLine.next();
						registry.sortCourseByName(courseCode);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
		  		}
		  		else if (command.equalsIgnoreCase("SCI"))
		  		{
					// get course code
					// sort list of students in course by student id
					// see class Registry
					try {
						String courseCode = commandLine.next();
						registry.sortCourseById(courseCode);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
				}
				else if (command.equalsIgnoreCase("SCH")) 
				{
					// get course code, day, start and duration
					// schedule the course
					// see class Scheduler
					try {
						String courseCode = commandLine.next();
						String day = commandLine.next();
						int startTime = commandLine.nextInt();
						int duration = commandLine.nextInt();
						schedule.setDayAndTime(courseCode, day, startTime, duration);
					} catch (InvalidDayException e) {
						System.out.println(e);
					} catch (InvalidTimeException e) {
						System.out.println(e);
					} catch (InvalidDurationException e) {
						System.out.println(e);
					} catch (LectureTimeCollisionException e) {
						System.out.println(e);
					} catch (UnknownCourseException e) {
						System.out.println(e);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
				}
				else if (command.equalsIgnoreCase("CSCH"))
				{
					// get course code
					// clear the schedule of that course
					try {
						String courseCode = commandLine.next();
						schedule.clearSchedule(courseCode);
					} catch (UnknownCourseException e) {
						System.out.println(e);
					} catch (NoSuchElementException e) {
						System.out.println("Missing an argument");
					}
				}
				else if (command.equalsIgnoreCase("PSCH")) {
					schedule.printSchedule();
				}
		  		System.out.print("\n>");
			}
		} catch (IOException e) {
			System.out.println("students.txt File not found");
		} catch (NoSuchElementException e) {
			System.out.println("Bad File Format students.txt");
		}
	}
  
  	private static boolean isStringOnlyAlphabet(String str) 
  	{ 
		// write method to check if string str contains only alphabetic characters 
		if (str == null) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if (!(character >= 'A' && character <= 'Z') && !(character >= 'a' && character <= 'z')) {
				return false;
			}
		}
		return true;
	} 

	public static boolean isNumeric(String str)
	{
    // write method to check if string str contains only numeric characters
		if (str == null) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char character = str.charAt(i);
			if (!Character.isDigit(character)) {
				return false;
			}
		}
		return true;
  	}
}