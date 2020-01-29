package com.skul.skul.utils;

public class Student_kcpe_marks_util {

	public static String kcpemarks_mean(String marks) {
		double mrks = Double.parseDouble(marks);
		double mean_mks = (mrks/5);
		String mark = String.format("%.0f",mean_mks);
		return mark;
		
	}	
	public static String averageGrade(double l) {
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
	
}
