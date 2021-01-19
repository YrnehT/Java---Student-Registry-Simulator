//Student Name: Doan Huy Tran
//Student ID: 500983653

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.io.*; 

public class Registry
{
	// A1
	/*
	private ArrayList<Student>      students = new ArrayList<Student>();
	private ArrayList<ActiveCourse> courses  = new ArrayList<ActiveCourse>();
   
	public Registry()
	{
		
		// Add some students
		// in A2 we will read from a file
		Student s1 = new Student("JohnOliver", "34562");
		Student s2 = new Student("HarryWindsor", "38467");
		Student s3 = new Student("SophieBrown", "98345");
		Student s4 = new Student("FaisalQuereshi", "57643");
		Student s5 = new Student("GenghisKhan", "25347");
		Student s6 = new Student("SherryTu", "46532");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		Collections.sort(students);
		// sort the students alphabetically - see class Student
	

	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   // Add some active courses with students
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   list.add(s2); list.add(s3); list.add(s4);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   list.add(s1); list.add(s5); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   courses.add(new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   }
	   */
   
	// A2
	//Convert ArrayList students and courses into TreeMap
	private TreeMap<String, Student> students = new TreeMap<String, Student>();
   	private TreeMap<String, ActiveCourse> courses  = new TreeMap<String, ActiveCourse>();

   	public Registry() throws IOException
   	{
		//Read students from a given text file and add them to the students TreeMap
		File studentList = new File("/Users/tipro/OneDrive/Desktop/Ryerson Courses/First Year - 2nd semester/CPS209 - Java/Labs and Assignments/A1/Assignment1/students.txt");
		Scanner myReader = new Scanner(studentList);
		while (myReader.hasNextLine()) {
			String name = myReader.next();
			String id = myReader.next();
			Student newStudent = new Student(name, id);
			students.put(id, newStudent);
		}
		myReader.close();

		Student s1 = students.get("34562");
		Student s2 = students.get("38467");
		Student s3 = students.get("98345");
		Student s4 = students.get("57643");
		Student s5 = students.get("25347");
		Student s6 = students.get("46532");
	   
		// Add some active courses with students
		ActiveCourse newActiveCourse;
		ArrayList<Student> list = new ArrayList<Student>();
	
		// CPS209
		String courseName = "Computer Science II";
		String courseCode = "CPS209";
		String descr = "Learn how to write complex programs!";
		String format = "3Lec 2Lab";

		list.add(s2); list.add(s3); list.add(s4);
		newActiveCourse = new ActiveCourse(courseName,courseCode,descr,format,"W2020",list);
		courses.put(courseCode, newActiveCourse);
		s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	    s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	    s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
		// CPS511
		courseName = "Computer Graphics";
		courseCode = "CPS511";
		descr = "Learn how to write cool graphics programs";
		format = "3Lec";
		
		list.clear();
		list.add(s1); list.add(s5); list.add(s6);
		newActiveCourse = new ActiveCourse(courseName,courseCode,descr,format,"W2020",list);
		courses.put(courseCode, newActiveCourse);
		s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
		
		// CPS643
		courseName = "Virtual Reality";
		courseCode = "CPS643";
		descr = "Learn how to write extremely cool virtual reality programs";
		format = "3Lec 2Lab";
		
		list.clear();
		list.add(s1); list.add(s2); list.add(s4); list.add(s6);
		newActiveCourse = new ActiveCourse(courseName,courseCode,descr,format,"W2020",list);
		courses.put(courseCode, newActiveCourse);
		s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
		s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
   	}

	public TreeMap<String, ActiveCourse> getCourses() {
		return courses;
	}

