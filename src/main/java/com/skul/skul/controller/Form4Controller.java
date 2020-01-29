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

import com.skul.skul.model.Form4MarksEntry;
import com.skul.skul.service.Form4Service;
@RequestMapping("/formfour_input")
@Controller
public class Form4Controller {

	@Autowired
	private Form4Service form4Service;
	
	@GetMapping("/form_four_languages")
	public String language_page() {
		return "form_four/form_four_inner/marks_input_languages";
	}
	@GetMapping("/form_four_science")
	public String science_page() {
		return "form_four/form_four_inner/marks_input_sciences";
	}
	@GetMapping("/form_four_humanity")
	public String humanity_page() {
		return "form_four/form_four_inner/marks_input_humanities";
	}
	@GetMapping("/form_four_technical")
	public String technical_page() {
		return "form_four/form_four_inner/marks_input_technicals";
	}
	
	@GetMapping("/findOne")
    @ResponseBody
    public Form4MarksEntry findOne(Long id) {    	
    	return form4Service.findById(id);
    }    
	
    @PostMapping("/save")
    public String saveA(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/engMarksInput")
	public String getEngmarks(Model model) {
	   List<Form4MarksEntry> four_eng_mks_input = form4Service.select_eng_ByStream();
	   model.addAttribute("four_eng_mks_input", four_eng_mks_input);	  
	    return "form_four/english";
	}
	
	@GetMapping(value = "/kisMarksInput")
	public String getKismarks(Model model) {
	   List<Form4MarksEntry> four_kis_mks_input = form4Service.select_kis_ByStream();
	   model.addAttribute("four_kis_mks_input", four_kis_mks_input);	  
	    return "form_four/kiswahili";
	}
	@PostMapping("/save_kis")
    public String save_kis(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_kis(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/mathMarksInput")
	public String getmathmarks(Model model) {
	   List<Form4MarksEntry> four_math_mks_input = form4Service.select_math_ByStream();
	   model.addAttribute("four_math_mks_input", four_math_mks_input);	  
	    return "form_four/mathematics";
	}
	@PostMapping("/save_math")
    public String save_math(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_math(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/bioMarksInput")
	public String getbiomarks(Model model) {
	   List<Form4MarksEntry> four_bio_mks_input = form4Service.select_bio_ByStream();
	   model.addAttribute("four_bio_mks_input", four_bio_mks_input);	  
	    return "form_four/biology";
	}
	@PostMapping("/save_bio")
    public String save_bio(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_bio(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/chemMarksInput")
	public String getchemmarks(Model model) {
	   List<Form4MarksEntry> four_chem_mks_input = form4Service.select_chem_ByStream();
	   model.addAttribute("four_chem_mks_input", four_chem_mks_input);	  
	    return "form_four/chemistry";
	}
	@PostMapping("/save_chem")
    public String save_chem(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_chem(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/phyMarksInput")
	public String getphymarks(Model model) {
	   List<Form4MarksEntry> four_phy_mks_input = form4Service.select_phy_ByStream();
	   model.addAttribute("four_phy_mks_input", four_phy_mks_input);	  
	    return "form_four/physics";
	}
	@PostMapping("/save_phy")
    public String save_phy(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_phy(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/geoMarksInput")
	public String getGeomarks(Model model) {
	   List<Form4MarksEntry> four_geo_mks_input = form4Service.select_geo_ByStream();
	   model.addAttribute("four_geo_mks_input", four_geo_mks_input);	  
	    return "form_four/geography";
	}
	@PostMapping("/save_geo")
    public String save_geo(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_geo(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	@GetMapping(value = "/hisMarksInput")
	public String gethismarks(Model model) {
	   List<Form4MarksEntry> four_his_mks_input = form4Service.select_his_ByStream();
	   model.addAttribute("four_his_mks_input", four_his_mks_input);	  
	    return "form_four/history";
	}
	@PostMapping("/save_his")
    public String save_his(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_his(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/creMarksInput")
	public String getcremarks(Model model) {
	   List<Form4MarksEntry> four_cre_mks_input = form4Service.select_cre_ByStream();
	   model.addAttribute("four_cre_mks_input", four_cre_mks_input);	  
	    return "form_four/cre";
	}
	@PostMapping("/save_cre")
    public String save_cre(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_cre(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/agricMarksInput")
	public String getagricmarks(Model model) {
	   List<Form4MarksEntry> four_agric_mks_input = form4Service.select_agric_ByStream();
	   model.addAttribute("four_agric_mks_input", four_agric_mks_input);	  
	    return "form_four/agriculture";
	}
	@PostMapping("/save_agric")
    public String save_agric(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_agric(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/bizMarksInput")
	public String getbizmarks(Model model) {
	   List<Form4MarksEntry> four_biz_mks_input = form4Service.select_biz_ByStream();
	   model.addAttribute("four_biz_mks_input", four_biz_mks_input);	  
	    return "form_four/business";
	}
	@PostMapping("/save_biz")
    public String save_biz(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_biz(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/compMarksInput")
	public String getcompmarks(Model model) {
	   List<Form4MarksEntry> four_comp_mks_input = form4Service.select_comp_ByStream();
	   model.addAttribute("four_comp_mks_input", four_comp_mks_input);	  
	    return "form_four/computer";
	}
	@PostMapping("/save_comp")
    public String save_comp(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_comp(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }
	
	@GetMapping(value = "/homMarksInput")
	public String gethommarks(Model model) {
	   List<Form4MarksEntry> four_hom_mks_input = form4Service.select_hom_ByStream();
	   model.addAttribute("four_hom_mks_input", four_hom_mks_input);	  
	    return "form_four/homescience";
	}
	@PostMapping("/save_hom")
    public String save_hom(Form4MarksEntry s,HttpServletRequest request) {
    	form4Service.update_hom(s);    	
    	return "redirect:" + request.getHeader("Referer");
    }	
	
	
}
