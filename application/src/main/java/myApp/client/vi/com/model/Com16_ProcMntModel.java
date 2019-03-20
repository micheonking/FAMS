package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com16_ProcMntModel implements GridDataModel { 

	private Long    procMntId;
	private String  cmpCode;
	private String  stdDate;
	private String  fndCode;
	private String  bizSttYn;
	private String  tdyRghYn;
	private String  printRcvYn;
	private String  trCloYn;
	private String  mktPrcYn;
	private String  cloChkYn;
	private String  cloYn;
	private String  bizEndYn;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;
	
	private boolean  bizSttYnFlag;
	
	@Override
	public void setKeyId(Long id) {
		this.procMntId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getProcMntId(); 
	}

	public Long getProcMntId() {
		return procMntId;
	}

	public void setProcMntId(Long procMntId) {
		this.procMntId = procMntId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getStdDate() {
		return stdDate;
	}

	public void setStdDate(String stdDate) {
		this.stdDate = stdDate;
	}

	public String getFndCode() {
		return fndCode;
	}

	public void setFndCode(String fndCode) {
		this.fndCode = fndCode;
	}

	public String getBizSttYn() {
		return bizSttYn;
	}

	public void setBizSttYn(String bizSttYn) {
		this.bizSttYn = bizSttYn;
	}

	public String getTdyRghYn() {
		return tdyRghYn;
	}

	public void setTdyRghYn(String tdyRghYn) {
		this.tdyRghYn = tdyRghYn;
	}

	public String getPrintRcvYn() {
		return printRcvYn;
	}

	public void setPrintRcvYn(String printRcvYn) {
		this.printRcvYn = printRcvYn;
	}

	public String getTrCloYn() {
		return trCloYn;
	}

	public void setTrCloYn(String trCloYn) {
		this.trCloYn = trCloYn;
	}

	public String getMktPrcYn() {
		return mktPrcYn;
	}

	public void setMktPrcYn(String mktPrcYn) {
		this.mktPrcYn = mktPrcYn;
	}

	public String getCloChkYn() {
		return cloChkYn;
	}

	public void setCloChkYn(String cloChkYn) {
		this.cloChkYn = cloChkYn;
	}

	public String getCloYn() {
		return cloYn;
	}

	public void setCloYn(String cloYn) {
		this.cloYn = cloYn;
	}

	public String getBizEndYn() {
		return bizEndYn;
	}

	public void setBizEndYn(String bizEndYn) {
		this.bizEndYn = bizEndYn;
	}

	public boolean isBizSttYnFlag() {
		return bizSttYnFlag;
	}

	public void setBizSttYnFlag(boolean bizSttYnFlag) {
		this.bizSttYnFlag = bizSttYnFlag;
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
