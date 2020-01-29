package com.skul.skul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Student;
import com.skul.skul.repository.FormOneMarksRepository;
import com.skul.skul.repository.FormonemarksreportprocessRepository;
import com.skul.skul.service.FormOneService;
import com.skul.skul.service.FormOneSubjectRankingService;

@RequestMapping("/admin")
@Controller
public class AdminConstractor {

	@Autowired
	private FormOneService formOneService;
	
	@Autowired
	FormOneMarksRepository formOneMarksRepository;
	
	@Autowired
	FormonemarksreportprocessRepository formonemarksreportprocessRepository;
	
	@Autowired
	FormOneSubjectRankingService formOneSubjectRankingService;
	
	@GetMapping(value = "/form_one")
	public String getScimarks(Model model) {	    	    
	    return "admin/form_one";
	}
	@GetMapping(value = "/formone_new_exam") // load marks in a pageable format
	public String formAdmin_exam(@PageableDefault(size = 10) Pageable pageable, Model model) {			
		Page<FormOneMarks> page = formOneMarksRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/new_exam";
	}	
	@GetMapping(value = "/form_report") // load marks in a pageable format
	public String formAdmin_report(@PageableDefault(size = 10) Pageable pageable, Model model) {			
		Page<FormOneMarks_Report_Process> page1 = formonemarksreportprocessRepository.findAll(pageable);
		model.addAttribute("page1", page1);
	    return "admin/form_report";
	}
	@GetMapping(value="/formonedetails") //loads student details for a new exam
	public String copy_std4One_toMarks(Model model) {		
		List<Student> crank = formOneService.select_students_ToLoad();	
		int[] bpdate = formOneService.select_all_students(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/admin/formone_new_exam";
	}
	@GetMapping(value = "/examtypeupdate/{type}")
	public String exmTypeUpdate(@PathVariable String type, Model model) {
		formOneService.updateExamType(type);						    
	    model.addAttribute("type", type);
	    return "redirect:/admin/formone_new_exam";
	}
	
	@GetMapping(value = "/examtypeupdate")
	public String getexmTypeUpdateValue(@ModelAttribute("type") String type,Model model) {
	    if (type.equalsIgnoreCase("all")) {
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/admin/examtypeupdate/" + type;          
	    }
	}
	
	@GetMapping(value = "/termupdate/{term}")
	public String updateTerm(@PathVariable String term, Model model) {
		formOneService.updateTerm(term);						    
	    model.addAttribute("term", term);
	    return "redirect:/admin/formone_new_exam";
	}
	
	@GetMapping(value = "/termupdate")
	public String getTermValue(@ModelAttribute("term") String term,Model model) {
	    if (term.equalsIgnoreCase("all")) {
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/admin/termupdate/" + term;          
	    }
	}
	
	@GetMapping(value="/form_totla")
	public String totla_marks(ModelAndView model, HttpServletRequest request) {		
		List<FormOneMarks> oneMarks = formOneService.total_marks();			
		int[] bpdate = formOneService.batchUpdate_FormOne_tt(oneMarks);	
		model.addObject("rows", bpdate.length);
		
		return "redirect:/admin/formone_new_exam";
	}
	@GetMapping(value="/formoneclassranking")
	public String classRank(Model model) {		
		List<FormOneMarks> crank = formOneService.rankList();		
		int[] bpdate = formOneService.c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/admin/formone_new_exam";
	}	
	@GetMapping(value ="/markListAverage")
	public String getListAve(ModelAndView model, HttpServletRequest request) {
		List<FormOneMarks> crank_av = formOneService.rank_ave();		
		int[] bpd = formOneService.rank_average(crank_av);	
		model.addObject(bpd.length);
		return "redirect:/admin/formone_new_exam";
			}
	@RequestMapping(value = "/backup")
	public String getMarksToBackUp(Model model) {
	    List<FormOneMarks> marksAvgToBackUp = formOneService.selectAverageToBackUp();
	    int[] bpdate = formOneService.batchAverageToBackUp(marksAvgToBackUp);
	    formOneService.deleteAll(marksAvgToBackUp);	  
		model.addAttribute(bpdate.length);
		return "redirect:/admin/formone_new_exam";
	}
	@GetMapping(value = "/loadTermYearAvg/{year}/{term}")
	public String getTermYearAvg(@PathVariable String year,@PathVariable String term, @PageableDefault(size = 10) Pageable pageable, Model model) {
	  List<FormOneMarks> formOneavg = formOneService.select_avgs(year, term);
	   int[] bpdate = formOneService.copyAvg(formOneavg);
		model.addAttribute("rows", bpdate.length);
		return "redirect:/admin/form_report";
	}
	
	@GetMapping(value = "/loadTermYearAvg")
	public String getTermYearValues(@ModelAttribute("year") String year,@ModelAttribute("term") String term,Model model) {
	    if (year.equalsIgnoreCase("all") || term.equalsIgnoreCase("all") ) {
	        return "redirect:/form_one/formOneList/";
	    } else {
	        return "redirect:/admin/loadTermYearAvg/" + year +"/" + term;          
	    }
	}
	@GetMapping(value="/form_total_avgs")
	public String total_avgs(ModelAndView model, HttpServletRequest request) {		
		List<FormOneMarks_Report_Process> up_all = formOneService.marks_avgs();			
		int[] bpdate = formOneService.update_tt_avgs(up_all);	
		model.addObject("rows", bpdate.length);		
		return "redirect:/admin/form_report";
	}
	@GetMapping(value="/formoneclassranking_avgs")
	public String avgs_classRank(Model model) {		
		List<FormOneMarks> crank = formOneService.rankList_ave();		
		int[] bpdate = formOneService.c_rnk_average(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/admin/form_report";
	}
	@GetMapping(value ="/markList_Average")
	public String getList_Ave(ModelAndView model, HttpServletRequest request) {
		List<FormOneMarks_Report_Process> rank_av = formOneService.rank_av();		
		int[] bpd = formOneService.rnk_average(rank_av);	
		model.addObject(bpd.length);
		return "redirect:/admin/form_report";
			}
	
	@GetMapping(value ="/sub_ranking_Average")
	public String getSub_ranking_Ave(ModelAndView model, HttpServletRequest request) {
		List<FormOneMarks_Report_Process> crank_eng = formOneSubjectRankingService.sub_rank_ave();		
		int[] bpd = formOneSubjectRankingService.sub_rank_average(crank_eng);
		model.addObject(bpd.length);
		
		List<FormOneMarks_Report_Process> crank_kis = formOneSubjectRankingService.sub_rank_kis();		
		int[] bpd1 = formOneSubjectRankingService.sub_rank_kis(crank_kis);
		model.addObject(bpd1.length);
		
		List<FormOneMarks_Report_Process> crank_math = formOneSubjectRankingService.sub_rank_math();		
		int[] bpd2 = formOneSubjectRankingService.sub_rank_math(crank_math);
		model.addObject(bpd2.length);
		
		List<FormOneMarks_Report_Process> crank_bio = formOneSubjectRankingService.sub_rank_bio();		
		int[] bpd3 = formOneSubjectRankingService.sub_rank_bio(crank_bio);
		model.addObject(bpd3.length);
		
		List<FormOneMarks_Report_Process> crank_chem = formOneSubjectRankingService.sub_rank_chem();		
		int[] bpd4 = formOneSubjectRankingService.sub_rank_chem(crank_chem);
		model.addObject(bpd4.length);
		
		List<FormOneMarks_Report_Process> crank_phy = formOneSubjectRankingService.sub_rank_phy();		
		int[] bpd5 = formOneSubjectRankingService.sub_rank_phy(crank_phy);
		model.addObject(bpd5.length);
		
		List<FormOneMarks_Report_Process> crank_geo = formOneSubjectRankingService.sub_rank_geo();		
		int[] bpd6 = formOneSubjectRankingService.sub_rank_geo(crank_geo);
		model.addObject(bpd6.length);
		
		List<FormOneMarks_Report_Process> crank_his = formOneSubjectRankingService.sub_rank_his();		
		int[] bpd7 = formOneSubjectRankingService.sub_rank_his(crank_his);
		model.addObject(bpd7.length);
		
		List<FormOneMarks_Report_Process> crank_cre = formOneSubjectRankingService.sub_rank_cre();		
		int[] bpd8 = formOneSubjectRankingService.sub_rank_cre(crank_cre);
		model.addObject(bpd8.length);
		
		List<FormOneMarks_Report_Process> crank_agric = formOneSubjectRankingService.sub_rank_agric();		
		int[] bpd9 = formOneSubjectRankingService.sub_rank_agric(crank_agric);
		model.addObject(bpd9.length);
		
		List<FormOneMarks_Report_Process> crank_biz = formOneSubjectRankingService.sub_rank_biz();		
		int[] bpd10 = formOneSubjectRankingService.sub_rank_biz(crank_biz);
		model.addObject(bpd10.length);
		
		List<FormOneMarks_Report_Process> crank_comp = formOneSubjectRankingService.sub_rank_comp();		
		int[] bpd11 = formOneSubjectRankingService.sub_rank_comp(crank_comp);
		model.addObject(bpd11.length);
		
		List<FormOneMarks_Report_Process> crank_hom = formOneSubjectRankingService.sub_rank_hom();		
		int[] bpd12 = formOneSubjectRankingService.sub_rank_hom(crank_hom);
		model.addObject(bpd12.length);		
		
		return "redirect:/admin/form_report";
			}
	@GetMapping(value = "/backup_avgs")
	public String getMarks_BackUp(Model model) {
	    List<FormOneMarks_Report_Process> marksAvgToBackUp = formOneService.selectAvToBackUp();
	    int[] bpdate = formOneService.bchAverageToBackUp(marksAvgToBackUp);
	    int[] bpdate1 = formOneService.deleteAl(marksAvgToBackUp);
	    model.addAttribute(bpdate1);
		model.addAttribute(bpdate.length);
		return "redirect:/admin/form_report";
	}
	
	
}
