package com.skul.skul.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.skul.skul.dao.FormOneDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Student;
import com.skul.skul.utils.CommonGradeUtils;
import com.skul.skul.utils.CommonGradeUtils;

@Repository
public class FormOneDaoImpl implements FormOneDao{

	protected static final String NULL = null;
	
	final String SQL_SELECT_language_STRM = "SELECT student.regno,student.stream,formonemarks.regno,formonemarks.stream,formonemarks.eng,formonemarks.kis,formonemarks.math FROM student, formonemarks WHERE student.regno = formonemarks.regno";
	
	final String SQL_SELECT_science_STRM = "SELECT student.regno,student.stream,formonemarks.regno,formonemarks.stream,formonemarks.bio,formonemarks.chem,formonemarks.phy,formonemarks.phy FROM student, formonemarks WHERE student.regno = formonemarks.regno";
	
	final String SQL_SELECT_humanities_STRM = "SELECT student.regno,student.stream,formonemarks.regno,formonemarks.stream,formonemarks.geo,formonemarks.his,formonemarks.cre FROM student, formonemarks WHERE student.regno = formonemarks.regno";
	
	final String SQL_SELECT_technicals_STRM = "SELECT student.regno,student.stream,formonemarks.regno,formonemarks.stream,formonemarks.agric,formonemarks.biz,formonemarks.comp, formonemarks.hom FROM student, formonemarks WHERE student.regno = formonemarks.regno";
	
	final String SQL_COPY_STD = "SELECT regno,form,stream,year from student where form ='ONE' ";
	
	final String qsl_copy_to_marks = "INSERT INTO formonemarks(regno,form,stream,year) VALUES (:regno,:form,:stream,:year)";
	
	final String SQL_UPDATE_TT = "update formonemarks set eng_grade = :eng_grade, kis_grade = :kis_grade, math_grade = :math_grade,bio_grade = :bio_grade, chem_grade = :chem_grade,phy_grade = :phy_grade, geo_grade = :geo_grade, his_grade = :his_grade,cre_grade = :cre_grade, agric_grade = :agric_grade,biz_grade = :biz_grade, comp_grade = :comp_grade, hom_grade = :hom_grade,tt = :tt,points =:points, avg = :avg, ov_grade =:ov_grade where regno = :regno";
	
	final String SQL_GET_ALL = "select regno, eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt FROM formonemarks group by regno";
	
final String SQL_GET_ = "SELECT *,(SELECT AVG(c)FROM  (VALUES(eng),(kis),(math),(bio),(chem),(phy),(geo),(his),(cre),(agric),(biz),(comp),(hom),(agric) ) T (c)) AS tt	FROM formonemarks group by regno";

final String SQL_RANK_PER_CLASS = "SELECT formonemarks.regno, COUNT( lesser.regno ) +1 AS crank FROM formonemarks LEFT JOIN formonemarks AS lesser ON lesser.tt > formonemarks.tt AND lesser.stream = formonemarks.stream GROUP BY formonemarks.regno";
	 
	//final String SQL_RANK_average = "SELECT regno,tt,rank FROM(SELECT regno,tt, @curRank := IF(@prevRank = tt, @curRank, @incRank) AS rank,@incRank :=@incRank + 1,@prevRank := tt FROM formonemarks m,(SELECT @curRank :=0, @prevRank := NULL, @incRank := 1) r ORDER BY tt DESC) s";
	
	final String SQL_RANK_average = "SELECT regno,tt, RANK() OVER (ORDER BY tt DESC) from formonemarks";
	
	final String qsl_copy_to_tableBACKUP = "INSERT INTO formonebackup(regno,form,stream,examtype,term,year,math,eng,kis,eng_grade,math_grade,kis_grade,bio,bio_grade,chem,chem_grade,phy, phy_grade,geo,geo_grade,his,his_grade,cre, cre_grade,agric,agric_grade,biz,biz_grade,hom,hom_grade,comp,comp_grade,tt,avg,points,ov_grade,rank,crank) VALUES (:regno,:form,:stream,:examtype,:term,:year,:math,:eng,:kis,:eng_grade,:math_grade,:kis_grade,:bio,:bio_grade,:chem,:chem_grade,:phy, :phy_grade,:geo,:geo_grade,:his,:his_grade,:cre, :cre_grade,:agric,:agric_grade,:biz,:biz_grade,:hom,:hom_grade,:comp,:comp_grade,:tt,:avg,:points,:ov_grade,:rank,:crank)";
	  
