package com.skul.skul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skul.skul.model.Student;
import com.skul.skul.repository.StudentRepository;

@RequestMapping("/form3_class_teacher")
@Controller
public class F3_class_teacher {
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/form_three_class_teacher_page") // class teacher page
	public String class_teacher_page() {
		return "class_teachre/form3_class_teacher";
	}
	@GetMapping(value = "/form3_student_updates")//student update
	public String getnewStudent34Page(Model model,Pageable pageable) {	
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);
	    return "students/formthree";  
	}
	@GetMapping("/form_three_analysis") // analysis page
	public String analysis_page(Model model) {
		return "form_three/analysis_page";
	}
	@GetMapping(value = "/form_three_reports") // report page
	public String getF3_ReportsPage(Model model) {	    	    
	    return "form_three/formthreereports";
	}
}
