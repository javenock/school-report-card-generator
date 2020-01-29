package com.skul.skul.dao;

import java.util.List;

import com.skul.skul.model.Form2Marks;
import com.skul.skul.model.Form2Marks_Report_Process;
import com.skul.skul.model.Student;

public interface Form2Dao {

	public void update(Form2Marks e);
	public List<Form2Marks> select_eng_ByStream(); // form one; load languages 
	
	public void update_sci(Form2Marks e);
	public List<Form2Marks> select_sci_ByStream(); // form one; load sciences 
	
	public void update_hum(Form2Marks e);
	public List<Form2Marks> select_hum_ByStream(); // form one; load humanities
	
	public void update_tech(Form2Marks e);
	public List<Form2Marks> select_tech_ByStream(); // form one; load bio
	
	
	public List<Student> select_students_ToLoad();	
	public int[] select_all_students(List<Student> copy_all);
	
	public void updateExamType(String exmtype);     // update exam type	
	public void updateTerm(String term); // update term
	
	public List<Form2Marks> total_marks();	
	public int[] batchUpdate_FormTwo_tt(List<Form2Marks> form_tt); // totol calculations and update
		
	public List<Form2Marks> rankList();
	public int[] c_rank(List<Form2Marks> crank);
	
	public List<Form2Marks> rank_ave();
	public int[] rank_average(List<Form2Marks> crankAvg);
	
	public int[] batchAverageToBackUp(List<Form2Marks> backup);
	
	public List<Form2Marks> select_avgs(String year, String term);
	public int[] copyAvg(List<Form2Marks> copy_all);
	
	public List<Form2Marks_Report_Process> marks_avgs();
	public int[] update_tt_avgs(List<Form2Marks_Report_Process> up_all);
	
	
	public List<Form2Marks> rankList_ave();
	public int[] c_rnk_average(List<Form2Marks> crankAvg);
	public List<Form2Marks_Report_Process> rank_av();
	public int[] rnk_average(List<Form2Marks_Report_Process> crankAv);
	public List<Form2Marks_Report_Process> selectAvToBackUp();
	public int[] bchAverageToBackUp(List<Form2Marks_Report_Process> backup);
	public int[] deleteAl(List<Form2Marks_Report_Process> backup);

	//public List<Form2Marks> selectAverageToBackUp();
}