   	// Add new student to the registry (students arraylist above) 
   	public boolean addNewStudent(String name, String id)
   	{
	   // Create a new student object
	   // check to ensure student is not already in registry
	   // if not, add them and return true, otherwise return false
	   // make use of equals method in class Student
	   
		// A1
		/*
	   	Student newStudent = new Student(name, id);	//Create a new student object

	   	for (int i = 0; i < students.size(); i++) {	//Loop through the list of student to find this student
		   	Student checkStudent = students.get(i);	//Current student in the list as the loop goes through
		   	if (newStudent.equals(checkStudent)) {	//If found a student with the same id
			   	System.out.println("There is already a student with the same id");	//Print out there is a student with the same id already and return false
			   	return false;
			}
		}
		students.add(newStudent);	//If not the same, it means that this is a new student. Add this student to the registry and return true
		return true;
		}
		*/

	// A2
		Student newStudent = new Student(name, id); 									//Create a new student obbject
		for (String IDkey : students.keySet()) {										//Loop through the treemap of student to find this student
			if (id.equalsIgnoreCase(IDkey)) { 											//If found a student with the same id
				System.out.println("There is already a student with the same id");		//Print out there is a student with the same id already and return false
				return false;
			}
		}
		students.put(id, newStudent);													//If not the same, it means that this is a new student. Add this student to the registry and return true
		return true;
   	}

   // Remove student from registry 
   	public boolean removeStudent(String studentId)
   	{
	   // Find student in students arraylist
	   // If found, remove this student and return true

	// A1
	/*
		   for (int i = 0; i < students.size(); i++) {							//Loop through the list of student to find this student
			   Student studentRemove = students.get(i);							//Current student in the list as the loop goes through
			   if ((studentRemove.getId()).equals(studentId)) {					//If found a student with the same id as studentId
				   students.remove(studentRemove);								//Remove this student from the registry
				   for (int y = 0; y < courses.size(); y++) {					//Loop through the active course list
					   ActiveCourse aC = courses.get(y);						//Current active course that the loop goes through
					   ArrayList<Student> aCstudentList = aC.getStudents();		//Current list of student in the active course
					   for (int z = 0; z < aCstudentList.size(); z++) {			//Loop through the list of student in an active course
						   Student checkStudent = aCstudentList.get(z);			//Current student that the loop goes through
						   if (checkStudent.getId().equals(studentId)) {		//If found a student with the same id
							   aCstudentList.remove(checkStudent);				//Remove that student from the active course
						   }
					   }
				   }
				   return true;													//Return true if a student was removed
			   }
		   }
		   return false;														//Otherwise, return false
	   }
	*/

	// A2
		for (String IDKey : students.keySet()) {									//Loop through the treemap of student to find this student
			if (IDKey.equalsIgnoreCase(studentId)) {								//If found a student with the same id as studentId
				students.remove(IDKey);												//Remove that student from the students treemap
				for (String courseCodeKey : courses.keySet()) {						//Loop through the courses treemap
					ActiveCourse aC = courses.get(courseCodeKey);					//Current Active course as the loop goes through
					ArrayList<Student> aCstudentList = aC.getStudents();			//Array List of student of that course
					for (int i = 0; i < aCstudentList.size(); i++) {				//Loop through the student array list
						Student checkStudent = aCstudentList.get(i);				//Current student as the loop goes through
						if (checkStudent.getId().equalsIgnoreCase(studentId)) {		//If found a student with the same id
							aCstudentList.remove(checkStudent);						//Remove that student from the course
						}
					}
				}
				return true;
			}
		}
		return false;
	}
   
   // Print all registered students
   public void printAllStudents()
   {
	// A1
	/*
	   for (int i = 0; i < students.size(); i++) {		//Loop through the list of student
		   Student currentStudent = students.get(i);	//Current student as the loop goes through
		   System.out.println(currentStudent);			//Print out the student
		}
	*/

	// A2
		for (String IDKey : students.keySet()) {		//Loop through the students treemap
			System.out.println(students.get(IDKey));	//Print out each student
		}
   }
   
