package GenerateExamDocsProject;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * Examination Update Form
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class FormPanel extends JPanel
{
    public FormPanel(UpdateDataControl updateDataControl)
    {    
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));        
        JTextArea textArea = new JTextArea("Please Fill Form. \n courseName, courseID, section, month, day, \n year, weekday, time,"
        		+ "duration, building, room(or row), \n capcity and instructor can not be empty!", 5, 20);
        textArea.setEditable(false);
        mainPanel.add(textArea);
        mainPanel.add(new JLabel(" "));
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JTextField field3 = new JTextField("");
        JTextField field4 = new JTextField("");
        JTextField field5 = new JTextField("");
        JTextField field6 = new JTextField("");
        JTextField field7 = new JTextField("");
        JTextField field8 = new JTextField("");
        JTextField field9 = new JTextField("");
        JTextField field10 = new JTextField("");
        JTextField field11 = new JTextField("");
        JTextField field12 = new JTextField("");
        JTextField field13 = new JTextField("");
        JTextField field14 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("courseName:"));
        panel.add(field1);
        panel.add(new JLabel("courseID:"));
        panel.add(field2);
        panel.add(new JLabel("section:"));
        panel.add(field3);
        panel.add(new JLabel("month:"));
        panel.add(field4);
        panel.add(new JLabel("day:"));
        panel.add(field5);
        panel.add(new JLabel("year:"));
        panel.add(field6);
        panel.add(new JLabel("weekday:"));
        panel.add(field7);
        panel.add(new JLabel("time:"));
        panel.add(field8);
        panel.add(new JLabel("duration:"));
        panel.add(field9);
        panel.add(new JLabel("building:"));
        panel.add(field10);
        panel.add(new JLabel("room:"));
        panel.add(field11);
        panel.add(new JLabel("row:"));
        panel.add(field12);
        panel.add(new JLabel("capacity:"));
        panel.add(field13);
        panel.add(new JLabel("instructor:"));
        panel.add(field14);
        mainPanel.add(panel, BorderLayout.WEST); 
        textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        int result = JOptionPane.showConfirmDialog(null, mainPanel, "Update Database Form",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {            
        	String courseName;
        	if(field1.getText().isEmpty()) {
        		courseName = null;
        	} else {
        		courseName = field1.getText();
        	}            
    		int courseID;
        	if(field2.getText().isEmpty()) {
        		courseID = -1;
        	} else {
        		courseID = Integer.parseInt(field2.getText());
        	}    		
    		char section;
        	if(field3.getText().isEmpty()) {
        		section = ' ';
        	} else {
        		section = field3.getText().charAt(0);
        	}    		
    		String month;
    		if(field4.getText().isEmpty()) {
    			month = null;
    		} else {
    			month = field4.getText();
    		}   		
    		int day; 
    		if(field5.getText().isEmpty()) {
    			day = -1;
    		} else {
    			day = Integer.parseInt(field5.getText());
    		}    		
    		int year;
    		if(field6.getText().isEmpty()) {
    			year = -1;
    		} else {
    			year = Integer.parseInt(field6.getText());
    		}    		
    		String weekday; 
    		if(field7.getText().isEmpty()) {
    			weekday = null;
    		} else {
    			weekday = field7.getText();
    		}    		
    		int time;
    		if(field8.getText().isEmpty()) {
    			time = -1;
    		} else {
    			time = Integer.parseInt(field8.getText());
    		}    		
    		float duration;
    		if(field9.getText().isEmpty()) {
    			duration = -1;
    		} else {
    			duration = Float.parseFloat(field9.getText());
    		}   		
    		String building; 
    		if(field10.getText().isEmpty()) {
    			building = null;
    		} else {
    			building = field10.getText();
    		}    		
    		int room;
    		if(field11.getText().isEmpty()) {
    			room = -1;
    		} else {
    			room = Integer.parseInt(field11.getText());
    		}    		
    		int row;
    		if(field12.getText().isEmpty()) {
    			row = -1;
    		} else {
    			row = Integer.parseInt(field12.getText());
    		}    		
    		int capacity;
    		if(field13.getText().isEmpty()) {
    			capacity = -1;
    		} else {
    			capacity = Integer.parseInt(field13.getText());  
    		}    		
    		String instructor; 
    		if(field14.getText().isEmpty()) {
    			instructor = null;
    		} else {
    			instructor = field14.getText();
    		}    
    		updateDataControl.getUpdateDatabase().setCourseName(courseName);
    		updateDataControl.getUpdateDatabase().setCourseID(courseID);
    		updateDataControl.getUpdateDatabase().setSection(section);
    		updateDataControl.getUpdateDatabase().setMonth(month);
    		updateDataControl.getUpdateDatabase().setDay(day);
    		updateDataControl.getUpdateDatabase().setYear(year);
    		updateDataControl.getUpdateDatabase().setWeekday(weekday);
    		updateDataControl.getUpdateDatabase().setTime(time);
    		updateDataControl.getUpdateDatabase().setDuration(duration);
    		updateDataControl.getUpdateDatabase().setBuilding(building);
    		updateDataControl.getUpdateDatabase().setRoom(room);
    		updateDataControl.getUpdateDatabase().setRowNum(row);
    		updateDataControl.getUpdateDatabase().setCapacity(capacity);
    		updateDataControl.getUpdateDatabase().setInstructor(instructor);  
        } else {
            System.out.println("Cancelled");
        }
    }     
}
