package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.Form4SubjectRankingDao;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksbackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.service.Form4SubjectRankingService;
@Service
public class Form4SubjectRankingServiceImpl implements Form4SubjectRankingService{

	@Autowired
	Form4SubjectRankingDao form4SubjectRankingDao;
	
	@Override
	public int[] sub_rank_average(List<Form4marksreportprocess> subrankAvg) {
		
		return form4SubjectRankingDao.sub_rank_average(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_ave() {
		
		return form4SubjectRankingDao.sub_rank_ave();
	}

	@Override
	public int[] sub_rank_kis(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_kis(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_kis() {
		return form4SubjectRankingDao.sub_rank_kis();
	}

	@Override
	public int[] sub_rank_math(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_math(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_math() {
		return form4SubjectRankingDao.sub_rank_math();
	}

	@Override
	public int[] sub_rank_bio(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_bio(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_bio() {
		return form4SubjectRankingDao.sub_rank_bio();
	}

	@Override
	public int[] sub_rank_chem(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_chem(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_chem() {
		return form4SubjectRankingDao.sub_rank_chem();
	}

	@Override
	public int[] sub_rank_phy(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_phy(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_phy() {
		return form4SubjectRankingDao.sub_rank_phy();
				
	}

	@Override
	public int[] sub_rank_geo(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_geo(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_geo() {
		return form4SubjectRankingDao.sub_rank_geo();
	}

	@Override
	public int[] sub_rank_his(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_his(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_his() {
		return form4SubjectRankingDao.sub_rank_his();
	}

	@Override
	public int[] sub_rank_cre(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_cre(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_cre() {
		return form4SubjectRankingDao.sub_rank_cre();
	}

	@Override
	public int[] sub_rank_agric(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_agric(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_agric() {
		return form4SubjectRankingDao.sub_rank_agric();
	}

	@Override
	public int[] sub_rank_biz(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_biz(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_biz() {
		return form4SubjectRankingDao.sub_rank_biz();
	}

	@Override
	public int[] sub_rank_comp(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_comp(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_comp() {
		return form4SubjectRankingDao.sub_rank_comp();
	}

	@Override
	public int[] sub_rank_hom(List<Form4marksreportprocess> subrankAvg) {
		return form4SubjectRankingDao.sub_rank_hom(subrankAvg);
	}

	@Override
	public List<Form4marksreportprocess> sub_rank_hom() {
		return form4SubjectRankingDao.sub_rank_hom();
	}

	@Override
	public List<Form4basebackup> selectAll_ExamOne(Long adno, String term, String year) {
		return form4SubjectRankingDao.selectAll_ExamOne(adno, term, year);
	}

	@Override
	public List<Form4basebackup> selectAll_ExamTwo(Long adno, String term, String year) {
		return form4SubjectRankingDao.selectAll_ExamTwo(adno, term, year);
	}

	@Override
	public List<Form4basebackup> selectAll_ExamThree(Long adno, String term, String year) {
		return form4SubjectRankingDao.selectAll_ExamThree(adno, term, year);
	}

	@Override
	public List<Form4marksbackup> selectAll_Exam(Long adno, String term, String year) {
		return form4SubjectRankingDao.selectAll_Exam(adno, term, year);
	}

	@Override
	public List<Form4marksbackup> selectAll_TermOne(Long adno) {
		return form4SubjectRankingDao.selectAll_TermOne(adno);
	}

	@Override
	public List<Form4marksbackup> selectAll_TermTwo(Long adno) {
		return form4SubjectRankingDao.selectAll_TermTwo(adno);
	}

	@Override
	public List<Form4marksbackup> selectAll_TermThree(Long adno) {
		return form4SubjectRankingDao.selectAll_TermThree(adno);
	}

	@Override
	public List<Form4basebackup> selectAll(String term, String year, String examtype) {
		
		return form4SubjectRankingDao.selectAll(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype) {
		return form4SubjectRankingDao.sub_analysis(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype) {
		return form4SubjectRankingDao.stream_analysis(term, year, examtype);
	}

	@Override
	public List<Form4marksbackup> student_mean_dev(long regno) {
		return form4SubjectRankingDao.student_mean_dev(regno);
	}
}
