package com.skul.skul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.service.MyPdfService;
@Service
public class MyPdfServiceImpl implements MyPdfService{

	@Autowired
	FormThreeMarksRepository formThreeMarksRepository;
	
	@Override
	public List<FormThreeMarksEntry> getAll() {
		
		return formThreeMarksRepository.findAll();
	}

}
