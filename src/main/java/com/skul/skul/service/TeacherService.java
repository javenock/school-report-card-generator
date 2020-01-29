package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.Teachers;

public interface TeacherService {
	public List<Teachers> getAll(String Stream, String form);
	
	public List<Teachers> get_principal_name();
}