	final String SQL_ALL_AVG = "SELECT regno,stream,year,term, Avg(Coalesce(eng,0))as eng,Avg(Coalesce(kis,0))as kis,Avg(Coalesce(math,0))as math,Avg(Coalesce(bio,0))as bio,Avg(Coalesce(chem,0))as chem,Avg(Coalesce(phy,0))as phy,Avg(Coalesce(geo,0))as geo,Avg(Coalesce(his,0))as his,Avg(Coalesce(cre,0))as cre,Avg(Coalesce(agric,0))as agric,Avg(Coalesce(biz,0))as biz,Avg(Coalesce(comp,0))as comp,Avg(Coalesce(hom,0))as hom FROM `formonebackup` WHERE year = :year AND term = :term GROUP BY regno";
	
	final String qsl_copy_to_table1 = "INSERT INTO FormOneMarksReportProcess(regno,stream,year,term,eng,math,kis,bio,chem,phy,geo,his,cre,agric,biz,comp,hom) VALUES (:regno,:stream,:year,:term,:eng,:math,:kis,:bio,:chem,:phy,:geo,:his,:cre,:agric,:biz,:comp,:hom)";

	//final String qsl_all = "SELECT regno, eng, kis, math, bio, chem, phy, geo, his, cre, agric, biz, comp, hom, SUM( eng + kis + math + bio + chem + phy + geo + his + cre + agric + biz + comp + hom ) AS tt FROM `formOneMarksreportprocess` GROUP BY regno";
	
	//final String qsl_all = "SELECT regno,eng, kis, math, bio, chem, phy, geo, his, cre, agric, biz, comp, hom,ROUND(SUM(COALESCE(CAST(eng AS DOUBLE PRECISION),0)) + SUM(COALESCE(CAST(kis AS DOUBLE PRECISION),0)) + SUM(COALESCE(CAST(math AS DOUBLE PRECISION),0)) + SUM(COALESCE(CAST(bio AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(chem AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(phy AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(geo AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(his AS DOUBLE PRECISION),0))	+ SUM(COALESCE(CAST(cre AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(agric AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(biz AS DOUBLE PRECISION),0))+ SUM(COALESCE(CAST(comp AS DOUBLE PRECISION),0))	+ SUM(COALESCE(CAST(hom AS DOUBLE PRECISION),0))) AS tt FROM formOneMarksreportprocess GROUP BY regno";
		
	final String qsl_all = "select regno, eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt FROM formOneMarksreportprocess group by regno,eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt"; 
			
	final String sql_up_all = "update FormOneMarksReportProcess set eng_grade = :eng_grade,eng_pnts = :eng_pnts,eng_remarks =:eng_remarks, math_grade = :math_grade,math_pnts = :math_pnts,math_remarks =:math_remarks,kis_grade = :kis_grade,kis_pnts = :kis_pnts,kis_remarks =:kis_remarks,bio_grade = :bio_grade,bio_pnts = :bio_pnts,bio_remarks =:bio_remarks,chem_grade = :chem_grade,chem_pnts = :chem_pnts,chem_remarks =:chem_remarks, phy_grade = :phy_grade,phy_pnts = :phy_pnts,phy_remarks =:phy_remarks,geo_grade = :geo_grade,geo_pnts = :geo_pnts,geo_remarks =:geo_remarks,his_grade = :his_grade,his_pnts = :his_pnts,his_remarks =:his_remarks,cre_grade = :cre_grade,cre_pnts = :cre_pnts,cre_remarks =:cre_remarks,agric_grade = :agric_grade,agric_pnts = :agric_pnts,agric_remarks =:agric_remarks,biz_grade = :biz_grade,biz_pnts = :biz_pnts,biz_remarks =:biz_remarks,hom_grade = :hom_grade,hom_pnts = :hom_pnts,hom_remarks =:hom_remarks,comp_grade = :comp_grade,comp_pnts = :comp_pnts,comp_remarks =:comp_remarks, Ov_grade = :Ov_grade, points = :points, avg = :avg, tt = :tt, pri_remarks = :pri_remarks,ClsT_remarks = :ClsT_remarks where regno = :regno"; 
	
	final String clear_all = "DELETE FROM formonemarksreportprocess";
	
	final String SQL_ALL_process = "select * from formonemarksreportprocess";	
	
	final String SQL_ALL_from_table1_to_table2 = "select * from formonemarks";
	
	final String SQL_RANK_PER_CLASS_AVG = "SELECT formonemarksreportprocess.regno, COUNT( lesser.regno ) +1 AS crank FROM formonemarksreportprocess LEFT JOIN formonemarksreportprocess AS lesser ON lesser.tt > formonemarksreportprocess.tt AND lesser.stream = formonemarksreportprocess.stream GROUP BY formonemarksreportprocess.regno";
	
