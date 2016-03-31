package GenerateExamDocsProject;
import java.awt.*;
import javax.swing.*;

/**
 * Generate Room Seating Plans Form
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */	
public class GenRoomSeatingForm {
	    private GenerateDocsControl generateDocsControl;
	    public GenRoomSeatingForm(GenerateDocsControl generateDocsControl) {   	    		
            this.generateDocsControl = generateDocsControl;
            JPanel msgPanel = new JPanel(new GridLayout(0, 1));
            msgPanel.add(new JLabel("Please Fill Form.  \n Building, Month, Day, Year and Time can not be empty!"));
	        JTextField field1 = new JTextField("");
	        JTextField field2 = new JTextField("");
	        JTextField field3 = new JTextField("");
	        JTextField field4 = new JTextField("");
	        JTextField field5 = new JTextField("");	        
	        JPanel panel = new JPanel(new GridLayout(0, 2));
	        panel.add(new JLabel("Building:"));
	        panel.add(field1);
	        panel.add(new JLabel("Month:"));
	        panel.add(field2);
	        panel.add(new JLabel("Day:"));
	        panel.add(field3);
	        panel.add(new JLabel("Year:"));
	        panel.add(field4);
	        panel.add(new JLabel("Time:"));
	        panel.add(field5);    
	     	msgPanel.add(panel);        
	       int result = JOptionPane.showConfirmDialog(null, msgPanel, "Generate Room Seating Form",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {	            
	        	String building;
	        	if(field1.getText().isEmpty()) {
	        		building = null;
	        	} else {
	        		building = field1.getText();
	        	}	 	        	
	        	String month;
	        	if(field2.getText().isEmpty()) {
	        		month = null;
	        	} else {
	        		month = field2.getText();
	        	}	            
	    		int day;
	        	if(field3.getText().isEmpty()) {
	        		day = -1;
	        	} else {
	        		day = Integer.parseInt(field3.getText());
	        	}	    		
	    		int year;
	        	if(field4.getText().isEmpty()) {
	        		year = -1;
	        	} else {
	        		year = Integer.parseInt(field4.getText());
	        	}	        	
	    		int time;
	        	if(field5.getText().isEmpty()) {
	        		time = -1;
	        	} else {
	        		time = Integer.parseInt(field5.getText());
	        	}	        	
	        	generateDocsControl.getRoomSeatingPlans().setBuilding(building);
	        	generateDocsControl.getRoomSeatingPlans().setMonth(month);
	        	generateDocsControl.getRoomSeatingPlans().setDay(day);
	        	generateDocsControl.getRoomSeatingPlans().setYear(year);
	        	generateDocsControl.getRoomSeatingPlans().setTime(time);
	        } else {
	            System.out.println("Cancelled");
	        }
	    }
}

