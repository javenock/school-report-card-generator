package com.skul.skul.controller;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.List;

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

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.skul.skul.model.Form2backupbase;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.service.Form2SubjectRankingService;
import com.skul.skul.service.FormOneSubjectRankingService;
import com.skul.skul.service.StudentService;
import com.skul.skul.utils.GeneratePdfReport;
import com.skul.skul.utils.HeaderFooterPageEvent;

@RequestMapping("/f2_class_analysis")
@Controller
public class F2_analysis {

	@Autowired
	Form2SubjectRankingService form2SubjectRankingService;
	
	@Autowired
	StudentService studentService;
	
	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);
	
	@RequestMapping(value = "/two_analysis_gen_/{year}/{term}/{examtype}", method = RequestMethod.GET,produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> two_analysis_Report(@PathVariable String term, @PathVariable String year,@PathVariable String examtype ) throws FileNotFoundException, DocumentException {

        ByteArrayInputStream bis = f2_Reportw(term, year, examtype);

        HttpHeaders  headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=form_TWO_MARK_SHEET.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	
	@GetMapping(value = "/two_analysis_gen_")
	public String getTecMarksEntryByStramForm(@ModelAttribute("term") String term,@ModelAttribute("year") String year, @ModelAttribute("examtype") String examtype, Model model) {
	    return "redirect:/f2_class_analysis/two_analysis_gen_/" + year +"/" + term + "/" + examtype;          
	    
	}
	
	
	   public  ByteArrayInputStream f2_Reportw(String term, String year, String examtype) throws DocumentException {
		
		List<Form2backupbase> rowMarks =  form2SubjectRankingService.selectAll(term, year, examtype);

		List<Subject_Analysis> sub_analy =  form2SubjectRankingService.sub_analysis(term, year, examtype);

		List<Subject_Analysis> stream_analy =  form2SubjectRankingService.stream_analysis(term, year, examtype);
		
		
		
        Document document = new Document(PageSize.A4.rotate(),36,36,90,36);
              ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            PdfPTable table = new PdfPTable(24); 
            table.setWidthPercentage(106);
            table.setWidths(new int[]{5,15,4,5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,4,4,4,4,4});
            Font font = FontFactory.getFont(FontFactory.TIMES_BOLD,10);
            Font fontn = FontFactory.getFont(FontFactory.TIMES_ITALIC,9);
            Font font3 = FontFactory.getFont(FontFactory.HELVETICA,10);
            Font font1 = FontFactory.getFont(FontFactory.TIMES_ITALIC,9);
            Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
            Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD,14);
            PdfPCell hcell;
            
            PdfPCell pdfP_pos1 = new PdfPCell(new Phrase("                     --     "+ "EXAM : " +examtype +"    " +"TERM : "+term+"  "+"YEAR : "+year+ "   "+"F2"+ "   --",font4 ));
            pdfP_pos1.setColspan(24);
            table.addCell(pdfP_pos1);
            hcell = new PdfPCell(new Phrase("ADM NO", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("NAME", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("KCPE", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("STRM", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("ENG", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("KIS", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("MAT", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("BIO", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("CHE", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("PHY", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("GEO", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("HIS", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("CRE", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("AGR", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("BST", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("COM", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("HOM", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("SUB", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("TOT", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("PNT", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("GRD", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("C.P", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell); 
            
            hcell = new PdfPCell(new Phrase("O.P", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("VAP", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
          for (Form2backupbase mks : rowMarks) {

        	  String admno = "--";     String fname = "--";               String stream = "--";   
        	String eng = "--";         String kis = "--";             String math = "--";            String bio = "--";         String chem = "--";
   			String phy = "--";         String geo = "--";             String his = "--";             String cre = "--";         String agric = "--";
   			String bis = "--";         String comp = "--";            String hom = "--";             String tt = "--";
   			String eng_grade = "--";   String kis_grade = "--";       String math_grade = "--";      String bio_grade = "--";     String chem_grade = "--";
   			String phy_grade = "--";   String geo_grade = "--";       String his_grade = "--";       String cre_grade = "--";     String agric_grade = "--";
   			String bis_grade = "--";   String comp_grade = "--";      String hom_grade = "--";       String tt_pnts_grade = "--";
   			String tot = "--"; String ovpoints = "--"; String ovpgrade = "--"; String crnk = "--"; String rank = "--";
   			 String subono = "--"; String kcpemarks = "--"; String kcpegrade = "--";  String vap = "--";
   			 kcpemarks = mks.getKcpemarks();  
   			 kcpegrade = mks.getKcpegrade();   vap = mks.getVap();
   					 
   			admno = mks.getRegno().toString();
   			  fname = mks.getFname(); stream = mks.getStream();
   			if((mks.getEng()==0) || mks.getEng().equals("null")) {}else {
 	       		eng = Long.toString(mks.getEng());}
 	       	   
 	       	if((mks.getKis()==0) || mks.getKis().equals("null")) {}else {
	       		kis = Long.toString(mks.getKis());} 
 	       	
 	       if((mks.getMath()==0) || mks.getMath().equals("null")) {}else {
	       		math = Long.toString(mks.getMath());}
 	       
 	      if((mks.getBio()==0) || mks.getBio().equals("null")) {}else {
	       		bio = Long.toString(mks.getBio());} 
 	      
 	     if((mks.getChem()==0) || mks.getChem().equals("null")) {}else {
       		chem = Long.toString(mks.getChem());}
 	     
 	    if((mks.getPhy()==0) || mks.getPhy().equals("null")) {}else {
       		phy = Long.toString(mks.getPhy());}
 	    
 	   if((mks.getGeo()==0) || mks.getGeo().equals("null")) {}else {
       		geo = Long.toString(mks.getGeo());}
 	   
 	  if((mks.getHis()==0) || mks.getHis().equals("null")) {}else {
       		his = Long.toString(mks.getHis());}
 	  
 	 if((mks.getCre()==0) || mks.getCre().equals("null")) {}else {
       		cre = Long.toString(mks.getCre());}
 	 
 	if((mks.getAgric()==0) || mks.getAgric().equals("null")) {}else {
   		agric = Long.toString(mks.getAgric());}
 	
 	if((mks.getBiz()==0) || mks.getBiz().equals("null")) {}else {
   		bis = Long.toString(mks.getBiz());}
 	if((mks.getComp()==0) || mks.getComp().equals("null")) {}else {
   		comp = Long.toString(mks.getComp());}
 	if((mks.getHom()==0) || mks.getHom().equals("null")) {}else {
   		hom = Long.toString(mks.getHom());}
 	if((mks.getTt()==0)) {}else {
   		tt = Long.toString(mks.getTt());}
  /* eng = mks.getEng().toString();    kis = mks.getKis().toString();    math = mks.getMath().toString();   bio = mks.getBio().toString();  chem = mks.getChem().toString();
   phy = mks.getPhy().toString();    geo = mks.getGeo().toString();    his = mks.getHis().toString();   cre = mks.getCre().toString();  agric = mks.getAgric().toString();
   bis = mks.getBiz().toString();    comp = mks.getComp().toString();    hom = mks.getHom().toString();   */
   
	eng_grade = mks.getEng_grade();	     kis_grade = mks.getKis_grade();	math_grade = mks.getMath_grade();	bio_grade = mks.getBio_grade();
	chem_grade = mks.getChem_grade();    phy_grade = mks.getPhy_grade();  	geo_grade = mks.getGeo_grade();	    his_grade = mks.getHis_grade();
	cre_grade = mks.getCre_grade();   	 agric_grade = mks.getAgric_grade(); bis_grade = mks.getBiz_grade();	comp_grade = mks.getComp_grade();
    hom_grade = mks.getHom_grade();
   			  
   	tot = mks.getTt().toString(); ovpoints = mks.getPoints().toString(); ovpgrade = mks.getOv_grade(); crnk = mks.getCrank(); rank = mks.getRank();
   			  
   				  
                PdfPCell cell;
                cell = new PdfPCell(new Phrase(admno,font2));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(fname,fontn));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell); 
                
                cell = new PdfPCell(new Phrase(kcpemarks + kcpegrade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(stream,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell); 
                
                cell = new PdfPCell(new Phrase(eng + eng_grade,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(kis + kis_grade,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(math + math_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(chem + chem_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bio + bio_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(phy + phy_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(geo + geo_grade,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(his + his_grade,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(cre + cre_grade,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(agric + agric_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(bis + bis_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(comp + comp_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(hom + hom_grade,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase("13",font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(tot,font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(ovpoints,font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(ovpgrade,font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(crnk,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(rank,font3));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(vap,font1));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }

          
          PdfPTable table_t2 = new PdfPTable(17); 
          table_t2.setWidthPercentage(106);
          table_t2.setWidths(new int[]{5,10,4,5,4,4,4,4,4,4,4,4,4,4,4,4,4});
          Font font_t2 = FontFactory.getFont(FontFactory.TIMES_BOLD,10);
          Font font1_t2 = FontFactory.getFont(FontFactory.TIMES_ITALIC,9);
          Font font2_t2 = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
          PdfPCell hcell_t2;
          for (Subject_Analysis sabo : sub_analy) {
          hcell_t2 = new PdfPCell(new Phrase("Code", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("Subject", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("Entry", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("A", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("A-", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("B+", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("B", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("B-", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("C+", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("C", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("C-", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("D+", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          hcell_t2 = new PdfPCell(new Phrase("D", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("D-", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("E", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("Mean", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase("Grade", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
          hcell_t2 = new PdfPCell(new Phrase("101", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("ENGLISH", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getEng_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
          // kiswahili
          hcell_t2 = new PdfPCell(new Phrase("102", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("KISWAHILI", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getKis_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Mathematics
          hcell_t2 = new PdfPCell(new Phrase("121", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("MATHEMATICS", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getMath_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Biology
          hcell_t2 = new PdfPCell(new Phrase("231", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("BIOLOGY", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBio_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Chemistry
          hcell_t2 = new PdfPCell(new Phrase("233", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("CHEMISTRY", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getChem_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Physics
          hcell_t2 = new PdfPCell(new Phrase("232", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("PHYSICS", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getPhy_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Geo
          hcell_t2 = new PdfPCell(new Phrase("312", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("GEOGRAPHY", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getGeo_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // His
          hcell_t2 = new PdfPCell(new Phrase("311", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("HISTORY", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHis_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
          // Cre
          hcell_t2 = new PdfPCell(new Phrase("313", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("CRE", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getCre_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Agric
          hcell_t2 = new PdfPCell(new Phrase("443", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("AGRICULTURE", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getAgric_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Biz
          hcell_t2 = new PdfPCell(new Phrase("565", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("BUSINESS", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getBiz_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
       // Comp
          hcell_t2 = new PdfPCell(new Phrase("451", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("COMPUTER", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getComp_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          
          // Home
          hcell_t2 = new PdfPCell(new Phrase("455", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase("HOMESCIENCE", font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_LEFT);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_entry(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_aplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_aminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_bplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_bplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_bminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_cplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_cplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_cminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_dplus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_dplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_dminus(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_eplain(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_av(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);          
          hcell_t2 = new PdfPCell(new Phrase(sabo.getHom_grade(), font_t2));
          hcell_t2.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t2.addCell(hcell_t2);
          }
          // table 3
          
          PdfPTable table_t3 = new PdfPTable(16); 
          table_t3.setWidthPercentage(106);
          table_t3.setWidths(new int[]{5,10,4,5,4,4,4,4,4,4,4,4,4,4,5,5});
          Font font_t3 = FontFactory.getFont(FontFactory.TIMES_BOLD,12);
          Font font1_t3 = FontFactory.getFont(FontFactory.HELVETICA,12);
          Font font2_t3 = FontFactory.getFont(FontFactory.TIMES_BOLD,9);
          PdfPCell hcell_t3;
          
          hcell_t3 = new PdfPCell(new Phrase("STREAM", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("ENTRY", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("A", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("A-", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("B+", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("B", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("B-", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("C+", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("C", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("C-", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("D+", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("D", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("D-", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("E", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("MEAN x/100", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          hcell_t3 = new PdfPCell(new Phrase("M.G", font_t3));
          hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
          table_t3.addCell(hcell_t3);
          
          int i = 0;
           do {
        	   for (Subject_Analysis strm : stream_analy) {
        	   hcell_t3 = new PdfPCell(new Phrase(strm.getStream(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3); 
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getSt_entry(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getAplain(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getAminus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getBplus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getBplain(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3); 
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getBminus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getCplus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getCplain(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getCminus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getDplus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3); 
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getDplain(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getDminus(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getEplain(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getSt_av(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
               
               hcell_t3 = new PdfPCell(new Phrase(strm.getSt_grade(), font1_t3));
               hcell_t3.setHorizontalAlignment(Element.ALIGN_CENTER);
               table_t3.addCell(hcell_t3);
        	   }
               i++;
           } while( i < 1 );
       
            PdfWriter writer = PdfWriter.getInstance(document, out);
            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
            writer.setPageEvent(event);
            document.open();
            document.add(table);
            document.newPage();
            document.add(new Phrase("    ----    SUBJECT ANALYSIS   ----"));
            document.add(table_t2);
            document.newPage();
            document.add(table_t3);
            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
