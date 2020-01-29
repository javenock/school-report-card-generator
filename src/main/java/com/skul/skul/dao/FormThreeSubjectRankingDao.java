package com.skul.skul.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.skul.skul.model.Formonebackup;
import com.skul.skul.model.Formthreebasebackup;
import com.skul.skul.model.Formthreemarksbackup;
import com.skul.skul.model.Formthreemarksreportprocess;
import com.skul.skul.model.Subject_Analysis;


public interface FormThreeSubjectRankingDao {
	public int[] sub_rank_average(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_ave();
	public int[] sub_rank_kis(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_kis();
	public int[] sub_rank_math(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_math();
	public int[] sub_rank_bio(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_bio();
	public int[] sub_rank_chem(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_chem();
	public int[] sub_rank_phy(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_phy();
	public int[] sub_rank_geo(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_geo();
	public int[] sub_rank_his(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_his();
	public int[] sub_rank_cre(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_cre();
	public int[] sub_rank_agric(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_agric();
	public int[] sub_rank_biz(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_biz();
	public int[] sub_rank_comp(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_comp();
	public int[] sub_rank_hom(List<Formthreemarksreportprocess> subrankAvg);
	public List<Formthreemarksreportprocess> sub_rank_hom();
	
	public  List<Formthreebasebackup> selectAll_ExamOne(Long adno, String term, String year);
	public List<Formthreebasebackup> selectAll_ExamTwo(Long adno, String term, String year);
	public List<Formthreebasebackup> selectAll_ExamThree(Long adno, String term,String year);
	public  List<Formthreemarksbackup> selectAll_Exam(Long adno, String term, String year);
	
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype);
	
	public List<Formthreemarksbackup> selectAll_TermOne(Long adno);
	public List<Formthreemarksbackup> selectAll_TermTwo(Long adno);
	public List<Formthreemarksbackup> selectAll_TermThree(Long adno);
	
	public  List<Formthreebasebackup> selectAll(String term, String year, String examtype);
	
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype);
	public List<Formthreemarksbackup> student_mean_dev(long regno);
}
