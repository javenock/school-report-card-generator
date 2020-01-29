package com.skul.skul.model;

import javax.persistence.*;

@Entity
@Table(name = "formthreemarksentry")
public class FormThreeMarksEntry {
	@Id
	@Column(name = "regno", unique = true)
	private Long regno;
	private String form;
	private String term;
	private String examtype;
	private String year;
	private Long math;
	private String math_grade;
	private Long math_pnts;
	private Long eng;
	private String eng_grade;
	private Long eng_pnts;
	private Long kis;
	private String kis_grade;
	private Long kis_pnts;
	private Long bio;
	private String bio_grade;
	private Long bio_pnts;
	private Long chem;
	private String chem_grade;
	private Long chem_pnts;
	private Long phy;
	private String phy_grade;
	private Long phy_pnts;
	private Long his;
	private String his_grade;
	private Long his_pnts;
	private Long geo;
	private String geo_grade;
	private Long geo_pnts;
	private Long cre;
	private String cre_grade;
	private Long cre_pnts;
	private Long comp;
	private String comp_grade;
	private Long comp_pnts;
	private Long agric;
	private String agric_grade;
	private Long agric_pnts;
	private Long biz;
	private String biz_grade;
	private Long biz_pnts;
	private Long hom;
	private String hom_grade;
	private Long hom_pnts;
	private Long avg;
	private Long tt;
	private Long points;
	private String ov_grade;
	private String rank;
	private String crank;
	private String stream;
	private Long ov_pnts;
	private String ov_pnts_grade;
	
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
	public Long getMath_pnts() {
		return math_pnts;
	}
	public void setMath_pnts(Long math_pnts) {
		this.math_pnts = math_pnts;
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
	public Long getEng_pnts() {
		return eng_pnts;
	}
	public void setEng_pnts(Long eng_pnts) {
		this.eng_pnts = eng_pnts;
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
	public Long getKis_pnts() {
		return kis_pnts;
	}
	public void setKis_pnts(Long kis_pnts) {
		this.kis_pnts = kis_pnts;
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
	public Long getBio_pnts() {
		return bio_pnts;
	}
	public void setBio_pnts(Long bio_pnts) {
		this.bio_pnts = bio_pnts;
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
	public Long getChem_pnts() {
		return chem_pnts;
	}
	public void setChem_pnts(Long chem_pnts) {
		this.chem_pnts = chem_pnts;
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
	public Long getPhy_pnts() {
		return phy_pnts;
	}
	public void setPhy_pnts(Long phy_pnts) {
		this.phy_pnts = phy_pnts;
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
	public Long getHis_pnts() {
		return his_pnts;
	}
	public void setHis_pnts(Long his_pnts) {
		this.his_pnts = his_pnts;
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
	public Long getGeo_pnts() {
		return geo_pnts;
	}
	public void setGeo_pnts(Long geo_pnts) {
		this.geo_pnts = geo_pnts;
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
	public Long getCre_pnts() {
		return cre_pnts;
	}
	public void setCre_pnts(Long cre_pnts) {
		this.cre_pnts = cre_pnts;
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
	public Long getComp_pnts() {
		return comp_pnts;
	}
	public void setComp_pnts(Long comp_pnts) {
		this.comp_pnts = comp_pnts;
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
	public Long getAgric_pnts() {
		return agric_pnts;
	}
	public void setAgric_pnts(Long agric_pnts) {
		this.agric_pnts = agric_pnts;
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
	public Long getBiz_pnts() {
		return biz_pnts;
	}
	public void setBiz_pnts(Long biz_pnts) {
		this.biz_pnts = biz_pnts;
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
	public Long getHom_pnts() {
		return hom_pnts;
	}
	public void setHom_pnts(Long hom_pnts) {
		this.hom_pnts = hom_pnts;
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
	public Long getOv_pnts() {
		return ov_pnts;
	}
	public void setOv_pnts(Long ov_pnts) {
		this.ov_pnts = ov_pnts;
	}
	public String getOv_pnts_grade() {
		return ov_pnts_grade;
	}
	public void setOv_pnts_grade(String ov_pnts_grade) {
		this.ov_pnts_grade = ov_pnts_grade;
	}
	
	public FormThreeMarksEntry(String form, String term, String examtype, String year, Long math, String math_grade,
			Long math_pnts, Long eng, String eng_grade, Long eng_pnts, Long kis, String kis_grade, Long kis_pnts,
			Long bio, String bio_grade, Long bio_pnts, Long chem, String chem_grade, Long chem_pnts, Long phy,
			String phy_grade, Long phy_pnts, Long his, String his_grade, Long his_pnts, Long geo, String geo_grade,
			Long geo_pnts, Long cre, String cre_grade, Long cre_pnts, Long comp, String comp_grade, Long comp_pnts,
			Long agric, String agric_grade, Long agric_pnts, Long biz, String biz_grade, Long biz_pnts, Long hom,
			String hom_grade, Long hom_pnts, Long avg, Long tt, Long points, String ov_grade, String rank, String crank,
			String stream, Long ov_pnts, String ov_pnts_grade) {
		this.form = form;
		this.term = term;
		this.examtype = examtype;
		this.year = year;
		this.math = math;
		this.math_grade = math_grade;
		this.math_pnts = math_pnts;
		this.eng = eng;
		this.eng_grade = eng_grade;
		this.eng_pnts = eng_pnts;
		this.kis = kis;
		this.kis_grade = kis_grade;
		this.kis_pnts = kis_pnts;
		this.bio = bio;
		this.bio_grade = bio_grade;
		this.bio_pnts = bio_pnts;
		this.chem = chem;
		this.chem_grade = chem_grade;
		this.chem_pnts = chem_pnts;
		this.phy = phy;
		this.phy_grade = phy_grade;
		this.phy_pnts = phy_pnts;
		this.his = his;
		this.his_grade = his_grade;
		this.his_pnts = his_pnts;
		this.geo = geo;
		this.geo_grade = geo_grade;
		this.geo_pnts = geo_pnts;
		this.cre = cre;
		this.cre_grade = cre_grade;
		this.cre_pnts = cre_pnts;
		this.comp = comp;
		this.comp_grade = comp_grade;
		this.comp_pnts = comp_pnts;
		this.agric = agric;
		this.agric_grade = agric_grade;
		this.agric_pnts = agric_pnts;
		this.biz = biz;
		this.biz_grade = biz_grade;
		this.biz_pnts = biz_pnts;
		this.hom = hom;
		this.hom_grade = hom_grade;
		this.hom_pnts = hom_pnts;
		this.avg = avg;
		this.tt = tt;
		this.points = points;
		this.ov_grade = ov_grade;
		this.rank = rank;
		this.crank = crank;
		this.stream = stream;
		this.ov_pnts = ov_pnts;
		this.ov_pnts_grade = ov_pnts_grade;
	}
	public FormThreeMarksEntry() {
		
	}
	@Override
	public String toString() {
		return "FormThreeMarksEntry [regno=" + regno + ", form=" + form + ", term=" + term + ", examtype=" + examtype
				+ ", year=" + year + ", math=" + math + ", math_grade=" + math_grade + ", math_pnts=" + math_pnts
				+ ", eng=" + eng + ", eng_grade=" + eng_grade + ", eng_pnts=" + eng_pnts + ", kis=" + kis
				+ ", kis_grade=" + kis_grade + ", kis_pnts=" + kis_pnts + ", bio=" + bio + ", bio_grade=" + bio_grade
				+ ", bio_pnts=" + bio_pnts + ", chem=" + chem + ", chem_grade=" + chem_grade + ", chem_pnts="
				+ chem_pnts + ", phy=" + phy + ", phy_grade=" + phy_grade + ", phy_pnts=" + phy_pnts + ", his=" + his
				+ ", his_grade=" + his_grade + ", his_pnts=" + his_pnts + ", geo=" + geo + ", geo_grade=" + geo_grade
				+ ", geo_pnts=" + geo_pnts + ", cre=" + cre + ", cre_grade=" + cre_grade + ", cre_pnts=" + cre_pnts
				+ ", comp=" + comp + ", comp_grade=" + comp_grade + ", comp_pnts=" + comp_pnts + ", agric=" + agric
				+ ", agric_grade=" + agric_grade + ", agric_pnts=" + agric_pnts + ", biz=" + biz + ", biz_grade="
				+ biz_grade + ", biz_pnts=" + biz_pnts + ", hom=" + hom + ", hom_grade=" + hom_grade + ", hom_pnts="
				+ hom_pnts + ", avg=" + avg + ", tt=" + tt + ", points=" + points + ", ov_grade=" + ov_grade + ", rank="
				+ rank + ", crank=" + crank + ", stream=" + stream + ", ov_pnts=" + ov_pnts + ", ov_pnts_grade="
				+ ov_pnts_grade + "]";
	}
	
	
	
	
	

	
	}
