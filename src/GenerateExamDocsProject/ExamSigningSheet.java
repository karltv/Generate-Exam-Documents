package GenerateExamDocsProject;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * Examination Signing Sheet
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class ExamSigningSheet extends GenDocument {
	private String weekday;
	private String month;
	private int day;
	private int year;
	private int time;
	private String building;
	private int rowNum;
	private int room;	
	public ExamSigningSheet() {
		super();
	}	
	public ExamSigningSheet(String courseName, int courseID, char courseSection) {
		super(courseName, courseID, courseSection);
	
	}	
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public boolean generateSheet() {
    	Statement statement = super.initialize();
    	try {
    		if(getCourseName() == null) {
    			JOptionPane.showMessageDialog(null, "courseName can not be empty", "alert", JOptionPane.ERROR_MESSAGE);
    			getConnection().close();
    			return false;
    		}
    		if(getCourseID() == -1) {
    			JOptionPane.showMessageDialog(null, "courseID can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		if(getCourseSection() == ' ') {
    			JOptionPane.showMessageDialog(null, "section can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		String sql = "Select courseName, courseID, section, month, day, year, weekday, time, building, room, row from ExamData"
    				+ " where courseName = '" + getCourseName() + "' AND courseID = " + getCourseID() + " AND section ='" + getCourseSection() + "';";
    		ResultSet resultSet = statement.executeQuery(sql);    		
            if(resultSet.next()) {	            
         		this.month = resultSet.getString(4);
	    		this.day = Integer.parseInt(resultSet.getString(5));
	    		this.year = Integer.parseInt(resultSet.getString(6));
	    		this.weekday = resultSet.getString(7);
	    		this.time = Integer.parseInt(resultSet.getString(8));
	    		this.building = resultSet.getString(9);
	    		if(resultSet.getString(10) == null) {
	    			this.room = -1;
	    		} else {
	    			this.room = Integer.parseInt(resultSet.getString(10));
	    		}
	    		if(resultSet.getString(11) == null) {
	    			this.rowNum = -1;
	    		} else {
	    			this.rowNum = Integer.parseInt(resultSet.getString(11));
	    		}
	    		generateTable();
            } else {
            	JOptionPane.showMessageDialog(null, "There is no this data in the Database!", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
            }    		
    		getConnection().close();
    		resultSet.close();
    		return true;    		
		} catch (Exception e) {
			System.out.println("Error:  " + e.getMessage());			
		}    	
    	return false;    	
    }
    public void generateTable() {
        try {      	
            String filename = "C:/GenerateDocs/GenerateExamSigningSheet.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue(" ");
            rowhead.createCell(1).setCellValue(" ");
            rowhead.createCell(2).setCellValue(" ");
            rowhead.createCell(3).setCellValue(" ");
            rowhead.createCell(4).setCellValue("Examination");            
            rowhead.createCell(5).setCellValue("Signing");            
            rowhead.createCell(6).setCellValue("Sheet");
            rowhead.createCell(7).setCellValue(" ");
            rowhead.createCell(8).setCellValue(" ");
            rowhead.createCell(9).setCellValue(" ");
            rowhead.createCell(10).setCellValue(" ");
            rowhead.createCell(11).setCellValue(" ");
            rowhead.createCell(12).setCellValue(" ");
            rowhead.createCell(13).setCellValue(" ");   
            HSSFRow row = sheet.createRow((short)1);
		    row.createCell(0).setCellValue("Date");            
            row.createCell(1).setCellValue(weekday);            
            row.createCell(2).setCellValue(month);
            row.createCell(3).setCellValue(day);
            row.createCell(4).setCellValue(year);
            row.createCell(5).setCellValue("Time");
            row.createCell(6).setCellValue(time);
            row.createCell(7).setCellValue(" ");
            row.createCell(8).setCellValue(" ");
            row.createCell(9).setCellValue(" ");            
            row.createCell(10).setCellValue(" ");            
            row.createCell(11).setCellValue(" ");
            row.createCell(12).setCellValue(" ");
            row.createCell(13).setCellValue(" ");            
            HSSFRow row2 = sheet.createRow((short)2);
            row2.createCell(0).setCellValue("Course");            
            row2.createCell(1).setCellValue(getCourseName());
            row2.createCell(2).setCellValue(getCourseID());
            row2.createCell(3).setCellValue(getCourseSection());
            row2.createCell(4).setCellValue(" ");
            row2.createCell(5).setCellValue(" ");
            row2.createCell(6).setCellValue(" ");
            row2.createCell(7).setCellValue(" ");
            row2.createCell(8).setCellValue(" ");
            row2.createCell(9).setCellValue(" ");
            row2.createCell(10).setCellValue(" ");
            row2.createCell(11).setCellValue(" ");
            row2.createCell(12).setCellValue(" ");
            row2.createCell(13).setCellValue(" ");	
            row = sheet.createRow((short)3);
            row.createCell(0).setCellValue("Room");            
            row.createCell(1).setCellValue(building);            
            row.createCell(2).setCellValue(room == -1? "Row":"Room");
            row.createCell(3).setCellValue(room == -1? rowNum : room);
            row.createCell(4).setCellValue(" ");
            row.createCell(5).setCellValue(" ");
            row.createCell(6).setCellValue(" ");
            row.createCell(7).setCellValue(" ");
            row.createCell(8).setCellValue(" ");
            row.createCell(9).setCellValue(" ");
            row.createCell(10).setCellValue(" ");
            row.createCell(11).setCellValue(" ");
            row.createCell(12).setCellValue(" ");
            row.createCell(13).setCellValue(" ");	           
            row = sheet.createRow((short)4);
            row.createCell(0).setCellValue(" ");            
            row.createCell(1).setCellValue("ID");            
            row.createCell(2).setCellValue("Student's Signature");
            row.createCell(3).setCellValue("Print Name Clearly");
            row.createCell(4).setCellValue("Student#");
            row.createCell(5).setCellValue("(last");
            row.createCell(6).setCellValue("4 digits)");
            row.createCell(7).setCellValue("Receipt");
            row.createCell(8).setCellValue("Answer");
            row.createCell(9).setCellValue("Book");
            row.createCell(10).setCellValue(" ");
            row.createCell(11).setCellValue(" ");
            row.createCell(12).setCellValue(" ");
            row.createCell(13).setCellValue(" ");              
            for(int i = 5; i < 35; i++) {
                row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(" " + (i-4));            
                row.createCell(1).setCellValue(" ");            
                row.createCell(2).setCellValue(" ");
                row.createCell(3).setCellValue(" ");
                row.createCell(4).setCellValue("x");
                row.createCell(5).setCellValue("x");
                row.createCell(6).setCellValue("x");
                row.createCell(7).setCellValue("x");
                row.createCell(8).setCellValue("x");
                row.createCell(9).setCellValue(" ");
                row.createCell(10).setCellValue(" ");
                row.createCell(11).setCellValue(" ");
                row.createCell(12).setCellValue(" ");
                row.createCell(13).setCellValue(" ");  
            }            
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }    
    }	
}
