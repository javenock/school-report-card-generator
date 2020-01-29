package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.FormOneDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormOneMarksRepository;
import com.skul.skul.service.FormOneService;

@Service
public class FormOneServiceImpl implements FormOneService{

	@Autowired
	private FormOneDao formOneDao;
	
	@Autowired
	private FormOneMarksRepository formOneMarksRepository;
	
	@Override
	public FormOneMarks findById(Long regno) {
		return formOneMarksRepository.getOne(regno);
	}
	
	@Override
	public void update(FormOneMarks e) {
		formOneDao.update(e);		
	}
	@Override
	public List<FormOneMarks> select_eng_ByStream() {		
		return formOneDao.select_eng_ByStream();
	}
	
	@Override
	public void update_sci(FormOneMarks e) {
		formOneDao.update_sci(e);		
	}
	@Override
	public List<FormOneMarks> select_sci_ByStream() {		
		return formOneDao.select_sci_ByStream();
	}
	@Override
	public void update_hum(FormOneMarks e) {
		formOneDao.update_hum(e);		
	}
	@Override
	public List<FormOneMarks> select_hum_ByStream() {		
		return formOneDao.select_hum_ByStream();
	}
	@Override
	public void update_tech(FormOneMarks e) {
		formOneDao.update_tech(e);		
	}
	@Override
	public List<FormOneMarks> select_tech_ByStream() {
		return formOneDao.select_tech_ByStream();
	}

	@Override
	public List<FormOneMarks> select_All_formOne_Marks() {
		return formOneMarksRepository.findAll();
	}

	@Override
	public List<Student> select_students_ToLoad() {		
		return formOneDao.select_students_ToLoad();
	}

	@Override
	public int[] select_all_students(List<Student> copy_all) {
		return formOneDao.select_all_students(copy_all);
	}

	@Override
	public void updateExamType(String exmtype) {
		formOneDao.updateExamType(exmtype);
	}

	@Override
	public void updateTerm(String term) {
		formOneDao.updateTerm(term);
	}

	@Override
	public List<FormOneMarks> total_marks() {
		return formOneDao.total_marks();
	}

	@Override
	public int[] batchUpdate_FormOne_tt(List<FormOneMarks> form_tt) {
		return formOneDao.batchUpdate_FormOne_tt(form_tt);
	}

	@Override
	public List<FormOneMarks> rankList() {
		return formOneDao.rankList();
	}

	@Override
	public int[] c_rank(List<FormOneMarks> crank) {
		return formOneDao.c_rank(crank);
	}

	@Override
	public List<FormOneMarks> rank_ave() {
		return formOneDao.rank_ave();
	}

	@Override
	public int[] rank_average(List<FormOneMarks> crankAvg) {
		return formOneDao.rank_average(crankAvg);
	}

	@Override
	public List<FormOneMarks> selectAverageToBackUp() { // use tyhia method
		return formOneMarksRepository.findAll();
	}

	@Override
	public  void deleteAll(List<FormOneMarks> backup) {
		 formOneMarksRepository.deleteAllInBatch();		  
	}

	@Override
	public int[] batchAverageToBackUp(List<FormOneMarks> backup) {
		return formOneDao.batchAverageToBackUp(backup);
	}

	@Override
	public List<FormOneMarks> select_avgs(String year, String term) {
		return formOneDao.select_avgs(year, term);
	}

	@Override
	public int[] copyAvg(List<FormOneMarks> copy_all) {
		return formOneDao.copyAvg(copy_all);
	}

	@Override
	public List<FormOneMarks_Report_Process> marks_avgs() {
		return formOneDao.marks_avgs();
	}

	@Override
	public int[] update_tt_avgs(List<FormOneMarks_Report_Process> up_all) {
		return formOneDao.update_tt_avgs(up_all);
	}

	@Override
	public List<FormOneMarks> rankList_ave() {
		
		return formOneDao.rankList_ave();
	}

	@Override
	public int[] c_rnk_average(List<FormOneMarks> crankAvg) {
		
		return formOneDao.c_rnk_average(crankAvg);
	}

	@Override
	public List<FormOneMarks_Report_Process> rank_av() {
		
		return formOneDao.rank_av();
	}

	@Override
	public int[] rnk_average(List<FormOneMarks_Report_Process> crankAv) {
		
		return formOneDao.rnk_average(crankAv);
	}

	@Override
	public List<FormOneMarks_Report_Process> selectAvToBackUp() {
		
		return formOneDao.selectAvToBackUp();
	}

	@Override
	public int[] bchAverageToBackUp(List<FormOneMarks_Report_Process> backup) {
		
		return formOneDao.bchAverageToBackUp(backup);
	}

	@Override
	public int[] deleteAl(List<FormOneMarks_Report_Process> backup) {
		
		return formOneDao.deleteAl(backup);
	}

	
}
