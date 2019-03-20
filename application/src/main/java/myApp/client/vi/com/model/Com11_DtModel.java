package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com11_DtModel implements GridDataModel { 

	private Long    dtId ;
	private String  cmpCode ;
	private String  ntnCode ;
	private String  stdDate ;
	private String  hdayTypeCode ;
	private String  hdayName ;
	private String  dfwTypeCode ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	@Override
	public void setKeyId(Long id) {
		this.dtId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getDtId(); 
	}

	public Long getDtId() {
		return dtId;
	}

	public void setDtId(Long dtId) {
		this.dtId = dtId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getNtnCode() {
		return ntnCode;
	}

	public void setNtnCode(String ntnCode) {
		this.ntnCode = ntnCode;
	}

	public String getStdDate() {
		return stdDate;
	}

	public void setStdDate(String stdDate) {
		this.stdDate = stdDate;
	}

	public String getHdayTypeCode() {
		return hdayTypeCode;
	}

	public void setHdayTypeCode(String hdayTypeCode) {
		this.hdayTypeCode = hdayTypeCode;
	}

	public String getHdayName() {
		return hdayName;
	}

	public void setHdayName(String hdayName) {
		this.hdayName = hdayName;
	}

	public String getDfwTypeCode() {
		return dfwTypeCode;
	}

	public void setDfwTypeCode(String dfwTypeCode) {
		this.dfwTypeCode = dfwTypeCode;
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
