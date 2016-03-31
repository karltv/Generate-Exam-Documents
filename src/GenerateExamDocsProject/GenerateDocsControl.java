package GenerateExamDocsProject;
import javax.swing.JOptionPane;
/**
 * Generate document control
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class GenerateDocsControl {
	private ExamSigningSheet signingSheet;
	private StickerOnEnvelop stickerOnEnvelop;
	private RoomSeatingPlans roomSeatingPlans;
	private MasterSeatingPlans masterSeatingPlans;	
	public GenerateDocsControl() {
		signingSheet = new ExamSigningSheet();
		stickerOnEnvelop = new StickerOnEnvelop();
		roomSeatingPlans = new RoomSeatingPlans();
		masterSeatingPlans = new MasterSeatingPlans();
	}	
	public ExamSigningSheet getSigningSheet() {
		return signingSheet;
	}
	public void setSigningSheet(ExamSigningSheet signingSheet) {
		this.signingSheet = signingSheet;
	}
	public StickerOnEnvelop getStickerOnEnvelop() {
		return stickerOnEnvelop;
	}
	public void setStickerOnEnvelop(StickerOnEnvelop stickerOnEnvelop) {
		this.stickerOnEnvelop = stickerOnEnvelop;
	}
	public RoomSeatingPlans getRoomSeatingPlans() {
		return roomSeatingPlans;
	}
	public void setRoomSeatingPlans(RoomSeatingPlans roomSeatingPlans) {
		this.roomSeatingPlans = roomSeatingPlans;
	}
	public MasterSeatingPlans getMasterSeatingPlans() {
		return masterSeatingPlans;
	}
	public void setMasterSeatingPlans(MasterSeatingPlans masterSeatingPlans) {
		this.masterSeatingPlans = masterSeatingPlans;
	}		
	// Return a String showing that the docs are generated on C:\GenerateDocs directory
	public void generateExamSigningSheet(String courseName, int courseID, char courseSection) {
		signingSheet.setCourseName(courseName);
		signingSheet.setCourseID(courseID);
		signingSheet.setCourseSection(courseSection);
		boolean state = signingSheet.generateSheet();
		if(state) {
			JOptionPane.showMessageDialog(null, "Successfully generated Exam Signing Sheet!   The file is on C:\\GenerateDocs,   go get it!", "Completion", JOptionPane.INFORMATION_MESSAGE);

		}	
	}
	// Return a String showing that the docs are generated on C:\GenerateDocs directory
	public void generateStickerOnEnvelop(String courseName, int courseID, char courseSection) {
		stickerOnEnvelop.setCourseName(courseName);
		stickerOnEnvelop.setCourseID(courseID);
		stickerOnEnvelop.setCourseSection(courseSection);
		boolean state = stickerOnEnvelop.generateSheet();
		if(state) {
			JOptionPane.showMessageDialog(null, "Successfully generated Sticker On Envelop!   The file is on C:\\GenerateDocs,   go get it!", "Completion", JOptionPane.INFORMATION_MESSAGE);
		}	
	}	
	// Return a String showing that the docs are generated on C:\GenerateDocs directory
	public void generateRoomSeatingPlans(String building, String month, int day, int year, int time) {
		roomSeatingPlans.setBuilding(building);
		roomSeatingPlans.setMonth(month);
		roomSeatingPlans.setDay(day);
		roomSeatingPlans.setYear(year);
		roomSeatingPlans.setTime(time);
		boolean state = roomSeatingPlans.generateSheet();
		if(state) {
			JOptionPane.showMessageDialog(null, "Successfully generated Room Seating Plans!   The file is on C:\\GenerateDocs,   go get it!", "Completion", JOptionPane.INFORMATION_MESSAGE);
		}	
	}	
	// Return a String showing that the docs are generated on C:\GenerateDocs directory
	public void generateMasterSeatingPlans(String month, int day, int year, int time) {
		masterSeatingPlans.setMonth(month);
		masterSeatingPlans.setDay(day);
		masterSeatingPlans.setYear(year);
		masterSeatingPlans.setTime(time);
		boolean state = masterSeatingPlans.generateSheet();
		if(state) {
			JOptionPane.showMessageDialog(null, "Successfully generated Master Seating Plans!   The file is on C:\\GenerateDocs,   go get it!", "Completion", JOptionPane.INFORMATION_MESSAGE);
		}	
	}		
}
