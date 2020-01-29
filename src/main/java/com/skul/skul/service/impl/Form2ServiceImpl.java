package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.Form2Dao;
import com.skul.skul.model.Form2Marks;
import com.skul.skul.model.Form2Marks_Report_Process;
import com.skul.skul.model.Student;
import com.skul.skul.repository.Form2MarksRepository;
import com.skul.skul.service.Form2Service;

@Service
public class Form2ServiceImpl implements Form2Service{

	@Autowired
	private Form2Dao form2Dao;
	
	@Autowired
	private Form2MarksRepository Form2MarksRepository;
	
	@Override
	public Form2Marks findById(Long regno) {
		return Form2MarksRepository.getOne(regno);
	}
	
	@Override
	public void update(Form2Marks e) {
		form2Dao.update(e);		
	}
	@Override
	public List<Form2Marks> select_eng_ByStream() {		
		return form2Dao.select_eng_ByStream();
	}
	
	@Override
	public void update_sci(Form2Marks e) {
		form2Dao.update_sci(e);		
	}
	@Override
	public List<Form2Marks> select_sci_ByStream() {		
		return form2Dao.select_sci_ByStream();
	}
	@Override
	public void update_hum(Form2Marks e) {
		form2Dao.update_hum(e);		
	}
	@Override
	public List<Form2Marks> select_hum_ByStream() {		
		return form2Dao.select_hum_ByStream();
	}
	@Override
	public void update_tech(Form2Marks e) {
		form2Dao.update_tech(e);		
	}
	@Override
	public List<Form2Marks> select_tech_ByStream() {
		return form2Dao.select_tech_ByStream();
	}

	@Override
	public List<Form2Marks> select_All_formOne_Marks() {
		return Form2MarksRepository.findAll();
	}

	@Override
	public List<Student> select_students_ToLoad() {		
		return form2Dao.select_students_ToLoad();
	}

	@Override
	public int[] select_all_students(List<Student> copy_all) {
		return form2Dao.select_all_students(copy_all);
	}

	@Override
	public void updateExamType(String exmtype) {
		form2Dao.updateExamType(exmtype);
	}

	@Override
	public void updateTerm(String term) {
		form2Dao.updateTerm(term);
	}

	@Override
	public List<Form2Marks> total_marks() {
		return form2Dao.total_marks();
	}

	@Override
	public int[] batchUpdate_FormTwo_tt(List<Form2Marks> form_tt) {
		return form2Dao.batchUpdate_FormTwo_tt(form_tt);
	}

	@Override
	public List<Form2Marks> rankList() {
		return form2Dao.rankList();
	}

	@Override
	public int[] c_rank(List<Form2Marks> crank) {
		return form2Dao.c_rank(crank);
	}

	@Override
	public List<Form2Marks> rank_ave() {
		return form2Dao.rank_ave();
	}

	@Override
	public int[] rank_average(List<Form2Marks> crankAvg) {
		return form2Dao.rank_average(crankAvg);
	}

	@Override
	public List<Form2Marks> selectAverageToBackUp() { // use tyhia method
		return Form2MarksRepository.findAll();
	}

	@Override
	public  void deleteAll(List<Form2Marks> backup) {
		 Form2MarksRepository.deleteAllInBatch();		  
	}

	@Override
	public int[] batchAverageToBackUp(List<Form2Marks> backup) {
		return form2Dao.batchAverageToBackUp(backup);
	}

	@Override
	public List<Form2Marks> select_avgs(String year, String term) {
		return form2Dao.select_avgs(year, term);
	}

	@Override
	public int[] copyAvg(List<Form2Marks> copy_all) {
		return form2Dao.copyAvg(copy_all);
	}

	@Override
	public List<Form2Marks_Report_Process> marks_avgs() {
		return form2Dao.marks_avgs();
	}

	@Override
	public int[] update_tt_avgs(List<Form2Marks_Report_Process> up_all) {
		return form2Dao.update_tt_avgs(up_all);
	}

	@Override
	public List<Form2Marks> rankList_ave() {
		
		return form2Dao.rankList_ave();
	}

	@Override
	public int[] c_rnk_average(List<Form2Marks> crankAvg) {
		
		return form2Dao.c_rnk_average(crankAvg);
	}

	@Override
	public List<Form2Marks_Report_Process> rank_av() {
		
		return form2Dao.rank_av();
	}

	@Override
	public int[] rnk_average(List<Form2Marks_Report_Process> crankAv) {
		
		return form2Dao.rnk_average(crankAv);
	}

	@Override
	public List<Form2Marks_Report_Process> selectAvToBackUp() {
		
		return form2Dao.selectAvToBackUp();
	}

	@Override
	public int[] bchAverageToBackUp(List<Form2Marks_Report_Process> backup) {
		
		return form2Dao.bchAverageToBackUp(backup);
	}

	@Override
	public int[] deleteAl(List<Form2Marks_Report_Process> backup) {
		
		return form2Dao.deleteAl(backup);
	}

	
}
