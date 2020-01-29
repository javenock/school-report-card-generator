package com.skul.skul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Formthreebasebackup;
import com.skul.skul.model.Formthreemarksreportprocess;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormThreeMarksRepository;
import com.skul.skul.repository.FormthreemarksreportprocessRepository;
import com.skul.skul.service.FormThreeService;
import com.skul.skul.service.FormThreeSubjectRankingService;

@RequestMapping("/form_three_admin")
@Controller
public class FormThreeAdmin {

	@Autowired
	FormThreeService formThreeService;
	
	@Autowired
	FormThreeMarksRepository formThreeMarksRepository;
	
	@Autowired
	FormthreemarksreportprocessRepository formthreemarksreportprocessRepository;
	@Autowired
	FormThreeSubjectRankingService formThreeSubjectRankingService;
	
	@GetMapping("/form_three_admin_screen")
	public String index_page() {
		return "admin/form_three_admin_screen";
	}
	
	@GetMapping("/form_three_new_exam")
	public String new_page(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<FormThreeMarksEntry> page = formThreeMarksRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/new_exam_f3";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/form_three_report")
	public String report_page(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<Formthreemarksreportprocess> page3 = formthreemarksreportprocessRepository.findAll(pageable);
		model.addAttribute("page3", page3);
		return "admin/form3_reports_page";
	}
	
	
	
