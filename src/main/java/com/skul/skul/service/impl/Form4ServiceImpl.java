package com.skul.skul.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.Form4Dao;
import com.skul.skul.dao.FormThreeDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.Form4MarksEntry;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Student;
import com.skul.skul.repository.Form4MarksRepository;
import com.skul.skul.repository.Form4marksreportprocessRepository;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.repository.Form4marksreportprocessRepository;
import com.skul.skul.service.Form4Service;
import com.skul.skul.service.FormThreeService;
@Service
public class Form4ServiceImpl implements Form4Service{

	@Autowired
	private Form4Dao form4Dao;
	
	@Autowired
	Form4MarksRepository form4MarksRepository;
	
	@Autowired
	Form4marksreportprocessRepository form4marksreportprocessRepository;
	
	
	@Override
	public List<Form4MarksEntry> select_eng_ByStream() {
		return form4Dao.select_eng_ByStream();
	}
	
	@Override
	public Form4MarksEntry findById(Long regno) {
		return form4MarksRepository.getOne(regno);
	}

	@Override
	public void update(Form4MarksEntry e) {
		form4Dao.update(e);
		
	}

	@Override
	public List<Form4MarksEntry> select_geo_ByStream() {
		return form4Dao.select_geo_ByStream();
	}

	@Override
	public void update_geo(Form4MarksEntry e) {
		form4Dao.update_geo(e);
	}

	@Override
	public List<Form4MarksEntry> select_kis_ByStream() {
		return form4Dao.select_kis_ByStream();
	}

	@Override
	public void update_kis(Form4MarksEntry e) {
		form4Dao.update_kis(e);
	}

	@Override
	public List<Form4MarksEntry> select_math_ByStream() {
		return form4Dao.select_math_ByStream();
	}

	@Override
	public void update_math(Form4MarksEntry e) {
		form4Dao.update_math(e);
	}

	@Override
	public List<Form4MarksEntry> select_bio_ByStream() {
		return form4Dao.select_bio_ByStream();
	}

	@Override
	public void update_bio(Form4MarksEntry e) {
		form4Dao.update_bio(e);
	}

	@Override
	public List<Form4MarksEntry> select_chem_ByStream() {
		return form4Dao.select_chem_ByStream();
	}

	@Override
	public void update_chem(Form4MarksEntry e) {
		form4Dao.update_chem(e);
	}

	@Override
	public List<Form4MarksEntry> select_phy_ByStream() {
		return form4Dao.select_phy_ByStream();
	}

	@Override
	public void update_phy(Form4MarksEntry e) {
		form4Dao.update_phy(e);
	}

	@Override
	public List<Form4MarksEntry> select_his_ByStream() {
		return form4Dao.select_his_ByStream();
	}

	@Override
	public void update_his(Form4MarksEntry e) {
		form4Dao.update_his(e);
	}

	@Override
	public List<Form4MarksEntry> select_cre_ByStream() {
		return form4Dao.select_cre_ByStream();
	}

	@Override
	public void update_cre(Form4MarksEntry e) {
		form4Dao.update_cre(e);
	}

	@Override
	public List<Form4MarksEntry> select_agric_ByStream() {
		return form4Dao.select_agric_ByStream();
	}

	@Override
	public void update_agric(Form4MarksEntry e) {
		form4Dao.update_agric(e);
	}

	@Override
	public List<Form4MarksEntry> select_biz_ByStream() {
		return form4Dao.select_biz_ByStream();
	}

	@Override
	public void update_biz(Form4MarksEntry e) {
		form4Dao.update_biz(e);
	}

	@Override
	public List<Form4MarksEntry> select_comp_ByStream() {
		return form4Dao.select_comp_ByStream();
	}

	@Override
	public void update_comp(Form4MarksEntry e) {
		form4Dao.update_comp(e);
	}

	@Override
	public List<Form4MarksEntry> select_hom_ByStream() {
		return form4Dao.select_hom_ByStream();
	}

	@Override
	public void update_hom(Form4MarksEntry e) {
		form4Dao.update_hom(e);
	}

	@Override
	public List<Student> select_students_ToLoad() {
		return form4Dao.select_students_ToLoad();
	}

	@Override
	public int[] select_all_students(List<Student> copy_all) {
		return form4Dao.select_all_students(copy_all);
	}

	@Override
	public void updateExamType(String exmtype) {
		form4Dao.updateExamType(exmtype);
	}

	@Override
	public void updateTerm(String term) {
		form4Dao.updateTerm(term);
	}

	@Override
	public List<Form4MarksEntry> sumup() {
		return form4Dao.sumup();
	}

	@Override
	public int[] batchUpdate_Formfour_tt(List<Form4MarksEntry> form_tt) {
		return form4Dao.batchUpdate_FormThree_tt(form_tt);
	}

	@Override
	public List<Form4MarksEntry> rankList() {
		return form4Dao.rankList();
	}

	@Override
	public int[] c_rank(List<Form4MarksEntry> crank) {
		return form4Dao.c_rank(crank);
	}

	@Override
	public List<Form4MarksEntry> rank_ave() {
		return form4Dao.rank_ave();
	}

	@Override
	public int[] rank_average(List<Form4MarksEntry> crankAvg) {
		return form4Dao.rank_average(crankAvg);
	}

	@Override
	public List<Form4MarksEntry> selectAverageToBackUp(){
		return form4MarksRepository.findAll();
	}

	@Override
	public int[] batchAverageToBackUp(List<Form4MarksEntry> backup) {
		return form4Dao.batchAverageToBackUp(backup);
	}
	@Override
	public  void deleteAll(List<Form4MarksEntry> backup) {
		form4MarksRepository.deleteAllInBatch();		  
	}

	@Override
	public List<Form4basebackup> select_avgs(String year, String term) {
		return form4Dao.select_avgs(year, term);
	}

	@Override
	public int[] copyAvg(List<Form4basebackup> copy_all) {
		return form4Dao.copyAvg(copy_all);
	}

	@Override
	public List<Form4marksreportprocess> _form4_tt() {
		return form4Dao._form4_tt();
	}

	@Override
	public int[] batchUpdate_Form4_tt(List<Form4marksreportprocess> form_tt) {
		return form4Dao.batchUpdate_Form4_tt(form_tt);
	}

	@Override
	public List<Form4marksreportprocess> f4_rankList() {
		return form4Dao.f4_rankList();
	}

	@Override
	public int[] f4_c_rank(List<Form4marksreportprocess> crank) {
		return form4Dao.f4_c_rank(crank);
	}

	@Override
	public List<Form4marksreportprocess> f4_rank_ave() {
		return form4Dao.f4_rank_ave();
	}

	@Override
	public int[] f4_rank_average(List<Form4marksreportprocess> crankAvg) {
		return form4Dao.f4_rank_average(crankAvg);
	}

	@Override
	public List<Form4marksreportprocess> selectAvToBackUp() {
		return form4marksreportprocessRepository.findAll();
	}

	@Override
	public int[] f4_bchAverageToBackUp(List<Form4marksreportprocess> backup) {
		return form4Dao.f4_bchAverageToBackUp(backup);
	}

	@Override
	public int[] f4_deleteAl(List<Form4marksreportprocess> backup) {
		return form4Dao.f4_deleteAl(backup);
	}
	
	
	}