	//final String SQL_RANK_ave = "SELECT regno,tt,rank FROM(SELECT regno,tt, @curRank := IF(@prevRank = tt, @curRank, @incRank) AS rank,@incRank :=@incRank + 1,@prevRank := tt FROM formonemarksreportprocess m,(SELECT @curRank :=0, @prevRank := NULL, @incRank := 1) r ORDER BY tt DESC) s";

	final String SQL_RANK_ave = "SELECT regno,tt, RANK() OVER (ORDER BY tt DESC)FROM formonemarksreportprocess";

	final String qsl_copy_to_tableBACKUP_av = "INSERT INTO form_one_marks_back_up(regno,form,stream,term,year,math,eng,kis,eng_grade,eng_pnts,eng_pos,eng_remarks,math_grade,math_pnts,math_pos,math_remarks,kis_grade,kis_pnts,kis_pos,kis_remarks,bio,bio_grade,bio_pnts,bio_pos,bio_remarks,chem,chem_grade,chem_pnts,chem_pos,chem_remarks,phy, phy_grade,phy_pnts,phy_pos,phy_remarks,geo,geo_grade,geo_pnts,geo_pos,geo_remarks,his,his_grade,his_pnts,his_pos,his_remarks,cre, cre_grade,cre_pnts,cre_pos,cre_remarks,agric,agric_grade,agric_pnts,agric_pos,agric_remarks,biz,biz_grade,biz_pnts,biz_pos,biz_remarks,hom,hom_grade,hom_pnts,hom_pos,hom_remarks,comp,comp_grade,comp_pnts,comp_pos,comp_remarks,tt,avg,ov_pnts,points,ov_grade,ov_pnts_grade,rank,crank,pri_remarks,ClsT_remarks) "
			+ "VALUES (:regno,:form,:stream,:term,:year,:math,:eng,:kis,:eng_grade,:eng_pnts,:eng_pos,:eng_remarks,:math_grade,:math_pnts,:math_pos,:math_remarks,:kis_grade,:kis_pnts,:kis_pos,:kis_remarks,:bio,:bio_grade,:bio_pnts,:bio_pos,:bio_remarks,:chem,:chem_grade,:chem_pnts,:chem_pos,:chem_remarks,:phy, :phy_grade,:phy_pnts,:phy_pos,:phy_remarks,:geo,:geo_grade,:geo_pnts,:geo_pos,:geo_remarks,:his,:his_grade,:his_pnts,:his_pos,:his_remarks,:cre, :cre_grade,:cre_pnts,:cre_pos,:cre_remarks,:agric,:agric_grade,:agric_pnts,:agric_pos,:agric_remarks,:biz,:biz_grade,:biz_pnts,:biz_pos,:biz_remarks,:hom,:hom_grade,:hom_pnts,:hom_pos,:hom_remarks,:comp,:comp_grade,:comp_pnts,:comp_pos,:comp_remarks,:tt,:avg,:ov_pnts,:points,:ov_grade,:ov_pnts_grade,:rank,:crank,:pri_remarks,:ClsT_remarks)";
	 
	final String sql_findone_ = "select * from formonemarks";
	
