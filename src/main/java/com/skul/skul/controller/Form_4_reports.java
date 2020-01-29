package com.skul.skul.controller;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Align;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.skul.skul.model.Form2marksbackup;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksbackup;
import com.skul.skul.model.FormOneMarksBackUp;
import com.skul.skul.model.Formthreemarksbackup;
import com.skul.skul.model.Student;
import com.skul.skul.model.Teachers;
import com.skul.skul.service.Form2SubjectRankingService;
import com.skul.skul.service.Form4SubjectRankingService;
import com.skul.skul.service.FormOneSubjectRankingService;
import com.skul.skul.service.FormThreeSubjectRankingService;
import com.skul.skul.service.StudentService;
import com.skul.skul.service.TeacherService;
import com.skul.skul.utils.Student_kcpe_marks_util;
@RequestMapping("/f4_reports")
@Controller
public class Form_4_reports {
	@Autowired
	StudentService studentService;
	@Autowired
	Form4SubjectRankingService form4SubjectRankingService;	
	@Autowired
	FormOneSubjectRankingService formoneSubjectRankingService;	
	@Autowired
	Form2SubjectRankingService form2SubjectRankingService;
	@Autowired
	FormThreeSubjectRankingService formThreeSubjectRankingService;
	@Autowired
	TeacherService teacherService;
	//private static final BaseFont Currier = null;
	
