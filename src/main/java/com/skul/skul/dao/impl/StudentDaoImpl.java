package com.skul.skul.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.skul.skul.dao.StudentDao;
import com.skul.skul.model.FormOneMarks;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Student;

@Repository
public class StudentDaoImpl  implements StudentDao{

	String SELECT_ALL = "SELECT * from student ";
	
	final static String SELECT_ALL_FORM_ONE = "SELECT * from student WHERE form = 'ONE' ";
	final static String SELECT_ALL_FORM_TWO = "SELECT * from student WHERE form = 'TWO' ";
	
	//final static String SELECT_ALL_FORM_THREE = "SELECT * from student WHERE form = 'THREE' ";
	
	final static String SELECT_ALL_FORM_THREE = "SELECT regno, COALESCE(agriculture,'') AS agriculture, COALESCE(biology,'') AS biology, COALESCE(business,'') AS business, COALESCE(chemistry,'')AS chemistry, COALESCE(computer,'')AS computer, COALESCE(cre,'')AS cre,COALESCE(english,'')AS english, COALESCE(fname,'')AS fname, COALESCE(form,'')AS form, COALESCE(gender,'')AS gender, COALESCE(geography,'')AS geography, COALESCE(history,'')AS history, COALESCE(homescience,'')AS homescience,COALESCE(kiswahili,'')AS kiswahili, COALESCE(mathematics,'')AS mathematics, COALESCE(physics,'')AS physics, COALESCE(sirname,'')AS sirname, COALESCE(status,'')AS status, COALESCE(stream,'')AS stream, year, COALESCE(subno,'') AS subno,COALESCE(kcpemarks,'') AS kcpemarks,COALESCE(kcpegrade,'') AS kcpegrade,COALESCE(kcpemean,'') AS kcpemean FROM student WHERE form = 'THREE'";
	final static String SELECT_ALL_FORM_FOUR = "SELECT regno, COALESCE(agriculture,'') AS agriculture, COALESCE(biology,'') AS biology, COALESCE(business,'') AS business, COALESCE(chemistry,'')AS chemistry, COALESCE(computer,'')AS computer, COALESCE(cre,'')AS cre,COALESCE(english,'')AS english, COALESCE(fname,'')AS fname, COALESCE(form,'')AS form, COALESCE(gender,'')AS gender, COALESCE(geography,'')AS geography, COALESCE(history,'')AS history, COALESCE(homescience,'')AS homescience,COALESCE(kiswahili,'')AS kiswahili, COALESCE(mathematics,'')AS mathematics, COALESCE(physics,'')AS physics, COALESCE(sirname,'')AS sirname, COALESCE(status,'')AS status, COALESCE(stream,'')AS stream, year, COALESCE(subno,'') AS subno,COALESCE(kcpemarks,'') AS kcpemarks,COALESCE(kcpegrade,'') AS kcpegrade,COALESCE(kcpemean,'') AS kcpemean FROM student WHERE form = 'FOUR'";
	
	final String SQL_SELECT_STREAM_NORTH = "SELECT stream,form FROM student WHERE stream = :stream AND form = :form";
	 final String SQL_SELECT_STREAM_WEST = "";
	 final String SQL_SELECT_STREAM_SOUTH = "";
	 final String SQL_SELECT_STREAM_EAST = "";
	final String SQL_SUB_NO = "SELECT regno,SUM(CASE WHEN agriculture = 'AGRICULTURE' THEN 1 ELSE 0 END + CASE WHEN business = 'BUSINESS' THEN 1 ELSE 0 END + CASE WHEN chemistry = 'CHEMISTRY' THEN 1 ELSE 0 END + CASE WHEN computer = 'COMPUTER' THEN 1 ELSE 0 END + CASE WHEN cre = 'CRE' THEN 1 ELSE 0 END + CASE WHEN geography = 'GEOGRAPHY' THEN 1 ELSE 0 END + CASE WHEN history = 'HISTORY' THEN 1 ELSE 0 END + CASE WHEN homescience = 'HOMESCIENCE' THEN 1 ELSE 0 END + CASE WHEN physics = 'PHYSICS' THEN 1 ELSE 0 END  + 4 ) AS subno FROM student GROUP BY regno";	
	@Autowired
	private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public List<Student> findAll() {
				
		List<Student> list = namedParameterJdbcTemplate.query(SELECT_ALL, new RowMapper<Student>() {
			 
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setSirname(rs.getString("sirname"));
				s_all.setStatus(rs.getString("status"));
				
				return s_all;
			}
			
		});
		return list;
	}
@Override
public List<Student> getAllStudent_form_one() {
		
		List<Student> list = namedParameterJdbcTemplate.query(SELECT_ALL_FORM_ONE, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setSirname(rs.getString("sirname"));
				s_all.setGender(rs.getString("gender"));
				s_all.setForm(rs.getString("form"));
				s_all.setStream(rs.getString("stream"));
				s_all.setStatus(rs.getString("status"));
				s_all.setKcpemarks(rs.getString("kcpemarks"));
				s_all.setKcpemean(rs.getString("kcpemean"));
				s_all.setKcpegrade(rs.getString("kcpegrade"));
				return s_all;
			}
			
		});
		return list;
	}
@Override
public List<Student> getAllStudent_form_two() {
		
		List<Student> list = namedParameterJdbcTemplate.query(SELECT_ALL_FORM_TWO, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setSirname(rs.getString("sirname"));
				s_all.setGender(rs.getString("gender"));
				s_all.setForm(rs.getString("form"));
				s_all.setStream(rs.getString("stream"));
				s_all.setStatus(rs.getString("status"));
				s_all.setKcpemarks(rs.getString("kcpemarks"));
				s_all.setKcpemean(rs.getString("kcpemean"));
				s_all.setKcpegrade(rs.getString("kcpegrade"));
				return s_all;
			}
			
		});
		return list;
	}
