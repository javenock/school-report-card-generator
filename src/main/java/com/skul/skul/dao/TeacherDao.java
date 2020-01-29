package com.skul.skul.dao;

import java.util.List;

import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Student;
import com.skul.skul.model.Teachers;

public interface TeacherDao {
	public List<Teachers> getAll(String Stream,String form);
	
	public List<Teachers> get_principal_name();
	
	
}
