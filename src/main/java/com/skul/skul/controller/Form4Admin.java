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

import com.skul.skul.model.Form4MarksEntry;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Student;
import com.skul.skul.repository.Form4MarksRepository;
import com.skul.skul.repository.Form4marksreportprocessRepository;
import com.skul.skul.service.Form4Service;
import com.skul.skul.service.Form4SubjectRankingService;

@RequestMapping("/form_four_admin")
@Controller
public class Form4Admin {

	@Autowired
	Form4Service form4Service;
	
	@Autowired
	Form4MarksRepository form4MarksRepository;
	
	@Autowired
	Form4marksreportprocessRepository form4marksreportprocessRepository;
	@Autowired
	Form4SubjectRankingService form4SubjectRankingService;
	@GetMapping("/form_four_admin_screen")
	public String index_page() {
		return "admin/form_4_admin_screen";
	}
	
	@GetMapping("/form_four_new_exam")
	public String new_page(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<Form4MarksEntry> page = form4MarksRepository.findAll(pageable);
		model.addAttribute("page", page);
		return "admin/new_exam_f4";
	}	
	@GetMapping("/form_four_report")
	public String report_page(@PageableDefault(size = 10) Pageable pageable, Model model) {
		Page<Form4marksreportprocess> page3 = form4marksreportprocessRepository.findAll(pageable);
		model.addAttribute("page3", page3);
		return "admin/form4_reports_page";
	}	
	@GetMapping("/form_4_class_teacher_page")
	public String class_teacher_page() {
		return "class_teachre/form4_class_teacher";
	}	
	@GetMapping(value="/form4details") //loads student details for a new exam
	public String copy_std4One_toMarks(Model model) {		
		List<Student> crank = form4Service.select_students_ToLoad();	
		int[] bpdate = form4Service.select_all_students(crank);
		model.addAttribute(bpdate.length);
		return "redirect:/form_four_admin/form_four_new_exam"; //admin/formone_new_exam";
	}	
	@GetMapping(value = "/examtypeupdate/{type}")
	public String exmTypeUpdate(@PathVariable String type, Model model) {
		form4Service.updateExamType(type);						    
	    model.addAttribute("type", type);
	    return "redirect:/form_four_admin/form_four_new_exam";
	}	
	@GetMapping(value = "/examtypeupdate")
	public String getexmTypeUpdateValue(@ModelAttribute("type") String type,Model model) {
	    if (type.equalsIgnoreCase("all")){
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/form_four_admin/examtypeupdate/" + type;          
	    }
	}
	
	@GetMapping(value = "/termupdate/{term}")
	public String updateTerm(@PathVariable String term, Model model) {
		form4Service.updateTerm(term);						    
	    model.addAttribute("term", term);
	    return "redirect:/form_four_admin/form_four_new_exam";
	}
	
	@GetMapping(value = "/termupdate")
	public String getTermValue(@ModelAttribute("term") String term,Model model) {
	    if (term.equalsIgnoreCase("all")) {
	    	return "redirect:/form_one/formone_new_exam";
	    } else {
	        return "redirect:/form_four_admin/termupdate/" + term;          
	    }
	}
	
	@GetMapping(value="/form_totla")
	public String totla_marks(ModelAndView model, HttpServletRequest request) {		
		List<Form4MarksEntry> oneMarks = form4Service.sumup();			
		int[] bpdate = form4Service.batchUpdate_Formfour_tt(oneMarks);
		model.addObject("rows", bpdate.length);
		
		return "redirect:/form_four_admin/form_four_new_exam";
	}
	
	@GetMapping(value="/form_four_classranking")
	public String classRank(Model model) {		
		List<Form4MarksEntry> crank = form4Service.rankList();		
		int[] bpdate = form4Service.c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/form_four_admin/form_four_new_exam";
	}	
	@GetMapping(value ="/markListAverage")
	public String getListAve(ModelAndView model, HttpServletRequest request) {
		List<Form4MarksEntry> crank_av = form4Service.rank_ave();		
		int[] bpd = form4Service.rank_average(crank_av);	
		model.addObject(bpd.length);
		return "redirect:/form_four_admin/form_four_new_exam";
			}
	@RequestMapping(value = "/backup")
	public String getMarksToBackUp(Model model) {
	    List<Form4MarksEntry> marksAvgToBackUp = form4Service.selectAverageToBackUp();
	    int[] bpdate = form4Service.batchAverageToBackUp(marksAvgToBackUp);
	    form4Service.deleteAll(marksAvgToBackUp);	  
		model.addAttribute(bpdate.length);
		return "redirect:/form_four_admin/form_four_new_exam";
	}
	@GetMapping(value = "/loadTermYearAvg/{year}/{term}")
	public String getTermYearAvg(@PathVariable String year,@PathVariable String term, @PageableDefault(size = 10) Pageable pageable, Model model) {
	  List<Form4basebackup> formOneavg = form4Service.select_avgs(year, term);
	   int[] bpdate = form4Service.copyAvg(formOneavg);
		model.addAttribute("rows", bpdate.length);
		return "redirect:/form_four_admin/form_four_report";
	}
	
