package com.skul.skul.model;

import javax.persistence.*;

@Entity
public class Subject_Analysis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
private String eng_aplain;//A
private String eng_aminus; //A-
private String eng_bplus; //B+
private String eng_bplain; //B
private String eng_bminus; //B-
private String eng_cplus; //C+
private String eng_cplain; //C
private String eng_cminus; //C-
private String eng_dplus; //D+
private String eng_dplain; //D
private String eng_dminus; //D-
private String eng_eplain; //E
private String eng_entry;
private String eng_av;
private String eng_grade;
private String kis_aplain;//A
private String kis_aminus; //A-
private String kis_bplus; //B+
private String kis_bplain; //B
private String kis_bminus; //B-
private String kis_cplus; //C+
private String kis_cplain; //C
private String kis_cminus; //C-
private String kis_dplus; //D+
private String kis_dplain; //D
private String kis_dminus; //D-
private String kis_eplain; //E
private String kis_entry;
private String kis_av;
private String kis_grade;
private String math_aplain;//A
private String math_aminus; //A-
private String math_bplus; //B+
private String math_bplain; //B
private String math_bminus; //B-
private String math_cplus; //C+
private String math_cplain; //C
private String math_cminus; //C-
private String math_dplus; //D+
private String math_dplain; //D
private String math_dminus; //D-
private String math_eplain; //E
private String math_entry;
private String math_av;
private String math_grade;
private String bio_aplain;//A
private String bio_aminus; //A-
private String bio_bplus; //B+
private String bio_bplain; //B
private String bio_bminus; //B-
private String bio_cplus; //C+
private String bio_cplain; //C
private String bio_cminus; //C-
private String bio_dplus; //D+
private String bio_dplain; //D
private String bio_dminus; //D-
private String bio_eplain; //E
private String bio_entry;
private String bio_av;
private String bio_grade;
private String chem_aplain;//A
private String chem_aminus; //A-
private String chem_bplus; //B+
private String chem_bplain; //B
private String chem_bminus; //B-
private String chem_cplus; //C+
private String chem_cplain; //C
private String chem_cminus; //C-
private String chem_dplus; //D+
private String chem_dplain; //D
private String chem_dminus; //D-
private String chem_eplain; //E
private String chem_entry;
private String chem_av;
private String chem_grade;
private String phy_aplain;//A
private String phy_aminus; //A-
private String phy_bplus; //B+
private String phy_bplain; //B
private String phy_bminus; //B-
private String phy_cplus; //C+
private String phy_cplain; //C
private String phy_cminus; //C-
private String phy_dplus; //D+
private String phy_dplain; //D
private String phy_dminus; //D-
private String phy_eplain; //E
private String phy_entry;
private String phy_av;
private String phy_grade;
private String geo_aplain;//A
private String geo_aminus; //A-
private String geo_bplus; //B+
private String geo_bplain; //B
private String geo_bminus; //B-
private String geo_cplus; //C+
private String geo_cplain; //C
private String geo_cminus; //C-
private String geo_dplus; //D+
private String geo_dplain; //D
private String geo_dminus; //D-
private String geo_eplain; //E
private String geo_entry;
private String geo_av;
private String geo_grade;
private String his_aplain;//A
private String his_aminus; //A-
private String his_bplus; //B+
private String his_bplain; //B
private String his_bminus; //B-
private String his_cplus; //C+
private String his_cplain; //C
private String his_cminus; //C-
private String his_dplus; //D+
private String his_dplain; //D
private String his_dminus; //D-
private String his_eplain; //E
private String his_entry;
private String his_av;
private String his_grade;
private String cre_aplain;//A
private String cre_aminus; //A-
private String cre_bplus; //B+
private String cre_bplain; //B
private String cre_bminus; //B-
private String cre_cplus; //C+
private String cre_cplain; //C
private String cre_cminus; //C-
private String cre_dplus; //D+
private String cre_dplain; //D
private String cre_dminus; //D-
private String cre_eplain; //E
private String cre_entry;
private String cre_av;
private String cre_grade;
private String agric_aplain;//A
private String agric_aminus; //A-
private String agric_bplus; //B+
private String agric_bplain; //B
private String agric_bminus; //B-
private String agric_cplus; //C+
private String agric_cplain; //C
private String agric_cminus; //C-
private String agric_dplus; //D+
private String agric_dplain; //D
private String agric_dminus; //D-
private String agric_eplain; //E
private String agric_entry;
private String agric_av;
private String agric_grade;
private String biz_aplain;//A
private String biz_aminus; //A-
private String biz_bplus; //B+
private String biz_bplain; //B
private String biz_bminus; //B-
private String biz_cplus; //C+
private String biz_cplain; //C
private String biz_cminus; //C-
private String biz_dplus; //D+
private String biz_dplain; //D
private String biz_dminus; //D-
private String biz_eplain; //E
private String biz_entry;
private String biz_av;
private String biz_grade;
private String comp_aplain;//A
private String comp_aminus; //A-
private String comp_bplus; //B+
private String comp_bplain; //B
private String comp_bminus; //B-
private String comp_cplus; //C+
private String comp_cplain; //C
private String comp_cminus; //C-
private String comp_dplus; //D+
private String comp_dplain; //D
private String comp_dminus; //D-
private String comp_eplain; //E
private String comp_entry;
private String comp_av;
private String comp_grade;
private String hom_aplain;//A
private String hom_aminus; //A-
private String hom_bplus; //B+
private String hom_bplain; //B
private String hom_bminus; //B-
private String hom_cplus; //C+
private String hom_cplain; //C
private String hom_cminus; //C-
private String hom_dplus; //D+
private String hom_dplain; //D
private String hom_dminus; //D-
private String hom_eplain; //E
private String hom_entry;
private String hom_av;
private String hom_grade;

