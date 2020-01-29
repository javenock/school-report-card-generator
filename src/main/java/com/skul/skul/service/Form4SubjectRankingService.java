package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.FormOneMarksBackUp;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksbackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Subject_Analysis;

public interface Form4SubjectRankingService {
	public int[] sub_rank_average(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_ave();
	public int[] sub_rank_kis(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_kis();
	public int[] sub_rank_math(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_math();
	public int[] sub_rank_bio(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_bio();
	public int[] sub_rank_chem(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_chem();
	public int[] sub_rank_phy(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_phy();
	public int[] sub_rank_geo(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_geo();
	public int[] sub_rank_his(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_his();
	public int[] sub_rank_cre(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_cre();
	public int[] sub_rank_agric(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_agric();
	public int[] sub_rank_biz(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_biz();
	public int[] sub_rank_comp(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_comp();
	public int[] sub_rank_hom(List<Form4marksreportprocess> subrankAvg);
	public List<Form4marksreportprocess> sub_rank_hom();
	
	public  List<Form4basebackup> selectAll_ExamOne(Long adno, String term, String year);
	public  List<Form4basebackup> selectAll_ExamTwo(Long adno, String term, String year);
	public  List<Form4basebackup> selectAll_ExamThree(Long adno, String term, String year);
	public  List<Form4marksbackup> selectAll_Exam(Long adno, String term, String year);
	
	public List<Form4marksbackup> selectAll_TermOne(Long adno);
	public List<Form4marksbackup> selectAll_TermTwo(Long adno);
	public List<Form4marksbackup> selectAll_TermThree(Long adno);

	public List<Form4basebackup> selectAll(String term, String year, String examtype);
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype);
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype);
	public List<Form4marksbackup> student_mean_dev(long regno);
}
