# Java---Student-Registry-Simulator
This program is a simple version of a student registry. Universities maintain a list of registered students in the registry. A university also has a list of active courses that are currently running. It also has a list (stored in a Student Calendar) of all courses but we will not simulate this. We will simulate only active courses. See the class descriptions below and also look closely at the skeleton code and comments within. 

1.	Student: Class Student contains instance variables name (type String), id (type String), courses (array list of CreditCourse objects). The id string should contain 5 digit characters.  The courses array list keeps track of the courses the student has taken in the past or is currently enrolled in. 

2.	Course: class Course contains instance variables code, name, description, format (all type String). Most of the code for this class is already written for you. See subclasses CreditCourse and ActiveCourse to see how it is used.

3.	ActiveCourse: Class ActiveCourse extends class Course. That is, an ActiveCourse is a Course. In addition to all the variables and methods inherited from class Course, class ActiveCourse also keeps an array list of students enrolled in the course.  This class also has two private Comparator classes that are used to sort the list of students by name or by student id. 

4.	CreditCourse: class CreditCourse also extends class Course. That is, a CreditCourse is a Course. In addition to all the variables and methods inherited from class Course, class CreditCourse adds variables semester (type String), grade (double), active (type boolean). Class Student above keeps a list of CreditCourse objects. The grade variable is initially set to 0. The active variable is initially set to true. The active variable indicates whether this is course that is currently happening – and therefore there is an associated ActiveCourse object in the Registry – or whether this was a course the student has taken in the past. The final grade for a CreditCourse that a student is taking is set from class Registry in method setFinalGrade(). A CreditCourse is associated with a student and is like a record of what the student has done or is currently doing. An ActiveCourse, on the other hand, is for university administrators and professors which holds information for a currently active course like cps209. In a university, an ActiveCourse may not be for credit and so it is not a subclass of CreditCourse. See code comments for this method.

5.	Registry: class Registry holds a list of students registered at this university and a list of active courses. It is the largest class for this system. A constructor method has been created for you and some students have been pre-registered and some courses created. Take a look at the code in the constructor method and follow it through. Your job is to fill in code for the skeleton methods by following the comments. Two of these methods have been written for you. 


6.	StudentRegistrySimulator. This class has the main() method and is the user interaction part. Some skeleton code has been provided for you with some comments. In a while loop, a scanner reads a line of input from the user. The input lines contain words (Strings). Most input lines contain a single word that represents a command. Some lines contain a command word and some parameter string. Here are the commands:
a.	“L” : list all the students in the registry. This one has been done for you. 
b.	“Q” : quit out of the program. Also done for you.
c.	“REG” : register a student. Reads a student name and student id from the commandLine scanner (see code). Uses Registry method to register the new student. Just make up a 5 digit id. 
d.	“DEL”: deletes a student from the registry. 
e.	“ADDC”: adds a student to an active course
f.	“DROPC”: drops a student from an active course
g.	“PAC” : prints all active course
h.	“PCL” : prints class list for an active course
i.	“PGR” : prints student id and grade for all students in an active course
j.	“PSC” : prints all credit courses for a student
k.	“SFG” : Set final grade of a student in a course
l.	“SCN” : sort list of students in a course by student name
m.	“SCI” : sort list of students in a course by student id  
n.	Make sure your code handles commands that are not recognized or the null string or a null reference etc. 


7. Use File I/O and exceptions. Replace the given constructor method in class Registry to read a list of students from a file students.txt and create the array list of Student objects. Also read a list of courses from a file courses.txt. Add appropriate exception handling for the file I/O. In class Registry, throw an exception for at least 2 of the methods if their parameters are invalid or out of range etc. In class StudentRegistrySimulator, catch these exceptions and print an appropriate message to the user.   
