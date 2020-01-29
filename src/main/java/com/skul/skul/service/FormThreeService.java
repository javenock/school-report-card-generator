package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Formthreebasebackup;
import com.skul.skul.model.Formthreemarksreportprocess;
import com.skul.skul.model.Student;

public interface FormThreeService {

	public List<FormThreeMarksEntry> select_eng_ByStream();
	
	public FormThreeMarksEntry findById(Long regno);
	
	public void update(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_geo_ByStream();
	
	public void update_geo(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_kis_ByStream();	
	public void update_kis(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_math_ByStream();	
	public void update_math(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_bio_ByStream();	
	public void update_bio(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_chem_ByStream();	
	public void update_chem(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_phy_ByStream();	
	public void update_phy(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_his_ByStream();	
	public void update_his(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_cre_ByStream();	
	public void update_cre(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_agric_ByStream();	
	public void update_agric(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_biz_ByStream();	
	public void update_biz(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_comp_ByStream();	
	public void update_comp(FormThreeMarksEntry e);
	
	public List<FormThreeMarksEntry> select_hom_ByStream();	
	public void update_hom(FormThreeMarksEntry e);
	
	public List<Student> select_students_ToLoad();
	public int[] select_all_students(List<Student> copy_all);
	
	public void updateExamType(String exmtype);
	public void updateTerm(String term);
	
	public List<FormThreeMarksEntry> sumup();
	public int[] batchUpdate_FormThree_tt(List<FormThreeMarksEntry> form_tt);
	
	public List<FormThreeMarksEntry> rankList();
	public int[] c_rank(List<FormThreeMarksEntry> crank);
	public List<FormThreeMarksEntry> rank_ave();
	public int[] rank_average(List<FormThreeMarksEntry> crankAvg);
	
	public List<FormThreeMarksEntry> selectAverageToBackUp();
	
	public int[] batchAverageToBackUp(List<FormThreeMarksEntry> backup);
	
	public  void deleteAll(List<FormThreeMarksEntry> backup);
	
	public List<Formthreebasebackup> select_avgs(String year, String term);
	public int[] copyAvg(List<Formthreebasebackup> copy_all);
	
	public List<Formthreemarksreportprocess> _form3_tt();
	public int[] batchUpdate_Form3_tt(List<Formthreemarksreportprocess> form_tt);

	public List<Formthreemarksreportprocess> f3_rankList();
	public int[] f3_c_rank(List<Formthreemarksreportprocess> crank);
	public List<Formthreemarksreportprocess> f3_rank_ave();
	public int[] f3_rank_average(List<Formthreemarksreportprocess> crankAvg);
	
	public List<Formthreemarksreportprocess> selectAvToBackUp();
	
	public int[] f3_bchAverageToBackUp(List<Formthreemarksreportprocess> backup);
	public int[] f3_deleteAl(List<Formthreemarksreportprocess> backup);
	}
