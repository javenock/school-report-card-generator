package com.skul.skul.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.skul.skul.dao.Form4SubjectRankingDao;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksbackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Subject_Analysis;
import com.skul.skul.utils.CommonGradeUtils_f3_and_f4;
import com.skul.skul.utils.Student_kcpe_marks_util;
@Component
public class Form4SubjectRankingDaoImpl implements Form4SubjectRankingDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	final String SQL_RANK_average = "SELECT regno,eng,RANK() OVER (ORDER BY eng DESC) AS eng_pos FROM Form4marksreportprocess";
	
	final String SQL_kis_average = "SELECT regno,kis,RANK() OVER (ORDER BY kis DESC) AS kis_pos FROM Form4marksreportprocess";
	
	final String SQL_math_average = "SELECT regno,math,RANK() OVER (ORDER BY math DESC) AS math_pos FROM Form4marksreportprocess";	
	
	final String SQL_bio_average = "SELECT regno,bio,RANK() OVER (ORDER BY bio DESC) AS bio_pos FROM Form4marksreportprocess";
	
	final String SQL_chem_average = "SELECT regno,chem,RANK() OVER (ORDER BY chem DESC) AS chem_pos FROM Form4marksreportprocess";	
	
	final String SQL_phy_average = "SELECT regno,phy,RANK() OVER (ORDER BY phy DESC) AS phy_pos FROM Form4marksreportprocess";	
	
	final String SQL_geo_average = "SELECT regno,geo,RANK() OVER (ORDER BY geo DESC) AS geo_pos FROM Form4marksreportprocess";	
	
	final String SQL_his_average = "SELECT regno,his,RANK() OVER (ORDER BY his DESC) AS his_pos FROM Form4marksreportprocess";	
	
	final String SQL_cre_average = "SELECT regno,cre,RANK() OVER (ORDER BY cre DESC) AS cre_pos FROM Form4marksreportprocess";	
	
	final String SQL_agric_average = "SELECT regno,agric,RANK() OVER (ORDER BY agric DESC) AS agric_pos FROM Form4marksreportprocess";	
	
	final String SQL_biz_average = "SELECT regno,biz,RANK() OVER (ORDER BY biz DESC) AS biz_pos FROM Form4marksreportprocess";	
	
	final String SQL_comp_average = "SELECT regno,comp,RANK() OVER (ORDER BY comp DESC) AS comp_pos FROM Form4marksreportprocess";	
	
	final String SQL_hom_average = "SELECT regno,hom,RANK() OVER (ORDER BY hom DESC) AS hom_pos FROM Form4marksreportprocess";
	
	final  String SQL_SELECT_EXAM_ONE = "SELECT * from Form4basebackup where regno = :regno AND term = :term AND year = :year AND examtype = 'EXAM1' ";
	 
	final  String SQL_SELECT_EXAM_TWO = "SELECT * from Form4basebackup where regno = :regno AND term = :term AND year = :year AND examtype = 'EXAM2' ";
	
	 final  String SQL_SELECT_EXAM_THREE = "SELECT * from Form4basebackup where regno = :regno AND term = :term AND year = :year AND examtype = 'EXAM3' ";
	 
	 final  String SQL_SELECT_EXAM_ = "SELECT * from Form4marksbackup where regno = :regno AND term = :term AND year = :year";
	 
	 final  String SQL_SELECT_TERM_ONE = "SELECT * from Form4marksbackup where regno = :regno AND term = '1' ";
	 
	 final String SQL_SELECT_TERM_TWO = "SELECT * from Form4marksbackup where regno = :regno AND term = '2' ";
	 
	 final String SQL_SELECT_TERM_THREE = "SELECT * from Form4marksbackup where regno = :regno AND term = '3' ";
	 

	final String SQL_SELECT_MARKCHIT = "SELECT student.regno,student.stream,student.fname,student.subno,student.kcpemarks,student.kcpemean,student.kcpegrade,Form4basebackup.* FROM student, Form4basebackup WHERE student.regno = Form4basebackup.regno AND Form4basebackup.term = :term AND Form4basebackup.year = :year AND Form4basebackup.examtype = :examtype ORDER BY tt DESC";
		
	final String SQL_SUB_ANALYSIS = "SELECT SUM(CASE WHEN eng_grade  = 'A' THEN 1 ELSE 0 END) AS eng_aplain, SUM(CASE WHEN eng_grade  = 'A-' THEN 1 ELSE 0 END) AS eng_aminus,SUM(CASE WHEN eng_grade  = 'B+' THEN 1 ELSE 0 END) AS eng_bplus,SUM(CASE WHEN eng_grade  = 'B' THEN 1 ELSE 0 END) AS eng_bplain,SUM(CASE WHEN eng_grade  = 'B-' THEN 1 ELSE 0 END) AS eng_bminus,SUM(CASE WHEN eng_grade  = 'C+' THEN 1 ELSE 0 END) AS eng_cplus,SUM(CASE WHEN eng_grade  = 'C' THEN 1 ELSE 0 END) AS eng_cplain,SUM( CASE WHEN eng_grade  = 'C-' THEN 1 ELSE 0 END) AS eng_cminus,SUM( CASE WHEN eng_grade  = 'D+' THEN 1 ELSE 0 END) AS eng_dplus,SUM( CASE WHEN eng_grade  = 'D' THEN 1 ELSE 0 END) AS eng_dplain,SUM( CASE WHEN eng_grade  = 'D-' THEN 1 ELSE 0 END) AS eng_dminus,SUM( CASE WHEN eng_grade  = 'E' THEN 1 ELSE 0 END) AS eng_eplain,(SUM( CASE WHEN eng_grade  = 'A' THEN 1 ELSE 0 END) + SUM( CASE WHEN eng_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN eng_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN eng_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN eng_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN eng_grade  = 'E' THEN 1 ELSE 0 END ))AS eng_Entry,SUM(eng) AS eng_av,\r\n" + 
			"SUM(CASE WHEN kis_grade  = 'A' THEN 1 ELSE 0 END) AS kis_aplain, SUM(CASE WHEN kis_grade  = 'A-' THEN 1 ELSE 0 END) AS kis_aminus,SUM(CASE WHEN kis_grade  = 'B+' THEN 1 ELSE 0 END) AS kis_bplus,SUM(CASE WHEN kis_grade  = 'B' THEN 1 ELSE 0 END) AS kis_bplain,SUM(CASE WHEN kis_grade  = 'B-' THEN 1 ELSE 0 END) AS kis_bminus,SUM(CASE WHEN kis_grade  = 'C+' THEN 1 ELSE 0 END) AS kis_cplus,SUM(CASE WHEN kis_grade  = 'C' THEN 1 ELSE 0 END) AS kis_cplain,SUM( CASE WHEN kis_grade  = 'C-' THEN 1 ELSE 0 END) AS kis_cminus,SUM( CASE WHEN kis_grade  = 'D+' THEN 1 ELSE 0 END) AS kis_dplus,SUM( CASE WHEN kis_grade  = 'D' THEN 1 ELSE 0 END) AS kis_dplain,SUM( CASE WHEN kis_grade  = 'D-' THEN 1 ELSE 0 END) AS kis_dminus,SUM( CASE WHEN kis_grade  = 'E' THEN 1 ELSE 0 END) AS kis_eplain,(SUM( CASE WHEN kis_grade  = 'A' THEN 1 ELSE 0 END) + SUM( CASE WHEN kis_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN kis_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN kis_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN kis_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN kis_grade  = 'E' THEN 1 ELSE 0 END ))AS kis_entry,SUM(kis) AS kis_av,\r\n" + 
			"SUM(CASE WHEN math_grade  = 'A' THEN 1 ELSE 0 END) AS math_aplain, SUM(CASE WHEN math_grade  = 'A-' THEN 1 ELSE 0 END) AS math_aminus,SUM(CASE WHEN math_grade  = 'B+' THEN 1 ELSE 0 END) AS math_bplus,SUM(CASE WHEN math_grade  = 'B' THEN 1 ELSE 0 END) AS math_bplain,SUM(CASE WHEN math_grade  = 'B-' THEN 1 ELSE 0 END) AS math_bminus,SUM(CASE WHEN math_grade  = 'C+' THEN 1 ELSE 0 END) AS math_cplus,SUM(CASE WHEN math_grade  = 'C' THEN 1 ELSE 0 END) AS math_cplain,SUM( CASE WHEN math_grade  = 'C-' THEN 1 ELSE 0 END) AS math_cminus,SUM( CASE WHEN math_grade  = 'D+' THEN 1 ELSE 0 END) AS math_dplus,SUM( CASE WHEN math_grade  = 'D' THEN 1 ELSE 0 END) AS math_dplain,SUM( CASE WHEN math_grade  = 'D-' THEN 1 ELSE 0 END) AS math_dminus,SUM( CASE WHEN math_grade  = 'E' THEN 1 ELSE 0 END) AS math_eplain,(SUM( CASE WHEN math_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN math_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN math_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN math_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN math_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN math_grade  = 'E' THEN 1 ELSE 0 END ))AS math_entry,SUM(math) AS math_av,\r\n" + 
			"SUM(CASE WHEN bio_grade  = 'A' THEN 1 ELSE 0 END) AS bio_aplain, SUM(CASE WHEN bio_grade  = 'A-' THEN 1 ELSE 0 END) AS bio_aminus,SUM(CASE WHEN bio_grade  = 'B+' THEN 1 ELSE 0 END) AS bio_bplus,SUM(CASE WHEN bio_grade  = 'B' THEN 1 ELSE 0 END) AS bio_bplain,SUM(CASE WHEN bio_grade  = 'B-' THEN 1 ELSE 0 END) AS bio_bminus,SUM(CASE WHEN bio_grade  = 'C+' THEN 1 ELSE 0 END) AS bio_cplus,SUM(CASE WHEN bio_grade  = 'C' THEN 1 ELSE 0 END) AS bio_cplain,SUM( CASE WHEN bio_grade  = 'C-' THEN 1 ELSE 0 END) AS bio_cminus,SUM( CASE WHEN bio_grade  = 'D+' THEN 1 ELSE 0 END) AS bio_dplus,SUM( CASE WHEN bio_grade  = 'D' THEN 1 ELSE 0 END) AS bio_dplain,SUM( CASE WHEN bio_grade  = 'D-' THEN 1 ELSE 0 END) AS bio_dminus,SUM( CASE WHEN bio_grade  = 'E' THEN 1 ELSE 0 END) AS bio_eplain,(SUM( CASE WHEN bio_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN bio_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN bio_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN bio_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN bio_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN bio_grade  = 'E' THEN 1 ELSE 0 END ))AS bio_entry,SUM(bio) AS bio_av,\r\n" + 
			"SUM(CASE WHEN chem_grade  = 'A' THEN 1 ELSE 0 END) AS chem_aplain, SUM(CASE WHEN chem_grade  = 'A-' THEN 1 ELSE 0 END) AS chem_aminus,SUM(CASE WHEN chem_grade  = 'B+' THEN 1 ELSE 0 END) AS chem_bplus,SUM(CASE WHEN chem_grade  = 'B' THEN 1 ELSE 0 END) AS chem_bplain,SUM(CASE WHEN chem_grade  = 'B-' THEN 1 ELSE 0 END) AS chem_bminus,SUM(CASE WHEN chem_grade  = 'C+' THEN 1 ELSE 0 END) AS chem_cplus,SUM(CASE WHEN chem_grade  = 'C' THEN 1 ELSE 0 END) AS chem_cplain,SUM( CASE WHEN chem_grade  = 'C-' THEN 1 ELSE 0 END) AS chem_cminus,SUM( CASE WHEN chem_grade  = 'D+' THEN 1 ELSE 0 END) AS chem_dplus,SUM( CASE WHEN chem_grade  = 'D' THEN 1 ELSE 0 END) AS chem_dplain,SUM( CASE WHEN chem_grade  = 'D-' THEN 1 ELSE 0 END) AS chem_dminus,SUM( CASE WHEN chem_grade  = 'E' THEN 1 ELSE 0 END) AS chem_eplain,(SUM( CASE WHEN chem_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN chem_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN chem_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN chem_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN chem_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN chem_grade  = 'E' THEN 1 ELSE 0 END ))AS chem_entry,SUM(chem) AS chem_av,\r\n" + 
			"SUM(CASE WHEN phy_grade  = 'A' THEN 1 ELSE 0 END) AS phy_aplain, SUM(CASE WHEN phy_grade  = 'A-' THEN 1 ELSE 0 END) AS phy_aminus,SUM(CASE WHEN phy_grade  = 'B+' THEN 1 ELSE 0 END) AS phy_bplus,SUM(CASE WHEN phy_grade  = 'B' THEN 1 ELSE 0 END) AS phy_bplain,SUM(CASE WHEN phy_grade  = 'B-' THEN 1 ELSE 0 END) AS phy_bminus,SUM(CASE WHEN phy_grade  = 'C+' THEN 1 ELSE 0 END) AS phy_cplus,SUM(CASE WHEN phy_grade  = 'C' THEN 1 ELSE 0 END) AS phy_cplain,SUM( CASE WHEN phy_grade  = 'C-' THEN 1 ELSE 0 END) AS phy_cminus,SUM( CASE WHEN phy_grade  = 'D+' THEN 1 ELSE 0 END) AS phy_dplus,SUM( CASE WHEN phy_grade  = 'D' THEN 1 ELSE 0 END) AS phy_dplain,SUM( CASE WHEN phy_grade  = 'D-' THEN 1 ELSE 0 END) AS phy_dminus,SUM( CASE WHEN phy_grade  = 'E' THEN 1 ELSE 0 END) AS phy_eplain,(SUM( CASE WHEN phy_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN phy_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN phy_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN phy_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN phy_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN phy_grade  = 'E' THEN 1 ELSE 0 END ))AS phy_entry,SUM(phy) AS phy_av,\r\n" + 
			"SUM(CASE WHEN geo_grade  = 'A' THEN 1 ELSE 0 END) AS geo_aplain, SUM(CASE WHEN geo_grade  = 'A-' THEN 1 ELSE 0 END) AS geo_aminus,SUM(CASE WHEN geo_grade  = 'B+' THEN 1 ELSE 0 END) AS geo_bplus,SUM(CASE WHEN geo_grade  = 'B' THEN 1 ELSE 0 END) AS geo_bplain,SUM(CASE WHEN geo_grade  = 'B-' THEN 1 ELSE 0 END) AS geo_bminus,SUM(CASE WHEN geo_grade  = 'C+' THEN 1 ELSE 0 END) AS geo_cplus,SUM(CASE WHEN geo_grade  = 'C' THEN 1 ELSE 0 END) AS geo_cplain,SUM( CASE WHEN geo_grade  = 'C-' THEN 1 ELSE 0 END) AS geo_cminus,SUM( CASE WHEN geo_grade  = 'D+' THEN 1 ELSE 0 END) AS geo_dplus,SUM( CASE WHEN geo_grade  = 'D' THEN 1 ELSE 0 END) AS geo_dplain,SUM( CASE WHEN geo_grade  = 'D-' THEN 1 ELSE 0 END) AS geo_dminus,SUM( CASE WHEN geo_grade  = 'E' THEN 1 ELSE 0 END) AS geo_eplain,(SUM( CASE WHEN geo_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN geo_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN geo_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN geo_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN geo_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN geo_grade  = 'E' THEN 1 ELSE 0 END ))AS geo_entry,SUM(geo) AS geo_av,\r\n" + 
			"SUM(CASE WHEN his_grade  = 'A' THEN 1 ELSE 0 END) AS his_aplain, SUM(CASE WHEN his_grade  = 'A-' THEN 1 ELSE 0 END) AS his_aminus,SUM(CASE WHEN his_grade  = 'B+' THEN 1 ELSE 0 END) AS his_bplus,SUM(CASE WHEN his_grade  = 'B' THEN 1 ELSE 0 END) AS his_bplain,SUM(CASE WHEN his_grade  = 'B-' THEN 1 ELSE 0 END) AS his_bminus,SUM(CASE WHEN his_grade  = 'C+' THEN 1 ELSE 0 END) AS his_cplus,SUM(CASE WHEN his_grade  = 'C' THEN 1 ELSE 0 END) AS his_cplain,SUM( CASE WHEN his_grade  = 'C-' THEN 1 ELSE 0 END) AS his_cminus,SUM( CASE WHEN his_grade  = 'D+' THEN 1 ELSE 0 END) AS his_dplus,SUM( CASE WHEN his_grade  = 'D' THEN 1 ELSE 0 END) AS his_dplain,SUM( CASE WHEN his_grade  = 'D-' THEN 1 ELSE 0 END) AS his_dminus,SUM( CASE WHEN his_grade  = 'E' THEN 1 ELSE 0 END) AS his_eplain,(SUM( CASE WHEN his_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN his_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN his_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN his_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN his_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN his_grade  = 'E' THEN 1 ELSE 0 END ))AS his_entry,SUM(his) AS his_av,\r\n" + 
			"SUM(CASE WHEN cre_grade  = 'A' THEN 1 ELSE 0 END) AS cre_aplain, SUM(CASE WHEN cre_grade  = 'A-' THEN 1 ELSE 0 END) AS cre_aminus,SUM(CASE WHEN cre_grade  = 'B+' THEN 1 ELSE 0 END) AS cre_bplus,SUM(CASE WHEN cre_grade  = 'B' THEN 1 ELSE 0 END) AS cre_bplain,SUM(CASE WHEN cre_grade  = 'B-' THEN 1 ELSE 0 END) AS cre_bminus,SUM(CASE WHEN cre_grade  = 'C+' THEN 1 ELSE 0 END) AS cre_cplus,SUM(CASE WHEN cre_grade  = 'C' THEN 1 ELSE 0 END) AS cre_cplain,SUM( CASE WHEN cre_grade  = 'C-' THEN 1 ELSE 0 END) AS cre_cminus,SUM( CASE WHEN cre_grade  = 'D+' THEN 1 ELSE 0 END) AS cre_dplus,SUM( CASE WHEN cre_grade  = 'D' THEN 1 ELSE 0 END) AS cre_dplain,SUM( CASE WHEN cre_grade  = 'D-' THEN 1 ELSE 0 END) AS cre_dminus,SUM( CASE WHEN cre_grade  = 'E' THEN 1 ELSE 0 END) AS cre_eplain,(SUM( CASE WHEN cre_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN cre_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN cre_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN cre_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN cre_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN cre_grade  = 'E' THEN 1 ELSE 0 END ))AS cre_entry,SUM(cre) AS cre_av,\r\n" + 
			"SUM(CASE WHEN agric_grade  = 'A' THEN 1 ELSE 0 END) AS agric_aplain, SUM(CASE WHEN agric_grade  = 'A-' THEN 1 ELSE 0 END) AS agric_aminus,SUM(CASE WHEN agric_grade  = 'B+' THEN 1 ELSE 0 END) AS agric_bplus,SUM(CASE WHEN agric_grade  = 'B' THEN 1 ELSE 0 END) AS agric_bplain,SUM(CASE WHEN agric_grade  = 'B-' THEN 1 ELSE 0 END) AS agric_bminus,SUM(CASE WHEN agric_grade  = 'C+' THEN 1 ELSE 0 END) AS agric_cplus,SUM(CASE WHEN agric_grade  = 'C' THEN 1 ELSE 0 END) AS agric_cplain,SUM( CASE WHEN agric_grade  = 'C-' THEN 1 ELSE 0 END) AS agric_cminus,SUM( CASE WHEN agric_grade  = 'D+' THEN 1 ELSE 0 END) AS agric_dplus,SUM( CASE WHEN agric_grade  = 'D' THEN 1 ELSE 0 END) AS agric_dplain,SUM( CASE WHEN agric_grade  = 'D-' THEN 1 ELSE 0 END) AS agric_dminus,SUM( CASE WHEN agric_grade  = 'E' THEN 1 ELSE 0 END) AS agric_eplain,(SUM( CASE WHEN agric_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN agric_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN agric_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN agric_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN agric_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN agric_grade  = 'E' THEN 1 ELSE 0 END ))AS agric_entry,SUM(agric) AS agric_av,\r\n" + 
			"SUM(CASE WHEN biz_grade  = 'A' THEN 1 ELSE 0 END) AS biz_aplain, SUM(CASE WHEN biz_grade  = 'A-' THEN 1 ELSE 0 END) AS biz_aminus,SUM(CASE WHEN biz_grade  = 'B+' THEN 1 ELSE 0 END) AS biz_bplus,SUM(CASE WHEN biz_grade  = 'B' THEN 1 ELSE 0 END) AS biz_bplain,SUM(CASE WHEN biz_grade  = 'B-' THEN 1 ELSE 0 END) AS biz_bminus,SUM(CASE WHEN biz_grade  = 'C+' THEN 1 ELSE 0 END) AS biz_cplus,SUM(CASE WHEN biz_grade  = 'C' THEN 1 ELSE 0 END) AS biz_cplain,SUM( CASE WHEN biz_grade  = 'C-' THEN 1 ELSE 0 END) AS biz_cminus,SUM( CASE WHEN biz_grade  = 'D+' THEN 1 ELSE 0 END) AS biz_dplus,SUM( CASE WHEN biz_grade  = 'D' THEN 1 ELSE 0 END) AS biz_dplain,SUM( CASE WHEN biz_grade  = 'D-' THEN 1 ELSE 0 END) AS biz_dminus,SUM( CASE WHEN biz_grade  = 'E' THEN 1 ELSE 0 END) AS biz_eplain,(SUM( CASE WHEN biz_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN biz_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN biz_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN biz_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN biz_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN biz_grade  = 'E' THEN 1 ELSE 0 END ))AS biz_entry,SUM(biz) AS biz_av,\r\n" + 
			"SUM(CASE WHEN comp_grade  = 'A' THEN 1 ELSE 0 END) AS comp_aplain, SUM(CASE WHEN comp_grade  = 'A-' THEN 1 ELSE 0 END) AS comp_aminus,SUM(CASE WHEN comp_grade  = 'B+' THEN 1 ELSE 0 END) AS comp_bplus,SUM(CASE WHEN comp_grade  = 'B' THEN 1 ELSE 0 END) AS comp_bplain,SUM(CASE WHEN comp_grade  = 'B-' THEN 1 ELSE 0 END) AS comp_bminus,SUM(CASE WHEN comp_grade  = 'C+' THEN 1 ELSE 0 END) AS comp_cplus,SUM(CASE WHEN comp_grade  = 'C' THEN 1 ELSE 0 END) AS comp_cplain,SUM( CASE WHEN comp_grade  = 'C-' THEN 1 ELSE 0 END) AS comp_cminus,SUM( CASE WHEN comp_grade  = 'D+' THEN 1 ELSE 0 END) AS comp_dplus,SUM( CASE WHEN comp_grade  = 'D' THEN 1 ELSE 0 END) AS comp_dplain,SUM( CASE WHEN comp_grade  = 'D-' THEN 1 ELSE 0 END) AS comp_dminus,SUM( CASE WHEN comp_grade  = 'E' THEN 1 ELSE 0 END) AS comp_eplain,(SUM( CASE WHEN comp_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN comp_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN comp_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN comp_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN comp_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN comp_grade  = 'E' THEN 1 ELSE 0 END ))AS comp_entry,SUM(comp) AS comp_av,\r\n" + 
			"SUM(CASE WHEN hom_grade  = 'A' THEN 1 ELSE 0 END) AS hom_aplain, SUM(CASE WHEN hom_grade  = 'A-' THEN 1 ELSE 0 END) AS hom_aminus,SUM(CASE WHEN hom_grade  = 'B+' THEN 1 ELSE 0 END) AS hom_bplus,SUM(CASE WHEN hom_grade  = 'B' THEN 1 ELSE 0 END) AS hom_bplain,SUM(CASE WHEN hom_grade  = 'B-' THEN 1 ELSE 0 END) AS hom_bminus,SUM(CASE WHEN hom_grade  = 'C+' THEN 1 ELSE 0 END) AS hom_cplus,SUM(CASE WHEN hom_grade  = 'C' THEN 1 ELSE 0 END) AS hom_cplain,SUM( CASE WHEN hom_grade  = 'C-' THEN 1 ELSE 0 END) AS hom_cminus,SUM( CASE WHEN hom_grade  = 'D+' THEN 1 ELSE 0 END) AS hom_dplus,SUM( CASE WHEN hom_grade  = 'D' THEN 1 ELSE 0 END) AS hom_dplain,SUM( CASE WHEN hom_grade  = 'D-' THEN 1 ELSE 0 END) AS hom_dminus,SUM( CASE WHEN hom_grade  = 'E' THEN 1 ELSE 0 END) AS hom_eplain,(SUM( CASE WHEN hom_grade  = 'A' THEN 1 ELSE 0 END) +       SUM( CASE WHEN hom_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN hom_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN hom_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN hom_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN hom_grade  = 'E' THEN 1 ELSE 0 END ))AS hom_entry,SUM(hom) AS hom_av \r\n" + 
			"FROM Form4basebackup WHERE term = :term AND year = :year AND examtype = :examtype ";
	
	final String SQL_STREAM_ANALYSIS = "SELECT stream,SUM(CASE WHEN ov_pnts_grade  = 'A' THEN 1 ELSE 0 END) AS aplain, SUM(CASE WHEN ov_pnts_grade  = 'A-' THEN 1 ELSE 0 END) AS aminus,SUM(CASE WHEN ov_pnts_grade  = 'B+' THEN 1 ELSE 0 END) AS bplus,SUM(CASE WHEN ov_pnts_grade  = 'B' THEN 1 ELSE 0 END) AS bplain,SUM(CASE WHEN ov_pnts_grade  = 'B-' THEN 1 ELSE 0 END) AS bminus,SUM(CASE WHEN ov_pnts_grade  = 'C+' THEN 1 ELSE 0 END) AS cplus,SUM(CASE WHEN ov_pnts_grade  = 'C' THEN 1 ELSE 0 END) AS cplain,SUM( CASE WHEN ov_pnts_grade  = 'C-' THEN 1 ELSE 0 END) AS cminus,SUM( CASE WHEN ov_pnts_grade  = 'D+' THEN 1 ELSE 0 END) AS dplus,SUM( CASE WHEN ov_pnts_grade  = 'D' THEN 1 ELSE 0 END) AS dplain,SUM( CASE WHEN ov_pnts_grade  = 'D-' THEN 1 ELSE 0 END) AS dminus,SUM( CASE WHEN ov_pnts_grade  = 'E' THEN 1 ELSE 0 END) AS eplain,(SUM( CASE WHEN ov_pnts_grade  = 'A' THEN 1 ELSE 0 END) + SUM( CASE WHEN ov_pnts_grade  = 'A-' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'B+' THEN 1 ELSE 0 END) +	SUM( CASE WHEN ov_pnts_grade  = 'B' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'B-' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'C+' THEN 1 ELSE 0 END) + SUM( CASE WHEN ov_pnts_grade  = 'C' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'C-' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'D+' THEN 1 ELSE 0 END) +SUM(CASE WHEN ov_pnts_grade  = 'D' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'D-' THEN 1 ELSE 0 END) +SUM( CASE WHEN ov_pnts_grade  = 'E' THEN 1 ELSE 0 END ))AS entry,(SUM(COALESCE(CAST(tt AS DOUBLE PRECISION),0))) AS  tt_marks FROM Form4basebackup WHERE term = :term AND year = :year AND examtype = :examtype GROUP BY stream";
	final String SQL_DEV_ = "SELECT id,regno,COALESCE(tt,0) AS tt,tt - lag(tt) OVER (ORDER BY id) as deviation FROM Form4marksbackup WHERE regno = :regno ORDER BY id DESC LIMIT 1";
	@Override
	public int[] sub_rank_average(List<Form4marksreportprocess> subrankAvg) {		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,eng_pos = :eng_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}	
	@Override
	public List<Form4marksreportprocess> sub_rank_ave() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_RANK_average, new RowMapper<Form4marksreportprocess>() {
			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess eng_rank = new Form4marksreportprocess();					
				eng_rank.setRegno(rs.getLong("regno"));
				eng_rank.setEng_pos(rs.getString("eng_pos"));
				return eng_rank;
			}
		});
		return list;
	}
	// kis
	@Override
	public int[] sub_rank_kis(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());  
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,kis_pos = :kis_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_kis() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_kis_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess kis_rank = new Form4marksreportprocess();					
				kis_rank.setRegno(rs.getLong("regno"));
				kis_rank.setKis_pos(rs.getString("kis_pos"));
				return kis_rank;
			}
		});
		return list;
	}
	// mathematics
	@Override
	public int[] sub_rank_math(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,math_pos = :math_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_math() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_math_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess math_rank = new Form4marksreportprocess();					
				math_rank.setRegno(rs.getLong("regno"));
				math_rank.setMath_pos(rs.getString("math_pos"));
				return math_rank;
			}
		});
		return list;
	}
	// biology
	@Override
	public int[] sub_rank_bio(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,bio_pos = :bio_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_bio() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_bio_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess bio_rank = new Form4marksreportprocess();					
				bio_rank.setRegno(rs.getLong("regno"));
				bio_rank.setBio_pos(rs.getString("bio_pos"));
				return bio_rank;
			}
		});
		return list;
	}
	//chem
	@Override
	public int[] sub_rank_chem(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,chem_pos = :chem_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_chem() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_chem_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess chem_rank = new Form4marksreportprocess();					
				chem_rank.setRegno(rs.getLong("regno"));
				chem_rank.setChem_pos(rs.getString("chem_pos"));
				return chem_rank;
			}
		});
		return list;
	}
	//phy
	@Override
	public int[] sub_rank_phy(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,phy_pos = :phy_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_phy() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_phy_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess phy_rank = new Form4marksreportprocess();					
				phy_rank.setRegno(rs.getLong("regno"));
				phy_rank.setPhy_pos(rs.getString("phy_pos"));
				return phy_rank;
			}
		});
		return list;
	}
	//geo
	@Override
	public int[] sub_rank_geo(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,geo_pos = :geo_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_geo() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_geo_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess geo_rank = new Form4marksreportprocess();					
				geo_rank.setRegno(rs.getLong("regno"));
				geo_rank.setGeo_pos(rs.getString("geo_pos"));
				return geo_rank;
			}
		});
		return list;
	}
	//history
	@Override
	public int[] sub_rank_his(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,his_pos = :his_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_his() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_his_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess his_rank = new Form4marksreportprocess();					
				his_rank.setRegno(rs.getLong("regno"));
				his_rank.setHis_pos(rs.getString("his_pos"));
				return his_rank;
			}
		});
		return list;
	}
	//cre
	@Override
	public int[] sub_rank_cre(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,cre_pos = :cre_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_cre() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_cre_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess cre_rank = new Form4marksreportprocess();					
				cre_rank.setRegno(rs.getLong("regno"));
				cre_rank.setCre_pos(rs.getString("cre_pos"));
				return cre_rank;
			}
		});
		return list;
	}
	//agric
	@Override
	public int[] sub_rank_agric(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,agric_pos = :agric_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_agric() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_agric_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess agric_rank = new Form4marksreportprocess();					
				agric_rank.setRegno(rs.getLong("regno"));
				agric_rank.setAgric_pos(rs.getString("agric_pos"));
				return agric_rank;
			}
		});
		return list;
	}
	// business
	@Override
	public int[] sub_rank_biz(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,biz_pos = :biz_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_biz() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_biz_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess biz_rank = new Form4marksreportprocess();					
				biz_rank.setRegno(rs.getLong("regno"));
				biz_rank.setBiz_pos(rs.getString("biz_pos"));
				return biz_rank;
			}
		});
		return list;
	}
	//computer
	@Override
	public int[] sub_rank_comp(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,comp_pos = :comp_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_comp() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_comp_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess comp_rank = new Form4marksreportprocess();					
				comp_rank.setRegno(rs.getLong("regno"));
				comp_rank.setComp_pos(rs.getString("comp_pos"));
				return comp_rank;
			}
		});
		return list;
	}
	//homescience
	@Override
	public int[] sub_rank_hom(List<Form4marksreportprocess> subrankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(subrankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set regno = :regno,hom_pos = :hom_pos where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> sub_rank_hom() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_hom_average, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess hom_rank = new Form4marksreportprocess();					
				hom_rank.setRegno(rs.getLong("regno"));
				hom_rank.setHom_pos(rs.getString("hom_pos"));
				return hom_rank;
			}
		});
		return list;
	}
	@Override
	public  List<Form4basebackup> selectAll_ExamOne(Long adno, String term, String year) {
		List<Form4basebackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_EXAM_ONE, new MapSqlParameterSource().addValue("regno", adno).addValue("term", term).addValue("year", year), new RowMapper<Form4basebackup>() {
			
			@Override
			public Form4basebackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4basebackup s_all = new Form4basebackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setForm(rs.getString("form"));
				s_all.setTerm(rs.getString("term"));
				s_all.setExamtype(rs.getString("examtype"));
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setEng_grade(rs.getString("eng_grade"));
				s_all.setMath(rs.getLong("math"));
				s_all.setMath_grade(rs.getString("math_grade"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setKis_grade(rs.getString("kis_grade"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setBio_grade(rs.getString("bio_grade"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setChem_grade(rs.getString("chem_grade"));
				s_all.setPhy(rs.getLong("phy"));
				s_all.setPhy_grade(rs.getString("phy_grade"));
				s_all.setGeo(rs.getLong("geo"));
				s_all.setGeo_grade(rs.getString("geo_grade"));
				s_all.setHis(rs.getLong("his"));
				s_all.setHis_grade(rs.getString("his_grade"));
				s_all.setCre(rs.getLong("cre"));
				s_all.setCre_grade(rs.getString("cre_grade"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setAgric_grade(rs.getString("agric_grade"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setBiz_grade(rs.getString("biz_grade"));
				s_all.setHom(rs.getLong("hom"));
				s_all.setHom_grade(rs.getString("hom_grade"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setComp_grade(rs.getString("comp_grade"));
				s_all.setAvg(rs.getLong("avg"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setOv_pnts(rs.getLong("ov_pnts"));
				s_all.setRank(rs.getString("rank"));
				s_all.setCrank(rs.getString("crank"));
				
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public  List<Form4basebackup> selectAll_ExamTwo(Long adno, String term, String year) {
		List<Form4basebackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_EXAM_TWO, new MapSqlParameterSource().addValue("regno", adno).addValue("term", term).addValue("year", year), new RowMapper<Form4basebackup>() {
			
			@Override
			public Form4basebackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4basebackup s_all = new Form4basebackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setForm(rs.getString("form"));
				s_all.setTerm(rs.getString("term"));
				s_all.setExamtype(rs.getString("examtype"));
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setEng_grade(rs.getString("eng_grade"));
				s_all.setMath(rs.getLong("math"));
				s_all.setMath_grade(rs.getString("math_grade"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setKis_grade(rs.getString("kis_grade"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setBio_grade(rs.getString("bio_grade"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setChem_grade(rs.getString("chem_grade"));
				s_all.setPhy(rs.getLong("phy"));
				s_all.setPhy_grade(rs.getString("phy_grade"));
				s_all.setGeo(rs.getLong("geo"));
				s_all.setGeo_grade(rs.getString("geo_grade"));
				s_all.setHis(rs.getLong("his"));
				s_all.setHis_grade(rs.getString("his_grade"));
				s_all.setCre(rs.getLong("cre"));
				s_all.setCre_grade(rs.getString("cre_grade"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setAgric_grade(rs.getString("agric_grade"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setBiz_grade(rs.getString("biz_grade"));
				s_all.setHom(rs.getLong("hom"));
				s_all.setHom_grade(rs.getString("hom_grade"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setComp_grade(rs.getString("comp_grade"));
				s_all.setAvg(rs.getLong("avg"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setOv_pnts(rs.getLong("ov_pnts"));
				s_all.setRank(rs.getString("rank"));
				s_all.setCrank(rs.getString("crank"));
				return s_all;
			}
			
		});
		return list;
	}
	
	@Override
	public  List<Form4basebackup> selectAll_ExamThree(Long adno, String term, String year) {
		List<Form4basebackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_EXAM_THREE, new MapSqlParameterSource().addValue("regno", adno).addValue("term", term).addValue("year", year), new RowMapper<Form4basebackup>() {
			
			@Override
			public Form4basebackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4basebackup s_all = new Form4basebackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setForm(rs.getString("form"));
				s_all.setTerm(rs.getString("term"));
				s_all.setExamtype(rs.getString("examtype"));
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setEng_grade(rs.getString("eng_grade"));
				s_all.setMath(rs.getLong("math"));
				s_all.setMath_grade(rs.getString("math_grade"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setKis_grade(rs.getString("kis_grade"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setBio_grade(rs.getString("bio_grade"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setChem_grade(rs.getString("chem_grade"));
				s_all.setPhy(rs.getLong("phy"));
				s_all.setPhy_grade(rs.getString("phy_grade"));
				s_all.setGeo(rs.getLong("geo"));
				s_all.setGeo_grade(rs.getString("geo_grade"));
				s_all.setHis(rs.getLong("his"));
				s_all.setHis_grade(rs.getString("his_grade"));
				s_all.setCre(rs.getLong("cre"));
				s_all.setCre_grade(rs.getString("cre_grade"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setAgric_grade(rs.getString("agric_grade"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setBiz_grade(rs.getString("biz_grade"));
				s_all.setHom(rs.getLong("hom"));
				s_all.setHom_grade(rs.getString("hom_grade"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setComp_grade(rs.getString("comp_grade"));
				s_all.setAvg(rs.getLong("avg"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setOv_pnts(rs.getLong("ov_pnts"));
				s_all.setRank(rs.getString("rank"));
				s_all.setCrank(rs.getString("crank"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public  List<Form4marksbackup> selectAll_Exam(Long adno, String term, String year) {
		List<Form4marksbackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_EXAM_, new MapSqlParameterSource().addValue("regno", adno).addValue("term", term).addValue("year", year), new RowMapper<Form4marksbackup>() {
			
			@Override
			public Form4marksbackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksbackup s_all = new Form4marksbackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setForm(rs.getString("form"));
				s_all.setTerm(rs.getString("term"));
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setEng_grade(rs.getString("eng_grade"));
				s_all.setEng_pnts(rs.getLong("eng_pnts"));
				s_all.setEng_pos(rs.getString("eng_pos"));
				s_all.setEng_remarks(rs.getString("eng_remarks"));
				
				s_all.setMath(rs.getLong("math"));
				s_all.setMath_grade(rs.getString("math_grade"));				
				s_all.setMath_pnts(rs.getLong("math_pnts"));
				s_all.setMath_pos(rs.getString("math_pos"));
				s_all.setMath_remarks(rs.getString("math_remarks"));
								
				s_all.setKis(rs.getLong("kis"));
				s_all.setKis_grade(rs.getString("kis_grade"));				
				s_all.setKis_pnts(rs.getLong("kis_pnts"));
				s_all.setKis_pos(rs.getString("kis_pos"));
				s_all.setKis_remarks(rs.getString("kis_remarks"));
				
				s_all.setBio(rs.getLong("bio"));
				s_all.setBio_grade(rs.getString("bio_grade"));				
				s_all.setBio_pnts(rs.getLong("bio_pnts"));
				s_all.setBio_pos(rs.getString("bio_pos"));
				s_all.setBio_remarks(rs.getString("bio_remarks"));
				
				s_all.setChem(rs.getLong("chem"));
				s_all.setChem_grade(rs.getString("chem_grade"));				
				s_all.setChem_pnts(rs.getLong("chem_pnts"));
				s_all.setChem_pos(rs.getString("chem_pos"));
				s_all.setChem_remarks(rs.getString("chem_remarks"));
				
				s_all.setPhy(rs.getLong("phy"));
				s_all.setPhy_grade(rs.getString("phy_grade"));				
				s_all.setPhy_pnts(rs.getLong("phy_pnts"));
				s_all.setPhy_pos(rs.getString("phy_pos"));
				s_all.setPhy_remarks(rs.getString("phy_remarks"));
				
				s_all.setGeo(rs.getLong("geo"));
				s_all.setGeo_grade(rs.getString("geo_grade"));				
				s_all.setGeo_pnts(rs.getLong("geo_pnts"));
				s_all.setGeo_pos(rs.getString("geo_pos"));
				s_all.setGeo_remarks(rs.getString("geo_remarks"));
				
				s_all.setHis(rs.getLong("his"));				
				s_all.setHis_grade(rs.getString("his_grade"));				
				s_all.setHis_pnts(rs.getLong("his_pnts"));
				s_all.setHis_pos(rs.getString("his_pos"));
				s_all.setHis_remarks(rs.getString("his_remarks"));
				
				s_all.setCre(rs.getLong("cre"));
				s_all.setCre_grade(rs.getString("cre_grade"));				
				s_all.setCre_pnts(rs.getLong("cre_pnts"));
				s_all.setCre_pos(rs.getString("cre_pos"));
				s_all.setCre_remarks(rs.getString("cre_remarks"));
				
				s_all.setAgric(rs.getLong("agric"));				
				s_all.setAgric_grade(rs.getString("agric_grade"));				
				s_all.setAgric_pnts(rs.getLong("agric_pnts"));
				s_all.setAgric_pos(rs.getString("agric_pos"));
				s_all.setAgric_remarks(rs.getString("agric_remarks"));
				
				s_all.setBiz(rs.getLong("biz"));
				s_all.setBiz_grade(rs.getString("biz_grade"));				
				s_all.setBiz_pnts(rs.getLong("biz_pnts"));
				s_all.setBiz_pos(rs.getString("biz_pos"));
				s_all.setBiz_remarks(rs.getString("biz_remarks"));
				
				s_all.setHom(rs.getLong("hom"));
				s_all.setHom_grade(rs.getString("hom_grade"));				
				s_all.setHom_pnts(rs.getLong("hom_pnts"));
				s_all.setHom_pos(rs.getString("hom_pos"));
				s_all.setHom_remarks(rs.getString("hom_remarks"));
				
				s_all.setComp(rs.getLong("comp"));
				s_all.setComp_grade(rs.getString("comp_grade"));				
				s_all.setComp_pnts(rs.getLong("comp_pnts"));
				s_all.setComp_pos(rs.getString("comp_pos"));
				s_all.setComp_remarks(rs.getString("comp_remarks"));
				
				s_all.setTt(rs.getLong("tt"));
				s_all.setAvg(rs.getLong("avg"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setOv_grade(rs.getString("ov_grade"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setOv_pnts(rs.getLong("ov_pnts"));
				s_all.setRank(rs.getString("rank"));
				s_all.setCrank(rs.getString("crank"));
				s_all.setPri_remarks(rs.getString("pri_remarks"));
				s_all.setClsT_remarks(rs.getString("ClsT_remarks"));
				return s_all;
			}
			
		});
		return list;
	}
	@Override
	public List<Form4marksbackup> selectAll_TermOne(Long adno) {
		List<Form4marksbackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_TERM_ONE, new MapSqlParameterSource().addValue("regno", adno), new RowMapper<Form4marksbackup>() {
			
				@Override
				public Form4marksbackup mapRow(ResultSet rs, int rowNum) throws SQLException {
					Form4marksbackup s_all = new Form4marksbackup();
					s_all.setRegno(rs.getLong("regno"));
					s_all.setTt(rs.getLong("tt"));
					s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
					s_all.setPoints(rs.getLong("points"));
					s_all.setRank(rs.getString("rank"));
					
					return s_all;
				}
				
			});
			return list;
	}

	@Override
	public List<Form4marksbackup> selectAll_TermTwo(Long adno) {
		List<Form4marksbackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_TERM_TWO, new MapSqlParameterSource().addValue("regno", adno), new RowMapper<Form4marksbackup>() {
			
			@Override
			public Form4marksbackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksbackup s_all = new Form4marksbackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setRank(rs.getString("rank"));
				
				
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public List<Form4marksbackup> selectAll_TermThree(Long adno) {
		List<Form4marksbackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_TERM_THREE, new MapSqlParameterSource().addValue("regno", adno), new RowMapper<Form4marksbackup>() {
			
			@Override
			public Form4marksbackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksbackup s_all = new Form4marksbackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setRank(rs.getString("rank"));
				
				return s_all;
			}
			
		});
		return list;
	}
	@Override
	public List<Form4basebackup> selectAll(String term, String year, String examtype) {
	List<Form4basebackup> list = namedParameterJdbcTemplate.query(SQL_SELECT_MARKCHIT, new MapSqlParameterSource().addValue("term", term).addValue("year", year).addValue("examtype", examtype), new RowMapper<Form4basebackup>() {
			
			@Override
			public Form4basebackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4basebackup s_all = new Form4basebackup();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setForm(rs.getString("form"));
				s_all.setTerm(rs.getString("term"));
				s_all.setExamtype(rs.getString("examtype"));
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setEng_grade(rs.getString("eng_grade"));
				s_all.setMath(rs.getLong("math"));
				s_all.setMath_grade(rs.getString("math_grade"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setKis_grade(rs.getString("kis_grade"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setBio_grade(rs.getString("bio_grade"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setChem_grade(rs.getString("chem_grade"));
				s_all.setPhy(rs.getLong("phy"));
				s_all.setPhy_grade(rs.getString("phy_grade"));
				s_all.setGeo(rs.getLong("geo"));
				s_all.setGeo_grade(rs.getString("geo_grade"));
				s_all.setHis(rs.getLong("his"));
				s_all.setHis_grade(rs.getString("his_grade"));
				s_all.setCre(rs.getLong("cre"));
				s_all.setCre_grade(rs.getString("cre_grade"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setAgric_grade(rs.getString("agric_grade"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setBiz_grade(rs.getString("biz_grade"));
				s_all.setHom(rs.getLong("hom"));
				s_all.setHom_grade(rs.getString("hom_grade"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setComp_grade(rs.getString("comp_grade"));
				s_all.setAvg(rs.getLong("avg"));
				s_all.setTt(rs.getLong("tt"));
				s_all.setPoints(rs.getLong("points"));
				s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				s_all.setOv_pnts(rs.getLong("ov_pnts"));
				s_all.setRank(rs.getString("rank"));
				s_all.setCrank(rs.getString("crank"));
				s_all.setSubno(rs.getString("subno"));
				s_all.setKcpemarks(rs.getString("kcpemarks"));
				
				
				
				
				//s_all.setKcpemean(rs.getString("kcpemean"));
				//s_all.setKcpegrade(rs.getString("kcpegrade"));				
				String total = Long.toString(rs.getLong("tt"));
				double total1 = Double.parseDouble(total);
				double div_tot = (total1/7);
				double kcpe_mean = Double.parseDouble(Student_kcpe_marks_util.kcpemarks_mean(rs.getString("kcpemarks")));
				s_all.setKcpegrade(Student_kcpe_marks_util.averageGrade(kcpe_mean));
				double dvn = div_tot - kcpe_mean;
				s_all.setVap(String.format("%.1f",dvn));
				return s_all;
			}
			
		});
		return list;
	}
	
	@Override
	public List<Subject_Analysis> sub_analysis(String term, String year, String examtype) {
	List<Subject_Analysis> list = namedParameterJdbcTemplate.query(SQL_SUB_ANALYSIS, new MapSqlParameterSource().addValue("term", term).addValue("year", year).addValue("examtype", examtype), new RowMapper<Subject_Analysis>() {
			
			@Override
			public Subject_Analysis mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject_Analysis s_all = new Subject_Analysis();
				s_all.setEng_aplain(rs.getString("eng_aplain"));
				s_all.setEng_aminus(rs.getString("eng_aminus"));
				s_all.setEng_bplus(rs.getString("eng_bplus"));
				s_all.setEng_bplain(rs.getString("eng_bplain"));
				s_all.setEng_bminus(rs.getString("eng_bminus"));
				s_all.setEng_cplus(rs.getString("eng_cplus"));
				s_all.setEng_cplain(rs.getString("eng_cplain"));
				s_all.setEng_cminus(rs.getString("eng_cminus"));
				s_all.setEng_dplus(rs.getString("eng_dplus"));
				s_all.setEng_dplain(rs.getString("eng_dplain"));
				s_all.setEng_dminus(rs.getString("eng_dminus"));
				s_all.setEng_eplain(rs.getString("eng_eplain"));
				s_all.setEng_entry(rs.getString("Eng_entry"));	
				double eng_entry = Double.parseDouble(rs.getString("Eng_entry"));
				if(eng_entry == 0.0) {
					 s_all.setEng_av("--");
					    s_all.setEng_grade("--");
						
				}else {
					double eng_tt = Double.parseDouble(rs.getString("eng_av"));
					double english_av = (eng_tt / eng_entry);					
					 s_all.setEng_av(String.format("%.2f",english_av));
					    s_all.setEng_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(english_av));						
				}
				s_all.setKis_aplain(rs.getString("kis_aplain"));
				s_all.setKis_aminus(rs.getString("kis_aminus"));
				s_all.setKis_bplus(rs.getString("kis_bplus"));
				s_all.setKis_bplain(rs.getString("kis_bplain"));
				s_all.setKis_bminus(rs.getString("kis_bminus"));
				s_all.setKis_cplus(rs.getString("kis_cplus"));
				s_all.setKis_cplain(rs.getString("kis_cplain"));
				s_all.setKis_cminus(rs.getString("kis_cminus"));
				s_all.setKis_dplus(rs.getString("kis_dplus"));
				s_all.setKis_dplain(rs.getString("kis_dplain"));
				s_all.setKis_dminus(rs.getString("kis_dminus"));
				s_all.setKis_eplain(rs.getString("kis_eplain"));
				s_all.setKis_entry(rs.getString("Kis_entry"));				
				double kis_entry = Double.parseDouble(rs.getString("kis_entry"));
				if(kis_entry == 0.0) {
					 s_all.setKis_av("--");
					    s_all.setKis_grade("--");
						
				}else {
					double kis_tt = Double.parseDouble(rs.getString("kis_av"));
					double kiswahili_av = (kis_tt / kis_entry);					
					 s_all.setKis_av(String.format("%.2f",kiswahili_av));
					    s_all.setKis_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(kiswahili_av));						
				}
				
				s_all.setMath_aplain(rs.getString("Math_aplain"));
				s_all.setMath_aminus(rs.getString("Math_aminus"));
				s_all.setMath_bplus(rs.getString("Math_bplus"));
				s_all.setMath_bplain(rs.getString("Math_bplain"));
				s_all.setMath_bminus(rs.getString("Math_bminus"));
				s_all.setMath_cplus(rs.getString("Math_cplus"));
				s_all.setMath_cplain(rs.getString("Math_cplain"));
				s_all.setMath_cminus(rs.getString("Math_cminus"));
				s_all.setMath_dplus(rs.getString("Math_dplus"));
				s_all.setMath_dplain(rs.getString("Math_dplain"));
				s_all.setMath_dminus(rs.getString("Math_dminus"));
				s_all.setMath_eplain(rs.getString("Math_eplain"));
				s_all.setMath_entry(rs.getString("math_entry"));				
			   	double math_entry = Double.parseDouble(rs.getString("math_entry"));
				if(math_entry == 0.0) {
					 s_all.setMath_av("--");
					    s_all.setMath_grade("--");
						
				}else {
					double math_tt = Double.parseDouble(rs.getString("math_av"));
					double mathematics_av = (math_tt / math_entry);					
					 s_all.setMath_av(String.format("%.2f",mathematics_av));
					    s_all.setMath_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(mathematics_av));						
				}
				s_all.setBio_aplain(rs.getString("Bio_aplain"));
				s_all.setBio_aminus(rs.getString("Bio_aminus"));
				s_all.setBio_bplus(rs.getString("Bio_bplus"));
				s_all.setBio_bplain(rs.getString("Bio_bplain"));
				s_all.setBio_bminus(rs.getString("Bio_bminus"));
				s_all.setBio_cplus(rs.getString("Bio_cplus"));
				s_all.setBio_cplain(rs.getString("Bio_cplain"));
				s_all.setBio_cminus(rs.getString("Bio_cminus"));
				s_all.setBio_dplus(rs.getString("Bio_dplus"));
				s_all.setBio_dplain(rs.getString("Bio_dplain"));
				s_all.setBio_dminus(rs.getString("Bio_dminus"));
				s_all.setBio_eplain(rs.getString("Bio_eplain"));
				s_all.setBio_entry(rs.getString("Bio_entry"));				
			 	double bio_entry = Double.parseDouble(rs.getString("bio_entry"));
				if(bio_entry == 0.0) {
					 s_all.setBio_av("--");
					    s_all.setBio_grade("--");
						
				}else {
					double bio_tt = Double.parseDouble(rs.getString("bio_av"));
					double biology_av = (bio_tt / bio_entry);					
					 s_all.setBio_av(String.format("%.2f",biology_av));
					    s_all.setBio_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(biology_av));						
				}
				s_all.setChem_aplain(rs.getString("Chem_aplain"));
				s_all.setChem_aminus(rs.getString("Chem_aminus"));
				s_all.setChem_bplus(rs.getString("Chem_bplus"));
				s_all.setChem_bplain(rs.getString("Chem_bplain"));
				s_all.setChem_bminus(rs.getString("Chem_bminus"));
				s_all.setChem_cplus(rs.getString("Chem_cplus"));
				s_all.setChem_cplain(rs.getString("Chem_cplain"));
				s_all.setChem_cminus(rs.getString("Chem_cminus"));
				s_all.setChem_dplus(rs.getString("Chem_dplus"));
				s_all.setChem_dplain(rs.getString("Chem_dplain"));
				s_all.setChem_dminus(rs.getString("Chem_dminus"));
				s_all.setChem_eplain(rs.getString("Chem_eplain"));
				s_all.setChem_entry(rs.getString("chem_entry"));				
				double chem_entry = Double.parseDouble(rs.getString("chem_entry"));
				if(chem_entry == 0.0) {
					 s_all.setChem_av("--");
					    s_all.setChem_grade("--");
						
				}else {
					double chem_tt = Double.parseDouble(rs.getString("chem_av"));
					double chemistry_av = (chem_tt / chem_entry);					
					 s_all.setChem_av(String.format("%.2f",chemistry_av));
					    s_all.setChem_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(chemistry_av));						
				}
				s_all.setPhy_aplain(rs.getString("Phy_aplain"));
				s_all.setPhy_aminus(rs.getString("Phy_aminus"));
				s_all.setPhy_bplus(rs.getString("Phy_bplus"));
				s_all.setPhy_bplain(rs.getString("Phy_bplain"));
				s_all.setPhy_bminus(rs.getString("Phy_bminus"));
				s_all.setPhy_cplus(rs.getString("Phy_cplus"));
				s_all.setPhy_cplain(rs.getString("Phy_cplain"));
				s_all.setPhy_cminus(rs.getString("Phy_cminus"));
				s_all.setPhy_dplus(rs.getString("Phy_dplus"));
				s_all.setPhy_dplain(rs.getString("Phy_dplain"));
				s_all.setPhy_dminus(rs.getString("Phy_dminus"));
				s_all.setPhy_eplain(rs.getString("Phy_eplain"));
				s_all.setPhy_entry(rs.getString("phy_entry"));				
				double phy_entry = Double.parseDouble(rs.getString("phy_entry"));
				if(phy_entry == 0.0) {
					 s_all.setPhy_av("--");
					    s_all.setPhy_grade("--");
						
				}else {
					double phy_tt = Double.parseDouble(rs.getString("phy_av"));
					double physics_av = (phy_tt / phy_entry);					
					 s_all.setPhy_av(String.format("%.2f",physics_av));
					    s_all.setPhy_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(physics_av));						
				}
				
				s_all.setGeo_aplain(rs.getString("Geo_aplain"));
				s_all.setGeo_aminus(rs.getString("Geo_aminus"));
				s_all.setGeo_bplus(rs.getString("Geo_bplus"));
				s_all.setGeo_bplain(rs.getString("Geo_bplain"));
				s_all.setGeo_bminus(rs.getString("Geo_bminus"));
				s_all.setGeo_cplus(rs.getString("Geo_cplus"));
				s_all.setGeo_cplain(rs.getString("Geo_cplain"));
				s_all.setGeo_cminus(rs.getString("Geo_cminus"));
				s_all.setGeo_dplus(rs.getString("Geo_dplus"));
				s_all.setGeo_dplain(rs.getString("Geo_dplain"));
				s_all.setGeo_dminus(rs.getString("Geo_dminus"));
				s_all.setGeo_eplain(rs.getString("Geo_eplain"));
				s_all.setGeo_entry(rs.getString("geo_entry"));				
				double geo_entry = Double.parseDouble(rs.getString("geo_entry"));
				if(geo_entry == 0.0) {
					 s_all.setGeo_av("--");
					    s_all.setGeo_grade("--");
						
				}else {
					double geo_tt = Double.parseDouble(rs.getString("geo_av"));
					double geography_av = (geo_tt / geo_entry);					
					 s_all.setGeo_av(String.format("%.2f",geography_av));
					    s_all.setGeo_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(geography_av));						
				}
				
				s_all.setHis_aplain(rs.getString("His_aplain"));
				s_all.setHis_aminus(rs.getString("His_aminus"));
				s_all.setHis_bplus(rs.getString("His_bplus"));
				s_all.setHis_bplain(rs.getString("His_bplain"));
				s_all.setHis_bminus(rs.getString("His_bminus"));
				s_all.setHis_cplus(rs.getString("His_cplus"));
				s_all.setHis_cplain(rs.getString("His_cplain"));
				s_all.setHis_cminus(rs.getString("His_cminus"));
				s_all.setHis_dplus(rs.getString("His_dplus"));
				s_all.setHis_dplain(rs.getString("His_dplain"));
				s_all.setHis_dminus(rs.getString("His_dminus"));
				s_all.setHis_eplain(rs.getString("His_eplain"));
				s_all.setHis_entry(rs.getString("his_entry"));				
				double his_entry = Double.parseDouble(rs.getString("his_entry"));
				if(his_entry == 0.0) {
					 s_all.setHis_av("--");
					    s_all.setHis_grade("--");
						
				}else {
					double his_tt = Double.parseDouble(rs.getString("his_av"));
					double history_av = (his_tt / his_entry);					
					 s_all.setHis_av(String.format("%.2f",history_av));
					    s_all.setHis_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(history_av));						
				}
						
				s_all.setCre_aplain(rs.getString("Cre_aplain"));
				s_all.setCre_aminus(rs.getString("Cre_aminus"));
				s_all.setCre_bplus(rs.getString("Cre_bplus"));
				s_all.setCre_bplain(rs.getString("Cre_bplain"));
				s_all.setCre_bminus(rs.getString("Cre_bminus"));
				s_all.setCre_cplus(rs.getString("Cre_cplus"));
				s_all.setCre_cplain(rs.getString("Cre_cplain"));
				s_all.setCre_cminus(rs.getString("Cre_cminus"));
				s_all.setCre_dplus(rs.getString("Cre_dplus"));
				s_all.setCre_dplain(rs.getString("Cre_dplain"));
				s_all.setCre_dminus(rs.getString("Cre_dminus"));
				s_all.setCre_eplain(rs.getString("Cre_eplain"));
				s_all.setCre_entry(rs.getString("cre_entry"));				
				double cre_entry = Double.parseDouble(rs.getString("cre_entry"));
				if(cre_entry == 0.0) {
					 s_all.setCre_av("--");
					    s_all.setCre_grade("--");
						
				}else {
					double cre_tt = Double.parseDouble(rs.getString("cre_av"));
					double cre_av = (cre_tt / cre_entry);					
					 s_all.setCre_av(String.format("%.2f",cre_av));
					    s_all.setCre_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(cre_av));						
				}
				
				s_all.setAgric_aplain(rs.getString("Agric_aplain"));
				s_all.setAgric_aminus(rs.getString("Agric_aminus"));
				s_all.setAgric_bplus(rs.getString("Agric_bplus"));
				s_all.setAgric_bplain(rs.getString("Agric_bplain"));
				s_all.setAgric_bminus(rs.getString("Agric_bminus"));
				s_all.setAgric_cplus(rs.getString("Agric_cplus"));
				s_all.setAgric_cplain(rs.getString("Agric_cplain"));
				s_all.setAgric_cminus(rs.getString("Agric_cminus"));
				s_all.setAgric_dplus(rs.getString("Agric_dplus"));
				s_all.setAgric_dplain(rs.getString("Agric_dplain"));
				s_all.setAgric_dminus(rs.getString("Agric_dminus"));
				s_all.setAgric_eplain(rs.getString("Agric_eplain"));
				s_all.setAgric_entry(rs.getString("agric_entry"));				
				double agric_entry = Double.parseDouble(rs.getString("agric_entry"));
				if(agric_entry == 0.0) {
					 s_all.setAgric_av("--");
					    s_all.setAgric_grade("--");
						
				}else {
					double agric_tt = Double.parseDouble(rs.getString("agric_av"));
					double agriculture_av = (agric_tt / agric_entry);					
					 s_all.setAgric_av(String.format("%.2f",agriculture_av));
					    s_all.setAgric_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(agriculture_av));						
				}
				
				s_all.setBiz_aplain(rs.getString("Biz_aplain"));
				s_all.setBiz_aminus(rs.getString("Biz_aminus"));
				s_all.setBiz_bplus(rs.getString("Biz_bplus"));
				s_all.setBiz_bplain(rs.getString("Biz_bplain"));
				s_all.setBiz_bminus(rs.getString("Biz_bminus"));
				s_all.setBiz_cplus(rs.getString("Biz_cplus"));
				s_all.setBiz_cplain(rs.getString("Biz_cplain"));
				s_all.setBiz_cminus(rs.getString("Biz_cminus"));
				s_all.setBiz_dplus(rs.getString("Biz_dplus"));
				s_all.setBiz_dplain(rs.getString("Biz_dplain"));
				s_all.setBiz_dminus(rs.getString("Biz_dminus"));
				s_all.setBiz_eplain(rs.getString("Biz_eplain"));
				s_all.setBiz_entry(rs.getString("biz_entry"));				
				double biz_entry = Double.parseDouble(rs.getString("biz_entry"));
				if(biz_entry == 0.0) {
					 s_all.setBiz_av("--");
					    s_all.setBiz_grade("--");
						
				}else {
					double biz_tt = Double.parseDouble(rs.getString("biz_av"));
					double business_av = (biz_tt / biz_entry);					
					 s_all.setBiz_av(String.format("%.2f",business_av));
					    s_all.setBiz_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(business_av));						
				}
				
				s_all.setComp_aplain(rs.getString("Comp_aplain"));
				s_all.setComp_aminus(rs.getString("Comp_aminus"));
				s_all.setComp_bplus(rs.getString("Comp_bplus"));
				s_all.setComp_bplain(rs.getString("Comp_bplain"));
				s_all.setComp_bminus(rs.getString("Comp_bminus"));
				s_all.setComp_cplus(rs.getString("Comp_cplus"));
				s_all.setComp_cplain(rs.getString("Comp_cplain"));
				s_all.setComp_cminus(rs.getString("Comp_cminus"));
				s_all.setComp_dplus(rs.getString("Comp_dplus"));
				s_all.setComp_dplain(rs.getString("Comp_dplain"));
				s_all.setComp_dminus(rs.getString("Comp_dminus"));
				s_all.setComp_eplain(rs.getString("Comp_eplain"));
				s_all.setComp_entry(rs.getString("comp_entry"));				
				double comp_entry = Double.parseDouble(rs.getString("comp_entry"));
				if(comp_entry == 0.0) {
					 s_all.setComp_av("--");
					    s_all.setComp_grade("--");
						
				}else {
					double comp_tt = Double.parseDouble(rs.getString("comp_av"));
					double computer_av = (comp_tt / comp_entry);					
					 s_all.setComp_av(String.format("%.2f",computer_av));
					    s_all.setComp_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(computer_av));						
				}
				
				s_all.setHom_aplain(rs.getString("Hom_aplain"));
				s_all.setHom_aminus(rs.getString("Hom_aminus"));
				s_all.setHom_bplus(rs.getString("Hom_bplus"));
				s_all.setHom_bplain(rs.getString("Hom_bplain"));
				s_all.setHom_bminus(rs.getString("Hom_bminus"));
				s_all.setHom_cplus(rs.getString("Hom_cplus"));
				s_all.setHom_cplain(rs.getString("Hom_cplain"));
				s_all.setHom_cminus(rs.getString("Hom_cminus"));
				s_all.setHom_dplus(rs.getString("Hom_dplus"));
				s_all.setHom_dplain(rs.getString("Hom_dplain"));
				s_all.setHom_dminus(rs.getString("Hom_dminus"));
				s_all.setHom_eplain(rs.getString("Hom_eplain"));
				s_all.setHom_entry(rs.getString("hom_entry"));				
				double hom_entry = Double.parseDouble(rs.getString("hom_entry"));
				if(hom_entry == 0.0) {
					 s_all.setHom_av("--");
					    s_all.setHom_grade("--");
						
				}else {
					double hom_tt = Double.parseDouble(rs.getString("hom_av"));
					double homsc_av = (hom_tt / hom_entry);					
					 s_all.setHom_av(String.format("%.2f",homsc_av));
					    s_all.setHom_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(homsc_av));						
				}
				return s_all;
			}
			
		});
		return list;
	}
	@Override
	public List<Subject_Analysis> stream_analysis(String term, String year, String examtype) {
		List<Subject_Analysis> list = namedParameterJdbcTemplate.query(SQL_STREAM_ANALYSIS, new MapSqlParameterSource().addValue("term", term).addValue("year", year).addValue("examtype", examtype), new RowMapper<Subject_Analysis>() {
			
			@Override
			public Subject_Analysis mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject_Analysis s_all = new Subject_Analysis();
				s_all.setStream(rs.getString("stream"));
				s_all.setSt_entry(rs.getString("entry"));				
				s_all.setAplain(rs.getString("aplain"));
				s_all.setAminus(rs.getString("aminus"));
				s_all.setBplus(rs.getString("bplus"));
				s_all.setBplain(rs.getString("bplain"));
				s_all.setBminus(rs.getString("bminus"));
				s_all.setCplus(rs.getString("cplus"));
				s_all.setCplain(rs.getString("cplain"));
				s_all.setCminus(rs.getString("cminus"));
				s_all.setDplus(rs.getString("dplus"));
				s_all.setDplain(rs.getString("dplain"));
				s_all.setDminus(rs.getString("dminus"));	
				s_all.setEplain(rs.getString("eplain"));
				double entry = Double.parseDouble(rs.getString("entry"));
				if(entry == 0.0) {
					 s_all.setSt_av("--");
					    s_all.setSt_grade("--");
						
				}else {
					double _tt = Double.parseDouble(rs.getString("tt_marks"));
					double _av = ((_tt / (entry*700))*100);					
					 s_all.setSt_av(String.format("%.2f",_av));
					    s_all.setSt_grade(CommonGradeUtils_f3_and_f4.averageGrade_sub(_av));						
				}
				return s_all;
			}
			
		});
		return list;
	}
	
	@Override
	public List<Form4marksbackup> student_mean_dev(long regno) {
		List<Form4marksbackup> list = namedParameterJdbcTemplate.query(SQL_DEV_,new MapSqlParameterSource().addValue("regno", regno), new RowMapper<Form4marksbackup>() {
			@Override
			public Form4marksbackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksbackup s_all = new Form4marksbackup();
				s_all.setRegno(rs.getLong("regno"));
				long dev1 = 0;
				 dev1 = (rs.getLong("deviation"));
				long dev2 = (dev1)/7;
				s_all.setDev(Long.toString(dev2));
				return s_all;
			}
		});
		return list;
	}
}
