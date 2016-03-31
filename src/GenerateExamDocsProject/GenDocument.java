package GenerateExamDocsProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;
/**
 * The general document class
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class GenDocument {
	private String courseName;
	private int courseID;
	private char courseSection;
	Connection connection;	
	public GenDocument() {
		this.courseName = "ECOR";
		this.courseID = 2606;
		this.courseSection = 'A';
	}	
	public GenDocument(String courseName, int courseID, char courseSection) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseSection = courseSection;
	}	
	public String getCourseName() {
		return courseName;
	}	
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}	
	public int getCourseID() {
		return courseID;
	}	
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}	
	public char getCourseSection() {
		return courseSection;
	}	
	public void setCourseSection(char section) {
		this.courseSection = section;
	}	
	public Connection getConnection() {
		return connection;
	}	
	public Statement initialize() {
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC"); //
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\GenerateDocs\\Info\\data.db");
			statement = connection.createStatement();
			return statement;
		} catch (Exception e) {
			e.printStackTrace();;
		}
        return statement;
	}
}
