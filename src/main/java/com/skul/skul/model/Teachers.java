package com.skul.skul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Teachers {	
	private Long idno;
	private String fname;
	private String othername;
	private String rank;
	private Long phone;
	private String form;
	private String stream;
	private String subject;
	@Id
	@Column(name = "idno", unique = true)
	public Long getIdno() {
		return idno;
	}
	public void setIdno(Long idno) {
		this.idno = idno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getOthername() {
		return othername;
	}
	public void setOthername(String othername) {
		this.othername = othername;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}			
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Teachers(String fname, String othername, String rank, Long phone,String form,String stream,String subject) {
		this.fname = fname;
		this.othername = othername;
		this.rank = rank;
		this.phone = phone;
		this.form = form;
		this.stream = stream;
		this.subject = subject;
	}
	public Teachers() {		
	}
	@Override
	public String toString() {
		return "Teachers [idno=" + idno + ", fname=" + fname + ", othername=" + othername + ", rank=" + rank
				+ ", phone=" + phone + ", form=" + form + ", stream=" + stream + ", subject=" + subject + "]";
	}
	
	
}
