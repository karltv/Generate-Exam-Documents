package GenerateExamDocsProject;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * Room Seating Plans class
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class RoomSeatingPlans extends GenDocument {
	private String weekday;
	private String month;
	private int day;
	private int year;
	private int time;
	private String building;
	private int rowNum;
	private int room;
	private String instructor;	
	public RoomSeatingPlans() {
		super();
	}	
	public RoomSeatingPlans(String courseName, int courseID, char courseSection) {
		super(courseName, courseID, courseSection);
	
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
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
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
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public boolean generateSheet() {
    	Statement statement = super.initialize();
    	try {
    		if(getBuilding() == null) {
    			JOptionPane.showMessageDialog(null, "Building can not be empty", "alert", JOptionPane.ERROR_MESSAGE);
    			getConnection().close();
    			return false;
    		}
    		if(getMonth() == null) {
    			JOptionPane.showMessageDialog(null, "Month can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		if(getDay() == -1) {
    			JOptionPane.showMessageDialog(null, "Day can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		if(getYear() == -1) {
    			JOptionPane.showMessageDialog(null, "Year can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		if(getTime() == -1) {
    			JOptionPane.showMessageDialog(null, "Time can not be empty", "alert", JOptionPane.ERROR_MESSAGE); 
    			getConnection().close();
    			return false;
    		}
    		String sql = "Select courseName, courseID, section, month, day, year, weekday, time, building, room, row, instructor from ExamData"
    				+ " where building = '" + getBuilding() + "' AND month = '" + getMonth() + "' AND day =" + getDay() + " AND time =" + getTime() +";";
    		ResultSet resultSet = statement.executeQuery(sql);    		
    		if(!generateTable(resultSet)) {
    			JOptionPane.showMessageDialog(null, "This is  no this data in the Database", "alert", JOptionPane.ERROR_MESSAGE); 
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
    public boolean generateTable(ResultSet set) {
        try {      	
            String filename = "C:/GenerateDocs/GenerateRoomSeatingPlans.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue(" ");
            rowhead.createCell(1).setCellValue(" ");
            rowhead.createCell(2).setCellValue(getBuilding());
            rowhead.createCell(3).setCellValue("Building");
            rowhead.createCell(4).setCellValue("Examination");            
            rowhead.createCell(5).setCellValue("Seating");            
            rowhead.createCell(6).setCellValue("Plan");
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
            row2.createCell(1).setCellValue("CourseID");
            row2.createCell(2).setCellValue("Section");
            row2.createCell(3).setCellValue("Weekday");
            row2.createCell(4).setCellValue("Building");
            row2.createCell(5).setCellValue("Room/Row");
            row2.createCell(6).setCellValue("Instructor"); 
            int i = 3;
            while(set.next()) {
	            setCourseName(set.getString(1));
	            setCourseID(Integer.parseInt(set.getString(2)));
	            setCourseSection(set.getString(3).charAt(0));
         		this.month = set.getString(4);
	    		this.day = Integer.parseInt(set.getString(5));
	    		this.year = Integer.parseInt(set.getString(6));
	    		this.weekday = set.getString(7);
	    		this.time = Integer.parseInt(set.getString(8));
	    		this.building = set.getString(9);
	    		if(set.getString(10) == null) {
	    			this.room = -1;
	    		} else {
	    			this.room = Integer.parseInt(set.getString(10));
	    		}
	    		if(set.getString(11) == null) {
	    			this.rowNum = -1;
	    		} else {
	    			this.rowNum = Integer.parseInt(set.getString(11));
	    		}
	    		this.instructor = set.getString(12);
	    		
                row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(getCourseName());            
                row.createCell(1).setCellValue(getCourseID());            
                row.createCell(2).setCellValue(String.valueOf(getCourseSection()));
                row.createCell(3).setCellValue(getWeekday());
                row.createCell(4).setCellValue(getBuilding());
                row.createCell(5).setCellValue(this.room == -1? getRowNum() : getRoom());
                row.createCell(6).setCellValue(getInstructor());
                i++;
            }     
            if(i == 3) {
    			workbook.close();
    			return false;
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
            return true;
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return false;
    }
}