   // Given a studentId and a course code, add student to the active course
   	public void addCourse(String studentId, String courseCode)
   	{
	   	// Find student object in registry (i.e. students arraylist)
	   	// Check if student has already taken this course in the past Hint: look at their credit course list
	   	// If not, then find the active course in courses array list using course code
	   	// If active course found then check to see if student already enrolled in this course
	   	// If not already enrolled
	   	//   add student to the active course
	   	//   add course to student list of credit courses with initial grade of 0

		// A1
		/*
		boolean foundCc = false;
		for (int i = 0; i < students.size(); i++) {														//Loop through students array to find the student match studentId
			Student checkStudent = students.get(i);														//The student as the loop goes through 
			if ((checkStudent.getId()).equals(studentId)) {												//Check if this is the right student or not
				ArrayList<CreditCourse> checkStudentCcList = checkStudent.getCourse(); 					//Credit Course list of the current checkStudent
				for (int y = 0; y < checkStudentCcList.size(); y++) {									//If right, begin another loop to check for credit course list
					CreditCourse checkCc = checkStudentCcList.get(y);									//checkCc is the current credit course
					if (checkCc.getCode().equalsIgnoreCase(courseCode) && !checkCc.getActive()) {		//If found a course equals courseCode and that course is inactive
						foundCc = true;																	//Set the foundCc boolean to true, it means the student already took this course in the past. End the loop
						System.out.println("This student already took this course in the past");
						break;
					}
					if (checkCc.getCode().equalsIgnoreCase(courseCode) && checkCc.getActive()) {		//If found a course equals courseCode and that course is active
						foundCc = true;																	//Also set the found boolean to true, it means the student is already enrolled in the active course
						System.out.println("This student is already enrolled in this active course");
						break;
					} else {																			//If the course is not found in the credit course list, it means the student has never taken this course. Set the foundCc boolean to false
						foundCc = false;
					}
				}
				if (foundCc == false) {																	//If the found boolean is false, continue to check the active course
					for (int z = 0; z < courses.size(); z++) {											//Loop through the active course list
						ActiveCourse checkAc = courses.get(z);											//Current active course as the loop goes through
						if (checkAc.getCode().equalsIgnoreCase(courseCode)) {							//If found the active course
							ArrayList<Student> checkAcStudentList = checkAc.getStudents();				//Get the list of student in that active course
							checkAcStudentList.add(checkStudent);										//Add the student to that list
							checkStudent.addCourse(checkAc.getName(), checkAc.getCode(), checkAc.getDescriptionOnly(), checkAc.getFormat(), checkAc.getSemester(), 0);		//Add the course to the student's credit course list
						}
					}
				}
			}
		}
		*/

		// A2
		boolean foundCc = false;																		//foundCc is a boolean to determine whether a credit course is found or not
		for (String IDKey : students.keySet()) {														//Loop through the student TreeMap to find the student with the same studentId
			if (IDKey.equals(studentId)) {																//If the IDKey is equal to the studentId
				Student checkStudent = students.get(IDKey);												//This is the student we are going to add course
				ArrayList<CreditCourse> studentCcList = checkStudent.getCourse();						//This is the credit course list of that student
				for (int i = 0; i < studentCcList.size(); i++) {										//Loop through the credit course list of that student to check if the student already took the course or not
					CreditCourse checkCc = studentCcList.get(i);										//Current credit course as the loop goes through
					if (checkCc.getCode().equalsIgnoreCase(courseCode) && !checkCc.getActive()) {		//If found a course equal to courseCode and that course is inactive
						foundCc = true;																	//Set the found boolean to true, it means that the student already took this course in the past
						System.out.println("This student already took this course in the past");		//Print out that the student took this course in the past
						break;																			//Break the loop
					}
					if (checkCc.getCode().equalsIgnoreCase(courseCode) && checkCc.getActive()) {		//If found a course equals courseCode and that course is active
						foundCc = true;																	//Also set the found boolean to true, it means the student is already enrolled in the active course
						System.out.println("This student is already enrolled in this active course");
						break;
					} else {																			//If the course is not found in the credit course list, it means the student has never taken this course. Set the foundCc boolean to false
						foundCc = false;
					}
				}
				if (foundCc == false) {																	//If the student has never taken this course
					for (String courseCodeKey : courses.keySet()) {										//Loop through the courses treemap
						if (courseCodeKey.equalsIgnoreCase(courseCode)) {								//If found a course with the same courseCode
							ActiveCourse checkAc = courses.get(courseCodeKey);							//Get that active course from the treemap
							ArrayList<Student> checkAcStudentList = checkAc.getStudents();				//Get the student arraylist of that course
							checkAcStudentList.add(checkStudent);										//Add this student to the arraylist
							checkStudent.addCourse(checkAc.getName(), checkAc.getCode(), checkAc.getDescriptionOnly(), checkAc.getFormat(), checkAc.getSemester(), 0);	//Add the course to the student
						}
					}
				}
			}
		}
	}

   
   // Given a studentId and a course code, drop student from the active course
   public void dropCourse(String studentId, String courseCode)
   {
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses

	   // A1
	   /*
	   	for (int i = 0; i < courses.size(); i++) {							//Loop through the current active courses list to find the course matches courseCode
		   	ActiveCourse dropC = courses.get(i);							//Current active course that the loop is going through
		   	if (dropC.getCode().equalsIgnoreCase(courseCode)) {				//If found the course in the active course list
			   	ArrayList<Student> dropCstudentList = dropC.getStudents();	//Get the list of students in that active course
			   	for (int y = 0; y < dropCstudentList.size(); y++) {			//Loop through this list of student to find the student we need to remove
				   	Student dropStudent = dropCstudentList.get(y);			//Current student in the active course that the loop is going through
				   	if ((dropStudent.getId()).equals(studentId)) {			//If found the student we need to remove
					   	dropCstudentList.remove(dropStudent);  				//Remove student from the current active course 
					   	dropStudent.removeActiveCourse(courseCode);			//Remove the credit course from the student's list of credit courses
				   	}
			   	}
		   	}
		}
		*/

		// A2
		for (String courseCodeKey : courses.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				ActiveCourse dropC = courses.get(courseCodeKey);
				ArrayList<Student> dropCstudentList = dropC.getStudents();
				for (int i = 0; i < dropCstudentList.size(); i++) {
					Student dropStudent = dropCstudentList.get(i);
					if (dropStudent.getId().equalsIgnoreCase(studentId)) {
						dropCstudentList.remove(dropStudent);
						dropStudent.removeActiveCourse(courseCode);
					}
				}
			}
		}
   	}
   
   // Print all active courses
   public void printActiveCourses()
   {
	   	// A1
	   	/*
	   	for (int i = 0; i < courses.size(); i++)			//Loop through the list of active course
	   	{
		   	ActiveCourse aC = courses.get(i);				//Current active course that the loop is going through
		   	System.out.println(aC.getDescription());		//Print out the description of the active course
	   	}
	   	*/

	   	// A2
	   	for (String courseCodeKey : courses.keySet()) {			//Loop through the courses TreeMap and get the key(courseCode)
		   	ActiveCourse aC = courses.get(courseCodeKey);		//Current active course that the loop is going through
		   	System.out.println(aC.getDescription());			//Print out the description of the active course
	   	}
   	}
   
   // Print the list of students in an active course
   public void printClassList(String courseCode) throws Exception
   {
		// A1
		/*
		boolean foundAc = false;
		for (int i = 0; i < courses.size(); i++)							//Loop through the list of the active course
		{
			ActiveCourse aC = courses.get(i);								//Current active course that the loop is going through
			if (aC.getCode().equalsIgnoreCase(courseCode)) {				//If the current active course code is the same as courseCode
				foundAc = true;				
				ArrayList<Student> acStudentList = aC.getStudents();		//Get the student list of this active course
				for (int y = 0; y < acStudentList.size(); y++) {			//Loop through this student list
					Student aCstudent = aCstudentList.get(y);				//Current student in the list that the loop is going through
					System.out.println(aCstudent);							//Print out the student
				}
			}
		}
		if (!foundAc) {
			throw new Exception("Invalid courseCode");
		}
		*/

		// A2
		boolean foundAc = false;
		for (String courseCodeKey : courses.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				foundAc = true;
				ActiveCourse aC = courses.get(courseCodeKey);
				ArrayList<Student> aCstudentList = aC.getStudents();
				for (int i = 0; i < aCstudentList.size(); i++) {
					Student aCstudent = aCstudentList.get(i);
					System.out.println(aCstudent);
				}
			}
		}
		if (!foundAc) {
			throw new UnknownCourseException("Unknown Course: " + courseCode);
		}
   	}
   
   // Given a course code, find course and sort class list by student name
   public void sortCourseByName(String courseCode)
   {
		// A1
		/*
		for (int i = 0; i < courses.size(); i++) {							//Loop through the list of active course
			ActiveCourse aC = courses.get(i);								//Current active course that the loop is going through
			if ((aC.getCode()).equalsIgnoreCase(courseCode)) {				//If the code of this active course equals courseCode
				aC.sortByName();											//Sort that course by name by using sortByName() in ActiveCourse
			}
		}
		*/

		// A2
		for (String courseCodeKey : courses.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				ActiveCourse aC = courses.get(courseCodeKey);
				aC.sortByName();
			}
		}
   	}
   
   // Given a course code, find course and sort class list by id
   public void sortCourseById(String courseCode)
   {
		// A1
		/*
		for (int i = 0; i < courses.size(); i++) {							//Loop through the list of active course
			ActiveCourse aC = courses.get(i);								//Current active course that the loop is going through
			if ((aC.getCode()).equalsIgnoreCase(courseCode)) {				//If the code of this active course equals courseCode
				aC.sortById();												//Sort that course by id using sortById() in ActiveCourse
			}
		}
		*/

		// A2
		for (String courseCodeKey : courses.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				ActiveCourse aC = courses.get(courseCodeKey);
				aC.sortById();
			}
		}
	}
   
   // Given a course code, find course and print student names and grades
   public void printGrades(String courseCode) throws Exception
   {
	   	// A1
		/*
		boolean foundC = false;
		for (int i = 0; i < courses.size(); i++) {							//Loop through the list of active course
			ActiveCourse aC = courses.get(i);								//Current active course that the loop is going through
			if (aC.getCode().equalsIgnoreCase(courseCode)) {				//If the code of this active course equals courseCode
				foundC = true;				
				aC.printGrades();											//Print the student name and grades of this active course using printGrades() in ActiveCourse
			}
		}
		if (!foundC) {
			throw new Exception("Invalid courseCode");
		}
		*/

		// A2
		boolean foundC = false;
		for (String courseCodeKey : courses.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				foundC = true;
				ActiveCourse aC = courses.get(courseCodeKey);
				aC.printGrades();
			}
		}
		if (!foundC) {
			throw new UnknownCourseException("Unknown Course: " + courseCode);
		}
   }
   
   // Given a studentId, print all active courses of student
   public void printStudentCourses(String studentId)
   {
		// A1
		/*
	  	for (int i = 0; i < students.size(); i++) {											//Loop through the student list
			Student checkStudent = students.get(i);											//Current student as the loop goes through
		   	if (checkStudent.getId().equals(studentId)) {									//If found a student with the same id as studentId
			   	ArrayList<CreditCourse> checkStudentCcList = checkStudent.getCourse();		//Get the credit course list of that student
			   	for (int y = 0; y < checkStudentCcList.size(); y++) {						//Loop through the credit course list
				  	CreditCourse cC = checkStudentCcList.get(y);							//Current credit course that the loop goes through
				   	if (cC.getActive()) {													//If the course is currently active
						System.out.println(cC.getDescription());							//Print out the credit course description
				   	}
				}
			}
		}
		*/

		// A2
		for (String IDKey : students.keySet()) {
			if (IDKey.equalsIgnoreCase(studentId)) {
				Student checkStudent = students.get(IDKey);
				ArrayList<CreditCourse> checkStudentCcList = checkStudent.getCourse();
				for (int i = 0; i < checkStudentCcList.size(); i++) {
					CreditCourse cC = checkStudentCcList.get(i);
					if (cC.getActive()) {
						System.out.println(cC.getDescription());
					}
				}
			}
		}
	}
		
   // Given a studentId, print all completed courses and grades of student
   public void printStudentTranscript(String studentId)
   {
		// A1
		/*
	   	for (int i = 0; i < students.size(); i++) {											//Loop through the studednt list
		   	Student checkStudent = students.get(i);											//Current student as the loop goes through
		   	if ((checkStudent.getId()).equals(studentId)) {									//If found a student with the same id as studentId
			   	ArrayList<CreditCourse> checkStudentCcList = checkStudent.getCourse();		//Get the credit course list of that student
			   	for (int y = 0; y < checkStudentCcList.size(); y++) {						//Loop through the credit course list
				  	CreditCourse checkStudentCc = checkStudentCcList.get(y);				//Current credit course as the loop goes through
				   	if (!checkStudentCc.getActive()) {										//If the credit course is inactive (completed)
						System.out.println(checkStudentCc.displayGrade());					//Print out the course information
					}
				}
			}
		}
		*/

		// A2
		for (String IDKey : students.keySet()) {
			if (IDKey.equalsIgnoreCase(studentId)) {
				Student checkStudent = students.get(IDKey);
				ArrayList<CreditCourse> checkStudentCcList = checkStudent.getCourse();
				for (int i = 0; i < checkStudentCcList.size(); i++) {
					CreditCourse checkStudentCc = checkStudentCcList.get(i);
					if (!checkStudentCc.getActive()) {
						System.out.println(checkStudentCc.displayGrade());
					}
				}
			}
		}
	}
   
   // Given a course code, student id and numeric grade
   // set the final grade of the student
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	   	// find the active course
	   	// If found, find the student in class list
	   	// then search student credit course list in student object and find course
	   	// set the grade in credit course and set credit course inactive

		// A1
		/*
	   	for (int i = 0; i < courses.size(); i++) {				//Loop through the active course list
		   	ActiveCourse findActiveCourse = courses.get(i);		//Current active course as the loop goes through
		   	if ((findActiveCourse.getCode()).equalsIgnoreCase(courseCode)) {		//If found an active course that has the code equals courseCode
			   	ArrayList<Student> findStudentList = findActiveCourse.getStudents();  	//Get the list of student in that active course
			   	for (int y = 0; y < findStudentList.size(); y++) {						//Loop through the list of student in that active course
				   	Student findStudent = findStudentList.get(y);						//Current student as the loop goes through
				   	if ((findStudent.getId()).equals(studentId)) {						//If found a student with the same id as studentId
					   	ArrayList<CreditCourse> findStudentCreditCourseList = findStudent.getCourse();		//Get the credit course list of that student
					   	for (int z = 0; z < findStudentCreditCourseList.size(); z++) {						//Loop through the credit course list
						   	CreditCourse findStudentCreditCourse = findStudentCreditCourseList.get(z);		//Current credit course as the loop goes through
						   	if ((findStudentCreditCourse.getCode()).equalsIgnoreCase(courseCode)) {			//If found a credit course that has the code equals courseCode
							   	findStudentCreditCourse.setFinal(grade);										//Set the final grade for that credit course
							   	findStudentCreditCourse.setInactive();										//Set the credit course inactive
						   	}
					   	}
				   	}
			   	}
		   	}
		}
		*/

		// A2
		for (String courseCodeKey : courses.keySet()) {														//Loop through the courses treemap
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {												//If found a course equals courseCode
				ActiveCourse findActiveCourse = courses.get(courseCodeKey);									//Get that active course
				ArrayList<Student> findStudentList = findActiveCourse.getStudents();  						//Get the list of student in that active course
			   	for (int i = 0; i < findStudentList.size(); i++) {											//Loop through the list of student in that active course
				   	Student findStudent = findStudentList.get(i);											//Current student as the loop goes through
				   	if ((findStudent.getId()).equals(studentId)) {											//If found a student with the same id as studentId
					   	ArrayList<CreditCourse> findStudentCreditCourseList = findStudent.getCourse();		//Get the credit course list of that student
					   	for (int z = 0; z < findStudentCreditCourseList.size(); z++) {						//Loop through the credit course list
						   	CreditCourse findStudentCreditCourse = findStudentCreditCourseList.get(z);		//Current credit course as the loop goes through
						   	if ((findStudentCreditCourse.getCode()).equalsIgnoreCase(courseCode)) {			//If found a credit course that has the code equals courseCode
							   	findStudentCreditCourse.setFinal(grade);									//Set the final grade for that credit course
							   	findStudentCreditCourse.setInactive();										//Set the credit course inactive
						   	}
					   	}
				   	}
			   	}
			}
		}
   	}
}
