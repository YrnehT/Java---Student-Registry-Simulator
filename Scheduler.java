import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Scheduler 
{
    // In main() after you create a Registry object, create a Scheduler object and pass in the courses ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	
	//ArrayList<Student> students;
	
	TreeMap<String,ActiveCourse> schedule;
		
	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
	  schedule = courses;
	}
	
	public void setDayAndTime(String courseCode, String day, int startTime, int duration) throws Exception
	{
		ArrayList<String> dayList = new ArrayList<String>();
		dayList.add("Mon");
		dayList.add("Tue");
		dayList.add("Wed");
		dayList.add("Thur");
		dayList.add("Fri");

		int endTime = startTime + duration*100;

		if (!dayList.contains(day)) {
			throw new InvalidDayException("Invalid Lecture Day");
		}
		if (startTime < 800  || startTime > 1600) {
			throw new InvalidTimeException("Invalid Lecture Start Time");
		}
		if (endTime < 900 || endTime > 1700) {
			throw new InvalidTimeException("Invalid Lecture End Time");
		}
		if (duration != 1 && duration != 2 && duration != 3) {
			throw new InvalidDurationException("Invalid Lecture Duration");
		}
		
		boolean foundAc = false;
		for (String courseCodeKey : schedule.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				foundAc = true;
				ActiveCourse aC = schedule.get(courseCodeKey);
				for (String otherCourseCodeKey : schedule.keySet()) {
					ActiveCourse checkAc = schedule.get(otherCourseCodeKey);
					int checkAcStartTime = checkAc.getLectureStart();
					int checkAcLectureDuration = checkAc.getLectureDuration() * 100;
					int checkAcEndTime = checkAcStartTime + checkAcLectureDuration;
					String checkAcLectureDay = checkAc.getLectureDay();
					if (checkAcLectureDay.equals(day)) {
						if (startTime >= checkAcStartTime && startTime < checkAcEndTime) {
							throw new LectureTimeCollisionException("Lecture Time Collision");
						}
						if (endTime > checkAcStartTime && endTime <= checkAcEndTime) {
							throw new LectureTimeCollisionException("Lecture Time Collision");
						}
						if (startTime <= checkAcStartTime && endTime >= checkAcEndTime) {
							throw new LectureTimeCollisionException("Lecture Time Collision");
						}
					}
				}
				aC.setLectureDay(day);
				aC.setLectureTime(startTime);
				aC.setLectureDuration(duration);
			}
		}
		if (foundAc == false) {
			throw new UnknownCourseException("Unknown Course: " + courseCode);
		}
	}

	
	
	
	public void clearSchedule(String courseCode)
	{
		boolean foundAc = false;
		for (String courseCodeKey : schedule.keySet()) {
			if (courseCodeKey.equalsIgnoreCase(courseCode)) {
				foundAc = true;
				ActiveCourse aC = schedule.get(courseCodeKey);
				aC.clear();
			}
		}
		if (foundAc = false) {
			throw new UnknownCourseException("Invalid CourseCode");
		}
	}
		
	public void printSchedule()
	{
		String [][] board = new String[10][6];
		board[0][0] = "     ";
		board[0][1] = " Mon ";
		board[0][2] = " Tue ";
		board[0][3] = " Wed ";
		board[0][4] = " Thur ";
		board[0][5] = " Fri ";
		board[1][0] = "0800";
		board[2][0] = "0900";
		board[3][0] = "1000";
		board[4][0] = "1100";
		board[5][0] = "1200";
		board[6][0] = "1300";
		board[7][0] = "1400";
		board[8][0] = "1500";
		board[9][0] = "1600";

		for (String courseCodeKey : schedule.keySet()) {
			ActiveCourse checkAc = schedule.get(courseCodeKey);
			int checkAcStartTime = checkAc.getLectureStart();
			int checkAcLectureDuration = checkAc.getLectureDuration() * 100;
			int checkAcEndTime = checkAcStartTime + checkAcLectureDuration;
			String checkAcLectureDay = checkAc.getLectureDay();
			String checkAcCourseCode = checkAc.getCode();
			int rowStart = 0;
			int rowEnd = 0;
			int col = 0;
			if (checkAcLectureDay.equals("Mon")) {
				col = 1;
			}
			if (checkAcLectureDay.equals("Tue")) {
				col = 2;
			}
			if (checkAcLectureDay.equals("Wed")) {
				col = 3;
			}
			if (checkAcLectureDay.equals("Thur")) {
				col = 4;
			}
			if (checkAcLectureDay.equals("Fri")) {
				col = 5;
			}
			
			if (checkAcStartTime == 800) {
				rowStart = 1;
			}
			if (checkAcStartTime == 900) {
				rowStart = 2;
			} 
			if (checkAcStartTime == 1000) {
				rowStart = 3;
			} 
			if (checkAcStartTime == 1100) {
				rowStart = 4;
			} 
			if (checkAcStartTime == 1200) {
				rowStart = 5;
			} 
			if (checkAcStartTime == 1300) {
				rowStart = 6;
			} 
			if (checkAcStartTime == 1400) {
				rowStart = 7;
			} 
			if (checkAcStartTime == 1500) {
				rowStart = 8;
			} 
			if (checkAcStartTime == 1600) {
				rowStart = 9;
			}


			if (checkAcEndTime == 900) {
				rowEnd = 1;
			} 
			if (checkAcEndTime == 1000) {
				rowEnd = 2;
			} 
			if (checkAcEndTime == 1100) {
				rowEnd = 3;
			} 
			if (checkAcEndTime == 1200) {
				rowEnd = 4;
			} 
			if (checkAcEndTime == 1300) {
				rowEnd = 5;
			} 
			if (checkAcEndTime == 1400) {
				rowEnd = 6;
			} 
			if (checkAcEndTime == 1500) {
				rowEnd = 7;
			} 
			if (checkAcEndTime == 1600) {
				rowEnd = 8;
			}
			if (checkAcEndTime == 1700) {
				rowEnd = 9;
			}

			for (int row = rowStart; row <= rowEnd; row++) {
				if (rowStart == 0 && rowEnd == 0 && col == 0){
					board[row][col] = "      ";
				} else {
					board[row][col] = checkAcCourseCode;
				}
			}
		}

		for(int i = 0; i < board.length; i++) {
		   	for (int y = 0; y < board[i].length; y++) {
				if (board[i][y] == null) {
			   	board[i][y] = "  ";
			   	System.out.print(board[i][y] + "  ");
			 	}
			System.out.print(board[i][y] + "  ");
		   	}
		   	System.out.println("");
		}
	}
}

