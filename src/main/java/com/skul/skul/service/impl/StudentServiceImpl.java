package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.StudentDao;
import com.skul.skul.model.Student;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.StudentService;
import com.skul.skul.utils.CommonGradeUtils;
import com.skul.skul.utils.Student_kcpe_marks_util;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentDao studentDao;
		
	@Override
	public List<Student> findAll() {
		
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		
		return studentRepository.getOne(id);
	}

	@Override
	public Student save(Student s) {
		s.setKcpemean(Student_kcpe_marks_util.kcpemarks_mean(s.getKcpemarks()));
		s.setKcpegrade(Student_kcpe_marks_util.averageGrade(Double.parseDouble(Student_kcpe_marks_util.kcpemarks_mean(s.getKcpemarks()))));
		return studentRepository.saveAndFlush(s);
		
	}

	@Override
	public List<Student> getAllStudent_form_one() {
		return studentDao.getAllStudent_form_one();
	}

	@Override
	public List<Student> getAllStudent_form_Three() {
		return studentDao.getAllStudent_form_Three();
	}

	@Override
	public List<Student> selectAll_north_students(String stream,String form) {
		return studentDao.selectAll_north_students(stream, form);
	}

	@Override
	public void update_chem_sub(Student e) {
		studentDao.update_chem_sub(e);
	}

	@Override
	public void update_phy_sub(Student e) {
		studentDao.update_phy_sub(e);
	}

	@Override
	public void update_geo_sub(Student e) {
		studentDao.update_geo_sub(e);
	}

	@Override
	public void update_his_sub(Student e) {
		studentDao.update_his_sub(e);
	}

	@Override
	public void update_cre_sub(Student e) {
		studentDao.update_cre_sub(e);
	}

	@Override
	public void update_agric_sub(Student e) {
		studentDao.update_agric_sub(e);
	}

	@Override
	public void update_biz_sub(Student e) {
		studentDao.update_biz_sub(e);
	}

	@Override
	public void update_comp_sub(Student e) {
		studentDao.update_comp_sub(e);
	}

	@Override
	public void update_hom_sub(Student e) {
		studentDao.update_hom_sub(e);
	}

	@Override
	public List<Student> selectAll_subno_students() {
		return studentDao.selectAll_subno_students();
	}

	@Override
	public int[] sabono(List<Student> sabno) {
		return studentDao.sabono(sabno);
	}

	@Override
	public void update_std(Student e) {
		 studentDao.update_std(e);
		
	}

	@Override
	public List<Student> getAllStudent_form_four() {
		return studentDao.getAllStudent_form_four();
	}

	@Override
	public List<Student> getAllStudent_form_two() {
		return studentDao.getAllStudent_form_two();
	}

	

}
