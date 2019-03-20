package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com04_TrCodeModel implements GridDataModel { 

	private Long    trCdId ;
	private String  trCode ;
	private String  trName ;
	private String  trOccTypeCode ;
	private String  seq ;
	private String  applProcYn ;
	private String  accSndYn ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  applProcYnFlag ;
	private boolean  accSndYnFlag ;
	
	@Override
	public void setKeyId(Long id) {
		this.trCdId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getTrCdId(); 
	}

	public Long getTrCdId() {
		return trCdId;
	}

	public void setTrCdId(Long trCdId) {
		this.trCdId = trCdId;
	}

	public String getTrCode() {
		return trCode;
	}

	public void setTrCode(String trCode) {
		this.trCode = trCode;
	}

	public String getTrName() {
		return trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public String getTrOccTypeCode() {
		return trOccTypeCode;
	}

	public void setTrOccTypeCode(String trOccTypeCode) {
		this.trOccTypeCode = trOccTypeCode;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getApplProcYn() {
		return applProcYn;
	}

	public void setApplProcYn(String applProcYn) {
		this.applProcYn = applProcYn;
	}

	public String getAccSndYn() {
		return accSndYn;
	}

	public void setAccSndYn(String accSndYn) {
		this.accSndYn = accSndYn;
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

	public boolean isApplProcYnFlag() {
		if("Y".equals(getApplProcYn())) {
			return true;
		} else {
			return false;
		}
	}

	public void setApplProcYnFlag(boolean applProcYnFlag) {
		if(applProcYnFlag) {
			this.applProcYn = "Y";
		} else {
			this.applProcYn = "N";
		}
	}

	public boolean isAccSndYnFlag() {
		if("Y".equals(getAccSndYn())) {
			return true;
		} else {
			return false;
		}
	}

	public void setAccSndYnFlag(boolean accSndYnFlag) {
		if(accSndYnFlag) {
			this.accSndYn = "Y";
		} else {
			this.accSndYn = "N";
		}
	}

	
}
