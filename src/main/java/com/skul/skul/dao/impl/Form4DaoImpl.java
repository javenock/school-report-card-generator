package com.skul.skul.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
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

import com.skul.skul.dao.Form4Dao;
import com.skul.skul.dao.FormThreeDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormOneMarks_Report_Process;
import com.skul.skul.model.Form4MarksEntry;
import com.skul.skul.model.Form4basebackup;
import com.skul.skul.model.Form4marksreportprocess;
import com.skul.skul.model.Student;
import com.skul.skul.utils.CommonGradeUtils;
import com.skul.skul.utils.CommonGradeUtils_f3_and_f4;
@Repository
public class Form4DaoImpl implements Form4Dao{
	String NULL = null;

	final String SQL_SELECT_language_STRM = "SELECT student.regno,student.stream,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.eng FROM student, Form4MarksEntry WHERE student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_kis_STRM = "SELECT student.regno,student.stream,student.kiswahili,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.kis FROM student, Form4MarksEntry WHERE student.kiswahili = 'KISWAHILI' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_math_STRM = "SELECT student.regno,student.stream,student.mathematics,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.math FROM student, Form4MarksEntry WHERE student.mathematics = 'MATHEMATICS' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_bio_STRM = "SELECT student.regno,student.stream,student.biology,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.bio FROM student, Form4MarksEntry WHERE student.biology = 'BIOLOGY' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_chem_STRM = "SELECT student.regno,student.stream,student.chemistry,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.chem FROM student, Form4MarksEntry WHERE student.chemistry = 'CHEMISTRY' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_phy_STRM = "SELECT student.regno,student.stream,student.physics,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.phy FROM student, Form4MarksEntry WHERE student.physics = 'PHYSICS' AND student.regno = Form4MarksEntry.regno";
		
	final String SQL_SELECT_geo_STRM = "SELECT student.regno,student.stream,student.geography,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.geo FROM student, Form4MarksEntry WHERE student.geography = 'GEOGRAPHY' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_his_STRM = "SELECT student.regno,student.stream,student.history,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.his FROM student, Form4MarksEntry WHERE student.history = 'HISTORY' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_cre_STRM = "SELECT student.regno,student.stream,Form4MarksEntry.cre FROM student, Form4MarksEntry WHERE student.cre = 'CRE' AND student.regno = Form4MarksEntry.regno";
				
	final String SQL_SELECT_agric_STRM = "SELECT student.regno,student.stream,student.agriculture,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.agric FROM student, Form4MarksEntry WHERE student.agriculture = 'AGRICULTURE' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_biz_STRM = "SELECT student.regno,student.stream,student.business,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.biz FROM student, Form4MarksEntry WHERE student.business = 'BUSINESS' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_comp_STRM = "SELECT student.regno,student.stream,student.computer,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.comp FROM student, Form4MarksEntry WHERE student.computer = 'COMPUTER' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_SELECT_hom_STRM = "SELECT student.regno,student.stream,student.homescience,Form4MarksEntry.regno,Form4MarksEntry.stream,Form4MarksEntry.hom FROM student, Form4MarksEntry WHERE student.homescience = 'HOMESCIENCE' AND student.regno = Form4MarksEntry.regno";
	
	final String SQL_COPY_STD = "SELECT regno,form,stream,year from student where form ='FOUR' ";
	
	final String qsl_copy_to_marks = "INSERT INTO Form4MarksEntry(regno,form,stream,year) VALUES (:regno,:form,:stream,:year)";
	
	final String SQL_GET_ALL = "select regno, eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt FROM Form4MarksEntry group by regno";
	
	final String SQL_UPDATE_TT = "update Form4MarksEntry set eng_grade = :eng_grade,eng_pnts = :eng_pnts,math_grade = :math_grade,math_pnts = :math_pnts,kis_grade = :kis_grade,kis_pnts = :kis_pnts,bio_grade = :bio_grade,bio_pnts = :bio_pnts,chem_grade = :chem_grade,chem_pnts = :chem_pnts, phy_grade = :phy_grade,phy_pnts = :phy_pnts,geo_grade = :geo_grade,geo_pnts = :geo_pnts,his_grade = :his_grade,his_pnts = :his_pnts,cre_grade = :cre_grade,cre_pnts = :cre_pnts,agric_grade = :agric_grade,agric_pnts = :agric_pnts,biz_grade = :biz_grade,biz_pnts = :biz_pnts,hom_grade = :hom_grade,hom_pnts = :hom_pnts,comp_grade = :comp_grade,comp_pnts = :comp_pnts, tt = :tt,points = :points,ov_pnts = :ov_pnts,ov_pnts_grade = :ov_pnts_grade where regno = :regno"; 
	
	final String SQL_RANK_PER_CLASS = "SELECT Form4MarksEntry.regno, COUNT( lesser.regno ) +1 AS crank FROM Form4MarksEntry LEFT JOIN Form4MarksEntry AS lesser ON lesser.ov_pnts > Form4MarksEntry.ov_pnts AND lesser.stream = Form4MarksEntry.stream GROUP BY Form4MarksEntry.regno";
	
