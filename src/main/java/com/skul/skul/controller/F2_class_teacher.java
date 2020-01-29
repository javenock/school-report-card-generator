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

@RequestMapping("/form_two_teacher")
@Controller
public class F2_class_teacher {
	@Autowired
	StudentRepository studentRepository; 
	
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/form_2_student_updates")
	public String getnewStudent12Page(Model model) {
		List<Student> student_record =  studentRepository.findByForm_one("TWO");
		model.addAttribute("student_record", student_record);
	    return "students/formtwo";
	}	
	
	@GetMapping(value = "/f2_TeacherPage")
	public String getScimarks(Model model) {	    	    
	    return "class_teachre/form2_class_teacher";
	}
	
	@GetMapping(value = "/form_two_reports")
	public String getReportsPage(Model model) {	    	    
	    return "form_two/report/formreports";
	}
	
	@GetMapping(value = "/form_two_analysis")
	public String getAnalysisPage(Model model) {	    	    
	    return "form_two/report/analysis_page";
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
	
	
	@GetMapping("/select_one_f2_std")
    @ResponseBody
	public Student getSelect_one_std(Long regno) {	    	    
		return studentService.findById(regno);
	}
	
	
	@GetMapping("/delete_f2_std")
    public String delete_std(Long regno,HttpServletRequest request) {	 
		
		studentRepository.deleteById(regno);
		return "redirect:" + request.getHeader("Referer");
	}
	
	
	
	
	
	
}
