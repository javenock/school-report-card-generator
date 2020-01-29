package com.skul.skul.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.skul.skul.dao.TeacherDao;
import com.skul.skul.model.FormThreeMarksEntry;
import com.skul.skul.model.Teachers;
@Repository
public class TeacherDaoImpl implements TeacherDao{

	String SQL_SELECT_TEACHER = "SELECT idno, fname, othername, phone, rank, form, stream,subject FROM teachers WHERE stream = :stream AND form = :form";

	String SQL_SELECT_PRINCIPAL = "SELECT fname, othername,rank FROM teachers WHERE rank = 'PRINCIPAL' ";
	@Autowired
	private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Teachers> getAll(String Stream, String form) {
		List<Teachers> list = namedParameterJdbcTemplate.query(SQL_SELECT_TEACHER,new MapSqlParameterSource().addValue("stream", Stream).addValue("form", form), new RowMapper<Teachers>() {
			@Override
			public Teachers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teachers s_all = new Teachers();
				s_all.setIdno(rs.getLong("idno"));
				s_all.setFname(rs.getString("fname"));
				s_all.setOthername(rs.getString("othername"));	
				s_all.setStream(rs.getString("stream"));
				s_all.setForm(rs.getString("form"));
				s_all.setSubject(rs.getString("subject"));
				return s_all;
			}			
		});
		return list;
	}
	@Override
	public List<Teachers> get_principal_name() {
		List<Teachers> list = namedParameterJdbcTemplate.query(SQL_SELECT_PRINCIPAL, new RowMapper<Teachers>() {
			@Override
			public Teachers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teachers s_all = new Teachers();
				s_all.setFname(rs.getString("fname"));
				s_all.setOthername(rs.getString("othername"));	
				
				return s_all;
			}			
		});
		return list;
	}
	
		
}
