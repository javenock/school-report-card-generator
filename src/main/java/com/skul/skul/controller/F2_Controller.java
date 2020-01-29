package com.skul.skul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skul.skul.model.Form2Marks;
import com.skul.skul.service.Form2Service;
@RequestMapping("/form_2_")
@Controller
public class F2_Controller {
	
	@Autowired
	private Form2Service form2Service;

		
	@GetMapping("/form2_marks_input")
	public String formTwoMarksInput(Model model) {		
		return "form_two/input_page";
	}
	
	@GetMapping("/findTwo_std_marks")
    @ResponseBody
    public Form2Marks findOne(Long id) {
    	
    	return form2Service.findById(id);
    }
    
    @PostMapping("/save")
    public String saveA(Form2Marks s,HttpServletRequest request) {
    	form2Service.update(s);    	
    	return "redirect:" + request.getHeader("Referer");	
    	
    }
    
    @GetMapping(value = "/langMarksInput")
	public String getEngmarks(Model model) {
	    List<Form2Marks> eng_mks_input = form2Service.select_eng_ByStream();
	    model.addAttribute("eng_mks_input", eng_mks_input);	  
	    return "form_two/marks_input_screens/languages";
	}
	
	
	 @RequestMapping(value = "/sciMarksInput")
	public String getScimarks(Model model) {
	    List<Form2Marks> sci_mks_input = form2Service.select_sci_ByStream();
	    model.addAttribute("sci_mks_input", sci_mks_input);	    
	    return "form_two/marks_input_screens/sci";
	}
	 
	 @PostMapping("/save_sci")
	 public String saveSci(Form2Marks s,HttpServletRequest request) {
	    	form2Service.update_sci(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	
	@RequestMapping(value = "/humMarksInput")
	public String getHummarks(Model model) {
	    List<Form2Marks> hum_mks_input = form2Service.select_hum_ByStream();
	    model.addAttribute("hum_mks_input", hum_mks_input);	    
	    return "form_two/marks_input_screens/hum";
	}
	@PostMapping("/save_hum")
	 public String saveHum(Form2Marks s,HttpServletRequest request) {
	    	form2Service.update_hum(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	@RequestMapping(value = "/techMarksInput")
	public String getTechmarks(Model model) {
	    List<Form2Marks> tech_mks_input = form2Service.select_tech_ByStream();
	    model.addAttribute("tech_mks_input", tech_mks_input);	    
	    return "form_two/marks_input_screens/tech";
	}
	@PostMapping("/save_tech")
	 public String saveTech(Form2Marks s,HttpServletRequest request) {
	    	form2Service.update_tech(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	
	
	
	
	
	
}
