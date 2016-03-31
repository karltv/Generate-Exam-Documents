package GenerateExamDocsProject;
import java.awt.*;
import javax.swing.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Generate Examination Documents Form
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */	
public class GenForm {
	    private GenerateDocsControl generateDocsControl;
	    public GenForm(GenerateDocsControl generateDocsControl) { 	    		
            this.generateDocsControl = generateDocsControl;
            JPanel msgPanel = new JPanel(new GridLayout(0, 1));
            msgPanel.add(new JLabel("Please Fill Form. \n courseName, courseID, section can not be empty!"));
	        JTextField field1 = new JTextField("");
	        JTextField field2 = new JTextField("");
	        JTextField field3 = new JTextField("");	        
	        JPanel panel = new JPanel(new GridLayout(0, 2));
	        panel.add(new JLabel("courseName:"));
	        panel.add(field1);
	        panel.add(new JLabel("courseID:"));
	        panel.add(field2);
	        panel.add(new JLabel("section:"));
	        panel.add(field3);
	     	msgPanel.add(panel);        
	       int result = JOptionPane.showConfirmDialog(null, msgPanel, "Generate Docs Form",
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
	        	generateDocsControl.getSigningSheet().setCourseName(courseName);
	        	generateDocsControl.getSigningSheet().setCourseID(courseID);
	        	generateDocsControl.getSigningSheet().setCourseSection(section);	   	        
	        	generateDocsControl.getStickerOnEnvelop().setCourseName(courseName);
	        	generateDocsControl.getStickerOnEnvelop().setCourseID(courseID);
	        	generateDocsControl.getStickerOnEnvelop().setCourseSection(section);
	        } else {
	            System.out.println("Cancelled");
	        }
	    }	    
}