	final String SQL_RANK_average = "SELECT regno,ov_pnts, RANK() OVER (ORDER BY ov_pnts DESC) from Form4MarksEntry";
	
	final String qsl_copy_to_tableBACKUP = "INSERT INTO Form4basebackup(regno,form,stream,examtype,term,year,math,eng,kis,eng_grade,math_grade,kis_grade,bio,bio_grade,chem,chem_grade,phy, phy_grade,geo,geo_grade,his,his_grade,cre, cre_grade,agric,agric_grade,biz,biz_grade,hom,hom_grade,comp,comp_grade,tt,ov_pnts,ov_pnts_grade,rank,crank) VALUES (:regno,:form,:stream,:examtype,:term,:year,:math,:eng,:kis,:eng_grade,:math_grade,:kis_grade,:bio,:bio_grade,:chem,:chem_grade,:phy, :phy_grade,:geo,:geo_grade,:his,:his_grade,:cre, :cre_grade,:agric,:agric_grade,:biz,:biz_grade,:hom,:hom_grade,:comp,:comp_grade,:tt,:ov_pnts,:ov_pnts_grade,:rank,:crank)";
	
	final String sql_findone_k  = "SELECT regno,stream,term,year,ROUND(avg(COALESCE(CAST(eng AS DOUBLE PRECISION),0))) AS eng,ROUND(avg(COALESCE(CAST(kis AS DOUBLE PRECISION),0))) AS kis,ROUND(avg(COALESCE(CAST(math AS DOUBLE PRECISION),0))) AS math,ROUND(avg(COALESCE(CAST(bio AS DOUBLE PRECISION),0))) AS bio,ROUND(avg(COALESCE(CAST(chem AS DOUBLE PRECISION),0))) AS chem,ROUND(avg(COALESCE(CAST(phy AS DOUBLE PRECISION),0))) AS phy,ROUND(avg(COALESCE(CAST(geo AS DOUBLE PRECISION),0))) AS geo,ROUND(avg(COALESCE(CAST(his AS DOUBLE PRECISION),0))) AS his,ROUND(avg(COALESCE(CAST(cre AS DOUBLE PRECISION),0))) AS cre,ROUND(avg(COALESCE(CAST(agric AS DOUBLE PRECISION),0))) AS agric,ROUND(avg(COALESCE(CAST(biz AS DOUBLE PRECISION),0))) AS biz,ROUND(avg(COALESCE(CAST(comp AS DOUBLE PRECISION),0))) AS comp,ROUND(avg(COALESCE(CAST(hom AS DOUBLE PRECISION),0))) AS hom  FROM Form4basebackup WHERE year = :year AND term = :term GROUP BY regno,stream,term,year";
	
	final String qsl_copy_to_table1 = "INSERT INTO Form4marksreportprocess(regno,stream,year,term,eng,math,kis,bio,chem,phy,geo,his,cre,agric,biz,comp,hom) VALUES (:regno,:stream,:year,:term,:eng,:math,:kis,:bio,:chem,:phy,:geo,:his,:cre,:agric,:biz,:comp,:hom)";

	final String SQL_GET_ALL_avg = "select regno, eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt FROM Form4marksreportprocess group by regno,eng, kis,math,bio,chem,phy,geo,his,cre,agric,biz,comp,hom,avg,tt";
	
	final String SQL_UPDATE_TT_avg = "update Form4marksreportprocess set eng_grade = :eng_grade,eng_pnts = :eng_pnts,eng_remarks = :eng_remarks,math_grade = :math_grade,math_pnts = :math_pnts,math_remarks = :math_remarks,kis_grade = :kis_grade,kis_pnts = :kis_pnts,kis_remarks = :kis_remarks,bio_grade = :bio_grade,bio_pnts = :bio_pnts,bio_remarks = :bio_remarks,chem_grade = :chem_grade,chem_pnts = :chem_pnts,chem_remarks = :chem_remarks,phy_grade = :phy_grade,phy_pnts = :phy_pnts,phy_remarks = :phy_remarks,geo_grade = :geo_grade,geo_pnts = :geo_pnts,geo_remarks = :geo_remarks,his_grade = :his_grade,his_pnts = :his_pnts,his_remarks = :his_remarks,cre_grade = :cre_grade,cre_pnts = :cre_pnts,cre_remarks = :cre_remarks,agric_grade = :agric_grade,agric_pnts = :agric_pnts,agric_remarks = :agric_remarks,biz_grade = :biz_grade,biz_pnts = :biz_pnts,biz_remarks = :biz_remarks,hom_grade = :hom_grade,hom_pnts = :hom_pnts,hom_remarks = :hom_remarks,comp_grade = :comp_grade,comp_pnts = :comp_pnts,comp_remarks = :comp_remarks, tt = :tt,ov_pnts = :ov_pnts,ov_pnts_grade = :ov_pnts_grade,points = :points, pri_remarks = :pri_remarks,ClsT_remarks = :ClsT_remarks  where regno = :regno"; 
	
	final String SQL_RANK_average_f3 = "SELECT regno,ov_pnts, RANK() OVER (ORDER BY ov_pnts DESC) from Form4marksreportprocess";
	
