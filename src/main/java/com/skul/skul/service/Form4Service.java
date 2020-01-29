package com.skul.skul.service;

import java.util.List;

import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Form4MarksEntry;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Student;

public interface Form4Service {

	public List<Form4MarksEntry> select_eng_ByStream();
	
	public Form4MarksEntry findById(Long regno);
	
	public void update(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_geo_ByStream();
	
	public void update_geo(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_kis_ByStream();	
	public void update_kis(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_math_ByStream();	
	public void update_math(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_bio_ByStream();	
	public void update_bio(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_chem_ByStream();	
	public void update_chem(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_phy_ByStream();	
	public void update_phy(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_his_ByStream();	
	public void update_his(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_cre_ByStream();	
	public void update_cre(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_agric_ByStream();	
	public void update_agric(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_biz_ByStream();	
	public void update_biz(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_comp_ByStream();	
	public void update_comp(Form4MarksEntry e);
	
	public List<Form4MarksEntry> select_hom_ByStream();	
	public void update_hom(Form4MarksEntry e);
	
	public List<Student> select_students_ToLoad();
	public int[] select_all_students(List<Student> copy_all);
	
	public void updateExamType(String exmtype);
	public void updateTerm(String term);
	
	public List<Form4MarksEntry> sumup();
	public int[] batchUpdate_Formfour_tt(List<Form4MarksEntry> form_tt);
	
	public List<Form4MarksEntry> rankList();
	public int[] c_rank(List<Form4MarksEntry> crank);
	public List<Form4MarksEntry> rank_ave();
	public int[] rank_average(List<Form4MarksEntry> crankAvg);
	
	public List<Form4MarksEntry> selectAverageToBackUp();
	
	public int[] batchAverageToBackUp(List<Form4MarksEntry> backup);
	
	public  void deleteAll(List<Form4MarksEntry> backup);
	
	public List<Form4basebackup> select_avgs(String year, String term);
	public int[] copyAvg(List<Form4basebackup> copy_all);
	
	public List<Form4marksreportprocess> _form4_tt();
	public int[] batchUpdate_Form4_tt(List<Form4marksreportprocess> form_tt);

	public List<Form4marksreportprocess> f4_rankList();
	public int[] f4_c_rank(List<Form4marksreportprocess> crank);
	public List<Form4marksreportprocess> f4_rank_ave();
	public int[] f4_rank_average(List<Form4marksreportprocess> crankAvg);
	
	public List<Form4marksreportprocess> selectAvToBackUp();
	
	public int[] f4_bchAverageToBackUp(List<Form4marksreportprocess> backup);
	public int[] f4_deleteAl(List<Form4marksreportprocess> backup);
	}