private String stream;
private String st_entry;
private String aplain;//A
private String aminus; //A-
private String bplus; //B+
private String bplain; //B
private String bminus; //B-
private String cplus; //C+
private String cplain; //C
private String cminus; //C-
private String dplus; //D+
private String dplain; //D
private String dminus; //D-
private String eplain; //E

private String st_av;
private String st_grade;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEng_aplain() {
	return eng_aplain;
}
public void setEng_aplain(String eng_aplain) {
	this.eng_aplain = eng_aplain;
}
public String getEng_aminus() {
	return eng_aminus;
}
public void setEng_aminus(String eng_aminus) {
	this.eng_aminus = eng_aminus;
}
public String getEng_bplus() {
	return eng_bplus;
}
public void setEng_bplus(String eng_bplus) {
	this.eng_bplus = eng_bplus;
}
public String getEng_bplain() {
	return eng_bplain;
}
public void setEng_bplain(String eng_bplain) {
	this.eng_bplain = eng_bplain;
}
public String getEng_bminus() {
	return eng_bminus;
}
public void setEng_bminus(String eng_bminus) {
	this.eng_bminus = eng_bminus;
}
public String getEng_cplus() {
	return eng_cplus;
}
public void setEng_cplus(String eng_cplus) {
	this.eng_cplus = eng_cplus;
}
public String getEng_cplain() {
	return eng_cplain;
}
public void setEng_cplain(String eng_cplain) {
	this.eng_cplain = eng_cplain;
}
public String getEng_cminus() {
	return eng_cminus;
}
public void setEng_cminus(String eng_cminus) {
	this.eng_cminus = eng_cminus;
}
public String getEng_dplus() {
	return eng_dplus;
}
public void setEng_dplus(String eng_dplus) {
	this.eng_dplus = eng_dplus;
}
public String getEng_dplain() {
	return eng_dplain;
}
public void setEng_dplain(String eng_dplain) {
	this.eng_dplain = eng_dplain;
}
public String getEng_dminus() {
	return eng_dminus;
}
public void setEng_dminus(String eng_dminus) {
	this.eng_dminus = eng_dminus;
}
public String getEng_eplain() {
	return eng_eplain;
}
public void setEng_eplain(String eng_eplain) {
	this.eng_eplain = eng_eplain;
}
public String getEng_entry() {
	return eng_entry;
}
public void setEng_entry(String eng_entry) {
	this.eng_entry = eng_entry;
}
public String getKis_aplain() {
	return kis_aplain;
}
public void setKis_aplain(String kis_aplain) {
	this.kis_aplain = kis_aplain;
}
public String getKis_aminus() {
	return kis_aminus;
}
public void setKis_aminus(String kis_aminus) {
	this.kis_aminus = kis_aminus;
}
public String getKis_bplus() {
	return kis_bplus;
}
public void setKis_bplus(String kis_bplus) {
	this.kis_bplus = kis_bplus;
}
public String getKis_bplain() {
	return kis_bplain;
}
public void setKis_bplain(String kis_bplain) {
	this.kis_bplain = kis_bplain;
}
public String getKis_bminus() {
	return kis_bminus;
}
public void setKis_bminus(String kis_bminus) {
	this.kis_bminus = kis_bminus;
}
public String getKis_cplus() {
	return kis_cplus;
}
public void setKis_cplus(String kis_cplus) {
	this.kis_cplus = kis_cplus;
}
public String getKis_cplain() {
	return kis_cplain;
}
public void setKis_cplain(String kis_cplain) {
	this.kis_cplain = kis_cplain;
}
public String getKis_cminus() {
	return kis_cminus;
}
public void setKis_cminus(String kis_cminus) {
	this.kis_cminus = kis_cminus;
}
public String getKis_dplus() {
	return kis_dplus;
}
public void setKis_dplus(String kis_dplus) {
	this.kis_dplus = kis_dplus;
}
public String getKis_dplain() {
	return kis_dplain;
}
public void setKis_dplain(String kis_dplain) {
	this.kis_dplain = kis_dplain;
}
public String getKis_dminus() {
	return kis_dminus;
}
public void setKis_dminus(String kis_dminus) {
	this.kis_dminus = kis_dminus;
}
public String getKis_eplain() {
	return kis_eplain;
}
public void setKis_eplain(String kis_eplain) {
	this.kis_eplain = kis_eplain;
}
public String getKis_entry() {
	return kis_entry;
}
public void setKis_entry(String kis_entry) {
	this.kis_entry = kis_entry;
}
public String getMath_aplain() {
	return math_aplain;
}
public void setMath_aplain(String math_aplain) {
	this.math_aplain = math_aplain;
}
public String getMath_aminus() {
	return math_aminus;
}
public void setMath_aminus(String math_aminus) {
	this.math_aminus = math_aminus;
}
public String getMath_bplus() {
	return math_bplus;
}
public void setMath_bplus(String math_bplus) {
	this.math_bplus = math_bplus;
}
public String getMath_bplain() {
	return math_bplain;
}
public void setMath_bplain(String math_bplain) {
	this.math_bplain = math_bplain;
}
public String getMath_bminus() {
	return math_bminus;
}
public void setMath_bminus(String math_bminus) {
	this.math_bminus = math_bminus;
}
public String getMath_cplus() {
	return math_cplus;
}
public void setMath_cplus(String math_cplus) {
	this.math_cplus = math_cplus;
}
public String getMath_cplain() {
	return math_cplain;
}
public void setMath_cplain(String math_cplain) {
	this.math_cplain = math_cplain;
}
public String getMath_cminus() {
	return math_cminus;
}
public void setMath_cminus(String math_cminus) {
	this.math_cminus = math_cminus;
}
public String getMath_dplus() {
	return math_dplus;
}
public void setMath_dplus(String math_dplus) {
	this.math_dplus = math_dplus;
}
public String getMath_dplain() {
	return math_dplain;
}
public void setMath_dplain(String math_dplain) {
	this.math_dplain = math_dplain;
}
public String getMath_dminus() {
	return math_dminus;
}
public void setMath_dminus(String math_dminus) {
	this.math_dminus = math_dminus;
}
public String getMath_eplain() {
	return math_eplain;
}
public void setMath_eplain(String math_eplain) {
	this.math_eplain = math_eplain;
}
public String getMath_entry() {
	return math_entry;
}
public void setMath_entry(String math_entry) {
	this.math_entry = math_entry;
}
public String getBio_aplain() {
	return bio_aplain;
}
public void setBio_aplain(String bio_aplain) {
	this.bio_aplain = bio_aplain;
}
public String getBio_aminus() {
	return bio_aminus;
}
public void setBio_aminus(String bio_aminus) {
	this.bio_aminus = bio_aminus;
}
public String getBio_bplus() {
	return bio_bplus;
}
public void setBio_bplus(String bio_bplus) {
	this.bio_bplus = bio_bplus;
}
public String getBio_bplain() {
	return bio_bplain;
}
public void setBio_bplain(String bio_bplain) {
	this.bio_bplain = bio_bplain;
}
public String getBio_bminus() {
	return bio_bminus;
}
public void setBio_bminus(String bio_bminus) {
	this.bio_bminus = bio_bminus;
}
public String getBio_cplus() {
	return bio_cplus;
}
public void setBio_cplus(String bio_cplus) {
	this.bio_cplus = bio_cplus;
}
public String getBio_cplain() {
	return bio_cplain;
}
public void setBio_cplain(String bio_cplain) {
	this.bio_cplain = bio_cplain;
}
public String getBio_cminus() {
	return bio_cminus;
}
public void setBio_cminus(String bio_cminus) {
	this.bio_cminus = bio_cminus;
}
public String getBio_dplus() {
	return bio_dplus;
}
public void setBio_dplus(String bio_dplus) {
	this.bio_dplus = bio_dplus;
}
public String getBio_dplain() {
	return bio_dplain;
}
public void setBio_dplain(String bio_dplain) {
	this.bio_dplain = bio_dplain;
}
public String getBio_dminus() {
	return bio_dminus;
}
public void setBio_dminus(String bio_dminus) {
	this.bio_dminus = bio_dminus;
}
public String getBio_eplain() {
	return bio_eplain;
}
public void setBio_eplain(String bio_eplain) {
	this.bio_eplain = bio_eplain;
}
public String getBio_entry() {
	return bio_entry;
}
public void setBio_entry(String bio_entry) {
	this.bio_entry = bio_entry;
}
public String getChem_aplain() {
	return chem_aplain;
}
public void setChem_aplain(String chem_aplain) {
	this.chem_aplain = chem_aplain;
}
public String getChem_aminus() {
	return chem_aminus;
}
public void setChem_aminus(String chem_aminus) {
	this.chem_aminus = chem_aminus;
}
public String getChem_bplus() {
	return chem_bplus;
}
public void setChem_bplus(String chem_bplus) {
	this.chem_bplus = chem_bplus;
}
public String getChem_bplain() {
	return chem_bplain;
}
public void setChem_bplain(String chem_bplain) {
	this.chem_bplain = chem_bplain;
}
public String getChem_bminus() {
	return chem_bminus;
}
public void setChem_bminus(String chem_bminus) {
	this.chem_bminus = chem_bminus;
}
public String getChem_cplus() {
	return chem_cplus;
}
public void setChem_cplus(String chem_cplus) {
	this.chem_cplus = chem_cplus;
}
public String getChem_cplain() {
	return chem_cplain;
}
public void setChem_cplain(String chem_cplain) {
	this.chem_cplain = chem_cplain;
}
public String getChem_cminus() {
	return chem_cminus;
}
public void setChem_cminus(String chem_cminus) {
	this.chem_cminus = chem_cminus;
}
public String getChem_dplus() {
	return chem_dplus;
}
public void setChem_dplus(String chem_dplus) {
	this.chem_dplus = chem_dplus;
}
public String getChem_dplain() {
	return chem_dplain;
}
public void setChem_dplain(String chem_dplain) {
	this.chem_dplain = chem_dplain;
}
public String getChem_dminus() {
	return chem_dminus;
}
public void setChem_dminus(String chem_dminus) {
	this.chem_dminus = chem_dminus;
}
public String getChem_eplain() {
	return chem_eplain;
}
public void setChem_eplain(String chem_eplain) {
	this.chem_eplain = chem_eplain;
}
public String getChem_entry() {
	return chem_entry;
}
public void setChem_entry(String chem_entry) {
	this.chem_entry = chem_entry;
}
public String getPhy_aplain() {
	return phy_aplain;
}
public void setPhy_aplain(String phy_aplain) {
	this.phy_aplain = phy_aplain;
}
public String getPhy_aminus() {
	return phy_aminus;
}
public void setPhy_aminus(String phy_aminus) {
	this.phy_aminus = phy_aminus;
}
public String getPhy_bplus() {
	return phy_bplus;
}
public void setPhy_bplus(String phy_bplus) {
	this.phy_bplus = phy_bplus;
}
public String getPhy_bplain() {
	return phy_bplain;
}
public void setPhy_bplain(String phy_bplain) {
	this.phy_bplain = phy_bplain;
}
public String getPhy_bminus() {
	return phy_bminus;
}
public void setPhy_bminus(String phy_bminus) {
	this.phy_bminus = phy_bminus;
}
public String getPhy_cplus() {
	return phy_cplus;
}
public void setPhy_cplus(String phy_cplus) {
	this.phy_cplus = phy_cplus;
}
public String getPhy_cplain() {
	return phy_cplain;
}
public void setPhy_cplain(String phy_cplain) {
	this.phy_cplain = phy_cplain;
}
public String getPhy_cminus() {
	return phy_cminus;
}
public void setPhy_cminus(String phy_cminus) {
	this.phy_cminus = phy_cminus;
}
public String getPhy_dplus() {
	return phy_dplus;
}
public void setPhy_dplus(String phy_dplus) {
	this.phy_dplus = phy_dplus;
}
public String getPhy_dplain() {
	return phy_dplain;
}
public void setPhy_dplain(String phy_dplain) {
	this.phy_dplain = phy_dplain;
}
public String getPhy_dminus() {
	return phy_dminus;
}
public void setPhy_dminus(String phy_dminus) {
	this.phy_dminus = phy_dminus;
}
public String getPhy_eplain() {
	return phy_eplain;
}
public void setPhy_eplain(String phy_eplain) {
	this.phy_eplain = phy_eplain;
}
public String getPhy_entry() {
	return phy_entry;
}
public void setPhy_entry(String phy_entry) {
	this.phy_entry = phy_entry;
}
public String getGeo_aplain() {
	return geo_aplain;
}
public void setGeo_aplain(String geo_aplain) {
	this.geo_aplain = geo_aplain;
}
public String getGeo_aminus() {
	return geo_aminus;
}
public void setGeo_aminus(String geo_aminus) {
	this.geo_aminus = geo_aminus;
}
public String getGeo_bplus() {
	return geo_bplus;
}
public void setGeo_bplus(String geo_bplus) {
	this.geo_bplus = geo_bplus;
}
public String getGeo_bplain() {
	return geo_bplain;
}
public void setGeo_bplain(String geo_bplain) {
	this.geo_bplain = geo_bplain;
}
public String getGeo_bminus() {
	return geo_bminus;
}
public void setGeo_bminus(String geo_bminus) {
	this.geo_bminus = geo_bminus;
}
public String getGeo_cplus() {
	return geo_cplus;
}
public void setGeo_cplus(String geo_cplus) {
	this.geo_cplus = geo_cplus;
}
public String getGeo_cplain() {
	return geo_cplain;
}
public void setGeo_cplain(String geo_cplain) {
	this.geo_cplain = geo_cplain;
}
public String getGeo_cminus() {
	return geo_cminus;
}
public void setGeo_cminus(String geo_cminus) {
	this.geo_cminus = geo_cminus;
}
public String getGeo_dplus() {
	return geo_dplus;
}
public void setGeo_dplus(String geo_dplus) {
	this.geo_dplus = geo_dplus;
}
public String getGeo_dplain() {
	return geo_dplain;
}
public void setGeo_dplain(String geo_dplain) {
	this.geo_dplain = geo_dplain;
}
public String getGeo_dminus() {
	return geo_dminus;
}
public void setGeo_dminus(String geo_dminus) {
	this.geo_dminus = geo_dminus;
}
public String getGeo_eplain() {
	return geo_eplain;
}
public void setGeo_eplain(String geo_eplain) {
	this.geo_eplain = geo_eplain;
}
public String getGeo_entry() {
	return geo_entry;
}
public void setGeo_entry(String geo_entry) {
	this.geo_entry = geo_entry;
}
public String getHis_aplain() {
	return his_aplain;
}
public void setHis_aplain(String his_aplain) {
	this.his_aplain = his_aplain;
}
public String getHis_aminus() {
	return his_aminus;
}
public void setHis_aminus(String his_aminus) {
	this.his_aminus = his_aminus;
}
public String getHis_bplus() {
	return his_bplus;
}
public void setHis_bplus(String his_bplus) {
	this.his_bplus = his_bplus;
}
public String getHis_bplain() {
	return his_bplain;
}
public void setHis_bplain(String his_bplain) {
	this.his_bplain = his_bplain;
}
public String getHis_bminus() {
	return his_bminus;
}
public void setHis_bminus(String his_bminus) {
	this.his_bminus = his_bminus;
}
public String getHis_cplus() {
	return his_cplus;
}
public void setHis_cplus(String his_cplus) {
	this.his_cplus = his_cplus;
}
public String getHis_cplain() {
	return his_cplain;
}
public void setHis_cplain(String his_cplain) {
	this.his_cplain = his_cplain;
}
public String getHis_cminus() {
	return his_cminus;
}
public void setHis_cminus(String his_cminus) {
	this.his_cminus = his_cminus;
}
public String getHis_dplus() {
	return his_dplus;
}
public void setHis_dplus(String his_dplus) {
	this.his_dplus = his_dplus;
}
public String getHis_dplain() {
	return his_dplain;
}
public void setHis_dplain(String his_dplain) {
	this.his_dplain = his_dplain;
}
public String getHis_dminus() {
	return his_dminus;
}
public void setHis_dminus(String his_dminus) {
	this.his_dminus = his_dminus;
}
public String getHis_eplain() {
	return his_eplain;
}
public void setHis_eplain(String his_eplain) {
	this.his_eplain = his_eplain;
}
public String getHis_entry() {
	return his_entry;
}
public void setHis_entry(String his_entry) {
	this.his_entry = his_entry;
}
public String getCre_aplain() {
	return cre_aplain;
}
public void setCre_aplain(String cre_aplain) {
	this.cre_aplain = cre_aplain;
}
public String getCre_aminus() {
	return cre_aminus;
}
public void setCre_aminus(String cre_aminus) {
	this.cre_aminus = cre_aminus;
}
public String getCre_bplus() {
	return cre_bplus;
}
public void setCre_bplus(String cre_bplus) {
	this.cre_bplus = cre_bplus;
}
public String getCre_bplain() {
	return cre_bplain;
}
public void setCre_bplain(String cre_bplain) {
	this.cre_bplain = cre_bplain;
}
public String getCre_bminus() {
	return cre_bminus;
}
public void setCre_bminus(String cre_bminus) {
	this.cre_bminus = cre_bminus;
}
public String getCre_cplus() {
	return cre_cplus;
}
public void setCre_cplus(String cre_cplus) {
	this.cre_cplus = cre_cplus;
}
public String getCre_cplain() {
	return cre_cplain;
}
public void setCre_cplain(String cre_cplain) {
	this.cre_cplain = cre_cplain;
}
public String getCre_cminus() {
	return cre_cminus;
}
public void setCre_cminus(String cre_cminus) {
	this.cre_cminus = cre_cminus;
}
public String getCre_dplus() {
	return cre_dplus;
}
public void setCre_dplus(String cre_dplus) {
	this.cre_dplus = cre_dplus;
}
public String getCre_dplain() {
	return cre_dplain;
}
public void setCre_dplain(String cre_dplain) {
	this.cre_dplain = cre_dplain;
}
public String getCre_dminus() {
	return cre_dminus;
}
public void setCre_dminus(String cre_dminus) {
	this.cre_dminus = cre_dminus;
}
public String getCre_eplain() {
	return cre_eplain;
}
public void setCre_eplain(String cre_eplain) {
	this.cre_eplain = cre_eplain;
}
public String getCre_entry() {
	return cre_entry;
}
public void setCre_entry(String cre_entry) {
	this.cre_entry = cre_entry;
}
public String getAgric_aplain() {
	return agric_aplain;
}
public void setAgric_aplain(String agric_aplain) {
	this.agric_aplain = agric_aplain;
}
public String getAgric_aminus() {
	return agric_aminus;
}
public void setAgric_aminus(String agric_aminus) {
	this.agric_aminus = agric_aminus;
}
public String getAgric_bplus() {
	return agric_bplus;
}
public void setAgric_bplus(String agric_bplus) {
	this.agric_bplus = agric_bplus;
}
public String getAgric_bplain() {
	return agric_bplain;
}
public void setAgric_bplain(String agric_bplain) {
	this.agric_bplain = agric_bplain;
}
public String getAgric_bminus() {
	return agric_bminus;
}
public void setAgric_bminus(String agric_bminus) {
	this.agric_bminus = agric_bminus;
}
public String getAgric_cplus() {
	return agric_cplus;
}
public void setAgric_cplus(String agric_cplus) {
	this.agric_cplus = agric_cplus;
}
public String getAgric_cplain() {
	return agric_cplain;
}
public void setAgric_cplain(String agric_cplain) {
	this.agric_cplain = agric_cplain;
}
public String getAgric_cminus() {
	return agric_cminus;
}
public void setAgric_cminus(String agric_cminus) {
	this.agric_cminus = agric_cminus;
}
public String getAgric_dplus() {
	return agric_dplus;
}
public void setAgric_dplus(String agric_dplus) {
	this.agric_dplus = agric_dplus;
}
public String getAgric_dplain() {
	return agric_dplain;
}
public void setAgric_dplain(String agric_dplain) {
	this.agric_dplain = agric_dplain;
}
public String getAgric_dminus() {
	return agric_dminus;
}
public void setAgric_dminus(String agric_dminus) {
	this.agric_dminus = agric_dminus;
}
public String getAgric_eplain() {
	return agric_eplain;
}
public void setAgric_eplain(String agric_eplain) {
	this.agric_eplain = agric_eplain;
}
public String getAgric_entry() {
	return agric_entry;
}
public void setAgric_entry(String agric_entry) {
	this.agric_entry = agric_entry;
}
public String getBiz_aplain() {
	return biz_aplain;
}
public void setBiz_aplain(String biz_aplain) {
	this.biz_aplain = biz_aplain;
}
public String getBiz_aminus() {
	return biz_aminus;
}
public void setBiz_aminus(String biz_aminus) {
	this.biz_aminus = biz_aminus;
}
public String getBiz_bplus() {
	return biz_bplus;
}
public void setBiz_bplus(String biz_bplus) {
	this.biz_bplus = biz_bplus;
}
public String getBiz_bplain() {
	return biz_bplain;
}
public void setBiz_bplain(String biz_bplain) {
	this.biz_bplain = biz_bplain;
}
public String getBiz_bminus() {
	return biz_bminus;
}
public void setBiz_bminus(String biz_bminus) {
	this.biz_bminus = biz_bminus;
}
public String getBiz_cplus() {
	return biz_cplus;
}
public void setBiz_cplus(String biz_cplus) {
	this.biz_cplus = biz_cplus;
}
public String getBiz_cplain() {
	return biz_cplain;
}
public void setBiz_cplain(String biz_cplain) {
	this.biz_cplain = biz_cplain;
}
public String getBiz_cminus() {
	return biz_cminus;
}
public void setBiz_cminus(String biz_cminus) {
	this.biz_cminus = biz_cminus;
}
public String getBiz_dplus() {
	return biz_dplus;
}
public void setBiz_dplus(String biz_dplus) {
	this.biz_dplus = biz_dplus;
}
public String getBiz_dplain() {
	return biz_dplain;
}
public void setBiz_dplain(String biz_dplain) {
	this.biz_dplain = biz_dplain;
}
public String getBiz_dminus() {
	return biz_dminus;
}
public void setBiz_dminus(String biz_dminus) {
	this.biz_dminus = biz_dminus;
}
public String getBiz_eplain() {
	return biz_eplain;
}
public void setBiz_eplain(String biz_eplain) {
	this.biz_eplain = biz_eplain;
}
public String getBiz_entry() {
	return biz_entry;
}
public void setBiz_entry(String biz_entry) {
	this.biz_entry = biz_entry;
}
public String getComp_aplain() {
	return comp_aplain;
}
public void setComp_aplain(String comp_aplain) {
	this.comp_aplain = comp_aplain;
}
public String getComp_aminus() {
	return comp_aminus;
}
public void setComp_aminus(String comp_aminus) {
	this.comp_aminus = comp_aminus;
}
public String getComp_bplus() {
	return comp_bplus;
}
public void setComp_bplus(String comp_bplus) {
	this.comp_bplus = comp_bplus;
}
public String getComp_bplain() {
	return comp_bplain;
}
public void setComp_bplain(String comp_bplain) {
	this.comp_bplain = comp_bplain;
}
public String getComp_bminus() {
	return comp_bminus;
}
public void setComp_bminus(String comp_bminus) {
	this.comp_bminus = comp_bminus;
}
public String getComp_cplus() {
	return comp_cplus;
}
public void setComp_cplus(String comp_cplus) {
	this.comp_cplus = comp_cplus;
}
public String getComp_cplain() {
	return comp_cplain;
}
public void setComp_cplain(String comp_cplain) {
	this.comp_cplain = comp_cplain;
}
public String getComp_cminus() {
	return comp_cminus;
}
public void setComp_cminus(String comp_cminus) {
	this.comp_cminus = comp_cminus;
}
public String getComp_dplus() {
	return comp_dplus;
}
public void setComp_dplus(String comp_dplus) {
	this.comp_dplus = comp_dplus;
}
public String getComp_dplain() {
	return comp_dplain;
}
public void setComp_dplain(String comp_dplain) {
	this.comp_dplain = comp_dplain;
}
public String getComp_dminus() {
	return comp_dminus;
}
public void setComp_dminus(String comp_dminus) {
	this.comp_dminus = comp_dminus;
}
public String getComp_eplain() {
	return comp_eplain;
}
public void setComp_eplain(String comp_eplain) {
	this.comp_eplain = comp_eplain;
}
public String getComp_entry() {
	return comp_entry;
}
public void setComp_entry(String comp_entry) {
	this.comp_entry = comp_entry;
}
public String getHom_aplain() {
	return hom_aplain;
}
public void setHom_aplain(String hom_aplain) {
	this.hom_aplain = hom_aplain;
}
public String getHom_aminus() {
	return hom_aminus;
}
public void setHom_aminus(String hom_aminus) {
	this.hom_aminus = hom_aminus;
}
public String getHom_bplus() {
	return hom_bplus;
}
public void setHom_bplus(String hom_bplus) {
	this.hom_bplus = hom_bplus;
}
public String getHom_bplain() {
	return hom_bplain;
}
public void setHom_bplain(String hom_bplain) {
	this.hom_bplain = hom_bplain;
}
public String getHom_bminus() {
	return hom_bminus;
}
public void setHom_bminus(String hom_bminus) {
	this.hom_bminus = hom_bminus;
}
public String getHom_cplus() {
	return hom_cplus;
}
public void setHom_cplus(String hom_cplus) {
	this.hom_cplus = hom_cplus;
}
public String getHom_cplain() {
	return hom_cplain;
}
public void setHom_cplain(String hom_cplain) {
	this.hom_cplain = hom_cplain;
}
public String getHom_cminus() {
	return hom_cminus;
}
public void setHom_cminus(String hom_cminus) {
	this.hom_cminus = hom_cminus;
}
public String getHom_dplus() {
	return hom_dplus;
}
public void setHom_dplus(String hom_dplus) {
	this.hom_dplus = hom_dplus;
}
public String getHom_dplain() {
	return hom_dplain;
}
public void setHom_dplain(String hom_dplain) {
	this.hom_dplain = hom_dplain;
}
public String getHom_dminus() {
	return hom_dminus;
}
public void setHom_dminus(String hom_dminus) {
	this.hom_dminus = hom_dminus;
}
public String getHom_eplain() {
	return hom_eplain;
}
public void setHom_eplain(String hom_eplain) {
	this.hom_eplain = hom_eplain;
}
public String getHom_entry() {
	return hom_entry;
}
public void setHom_entry(String hom_entry) {
	this.hom_entry = hom_entry;
}
public String getEng_av() {
	return eng_av;
}
public void setEng_av(String eng_av) {
	this.eng_av = eng_av;
}
public String getEng_grade() {
	return eng_grade;
}
public void setEng_grade(String eng_grade) {
	this.eng_grade = eng_grade;
}
public String getKis_av() {
	return kis_av;
}
public void setKis_av(String kis_av) {
	this.kis_av = kis_av;
}
public String getKis_grade() {
	return kis_grade;
}
public void setKis_grade(String kis_grade) {
	this.kis_grade = kis_grade;
}
public String getMath_av() {
	return math_av;
}
public void setMath_av(String math_av) {
	this.math_av = math_av;
}
public String getMath_grade() {
	return math_grade;
}
public void setMath_grade(String math_grade) {
	this.math_grade = math_grade;
}
public String getBio_av() {
	return bio_av;
}
public void setBio_av(String bio_av) {
	this.bio_av = bio_av;
}
public String getBio_grade() {
	return bio_grade;
}
public void setBio_grade(String bio_grade) {
	this.bio_grade = bio_grade;
}
public String getChem_av() {
	return chem_av;
}
public void setChem_av(String chem_av) {
	this.chem_av = chem_av;
}
public String getChem_grade() {
	return chem_grade;
}
public void setChem_grade(String chem_grade) {
	this.chem_grade = chem_grade;
}
public String getPhy_av() {
	return phy_av;
}
public void setPhy_av(String phy_av) {
	this.phy_av = phy_av;
}
public String getPhy_grade() {
	return phy_grade;
}
public void setPhy_grade(String phy_grade) {
	this.phy_grade = phy_grade;
}
public String getGeo_av() {
	return geo_av;
}
public void setGeo_av(String geo_av) {
	this.geo_av = geo_av;
}
public String getGeo_grade() {
	return geo_grade;
}
public void setGeo_grade(String geo_grade) {
	this.geo_grade = geo_grade;
}
public String getHis_av() {
	return his_av;
}
public void setHis_av(String his_av) {
	this.his_av = his_av;
}
public String getHis_grade() {
	return his_grade;
}
public void setHis_grade(String his_grade) {
	this.his_grade = his_grade;
}
public String getCre_av() {
	return cre_av;
}
public void setCre_av(String cre_av) {
	this.cre_av = cre_av;
}
public String getCre_grade() {
	return cre_grade;
}
public void setCre_grade(String cre_grade) {
	this.cre_grade = cre_grade;
}
public String getAgric_av() {
	return agric_av;
}
public void setAgric_av(String agric_av) {
	this.agric_av = agric_av;
}
public String getAgric_grade() {
	return agric_grade;
}
public void setAgric_grade(String agric_grade) {
	this.agric_grade = agric_grade;
}
public String getBiz_av() {
	return biz_av;
}
public void setBiz_av(String biz_av) {
	this.biz_av = biz_av;
}
public String getBiz_grade() {
	return biz_grade;
}
public void setBiz_grade(String biz_grade) {
	this.biz_grade = biz_grade;
}
public String getComp_av() {
	return comp_av;
}
public void setComp_av(String comp_av) {
	this.comp_av = comp_av;
}
public String getComp_grade() {
	return comp_grade;
}
public void setComp_grade(String comp_grade) {
	this.comp_grade = comp_grade;
}
public String getHom_av() {
	return hom_av;
}
public void setHom_av(String hom_av) {
	this.hom_av = hom_av;
}
public String getHom_grade() {
	return hom_grade;
}
public void setHom_grade(String hom_grade) {
	this.hom_grade = hom_grade;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}
