package com.skul.skul.model;

import javax.persistence.*;

@Entity
@Table(name="form2marksbackup")
public class Form2marksbackup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private Long regno;
	private String form;
	private String term;
	private String year;
	private Long math;
	private String math_grade;
	private Long math_pnts;
	private String math_pos;
	private String math_remarks;
	private String math_initials;
	private Long eng;
	private String eng_grade;
	private Long eng_pnts;
	private String eng_pos;
	private String eng_remarks;
	private String eng_initials;
	private Long kis;
	private String kis_grade;
	private Long kis_pnts;
	private String kis_pos;
	private String kis_remarks;
	private String kis_initials;
	private Long bio;
	private String bio_grade;
	private Long bio_pnts;
	private String bio_pos;
	private String bio_remarks;
	private String bio_initials;
	private Long chem;
	private String chem_grade;
	private Long chem_pnts;
	private String chem_pos;
	private String chem_remarks;
	private String chem_initials;
	private Long phy;
	private String phy_grade;
	private Long phy_pnts;
	private String phy_pos;
	private String phy_remarks;
	private String phy_initials;
	private Long his;
	private String his_grade;
	private Long his_pnts;
	private String his_pos;
	private String his_remarks;
	private String his_initials;
	private Long geo;
	private String geo_grade;
	private Long geo_pnts;
	private String geo_pos;
	private String geo_remarks;
	private String geo_initials;
	private Long cre;
	private String cre_grade;
	private Long cre_pnts;
	private String cre_pos;
	private String cre_remarks;
	private String cre_initials;
	private Long comp;
	private String comp_grade;
	private Long comp_pnts;
	private String comp_pos;
	private String comp_remarks;
	private String comp_initials;
	private Long agric;
	private String agric_grade;
	private Long agric_pnts;
	private String agric_pos;
	private String agric_remarks;
	private String agric_initials;
	private Long biz;
	private String biz_grade;
	private Long biz_pnts;
	private String biz_pos;
	private String biz_remarks;
	private String biz_initials;
	private Long hom;
	private String hom_grade;
	private Long hom_pnts;
	private String hom_pos;
	private String hom_remarks;
	private String hom_initials;
	private Long avg;
	private Long tt;
	private Long points;
	private String ov_grade;
	private String rank;
	private String crank;
	private String stream;
	private String clsT_remarks;
	private String pri_remarks;
	private Long ov_pnts;
	private String ov_pnts_grade;
	private String dev;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getMath_pos() {
		return math_pos;
	}
	public void setMath_pos(String math_pos) {
		this.math_pos = math_pos;
	}
	public String getMath_remarks() {
		return math_remarks;
	}
	public void setMath_remarks(String math_remarks) {
		this.math_remarks = math_remarks;
	}
	public String getMath_initials() {
		return math_initials;
	}
	public void setMath_initials(String math_initials) {
		this.math_initials = math_initials;
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
	public String getEng_pos() {
		return eng_pos;
	}
	public void setEng_pos(String eng_pos) {
		this.eng_pos = eng_pos;
	}
	public String getEng_remarks() {
		return eng_remarks;
	}
	public void setEng_remarks(String eng_remarks) {
		this.eng_remarks = eng_remarks;
	}
	public String getEng_initials() {
		return eng_initials;
	}
	public void setEng_initials(String eng_initials) {
		this.eng_initials = eng_initials;
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
	public String getKis_pos() {
		return kis_pos;
	}
	public void setKis_pos(String kis_pos) {
		this.kis_pos = kis_pos;
	}
	public String getKis_remarks() {
		return kis_remarks;
	}
	public void setKis_remarks(String kis_remarks) {
		this.kis_remarks = kis_remarks;
	}
	public String getKis_initials() {
		return kis_initials;
	}
	public void setKis_initials(String kis_initials) {
		this.kis_initials = kis_initials;
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
	public String getBio_pos() {
		return bio_pos;
	}
	public void setBio_pos(String bio_pos) {
		this.bio_pos = bio_pos;
	}
	public String getBio_remarks() {
		return bio_remarks;
	}
	public void setBio_remarks(String bio_remarks) {
		this.bio_remarks = bio_remarks;
	}
	public String getBio_initials() {
		return bio_initials;
	}
	public void setBio_initials(String bio_initials) {
		this.bio_initials = bio_initials;
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
	public String getChem_pos() {
		return chem_pos;
	}
	public void setChem_pos(String chem_pos) {
		this.chem_pos = chem_pos;
	}
	public String getChem_remarks() {
		return chem_remarks;
	}
	public void setChem_remarks(String chem_remarks) {
		this.chem_remarks = chem_remarks;
	}
	public String getChem_initials() {
		return chem_initials;
	}
	public void setChem_initials(String chem_initials) {
		this.chem_initials = chem_initials;
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
	public String getPhy_pos() {
		return phy_pos;
	}
	public void setPhy_pos(String phy_pos) {
		this.phy_pos = phy_pos;
	}
	public String getPhy_remarks() {
		return phy_remarks;
	}
	public void setPhy_remarks(String phy_remarks) {
		this.phy_remarks = phy_remarks;
	}
	public String getPhy_initials() {
		return phy_initials;
	}
	public void setPhy_initials(String phy_initials) {
		this.phy_initials = phy_initials;
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
	public String getHis_pos() {
		return his_pos;
	}
	public void setHis_pos(String his_pos) {
		this.his_pos = his_pos;
	}
	public String getHis_remarks() {
		return his_remarks;
	}
	public void setHis_remarks(String his_remarks) {
		this.his_remarks = his_remarks;
	}
	public String getHis_initials() {
		return his_initials;
	}
	public void setHis_initials(String his_initials) {
		this.his_initials = his_initials;
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
	public String getGeo_pos() {
		return geo_pos;
	}
	public void setGeo_pos(String geo_pos) {
		this.geo_pos = geo_pos;
	}
	public String getGeo_remarks() {
		return geo_remarks;
	}
	public void setGeo_remarks(String geo_remarks) {
		this.geo_remarks = geo_remarks;
	}
	public String getGeo_initials() {
		return geo_initials;
	}
	public void setGeo_initials(String geo_initials) {
		this.geo_initials = geo_initials;
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
	public String getCre_pos() {
		return cre_pos;
	}
	public void setCre_pos(String cre_pos) {
		this.cre_pos = cre_pos;
	}
	public String getCre_remarks() {
		return cre_remarks;
	}
	public void setCre_remarks(String cre_remarks) {
		this.cre_remarks = cre_remarks;
	}
	public String getCre_initials() {
		return cre_initials;
	}
	public void setCre_initials(String cre_initials) {
		this.cre_initials = cre_initials;
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
	public String getComp_pos() {
		return comp_pos;
	}
	public void setComp_pos(String comp_pos) {
		this.comp_pos = comp_pos;
	}
	public String getComp_remarks() {
		return comp_remarks;
	}
	public void setComp_remarks(String comp_remarks) {
		this.comp_remarks = comp_remarks;
	}
	public String getComp_initials() {
		return comp_initials;
	}
	public void setComp_initials(String comp_initials) {
		this.comp_initials = comp_initials;
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
	public String getAgric_pos() {
		return agric_pos;
	}
	public void setAgric_pos(String agric_pos) {
		this.agric_pos = agric_pos;
	}
	public String getAgric_remarks() {
		return agric_remarks;
	}
	public void setAgric_remarks(String agric_remarks) {
		this.agric_remarks = agric_remarks;
	}
	public String getAgric_initials() {
		return agric_initials;
	}
	public void setAgric_initials(String agric_initials) {
		this.agric_initials = agric_initials;
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
	public String getBiz_pos() {
		return biz_pos;
	}
	public void setBiz_pos(String biz_pos) {
		this.biz_pos = biz_pos;
	}
	public String getBiz_remarks() {
		return biz_remarks;
	}
	public void setBiz_remarks(String biz_remarks) {
		this.biz_remarks = biz_remarks;
	}
	public String getBiz_initials() {
		return biz_initials;
	}
	public void setBiz_initials(String biz_initials) {
		this.biz_initials = biz_initials;
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
	public String getHom_pos() {
		return hom_pos;
	}
	public void setHom_pos(String hom_pos) {
		this.hom_pos = hom_pos;
	}
	public String getHom_remarks() {
		return hom_remarks;
	}
	public void setHom_remarks(String hom_remarks) {
		this.hom_remarks = hom_remarks;
	}
	public String getHom_initials() {
		return hom_initials;
	}
	public void setHom_initials(String hom_initials) {
		this.hom_initials = hom_initials;
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
	public String getClsT_remarks() {
		return clsT_remarks;
	}
	public void setClsT_remarks(String clsT_remarks) {
		this.clsT_remarks = clsT_remarks;
	}
	public String getPri_remarks() {
		return pri_remarks;
	}
	public void setPri_remarks(String pri_remarks) {
		this.pri_remarks = pri_remarks;
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
	public String getDev() {
		return dev;
	}
	public void setDev(String dev) {
		this.dev = dev;
	}
	
}