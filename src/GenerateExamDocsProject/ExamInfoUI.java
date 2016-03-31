package GenerateExamDocsProject;
import javax.swing.JFrame;

/**
 * Examination Information User Interface
 * 
 * @author Zhiheng (David) Li
 * March 16, 2016
 */
public class ExamInfoUI
{
   /**
    * Creates and displays the main program frame.
    */
   public static void main(String[] args)
   {
	   GenerateDocsControl generateDocsControl = new GenerateDocsControl();
	   UpdateDataControl updateDataControl = new UpdateDataControl();	   
	   KeyPanel panel = new KeyPanel(generateDocsControl, updateDataControl);
   }
}
