 package com.skul.skul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.StudentService;

@RequestMapping("/form_one_teacher")
@Controller
public class Form_one_class_teacher {
	@Autowired
	StudentRepository studentRepository; 
	
	@Autowired
	FormThreeMarksRepository formThreeMarksRepository;
		
	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/form1_2_student_updates")
	public String getnewStudent12Page(Model model) {
		List<Student> student_record =  studentRepository.findByForm_one("ONE");
		model.addAttribute("student_record", student_record);
	    return "students/formone";
	}
	
	@PostMapping("/save_one_student") // new student
    public String save_one_std(Student s,HttpServletRequest request) {
		studentRepository.save(s);
    	return "redirect:" + request.getHeader("Referer");
    }
	@PostMapping("/update_one_student") //update a student
    public String update_one_std(Student s,HttpServletRequest request) {
		studentService.update_std(s);
    	return "redirect:" + request.getHeader("Referer");
    }
	
	
	@GetMapping("/select_one_f1_std")
    @ResponseBody
	public Student getSelect_one_std(Long regno) {	    	    
		return studentService.findById(regno);
	}
	
	
	@GetMapping("/delete_f1_std")
    public String delete_std(Long regno,HttpServletRequest request) {	 
		
		studentRepository.deleteById(regno);
		return "redirect:" + request.getHeader("Referer");
	}
	
	
}