	@GetMapping(value="/formthreedetails") //loads student details for a new exam
	public String copy_std4One_toMarks(Model model) {		
		List<Student> crank = formThreeService.select_students_ToLoad();	
		int[] bpdate = formThreeService.select_all_students(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/form_three_admin/form_three_new_exam"; //admin/formone_new_exam";
	}
	
	
	@GetMapping(value = "/examtypeupdate/{type}")
	public String exmTypeUpdate(@PathVariable String type, Model model) {
		formThreeService.updateExamType(type);						    
	    model.addAttribute("type", type);
	    return "redirect:/form_three_admin/form_three_new_exam";
	}
	
	@GetMapping(value = "/examtypeupdate")
	public String getexmTypeUpdateValue(@ModelAttribute("type") String type,Model model) {
	    if (type.equalsIgnoreCase("all")){
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/form_three_admin/examtypeupdate/" + type;          
	    }
	}
	
	@GetMapping(value = "/termupdate/{term}")
	public String updateTerm(@PathVariable String term, Model model) {
		formThreeService.updateTerm(term);						    
	    model.addAttribute("term", term);
	    return "redirect:/form_three_admin/form_three_new_exam";
	}
	
	@GetMapping(value = "/termupdate")
	public String getTermValue(@ModelAttribute("term") String term,Model model) {
	    if (term.equalsIgnoreCase("all")) {
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/form_three_admin/termupdate/" + term;          
	    }
	}
	
	@GetMapping(value="/form_totla")
	public String totla_marks(ModelAndView model, HttpServletRequest request) {		
		List<FormThreeMarksEntry> oneMarks = formThreeService.sumup();			
		int[] bpdate = formThreeService.batchUpdate_FormThree_tt(oneMarks);
		model.addObject("rows", bpdate.length);
		
		return "redirect:/form_three_admin/form_three_new_exam";
	}
	
	@GetMapping(value="/formoneclassranking")
	public String classRank(Model model) {		
		List<FormThreeMarksEntry> crank = formThreeService.rankList();		
		int[] bpdate = formThreeService.c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/form_three_admin/form_three_new_exam";
	}	
	@GetMapping(value ="/markListAverage")
	public String getListAve(ModelAndView model, HttpServletRequest request) {
		List<FormThreeMarksEntry> crank_av = formThreeService.rank_ave();		
		int[] bpd = formThreeService.rank_average(crank_av);	
		model.addObject(bpd.length);
		return "redirect:/form_three_admin/form_three_new_exam";
			}
	@RequestMapping(value = "/backup")
	public String getMarksToBackUp(Model model) {
	    List<FormThreeMarksEntry> marksAvgToBackUp = formThreeService.selectAverageToBackUp();
	    int[] bpdate = formThreeService.batchAverageToBackUp(marksAvgToBackUp);
	    formThreeService.deleteAll(marksAvgToBackUp);	  
		model.addAttribute(bpdate.length);
		return "redirect:/form_three_admin/form_three_new_exam";
	}
	@GetMapping(value = "/loadTermYearAvg/{year}/{term}")
	public String getTermYearAvg(@PathVariable String year,@PathVariable String term, @PageableDefault(size = 10) Pageable pageable, Model model) {
	  List<Formthreebasebackup> formOneavg = formThreeService.select_avgs(year, term);
	   int[] bpdate = formThreeService.copyAvg(formOneavg);
		model.addAttribute("rows", bpdate.length);
		return "redirect:/form_three_admin/form_three_report";
	}
	
	@GetMapping(value = "/loadTermYearAvg")
	public String getTermYearValues(@ModelAttribute("year") String year,@ModelAttribute("term") String term,Model model) {
	    if (year.equalsIgnoreCase("all") || term.equalsIgnoreCase("all") ) {
	        return "redirect:/form_three_admin/form_three_report/";
	    } else {
	        return "redirect:/form_three_admin/loadTermYearAvg/" + year +"/" + term;          
	    }
	}
	@GetMapping(value="/form_total_avgs")
	public String total_avgs(ModelAndView model, HttpServletRequest request) {		
		List<Formthreemarksreportprocess> up_all = formThreeService._form3_tt();			
		int[] bpdate = formThreeService.batchUpdate_Form3_tt(up_all);
		model.addObject("rows", bpdate.length);		
		return "redirect:/form_three_admin/form_three_report";
	}
	@GetMapping(value="/form3classranking")
	public String f3classRank(Model model) {		
		List<Formthreemarksreportprocess> crank = formThreeService.f3_rankList();		
		int[] bpdate = formThreeService.f3_c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/form_three_admin/form_three_report";
	}	
	@GetMapping(value ="/f3markListAverage")
	public String getF3ListAve(ModelAndView model, HttpServletRequest request) {
		List<Formthreemarksreportprocess> crank_av = formThreeService.f3_rank_ave();		
		int[] bpd = formThreeService.f3_rank_average(crank_av);	
		model.addObject(bpd.length);
		List<Formthreemarksreportprocess> crank_eng = formThreeSubjectRankingService.sub_rank_ave();		
		int[] bpdo = formThreeSubjectRankingService.sub_rank_average(crank_eng);
		model.addObject(bpdo.length);
		
		List<Formthreemarksreportprocess> crank_kis = formThreeSubjectRankingService.sub_rank_kis();		
		int[] bpd1 = formThreeSubjectRankingService.sub_rank_kis(crank_kis);
		model.addObject(bpd1.length);
		
		List<Formthreemarksreportprocess> crank_math = formThreeSubjectRankingService.sub_rank_math();		
		int[] bpd2 = formThreeSubjectRankingService.sub_rank_math(crank_math);
		model.addObject(bpd2.length);
		
		List<Formthreemarksreportprocess> crank_bio = formThreeSubjectRankingService.sub_rank_bio();		
		int[] bpd3 = formThreeSubjectRankingService.sub_rank_bio(crank_bio);
		model.addObject(bpd3.length);
		
		List<Formthreemarksreportprocess> crank_chem = formThreeSubjectRankingService.sub_rank_chem();		
		int[] bpd4 = formThreeSubjectRankingService.sub_rank_chem(crank_chem);
		model.addObject(bpd4.length);
		
		List<Formthreemarksreportprocess> crank_phy = formThreeSubjectRankingService.sub_rank_phy();		
		int[] bpd5 = formThreeSubjectRankingService.sub_rank_phy(crank_phy);
		model.addObject(bpd5.length);
		
		List<Formthreemarksreportprocess> crank_geo = formThreeSubjectRankingService.sub_rank_geo();		
		int[] bpd6 = formThreeSubjectRankingService.sub_rank_geo(crank_geo);
		model.addObject(bpd6.length);
		
		List<Formthreemarksreportprocess> crank_his = formThreeSubjectRankingService.sub_rank_his();		
		int[] bpd7 = formThreeSubjectRankingService.sub_rank_his(crank_his);
		model.addObject(bpd7.length);
		
		List<Formthreemarksreportprocess> crank_cre = formThreeSubjectRankingService.sub_rank_cre();		
		int[] bpd8 = formThreeSubjectRankingService.sub_rank_cre(crank_cre);
		model.addObject(bpd8.length);
		
		List<Formthreemarksreportprocess> crank_agric = formThreeSubjectRankingService.sub_rank_agric();		
		int[] bpd9 = formThreeSubjectRankingService.sub_rank_agric(crank_agric);
		model.addObject(bpd9.length);
		
		List<Formthreemarksreportprocess> crank_biz = formThreeSubjectRankingService.sub_rank_biz();		
		int[] bpd10 = formThreeSubjectRankingService.sub_rank_biz(crank_biz);
		model.addObject(bpd10.length);
		
		List<Formthreemarksreportprocess> crank_comp = formThreeSubjectRankingService.sub_rank_comp();		
		int[] bpd11 = formThreeSubjectRankingService.sub_rank_comp(crank_comp);
		model.addObject(bpd11.length);
		
		List<Formthreemarksreportprocess> crank_hom = formThreeSubjectRankingService.sub_rank_hom();		
		int[] bpd12 = formThreeSubjectRankingService.sub_rank_hom(crank_hom);
		model.addObject(bpd12.length);	
		return "redirect:/form_three_admin/form_three_report";
			}
	@GetMapping(value = "/backup_avgs")
	public String getAvgToBackUp(Model model) {
	    List<Formthreemarksreportprocess> marksAvgToBackUp = formThreeService.selectAvToBackUp();
	    int[] bpdate = formThreeService.f3_bchAverageToBackUp(marksAvgToBackUp);
	    formThreeService.f3_deleteAl(marksAvgToBackUp); 	  
		model.addAttribute(bpdate.length);
		return "redirect:/form_three_admin/form_three_report";
	}
	
	
	
}
