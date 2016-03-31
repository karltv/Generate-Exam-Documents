package GenerateExamDocsProject;
import javax.swing.JOptionPane;
/**
 * Update database control
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class UpdateDataControl {
	private UpdateDatabase updateDatabase;	
	public UpdateDataControl() {
		updateDatabase = new UpdateDatabase();		
	}
	public UpdateDatabase getUpdateDatabase() {
		return updateDatabase;
	}
	public void setUpdateDatabase(UpdateDatabase updateDatabase) {
		this.updateDatabase = updateDatabase;
	}	
	public void updateExamDatabase(String courseName, int courseID, char section, String month, int day, int year,
			String weekday, int time, float duration, String building, int room, int row, int capacity,	
			String instructor) {		
		boolean state = updateDatabase.updateExamInfoDatabase(courseName, courseID, section, month, day, year,
				weekday, time, duration, building, room, row, capacity,	
				instructor);
        if(state) {
        	JOptionPane.showMessageDialog(null, "Successfully update the Exam Database!", "Completion", JOptionPane.INFORMATION_MESSAGE);
        }
	}	
}
