package com.skul.skul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "formonemarks")
public class FormOneMarks {
	@Id
	@Column(name = "regno", unique = true)
	private Long regno;
	private String form;
	private String term;
	private String examtype;
	private String year;
	private Long math;
	private String math_grade;
	private Long eng;
	private String eng_grade;
	private Long kis;
	private String kis_grade;
	private Long bio;
	private String bio_grade;
	private Long chem;
	private String chem_grade;
	private Long phy;
	private String phy_grade;
	private Long his;
	private String his_grade;
	private Long geo;
	private String geo_grade;
	private Long cre;
	private String cre_grade;
	private Long comp;
	private String comp_grade;
	private Long agric;
	private String agric_grade;
	private Long biz;
	private String biz_grade;
	private Long hom;
	private String hom_grade;
	private Long avg;
	private Long tt;
	private Long points;
	private String ov_grade;
	private String rank;
	private String crank;
	private String stream;
	
	public Long getRegno() {
		return regno;
	}
	public void setRegno(Long regno) {
		this.regno = regno;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getExamtype() {
		return examtype;
	}
	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Long getMath() {
		return math;
	}
	public void setMath(Long math) {
		this.math = math;
	}
	public String getMath_grade() {
		return math_grade;
	}
	public void setMath_grade(String math_grade) {
		this.math_grade = math_grade;
	}
	public Long getEng() {
		return eng;
	}
	public void setEng(Long eng) {
		this.eng = eng;
	}
	public String getEng_grade() {
		return eng_grade;
	}
	public void setEng_grade(String eng_grade) {
		this.eng_grade = eng_grade;
	}
	public Long getKis() {
		return kis;
	}
	public void setKis(Long kis) {
		this.kis = kis;
	}
	public String getKis_grade() {
		return kis_grade;
	}
	public void setKis_grade(String kis_grade) {
		this.kis_grade = kis_grade;
	}
	public Long getBio() {
		return bio;
	}
	public void setBio(Long bio) {
		this.bio = bio;
	}
	public String getBio_grade() {
		return bio_grade;
	}
	public void setBio_grade(String bio_grade) {
		this.bio_grade = bio_grade;
	}
	public Long getChem() {
		return chem;
	}
	public void setChem(Long chem) {
		this.chem = chem;
	}
	public String getChem_grade() {
		return chem_grade;
	}
	public void setChem_grade(String chem_grade) {
		this.chem_grade = chem_grade;
	}
	public Long getPhy() {
		return phy;
	}
	public void setPhy(Long phy) {
		this.phy = phy;
	}
	public String getPhy_grade() {
		return phy_grade;
	}
	public void setPhy_grade(String phy_grade) {
		this.phy_grade = phy_grade;
	}
	public Long getHis() {
		return his;
	}
	public void setHis(Long his) {
		this.his = his;
	}
	public String getHis_grade() {
		return his_grade;
	}
	public void setHis_grade(String his_grade) {
		this.his_grade = his_grade;
	}
	public Long getGeo() {
		return geo;
	}
	public void setGeo(Long geo) {
		this.geo = geo;
	}
	public String getGeo_grade() {
		return geo_grade;
	}
	public void setGeo_grade(String geo_grade) {
		this.geo_grade = geo_grade;
	}
	public Long getCre() {
		return cre;
	}
	public void setCre(Long cre) {
		this.cre = cre;
	}
	public String getCre_grade() {
		return cre_grade;
	}
	public void setCre_grade(String cre_grade) {
		this.cre_grade = cre_grade;
	}
	public Long getComp() {
		return comp;
	}
	public void setComp(Long comp) {
		this.comp = comp;
	}
	public String getComp_grade() {
		return comp_grade;
	}
	public void setComp_grade(String comp_grade) {
		this.comp_grade = comp_grade;
	}
	public Long getAgric() {
		return agric;
	}
	public void setAgric(Long agric) {
		this.agric = agric;
	}
	public String getAgric_grade() {
		return agric_grade;
	}
	public void setAgric_grade(String agric_grade) {
		this.agric_grade = agric_grade;
	}
	public Long getBiz() {
		return biz;
	}
	public void setBiz(Long biz) {
		this.biz = biz;
	}
	public String getBiz_grade() {
		return biz_grade;
	}
	public void setBiz_grade(String biz_grade) {
		this.biz_grade = biz_grade;
	}
	public Long getHom() {
		return hom;
	}
	public void setHom(Long hom) {
		this.hom = hom;
	}
	public String getHom_grade() {
		return hom_grade;
	}
	public void setHom_grade(String hom_grade) {
		this.hom_grade = hom_grade;
	}
	public Long getAvg() {
		return avg;
	}
	public void setAvg(Long avg) {
		this.avg = avg;
	}
	public Long getTt() {
		return tt;
	}
	public void setTt(Long tt) {
		this.tt = tt;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public String getOv_grade() {
		return ov_grade;
	}
	public void setOv_grade(String ov_grade) {
		this.ov_grade = ov_grade;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCrank() {
		return crank;
	}
	public void setCrank(String crank) {
		this.crank = crank;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public FormOneMarks(String form, String term, String examtype, String year, Long math, String math_grade, Long eng,
			String eng_grade, Long kis, String kis_grade, Long bio, String bio_grade, Long chem, String chem_grade,
			Long phy, String phy_grade, Long his, String his_grade, Long geo, String geo_grade, Long cre,
			String cre_grade, Long comp, String comp_grade, Long agric, String agric_grade, Long biz, String biz_grade,
			Long hom, String hom_grade, Long avg, Long tt, Long points, String ov_grade, String rank, String crank,
			String stream) {
		this.form = form;
		this.term = term;
		this.examtype = examtype;
		this.year = year;
		this.math = math;
		this.math_grade = math_grade;
		this.eng = eng;
		this.eng_grade = eng_grade;
		this.kis = kis;
		this.kis_grade = kis_grade;
		this.bio = bio;
		this.bio_grade = bio_grade;
		this.chem = chem;
		this.chem_grade = chem_grade;
		this.phy = phy;
		this.phy_grade = phy_grade;
		this.his = his;
		this.his_grade = his_grade;
		this.geo = geo;
		this.geo_grade = geo_grade;
		this.cre = cre;
		this.cre_grade = cre_grade;
		this.comp = comp;
		this.comp_grade = comp_grade;
		this.agric = agric;
		this.agric_grade = agric_grade;
		this.biz = biz;
		this.biz_grade = biz_grade;
		this.hom = hom;
		this.hom_grade = hom_grade;
		this.avg = avg;
		this.tt = tt;
		this.points = points;
		this.ov_grade = ov_grade;
		this.rank = rank;
		this.crank = crank;
		this.stream = stream;
	}
	public FormOneMarks() {
		
	}
	@Override
	public String toString() {
		return "FormOneMarks [regno=" + regno + ", form=" + form + ", term=" + term + ", examtype=" + examtype
				+ ", year=" + year + ", math=" + math + ", math_grade=" + math_grade + ", eng=" + eng + ", eng_grade="
				+ eng_grade + ", kis=" + kis + ", kis_grade=" + kis_grade + ", bio=" + bio + ", bio_grade=" + bio_grade
				+ ", chem=" + chem + ", chem_grade=" + chem_grade + ", phy=" + phy + ", phy_grade=" + phy_grade
				+ ", his=" + his + ", his_grade=" + his_grade + ", geo=" + geo + ", geo_grade=" + geo_grade + ", cre="
				+ cre + ", cre_grade=" + cre_grade + ", comp=" + comp + ", comp_grade=" + comp_grade + ", agric="
				+ agric + ", agric_grade=" + agric_grade + ", biz=" + biz + ", biz_grade=" + biz_grade + ", hom=" + hom
				+ ", hom_grade=" + hom_grade + ", avg=" + avg + ", tt=" + tt + ", points=" + points + ", ov_grade="
				+ ov_grade + ", rank=" + rank + ", crank=" + crank + ", stream=" + stream + "]";
	}
	
	
}
