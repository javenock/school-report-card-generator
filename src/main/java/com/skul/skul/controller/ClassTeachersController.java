package com.skul.skul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.FormThreeService;
import com.skul.skul.service.StudentService;
@RequestMapping("/_teacher")
@Controller
public class ClassTeachersController {

	@Autowired
	StudentRepository studentRepository; 
	
	@Autowired
	FormThreeMarksRepository formThreeMarksRepository;
		
	@Autowired
	StudentService studentService;
		
	
	@PostMapping("/save_three_student")
    public String save_three_std(Student s,HttpServletRequest request) {
		//studentService.update_std(s);
		studentRepository.save(s);
    	return "redirect:" + request.getHeader("Referer");
    }
	@PostMapping("/update_three_student")
    public String update_three_std(Student s,HttpServletRequest request) {
		studentService.update_std(s);
		//studentRepository.save(s);
    	return "redirect:" + request.getHeader("Referer");
    }
	@PostMapping("/save_one_student")
    public String save_one_std(Student s,HttpServletRequest request) {
		//studentService.save(s);
		studentRepository.saveAndFlush(s);
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping("/select_one_f3_std")
    @ResponseBody
	public Student getSelect_one_std(Long regno) {	    	    
		return studentService.findById(regno);
	}
	
	
	@GetMapping("/delete_f3_std")
    public String delete_std(Long regno,HttpServletRequest request) {	 
		
		studentRepository.deleteById(regno);
		return "redirect:" + request.getHeader("Referer");
	}
	
	@GetMapping("/subject")
	public String subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/sabo";
	}
	
	@GetMapping("/subject_chem")
	public String chem_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/chem";
	}
	@PostMapping("/save_chem_sub")
    public String save_chem_sub(Student s,HttpServletRequest request) {
		studentService.update_chem_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_phy")
	public String phy_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/phy";
	}
	@PostMapping("/save_phy_sub")
    public String save_phy_sub(Student s,HttpServletRequest request) {
		studentService.update_phy_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@PostMapping("/save_geo_sub")
    public String save_geo_sub(Student s,HttpServletRequest request) {
		studentService.update_geo_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_his")
	public String his_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/his";
	}
	@PostMapping("/save_his_sub")
    public String save_his_sub(Student s,HttpServletRequest request) {
		studentService.update_his_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_cre")
	public String cre_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/cre";
	}
	@PostMapping("/save_cre_sub")
    public String save_cre_sub(Student s,HttpServletRequest request) {
		studentService.update_cre_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_agric")
	public String agric_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/agric";
	}
	@PostMapping("/save_agric_sub")
    public String save_agric_sub(Student s,HttpServletRequest request) {
		studentService.update_agric_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_biz")
	public String biz_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/biz";
	}
	@PostMapping("/save_biz_sub")
    public String save_biz_sub(Student s,HttpServletRequest request) {
		studentService.update_biz_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_comp")
	public String comp_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/comp";
	}
	@PostMapping("/save_comp_sub")
    public String save_comp_sub(Student s,HttpServletRequest request) {
		studentService.update_comp_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping("/subject_hom")
	public String hom_subject_page(Pageable pageable, Model model) {
		List<Student> student_record =  studentRepository.findByForm("THREE");
		model.addAttribute("student_record", student_record);	  
		    return "form_three/form_three_inner_one/hom";
	}
	@PostMapping("/save_hom_sub")
    public String save_hom_sub(Student s,HttpServletRequest request) {
		studentService.update_hom_sub(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }	
	
	@GetMapping("/chits_page_languages")
	public String chits_page_languages(Model model) {		
		List<FormThreeMarksEntry> rowMarks = formThreeMarksRepository.findAll();
		model.addAttribute("rowMarks",rowMarks);
		    return "chits/form_three/chit_lang";
	}
	@GetMapping("/chits_page_bio")
	public String chits_page_bio(Model model) {
		    return "chits/form_three/chit_bio";
	}
	@GetMapping("/chits_page_chem")
	public String chits_page_chem(Model model) {
		    return "chits/form_three/chit_chem";
	}	
	@GetMapping("/chits_page_phy")
	public String chits_page_phy(Model model) {
		    return "chits/form_three/chit_phy";
	}
	@GetMapping("/chits_page_geo")
	public String chits_page_geo(Model model) {
		    return "chits/form_three/chit_geo";
	}
	@GetMapping("/chits_page_his")
	public String chits_page_his(Model model) {
		    return "chits/form_three/chit_his";
	}
	@GetMapping("/chits_page_cre")
	public String chits_page_cre(Model model) {
		    return "chits/form_three/chit_cre";
	}
	@GetMapping("/chits_page_agric")
	public String chits_page_agric(Model model) {
		    return "chits/form_three/chit_agric";
	}
	@GetMapping("/chits_page_biz")
	public String chits_page_biz(Model model) {
		    return "chits/form_three/chit_biz";
	}
	@GetMapping("/chits_page_comp")
	public String chits_page_comp(Model model) {
		    return "chits/form_three/chit_comp";
	}
	@GetMapping("/chits_page_hom")
	public String chits_page_hom(Model model) {
		    return "chits/form_three/chit_hom";
	}
	@GetMapping("/no_subject")
	public String subject_no( Model model,HttpServletRequest request) {
		List<Student> stdsabo = studentService.selectAll_subno_students();
		int[] bpdate = studentService.sabono(stdsabo);
		model.addAttribute(bpdate.length);
		return "redirect:" + request.getHeader("Referer");
		  
	}
	
}
