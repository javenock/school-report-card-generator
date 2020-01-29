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
import org.springframework.web.servlet.ModelAndView;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.service.FormThreeService;
@RequestMapping("/formthree_input")
@Controller
public class FormThreeController {

	@Autowired
	private FormThreeService formThreeService;
	
	@GetMapping("/form_three_languages")
	public String language_page() {
		return "form_three/form_three_inner/marks_input_languages";
	}
	@GetMapping("/form_three_science")
	public String science_page() {
		return "form_three/form_three_inner/marks_input_sciences";
	}
	@GetMapping("/form_three_humanity")
	public String humanity_page() {
		return "form_three/form_three_inner/marks_input_humanities";
	}
	@GetMapping("/form_three_technical")
	public String technical_page() {
		return "form_three/form_three_inner/marks_input_technicals";
	}
	
	@GetMapping("/findOne")
    @ResponseBody
    public FormThreeMarksEntry findOne(Long id) {    	
    	return formThreeService.findById(id);
    }    
	
    @PostMapping("/save")
    public String saveA(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/engMarksInput")
	public String getEngmarks(Model model) {
	   List<FormThreeMarksEntry> three_eng_mks_input = formThreeService.select_eng_ByStream();
	   model.addAttribute("three_eng_mks_input", three_eng_mks_input);	  
	    return "form_three/english";
	}
	
	@GetMapping(value = "/kisMarksInput")
	public String getKismarks(Model model) {
	   List<FormThreeMarksEntry> three_kis_mks_input = formThreeService.select_kis_ByStream();
	   model.addAttribute("three_kis_mks_input", three_kis_mks_input);	  
	    return "form_three/kiswahili";
	}
	@PostMapping("/save_kis")
    public String save_kis(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_kis(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/mathMarksInput")
	public String getmathmarks(Model model) {
	   List<FormThreeMarksEntry> three_math_mks_input = formThreeService.select_math_ByStream();
	   model.addAttribute("three_math_mks_input", three_math_mks_input);	  
	    return "form_three/mathematics";
	}
	@PostMapping("/save_math")
    public String save_math(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_math(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/bioMarksInput")
	public String getbiomarks(Model model) {
	   List<FormThreeMarksEntry> three_bio_mks_input = formThreeService.select_bio_ByStream();
	   model.addAttribute("three_bio_mks_input", three_bio_mks_input);	  
	    return "form_three/biology";
	}
	@PostMapping("/save_bio")
    public String save_bio(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_bio(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/chemMarksInput")
	public String getchemmarks(Model model) {
	   List<FormThreeMarksEntry> three_chem_mks_input = formThreeService.select_chem_ByStream();
	   model.addAttribute("three_chem_mks_input", three_chem_mks_input);	  
	    return "form_three/chemistry";
	}
	@PostMapping("/save_chem")
    public String save_chem(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_chem(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/phyMarksInput")
	public String getphymarks(Model model) {
	   List<FormThreeMarksEntry> three_phy_mks_input = formThreeService.select_phy_ByStream();
	   model.addAttribute("three_phy_mks_input", three_phy_mks_input);	  
	    return "form_three/physics";
	}
	@PostMapping("/save_phy")
    public String save_phy(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_phy(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/geoMarksInput")
	public String getGeomarks(Model model) {
	   List<FormThreeMarksEntry> three_geo_mks_input = formThreeService.select_geo_ByStream();
	   model.addAttribute("three_geo_mks_input", three_geo_mks_input);	  
	    return "form_three/geography";
	}
	@PostMapping("/save_geo")
    public String save_geo(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_geo(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping(value = "/hisMarksInput")
	public String gethismarks(Model model) {
	   List<FormThreeMarksEntry> three_his_mks_input = formThreeService.select_his_ByStream();
	   model.addAttribute("three_his_mks_input", three_his_mks_input);	  
	    return "form_three/history";
	}
	@PostMapping("/save_his")
    public String save_his(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_his(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/creMarksInput")
	public String getcremarks(Model model) {
	   List<FormThreeMarksEntry> three_cre_mks_input = formThreeService.select_cre_ByStream();
	   model.addAttribute("three_cre_mks_input", three_cre_mks_input);	  
	    return "form_three/cre";
	}
	@PostMapping("/save_cre")
    public String save_cre(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_cre(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/agricMarksInput")
	public String getagricmarks(Model model) {
	   List<FormThreeMarksEntry> three_agric_mks_input = formThreeService.select_agric_ByStream();
	   model.addAttribute("three_agric_mks_input", three_agric_mks_input);	  
	    return "form_three/agriculture";
	}
	@PostMapping("/save_agric")
    public String save_agric(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_agric(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/bizMarksInput")
	public String getbizmarks(Model model) {
	   List<FormThreeMarksEntry> three_biz_mks_input = formThreeService.select_biz_ByStream();
	   model.addAttribute("three_biz_mks_input", three_biz_mks_input);	  
	    return "form_three/business";
	}
	@PostMapping("/save_biz")
    public String save_biz(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_biz(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/compMarksInput")
	public String getcompmarks(Model model) {
	   List<FormThreeMarksEntry> three_comp_mks_input = formThreeService.select_comp_ByStream();
	   model.addAttribute("three_comp_mks_input", three_comp_mks_input);	  
	    return "form_three/computer";
	}
	@PostMapping("/save_comp")
    public String save_comp(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_comp(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/homMarksInput")
	public String gethommarks(Model model) {
	   List<FormThreeMarksEntry> three_hom_mks_input = formThreeService.select_hom_ByStream();
	   model.addAttribute("three_hom_mks_input", three_hom_mks_input);	  
	    return "form_three/homescience";
	}
	@PostMapping("/save_hom")
    public String save_hom(FormThreeMarksEntry s,HttpServletRequest request) {
    	formThreeService.update_hom(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }	
	
	
}