	final String sql_findone_k  = "SELECT regno,stream,term,year,ROUND(avg(COALESCE(CAST(eng AS DOUBLE PRECISION),0))) AS eng,ROUND(avg(COALESCE(CAST(kis AS DOUBLE PRECISION),0))) AS kis,ROUND(avg(COALESCE(CAST(math AS DOUBLE PRECISION),0))) AS math,ROUND(avg(COALESCE(CAST(bio AS DOUBLE PRECISION),0))) AS bio,ROUND(avg(COALESCE(CAST(chem AS DOUBLE PRECISION),0))) AS chem,ROUND(avg(COALESCE(CAST(phy AS DOUBLE PRECISION),0))) AS phy,ROUND(avg(COALESCE(CAST(geo AS DOUBLE PRECISION),0))) AS geo,ROUND(avg(COALESCE(CAST(his AS DOUBLE PRECISION),0))) AS his,ROUND(avg(COALESCE(CAST(cre AS DOUBLE PRECISION),0))) AS cre,ROUND(avg(COALESCE(CAST(agric AS DOUBLE PRECISION),0))) AS agric,ROUND(avg(COALESCE(CAST(biz AS DOUBLE PRECISION),0))) AS biz,ROUND(avg(COALESCE(CAST(comp AS DOUBLE PRECISION),0))) AS comp,ROUND(avg(COALESCE(CAST(hom AS DOUBLE PRECISION),0))) AS hom  FROM formonebackup WHERE year = :year AND term = :term GROUP BY regno,stream,term,year";
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override  //load english for input operation
	public List<FormOneMarks> select_eng_ByStream() {
			
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_SELECT_language_STRM, new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks s_all = new FormOneMarks();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setMath(rs.getLong("math"));
				return s_all;
			}
			
		});
		return list;
	}
	@Override
	public List<FormOneMarks> select_sci_ByStream() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_SELECT_science_STRM, new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks s_all = new FormOneMarks();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setPhy(rs.getLong("phy"));
				return s_all;
			}
			
		});
		return list;
	}
	@Override
	public List<FormOneMarks> select_hum_ByStream() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_SELECT_humanities_STRM, new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks s_all = new FormOneMarks();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setGeo(rs.getLong("geo"));
				s_all.setHis(rs.getLong("his"));
				s_all.setCre(rs.getLong("cre"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public List<FormOneMarks> select_tech_ByStream() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_SELECT_technicals_STRM, new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks s_all = new FormOneMarks();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setHom(rs.getLong("hom"));
				return s_all;
			}
			
		});
		return list;
	}
	@Override
    public void update(FormOneMarks e) {
		 final String UPDATE_QUERY = "update formonemarks set eng = :eng,kis = :kis, math = :math where regno = :regno";
		    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("eng", e.getEng()).addValue("kis", e.getKis()).addValue("math", e.getMath()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       
    }	
	@Override
    public void update_sci(FormOneMarks e) {
		 final String UPDATE_QUERY_sci = "update formonemarks set bio = :bio,chem = :chem, phy = :phy where regno = :regno";
		    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("bio", e.getBio()).addValue("chem", e.getChem()).addValue("phy", e.getPhy()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY_sci, namedParameters); 
       
    }
	@Override
    public void update_hum(FormOneMarks e) {
		 final String UPDATE_QUERY = "update formonemarks set geo = :geo,his = :his, cre = :cre where regno = :regno";
		    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("geo", e.getGeo()).addValue("his", e.getGeo()).addValue("cre", e.getCre()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       
    }	
	@Override
    public void update_tech(FormOneMarks e) {
		 final String UPDATE_QUERY_sci = "update formonemarks set agric = :agric,biz = :biz, comp = :comp, hom = :hom where regno = :regno";
		    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("agric", e.getAgric()).addValue("biz", e.getBiz()).addValue("comp", e.getComp()).addValue("hom", e.getHom()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY_sci, namedParameters); 
       
    }
	
	@Override
	public List<Student> select_students_ToLoad() {
		List<Student> list = namedParameterJdbcTemplate.query(SQL_COPY_STD, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setForm(rs.getString("form"));			
				s_all.setYear(rs.getString("year"));
				s_all.setStream(rs.getString("stream"));								
				return s_all;
			}			
		});
		return list;	
	}
	@Override
	public int[] select_all_students(List<Student> copy_all) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(copy_all.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(qsl_copy_to_marks,batch);        		
        	      return crankCounts;
	}
	@Override
	public void updateExamType(String exmtype){     // update exam type
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("exmtype", exmtype);
	      String query = "UPDATE formonemarks SET examtype ='" + exmtype +"' "; // where form = 'one' ";
	      this.namedParameterJdbcTemplate.update(query,params);
	 }

	@Override
	public void updateTerm(String term) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("term", term);
	      String query = "UPDATE formonemarks SET term ='" + term +"' ";// where form = 'one' ";
	      this.namedParameterJdbcTemplate.update(query,params);
		
	}
	
	@Override
	public List<FormOneMarks> total_marks() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_GET_ALL, new RowMapper<FormOneMarks>() {
		@Override
		public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Long enge;Long kise;Long mathe; Long bioe ;Long cheme ;Long phye ;Long geoe ;Long hise ;Long cree ;Long agrice;
			Long bize;Long compe ;Long home ;	
			
			Long engel; Long kisel; Long mathel; Long bioel ;Long chemel ;Long phyel ; Long geoel;Long hisel; Long creel;Long agricel;
			Long bizel; Long compel;Long homel;
			
			FormOneMarks e = new FormOneMarks();					
			e.setRegno(rs.getLong("regno"));
						
			 enge = rs.getLong("eng"); kise = rs.getLong("kis"); mathe = rs.getLong("math"); bioe = rs.getLong("bio"); cheme = rs.getLong("chem");
			 phye = rs.getLong("phy"); geoe = rs.getLong("geo"); hise = rs.getLong("his"); cree = rs.getLong("cre"); agrice = rs.getLong("agric");
			 bize = rs.getLong("biz"); compe = rs.getLong("comp"); home = rs.getLong("hom");			
			
			 if(enge == 0 && kise == 0 && mathe == 0 && bioe == 0 && cheme == 0 && phye == 0 &&
						geoe == 0 && hise == 0 && cree == 0 && agrice == 0 && bize == 0 && compe == 0 && home == 0) {
						
			 e.setTt((long) 0);
				e.setAvg((long) 0);
				e.setOv_grade("Z");
			} else
			{

				//get group one subjects
				if(enge.equals("null")||enge.equals("")) {
					engel = (long) 0;
				}else {
					engel = enge;
					String grd1 = CommonGradeUtils.groupAGrade(engel);
					e.setEng_grade(grd1);
				}
				if(kise.equals("null")||kise.equals("")) {
					kisel = (long) 0;
				}else {
					kisel = kise;
					String grd2 = CommonGradeUtils.groupAGrade(kisel);
					e.setKis_grade(grd2);
				}
				if(mathe.equals("") || mathe.equals("null")) {
					mathel = (long) 0;
				}else {
					mathel = mathe;
					String grd3 = CommonGradeUtils.groupAGrade(mathel);
					e.setMath_grade(grd3);
				}
				
//get the best first two subjects from group 2
					
				if(bioe.equals("null")||bioe.equals("")) {
					bioel = (long) 0;
				}else {
					bioel = bioe;
					String grd4 = CommonGradeUtils.groupAGrade(bioel);
					e.setBio_grade(grd4);
				
				}
				if(cheme.equals("null")||cheme.equals("")) {
					chemel = (long) 0;
				}else {
					chemel = cheme;
					String grd5 = CommonGradeUtils.groupAGrade(chemel);
					e.setChem_grade(grd5);
				
				}
				if(phye.equals("null")||phye.equals("")) {
					phyel = (long) 0;
				}else {
					phyel = phye;
					String grd6 = CommonGradeUtils.groupAGrade(phyel);
					e.setPhy_grade(grd6);
				
				}		
				
							
//get the best highest value from group 3
				
				if(geoe.equals(NULL)||geoe.equals("")) {
					geoel = (long) 0;
				}else {
					geoel = geoe;
					String grd7 = CommonGradeUtils.groupAGrade(geoel);
					e.setGeo_grade(grd7);
				}
				if(hise.equals(NULL)||hise.equals("")) {
					hisel = (long) 0;
				}else {
					hisel = hise;
					String grd8 = CommonGradeUtils.groupAGrade(hisel);
					e.setHis_grade(grd8);
				}
				if(cree.equals(NULL)||cree.equals("")) {
					creel = (long) 0;
				}else {
					creel = cree;
					String grd9 = CommonGradeUtils.groupAGrade(creel);
					e.setCre_grade(grd9);
				}
									
//get the best highest value from group 4
				
				if(agrice.equals(NULL)||agrice.equals("")) {
					agricel = (long) 0;
				}else {
					agricel = agrice;
					String grd10 = CommonGradeUtils.groupAGrade(agricel);
					e.setAgric_grade(grd10);
				}
				if(bize.equals(NULL)||bize.equals("")) {
					bizel = (long) 0;
				}else {
					bizel = bize;
					String grd11 = CommonGradeUtils.groupAGrade(bizel);
					e.setBiz_grade(grd11);
				}
				if(compe.equals(NULL)||compe.equals("")) {
					compel = (long) 0;
				}else {
					compel = compe;
					String grd12 = CommonGradeUtils.groupAGrade(compel);
					e.setComp_grade(grd12);
				}
				if(home.equals(NULL)||home.equals("")) {
					homel = (long) 0;
				}else {
					homel = home;
					String grd13 = CommonGradeUtils.groupAGrade(homel);
					e.setHom_grade(grd13);
				}
			
				
				Long tot = (
						engel + kisel + mathel + bioel + chemel + phyel + geoel + hisel + creel + agricel + bizel + compel + homel
						);
				e.setTt(tot);
				
				
				long one = tot/13;  // getting average
				String two = Long.toString(one);  //changing average to string
				
				String grade_val = CommonGradeUtils.averageGrade(one);
				
				String aver = String.format("%.0f", Double.parseDouble(two));
				e.setAvg(Long.parseLong(aver));				
				e.setOv_grade(grade_val);
				Long pt = CommonGradeUtils.points(grade_val);
				e.setPoints(pt);
			}
			
		
			return e;
		}
	});
	return list;
	}
	@Override
	public int[] batchUpdate_FormOne_tt(List<FormOneMarks> form_tt) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(form_tt.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(SQL_UPDATE_TT,batch);
        return updateCounts;
	}
	
	@Override
	public List<FormOneMarks> rankList() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_RANK_PER_CLASS, new RowMapper<FormOneMarks>() {

			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks c_rank = new FormOneMarks();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setCrank(rs.getString("crank"));
				return c_rank;
			}
		});
		return list;
			}

	@Override
	public int[] c_rank(List<FormOneMarks> crank) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crank.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update formonemarks set crank = :crank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	@Override
	public List<FormOneMarks> rank_ave() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_RANK_average, new RowMapper<FormOneMarks>() {

			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks c_rank = new FormOneMarks();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setRank(rs.getString("rank"));
				return c_rank;
			}
		});
		return list;
	}
	@Override
	public int[] rank_average(List<FormOneMarks> crankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update formonemarks set rank = :rank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	
	
	@Override
	public int[] batchAverageToBackUp(List<FormOneMarks> backup) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		qsl_copy_to_tableBACKUP,batch);
        		
        	      return crankCounts;
		}	
	
	@Override
	public List<FormOneMarks> select_avgs(String year, String term) {
		
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(sql_findone_k, new MapSqlParameterSource().addValue("year", year).addValue("term", term), new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks s_all = new FormOneMarks();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setTerm(rs.getString("term"));
				s_all.setYear(rs.getString("year"));		
				
				//String ts_fomrt = String.format("%.0d", rs.getInt("eng"));
				//s_all.setEng(ts_fomrt);
				s_all.setEng(rs.getLong("eng"));
				s_all.setKis(rs.getLong("kis"));
				s_all.setMath(rs.getLong("math"));
				s_all.setBio(rs.getLong("bio"));
				s_all.setChem(rs.getLong("chem"));
				s_all.setPhy(rs.getLong("phy"));				
				s_all.setGeo(rs.getLong("geo"));
				s_all.setHis(rs.getLong("his"));
				s_all.setCre(rs.getLong("cre"));
				s_all.setAgric(rs.getLong("agric"));
				s_all.setBiz(rs.getLong("biz"));
				s_all.setComp(rs.getLong("comp"));
				s_all.setHom(rs.getLong("hom"));
				return s_all;
			}
			
		});
		return list;
	}
	
	@Override
	public int[] copyAvg(List<FormOneMarks> copy_all) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(copy_all.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(qsl_copy_to_table1,batch);
        		
        	      return crankCounts;
	}
	@Override
	public List<FormOneMarks_Report_Process> marks_avgs() {
		List<FormOneMarks_Report_Process> list = namedParameterJdbcTemplate.query(qsl_all, new RowMapper<FormOneMarks_Report_Process>() {

			@Override
			public FormOneMarks_Report_Process mapRow(ResultSet rs, int rowNum) throws SQLException {
				Long enge;Long kise;Long mathe; Long bioe ;Long cheme ;Long phye ;Long geoe ;Long hise ;Long cree ;Long agrice;
				Long bize;Long compe ;Long home ;	
				
				Long engel; Long kisel; Long mathel; Long bioel ;Long chemel ;Long phyel ; Long geoel;Long hisel; Long creel;Long agricel;
				Long bizel; Long compel;Long homel;
				
				Long engpnts = (long) 0;Long kispnts = (long) 0;Long mathpnts = (long) 0; Long biopnts = (long) 0; Long chempnts = (long) 0;Long phypnts = (long) 0;Long geopnts = (long) 0; Long hispnts = (long) 0;Long crepnts = (long) 0; Long agricpnts = (long) 0;
				Long bizpnts = (long) 0;Long comppnts = (long) 0;Long hompnts = (long) 0;	
				
				
				FormOneMarks_Report_Process e = new FormOneMarks_Report_Process();					
				e.setRegno(rs.getLong("regno"));
				
				 enge = rs.getLong("eng"); kise = rs.getLong("kis"); mathe = rs.getLong("math"); bioe = rs.getLong("bio"); cheme = rs.getLong("chem");
				 phye = rs.getLong("phy"); geoe = rs.getLong("geo"); hise = rs.getLong("his"); cree = rs.getLong("cre"); agrice = rs.getLong("agric");
				 bize = rs.getLong("biz"); compe = rs.getLong("comp"); home = rs.getLong("hom");			
				
				 if(enge == 0 && kise == 0 && mathe == 0 && bioe == 0 && cheme == 0 && phye == 0 &&
							geoe == 0 && hise == 0 && cree == 0 && agrice == 0 && bize == 0 && compe == 0 && home == 0) {
							
				 e.setTt((long) 0);
					e.setAvg((long) 0);
					e.setOv_grade("Z");} 
					else {
						//get group one subjects
						if(enge.equals("null")||enge.equals("")) {
							engel = (long) 0;
						}else {
							engel = enge;
							String grd1 = CommonGradeUtils.groupAGrade(engel);						
							engpnts = CommonGradeUtils.pointsA(grd1);
							e.setEng_pnts(engpnts);
							e.setEng_grade(grd1);
							e.setEng_remarks(CommonGradeUtils.remarks(grd1));
						}
						if(kise.equals("null")||kise.equals("")) {
							kisel = (long) 0;
						}else {
							kisel = kise;
							String grd2 = CommonGradeUtils.groupAGrade(kisel);
							kispnts = CommonGradeUtils.pointsA(grd2);
							e.setKis_pnts(kispnts);
							e.setKis_grade(grd2);
							e.setKis_remarks(CommonGradeUtils.remarks(grd2));
						}
						if(mathe.equals("") || mathe.equals("null")) {
							mathel = (long) 0;
						}else {
							mathel = mathe;
							String grd3 = CommonGradeUtils.groupAGrade(mathel);
							mathpnts = CommonGradeUtils.pointsA(grd3);
							e.setMath_pnts(mathpnts);
							e.setMath_grade(grd3);
							e.setMath_remarks(CommonGradeUtils.remarks(grd3));
						}
						
	//get the best first two subjects from group 2
							
						if(bioe.equals("null")||bioe.equals("")) {
							bioel = (long) 0;
						}else {
							bioel = bioe;
							String grd4 = CommonGradeUtils.groupAGrade(bioel);
							biopnts = CommonGradeUtils.pointsA(grd4);
							e.setBio_pnts(biopnts);
							e.setBio_grade(grd4);
							e.setBio_remarks(CommonGradeUtils.remarks(grd4));
						}
						if(cheme.equals("null")||cheme.equals("")) {
							chemel = (long) 0;
						}else {
							chemel = cheme;
							String grd5 = CommonGradeUtils.groupAGrade(chemel);
							chempnts = CommonGradeUtils.pointsA(grd5);
							e.setChem_pnts(chempnts);
							e.setChem_grade(grd5);
							e.setChem_remarks(CommonGradeUtils.remarks(grd5));
						}
						if(phye.equals("null")||phye.equals("")) {
							phyel = (long) 0;
						}else {
							phyel = phye;
							String grd6 = CommonGradeUtils.groupAGrade(phyel);
							phypnts = CommonGradeUtils.pointsA(grd6);
							e.setPhy_pnts(phypnts);
							e.setPhy_grade(grd6);
							e.setPhy_remarks(CommonGradeUtils.remarks(grd6));
						}		
						
									
	//get the best highest value from group 3
						
						if(geoe.equals(NULL)||geoe.equals("")) {
							geoel = (long) 0;
						}else {
							geoel = geoe;
							String grd7 = CommonGradeUtils.groupAGrade(geoel);
							geopnts = CommonGradeUtils.pointsA(grd7);
							e.setGeo_pnts(geopnts);
							e.setGeo_grade(grd7);
							e.setGeo_remarks(CommonGradeUtils.remarks(grd7));
						}
						if(hise.equals(NULL)||hise.equals("")) {
							hisel = (long) 0;
						}else {
							hisel = hise;
							String grd8 = CommonGradeUtils.groupAGrade(hisel);
							hispnts = CommonGradeUtils.pointsA(grd8);
							e.setHis_pnts(hispnts);
							e.setHis_grade(grd8);
							e.setHis_remarks(CommonGradeUtils.remarks(grd8));
						}
						if(cree.equals(NULL)||cree.equals("")) {
							creel = (long) 0;
						}else {
							creel = cree;
							String grd9 = CommonGradeUtils.groupAGrade(creel);
							crepnts = CommonGradeUtils.pointsA(grd9);
							e.setCre_pnts(crepnts);
							e.setCre_grade(grd9);
							e.setCre_remarks(CommonGradeUtils.remarks(grd9));
						}
											
	//get the best highest value from group 4
						
						if(agrice.equals(NULL)||agrice.equals("")) {
							agricel = (long) 0;
						}else {
							agricel = agrice;
							String grd10 = CommonGradeUtils.groupAGrade(agricel);
							agricpnts = CommonGradeUtils.pointsA(grd10);
							e.setAgric_pnts(agricpnts);
							e.setAgric_grade(grd10);
							e.setAgric_remarks(CommonGradeUtils.remarks(grd10));
						}
						if(bize.equals(NULL)||bize.equals("")) {
							bizel = (long) 0;
						}else {
							bizel = bize;
							String grd11 = CommonGradeUtils.groupAGrade(bizel);
							bizpnts = CommonGradeUtils.pointsA(grd11);
							e.setBiz_pnts(bizpnts);
							e.setBiz_grade(grd11);
							e.setBiz_remarks(CommonGradeUtils.remarks(grd11));
						}
						if(compe.equals(NULL)||compe.equals("")) {
							compel = (long) 0;
						}else {
							compel = compe;
							String grd12 = CommonGradeUtils.groupAGrade(compel);
							comppnts = CommonGradeUtils.pointsA(grd12);
							e.setComp_pnts(comppnts);
							e.setComp_grade(grd12);
							e.setComp_remarks(CommonGradeUtils.remarks(grd12));
						}
						if(home.equals(NULL)||home.equals("")) {
							homel = (long) 0;
						}else {
							homel = home;
							String grd13 = CommonGradeUtils.groupAGrade(homel);
						    hompnts = CommonGradeUtils.pointsA(grd13);
							e.setHom_pnts(hompnts);
							e.setHom_grade(grd13);
							e.setHom_remarks(CommonGradeUtils.remarks(grd13));
						}
						Long tot = (
								engel + kisel + mathel + bioel + chemel + phyel + geoel + hisel + creel + agricel + bizel + compel + homel
								);
						e.setTt(tot);
						
						
						long one = tot/13;  // getting average
						//long pnts = ((tot/1300)*84);
						String two = Long.toString(one);  //changing average to string						
						String grade_val = CommonGradeUtils.averageGrade(one);						
						String aver = String.format("%.0f", Double.parseDouble(two));
						e.setAvg(Long.parseLong(aver));				
						e.setOv_grade(grade_val);
						e.setPoints(CommonGradeUtils.points(grade_val));
				
				e.setPri_remarks(CommonGradeUtils.remarks_class_prinzy(grade_val));
				e.setClsT_remarks(CommonGradeUtils.remarks_class_teacher(grade_val));
					}
				return e;
			}
			
    	});
    	return list;
	}
	@Override
	public int[] update_tt_avgs(List<FormOneMarks_Report_Process> up_all) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(up_all.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(sql_up_all,batch);        		
        	      return crankCounts;
	}
	@Override
	public List<FormOneMarks> rankList_ave() {
		List<FormOneMarks> list = namedParameterJdbcTemplate.query(SQL_RANK_PER_CLASS_AVG, new RowMapper<FormOneMarks>() {
			@Override
			public FormOneMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks c_rank = new FormOneMarks();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setCrank(rs.getString("crank"));
				return c_rank;
			}
		});
		return list;
	}
	@Override
	public int[] c_rnk_average(List<FormOneMarks> crankAvg) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update formonemarksreportprocess set regno = :regno,crank = :crank where regno = :regno",batch);        		
        	      return crankCounts;
	}	
	@Override
	public List<FormOneMarks_Report_Process> rank_av() {
		List<FormOneMarks_Report_Process> list = namedParameterJdbcTemplate.query(SQL_RANK_ave, new RowMapper<FormOneMarks_Report_Process>() {

			@Override
			public FormOneMarks_Report_Process mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks_Report_Process c_rank = new FormOneMarks_Report_Process();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setRank(rs.getString("rank"));
				return c_rank;
			}
		});
		return list;
	}
	@Override
	public int[] rnk_average(List<FormOneMarks_Report_Process> crankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update formonemarksreportprocess set rank = :rank where regno = :regno",batch);        		
        	      return crankCounts;
	}
	@Override
	public List<FormOneMarks_Report_Process> selectAvToBackUp() {		
		List<FormOneMarks_Report_Process> list = namedParameterJdbcTemplate.query(SQL_ALL_process, new RowMapper<FormOneMarks_Report_Process>() {
			@Override
			public FormOneMarks_Report_Process mapRow(ResultSet rs, int rowNum) throws SQLException {
				FormOneMarks_Report_Process s_all = new FormOneMarks_Report_Process();
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
				s_all.setOv_grade(rs.getString("ov_grade"));
				
				//s_all.setOv_pnts_grade(rs.getString("ov_pnts_grade"));
				//s_all.setOv_pnts(rs.getString("ov_pnts"));
				s_all.setPoints(rs.getLong("points"));
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
	public int[] bchAverageToBackUp(List<FormOneMarks_Report_Process> backup) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		qsl_copy_to_tableBACKUP_av,batch);
        		
        	      return crankCounts;
		}

	@Override
	public int[] deleteAl(List<FormOneMarks_Report_Process> backup) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(clear_all,batch);
        		
        	      return crankCounts;
	}
	
}
