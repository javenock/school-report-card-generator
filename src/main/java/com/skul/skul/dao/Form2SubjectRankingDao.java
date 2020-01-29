package com.skul.skul.dao;

import java.util.List;

import com.skul.skul.model.Form2Marks;
import com.skul.skul.model.Form2marksbackup;
import com.skul.skul.model.Form2Marks_Report_Process;
import com.skul.skul.model.Form2backupbase;
import com.skul.skul.model.Subject_Analysis;

public interface Form2SubjectRankingDao {
	
	public int[] sub_rank_average(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_ave();
	public int[] sub_rank_kis(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_kis();
	public int[] sub_rank_math(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_math();
	public int[] sub_rank_bio(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_bio();
	public int[] sub_rank_chem(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_chem();
	public int[] sub_rank_phy(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_phy();
	public int[] sub_rank_geo(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_geo();
	public int[] sub_rank_his(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_his();
	public int[] sub_rank_cre(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_cre();
	public int[] sub_rank_agric(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_agric();
	public int[] sub_rank_biz(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_biz();
	public int[] sub_rank_comp(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_comp();
	public int[] sub_rank_hom(List<Form2Marks_Report_Process> subrankAvg);
	public List<Form2Marks_Report_Process> sub_rank_hom();
	
	
	public List<Form2marksbackup> selectAll_TermOne(Long adno);
	public List<Form2marksbackup> selectAll_TermTwo(Long adno);
	public List<Form2marksbackup> selectAll_TermThree(Long adno);
	
	
	public  List<Form2Marks> selectAll_ExamOne(Long adno, String term, String year);
	public List<Form2Marks> selectAll_ExamTwo(Long adno, String term, String year);
	public List<Form2Marks> selectAll_ExamThree(Long adno, String term,String year);
	public  List<Form2marksbackup> selectAll_Exam(Long adno, String term, String year);
	public List<Form2marksbackup> student_mean_dev(long regno);
	public List<Form2backupbase> selectAll(String term, String year, String examtype);
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype);
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype);
}