	final String SQL_RANK_PER_CLASS_f3 = "SELECT Form4marksreportprocess.regno, COUNT( lesser.regno ) +1 AS crank FROM Form4marksreportprocess LEFT JOIN Form4marksreportprocess AS lesser ON lesser.ov_pnts > Form4marksreportprocess.ov_pnts AND lesser.stream = Form4marksreportprocess.stream GROUP BY Form4marksreportprocess.regno";
	
	final String qsl_copy_to_tableBACKUP_av = "INSERT INTO Form4marksbackup(regno,form,stream,term,year,math,eng,kis,eng_grade,eng_pnts,eng_pos,eng_remarks,math_grade,math_pnts,math_pos,math_remarks,kis_grade,kis_pnts,kis_pos,kis_remarks,bio,bio_grade,bio_pnts,bio_pos,bio_remarks,chem,chem_grade,chem_pnts,chem_pos,chem_remarks,phy, phy_grade,phy_pnts,phy_pos,phy_remarks,geo,geo_grade,geo_pnts,geo_pos,geo_remarks,his,his_grade,his_pnts,his_pos,his_remarks,cre, cre_grade,cre_pnts,cre_pos,cre_remarks,agric,agric_grade,agric_pnts,agric_pos,agric_remarks,biz,biz_grade,biz_pnts,biz_pos,biz_remarks,hom,hom_grade,hom_pnts,hom_pos,hom_remarks,comp,comp_grade,comp_pnts,comp_pos,comp_remarks,tt,avg,ov_pnts,points,ov_grade,ov_pnts_grade,rank,crank,pri_remarks,ClsT_remarks) "
			+ "VALUES (:regno,:form,:stream,:term,:year,:math,:eng,:kis,:eng_grade,:eng_pnts,:eng_pos,:eng_remarks,:math_grade,:math_pnts,:math_pos,:math_remarks,:kis_grade,:kis_pnts,:kis_pos,:kis_remarks,:bio,:bio_grade,:bio_pnts,:bio_pos,:bio_remarks,:chem,:chem_grade,:chem_pnts,:chem_pos,:chem_remarks,:phy, :phy_grade,:phy_pnts,:phy_pos,:phy_remarks,:geo,:geo_grade,:geo_pnts,:geo_pos,:geo_remarks,:his,:his_grade,:his_pnts,:his_pos,:his_remarks,:cre, :cre_grade,:cre_pnts,:cre_pos,:cre_remarks,:agric,:agric_grade,:agric_pnts,:agric_pos,:agric_remarks,:biz,:biz_grade,:biz_pnts,:biz_pos,:biz_remarks,:hom,:hom_grade,:hom_pnts,:hom_pos,:hom_remarks,:comp,:comp_grade,:comp_pnts,:comp_pos,:comp_remarks,:tt,:avg,:ov_pnts,:points,:ov_grade,:ov_pnts_grade,:rank,:crank,:pri_remarks,:ClsT_remarks)";
	