	@GetMapping(value = "/loadTermYearAvg")
	public String getTermYearValues(@ModelAttribute("year") String year,@ModelAttribute("term") String term,Model model) {
	    if (year.equalsIgnoreCase("all") || term.equalsIgnoreCase("all") ) {
	        return "redirect:/form_four_admin/form_four_report/";
	    } else {
	        return "redirect:/form_four_admin/loadTermYearAvg/" + year +"/" + term;          
	    }
	}
	@GetMapping(value="/form_total_avgs")
	public String total_avgs(ModelAndView model, HttpServletRequest request) {		
		List<Form4marksreportprocess> up_all = form4Service._form4_tt();			
		int[] bpdate = form4Service.batchUpdate_Form4_tt(up_all);
		model.addObject("rows", bpdate.length);		
		return "redirect:/form_four_admin/form_four_report";
	}
	@GetMapping(value="/form4classranking")
	public String f3classRank(Model model) {		
		List<Form4marksreportprocess> crank = form4Service.f4_rankList();		
		int[] bpdate = form4Service.f4_c_rank(crank);	
		model.addAttribute(bpdate.length);
		return "redirect:/form_four_admin/form_four_report";
	}	
	@GetMapping(value ="/form4markListAverage")
	public String getF3ListAve(ModelAndView model, HttpServletRequest request) {
		List<Form4marksreportprocess> crank_av = form4Service.f4_rank_ave();		
		int[] bpd = form4Service.f4_rank_average(crank_av);	
		model.addObject(bpd.length);
		List<Form4marksreportprocess> crank_eng = form4SubjectRankingService.sub_rank_ave();		
		int[] bpdo = form4SubjectRankingService.sub_rank_average(crank_eng);
		model.addObject(bpdo.length);
		
		List<Form4marksreportprocess> crank_kis = form4SubjectRankingService.sub_rank_kis();		
		int[] bpd1 = form4SubjectRankingService.sub_rank_kis(crank_kis);
		model.addObject(bpd1.length);
		
		List<Form4marksreportprocess> crank_math = form4SubjectRankingService.sub_rank_math();		
		int[] bpd2 = form4SubjectRankingService.sub_rank_math(crank_math);
		model.addObject(bpd2.length);
		
		List<Form4marksreportprocess> crank_bio = form4SubjectRankingService.sub_rank_bio();		
		int[] bpd3 = form4SubjectRankingService.sub_rank_bio(crank_bio);
		model.addObject(bpd3.length);
		
		List<Form4marksreportprocess> crank_chem = form4SubjectRankingService.sub_rank_chem();		
		int[] bpd4 = form4SubjectRankingService.sub_rank_chem(crank_chem);
		model.addObject(bpd4.length);
		
		List<Form4marksreportprocess> crank_phy = form4SubjectRankingService.sub_rank_phy();		
		int[] bpd5 = form4SubjectRankingService.sub_rank_phy(crank_phy);
		model.addObject(bpd5.length);
		
		List<Form4marksreportprocess> crank_geo = form4SubjectRankingService.sub_rank_geo();		
		int[] bpd6 = form4SubjectRankingService.sub_rank_geo(crank_geo);
		model.addObject(bpd6.length);
		
		List<Form4marksreportprocess> crank_his = form4SubjectRankingService.sub_rank_his();		
		int[] bpd7 = form4SubjectRankingService.sub_rank_his(crank_his);
		model.addObject(bpd7.length);
		
		List<Form4marksreportprocess> crank_cre = form4SubjectRankingService.sub_rank_cre();		
		int[] bpd8 = form4SubjectRankingService.sub_rank_cre(crank_cre);
		model.addObject(bpd8.length);
		
		List<Form4marksreportprocess> crank_agric = form4SubjectRankingService.sub_rank_agric();		
		int[] bpd9 = form4SubjectRankingService.sub_rank_agric(crank_agric);
		model.addObject(bpd9.length);
		
		List<Form4marksreportprocess> crank_biz = form4SubjectRankingService.sub_rank_biz();		
		int[] bpd10 = form4SubjectRankingService.sub_rank_biz(crank_biz);
		model.addObject(bpd10.length);
		
		List<Form4marksreportprocess> crank_comp = form4SubjectRankingService.sub_rank_comp();		
		int[] bpd11 = form4SubjectRankingService.sub_rank_comp(crank_comp);
		model.addObject(bpd11.length);
		
		List<Form4marksreportprocess> crank_hom = form4SubjectRankingService.sub_rank_hom();		
		int[] bpd12 = form4SubjectRankingService.sub_rank_hom(crank_hom);
		model.addObject(bpd12.length);	
		return "redirect:/form_four_admin/form_four_report";
			}
	@GetMapping(value = "/backup_avgs")
	public String getAvgToBackUp(Model model) {
	    List<Form4marksreportprocess> marksAvgToBackUp = form4Service.selectAvToBackUp();
	    int[] bpdate = form4Service.f4_bchAverageToBackUp(marksAvgToBackUp);
		model.addAttribute(bpdate.length);
		form4Service.f4_deleteAl(marksAvgToBackUp); 	  
			model.addAttribute(bpdate.length);
		return "redirect:/form_four_admin/form_four_report";
	}
	
	
	
}
