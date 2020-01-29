package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.FormOneSubjectRankingDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarksBackUp;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Formonebackup;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.service.FormOneSubjectRankingService;


@Service
public class FormOneSubjectRankingDaoServiceImpl implements FormOneSubjectRankingService{

	@Autowired
	FormOneSubjectRankingDao formOneSubjectRankingDaoDao;
	
	@Override
	public int[] sub_rank_average(List<FormOneMarks_Report_Process> subrankAvg) {
		
		return formOneSubjectRankingDaoDao.sub_rank_average(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_ave() {
		
		return formOneSubjectRankingDaoDao.sub_rank_ave();
	}

	@Override
	public int[] sub_rank_kis(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_kis(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_kis() {
		return formOneSubjectRankingDaoDao.sub_rank_kis();
	}

	@Override
	public int[] sub_rank_math(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_math(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_math() {
		return formOneSubjectRankingDaoDao.sub_rank_math();
	}

	@Override
	public int[] sub_rank_bio(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_bio(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_bio() {
		return formOneSubjectRankingDaoDao.sub_rank_bio();
	}

	@Override
	public int[] sub_rank_chem(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_chem(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_chem() {
		return formOneSubjectRankingDaoDao.sub_rank_chem();
	}

	@Override
	public int[] sub_rank_phy(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_phy(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_phy() {
		return formOneSubjectRankingDaoDao.sub_rank_phy();
				
	}

	@Override
	public int[] sub_rank_geo(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_geo(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_geo() {
		return formOneSubjectRankingDaoDao.sub_rank_geo();
	}

	@Override
	public int[] sub_rank_his(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_his(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_his() {
		return formOneSubjectRankingDaoDao.sub_rank_his();
	}

	@Override
	public int[] sub_rank_cre(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_cre(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_cre() {
		return formOneSubjectRankingDaoDao.sub_rank_cre();
	}

	@Override
	public int[] sub_rank_agric(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_agric(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_agric() {
		return formOneSubjectRankingDaoDao.sub_rank_agric();
	}

	@Override
	public int[] sub_rank_biz(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_biz(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_biz() {
		return formOneSubjectRankingDaoDao.sub_rank_biz();
	}

	@Override
	public int[] sub_rank_comp(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_comp(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_comp() {
		return formOneSubjectRankingDaoDao.sub_rank_comp();
	}

	@Override
	public int[] sub_rank_hom(List<FormOneMarks_Report_Process> subrankAvg) {
		return formOneSubjectRankingDaoDao.sub_rank_hom(subrankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> sub_rank_hom() {
		return formOneSubjectRankingDaoDao.sub_rank_hom();
	}

	@Override
	public List<FormOneMarksBackUp> selectAll_TermOne(Long adno) {
		return formOneSubjectRankingDaoDao.selectAll_TermOne(adno);
	}

	@Override
	public List<FormOneMarksBackUp> selectAll_TermTwo(Long adno) {
		return formOneSubjectRankingDaoDao.selectAll_TermTwo(adno);
	}

	@Override
	public List<FormOneMarksBackUp> selectAll_TermThree(Long adno) {
		return formOneSubjectRankingDaoDao.selectAll_TermThree(adno);
	}

	@Override
	public List<FormOneMarks> selectAll_ExamOne(Long adno, String term, String year) {
		return formOneSubjectRankingDaoDao.selectAll_ExamOne(adno, term, year);
	}

	@Override
	public List<FormOneMarks> selectAll_ExamTwo(Long adno, String term, String year) {
		return formOneSubjectRankingDaoDao.selectAll_ExamTwo(adno, term, year);
	}

	@Override
	public List<FormOneMarks> selectAll_ExamThree(Long adno, String term, String year) {
		return formOneSubjectRankingDaoDao.selectAll_ExamThree(adno, term, year);
	}

	@Override
	public List<FormOneMarksBackUp> selectAll_Exam(Long adno, String term, String year) {
		return formOneSubjectRankingDaoDao.selectAll_Exam(adno, term, year);
	}

	@Override
	public List<FormOneMarksBackUp> student_mean_dev(long regno) {
		
		return formOneSubjectRankingDaoDao.student_mean_dev(regno);
	}

	@Override
	public List<Formonebackup> selectAll(String term, String year, String examtype) {
		return formOneSubjectRankingDaoDao.selectAll(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype) {
		return formOneSubjectRankingDaoDao.sub_analysis(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype) {
		return formOneSubjectRankingDaoDao.stream_analysis(term, year, examtype);
	}

}
