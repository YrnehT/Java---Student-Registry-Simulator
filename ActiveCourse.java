//Student Name: Doan Huy Tran
//Student ID: 500983653

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
 
public class ActiveCourse extends Course
{
	private ArrayList<Student> students; 
   private String semester;
   private int lectureStart;
   private int lectureDuration;
   private String lectureDay;
	   
   // Add a constructor method with appropriate parameters
   // should call super class constructor to initialize inherited variables
   // make sure to *copy* students array list being passed in into new arraylist of students
   // see class Registry to see how an ActiveCourse object is created and used
   public ActiveCourse(String name, String code, String descr, String fmt,String semester,ArrayList<Student> students)
   {
      super(name, code, descr, fmt);
      ArrayList<Student> activeCourseStudent = new ArrayList<Student>();
      for (int i = 0; i < students.size(); i++) {
         Student student = students.get(i);
         activeCourseStudent.add(student);
      }
      this.students = activeCourseStudent;
      this.semester = semester;
      lectureStart = 0;
      lectureDuration = 0;
      lectureDay = "";
   }

   public String getCode() {
      return super.getCode();
   }
   
   public ArrayList<Student> getStudents() {
      return students;
   }

   public String getSemester()
   {
	   return semester;
   }
   
   public String getLectureDay() {
      return lectureDay;
   }

   public int getLectureDuration() {
      return lectureDuration;
   }

   public int getLectureStart() {
      return lectureStart;
   }

   public void setLectureDay(String day) {
      lectureDay = day;
   }

   public void setLectureTime(int startTime) {
      lectureStart = startTime;
   }

   public void setLectureDuration(int duration) {
      lectureDuration = duration;
   }

   public void clear() {
      lectureDay = "";
      lectureDuration = 0;
      lectureStart = 0;
   }

   // Prints the students in this course  (name and student id)
   public void printClassList()
   {
	   System.out.println(students);
   }
   
   // Prints the grade of each student in this course (along with name and student id)
   // 
   public void printGrades()
   {
	   for (int i = 0; i < students.size(); i++) {
         Student student = students.get(i);
         System.out.println(student.getId() + " " + student.getName() + " " + getGrade(student.getId())); 
      }
   }
   
   // Returns the numeric grade in this course for this student
   // If student not found in course, return 0 
   public double getGrade(String studentId)
   {
	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class CreditCourse method getGrade() 
	  // return the grade stored in the credit course object
	  for (int i = 0; i < students.size(); i++) {
        Student student = students.get(i);
        if (((student.getId()).equals(studentId))) {
           ArrayList<CreditCourse> studentCc = student.getCourse(); 
           for (int y = 0; y < studentCc.size(); y++) {
              CreditCourse cc = studentCc.get(y);
              if ((cc.getCode()).equalsIgnoreCase(this.getCode())) {
                 return cc.getGrade();
               }
            }
         }
      }
      return 0.0;
   }
   
   // Returns a String containing the course information as well as the semester and the number of students 
   // enrolled in the course
   // must override method in the superclass Course and use super class method getDescription()
   public String getDescription()
   {
	   return super.getDescription() + " " + semester + " Enrollment: " + students.size() + "\n";
   }

   public String getDescriptionOfSuperClass() {
      return super.getDescription();
   }
   
   // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortByName()
   {
      Collections.sort(students, new NameComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student name
   private class NameComparator implements Comparator<Student>
   {
      public int compare(Student a, Student b) {
         return a.getName().compareTo(b.getName());
	   }
   }
   
   // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
   // Make use of a private Comparator class below
   public void sortById()
   {
      Collections.sort(students, new IDComparator());
   }
   
   // Fill in the class so that this class implement the Comparator interface
   // This class is used to compare two Student objects based on student id
   private class IDComparator implements Comparator<Student>
   {
   	public int compare(Student a, Student b) {
         return a.getId().compareTo(b.getId());
	   }
   }
}
