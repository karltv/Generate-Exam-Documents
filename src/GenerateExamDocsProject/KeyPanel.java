package GenerateExamDocsProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The key panel
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class KeyPanel extends JPanel
{
    public KeyPanel(GenerateDocsControl generateDocsControl, UpdateDataControl updateDataControl)
    {        	
        setLayout(new BorderLayout());              
        JTextField field1 = new JTextField("");
        JTextField field2 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("UserID:"));
        panel.add(field1);
        panel.add(new JLabel("Password:"));
        panel.add(field2);
       int result = JOptionPane.showConfirmDialog(null, panel, "Login Window",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {        	
        	int userID;
        	if(field1.getText().isEmpty()) {
        		userID = -1;
        	} else {
        		userID = Integer.parseInt(field1.getText());
        	}
        	int password;
        	if(field2.getText().isEmpty()) {
        		password = -1;
        	} else {
        		password = Integer.parseInt(field2.getText());
        	}        	
            boolean state = verifyInfo(userID, password);            
            if(!state){
            	if(userID != -1 && password != -1) {
            		JOptionPane.showMessageDialog(null, "Incorrect userID or password", "alert", JOptionPane.ERROR_MESSAGE);
            	}            		
            } 	else {
                Object[] possibleValues = { "Generate Docs", "Update Database"};
                Object selectedValue = JOptionPane.showInputDialog(null,
                        "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);
                if(selectedValue.equals("Update Database")) {
                	FormPanel formPanel = new FormPanel(updateDataControl);
                	updateDataControl.updateExamDatabase(updateDataControl.getUpdateDatabase().getCourseName(),
                			updateDataControl.getUpdateDatabase().getCourseID(),
                			updateDataControl.getUpdateDatabase().getSection(),
                			updateDataControl.getUpdateDatabase().getMonth(),
                			updateDataControl.getUpdateDatabase().getDay(),
                			updateDataControl.getUpdateDatabase().getYear(),
                			updateDataControl.getUpdateDatabase().getWeekday(),
                			updateDataControl.getUpdateDatabase().getTime(),
                			updateDataControl.getUpdateDatabase().getDuration(),
                			updateDataControl.getUpdateDatabase().getBuilding(),
                			updateDataControl.getUpdateDatabase().getRoom(),
                			updateDataControl.getUpdateDatabase().getRowNum(),
                			updateDataControl.getUpdateDatabase().getCapacity(),
                			updateDataControl.getUpdateDatabase().getInstructor());               	
                } else {
                    Object[] possibleValues2 = { "GenerateExamSigningSheet", "GenerateStickerOnEnvelop",
                    							 "GenerateRoomSeatingPlans", "GenerateMasterSeatingPlans"};
                    Object selectedValue2 = JOptionPane.showInputDialog(null,
                            "Choose one", "Input",
                            JOptionPane.INFORMATION_MESSAGE, null,
                            possibleValues2, possibleValues2[0]);
                    if(selectedValue2.equals("GenerateExamSigningSheet")) {
                    	GenForm genForm = new GenForm(generateDocsControl);
                    	generateDocsControl.generateExamSigningSheet(generateDocsControl.getSigningSheet().getCourseName(), 
                    			generateDocsControl.getSigningSheet().getCourseID(), 
                    			generateDocsControl.getSigningSheet().getCourseSection());
                    } else if(selectedValue2.equals("GenerateStickerOnEnvelop")) {
                    	GenForm genForm = new GenForm(generateDocsControl);
                    	generateDocsControl.generateStickerOnEnvelop(generateDocsControl.getStickerOnEnvelop().getCourseName(), 
                    			generateDocsControl.getStickerOnEnvelop().getCourseID(), 
                    			generateDocsControl.getStickerOnEnvelop().getCourseSection());
                    } else if(selectedValue2.equals("GenerateRoomSeatingPlans")) {
                    	GenRoomSeatingForm genRoomSeatingForm = new GenRoomSeatingForm(generateDocsControl);
                    	generateDocsControl.generateRoomSeatingPlans(generateDocsControl.getRoomSeatingPlans().getBuilding(),
                    			generateDocsControl.getRoomSeatingPlans().getMonth(),
                    			generateDocsControl.getRoomSeatingPlans().getDay(), 
                    			generateDocsControl.getRoomSeatingPlans().getYear(), 
                    			generateDocsControl.getRoomSeatingPlans().getTime());
                    	
                    } else if(selectedValue2.equals("GenerateMasterSeatingPlans")) {
                    	GenerateMasterSeatingForm generateMasterSeatingForm = new GenerateMasterSeatingForm(generateDocsControl);
                    	generateDocsControl.generateMasterSeatingPlans(generateDocsControl.getMasterSeatingPlans().getMonth(), 
                    			generateDocsControl.getMasterSeatingPlans().getDay(), 
                    			generateDocsControl.getMasterSeatingPlans().getYear(), 
                    			generateDocsControl.getMasterSeatingPlans().getTime());                    	
                    }
                }     
            }
        } else {
            System.out.println("Cancelled");
        }
    }
    private boolean verifyInfo(int ID, int password) {
    	try {			
    		Class.forName("org.sqlite.JDBC");
    		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/GenerateDocs/Info/data.db");
    		Statement statement = connection.createStatement();    		
        	if(ID == -1) {
        		JOptionPane.showMessageDialog(null, "userID can not be empty", "alert", JOptionPane.ERROR_MESSAGE);
        		connection.close();
        		return false;
        	}         	
        	if(password == -1) {
        		JOptionPane.showMessageDialog(null, "password can not be empty", "alert", JOptionPane.ERROR_MESSAGE);
        		connection.close();
        		return false;
        	}     		
    		String sql = "Select * from LoginData where userID = " + ID;
    		ResultSet resultSet = statement.executeQuery(sql);
    		while(resultSet.next()) {
    			int passwd = Integer.parseInt(resultSet.getString(2));
    			if(passwd == password) {
    				connection.close();
    				resultSet.close();
    				return true;
    			}   
				connection.close();
				resultSet.close();
    			return false;
    		}   		
			connection.close();
			resultSet.close();
    		return false;
		}catch (Exception e) {
			System.out.println("Error:  " + e.getMessage());			
		}
    	return false;    	
    }     
}
