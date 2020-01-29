package com.skul.skul.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.dao.TeacherDao;
import com.skul.skul.model.Teachers;
import com.skul.skul.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	@Override
	public List<Teachers> getAll(String Stream, String form) {
		return teacherDao.getAll(Stream, form);
	}
	@Override
	public List<Teachers> get_principal_name() {
		return teacherDao.get_principal_name();
	}

}
