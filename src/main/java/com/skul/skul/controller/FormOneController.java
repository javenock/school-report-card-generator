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

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.service.FormOneService;
@RequestMapping("/form_one")
@Controller
public class FormOneController {
	
	@Autowired
	private FormOneService formOneService;

		
	@GetMapping("/findOne_std_marks")
    @ResponseBody
    public FormOneMarks findOne(Long id) {
    	
    	return formOneService.findById(id);
    }
    
    @PostMapping("/save")
    public String saveA(FormOneMarks s,HttpServletRequest request) {
    	formOneService.update(s);
    	
    	return "redirect:" + request.getHeader("Referer");	
    	
    }
    
    @GetMapping(value = "/engMarksInput")
	public String getEngmarks(Model model) {
	    List<FormOneMarks> eng_mks_input = formOneService.select_eng_ByStream();
	    model.addAttribute("eng_mks_input", eng_mks_input);	  
	    return "formOne/formOneeng";
	}
	
	
	 @RequestMapping(value = "/sciMarksInput")
	public String getScimarks(Model model) {
	    List<FormOneMarks> sci_mks_input = formOneService.select_sci_ByStream();
	    model.addAttribute("sci_mks_input", sci_mks_input);	    
	    return "formOne/sci";
	}
	 
	 @PostMapping("/save_sci")
	 public String saveSci(FormOneMarks s,HttpServletRequest request) {
	    	formOneService.update_sci(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	
	@RequestMapping(value = "/humMarksInput")
	public String getHummarks(Model model) {
	    List<FormOneMarks> hum_mks_input = formOneService.select_hum_ByStream();
	    model.addAttribute("hum_mks_input", hum_mks_input);	    
	    return "formOne/hum";
	}
	@PostMapping("/save_hum")
	 public String saveHum(FormOneMarks s,HttpServletRequest request) {
	    	formOneService.update_hum(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	@RequestMapping(value = "/techMarksInput")
	public String getTechmarks(Model model) {
	    List<FormOneMarks> tech_mks_input = formOneService.select_tech_ByStream();
	    model.addAttribute("tech_mks_input", tech_mks_input);	    
	    return "formOne/tech";
	}
	@PostMapping("/save_tech")
	 public String saveTech(FormOneMarks s,HttpServletRequest request) {
	    	formOneService.update_tech(s);
	    	return "redirect:" + request.getHeader("Referer");	
	    	
	    }
	
	
	
	
	
	
}
