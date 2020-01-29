package com.skul.skul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skul.skul.model.Student;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.FormOneSubjectRankingService;
import com.skul.skul.service.StudentService;
import com.skul.skul.service.TeacherService;



@RequestMapping("/class_teacher")
@Controller
public class FormOne_Class_Teacher {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	FormOneSubjectRankingService formOneSubjectRankingService;
	
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(value = "/classTeacherPage")
	public String getScimarks(Model model) {	    	    
	    return "class_teachre/form1_class_teacher";
	}
	@GetMapping(value = "/form_one_reports")
	public String getReportsPage(Model model) {	    	    
	    return "formOne/formreports";
	}
		
	@GetMapping(value = "/form1_2_student_updates")
	public String getnewStudent12Page(Model model) {
		List<Student> student_record =  studentRepository.findByForm_one("ONE");
		model.addAttribute("student_record", student_record);
	    return "students/formone";
	}
	@GetMapping("/form_one_analysis")
	public String analysis_page(Model model) {
		return "formone/analysis_page";
	}
}
