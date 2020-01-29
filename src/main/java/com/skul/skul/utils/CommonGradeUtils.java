package com.skul.skul.utils;

public class CommonGradeUtils {

	public static String averageGrade(Long l) {
		String grade = null;	
		
		if(l > 80) {
			grade = "A";
		}
		else if(l > 74) {
			grade = "A-";
		}
		else if(l >69) {
			grade = "B+";
		} 
		else if(l >64)
		{
			grade = "B";
		}else if(l >59)
		{
			grade = "B-";
		}else if(l >54)
		{
			grade = "C+";
		}else if(l >49)
		{
			grade = "C";
		}else if(l >44)
		{
			grade = "C-";
		}else if(l >39)
		{
			grade = "D+";
		}else if(l >34)
		{
			grade = "D";
		}else if(l >29)
		{
			grade = "D-";
		} else if(l > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	
	public static String groupAGrade(Long l) {
		String grade = null;
		if(l > 80) {
			grade = "A";
			
		}
		else if(l > 74) {
			grade = "A-";
		}
		else if(l >69) {
			grade = "B+";
		} 
		else if(l >64)
		{
			grade = "B";
		}else if(l >59)
		{
			grade = "B-";
		}else if(l >54)
		{
			grade = "C+";
		}else if(l >49)
		{
			grade = "C";
		}else if(l >44)
		{
			grade = "C-";
		}else if(l >39)
		{
			grade = "D+";
		}else if(l >34)
		{
			grade = "D";
		}else if(l >29)
		{
			grade = "D-";
		} else if(l > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	
	public static Long pointsA(String l) {
		Long pnts;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else
		{
			pnts = (long) 1;
		}
		
		
		return pnts;
		
	}
	
	public static String groupBGrade(String m) {
		
		Double d = Double.parseDouble(m);
		String grade = null;
		
		if(d > 70) {
			grade = "A";
		}
		else if(d > 64) {
			grade = "A-";
		}
		else if(d >59) {
			grade = "B+";
		} 
		else if(d >49)
		{
			grade = "B";
		}else if(d >44)
		{
			grade = "B-";
		}else if(d >39)
		{
			grade = "C+";
		}else if(d >34)
		{
			grade = "C";
		}else if(d >29)
		{
			grade = "C-";
		}else if(d >24)
		{
			grade = "D+";
		}else if(d >19)
		{
			grade = "D";
		}else if(d >14)
		{
			grade = "D-";
		} else if(d > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	public static Long pointsB(String l) {
Long pnts;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else
		{
			pnts = (long) 1;
		}
		
		
		return pnts;
		
	}
	public static String groupCGrade(Long l) {
		String grade = null;
		if(l > 80) {
			grade = "A";
		}
		else if(l > 74) {
			grade = "A-";
		}
		else if(l >69) {
			grade = "B+";
		} 
		else if(l >64)
		{
			grade = "B";
		}else if(l >59)
		{
			grade = "B-";
		}else if(l >54)
		{
			grade = "C+";
		}else if(l >49)
		{
			grade = "C";
		}else if(l >44)
		{
			grade = "C-";
		}else if(l >39)
		{
			grade = "D+";
		}else if(l >34)
		{
			grade = "D";
		}else if(l >29)
		{
			grade = "D-";
		} else if(l > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	public static Long pointsC(String l) {
Long pnts;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else
		{
			pnts = (long) 1;
		}
		
		
		return pnts;
		
	}
	public static String groupDGrade(Long l) {
		String grade = null;
		if(l > 80) {
			grade = "A";
		}
		else if(l > 74) {
			grade = "A-";
		}
		else if(l >69) {
			grade = "B+";
		} 
		else if(l >64)
		{
			grade = "B";
		}else if(l >59)
		{
			grade = "B-";
		}else if(l >54)
		{
			grade = "C+";
		}else if(l >49)
		{
			grade = "C";
		}else if(l >44)
		{
			grade = "C-";
		}else if(l >39)
		{
			grade = "D+";
		}else if(l >34)
		{
			grade = "D";
		}else if(l >29)
		{
			grade = "D-";
		}else if(l > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	public static Long pointsD(String l) {
Long pnts;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else
		{
			pnts = (long) 1;
		}
		
		
		return pnts;
		
	}
	public static String groupEGrade(Long l) {
		String grade = null;
		if(l > 80) {
			grade = "A";
		}
		else if(l > 74) {
			grade = "A-";
		}
		else if(l >69) {
			grade = "B+";
		} 
		else if(l >64)
		{
			grade = "B";
		}else if(l >59)
		{
			grade = "B-";
		}else if(l >54)
		{
			grade = "C+";
		}else if(l >49)
		{
			grade = "C";
		}else if(l >44)
		{
			grade = "C-";
		}else if(l >39)
		{
			grade = "D+";
		}else if(l >34)
		{
			grade = "D";
		}else if(l >29)
		{
			grade = "D-";
		} else if(l > 0)
		{
			grade = "E";
		}else {
			grade = "";
		}
		
		
		return grade;
		
	}
	public static Long pointsE(String l) {
Long pnts;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else
		{
			pnts = (long) 1;
		}
		
		
		return pnts;
		
	}
	public static String remarks(String l) {
		String  remarks = "--";	
		
		if(l.equals("A") || l.equals("A-") || l.equals("B+") ) {
			remarks = "Excellent work";
		}
		
		else if(l.equals("B") || l.equals("B-") || l.equals("C+"))
		{
			remarks = "put in more effort";
		}
		else if(l.equals("C") || l.equals("C-") || l.equals("D+") )
		{
			remarks  = "Can do better, aim higher";
		}
		
		else if(l.equals("D") || l.equals("D-") )
		{
			remarks = "Satisfactory,aim higher";
		} else
		{
			remarks = "poor work";
		}
		
		
		return remarks;
		
	}
	public static String remarks_kis(String l) {
		String  remarks = "--";	
		
		if(l.equals("A") || l.equals("A-") || l.equals("B+") ) {
			remarks = "Bora Zaidi";
		}
		
		else if(l.equals("B") || l.equals("B-") || l.equals("C+"))
		{
			remarks = "Viema,Tia Tena bidii";
		}
		else if(l.equals("C") || l.equals("C-") || l.equals("D+") )
		{
			remarks  = "Ongeza Bidii";
		}
		
		else if(l.equals("D") || l.equals("D-") )
		{
			remarks = "Wastani";
		} else
		{
			remarks = "Kazi Mbaya";
		}
		
		
		return remarks;
		
	}
	public static Long points(String l) {
			
		
		Long pnts = (long) 0;	
		
		if(l.equals("A")) {
			pnts = (long) 12;
		}
		else if(l.equals("A-")) {
			pnts = (long) 11;
		}
		else if(l.equals("B+")) {
			pnts = (long) 10;
		} 
		else if(l.equals("B"))
		{
			pnts = (long) 9;
		}else if(l.equals("B-"))
		{
			pnts = (long) 8;
		}else if(l.equals("C+"))
		{
			pnts = (long) 7;
		}else if(l.equals("C"))
		{
			pnts = (long) 6;
		}else if(l.equals("C-"))
		{
			pnts = (long) 5;
		}else if(l.equals("D+"))
		{
			pnts = (long) 4;
		}else if(l.equals("D"))
		{
			pnts = (long) 3;
		}else if(l.equals("D-"))
		{
			pnts = (long) 2;
		} else if(l.equals("E"))
		{
			pnts = (long) 1;
		}else
		{
			
		}
		
		
		return pnts;
		
	}
	public static String remarks_class_teacher(String l) {
		String  remarks = "--";	
		
		if(l.equals("A") || l.equals("A-") || l.equals("B+") ) {
			remarks = "Excellent work";
		}
		
		else if(l.equals("B") || l.equals("B-") || l.equals("C+"))
		{
			remarks = "put in more effort";
		}
		else if(l.equals("C") || l.equals("C-") || l.equals("D+") )
		{
			remarks  = "Below Average, Work harder";
		}
		
		else if(l.equals("D") || l.equals("D-") )
		{
			remarks = "Satisfactory,aim higher";
		} else
		{
			remarks = "poor work";
		}
		
		
		return remarks;
		
	}
	public static String remarks_class_prinzy(String l) {
		String  remarks = "--";	
		
		if(l.equals("A") || l.equals("A-") || l.equals("B+") ) {
			remarks = "Excellent, Aim Higher";
		}
		
		else if(l.equals("B") || l.equals("B-") || l.equals("C+"))
		{
			remarks = "Satisfactory, put in more effort";
		}
		else if(l.equals("C") || l.equals("C-") || l.equals("D+") )
		{
			remarks  = "Below Average, Try Again";
		}
		
		else if(l.equals("D") || l.equals("D-") )
		{
			remarks = "Pull up your Socks and ,work harder";
		} else
		{
			remarks = "poor work, Work Harder";
		}
		
		
		return remarks;
		
	}
	
}
