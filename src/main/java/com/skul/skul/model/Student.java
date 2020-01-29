package com.skul.skul.model;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	private Long regno;
	private String fname;
	private String sirname;
	private String form;
	private String stream;
	private String year;
	private String gender;
	private String status;
	private String english;
	private String kiswahili;
	private String mathematics;
	private String biology;
	private String chemistry;
	private String physics;
	private String geography;
	private String history;
	private String cre;
	private String agriculture;
	private String business;
	private String computer;
	private String homescience;
	private String subno;
	private String kcpemarks;
	private String kcpemean;
	private String kcpegrade;
	public Long getRegno() {
		return regno;
	}
	public void setRegno(Long regno) {
		this.regno = regno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSirname() {
		return sirname;
	}
	public void setSirname(String sirname) {
		this.sirname = sirname;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKiswahili() {
		return kiswahili;
	}
	public void setKiswahili(String kiswahili) {
		this.kiswahili = kiswahili;
	}
	public String getMathematics() {
		return mathematics;
	}
	public void setMathematics(String mathematics) {
		this.mathematics = mathematics;
	}
	public String getBiology() {
		return biology;
	}
	public void setBiology(String biology) {
		this.biology = biology;
	}
	public String getChemistry() {
		return chemistry;
	}
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	public String getGeography() {
		return geography;
	}
	public void setGeography(String geography) {
		this.geography = geography;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getCre() {
		return cre;
	}
	public void setCre(String cre) {
		this.cre = cre;
	}
	public String getAgriculture() {
		return agriculture;
	}
	public void setAgriculture(String agriculture) {
		this.agriculture = agriculture;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public String getHomescience() {
		return homescience;
	}
	public void setHomescience(String homescience) {
		this.homescience = homescience;
	}	
	public String getSubno() {
		return subno;
	}
	public void setSubno(String subno) {
		this.subno = subno;
	}	
	public String getKcpemarks() {
		return kcpemarks;
	}
	public void setKcpemarks(String kcpemarks) {
		this.kcpemarks = kcpemarks;
	}
	public String getKcpemean() {
		return kcpemean;
	}
	public void setKcpemean(String kcpemean) {
		this.kcpemean = kcpemean;
	}
	public String getKcpegrade() {
		return kcpegrade;
	}
	public void setKcpegrade(String kcpegrade) {
		this.kcpegrade = kcpegrade;
	}
	
	public Student(String fname, String sirname, String form, String stream, String year, String gender, String status,
			String english, String kiswahili, String mathematics, String biology, String chemistry, String physics,
			String geography, String history, String cre, String agriculture, String business, String computer,
			String homescience, String subno, String kcpemarks, String kcpemean, String kcpegrade) {
		this.fname = fname;
		this.sirname = sirname;
		this.form = form;
		this.stream = stream;
		this.year = year;
		this.gender = gender;
		this.status = status;
		this.english = english;
		this.kiswahili = kiswahili;
		this.mathematics = mathematics;
		this.biology = biology;
		this.chemistry = chemistry;
		this.physics = physics;
		this.geography = geography;
		this.history = history;
		this.cre = cre;
		this.agriculture = agriculture;
		this.business = business;
		this.computer = computer;
		this.homescience = homescience;
		this.subno = subno;
		this.kcpemarks = kcpemarks;
		this.kcpemean = kcpemean;
		this.kcpegrade = kcpegrade;
	}
	
	public Student(Long regno, String fname, String sirname, String form, String stream, String year, String gender,
			String status, String english, String kiswahili, String mathematics, String biology, String chemistry,
			String physics, String geography, String history, String cre, String agriculture, String business,
			String computer, String homescience, String subno, String kcpemarks, String kcpemean, String kcpegrade) {
		this.regno = regno;
		this.fname = fname;
		this.sirname = sirname;
		this.form = form;
		this.stream = stream;
		this.year = year;
		this.gender = gender;
		this.status = status;
		this.english = english;
		this.kiswahili = kiswahili;
		this.mathematics = mathematics;
		this.biology = biology;
		this.chemistry = chemistry;
		this.physics = physics;
		this.geography = geography;
		this.history = history;
		this.cre = cre;
		this.agriculture = agriculture;
		this.business = business;
		this.computer = computer;
		this.homescience = homescience;
		this.subno = subno;
		this.kcpemarks = kcpemarks;
		this.kcpemean = kcpemean;
		this.kcpegrade = kcpegrade;
	}
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [regno=" + regno + ", fname=" + fname + ", sirname=" + sirname + ", form=" + form + ", stream="
				+ stream + ", year=" + year + ", gender=" + gender + ", status=" + status + ", english=" + english
				+ ", kiswahili=" + kiswahili + ", mathematics=" + mathematics + ", biology=" + biology + ", chemistry="
				+ chemistry + ", physics=" + physics + ", geography=" + geography + ", history=" + history + ", cre="
				+ cre + ", agriculture=" + agriculture + ", business=" + business + ", computer=" + computer
				+ ", homescience=" + homescience + ", subno=" + subno + ", kcpemarks=" + kcpemarks + ", kcpemean="
				+ kcpemean + ", kcpegrade=" + kcpegrade + "]";
	}
	
	
	
	
	
	
	
}
