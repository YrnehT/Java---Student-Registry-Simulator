//Student Name: Doan Huy Tran
//Student ID: 500983653

import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable <Student>
{
  private String name;
  private String id;
  public  ArrayList<CreditCourse> courses;
  
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }

  public ArrayList<CreditCourse> getCourse() {
    return courses;
  }
  
  // add a credit course to list of courses for this student
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
	  // create a CreditCourse object
	  // set course active
    // add to courses array list
    CreditCourse newCreditCourse = new CreditCourse(courseName, courseCode, descr, format, sem, grade);
    newCreditCourse.setActive();
    courses.add(newCreditCourse);
  }
  
  
  
  // Prints a student transcript
  // Prints all completed (i.e. non active) courses for this student (course code, course name, 
  // semester, letter grade
  // see class CreditCourse for useful methods
  public void printTranscript()
  {
	  for (int i = 0; i < courses.size(); i++) {
      CreditCourse cc = courses.get(i);
      if (cc.getActive() == false) {
        System.out.println(cc.displayGrade());
      }
    }
  }
  
  // Prints all active courses this student is enrolled in
  // see variable active in class CreditCourse
  public void printActiveCourses()
  {
    for (int i = 0; i < courses.size(); i++) {
      CreditCourse cc = courses.get(i);
      if (cc.getActive()) {
        System.out.println(cc);
      }
    }
  }
  
  // Drop a course (given by courseCode)
  // Find the credit course in courses arraylist above and remove it
  // only remove it if it is an active course
  public void removeActiveCourse(String courseCode)
  {
	 for (int i = 0; i < courses.size(); i++) {
     CreditCourse ac = courses.get(i);
     if ((ac.getCode()).equalsIgnoreCase(courseCode) && ac.getActive()) {
       courses.remove(ac);
     }
   }
  }
  
  public String toString()
  {
	  return "ID: " + id + " Name: " + name;
  }
  
  // override equals method inherited from superclass Object
  // if student names are equal *and* student ids are equal (of "this" student
  // and "other" student) then return true
  // otherwise return false
  // Hint: you will need to cast other parameter to a local Student reference variable

  public boolean equals(Object other)
  {
    Student otherStudent = (Student)other;
    if (this.id.equals(otherStudent.id)) {
      return true;
    }
	 return false;
  }

  public int compareTo(Student otherStudent) {
    return name.compareTo(otherStudent.name);
  }
  
}