	private static final Logger logger = LoggerFactory.getLogger(Form_4_reports.class);
	@RequestMapping(value = "/four_reports/{year}/{term}", method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> fourReport(@PathVariable String term, @PathVariable String year) throws DocumentException, MalformedURLException, IOException {
        ByteArrayInputStream bis = four_Report(term, year);
        HttpHeaders  headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=form_FOUR_report_pdf.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }	
	@GetMapping(value = "/four_reports")
	public String getTerm_year(@ModelAttribute("term") String term,@ModelAttribute("year") String year, Model model) {
	return "redirect:/f4_reports/four_reports/" + year +"/" + term ;          
	    
	}
	
public ByteArrayInputStream four_Report(@PathVariable String term,@PathVariable String year) throws DocumentException, MalformedURLException, IOException {
		
		int width= 555;//540; 
        int height= 220;//280;
        String trm = "";
		  //PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream(FILE));
         Document document = new Document();
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         PdfWriter writer = PdfWriter.getInstance(document, out);
		  document.open();
            
             List<Student> noStudents = studentService.getAllStudent_form_four();
             int total = noStudents.size();
            // try { 
            	 for(Student stdd : noStudents ) {
                	 
                	 double kcpe_mean = Double.parseDouble(Student_kcpe_marks_util.kcpemarks_mean(stdd.getKcpemarks()));
     				String kcpe_grade = Student_kcpe_marks_util.averageGrade(kcpe_mean);
                	 document.newPage();
                     String eng = "--";String kis = "--";String math = "--";String bio = "--";String chem = "--";
         			String phy = "--";String geo = "--";String his = "--";String cre = "--";String agric = "--";
         			String bis = "--";String comp = "--";String hom = "--";String tt = "--";
         			String eng_grade = "--";String kis_grade = "--";String math_grade = "--";String bio_grade = "--";String chem_grade = "--";
         			String phy_grade = "--";String geo_grade = "--";String his_grade = "--";String cre_grade = "--";String agric_grade = "--";
         			String bis_grade = "--";String comp_grade = "--";String hom_grade = "--"; String tt_pnts_grade = "--";String Ov_pnts_ex = "--";
         			
         			String eng_pnts = "--";String kis_pnts = "--";String math_pnts = "--";String bio_pnts = "--";String chem_pnts = "--";
         			String phy_pnts = "--";String geo_pnts = "--";String his_pnts = "--";String cre_pnts = "--";String agric_pnts = "--";
         			String bis_pnts = "--";String comp_pnts = "--";String hom_pnts = "--";String ov_pnts = "--"; String ov_pnts_grade = "--";
         			String tt_pnts = "--";String crank = "--"; String rank = "--";
         			
         			 String eng_pos = "--";String kis_pos = "--";String math_pos = "--";String bio_pos = "--";String chem_pos = "--";
          			String phy_pos = "--";String geo_pos = "--";String his_pos = "--";String cre_pos = "--";String agric_pos = "--";
          			String bis_pos = "--";String comp_pos = "--";String hom_pos = "--";String points = "--";
          			
          			String eng_remarks = "--";String kis_remarks = "--";String math_remarks = "--";String bio_remarks = "--";String chem_remarks = "--";
         			String phy_remarks = "--";String geo_remarks = "--";String his_remarks = "--";String cre_remarks = "--";String agric_remarks = "--";
         			String bis_remarks = "--";String comp_remarks = "--";String hom_remarks = "--"; String yr = "--";
         			String class_teacher_remarks = "***"; String principal_remarks = "###";
         			String devtion = "###";
         			
         			String eng1 = "--";String kis1 = "--";String math1 = "--";String bio1 = "--";String chem1 = "--";
         			String phy1 = "--";String geo1 = "--";String his1 = "--";String cre1 = "--";String agric1 = "--";
         			String bis1 = "--";String comp1 = "--";String hom1 = "--";String tt1 = "--"; String Ov_pnts1 = "--";String points1 = "--";
         			String eng1_grade = "--";String kis1_grade = "--";String math1_grade = "--";String bio1_grade = "--";String chem1_grade = "--";
         			String phy1_grade = "--";String geo1_grade = "--";String his1_grade = "--";String cre1_grade = "--";String agric1_grade = "--";
         			String bis1_grade = "--";String comp1_grade = "--";String hom1_grade = "--";String tt1_pnts_grade = "--";
         			String crank1 = "--"; String rank1 = "--";
         			
         			String eng2 = "--";String kis2 = "--";String math2 = "--";String bio2 = "--";String chem2 = "--";
         			String phy2 = "--";String geo2 = "--";String his2 = "--";String cre2 = "--";String agric2 = "--";
         			String bis2 = "--";String comp2 = "--";String hom2 = "--";String tt2 = "--"; String Ov_pnts2 = "--";String points2 = "--";
         			String eng2_grade = "--";String kis2_grade = "--";String math2_grade = "--";String bio2_grade = "--";String chem2_grade = "--";
         			String phy2_grade = "--";String geo2_grade = "--";String his2_grade = "--";String cre2_grade = "--";String agric2_grade = "--";
         			String bis2_grade = "--";String comp2_grade = "--";String hom2_grade = "--"; String tt2_pnts_grade = "--";
         			String crank2 = "--"; String rank2 = "--";
         			
         			String eng3 = "--";String kis3 = "--";String math3 = "--";String bio3 = "--";String chem3 = "--";
         			String phy3 = "--";String geo3 = "--";String his3 = "--";String cre3 = "--";String agric3 = "--";
         			String bis3 = "--";String comp3 = "--";String hom3 = "--";String tt3 = "--";String Ov_pnts3 = "--";String points3 = "--";
         			String eng3_grade = "--";String kis3_grade = "--";String math3_grade = "--";String bio3_grade = "--";String chem3_grade = "--";
         			String phy3_grade = "--";String geo3_grade = "--";String his3_grade = "--";String cre3_grade = "--";String agric3_grade = "--";
         			String bis3_grade = "--";String comp3_grade = "--";String hom3_grade = "--";String tt3_pnts_grade = "--";
         			String crank3 = "--"; String rank3 = "--";
         			
         			String exam_tt_one_f1 = "0"; String exam_points_one_f1 ="0"; String exam_mean_one_f1 ="0"; String exam_op_one_f1 ="0";
         			String exam_tt_two_f1 = "0"; String exam_points_two_f1 ="0"; String exam_mean_two_f1 ="0"; String exam_op_two_f1 ="0";
         			String exam_tt_three_f1 = "0"; String exam_points_three_f1 ="0"; String exam_mean_three_f1 ="0"; String exam_op_three_f1 ="0";
         			
         			String exam_tt_one_f2 = "0"; String exam_points_one_f2 ="0"; String exam_mean_one_f2 ="0"; String exam_op_one_f2 ="0";
         			String exam_tt_two_f2 = "0"; String exam_points_two_f2 ="0"; String exam_mean_two_f2 ="0"; String exam_op_two_f2 ="0";
         			String exam_tt_three_f2 = "0"; String exam_points_three_f2 ="0"; String exam_mean_three_f2 ="0"; String exam_op_three_f2 ="0";
         			
         			String exam_tt_one = "0"; String exam_points_one ="0"; String exam_mean_one ="0"; String exam_op_one ="0";
         			String exam_tt_two = "0"; String exam_points_two ="0"; String exam_mean_two ="0"; String exam_op_two ="0";
         			String exam_tt_three = "0"; String exam_points_three ="0"; String exam_mean_three ="0"; String exam_op_three ="0";
         			
         			String exam_tt_one_f3 = "0"; String exam_points_one_f3 ="0"; String exam_mean_one_f3 ="0"; String exam_op_one_f3 ="0";
         			String exam_tt_two_f3 = "0"; String exam_points_two_f3 ="0"; String exam_mean_two_f3 ="0"; String exam_op_two_f3 ="0";
         			String exam_tt_three_f3 = "0"; String exam_points_three_f3 ="0"; String exam_mean_three_f3 ="0"; String exam_op_three_f3 ="0";
         			
         			String first_name ="--"; String other_name ="--";
         			String p_fname = "--"; String p_othername = "--"; 
         			List<Teachers> teacha = teacherService.getAll(stdd.getStream(), stdd.getForm());
         			for (Teachers t_var : teacha) {         			
         				first_name = t_var.getFname();
         				other_name = t_var.getOthername();
             	           	}
         			List<Teachers> prinzy_name = teacherService.get_principal_name();
         			for(Teachers p_var : prinzy_name) {
         				p_fname = p_var.getFname();
         						p_othername =   p_var.getOthername();   				
         			}
         		List<Form4basebackup> exm1 = form4SubjectRankingService.selectAll_ExamOne(stdd.getRegno(),term,year);		
         		for (Form4basebackup markss : exm1) {
         	       	   if((markss.getEng()==0)) {}else {
         	       		eng1 = Long.toString(markss.getEng());}
         	       	   
         	       	if((markss.getKis()==0)) {}else {
      	       		kis1 = Long.toString(markss.getKis());} 
         	       	
         	       if((markss.getMath()==0)) {}else {
      	       		math1 = Long.toString(markss.getMath());}
         	       
         	      if((markss.getBio()==0)) {}else {
     	       		bio1 = Long.toString(markss.getBio());} 
         	      
         	     if((markss.getChem()==0)) {}else {
    	       		chem1 = Long.toString(markss.getChem());}
         	     
         	    if((markss.getPhy()==0)) {}else {
    	       		phy1 = Long.toString(markss.getPhy());}
         	    
         	   if((markss.getGeo()==0)) {}else {
    	       		geo1 = Long.toString(markss.getGeo());}
         	   
         	  if((markss.getHis()==0)) {}else {
    	       		his1 = Long.toString(markss.getHis());}
         	  
         	 if((markss.getCre()==0)) {}else {
    	       		cre1 = Long.toString(markss.getCre());}
         	 
         	if((markss.getAgric()==0)) {}else {
           		agric1 = Long.toString(markss.getAgric());}
         	
         	if((markss.getBiz()==0)) {}else {
           		bis1 = Long.toString(markss.getBiz());}
         	if((markss.getComp()==0)) {}else {
           		comp1 = Long.toString(markss.getComp());}
         	if((markss.getHom()==0)) {}else {
           		hom1 = Long.toString(markss.getHom());}
         	if((markss.getTt()==0)) {}else {
           		tt1 = Long.toString(markss.getTt());} 
         	if((markss.getOv_pnts()==0)) {}else {
         		Ov_pnts1 = Long.toString(markss.getOv_pnts());} 
         	if((markss.getPoints()==0)) {}else {
         		points1 = Long.toString(markss.getPoints());}
         	
         	eng1_grade = markss.getEng_grade();kis1_grade = markss.getKis_grade();	math1_grade = markss.getMath_grade();       	
         	          	bio1_grade = markss.getBio_grade();chem1_grade = markss.getChem_grade();phy1_grade = markss.getPhy_grade();
         	           	geo1_grade = markss.getGeo_grade();his1_grade = markss.getHis_grade();cre1_grade = markss.getCre_grade();
         	           	agric1_grade = markss.getAgric_grade();bis1_grade = markss.getBiz_grade();comp1_grade = markss.getComp_grade();
         	           	hom1_grade = markss.getHom_grade();tt1_pnts_grade = markss.getOv_pnts_grade(); 
         	           	crank1 = markss.getCrank(); rank1 = markss.getRank();}
         		
         		List<Form4basebackup> exam2 = form4SubjectRankingService.selectAll_ExamTwo(stdd.getRegno(),term,year);
         		for (Form4basebackup marksss : exam2) {
         			if((marksss.getEng()==0)) {  }else {
         	       		eng2 = Long.toString(marksss.getEng());}
         	       	   
         	       	if((marksss.getEng()==0) ) {}else {
      	       		kis2 = Long.toString(marksss.getKis());} 
         	       	
         	       if((marksss.getMath()==0) ) {}else {
      	       		math2 = Long.toString(marksss.getMath());}
         	       
         	      if((marksss.getBio()==0) ) {}else {
     	       		bio2 = Long.toString(marksss.getBio());} 
         	      
         	     if((marksss.getChem()==0)) {}else {
    	       		chem2 = Long.toString(marksss.getChem());}
         	     
         	    if((marksss.getPhy()==0)) {}else {
    	       		phy2 = Long.toString(marksss.getPhy());}
         	    
         	   if((marksss.getGeo()==0)) {}else {
    	       		geo2 = Long.toString(marksss.getGeo());}
         	   
         	  if((marksss.getHis()==0)) {}else {
    	       		his2 = Long.toString(marksss.getHis());}
         	  
         	 if((marksss.getCre()==0)) {}else {
    	       		cre2 = Long.toString(marksss.getCre());}
         	 
         	if((marksss.getAgric()==0)) {}else {
           		agric2 = Long.toString(marksss.getAgric());}
         	
         	if((marksss.getBiz()==0)) {}else {
           		bis2 = Long.toString(marksss.getBiz());}
         	if((marksss.getComp()==0)) {}else {
           		comp2 = Long.toString(marksss.getComp());}
         	if((marksss.getHom()==0)) {}else {
           		hom2 = Long.toString(marksss.getHom());}
         	if((marksss.getTt()==0)) {}else {
           		tt2 = Long.toString(marksss.getTt());}  
         	if((marksss.getOv_pnts()==0)) {}else {
         		Ov_pnts2 = Long.toString(marksss.getOv_pnts());}
         	if((marksss.getPoints()==0)) {}else {
         		points2 = Long.toString(marksss.getPoints());}
         	crank2 = marksss.getCrank(); rank2 = marksss.getRank();
         	           	eng2_grade = marksss.getEng_grade();kis2_grade = marksss.getKis_grade();	math2_grade = marksss.getMath_grade();       	
         	          	bio2_grade = marksss.getBio_grade();chem2_grade = marksss.getChem_grade();phy2_grade = marksss.getPhy_grade();
         	           	geo2_grade = marksss.getGeo_grade();his2_grade = marksss.getHis_grade();cre2_grade = marksss.getCre_grade();
         	           	agric2_grade = marksss.getAgric_grade();bis2_grade = marksss.getBiz_grade();comp2_grade = marksss.getComp_grade();
         	           	hom2_grade = marksss.getHom_grade();tt2_pnts_grade = marksss.getOv_pnts_grade();
         	       
         	            }
         		
         		List<Form4basebackup> exam3 = form4SubjectRankingService.selectAll_ExamThree(stdd.getRegno(),term,year);
         		for (Form4basebackup markssss : exam3) {
         			if((markssss.getEng()==0)) {}else {
         	       		eng3 = Long.toString(markssss.getEng());}
         	       	   
         	       	if((markssss.getEng()==0)) {}else {
      	       		kis3 = Long.toString(markssss.getKis());} 
         	       	
         	       if((markssss.getMath()==0)) {}else {
      	       		math3 = Long.toString(markssss.getMath());}
         	       
         	      if((markssss.getBio()==0)) {}else {
     	       		bio3 = Long.toString(markssss.getBio());} 
         	      
         	     if((markssss.getChem()==0)) {}else {
    	       		chem3 = Long.toString(markssss.getChem());}
         	     
         	    if((markssss.getPhy()==0)) {}else {
    	       		phy3 = Long.toString(markssss.getPhy());}
         	    
         	   if((markssss.getGeo()==0)) {}else {
    	       		geo3 = Long.toString(markssss.getGeo());}
         	   
         	  if((markssss.getHis()==0)) {}else {
    	       		his3 = Long.toString(markssss.getHis());}
         	  
         	 if((markssss.getCre()==0)) {}else {
    	       		cre3 = Long.toString(markssss.getCre());}
         	 
         	if((markssss.getAgric()==0)) {}else {
           		agric3 = Long.toString(markssss.getAgric());}
         	
         	if((markssss.getBiz()==0)) {}else {
           		bis3 = Long.toString(markssss.getBiz());}
         	if((markssss.getComp()==0)) {}else {
           		comp3 = Long.toString(markssss.getComp());}
         	if((markssss.getHom()==0)) {}else {
           		hom3 = Long.toString(markssss.getHom());}
         	if((markssss.getTt()==0)) {}else {
           		tt3 = Long.toString(markssss.getTt());}
         	if((markssss.getOv_pnts()==0)) {}else {
         		Ov_pnts3 = Long.toString(markssss.getOv_pnts());}
         	if((markssss.getPoints()==0)) {}else {
         		points3 = Long.toString(markssss.getPoints());}
         	       	   
         	           	eng3_grade = markssss.getEng_grade();kis3_grade = markssss.getKis_grade();	math3_grade = markssss.getMath_grade();       	
         	          	bio3_grade = markssss.getBio_grade();chem3_grade = markssss.getChem_grade();phy3_grade = markssss.getPhy_grade();
         	           	geo3_grade = markssss.getGeo_grade();his3_grade = markssss.getHis_grade();cre3_grade = markssss.getCre_grade();
         	           	agric3_grade = markssss.getAgric_grade();bis3_grade = markssss.getBiz_grade();comp3_grade = markssss.getComp_grade();
         	           	hom3_grade = markssss.getHom_grade();tt3_pnts_grade = markssss.getOv_pnts_grade();
         	           crank3 = markssss.getCrank(); rank3 = markssss.getRank();
         	            }
         		
         		List<Form4marksbackup> exm = form4SubjectRankingService.selectAll_Exam(stdd.getRegno(),term,year);		
         		for (Form4marksbackup mark : exm) {
         			if((mark.getEng()==0)) {}else {
         	       		eng = Long.toString(mark.getEng());}
         	       	   
         	       	if((mark.getKis()==0)) {}else {
      	       		kis = Long.toString(mark.getKis());} 
         	       	
         	       if((mark.getMath()==0)) {}else {
      	       		math = Long.toString(mark.getMath());}
         	       
         	      if((mark.getBio()==0)) {}else {
     	       		bio = Long.toString(mark.getBio());} 
         	      
         	     if((mark.getChem()==0)) {}else {
    	       		chem = Long.toString(mark.getChem());}
         	     
         	    if((mark.getPhy()==0)) {}else {
    	       		phy = Long.toString(mark.getPhy());}
         	    
         	   if((mark.getGeo()==0)) {}else {
    	       		geo = Long.toString(mark.getGeo());}
         	   
         	  if((mark.getHis()==0)) {}else {
    	       		his = Long.toString(mark.getHis());}
         	  
         	 if((mark.getCre()==0)) {}else {
    	       		cre = Long.toString(mark.getCre());}
         	 
         	if((mark.getAgric()==0)) {}else {
           		agric = Long.toString(mark.getAgric());}
         	
         	if((mark.getBiz()==0)) {}else {
           		bis = Long.toString(mark.getBiz());}
         	if((mark.getComp()==0)) {}else {
           		comp = Long.toString(mark.getComp());}
         	if((mark.getHom()==0)) {}else {
           		hom = Long.toString(mark.getHom());}
         	if((mark.getTt()==0)) {}else {
           		tt = Long.toString(mark.getTt());}
         	       	  
         	           	eng_grade = mark.getEng_grade();kis_grade = mark.getKis_grade();	math_grade = mark.getMath_grade();       	
         	          	bio_grade = mark.getBio_grade();chem_grade = mark.getChem_grade();phy_grade = mark.getPhy_grade();
         	           	geo_grade = mark.getGeo_grade();his_grade = mark.getHis_grade();cre_grade = mark.getCre_grade();
         	           	agric_grade = mark.getAgric_grade();bis_grade = mark.getBiz_grade();comp_grade = mark.getComp_grade();
         	           	hom_grade = mark.getHom_grade();tt_pnts_grade = mark.getOv_pnts_grade();
         	           if((mark.getEng_pnts()==0)) {}else {
         	        	  eng_pnts = Long.toString(mark.getEng_pnts());}
            	       	   
            	       	if((mark.getKis_pnts()==0)) {}else {
         	       		kis_pnts = Long.toString(mark.getKis_pnts());} 
            	       	
            	       if((mark.getMath_pnts()==0)) {}else {
         	       		math_pnts = Long.toString(mark.getMath_pnts());}
            	       
            	      if((mark.getBio_pnts()==0)) {}else {
        	       		bio_pnts = Long.toString(mark.getBio_pnts());} 
            	      
            	     if((mark.getChem_pnts()==0)) {}else {
       	       		chem_pnts = Long.toString(mark.getChem_pnts());}
            	     
            	    if((mark.getPhy_pnts()==0)) {}else {
       	       		phy_pnts = Long.toString(mark.getPhy_pnts());}
            	    
            	   if((mark.getGeo_pnts()==0)) {}else {
       	       		geo_pnts = Long.toString(mark.getGeo_pnts());}
            	   
            	  if((mark.getHis_pnts()==0)) {}else {
       	       		his_pnts = Long.toString(mark.getHis_pnts());}
            	  
            	 if((mark.getCre_pnts()==0)) {}else {
       	       		cre_pnts = Long.toString(mark.getCre_pnts());}
            	 
            	if((mark.getAgric_pnts()==0)) {}else {
              		agric_pnts = Long.toString(mark.getAgric_pnts());}
            	
            	if((mark.getBiz_pnts()==0)) {}else {
              		bis_pnts = Long.toString(mark.getBiz_pnts());}
            	if((mark.getComp_pnts()==0)) {}else {
              		comp_pnts = Long.toString(mark.getComp_pnts());}
            	if((mark.getHom_pnts()==0)) {}else {
              		hom_pnts = Long.toString(mark.getHom_pnts());}
            	if((mark.getOv_pnts()==0)) {}else {
              		tt_pnts = Long.toString(mark.getOv_pnts());}
            	if((mark.getPoints()==0)) {}else {
             		points = Long.toString(mark.getPoints());}
            	
         	            ov_pnts_grade = mark.getOv_pnts_grade();
         	 			
         	 			  eng_pos = mark.getEng_pos(); kis_pos = mark.getKis_pos(); math_pos = mark.getMath_pos(); bio_pos = mark.getBio_pos(); chem_pos = mark.getChem_pos();
         	  			 phy_pos = mark.getPhy_pos(); geo_pos = mark.getGeo_pos(); his_pos = mark.getHis_pos(); cre_pos = mark.getCre_pos(); agric_pos = mark.getAgric_pos();
         	  			 bis_pos = mark.getBiz_pos(); comp_pos = mark.getComp_pos(); hom_pos = mark.getHom_pos();
         	  			
         	  			 eng_remarks = mark.getEng_remarks(); kis_remarks = mark.getKis_remarks(); math_remarks = mark.getMath_remarks(); bio_remarks = mark.getBio_remarks(); chem_remarks = mark.getChem_remarks();
         	 			 phy_remarks = mark.getPhy_remarks(); geo_remarks = mark.getGeo_remarks(); his_remarks = mark.getHis_remarks(); cre_remarks = mark.getCre_remarks(); agric_remarks = mark.getAgric_remarks();
         	 			 bis_remarks = mark.getBiz_remarks(); comp_remarks = mark.getComp_remarks(); hom_remarks = mark.getHom_remarks(); 
         	 			crank = mark.getCrank(); rank = mark.getRank();principal_remarks = mark.getPri_remarks(); class_teacher_remarks = mark.getClsT_remarks();
         	 			
         	 			 trm = mark.getTerm(); yr = mark.getYear();
         	           	}
         		//form 1
         		List<Student> std_north = studentService.selectAll_north_students(stdd.getStream(),stdd.getForm());
         		int northSize = std_north.size();
         		List<FormOneMarksBackUp> exam_f1 = formoneSubjectRankingService.selectAll_TermOne(stdd.getRegno());
         		for (FormOneMarksBackUp exam_mark : exam_f1) {
        			 exam_tt_one_f1 = Long.toString(exam_mark.getTt());  exam_points_one_f1 = Long.toString(exam_mark.getPoints());  exam_mean_one_f1 = exam_mark.getOv_grade();  exam_op_one_f1 = exam_mark.getRank();
         	           	}
         		List<FormOneMarksBackUp> exam_two_f1 = formoneSubjectRankingService.selectAll_TermTwo(stdd.getRegno());
         		for (FormOneMarksBackUp exam_mar : exam_two_f1) {
        			 exam_tt_two_f1 = Long.toString(exam_mar.getTt());  exam_points_two_f1 = Long.toString(exam_mar.getPoints());  exam_mean_two_f1 = exam_mar.getOv_grade();  exam_op_two_f1 = exam_mar.getRank();
         	           	}
         		List<FormOneMarksBackUp> exam_three_f1 = formoneSubjectRankingService.selectAll_TermThree(stdd.getRegno());
         		for (FormOneMarksBackUp exam_ma : exam_three_f1) {
        			 exam_tt_three_f1 = Long.toString(exam_ma.getTt());  exam_points_three_f1 = Long.toString(exam_ma.getPoints());  exam_mean_three_f1 = exam_ma.getOv_grade();  exam_op_three_f1 = exam_ma.getRank();
         	           	}
         		
         	// form 2
           		List<Form2marksbackup> exam_f2 = form2SubjectRankingService.selectAll_TermOne(stdd.getRegno());
           		for (Form2marksbackup exam_mark : exam_f2) {
          			 exam_tt_one_f2 = Long.toString(exam_mark.getTt());  exam_points_one_f2 = Long.toString(exam_mark.getPoints());  exam_mean_one_f2 = exam_mark.getOv_grade();  exam_op_one_f2 = exam_mark.getRank();
           	           	}
           		List<Form2marksbackup> exam_two_f2 = form2SubjectRankingService.selectAll_TermTwo(stdd.getRegno());
           		for (Form2marksbackup exam_mar : exam_two_f2) {
          			 exam_tt_two_f2 = Long.toString(exam_mar.getTt());  exam_points_two_f2 = Long.toString(exam_mar.getPoints());  exam_mean_two_f2 = exam_mar.getOv_grade();  exam_op_two_f2 = exam_mar.getRank();
           	           	}
           		List<Form2marksbackup> exam_three_f2 = form2SubjectRankingService.selectAll_TermThree(stdd.getRegno());
           		for (Form2marksbackup exam_ma : exam_three_f2) {
          			 exam_tt_three_f2 = Long.toString(exam_ma.getTt());  exam_points_three_f2 = Long.toString(exam_ma.getPoints());  exam_mean_three_f2 = exam_ma.getOv_grade();  exam_op_three_f2 = exam_ma.getRank();
           	           	}
         		
         		List<Form4marksbackup> exam = form4SubjectRankingService.selectAll_TermOne(stdd.getRegno());
         		for (Form4marksbackup exam_mark : exam) {
         			
         			if((exam_mark.getTt()==0)) {}else {
         				exam_tt_one = Long.toString(exam_mark.getTt());} // total marks
                	
         			if((exam_mark.getPoints()==0)) {}else {
         				exam_points_one = Long.toString(exam_mark.getPoints());} //ov points
                	
         			 exam_mean_one = exam_mark.getOv_pnts_grade();  exam_op_one = exam_mark.getRank();
         	           	}
         		List<Form4marksbackup> exam_two = form4SubjectRankingService.selectAll_TermTwo(stdd.getRegno());
         		for (Form4marksbackup exam_mar : exam_two) {
         			
         			if((exam_mar.getTt()==0)) {}else {
         				exam_tt_two = Long.toString(exam_mar.getTt());}
                	
         			if((exam_mar.getPoints()==0)) {}else {
         				exam_points_two = Long.toString(exam_mar.getPoints());}
         			 exam_mean_two = exam_mar.getOv_pnts_grade();  exam_op_two = exam_mar.getRank();
         	           	}
         		List<Form4marksbackup> exam_three = form4SubjectRankingService.selectAll_TermThree(stdd.getRegno());
         		for (Form4marksbackup exam_ma : exam_three) {
         			if((exam_ma.getTt()==0)) {}else {
         				exam_tt_three = Long.toString(exam_ma.getTt());}
                	
         			if((exam_ma.getPoints()==0)) {}else {
         				exam_points_three = Long.toString(exam_ma.getPoints());}
         			
        			 exam_mean_three = exam_ma.getOv_pnts_grade();  exam_op_three = exam_ma.getRank();
         	           	}
         		
         		List<Formthreemarksbackup> exam_f3 = formThreeSubjectRankingService.selectAll_TermOne(stdd.getRegno());
         		for (Formthreemarksbackup exam_mark : exam_f3) {
         			
         			if((exam_mark.getTt()==0)) {}else {
         				exam_tt_one_f3 = Long.toString(exam_mark.getTt());} // total marks
                	
         			if((exam_mark.getPoints()==0)) {}else {
         				exam_points_one_f3 = Long.toString(exam_mark.getPoints());} //ov points
                	
         			 exam_mean_one_f3 = exam_mark.getOv_pnts_grade();  exam_op_one_f3 = exam_mark.getRank();
         	           	}
         		List<Formthreemarksbackup> exam_two_f3 = formThreeSubjectRankingService.selectAll_TermTwo(stdd.getRegno());
         		for (Formthreemarksbackup exam_mar : exam_two_f3) {
         			
         			if((exam_mar.getTt()==0)) {}else {
         				exam_tt_two_f3 = Long.toString(exam_mar.getTt());}
                	
         			if((exam_mar.getPoints()==0)) {}else {
         				exam_points_two_f3 = Long.toString(exam_mar.getPoints());}
         			 exam_mean_two_f3 = exam_mar.getOv_pnts_grade();  exam_op_two_f3 = exam_mar.getRank();
         	           	}
         		List<Formthreemarksbackup> exam_three_f3 = formThreeSubjectRankingService.selectAll_TermThree(stdd.getRegno());
         		for (Formthreemarksbackup exam_ma : exam_three_f3) {
         			if((exam_ma.getTt()==0)) {}else {
         				exam_tt_three_f3 = Long.toString(exam_ma.getTt());}
                	
         			if((exam_ma.getPoints()==0)) {}else {
         				exam_points_three_f3 = Long.toString(exam_ma.getPoints());}
         			
        			 exam_mean_three_f3 = exam_ma.getOv_pnts_grade();  exam_op_three_f3 = exam_ma.getRank();
         	           	}
         		List<Form4marksbackup> std_mean = form4SubjectRankingService.student_mean_dev(stdd.getRegno());
         		for (Form4marksbackup student_dev : std_mean) {
         			 devtion = student_dev.getDev();
         		}
         		DefaultCategoryDataset chart =new DefaultCategoryDataset();
         	
         		double t1_f1 = 0.0;        double t1_f2 = 0.0;      double t1_f3 = 0.0;      double t1_f4 = 0.0;
         		double t2_f1 = 0.0;        double t2_f2 = 0.0;      double t2_f3 = 0.0;      double t2_f4 = 0.0;
         		double t3_f1 = 0.0;        double t3_f2 = 0.0;      double t3_f3 = 0.0;      double t3_f4 = 0.0;
         		
         		t1_f1 = Double.parseDouble(exam_points_one_f1);
         		t2_f1 = Double.parseDouble(exam_points_two_f1);
         		t3_f1 = Double.parseDouble(exam_points_three_f1); 
         		
         		t1_f2 = Double.parseDouble(exam_points_one_f2);
         		t2_f2 = Double.parseDouble(exam_points_two_f2);
         		t3_f2 = Double.parseDouble(exam_points_three_f2);
         		
         		t1_f3 = Double.parseDouble(exam_points_one_f3);
         		t2_f3 = Double.parseDouble(exam_points_two_f3);
         		t3_f3 = Double.parseDouble(exam_points_three_f3);
         		
         		 t1_f4 = Double.parseDouble(exam_points_one);
         		t2_f4 = Double.parseDouble(exam_points_two);
         		t3_f4 = Double.parseDouble(exam_points_three);
         		
                chart.setValue(t1_f1,"Marks","F1T1"); 
                chart.setValue(t2_f1,"Marks","F1T2"); 
                chart.setValue(t3_f1,"Marks","F1T3");
                
                chart.setValue(t1_f2,"Marks","F2T1");
                chart.setValue(t2_f2,"Marks","F2T2"); 
                chart.setValue(t3_f2,"Marks","F2T3"); 
                
                chart.setValue(t1_f3,"Marks","F3T1");
                chart.setValue(t2_f3,"Marks","F3T2");
                chart.setValue(t3_f3,"Marks","F3T3"); 
                
                chart.setValue(t1_f4,"Marks","F4T1"); 
                chart.setValue(t2_f4,"Marks","F4T2");
                chart.setValue(t3_f4,"Marks","F4T3");
                JFreeChart my2DChart = ChartFactory.createBarChart("Progress Gragh","TERM","Points",chart,PlotOrientation.VERTICAL,false,true,false); 
                
                TextTitle mm = new TextTitle("STUDENT PROGRESS GRAPH");
                my2DChart.setTitle(mm);
         		Rectangle rect= new Rectangle(577,825,18,15); 
         		rect.setBorder(Rectangle.BOX);
         		rect.enableBorderSide(1);
         	     rect.enableBorderSide(2);
         	     rect.enableBorderSide(4);
         	     rect.enableBorderSide(8);
         	    rect.setBorderWidth(1);
         		//rect.setBackgroundColor(Color.BLACK);
         		
         		document.add(rect);
         		
         		PdfPTable table2 = new PdfPTable(3);
                 table2.setSpacingBefore(2);
                 table2.setWidthPercentage(98);
                 table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 table2.setWidths(new int []{2,5,2});
                 Image img = Image.getInstance(Form_4_reports.class.getResource("/images.jpg"));
                 img.scaleAbsolute(100, 48);
                 table2.addCell(new PdfPCell(new Phrase(new Chunk(img,0,-48))));
                 table2.addCell(new PdfPCell(new Phrase("SCHOOL   : GEOFF BROWN HIGH \n" + "ADDRESS : P.O Box 23009-50200 Sirisia\n" + "Tel             : 0712345678\n" + "MOTTO     : Hard Work Pays")));
                 Image img2 = Image.getInstance(Form_4_reports.class.getResource("/male3-128.png"));
                 img2.scaleAbsolute(100, 50);             
                 table2.addCell(new PdfPCell(new Phrase(new Chunk(img2,0,-50))));
                 Font FON = FontFactory.getFont(FontFactory.COURIER_OBLIQUE,12,Align.CENTER);
                 Font FONT = FontFactory.getFont(FontFactory.COURIER_OBLIQUE,12);
                 Font FONT1 = FontFactory.getFont(FontFactory.HELVETICA,9);
                 PdfPTable table1 = new PdfPTable(1);
                 table1.setSpacingBefore(2);   
                 table1.setWidthPercentage(98);
                 table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 table1.addCell(new PdfPCell(new Paragraph("Admission No :  " + stdd.getRegno(),FON)));
                 table1.addCell(new PdfPCell(new Paragraph("Name :  " + stdd.getFname() + "       "+ stdd.getSirname() + "     Status : " + stdd.getStatus(),FONT)));
                 table1.addCell(new PdfPCell(new Paragraph("Form :  " + stdd.getForm() + "           STREAM : " +stdd.getStream() + "            Gender: " +stdd.getGender() + "        Term : " + trm + "   Yr :  " +yr,FONT1)));
                 table1.addCell(new PdfPCell(new Paragraph("Class Pos : " + crank+"/" +northSize +" Overral Pos : " +rank+"/"+total+" Points: " +tt_pnts +"/84"+ "   GRADE : " + tt_pnts_grade ,FONT)));
                 
                PdfPTable table_PERF = new PdfPTable(20);
                 table_PERF.setSpacingBefore(2);   
                 table_PERF.setWidthPercentage(98);
                 table_PERF.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 Font fonth_P = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
                 
                 
         		
                 Font font1 = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
                 Font font_dev = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
                 PdfPCell pdfPCell = new PdfPCell(new Phrase(" "));
                 pdfPCell.setColspan(10);
                 PdfPCell pdfP_tt = new PdfPCell(new Phrase("Total Marks",font1));
                 pdfP_tt.setColspan(2);
                 PdfPCell pdfP_ttpnts = new PdfPCell(new Phrase("Total Points",font1));
                 pdfP_ttpnts.setColspan(2);
                 PdfPCell pdfP_grd = new PdfPCell(new Phrase("Overal Grade",font1));
                 pdfP_grd.setColspan(2);
                 
                 PdfPCell pdfP_pos = new PdfPCell(new Phrase("Stream Position",font1));
                 pdfP_pos.setColspan(2);
                 
                 PdfPCell pdfP_pos1 = new PdfPCell(new Phrase("Overal Position",font1));
                 pdfP_pos1.setColspan(2);
                 
                
                Font fonth1 = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
                 PdfPTable table = new PdfPTable(10);
                 table.setSpacingBefore(2);
                 table.setWidthPercentage(98);
                 table.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 Font fonth = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
                 table.setWidths(new int []{1,3,1,1,1,1,1,1,3,1});
                 table.addCell(new PdfPCell(new Phrase("Code",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Subject",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Exam1",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Exam2",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Exam3",fonth)));
                 table.addCell(new PdfPCell(new Phrase("AVG",fonth)));
                 table.addCell(new PdfPCell(new Phrase("pnts",fonth)));
                 table.addCell(new PdfPCell(new Phrase("POS",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Remarks",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Initials",fonth)));
                 
                 table.addCell(new PdfPCell(new Phrase("101",fonth)));
                 table.addCell(new PdfPCell(new Phrase("English",fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng1 + eng1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng2 + eng2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng3 + eng3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng + eng_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(eng_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));
                 
                 table.addCell(new PdfPCell(new Phrase("102",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Kiswahili",fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis1 + kis1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis2 + kis2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis3 + kis3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis + kis_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(kis_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));
                 
                 table.addCell(new PdfPCell(new Phrase("121",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Mathematics",fonth)));
                 table.addCell(new PdfPCell(new Phrase(math1 + math1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math2 + math2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math3 + math3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math + math_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(math_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));
                 
                 table.addCell(new PdfPCell(new Phrase("231",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Biology",fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio1 + bio1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio2 + bio2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio3 + bio3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio + bio_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bio_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));
                 
                 table.addCell(new PdfPCell(new Phrase("233",fonth)));
                 table.addCell(new PdfPCell(new Phrase("Chemistry",fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem1 + chem1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem2 + chem2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem3 + chem3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem + chem_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(chem_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));
                 if(stdd.getPhysics().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("232",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getPhysics(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy1 + phy1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy2 + phy2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy3 + phy3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy + phy_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(phy_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getGeography().equals("")) {}else {
                 table.addCell(new PdfPCell(new Phrase("312",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getGeography(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo1 + geo1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo2 + geo2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo3 + geo3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo + geo_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(geo_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getHistory().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("311",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getHistory(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(his1 + his1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his2 + his2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his3 + his3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his + his_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(his_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getCre().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("313",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getCre(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre1 + cre1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre2 + cre2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre3 + cre3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre + cre_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(cre_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getAgriculture().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("443",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getAgriculture(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric1 + agric1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric2 + agric2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric3 + agric3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric + agric_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(agric_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getBusiness().equals("")) {}else {
                 table.addCell(new PdfPCell(new Phrase("565",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getBusiness(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis1 + bis1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis2 + bis2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis3 + bis3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis + bis_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(bis_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getComputer().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("451",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getComputer(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp1 + comp1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp2 + comp2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp3 + comp3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp + comp_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(comp_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}
                 if(stdd.getHomescience().equals("")){}else {
                 table.addCell(new PdfPCell(new Phrase("500",fonth)));
                 table.addCell(new PdfPCell(new Phrase(stdd.getHomescience(),fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom1 + hom1_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom2 + hom2_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom3 + hom3_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom + hom_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom_pnts,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom_pos,fonth)));
                 table.addCell(new PdfPCell(new Phrase(hom_remarks,fonth)));
                 table.addCell(new PdfPCell(new Phrase("",fonth)));}             
                 
                 table.addCell(pdfPCell);
                 
                 table.addCell(pdfP_tt);        
                 table.addCell(new PdfPCell(new Phrase(tt1 +"/ 700",fonth1)));
                 table.addCell(new PdfPCell(new Phrase(tt2 +"/ 700",fonth1)));
                 table.addCell(new PdfPCell(new Phrase(tt3 +"/ 700",fonth1)));
                 table.addCell(new PdfPCell(new Phrase(tt +"/ 700",fonth1)));    
                 PdfPCell colss5 = new PdfPCell(new Phrase("kcpe",font1));
                 colss5.setRowspan(2);
                 table.addCell(colss5);
                 PdfPCell colss = new PdfPCell(new Phrase(stdd.getKcpemarks(),font1));
                 colss.setColspan(5);
                 table.addCell(colss);
               
                 
                 table.addCell(pdfP_ttpnts);
                 table.addCell(new PdfPCell(new Phrase(Ov_pnts1 +"/84",fonth)));
                 table.addCell(new PdfPCell(new Phrase(Ov_pnts2 +"/84",fonth)));
                 table.addCell(new PdfPCell(new Phrase(Ov_pnts3 +"/84",fonth)));
                 table.addCell(new PdfPCell(new Phrase(tt_pnts + "/84",fonth)));
                 PdfPCell colss1 = new PdfPCell(new Phrase(kcpe_grade,font1));
                 colss1.setColspan(4);
                 table.addCell(colss1);
                 
                 
                 
                 table.addCell(pdfP_grd);
                 table.addCell(new PdfPCell(new Phrase(tt1_pnts_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(tt2_pnts_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(tt3_pnts_grade,fonth)));
                 table.addCell(new PdfPCell(new Phrase(tt_pnts_grade,fonth)));
                 PdfPCell colss6 = new PdfPCell(new Phrase("MEAN",font1));
                 colss6.setRowspan(3);
                 table.addCell(colss6);
                 PdfPCell colss2 = new PdfPCell(new Phrase("",font1));             
                 colss2.setColspan(2);
                 table.addCell(colss2);
                 table.addCell(new PdfPCell(new Phrase("")));
                 
                 table.addCell(pdfP_pos);
                 table.addCell(new PdfPCell(new Phrase(crank1 +"/"+ northSize,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(crank2 +"/"+ northSize,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(crank3 +"/"+ northSize,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(crank +"/"+ northSize,fonth1)));
                 PdfPCell colss3 = new PdfPCell(new Phrase("Mean Deviation",font1));
                 colss3.setColspan(2);
                 table.addCell(colss3);
                 table.addCell(new PdfPCell(new Phrase("")));
                 
                 table.addCell(pdfP_pos1);  
                 table.addCell(new PdfPCell(new Phrase(rank1 +"/"+ total ,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(rank2 +"/"+ total ,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(rank3 +"/"+ total ,fonth1)));
                 table.addCell(new PdfPCell(new Phrase(rank +"/"+ total ,fonth1)));   
                 long de = Long.parseLong(devtion);
                 if(de >= 0) {
                 PdfPCell colss4 = new PdfPCell(new Phrase("ADDED BY:",font_dev));
                 colss4.setColspan(2);
                  table.addCell(colss4);
                  table.addCell(new PdfPCell(new Phrase(devtion,font_dev)));
                 }else {
                	 PdfPCell colss4 = new PdfPCell(new Phrase("DROPPED BY :",font_dev));
                     colss4.setColspan(2);
                      table.addCell(colss4);
                      table.addCell(new PdfPCell(new Phrase(devtion,font_dev)));
                 }
                 
                 table.completeRow();
                 
                 PdfPTable table4 = new PdfPTable(4);
                 table4.setSpacingBefore(1);
                 table4.setWidthPercentage(98);
                 table4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                 table4.setWidths(new int []{5,5,5,5});
                 table4.addCell(new PdfPCell(new Phrase("FORM 1")));
                 table4.addCell(new PdfPCell(new Phrase("FORM 2")));
                 table4.addCell(new PdfPCell(new Phrase("FORM 3")));
                 table4.addCell(new PdfPCell(new Phrase("FORM 4")));
                 
                 table_PERF.setWidths(new int []{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2});
                 table_PERF.addCell(new PdfPCell(new Phrase("Term",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MKS",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("PT",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MG",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("O.P",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("Term",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MKS",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("PT",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MG",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("O.P",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("Term",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MKS",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("PT",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MG",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("O.P",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("Term",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MKS",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("PT",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("MG",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("O.P",fonth_P)));
                 
                 table_PERF.addCell(new PdfPCell(new Phrase("1",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_one_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_one_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_one_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_one_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("1",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_one_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_one_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_one_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_one_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("1",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_one_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_one_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_one_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_one_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("1",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_one,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_one,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_one,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_one,fonth_P)));
                 
                 table_PERF.addCell(new PdfPCell(new Phrase("2",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_two_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_two_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_two_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_two_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("2",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_two_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_two_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_two_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_two_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("2",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_two_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_two_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_two_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_two_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("2",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_two,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_two,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_two,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_two,fonth_P)));
                 
                 table_PERF.addCell(new PdfPCell(new Phrase("3",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_three_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_three_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_three_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_three_f1,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("3",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_three_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_three_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_three_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_three_f2,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("3",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_three_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_three_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_three_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_three_f3,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase("3",fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_tt_three,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_points_three,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_mean_three,fonth_P)));
                 table_PERF.addCell(new PdfPCell(new Phrase(exam_op_three,fonth_P)));
                 
                 document.add(table2);
                 document.add(table1);
                 document.add(table);  
                 document.add(new Paragraph(" "));
                 document.add(table4);
                 document.add(table_PERF);
                     
                     PdfContentByte Add_Chart_Content= writer.getDirectContent();
                     
                     PdfTemplate template_Chart_Holder = Add_Chart_Content.createTemplate(width,height);
                     
                     Graphics2D Graphics_Chart=template_Chart_Holder.createGraphics(width,height,new DefaultFontMapper());                
                     Rectangle2D Chart_Region=new Rectangle2D.Double(28,2,530,150); //25,<left; 150 height;
                    
                     
                     my2DChart.draw(Graphics_Chart,Chart_Region);            
                     Graphics_Chart.dispose();
                     
                    Add_Chart_Content.addTemplate(template_Chart_Holder,0,135);
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));   
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph(". "));
                    document.add(new Paragraph("Class Teacher Mr/Mrs. " + first_name +" "+ other_name +"      Remarks : "+ class_teacher_remarks,font1));
                    document.add(new Paragraph("Principal Mr/Mrs. " + p_fname + " "+ p_othername + "      Remarks : "+ principal_remarks,font1));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph("      Closing Date : 2.08.2019 " + "       Opening Date : 27.8.2018",font1));               
                    document.add(new Paragraph("------------------created by javenock And Company----------------------- ",font1));
                    
                    
                   
                   // document.open();
                   
                   // document.add(table);
                   
                    
                    
        	}
            	 document.close();
            // }catch (DocumentException ex) {
                // logger.error("Error occurred: {0}", ex);
            // }
             return new ByteArrayInputStream(out.toByteArray());
         }
            
}
