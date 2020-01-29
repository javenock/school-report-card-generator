package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.FormThreeSubjectRankingDao;
import com.skul.skul.model.Formthreebasebackup;
import com.skul.skul.model.Formthreemarksbackup;
import com.skul.skul.model.Formthreemarksreportprocess;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.service.FormThreeSubjectRankingService;
@Service
public class FormThreeSubjectRankingServiceImpl implements FormThreeSubjectRankingService{

	@Autowired
	FormThreeSubjectRankingDao formThreeSubjectRankingDao;
	
	@Override
	public int[] sub_rank_average(List<Formthreemarksreportprocess> subrankAvg) {
		
		return formThreeSubjectRankingDao.sub_rank_average(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_ave() {
		
		return formThreeSubjectRankingDao.sub_rank_ave();
	}

	@Override
	public int[] sub_rank_kis(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_kis(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_kis() {
		return formThreeSubjectRankingDao.sub_rank_kis();
	}

	@Override
	public int[] sub_rank_math(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_math(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_math() {
		return formThreeSubjectRankingDao.sub_rank_math();
	}

	@Override
	public int[] sub_rank_bio(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_bio(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_bio() {
		return formThreeSubjectRankingDao.sub_rank_bio();
	}

	@Override
	public int[] sub_rank_chem(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_chem(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_chem() {
		return formThreeSubjectRankingDao.sub_rank_chem();
	}

	@Override
	public int[] sub_rank_phy(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_phy(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_phy() {
		return formThreeSubjectRankingDao.sub_rank_phy();
				
	}

	@Override
	public int[] sub_rank_geo(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_geo(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_geo() {
		return formThreeSubjectRankingDao.sub_rank_geo();
	}

	@Override
	public int[] sub_rank_his(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_his(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_his() {
		return formThreeSubjectRankingDao.sub_rank_his();
	}

	@Override
	public int[] sub_rank_cre(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_cre(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_cre() {
		return formThreeSubjectRankingDao.sub_rank_cre();
	}

	@Override
	public int[] sub_rank_agric(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_agric(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_agric() {
		return formThreeSubjectRankingDao.sub_rank_agric();
	}

	@Override
	public int[] sub_rank_biz(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_biz(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_biz() {
		return formThreeSubjectRankingDao.sub_rank_biz();
	}

	@Override
	public int[] sub_rank_comp(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_comp(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_comp() {
		return formThreeSubjectRankingDao.sub_rank_comp();
	}

	@Override
	public int[] sub_rank_hom(List<Formthreemarksreportprocess> subrankAvg) {
		return formThreeSubjectRankingDao.sub_rank_hom(subrankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> sub_rank_hom() {
		return formThreeSubjectRankingDao.sub_rank_hom();
	}

	@Override
	public List<Formthreebasebackup> selectAll_ExamOne(Long adno, String term, String year) {
		return formThreeSubjectRankingDao.selectAll_ExamOne(adno, term, year);
	}

	@Override
	public List<Formthreebasebackup> selectAll_ExamTwo(Long adno, String term, String year) {
		return formThreeSubjectRankingDao.selectAll_ExamTwo(adno, term, year);
	}

	@Override
	public List<Formthreebasebackup> selectAll_ExamThree(Long adno, String term, String year) {
		return formThreeSubjectRankingDao.selectAll_ExamThree(adno, term, year);
	}

	@Override
	public List<Formthreemarksbackup> selectAll_Exam(Long adno, String term, String year) {
		return formThreeSubjectRankingDao.selectAll_Exam(adno, term, year);
	}

	@Override
	public List<Formthreemarksbackup> selectAll_TermOne(Long adno) {
		return formThreeSubjectRankingDao.selectAll_TermOne(adno);
	}

	@Override
	public List<Formthreemarksbackup> selectAll_TermTwo(Long adno) {
		return formThreeSubjectRankingDao.selectAll_TermTwo(adno);
	}

	@Override
	public List<Formthreemarksbackup> selectAll_TermThree(Long adno) {
		return formThreeSubjectRankingDao.selectAll_TermThree(adno);
	}

	@Override
	public List<Formthreebasebackup> selectAll(String term, String year, String examtype) {
		
		return formThreeSubjectRankingDao.selectAll(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype) {
		return formThreeSubjectRankingDao.sub_analysis(term, year, examtype);
	}

	@Override
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype) {
		return formThreeSubjectRankingDao.stream_analysis(term, year, examtype);
	}

	@Override
	public List<Formthreemarksbackup> student_mean_dev(long regno) {
		return formThreeSubjectRankingDao.student_mean_dev(regno);
	}
}
