package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com07_CorpAcntModel implements GridDataModel { 

	private Long    corpAcntId ;
	private String  cmpCode ;
	private String  corpCode ;
	private String  acntNo ;
	private String  acntName ;
	private String  bnkCode ;
	private String  brnCode ;
	private String  tel ;
	private String  fax ;
	private String  acntKndCode ;
	private String  mng ;
	private String  rmk ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	@Override
	public void setKeyId(Long id) {
		this.corpAcntId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getCorpAcntId(); 
	}
	
	public Long getCorpId() {
		return corpAcntId;
	}

	public Long getCorpAcntId() {
		return corpAcntId;
	}

	public void setCorpAcntId(Long corpAcntId) {
		this.corpAcntId = corpAcntId;
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

	public String getAcntNo() {
		return acntNo;
	}

	public void setAcntNo(String acntNo) {
		this.acntNo = acntNo;
	}

	public String getAcntName() {
		return acntName;
	}

	public void setAcntName(String acntName) {
		this.acntName = acntName;
	}

	public String getBnkCode() {
		return bnkCode;
	}

	public void setBnkCode(String bnkCode) {
		this.bnkCode = bnkCode;
	}

	public String getBrnCode() {
		return brnCode;
	}

	public void setBrnCode(String brnCode) {
		this.brnCode = brnCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAcntKndCode() {
		return acntKndCode;
	}

	public void setAcntKndCode(String acntKndCode) {
		this.acntKndCode = acntKndCode;
	}

	public String getMng() {
		return mng;
	}

	public void setMng(String mng) {
		this.mng = mng;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
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

	
}
