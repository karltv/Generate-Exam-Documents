package GenerateExamDocsProject;
import java.awt.*;
import javax.swing.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Tests {
	String courseName = null;
	int courseID = -1;
	char courseSection= ' ';	
	String weekday = "Wednesday";
	String month = "December";
	int day = 16;
	int year= 2015;
	int time= 900;
	String building = "AT";
	int rowNum= -1;
	int room = 111;	
	float duration = (float) 3.0;
	int capacity = 20;
	
//---------------------------------------------------------------	
/*
	@Test
	public void testExamSigningSheet() {
		
		ExamSigningSheet signingsheet = new ExamSigningSheet(courseName, courseID, courseSection);

		signingsheet.setWeekday(weekday);
		String a = signingsheet.getWeekday();
		assertEquals(a,"Wednesday");
		
		signingsheet.setMonth(month);
		String b = signingsheet.getMonth();
		assertEquals(b,"December");
		
		signingsheet.setDay(day);	
		int c = signingsheet.getDay();
		assertEquals(c,16);
		
		signingsheet.setYear(year);	
		int d = signingsheet.getYear();
		assertEquals(d,2015);
		
		signingsheet.setTime(time);	
		int e = signingsheet.getTime();
		assertEquals(e,900);
		
		signingsheet.setBuilding(building);
		String f = signingsheet.getBuilding();
		assertEquals(f,"AT");
		
		signingsheet.setRowNum(rowNum);	
		int g = signingsheet.getRowNum();
		assertEquals(g,-1);
		
		signingsheet.setRoom(room);	
		int h = signingsheet.getRoom();
		assertEquals(h,111);
		
		//null course
		boolean x = signingsheet.generateSheet();	
		assertEquals(x,false);
		
		//incorect courseID
		String courseName = "ECOR";
		ExamSigningSheet signingsheet2 = new ExamSigningSheet(courseName, courseID, courseSection);
		boolean x1 = signingsheet2.generateSheet();	
		assertEquals(x1,false);	
		
		//incorrect courseSection
		int courseID = 2606;
		ExamSigningSheet signingsheet3 = new ExamSigningSheet(courseName, courseID, courseSection);
		boolean x2 = signingsheet3.generateSheet();	
		assertEquals(x2,false);	
		
		//else branch
		char courseSection= 'A';
		ExamSigningSheet signingsheet4 = new ExamSigningSheet(courseName, courseID, courseSection);
		boolean x3 = signingsheet4.generateSheet();	
		
		//course is not in the list
		String courseName2 = "AAAA";
		ExamSigningSheet signingsheet5 = new ExamSigningSheet(courseName2, courseID, courseSection);
		boolean x4 = signingsheet5.generateSheet();
		assertEquals(x4,false);	
		
	}
	
//---------------------------------------------------------------
	
	@Test
	public void testGenDocument() {
		
		GenDocument doc = new GenDocument();
		String a1 = doc.getCourseName();	
		assertEquals(a1,"ECOR");
		
		int b1 = doc.getCourseID();	
		assertEquals(b1,2606);
		
		char c1 = doc.getCourseSection();	
		assertEquals(c1,'A');
		
		String courseName2 = "AERO";
		int courseID2 = 3240;
		char courseSection2= 'A';
		
		GenDocument doc2 = new GenDocument(courseName2,courseID2,courseSection2);
		doc.setCourseName(courseName2);
		String a2 = doc2.getCourseName();	
		assertEquals(a2,"AERO");
		
		doc.setCourseID(courseID2);
		int b2 = doc2.getCourseID();	
		assertEquals(b2,3240);
		
		doc.setCourseSection(courseSection2);
		char c2 = doc2.getCourseSection();	
		assertEquals(c2,'A');
		
	}

//---------------------------------------------------------------
	
	@Test
	public void testMasterSeatingPlans() {
		
		String instructor = "Mike"; 
		
		MasterSeatingPlans MSP = new MasterSeatingPlans(courseName, courseID, courseSection);
		
		
		MSP.setWeekday(weekday);
		String a5 = MSP.getWeekday();
		assertEquals(a5,"Wednesday");
		
		MSP.setMonth(month);
		String b5 = MSP.getMonth();
		assertEquals(b5,"December");
		
		MSP.setDay(day);	
		int c5 = MSP.getDay();
		assertEquals(c5,16);
		
		MSP.setYear(year);	
		int d5 = MSP.getYear();
		assertEquals(d5,2015);
		
		MSP.setTime(time);	
		int e5 = MSP.getTime();
		assertEquals(e5,900);
		
		MSP.setBuilding(building);
		String f5 = MSP.getBuilding();
		assertEquals(f5,"AT");
		
		MSP.setRowNum(rowNum);	
		int g5 = MSP.getRowNum();
		assertEquals(g5,-1);
		
		MSP.setRoom(room);	
		int h5 = MSP.getRoom();
		assertEquals(h5,111);
		
		MSP.setInstructor(instructor);	
		String i5 = MSP.getInstructor();
		assertEquals(i5,"Mike");
		
		
		
		MSP.setMonth(null);
		boolean x = MSP.generateSheet();	
		assertEquals(x,false);
		
		
		MSP.setMonth("December");
		MSP.setDay(-1);
		boolean x1 = MSP.generateSheet();	
		assertEquals(x1,false);
		
		MSP.setDay(16);
		MSP.setYear(-1);
		boolean x2 = MSP.generateSheet();	
		assertEquals(x2,false);
		
		
		MSP.setYear(2015);
		MSP.setTime(-1);
		boolean x3 = MSP.generateSheet();	
		assertEquals(x3,false);
		
		
		//set invalid time
		MSP.setTime(1800);
		boolean x4 = MSP.generateSheet();
		assertEquals(x3,false);
		
		//set valid date
		MSP.setTime(900);
		boolean x5 = MSP.generateSheet();
		
		
			
	}
	
//---------------------------------------------------------------	
	
	@Test
	public void testRoomSeatingPlans() {
		
		String instructor = "Mike"; 
		
		RoomSeatingPlans RSP = new RoomSeatingPlans(courseName, courseID, courseSection);
		
		
		RSP.setWeekday(weekday);
		String a4 = RSP.getWeekday();
		assertEquals(a4,"Wednesday");
		
		RSP.setMonth(month);
		String b4 = RSP.getMonth();
		assertEquals(b4,"December");
		
		RSP.setDay(day);	
		int c4 = RSP.getDay();
		assertEquals(c4,16);
		
		RSP.setYear(year);	
		int d4 = RSP.getYear();
		assertEquals(d4,2015);
		
		RSP.setTime(time);	
		int e4 = RSP.getTime();
		assertEquals(e4,900);
		
		RSP.setBuilding(building);
		String f4 = RSP.getBuilding();
		assertEquals(f4,"AT");
		
		RSP.setRowNum(rowNum);	
		int g4 = RSP.getRowNum();
		assertEquals(g4,-1);
		
		RSP.setRoom(room);	
		int h4 = RSP.getRoom();
		assertEquals(h4,111);
		
		RSP.setInstructor(instructor);	
		String i4 = RSP.getInstructor();
		assertEquals(i4,"Mike");
		
		
		RSP.setBuilding(null);
		boolean x0 = RSP.generateSheet();	
		assertEquals(x0,false);
		
		RSP.setBuilding("AT");
		RSP.setMonth(null);
		boolean x = RSP.generateSheet();	
		assertEquals(x,false);
		
		
		RSP.setMonth("December");
		RSP.setDay(-1);
		boolean x1 = RSP.generateSheet();	
		assertEquals(x1,false);
		
		RSP.setDay(16);
		RSP.setYear(-1);
		boolean x2 = RSP.generateSheet();	
		assertEquals(x2,false);
		
		
		RSP.setYear(2015);
		RSP.setTime(-1);
		boolean x3 = RSP.generateSheet();	
		assertEquals(x3,false);
		
		
		//set invalid time
		RSP.setTime(1800);
		boolean x4 = RSP.generateSheet();
		assertEquals(x3,false);
		
		//set valid date
		RSP.setTime(900);
		boolean x5 = RSP.generateSheet();
		
			}

	//---------------------------------------------------------------
	
	@Test
	public void testStickerOnEnvelop() {
		
		float duration = (float) 3.0; 
		
		StickerOnEnvelop SOE = new StickerOnEnvelop(courseName, courseID, courseSection);
		
		
		SOE.setWeekday(weekday);
		String a3 = SOE.getWeekday();
		assertEquals(a3,"Wednesday");
		
		SOE.setMonth(month);
		String b3 = SOE.getMonth();
		assertEquals(b3,"December");
		
		SOE.setDay(day);	
		int c3 = SOE.getDay();
		assertEquals(c3,16);
		
		SOE.setYear(year);	
		int d3 = SOE.getYear();
		assertEquals(d3,2015);
		
		SOE.setTime(time);	
		int e3 = SOE.getTime();
		assertEquals(e3,900);
		
		SOE.setBuilding(building);
		String f3 = SOE.getBuilding();
		assertEquals(f3,"AT");
			
		SOE.setRowNum(rowNum);	
		int g3 = SOE.getRowNum();
		assertEquals(g3,-1);
		
		SOE.setRoom(room);	
		int h3 = SOE.getRoom();
		assertEquals(h3,111);
		
		SOE.setDuration(duration);	
		float i3 = SOE.getDuration();
		assertEquals(i3, 3.0, 0.0001);
		
	
		//null course
		boolean x = SOE.generateSheet();	
		assertEquals(x,false);
		
		//incorect courseID
		String courseName = "ECOR";
		StickerOnEnvelop SOE2 = new StickerOnEnvelop(courseName, courseID, courseSection);
		boolean x1 = SOE2.generateSheet();	
		assertEquals(x1,false);	
		
		//incorrect courseSection
		int courseID = 2606;
		StickerOnEnvelop SOE3 = new StickerOnEnvelop(courseName, courseID, courseSection);
		boolean x2 = SOE3.generateSheet();	
		assertEquals(x2,false);	
		
		//generate sheet with valid arguments
		char courseSection= 'A';
		StickerOnEnvelop SOE4 = new StickerOnEnvelop(courseName, courseID, courseSection);
		boolean x3 = SOE4.generateSheet();
		
		
		//course is not in the list
		String courseName2 = "AAAA";
		StickerOnEnvelop SOE5 = new StickerOnEnvelop(courseName2, courseID, courseSection);
		boolean x4 = SOE5.generateSheet();
		assertEquals(x4,false);	
	
	}
	
	//---------------------------------------------------------------
	
	@Test
	public void testUpdateDatabase() {
		
		String instructor = "Mike"; 
		
		UpdateDatabase UD = new UpdateDatabase();
		
		String a1 = UD.getCourseName();	
		assertEquals(a1,courseName);
		
		int b1 = UD.getCourseID();	
		assertEquals(b1,courseID);
		
		char c1 = UD.getSection();	
		assertEquals(c1,courseSection);
		
		String courseName2 = "AERO";
		int courseID2 = 3240;
		char courseSection2= 'A';
		
		UpdateDatabase UD2 = new UpdateDatabase();
		UD2.setCourseName(courseName2);
		String a2 = UD2.getCourseName();	
		assertEquals(a2,"AERO");
		
		UD2.setCourseID(courseID2);
		int b2 = UD2.getCourseID();	
		assertEquals(b2,3240);
		
		UD2.setSection(courseSection2);
		char c2 = UD2.getSection();	
		assertEquals(c2,'A');
		
		UD2.setWeekday(weekday);
		String a5 =UD2.getWeekday();
		assertEquals(a5,"Wednesday");
		
		UD2.setMonth(month);
		String b5 = UD2.getMonth();
		assertEquals(b5,"December");
		
		UD2.setDay(day);	
		int c5 = UD2.getDay();
		assertEquals(c5,16);
		
		UD2.setYear(year);	
		int d5 = UD2.getYear();
		assertEquals(d5,2015);
		
		UD2.setTime(time);	
		int e5 = UD2.getTime();
		assertEquals(e5,900);
		
		UD2.setBuilding(building);
		String f5 = UD2.getBuilding();
		assertEquals(f5,"AT");
		
		UD2.setRowNum(rowNum);	
		int g5 = UD2.getRowNum();
		assertEquals(g5,-1);
		
		UD2.setRoom(room);	
		int h5 = UD2.getRoom();
		assertEquals(h5,111);
		
		UD2.setInstructor(instructor);	
		String i5 = UD2.getInstructor();
		assertEquals(i5,"Mike");
		
		UD2.setDuration(duration);	
		float j5 = UD2.getDuration();
		assertEquals(j5,3.0, 0.01);
		
		UD2.setCapacity(capacity);	
		int k5 = UD2.getCapacity();
		assertEquals(k5,20);
		
		
		UpdateDatabase UD3 = new UpdateDatabase();
		String courseName = "AERO";
		int courseID = 3240;
		char courseSection= 'A';
		float duration = (float)3.0;
		int capacity = 20;
		char section = 'A';
		String instructor2 = "Ulrich";
		int rowNum= 2;
		int room = 111;
		//UD3.updateExamInfoDatabase(courseName,courseID,section,month,day,year,weekday,time,duration,building,room,rowNum,capacity,instructor2);
		
		
		int courseID3 = -1;
		boolean b7 = UD3.updateExamInfoDatabase(courseName,courseID3,courseSection,month,day,year,weekday,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(b7,false);
		
		char courseSection3= ' ';	
		boolean c7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection3,month,day,year,weekday,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(c7,false);	
		
		String month2 = null;
		boolean e7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month2,day,year,weekday,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(e7,false);	
		
		int day2 = -1;
		boolean f7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day2,year,weekday,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(f7,false);	
		
		int year2= -1;
		boolean g7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year2,weekday,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(g7,false);	
		
		String weekday2 = null;
		boolean d7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday2,time,duration,building,room,rowNum,capacity,instructor);
		assertEquals(d7,false);	
		
		int time2= -1;
		boolean h7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time2,duration,building,room,rowNum,capacity,instructor);
		assertEquals(h7,false);	
		
		float duration2 = (float) -1;
		boolean l7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration2,building,room,rowNum,capacity,instructor);
		assertEquals(l7,false);	
		
		String building2 = null;
		boolean i7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration,building2,room,rowNum,capacity,instructor);
		assertEquals(i7,false);	
		
		int rowNum2= -1;
		boolean j7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration,building,room,rowNum2,capacity,instructor);
		assertEquals(j7,false);	
		UD3.setRowNum(2);
		
		int room2 = -1;	
		boolean k7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration,building,room2,rowNum,capacity,instructor);
		assertEquals(k7,false);	
		
		int capacity2 = -1;
		boolean m7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration,building,room,rowNum,capacity2,instructor);
		assertEquals(m7,false);	
		
		String instructor3 = null;
		boolean n7 = UD3.updateExamInfoDatabase(courseName,courseID,courseSection,month,day,year,weekday,time,duration,building,room,rowNum,capacity,instructor3);
		assertEquals(n7,false);	
		
		}
		
		*/
	
	
}
