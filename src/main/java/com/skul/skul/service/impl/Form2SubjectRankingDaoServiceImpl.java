package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.Form2SubjectRankingDao;
import com.skul.skul.dao.FormOneSubjectRankingDao;
import com.skul.skul.model.Form2Marks;
import com.skul.skul.model.Form2marksbackup;
import com.skul.skul.model.Form2Marks_Report_Process;
import com.skul.skul.model.Form2backupbase;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.service.Form2SubjectRankingService;
import com.skul.skul.service.FormOneSubjectRankingService;


@Service
public class Form2SubjectRankingDaoServiceImpl implements Form2SubjectRankingService{

	@Autowired
	Form2SubjectRankingDao form2SubjectRankingDaoDao;
	
	@Override
	public int[] sub_rank_average(List<Form2Marks_Report_Process> subrankAvg) {
		
		return form2SubjectRankingDaoDao.sub_rank_average(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_ave() {
		
		return form2SubjectRankingDaoDao.sub_rank_ave();
	}

	@Override
	public int[] sub_rank_kis(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_kis(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_kis() {
		return form2SubjectRankingDaoDao.sub_rank_kis();
	}

	@Override
	public int[] sub_rank_math(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_math(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_math() {
		return form2SubjectRankingDaoDao.sub_rank_math();
	}

	@Override
	public int[] sub_rank_bio(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_bio(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_bio() {
		return form2SubjectRankingDaoDao.sub_rank_bio();
	}

	@Override
	public int[] sub_rank_chem(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_chem(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_chem() {
		return form2SubjectRankingDaoDao.sub_rank_chem();
	}

	@Override
	public int[] sub_rank_phy(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_phy(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_phy() {
		return form2SubjectRankingDaoDao.sub_rank_phy();
				
	}

	@Override
	public int[] sub_rank_geo(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_geo(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_geo() {
		return form2SubjectRankingDaoDao.sub_rank_geo();
	}

	@Override
	public int[] sub_rank_his(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_his(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_his() {
		return form2SubjectRankingDaoDao.sub_rank_his();
	}

	@Override
	public int[] sub_rank_cre(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_cre(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_cre() {
		return form2SubjectRankingDaoDao.sub_rank_cre();
	}

	@Override
	public int[] sub_rank_agric(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_agric(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_agric() {
		return form2SubjectRankingDaoDao.sub_rank_agric();
	}

	@Override
	public int[] sub_rank_biz(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_biz(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_biz() {
		return form2SubjectRankingDaoDao.sub_rank_biz();
	}

	@Override
	public int[] sub_rank_comp(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_comp(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_comp() {
		return form2SubjectRankingDaoDao.sub_rank_comp();
	}

	@Override
	public int[] sub_rank_hom(List<Form2Marks_Report_Process> subrankAvg) {
		return form2SubjectRankingDaoDao.sub_rank_hom(subrankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> sub_rank_hom() {
		return form2SubjectRankingDaoDao.sub_rank_hom();
	}

	@Override
	public List<Form2marksbackup> selectAll_TermOne(Long adno) {
		return form2SubjectRankingDaoDao.selectAll_TermOne(adno);
	}

	@Override
	public List<Form2marksbackup> selectAll_TermTwo(Long adno) {
		return form2SubjectRankingDaoDao.selectAll_TermTwo(adno);
	}

	@Override
	public List<Form2marksbackup> selectAll_TermThree(Long adno) {
		return form2SubjectRankingDaoDao.selectAll_TermThree(adno);
	}

	@Override
	public List<Form2Marks> selectAll_ExamOne(Long adno, String term, String year) {
		return form2SubjectRankingDaoDao.selectAll_ExamOne(adno, term, year);
	}

	@Override
	public List<Form2Marks> selectAll_ExamTwo(Long adno, String term, String year) {
		return form2SubjectRankingDaoDao.selectAll_ExamTwo(adno, term, year);
	}

	@Override
	public List<Form2Marks> selectAll_ExamThree(Long adno, String term, String year) {
		return form2SubjectRankingDaoDao.selectAll_ExamThree(adno, term, year);
	}

	@Override
	public List<Form2marksbackup> selectAll_Exam(Long adno, String term, String year) {
		return form2SubjectRankingDaoDao.selectAll_Exam(adno, term, year);
	}

	@Override
	public List<Form2marksbackup> student_mean_dev(long regno) {
		
		return form2SubjectRankingDaoDao.student_mean_dev(regno);
	}

	@Override
	public List<Form2backupbase> selectAll(String term, String year, String examtype) {
		return form2SubjectRankingDaoDao.selectAll(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype) {
		return form2SubjectRankingDaoDao.sub_analysis(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype) {
		return form2SubjectRankingDaoDao.stream_analysis(term, year, examtype);
	}

}
