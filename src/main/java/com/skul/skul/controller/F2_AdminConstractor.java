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

import com.skul.skul.model.Form2Marks;
import com.skul.skul.model.Form2Marks_Report_Process;
import com.skul.skul.model.Student;
import com.skul.skul.repository.Form2MarksRepository;
import com.skul.skul.repository.Form2marksreportprocessRepository;
import com.skul.skul.service.Form2Service;
import com.skul.skul.service.Form2SubjectRankingService;

@RequestMapping("/form2_admin")
@Controller
public class F2_AdminConstractor {

	@Autowired
	private Form2Service form2Service;
	
	@Autowired
	Form2MarksRepository form2MarksRepository;
	
	@Autowired
	Form2marksreportprocessRepository form2MarksreportprocessRepository;
	
	@Autowired
	Form2SubjectRankingService form2SubjectRankingService;
	
	@GetMapping(value = "/form_two")
	public String getAdmin_page(Model model) {	    	    
	    return "admin/form2/form_two";
	}
	@GetMapping(value = "/formtwo_new_exam") // load marks in a pageable format
	public String formAdmin_exam(@PageableDefault(size = 10) Pageable pageable, Model model) {			
		Page<Form2Marks> page = form2MarksRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/form2/form_2_new_exam";
	}	
	@GetMapping(value = "/form_2_reports_page") // load marks in a pageable format
	public String formAdmin_report(@PageableDefault(size = 10) Pageable pageable, Model model) {			
		Page<Form2Marks_Report_Process> page1 = form2MarksreportprocessRepository.findAll(pageable);
		model.addAttribute("page1", page1);
	    return "admin/form2/form_two_report";
	}
	@GetMapping(value="/formtwodetails") //loads student details for a new exam
	public String copy_std4Two_toMarks(Model model) {		
		List<Student> crank = form2Service.select_students_ToLoad();	
		int[] bpdate = form2Service.select_all_students(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/form2_admin/formtwo_new_exam";
	}
	@GetMapping(value = "/examtypeupdate/{type}")
	public String exmTypeUpdate(@PathVariable String type, Model model) {
		form2Service.updateExamType(type);						    
	    model.addAttribute("type", type);
	    return "redirect:/form2_admin/formtwo_new_exam";
	}
	
	@GetMapping(value = "/examtypeupdate")
	public String getexmTypeUpdateValue(@ModelAttribute("type") String type,Model model) {
	    if (type.equalsIgnoreCase("all")) {
	    	return "redirect:/";
	    } else {
	        return "redirect:/form2_admin/examtypeupdate/" + type;          
	    }
	}
	
	@GetMapping(value = "/termupdate/{term}")
	public String updateTerm(@PathVariable String term, Model model) {
		form2Service.updateTerm(term);						    
	    model.addAttribute("term", term);
	    return "redirect:/form2_admin/formtwo_new_exam";
	}
	
	@GetMapping(value = "/termupdate")
	public String getTermValue(@ModelAttribute("term") String term,Model model) {
	    if (term.equalsIgnoreCase("all")) {
	    	return "redirect:/";
	    } else {
	        return "redirect:/form2_admin/termupdate/" + term;          
	    }
	}
	
	@GetMapping(value="/form_totla")
	public String totla_marks(ModelAndView model, HttpServletRequest request) {		
		List<Form2Marks> oneMarks = form2Service.total_marks();			
		int[] bpdate = form2Service.batchUpdate_FormTwo_tt(oneMarks);	
		model.addObject("rows", bpdate.length);
		
		return "redirect:/form2_admin/formtwo_new_exam";
	}
	@GetMapping(value="/formtwoclassranking")
	public String classRank(Model model) {		
		List<Form2Marks> crank = form2Service.rankList();		
		int[] bpdate = form2Service.c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/form2_admin/formtwo_new_exam";
	}	
	@GetMapping(value ="/markListAverage")
	public String getListAve(ModelAndView model, HttpServletRequest request) {
		List<Form2Marks> crank_av = form2Service.rank_ave();		
		int[] bpd = form2Service.rank_average(crank_av);	
		model.addObject(bpd.length);
		return "redirect:/form2_admin/formtwo_new_exam";
			}
	@RequestMapping(value = "/backup")
	public String getMarksToBackUp(Model model) {
	    List<Form2Marks> marksAvgToBackUp = form2Service.selectAverageToBackUp();
	    int[] bpdate = form2Service.batchAverageToBackUp(marksAvgToBackUp);
	    form2Service.deleteAll(marksAvgToBackUp);	  
		model.addAttribute(bpdate.length);
		return "redirect:/form2_admin/formtwo_new_exam";
	}
	@GetMapping(value = "/loadTermYearAvg/{year}/{term}")
	public String getTermYearAvg(@PathVariable String year,@PathVariable String term, @PageableDefault(size = 10) Pageable pageable, Model model) {
	  List<Form2Marks> formOneavg = form2Service.select_avgs(year, term);
	   int[] bpdate = form2Service.copyAvg(formOneavg);
		model.addAttribute("rows", bpdate.length);
		return "redirect:/form2_admin/form_2_reports_page";
	}
	
	@GetMapping(value = "/loadTermYearAvg")
	public String getTermYearValues(@ModelAttribute("year") String year,@ModelAttribute("term") String term,Model model) {
	    if (year.equalsIgnoreCase("all") || term.equalsIgnoreCase("all") ) {
	        return "redirect:/";
	    } else {
	        return "redirect:/form2_admin/loadTermYearAvg/" + year +"/" + term;          
	    }
	}
	@GetMapping(value="/form_total_avgs")
	public String total_avgs(ModelAndView model, HttpServletRequest request) {		
		List<Form2Marks_Report_Process> up_all = form2Service.marks_avgs();			
		int[] bpdate = form2Service.update_tt_avgs(up_all);	
		model.addObject("rows", bpdate.length);		
		return "redirect:/form2_admin/form_2_reports_page";
	}
	@GetMapping(value="/formtwoclassranking_avgs")
	public String avgs_classRank(Model model) {		
		List<Form2Marks> crank = form2Service.rankList_ave();		
		int[] bpdate = form2Service.c_rnk_average(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/form2_admin/form_2_reports_page";
	}
	@GetMapping(value ="/markList_Average")
	public String getList_Ave(ModelAndView model, HttpServletRequest request) {
		List<Form2Marks_Report_Process> rank_av = form2Service.rank_av();		
		int[] bpd = form2Service.rnk_average(rank_av);	
		model.addObject(bpd.length);
		return "redirect:/form2_admin/form_2_reports_page";
			}
	
	@GetMapping(value ="/sub_ranking_Average")
	public String getSub_ranking_Ave(ModelAndView model, HttpServletRequest request) {
		List<Form2Marks_Report_Process> crank_eng = form2SubjectRankingService.sub_rank_ave();		
		int[] bpd = form2SubjectRankingService.sub_rank_average(crank_eng);
		model.addObject(bpd.length);
		
		List<Form2Marks_Report_Process> crank_kis = form2SubjectRankingService.sub_rank_kis();		
		int[] bpd1 = form2SubjectRankingService.sub_rank_kis(crank_kis);
		model.addObject(bpd1.length);
		
		List<Form2Marks_Report_Process> crank_math = form2SubjectRankingService.sub_rank_math();		
		int[] bpd2 = form2SubjectRankingService.sub_rank_math(crank_math);
		model.addObject(bpd2.length);
		
		List<Form2Marks_Report_Process> crank_bio = form2SubjectRankingService.sub_rank_bio();		
		int[] bpd3 = form2SubjectRankingService.sub_rank_bio(crank_bio);
		model.addObject(bpd3.length);
		
		List<Form2Marks_Report_Process> crank_chem = form2SubjectRankingService.sub_rank_chem();		
		int[] bpd4 = form2SubjectRankingService.sub_rank_chem(crank_chem);
		model.addObject(bpd4.length);
		
		List<Form2Marks_Report_Process> crank_phy = form2SubjectRankingService.sub_rank_phy();		
		int[] bpd5 = form2SubjectRankingService.sub_rank_phy(crank_phy);
		model.addObject(bpd5.length);
		
		List<Form2Marks_Report_Process> crank_geo = form2SubjectRankingService.sub_rank_geo();		
		int[] bpd6 = form2SubjectRankingService.sub_rank_geo(crank_geo);
		model.addObject(bpd6.length);
		
		List<Form2Marks_Report_Process> crank_his = form2SubjectRankingService.sub_rank_his();		
		int[] bpd7 = form2SubjectRankingService.sub_rank_his(crank_his);
		model.addObject(bpd7.length);
		
		List<Form2Marks_Report_Process> crank_cre = form2SubjectRankingService.sub_rank_cre();		
		int[] bpd8 = form2SubjectRankingService.sub_rank_cre(crank_cre);
		model.addObject(bpd8.length);
		
		List<Form2Marks_Report_Process> crank_agric = form2SubjectRankingService.sub_rank_agric();		
		int[] bpd9 = form2SubjectRankingService.sub_rank_agric(crank_agric);
		model.addObject(bpd9.length);
		
		List<Form2Marks_Report_Process> crank_biz = form2SubjectRankingService.sub_rank_biz();		
		int[] bpd10 = form2SubjectRankingService.sub_rank_biz(crank_biz);
		model.addObject(bpd10.length);
		
		List<Form2Marks_Report_Process> crank_comp = form2SubjectRankingService.sub_rank_comp();		
		int[] bpd11 = form2SubjectRankingService.sub_rank_comp(crank_comp);
		model.addObject(bpd11.length);
		
		List<Form2Marks_Report_Process> crank_hom = form2SubjectRankingService.sub_rank_hom();		
		int[] bpd12 = form2SubjectRankingService.sub_rank_hom(crank_hom);
		model.addObject(bpd12.length);		
		
		return "redirect:/form2_admin/form_2_reports_page";
			}
	@GetMapping(value = "/backup_avgs")
	public String getMarks_BackUp(Model model) {
	    List<Form2Marks_Report_Process> marksAvgToBackUp = form2Service.selectAvToBackUp();
	    int[] bpdate = form2Service.bchAverageToBackUp(marksAvgToBackUp);
	    int[] bpdate1 = form2Service.deleteAl(marksAvgToBackUp);
	    model.addAttribute(bpdate1);
		model.addAttribute(bpdate.length);
		return "redirect:/form2_admin/form_2_reports_page";
	}
	
	
}
