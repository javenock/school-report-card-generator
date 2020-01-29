package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarksBackUp;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Formonebackup;
import com.skul.skul.model.Subject_Analysis;

public interface FormOneSubjectRankingService {
	public int[] sub_rank_average(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_ave();
	public int[] sub_rank_kis(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_kis();
	public int[] sub_rank_math(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_math();
	public int[] sub_rank_bio(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_bio();
	public int[] sub_rank_chem(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_chem();
	public int[] sub_rank_phy(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_phy();
	public int[] sub_rank_geo(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_geo();
	public int[] sub_rank_his(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_his();
	public int[] sub_rank_cre(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_cre();
	public int[] sub_rank_agric(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_agric();
	public int[] sub_rank_biz(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_biz();
	public int[] sub_rank_comp(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_comp();
	public int[] sub_rank_hom(List<FormOneMarks_Report_Process> subrankAvg);
	public List<FormOneMarks_Report_Process> sub_rank_hom();
	
	public List<FormOneMarksBackUp> selectAll_TermOne(Long adno);
	public List<FormOneMarksBackUp> selectAll_TermTwo(Long adno);
	public List<FormOneMarksBackUp> selectAll_TermThree(Long adno);
	
	public  List<FormOneMarks> selectAll_ExamOne(Long adno, String term, String year);
	public List<FormOneMarks> selectAll_ExamTwo(Long adno, String term, String year);
	public List<FormOneMarks> selectAll_ExamThree(Long adno, String term,String year);
	public  List<FormOneMarksBackUp> selectAll_Exam(Long adno, String term, String year);
	public List<FormOneMarksBackUp> student_mean_dev(long regno);
	public List<Formonebackup> selectAll(String term, String year, String examtype);
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype);
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype);
}
