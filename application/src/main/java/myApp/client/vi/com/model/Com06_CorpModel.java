package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com06_CorpModel implements GridDataModel { 

	private Long    corpId ;
	private String  cmpCode ;
	private String  corpCode ;
	private String  corpName ;
	private String  corpTypeCode ;
	private String  bizRegNo ;
	private String  corpRegNo ;
	private Long  	grpCorpCode ;
	private String  stlBnkCode ;
	private String  stlBnkAcntNo ;
	private String  kscCorpCode ;
	private Long  	stnIndClassCode ;
	private String  estDate ;
	private String  reprName ;
	private String  telNo ;
	private String  addr ;
	private String  intTypeCode ;
	private String  abroTypeCode ;
	private String  dshTypeCode ;
	private String  useYn ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  useYnFlag ;
	
	@Override
	public void setKeyId(Long id) {
		this.corpId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getCorpId(); 
	}
	public Long getCorpId() {
		return corpId;
	}

	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpTypeCode() {
		return corpTypeCode;
	}

	public void setCorpTypeCode(String corpTypeCode) {
		this.corpTypeCode = corpTypeCode;
	}

	public String getBizRegNo() {
		return bizRegNo;
	}

	public void setBizRegNo(String bizRegNo) {
		this.bizRegNo = bizRegNo;
	}

	public String getCorpRegNo() {
		return corpRegNo;
	}

	public void setCorpRegNo(String corpRegNo) {
		this.corpRegNo = corpRegNo;
	}

	public Long getGrpCorpCode() {
		return grpCorpCode;
	}

	public void setGrpCorpCode(Long grpCorpCode) {
		this.grpCorpCode = grpCorpCode;
	}

	public String getStlBnkCode() {
		return stlBnkCode;
	}

	public void setStlBnkCode(String stlBnkCode) {
		this.stlBnkCode = stlBnkCode;
	}

	public String getStlBnkAcntNo() {
		return stlBnkAcntNo;
	}

	public void setStlBnkAcntNo(String stlBnkAcntNo) {
		this.stlBnkAcntNo = stlBnkAcntNo;
	}

	public String getKscCorpCode() {
		return kscCorpCode;
	}

	public void setKscCorpCode(String kscCorpCode) {
		this.kscCorpCode = kscCorpCode;
	}

	public Long getStnIndClassCode() {
		return stnIndClassCode;
	}

	public void setStnIndClassCode(Long stnIndClassCode) {
		this.stnIndClassCode = stnIndClassCode;
	}

	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public String getReprName() {
		return reprName;
	}

	public void setReprName(String reprName) {
		this.reprName = reprName;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIntTypeCode() {
		return intTypeCode;
	}

	public void setIntTypeCode(String intTypeCode) {
		this.intTypeCode = intTypeCode;
	}

	public String getAbroTypeCode() {
		return abroTypeCode;
	}

	public void setAbroTypeCode(String abroTypeCode) {
		this.abroTypeCode = abroTypeCode;
	}

	public String getDshTypeCode() {
		return dshTypeCode;
	}

	public void setDshTypeCode(String dshTypeCode) {
		this.dshTypeCode = dshTypeCode;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getInsUsrNo() {
		return insUsrNo;
	}

	public void setInsUsrNo(String insUsrNo) {
		this.insUsrNo = insUsrNo;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getUpdUsrNo() {
		return updUsrNo;
	}

	public void setUpdUsrNo(String updUsrNo) {
		this.updUsrNo = updUsrNo;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}


	public boolean isUseYnFlag() {
		if("Y".equals(getUseYn())) {
			return true;
		} else {
			return false;
		}
	}

	public void setUseYnFlag(boolean useYnFlag) {
		if(useYnFlag) {
			this.useYn = "Y";
		} else {
			this.useYn = "N";
		}
	}
}
