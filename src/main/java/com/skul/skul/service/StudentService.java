package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.Student;

public interface StudentService {

	//List<Student> findAll();
	
	public List<Student> findAll();
	Student findById(Long regno);
	Student save(Student s);
	
	public List<Student> getAllStudent_form_one();
	
	public List<Student> getAllStudent_form_Three();
	
	public List<Student> selectAll_north_students(String stream, String form);
	public void update_chem_sub(Student e);
	public void update_phy_sub(Student e);
	public void update_geo_sub(Student e);
	public void update_his_sub(Student e);
	public void update_cre_sub(Student e);
	public void update_agric_sub(Student e);
	public void update_biz_sub(Student e);
	public void update_comp_sub(Student e);
	public void update_hom_sub(Student e);
	public List<Student> selectAll_subno_students();
	public int[] sabono(List<Student> sabno);
	public List<Student> getAllStudent_form_four();
	public void update_std(Student e);
	public List<Student> getAllStudent_form_two();
	
}
