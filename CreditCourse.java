//Student Name: Doan Huy Tran
//Student ID: 500983653

public class CreditCourse extends Course
{
	// add a constructor method with appropriate parameters
	// should call the super class constructor

	private String  semester;
	public  double  grade;
	public  boolean active;

	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		// add code
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade = grade;
	}

	public double getGrade() {
		return grade;
	}

	public void setFinal(double finalGrade) {
		grade = finalGrade;
	}

	public String getCode() {
		return super.getCode();
	}

	public boolean getActive()
	{
		// add code and remove line below
		return active;
	}
	
	public void setActive()
	{
		// add code
		active = true;
	}
	
	public void setInactive()
	{
		// add code
		active = false;
	}
	
	public String displayGrade()
	{
		// Change line below and print out info about this course plus which semester and the grade achieved
		// make use of inherited method in super class
		return super.getInfo() + " " + semester + " Grade " + super.convertNumericGrade(grade);
	}
}