@Override
public List<Student> getAllStudent_form_Three() {
		
		List<Student> list = namedParameterJdbcTemplate.query(SELECT_ALL_FORM_THREE, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setSirname(rs.getString("sirname"));
				s_all.setGender(rs.getString("gender"));
				s_all.setStatus(rs.getString("status"));
				s_all.setForm(rs.getString("form"));
				s_all.setStream(rs.getString("stream"));
				s_all.setPhysics(rs.getString("physics"));
				s_all.setGeography(rs.getString("geography"));
				s_all.setHistory(rs.getString("history"));
				s_all.setCre(rs.getString("cre"));
				s_all.setAgriculture(rs.getString("agriculture"));
				s_all.setBusiness(rs.getString("business"));
				s_all.setComputer(rs.getString("computer"));
				s_all.setHomescience(rs.getString("homescience"));
				s_all.setCre(rs.getString("cre"));
				s_all.setKcpemarks(rs.getString("kcpemarks"));
				s_all.setKcpemean(rs.getString("kcpemean"));
				s_all.setKcpegrade(rs.getString("kcpegrade"));
				return s_all;
			}
			
		});
		return list;
	}
@Override
public List<Student> getAllStudent_form_four() {
		
		List<Student> list = namedParameterJdbcTemplate.query(SELECT_ALL_FORM_FOUR, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s_all = new Student();
				s_all.setRegno(rs.getLong("regno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setSirname(rs.getString("sirname"));
				s_all.setGender(rs.getString("gender"));
				s_all.setStatus(rs.getString("status"));
				s_all.setForm(rs.getString("form"));
				s_all.setStream(rs.getString("stream"));
				s_all.setPhysics(rs.getString("physics"));
				s_all.setGeography(rs.getString("geography"));
				s_all.setHistory(rs.getString("history"));
				s_all.setCre(rs.getString("cre"));
				s_all.setAgriculture(rs.getString("agriculture"));
				s_all.setBusiness(rs.getString("business"));
				s_all.setComputer(rs.getString("computer"));
				s_all.setHomescience(rs.getString("homescience"));
				s_all.setCre(rs.getString("cre"));
				s_all.setKcpemarks(rs.getString("kcpemarks"));
				s_all.setKcpemean(rs.getString("kcpemean"));
				s_all.setKcpegrade(rs.getString("kcpegrade"));
				return s_all;
			}
			
		});
		return list;
	}
	
@Override
public List<Student> selectAll_north_students(String stream,String form) {
	List<Student> list = namedParameterJdbcTemplate.query(SQL_SELECT_STREAM_NORTH,new MapSqlParameterSource().addValue("stream", stream).addValue("form", form), new RowMapper<Student>() {		
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s_all = new Student();
			s_all.setStream(rs.getString("stream"));
			s_all.setForm(rs.getString("form"));
			return s_all;
		}		
	});
	return list;
}
	
@Override
public void update_chem_sub(Student e) {
	final String UPDATE_QUERY = "update student set chemistry = :chemistry where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("chemistry", e.getChemistry()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_phy_sub(Student e) {
	final String UPDATE_QUERY = "update student set physics = :physics where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("physics", e.getPhysics()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);   		
}
@Override
public void update_geo_sub(Student e) {
	final String UPDATE_QUERY = "update student set geography = :geography where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("geography", e.getGeography()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_his_sub(Student e) {
	final String UPDATE_QUERY = "update student set history = :history where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("history", e.getHistory()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_cre_sub(Student e) {
	final String UPDATE_QUERY = "update student set cre = :cre where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("cre", e.getCre()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_agric_sub(Student e) {
	final String UPDATE_QUERY = "update student set agriculture = :agriculture where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("agriculture", e.getAgriculture()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_biz_sub(Student e) {
	final String UPDATE_QUERY = "update student set business = :business where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("business", e.getBusiness()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_comp_sub(Student e) {
	final String UPDATE_QUERY = "update student set computer = :computer where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("computer", e.getComputer()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public void update_hom_sub(Student e) {
	final String UPDATE_QUERY = "update student set homescience = :homescience where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("homescience", e.getHomescience()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
@Override
public List<Student> selectAll_subno_students() {
	List<Student> list = namedParameterJdbcTemplate.query(SQL_SUB_NO, new RowMapper<Student>() {		
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s_all = new Student();
			s_all.setRegno(rs.getLong("regno"));
			s_all.setSubno(rs.getString("subno"));
			return s_all;
		}		
	});
	return list;
}
@Override
public int[] sabono(List<Student> sabno) {
	
	SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(sabno.toArray());
    int[] crankCounts = namedParameterJdbcTemplate.batchUpdate(
    		"update student set subno = :subno where regno = :regno",batch);
    		
    	      return crankCounts;
}

@Override
public void update_std(Student e) {
	final String UPDATE_QUERY = "update student set fname = :fname,form = :form,stream = :stream,year = :year,gender = :gender,kcpemarks = :kcpemarks where regno = :regno";    
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("fname", e.getFname()).addValue("form", e.getForm()).addValue("stream", e.getStream()).addValue("year", e.getYear()).addValue("gender", e.getGender()).addValue("kcpemarks", e.getKcpemarks()).addValue("regno", e.getRegno());
    namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);    		
}
}