public String getSt_entry() {
	return st_entry;
}
public void setSt_entry(String st_entry) {
	this.st_entry = st_entry;
}
public String getAplain() {
	return aplain;
}
public void setAplain(String aplain) {
	this.aplain = aplain;
}
public String getAminus() {
	return aminus;
}
public void setAminus(String aminus) {
	this.aminus = aminus;
}
public String getBplus() {
	return bplus;
}
public void setBplus(String bplus) {
	this.bplus = bplus;
}
public String getBplain() {
	return bplain;
}
public void setBplain(String bplain) {
	this.bplain = bplain;
}
public String getBminus() {
	return bminus;
}
public void setBminus(String bminus) {
	this.bminus = bminus;
}
public String getCplus() {
	return cplus;
}
public void setCplus(String cplus) {
	this.cplus = cplus;
}
public String getCplain() {
	return cplain;
}
public void setCplain(String cplain) {
	this.cplain = cplain;
}
public String getCminus() {
	return cminus;
}
public void setCminus(String cminus) {
	this.cminus = cminus;
}
public String getDplus() {
	return dplus;
}
public void setDplus(String dplus) {
	this.dplus = dplus;
}
public String getDplain() {
	return dplain;
}
public void setDplain(String dplain) {
	this.dplain = dplain;
}
public String getDminus() {
	return dminus;
}
public void setDminus(String dminus) {
	this.dminus = dminus;
}
public String getEplain() {
	return eplain;
}
public void setEplain(String eplain) {
	this.eplain = eplain;
}
public String getSt_av() {
	return st_av;
}
public void setSt_av(String st_av) {
	this.st_av = st_av;
}
public String getSt_grade() {
	return st_grade;
}
public void setSt_grade(String st_grade) {
	this.st_grade = st_grade;
}

}
