package com.skul.skul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormOneMarksRepository;

public interface FormOneService {

	FormOneMarks findById(Long regno);
	public void update(FormOneMarks e);
	public List<FormOneMarks> select_eng_ByStream(); // form one; load languages 
	
	public void update_sci(FormOneMarks e);
	public List<FormOneMarks> select_sci_ByStream(); // form one; load sciences 
	
	public void update_hum(FormOneMarks e);
	public List<FormOneMarks> select_hum_ByStream(); // form one; load humanities
	
	public void update_tech(FormOneMarks e);
	public List<FormOneMarks> select_tech_ByStream(); // form one; load bio
	
	public List<FormOneMarks> select_All_formOne_Marks();
	
	public List<Student> select_students_ToLoad();	
	public int[] select_all_students(List<Student> copy_all);
	
	public void updateExamType(String exmtype);     // update exam type	
	public void updateTerm(String term); // update term
	
	public List<FormOneMarks> total_marks();	
	public int[] batchUpdate_FormOne_tt(List<FormOneMarks> form_tt); // totol calculations and update
	
	public List<FormOneMarks> rankList();
	public int[] c_rank(List<FormOneMarks> crank);
	
	public List<FormOneMarks> rank_ave();
	public int[] rank_average(List<FormOneMarks> crankAvg);
	
	public List<FormOneMarks> selectAverageToBackUp();
	//public void deleteAll();
	public void deleteAll(List<FormOneMarks> backup);
	public int[] batchAverageToBackUp(List<FormOneMarks> backup);
	
	public List<FormOneMarks> select_avgs(String year, String term);
	public int[] copyAvg(List<FormOneMarks> page1);
	
	public List<FormOneMarks_Report_Process> marks_avgs();
	public int[] update_tt_avgs(List<FormOneMarks_Report_Process> up_all);
	
	public List<FormOneMarks> rankList_ave();
	public int[] c_rnk_average(List<FormOneMarks> crankAvg);
	public List<FormOneMarks_Report_Process> rank_av();
	public int[] rnk_average(List<FormOneMarks_Report_Process> crankAv);
	public List<FormOneMarks_Report_Process> selectAvToBackUp();
	public int[] bchAverageToBackUp(List<FormOneMarks_Report_Process> backup);
	public int[] deleteAl(List<FormOneMarks_Report_Process> backup);
	
	}
