package com.skul.skul.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.FormThreeDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Formthreebasebackup;
import com.skul.skul.model.Formthreemarksreportprocess;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.repository.FormthreemarksreportprocessRepository;
import com.skul.skul.service.FormThreeService;
@Service
public class FormThreeServiceImpl implements FormThreeService{

	@Autowired
	private FormThreeDao formThreDao;
	
	@Autowired
	FormThreeMarksRepository formThreeMarksRepository;
	
	@Autowired
	FormthreemarksreportprocessRepository formthreemarksreportprocessRepository;
	
	
	@Override
	public List<FormThreeMarksEntry> select_eng_ByStream() {
		return formThreDao.select_eng_ByStream();
	}
	
	@Override
	public FormThreeMarksEntry findById(Long regno) {
		return formThreeMarksRepository.getOne(regno);
	}

	@Override
	public void update(FormThreeMarksEntry e) {
		formThreDao.update(e);
		
	}

	@Override
	public List<FormThreeMarksEntry> select_geo_ByStream() {
		return formThreDao.select_geo_ByStream();
	}

	@Override
	public void update_geo(FormThreeMarksEntry e) {
		formThreDao.update_geo(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_kis_ByStream() {
		return formThreDao.select_kis_ByStream();
	}

	@Override
	public void update_kis(FormThreeMarksEntry e) {
		formThreDao.update_kis(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_math_ByStream() {
		return formThreDao.select_math_ByStream();
	}

	@Override
	public void update_math(FormThreeMarksEntry e) {
		formThreDao.update_math(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_bio_ByStream() {
		return formThreDao.select_bio_ByStream();
	}

	@Override
	public void update_bio(FormThreeMarksEntry e) {
		formThreDao.update_bio(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_chem_ByStream() {
		return formThreDao.select_chem_ByStream();
	}

	@Override
	public void update_chem(FormThreeMarksEntry e) {
		formThreDao.update_chem(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_phy_ByStream() {
		return formThreDao.select_phy_ByStream();
	}

	@Override
	public void update_phy(FormThreeMarksEntry e) {
		formThreDao.update_phy(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_his_ByStream() {
		return formThreDao.select_his_ByStream();
	}

	@Override
	public void update_his(FormThreeMarksEntry e) {
		formThreDao.update_his(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_cre_ByStream() {
		return formThreDao.select_cre_ByStream();
	}

	@Override
	public void update_cre(FormThreeMarksEntry e) {
		formThreDao.update_cre(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_agric_ByStream() {
		return formThreDao.select_agric_ByStream();
	}

	@Override
	public void update_agric(FormThreeMarksEntry e) {
		formThreDao.update_agric(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_biz_ByStream() {
		return formThreDao.select_biz_ByStream();
	}

	@Override
	public void update_biz(FormThreeMarksEntry e) {
		formThreDao.update_biz(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_comp_ByStream() {
		return formThreDao.select_comp_ByStream();
	}

	@Override
	public void update_comp(FormThreeMarksEntry e) {
		formThreDao.update_comp(e);
	}

	@Override
	public List<FormThreeMarksEntry> select_hom_ByStream() {
		return formThreDao.select_hom_ByStream();
	}

	@Override
	public void update_hom(FormThreeMarksEntry e) {
		formThreDao.update_hom(e);
	}

	@Override
	public List<Student> select_students_ToLoad() {
		return formThreDao.select_students_ToLoad();
	}

	@Override
	public int[] select_all_students(List<Student> copy_all) {
		return formThreDao.select_all_students(copy_all);
	}

	@Override
	public void updateExamType(String exmtype) {
		formThreDao.updateExamType(exmtype);
	}

	@Override
	public void updateTerm(String term) {
		formThreDao.updateTerm(term);
	}

	@Override
	public List<FormThreeMarksEntry> sumup() {
		return formThreDao.sumup();
	}

	@Override
	public int[] batchUpdate_FormThree_tt(List<FormThreeMarksEntry> form_tt) {
		return formThreDao.batchUpdate_FormThree_tt(form_tt);
	}

	@Override
	public List<FormThreeMarksEntry> rankList() {
		return formThreDao.rankList();
	}

	@Override
	public int[] c_rank(List<FormThreeMarksEntry> crank) {
		return formThreDao.c_rank(crank);
	}

	@Override
	public List<FormThreeMarksEntry> rank_ave() {
		return formThreDao.rank_ave();
	}

	@Override
	public int[] rank_average(List<FormThreeMarksEntry> crankAvg) {
		return formThreDao.rank_average(crankAvg);
	}

	@Override
	public List<FormThreeMarksEntry> selectAverageToBackUp(){
		return formThreeMarksRepository.findAll();
	}

	@Override
	public int[] batchAverageToBackUp(List<FormThreeMarksEntry> backup) {
		return formThreDao.batchAverageToBackUp(backup);
	}
	@Override
	public  void deleteAll(List<FormThreeMarksEntry> backup) {
		formThreeMarksRepository.deleteAllInBatch();		  
	}

	@Override
	public List<Formthreebasebackup> select_avgs(String year, String term) {
		return formThreDao.select_avgs(year, term);
	}

	@Override
	public int[] copyAvg(List<Formthreebasebackup> copy_all) {
		return formThreDao.copyAvg(copy_all);
	}

	@Override
	public List<Formthreemarksreportprocess> _form3_tt() {
		return formThreDao._form3_tt();
	}

	@Override
	public int[] batchUpdate_Form3_tt(List<Formthreemarksreportprocess> form_tt) {
		return formThreDao.batchUpdate_Form3_tt(form_tt);
	}

	@Override
	public List<Formthreemarksreportprocess> f3_rankList() {
		return formThreDao.f3_rankList();
	}

	@Override
	public int[] f3_c_rank(List<Formthreemarksreportprocess> crank) {
		return formThreDao.f3_c_rank(crank);
	}

	@Override
	public List<Formthreemarksreportprocess> f3_rank_ave() {
		return formThreDao.f3_rank_ave();
	}

	@Override
	public int[] f3_rank_average(List<Formthreemarksreportprocess> crankAvg) {
		return formThreDao.f3_rank_average(crankAvg);
	}

	@Override
	public List<Formthreemarksreportprocess> selectAvToBackUp() {
		return formthreemarksreportprocessRepository.findAll();
	}

	@Override
	public int[] f3_bchAverageToBackUp(List<Formthreemarksreportprocess> backup) {
		return formThreDao.f3_bchAverageToBackUp(backup);
	}

	@Override
	public int[] f3_deleteAl(List<Formthreemarksreportprocess> backup) {
		return formThreDao.f3_deleteAl(backup);
	}
	
	
	}
