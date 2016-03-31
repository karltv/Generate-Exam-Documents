package GenerateExamDocsProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * Update Database class
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class UpdateDatabase {
	private String courseName;
	private int courseID;
	private char section;
	private String month;
	private int day;
	private int year;
	private String weekday;
	private int time;
	private float duration;	
	private String building;
	private int room;
	private int rowNum;
	private int capacity;
	private String instructor;	
	public UpdateDatabase() {
		courseName = null;
		courseID = -1;
		section = ' ';
		month = null;
		day = -1;
		year = -1;
		weekday = null;
		time = -1;
		duration = -1;
		building = null;
		room = -1;
		rowNum = -1;
		capacity = -1;
		instructor = null;		
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}	
	public boolean updateExamInfoDatabase(String courseName, int courseID, char section, String month, int day, int year,
			String weekday, int time, float duration, String building, int room, int row, int capacity,	
			String instructor) {		
	   	try {			
    		Class.forName("org.sqlite.JDBC");
    		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\GenerateDocs\\Info\\data.db");
    		Statement statement = connection.createStatement();    		
    		if(courseName == null) {
    			JOptionPane.showMessageDialog(null, "courseName can not be empty", "alert", JOptionPane.ERROR_MESSAGE);
    			connection.close();
    			return false;
    		}
    		if(courseID == -1) {
    			JOptionPane.showMessageDialog(null, "courseID can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(section == ' ') {
    			JOptionPane.showMessageDialog(null, "section can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(month == null) {
    			JOptionPane.showMessageDialog(null, "month can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(day == -1) {
    			JOptionPane.showMessageDialog(null, "day can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(year == -1) {
    			JOptionPane.showMessageDialog(null, "year can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(weekday == null) {
    			JOptionPane.showMessageDialog(null, "weekday can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(time == -1) {
    			JOptionPane.showMessageDialog(null, "time can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(duration == -1) {
    			JOptionPane.showMessageDialog(null, "duration can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(building == null) {
    			JOptionPane.showMessageDialog(null, "building can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(room == -1) {
    			JOptionPane.showMessageDialog(null, "room can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(rowNum == -1) {
    			JOptionPane.showMessageDialog(null, "row can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(capacity == -1) {
    			JOptionPane.showMessageDialog(null, "capacity can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}
    		if(instructor == null) {
    			JOptionPane.showMessageDialog(null, "instructor can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			connection.close();
    			return false;
    		}    		
    		String sql = "INSERT INTO ExamData " +
                    "VALUES ('" + courseName + "'," + courseID + ",'" + section + "','" + month + "'," + (day==-1 ? null : day) + "," + (day==-1 ? null : year) + ",'" + weekday + "'," + (day==-1 ? null : time) + "," 
                    + (day==-1 ? null : duration) + ",'" + building + "'," + (day==-1 ? null : room) + "," + (day==-1 ? null : row) + "," + (day==-1 ? null : capacity) + ",'" + instructor +"')";  
    		statement.executeUpdate(sql);
    		System.out.println("Database has been successfully updated.");
    		connection.close();  
    		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}    
    	return false;
	}
}