	final String clear_all = "DELETE FROM Form4marksreportprocess";
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
    public void update(Form4MarksEntry e) {
		 final String UPDATE_QUERY = "update Form4MarksEntry set eng = :eng where regno = :regno";
		    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("eng", e.getEng()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       
    }
	
	@Override  //load english for input operation
	public List<Form4MarksEntry> select_eng_ByStream() {
			
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_language_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setEng(rs.getLong("eng"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public List<Form4MarksEntry> select_geo_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_geo_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setGeo(rs.getLong("geo"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_geo(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set geo = :geo where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("geo", e.getGeo()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}	
	
	@Override
	public List<Form4MarksEntry> select_his_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_his_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setHis(rs.getLong("his"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_his(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set his = :his where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("his", e.getHis()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_kis_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_kis_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setKis(rs.getLong("kis"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_kis(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set kis = :kis where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("kis", e.getKis()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       			
	}

	@Override
	public List<Form4MarksEntry> select_math_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_math_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setMath(rs.getLong("math"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_math(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set math = :math where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("math", e.getMath()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_bio_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_bio_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setBio(rs.getLong("bio"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_bio(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set bio = :bio where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("bio", e.getBio()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_chem_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_chem_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setChem(rs.getLong("chem"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_chem(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set chem = :chem where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("chem", e.getChem()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_phy_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_phy_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setPhy(rs.getLong("phy"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_phy(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set phy = :phy where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("phy", e.getPhy()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_cre_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_cre_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setCre(rs.getLong("cre"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_cre(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set cre = :cre where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("cre", e.getCre()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_agric_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_agric_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setAgric(rs.getLong("agric"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_agric(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set agric = :agric where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("agric", e.getAgric()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_biz_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_biz_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setBiz(rs.getLong("biz"));
				return s_all;
			}
			
		});
		return list;
	}

	@Override
	public void update_biz(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set biz = :biz where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("biz", e.getBiz()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
	}

	@Override
	public List<Form4MarksEntry> select_comp_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_comp_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setComp(rs.getLong("comp"));
				return s_all;
			}			
		});
		return list;
	}
	@Override
	public void update_comp(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set comp = :comp where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("comp", e.getComp()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);        		
	}
	@Override
	public List<Form4MarksEntry> select_hom_ByStream() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_SELECT_hom_STRM, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry s_all = new Form4MarksEntry();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setStream(rs.getString("stream"));
				s_all.setHom(rs.getLong("hom"));
				return s_all;
			}			
		});
		return list;
	}
	@Override
	public void update_hom(Form4MarksEntry e) {
		final String UPDATE_QUERY = "update Form4MarksEntry set hom = :hom where regno = :regno";
	    
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("hom", e.getHom()).addValue("regno", e.getRegno());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters); 
       		
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
	      String query = "UPDATE Form4MarksEntry SET examtype ='" + exmtype +"' "; // where form = 'one' ";
	      this.namedParameterJdbcTemplate.update(query,params);
	 }

	@Override
	public void updateTerm(String term) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("term", term);
	      String query = "UPDATE Form4MarksEntry SET term ='" + term +"' ";// where form = 'one' ";
	      this.namedParameterJdbcTemplate.update(query,params);		
	}
	
	@Override
	public List<Form4MarksEntry> sumup() {
		
		//get the best subject from goup 3
		//get the best subject from either group 2,3,4 or 5.
		
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_GET_ALL, new RowMapper<Form4MarksEntry>() {
			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Long enge;Long kise;Long mathe; Long bioe ;Long cheme ;Long phye ;Long geoe ;Long hise ;Long cree ;Long agrice;
				Long bize;Long compe ;Long home ;	
				
				Long engel; Long kisel; Long mathel; Long bioel ;Long chemel ;Long phyel ; Long geoel;Long hisel; Long creel;Long agricel;
				Long bizel; Long compel;Long homel;
				
				Long engpnts = (long) 0;Long kispnts = (long) 0;Long mathpnts = (long) 0; Long biopnts = (long) 0; Long chempnts = (long) 0;Long phypnts = (long) 0;Long geopnts = (long) 0; Long hispnts = (long) 0; Long crepnts = (long) 0; Long agricpnts = (long) 0;
				Long bizpnts = (long) 0;Long comppnts = (long) 0;Long hompnts = (long) 0 ;	
				
				
				Form4MarksEntry e = new Form4MarksEntry();					
				e.setRegno(rs.getLong("regno"));
							
				 enge = rs.getLong("eng"); kise = rs.getLong("kis"); mathe = rs.getLong("math"); bioe = rs.getLong("bio"); cheme = rs.getLong("chem");
				 phye = rs.getLong("phy"); geoe = rs.getLong("geo"); hise = rs.getLong("his"); cree = rs.getLong("cre"); agrice = rs.getLong("agric");
				 bize = rs.getLong("biz"); compe = rs.getLong("comp"); home = rs.getLong("hom");			
				
				 if(enge == 0 && kise == 0 && mathe == 0 && bioe == 0 && cheme == 0 && phye == 0 &&
							geoe == 0 && hise == 0 && cree == 0 && agrice == 0 && bize == 0 && compe == 0 && home == 0) {
							
				 e.setTt((long) 0);
					e.setAvg((long) 0);
					e.setOv_grade("Z");
					e.setOv_pnts((long) 0);
				} 
				else {
					//get group one subjects
					if(enge.equals("null")||enge.equals("")) {
						engel = (long) 0;
					}else {
						engel = enge;
						String grd1 = CommonGradeUtils_f3_and_f4.groupAGrade(engel);
						
						engpnts = CommonGradeUtils_f3_and_f4.pointsA(grd1);
						e.setEng_pnts(engpnts);
						e.setEng_grade(grd1);
					}
					if(kise.equals("null")||kise.equals("")) {
						kisel = (long) 0;
					}else {
						kisel = kise;
						String grd2 = CommonGradeUtils_f3_and_f4.groupAGrade(kisel);
						kispnts = CommonGradeUtils_f3_and_f4.pointsA(grd2);
						e.setKis_pnts(kispnts);
						e.setKis_grade(grd2);
					}
					if(mathe.equals("") || mathe.equals("null")) {
						mathel = (long) 0;
					}else {
						mathel = mathe;
						String grd3 = CommonGradeUtils_f3_and_f4.groupAGrade(mathel);
						mathpnts = CommonGradeUtils_f3_and_f4.pointsA(grd3);
						e.setMath_pnts(mathpnts);
						e.setMath_grade(grd3);
					}
					
//get the best first two subjects from group 2
						
					if(bioe.equals("null")||bioe.equals("")) {
						bioel = (long) 0;
					}else {
						bioel = bioe;
						String grd4 = CommonGradeUtils_f3_and_f4.groupAGrade(bioel);
						biopnts = CommonGradeUtils_f3_and_f4.pointsA(grd4);
						e.setBio_pnts(biopnts);
						e.setBio_grade(grd4);
					
					}
					if(cheme.equals("null")||cheme.equals("")) {
						chemel = (long) 0;
					}else {
						chemel = cheme;
						String grd5 = CommonGradeUtils_f3_and_f4.groupAGrade(chemel);
						chempnts = CommonGradeUtils_f3_and_f4.pointsA(grd5);
						e.setChem_pnts(chempnts);
						e.setChem_grade(grd5);
					
					}
					if(phye.equals("null")||phye.equals("")) {
						phyel = (long) 0;
					}else {
						phyel = phye;
						String grd6 = CommonGradeUtils_f3_and_f4.groupAGrade(phyel);
						phypnts = CommonGradeUtils_f3_and_f4.pointsA(grd6);
						e.setPhy_pnts(phypnts);
						e.setPhy_grade(grd6);
					
					}		
					
								
//get the best highest value from group 3
					
					if(geoe.equals(NULL)||geoe.equals("")) {
						geoel = (long) 0;
					}else {
						geoel = geoe;
						String grd7 = CommonGradeUtils_f3_and_f4.groupAGrade(geoel);
						geopnts = CommonGradeUtils_f3_and_f4.pointsA(grd7);
						e.setGeo_pnts(geopnts);
						e.setGeo_grade(grd7);
					}
					if(hise.equals(NULL)||hise.equals("")) {
						hisel = (long) 0;
					}else {
						hisel = hise;
						String grd8 = CommonGradeUtils_f3_and_f4.groupAGrade(hisel);
						hispnts = CommonGradeUtils_f3_and_f4.pointsA(grd8);
						e.setHis_pnts(hispnts);
						e.setHis_grade(grd8);
					}
					if(cree.equals(NULL)||cree.equals("")) {
						creel = (long) 0;
					}else {
						creel = cree;
						String grd9 = CommonGradeUtils_f3_and_f4.groupAGrade(creel);
						crepnts = CommonGradeUtils_f3_and_f4.pointsA(grd9);
						e.setCre_pnts(crepnts);
						e.setCre_grade(grd9);
					}
										
//get the best highest value from group 4
					
					if(agrice.equals(NULL)||agrice.equals("")) {
						agricel = (long) 0;
					}else {
						agricel = agrice;
						String grd10 = CommonGradeUtils_f3_and_f4.groupAGrade(agricel);
						agricpnts = CommonGradeUtils_f3_and_f4.pointsA(grd10);
						e.setAgric_pnts(agricpnts);
						e.setAgric_grade(grd10);
					}
					if(bize.equals(NULL)||bize.equals("")) {
						bizel = (long) 0;
					}else {
						bizel = bize;
						String grd11 = CommonGradeUtils_f3_and_f4.groupAGrade(bizel);
						bizpnts = CommonGradeUtils_f3_and_f4.pointsA(grd11);
						e.setBiz_pnts(bizpnts);
						e.setBiz_grade(grd11);
					}
					if(compe.equals(NULL)||compe.equals("")) {
						compel = (long) 0;
					}else {
						compel = compe;
						String grd12 = CommonGradeUtils_f3_and_f4.groupAGrade(compel);
						comppnts = CommonGradeUtils_f3_and_f4.pointsA(grd12);
						e.setComp_pnts(comppnts);
						e.setComp_grade(grd12);
					}
					if(home.equals(NULL)||home.equals("")) {
						homel = (long) 0;
					}else {
						homel = home;
						String grd13 = CommonGradeUtils_f3_and_f4.groupAGrade(homel);
					    hompnts = CommonGradeUtils_f3_and_f4.pointsA(grd13);
						e.setHom_pnts(hompnts);
						e.setHom_grade(grd13);
					}
					
					
					Long[] group2 = {bioel,chemel,phyel};
					Arrays.sort(group2);
					Long first_val = group2[group2.length - 1];
					Long second_val = group2[group2.length - 2];
					Long third_val = group2[0];					
											Long group_two_sum = first_val + second_val;
											
											Long[] group2_pnts = {biopnts,chempnts,phypnts};
											Arrays.sort(group2_pnts);
											Long first_val_pnts = group2_pnts[group2_pnts.length - 1];
											Long second_val_pnts = group2_pnts[group2_pnts.length - 2];
											Long third_val_pnts = group2_pnts[0];					
																	Long group_two_sum_pnts = first_val_pnts + second_val_pnts;
											
											
					
					Long[] group3 = {geoel,hisel,creel};
					Arrays.sort(group3);
					Long grp3_first_val = group3[group3.length - 1];
					Long grp3_second_val = group3[group3.length - 2];
					Long group_three_sum = grp3_first_val ;
					
					Long[] group3_pnts = {geopnts,hispnts,crepnts};
					Arrays.sort(group3_pnts);
					Long grp3_first_val_pnts = group3_pnts[group3_pnts.length - 1];
					Long grp3_second_val_pnts = group3_pnts[group3_pnts.length - 2];
					Long group_three_sum_pnts = grp3_first_val_pnts ;
					
					Long[] group4 = {third_val,grp3_second_val,agricel,bizel,compel,homel};
					Arrays.sort(group4);
					Long grp4_first_val = group4[group4.length - 1];
						
					Long[] group4_pnts = {third_val_pnts,grp3_second_val_pnts,agricpnts,bizpnts,comppnts,hompnts};
					Arrays.sort(group4_pnts);
					Long grp4_first_val_pnts = group4_pnts[group4_pnts.length - 1];
					
					
					Long etoto = engel + kisel + mathel  + group_two_sum + group_three_sum + grp4_first_val;	
					Long pnts_total = engpnts + kispnts + mathpnts  + group_two_sum_pnts + group_three_sum_pnts + grp4_first_val_pnts;	
					String grad_ttpnts = CommonGradeUtils_f3_and_f4.averageGrade(pnts_total);
					Long pnts = CommonGradeUtils_f3_and_f4.points(grad_ttpnts);
					e.setOv_pnts(pnts_total);
					e.setOv_pnts_grade(grad_ttpnts);
					e.setPoints(pnts);
					e.setTt(etoto);
					
					
					
				}
				return e;
			}
		});
		return list;
		
		
		
	}	
	@Override
	public int[] batchUpdate_FormThree_tt(List<Form4MarksEntry> form_tt) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(form_tt.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(SQL_UPDATE_TT,batch);
        return updateCounts;
	}
	
	@Override
	public List<Form4MarksEntry> rankList() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_RANK_PER_CLASS, new RowMapper<Form4MarksEntry>() {

			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry c_rank = new Form4MarksEntry();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setCrank(rs.getString("crank"));
				return c_rank;
			}
		});
		return list;
			}

	@Override
	public int[] c_rank(List<Form4MarksEntry> crank) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crank.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4MarksEntry set crank = :crank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	@Override
	public List<Form4MarksEntry> rank_ave() {
		List<Form4MarksEntry> list = namedParameterJdbcTemplate.query(SQL_RANK_average, new RowMapper<Form4MarksEntry>() {

			@Override
			public Form4MarksEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4MarksEntry c_rank = new Form4MarksEntry();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setRank(rs.getString("rank"));
				return c_rank;
			}
		});
		return list;
	}
	@Override
	public int[] rank_average(List<Form4MarksEntry> crankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4MarksEntry set rank = :rank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	
	@Override
	public int[] batchAverageToBackUp(List<Form4MarksEntry> backup) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		qsl_copy_to_tableBACKUP,batch);
        		
        	      return crankCounts;
		}
	
	@Override
	public List<Form4basebackup> select_avgs(String year, String term) {
		
		List<Form4basebackup> list = namedParameterJdbcTemplate.query(sql_findone_k, new MapSqlParameterSource().addValue("year", year).addValue("term", term), new RowMapper<Form4basebackup>() {
			@Override
			public Form4basebackup mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4basebackup s_all = new Form4basebackup();
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
	public int[] copyAvg(List<Form4basebackup> copy_all) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(copy_all.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(qsl_copy_to_table1,batch);
        		
        	      return crankCounts;
	}
	
	@Override
	public List<Form4marksreportprocess> _form4_tt() {
		
		//get the best subject from goup 3
		//get the best subject from either group 2,3,4 or 5.
		
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_GET_ALL_avg, new RowMapper<Form4marksreportprocess>() {
			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Long enge;Long kise;Long mathe; Long bioe ;Long cheme ;Long phye ;Long geoe ;Long hise ;Long cree ;Long agrice;
				Long bize;Long compe ;Long home ;	
				
				Long engel; Long kisel; Long mathel; Long bioel ;Long chemel ;Long phyel ; Long geoel;Long hisel; Long creel;Long agricel;
				Long bizel; Long compel;Long homel;
				
				Long engpnts = (long) 0;Long kispnts = (long) 0;Long mathpnts = (long) 0; Long biopnts = (long) 0; Long chempnts = (long) 0;Long phypnts = (long) 0;Long geopnts = (long) 0; Long hispnts = (long) 0;Long crepnts = (long) 0; Long agricpnts = (long) 0;
				Long bizpnts = (long) 0;Long comppnts = (long) 0;Long hompnts = (long) 0;	
				
				
				Form4marksreportprocess e = new Form4marksreportprocess();					
				e.setRegno(rs.getLong("regno"));
							
				 enge = rs.getLong("eng"); kise = rs.getLong("kis"); mathe = rs.getLong("math"); bioe = rs.getLong("bio"); cheme = rs.getLong("chem");
				 phye = rs.getLong("phy"); geoe = rs.getLong("geo"); hise = rs.getLong("his"); cree = rs.getLong("cre"); agrice = rs.getLong("agric");
				 bize = rs.getLong("biz"); compe = rs.getLong("comp"); home = rs.getLong("hom");			
				
				 if(enge == 0 && kise == 0 && mathe == 0 && bioe == 0 && cheme == 0 && phye == 0 &&
							geoe == 0 && hise == 0 && cree == 0 && agrice == 0 && bize == 0 && compe == 0 && home == 0) {
							
				 e.setTt((long) 0);
					e.setAvg((long) 0);
					e.setOv_grade("Z");
				} 
				else {
					//get group one subjects
					if(enge.equals("null")||enge.equals("")) {
						engel = (long) 0;
					}else {
						engel = enge;
						String grd1 = CommonGradeUtils_f3_and_f4.groupAGrade(engel);						
						engpnts = CommonGradeUtils_f3_and_f4.pointsA(grd1);
						e.setEng_pnts(engpnts);
						e.setEng_grade(grd1);
						e.setEng_remarks(CommonGradeUtils_f3_and_f4.remarks(grd1));
					}
					if(kise.equals("null")||kise.equals("")) {
						kisel = (long) 0;
					}else {
						kisel = kise;
						String grd2 = CommonGradeUtils_f3_and_f4.groupAGrade(kisel);
						kispnts = CommonGradeUtils_f3_and_f4.pointsA(grd2);
						e.setKis_pnts(kispnts);
						e.setKis_grade(grd2);
						e.setKis_remarks(CommonGradeUtils_f3_and_f4.remarks(grd2));
					}
					if(mathe.equals("") || mathe.equals("null")) {
						mathel = (long) 0;
					}else {
						mathel = mathe;
						String grd3 = CommonGradeUtils_f3_and_f4.groupAGrade(mathel);
						mathpnts = CommonGradeUtils_f3_and_f4.pointsA(grd3);
						e.setMath_pnts(mathpnts);
						e.setMath_grade(grd3);
						e.setMath_remarks(CommonGradeUtils_f3_and_f4.remarks(grd3));
					}
					
//get the best first two subjects from group 2
						
					if(bioe.equals("null")||bioe.equals("")) {
						bioel = (long) 0;
					}else {
						bioel = bioe;
						String grd4 = CommonGradeUtils_f3_and_f4.groupAGrade(bioel);
						biopnts = CommonGradeUtils_f3_and_f4.pointsA(grd4);
						e.setBio_pnts(biopnts);
						e.setBio_grade(grd4);
						e.setBio_remarks(CommonGradeUtils_f3_and_f4.remarks(grd4));
					}
					if(cheme.equals("null")||cheme.equals("")) {
						chemel = (long) 0;
					}else {
						chemel = cheme;
						String grd5 = CommonGradeUtils_f3_and_f4.groupAGrade(chemel);
						chempnts = CommonGradeUtils_f3_and_f4.pointsA(grd5);
						e.setChem_pnts(chempnts);
						e.setChem_grade(grd5);
						e.setChem_remarks(CommonGradeUtils.remarks(grd5));
					}
					if(phye.equals("null")||phye.equals("")) {
						phyel = (long) 0;
					}else {
						phyel = phye;
						String grd6 = CommonGradeUtils_f3_and_f4.groupAGrade(phyel);
						phypnts = CommonGradeUtils_f3_and_f4.pointsA(grd6);
						e.setPhy_pnts(phypnts);
						e.setPhy_grade(grd6);
						e.setPhy_remarks(CommonGradeUtils.remarks(grd6));
					}		
					
								
//get the best highest value from group 3
					
					if(geoe.equals(NULL)||geoe.equals("")) {
						geoel = (long) 0;
					}else {
						geoel = geoe;
						String grd7 = CommonGradeUtils_f3_and_f4.groupAGrade(geoel);
						geopnts = CommonGradeUtils_f3_and_f4.pointsA(grd7);
						e.setGeo_pnts(geopnts);
						e.setGeo_grade(grd7);
						e.setGeo_remarks(CommonGradeUtils.remarks(grd7));
					}
					if(hise.equals(NULL)||hise.equals("")) {
						hisel = (long) 0;
					}else {
						hisel = hise;
						String grd8 = CommonGradeUtils_f3_and_f4.groupAGrade(hisel);
						hispnts = CommonGradeUtils_f3_and_f4.pointsA(grd8);
						e.setHis_pnts(hispnts);
						e.setHis_grade(grd8);
						e.setHis_remarks(CommonGradeUtils.remarks(grd8));
					}
					if(cree.equals(NULL)||cree.equals("")) {
						creel = (long) 0;
					}else {
						creel = cree;
						String grd9 = CommonGradeUtils_f3_and_f4.groupAGrade(creel);
						crepnts = CommonGradeUtils_f3_and_f4.pointsA(grd9);
						e.setCre_pnts(crepnts);
						e.setCre_grade(grd9);
						e.setCre_remarks(CommonGradeUtils.remarks(grd9));
					}
										
//get the best highest value from group 4
					
					if(agrice.equals(NULL)||agrice.equals("")) {
						agricel = (long) 0;
					}else {
						agricel = agrice;
						String grd10 = CommonGradeUtils_f3_and_f4.groupAGrade(agricel);
						agricpnts = CommonGradeUtils_f3_and_f4.pointsA(grd10);
						e.setAgric_pnts(agricpnts);
						e.setAgric_grade(grd10);
						e.setAgric_remarks(CommonGradeUtils.remarks(grd10));
					}
					if(bize.equals(NULL)||bize.equals("")) {
						bizel = (long) 0;
					}else {
						bizel = bize;
						String grd11 = CommonGradeUtils_f3_and_f4.groupAGrade(bizel);
						bizpnts = CommonGradeUtils_f3_and_f4.pointsA(grd11);
						e.setBiz_pnts(bizpnts);
						e.setBiz_grade(grd11);
						e.setBiz_remarks(CommonGradeUtils.remarks(grd11));
					}
					if(compe.equals(NULL)||compe.equals("")) {
						compel = (long) 0;
					}else {
						compel = compe;
						String grd12 = CommonGradeUtils_f3_and_f4.groupAGrade(compel);
						comppnts = CommonGradeUtils_f3_and_f4.pointsA(grd12);
						e.setComp_pnts(comppnts);
						e.setComp_grade(grd12);
						e.setComp_remarks(CommonGradeUtils.remarks(grd12));
					}
					if(home.equals(NULL)||home.equals("")) {
						homel = (long) 0;
					}else {
						homel = home;
						String grd13 = CommonGradeUtils_f3_and_f4.groupAGrade(homel);
					    hompnts = CommonGradeUtils_f3_and_f4.pointsA(grd13);
						e.setHom_pnts(hompnts);
						e.setHom_grade(grd13);
						e.setHom_remarks(CommonGradeUtils.remarks(grd13));
					}
					
					
					Long[] group2 = {bioel,chemel,phyel};
					Arrays.sort(group2);
					Long first_val = group2[group2.length - 1];
					Long second_val = group2[group2.length - 2];
					Long third_val = group2[0];					
											Long group_two_sum = first_val + second_val;
											
											Long[] group2_pnts = {biopnts,chempnts,phypnts};
											Arrays.sort(group2_pnts);
											Long first_val_pnts = group2_pnts[group2_pnts.length - 1];
											Long second_val_pnts = group2_pnts[group2_pnts.length - 2];
											Long third_val_pnts = group2_pnts[0];					
																	Long group_two_sum_pnts = first_val_pnts + second_val_pnts;
											
											
					
					Long[] group3 = {geoel,hisel,creel};
					Arrays.sort(group3);
					Long grp3_first_val = group3[group3.length - 1];
					Long grp3_second_val = group3[group3.length - 2];
					Long group_three_sum = grp3_first_val ;
					
					Long[] group3_pnts = {geopnts,hispnts,crepnts};
					Arrays.sort(group3_pnts);
					Long grp3_first_val_pnts = group3_pnts[group3_pnts.length - 1];
					Long grp3_second_val_pnts = group3_pnts[group3_pnts.length - 2];
					Long group_three_sum_pnts = grp3_first_val_pnts ;
					
					Long[] group4 = {third_val,grp3_second_val,agricel,bizel,compel,homel};
					Arrays.sort(group4);
					Long grp4_first_val = group4[group4.length - 1];
						
					Long[] group4_pnts = {third_val_pnts,grp3_second_val_pnts,agricpnts,bizpnts,comppnts,hompnts};
					Arrays.sort(group4_pnts);
					Long grp4_first_val_pnts = group4_pnts[group4_pnts.length - 1];
					Long etoto = engel + kisel + mathel  + group_two_sum + group_three_sum + grp4_first_val;	
					Long pnts_total = engpnts + kispnts + mathpnts  + group_two_sum_pnts + group_three_sum_pnts + grp4_first_val_pnts;	
					String grad_ttpnts = CommonGradeUtils_f3_and_f4.averageGrade(pnts_total);
					Long points = CommonGradeUtils_f3_and_f4.points(grad_ttpnts);
					e.setOv_pnts(pnts_total);
					e.setOv_pnts_grade(grad_ttpnts);
					e.setPoints(points);
					e.setPri_remarks(CommonGradeUtils_f3_and_f4.remarks_class_prinzy(grad_ttpnts));
					e.setClsT_remarks(CommonGradeUtils_f3_and_f4.remarks_class_teacher(grad_ttpnts));
					e.setTt(etoto);
				}
				return e;
			}
		});
		return list;
	}	
	@Override
	public int[] batchUpdate_Form4_tt(List<Form4marksreportprocess> form_tt) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(form_tt.toArray());
        int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(SQL_UPDATE_TT_avg,batch);
        return updateCounts;
	}
	
	@Override
	public List<Form4marksreportprocess> f4_rankList() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_RANK_PER_CLASS_f3, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess c_rank = new Form4marksreportprocess();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setCrank(rs.getString("crank"));
				return c_rank;
			}
		});
		return list;
			}

	@Override
	public int[] f4_c_rank(List<Form4marksreportprocess> crank) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crank.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set crank = :crank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	@Override
	public List<Form4marksreportprocess> f4_rank_ave() {
		List<Form4marksreportprocess> list = namedParameterJdbcTemplate.query(SQL_RANK_average_f3, new RowMapper<Form4marksreportprocess>() {

			@Override
			public Form4marksreportprocess mapRow(ResultSet rs, int rowNum) throws SQLException {
				Form4marksreportprocess c_rank = new Form4marksreportprocess();					
				c_rank.setRegno(rs.getLong("regno"));
				c_rank.setRank(rs.getString("rank"));
				return c_rank;
			}
		});
		return list;
	}
	@Override
	public int[] f4_rank_average(List<Form4marksreportprocess> crankAvg) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(crankAvg.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		"update Form4marksreportprocess set rank = :rank where regno = :regno",batch);
        		
        	      return crankCounts;
	}
	@Override
	public int[] f4_bchAverageToBackUp(List<Form4marksreportprocess> backup) {
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
        		qsl_copy_to_tableBACKUP_av,batch);
        		
        	      return crankCounts;
		}

	@Override
	public int[] f4_deleteAl(List<Form4marksreportprocess> backup) {
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(backup.toArray());
        int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(clear_all,batch);        		
        	      return crankCounts;
	}
}
