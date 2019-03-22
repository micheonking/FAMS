package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com10_TaxSysModel implements GridDataModel { 

	private Long    taxSysId ;
	private String  taxSysTypeCode ;
	private String  taxRtTypeCode ;
	private String  trsRulApyTypeCode ;
	private String  trsRulTgtTypCode ;
	private String  appSdd ;
	private String  apyEdd ;
	private String  trsRulXtncTypeCode ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  useYnFlag ;
	
	@Override
	public void setKeyId(Long id) {
		this.taxSysId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getTaxSysId(); 
	}

	public Long getTaxSysId() {
		return taxSysId;
	}

	public void setTaxSysId(Long taxSysId) {
		this.taxSysId = taxSysId;
	}

	public String getTaxSysTypeCode() {
		return taxSysTypeCode;
	}

	public void setTaxSysTypeCode(String taxSysTypeCode) {
		this.taxSysTypeCode = taxSysTypeCode;
	}

	public String getTaxRtTypeCode() {
		return taxRtTypeCode;
	}

	public void setTaxRtTypeCode(String taxRtTypeCode) {
		this.taxRtTypeCode = taxRtTypeCode;
	}

	public String getTrsRulApyTypeCode() {
		return trsRulApyTypeCode;
	}

	public void setTrsRulApyTypeCode(String trsRulApyTypeCode) {
		this.trsRulApyTypeCode = trsRulApyTypeCode;
	}

	public String getTrsRulTgtTypCode() {
		return trsRulTgtTypCode;
	}

	public void setTrsRulTgtTypCode(String trsRulTgtTypCode) {
		this.trsRulTgtTypCode = trsRulTgtTypCode;
	}

	public String getAppSdd() {
		return appSdd;
	}

	public void setAppSdd(String appSdd) {
		this.appSdd = appSdd;
	}

	public String getApyEdd() {
		return apyEdd;
	}

	public void setApyEdd(String apyEdd) {
		this.apyEdd = apyEdd;
	}

	public String getTrsRulXtncTypeCode() {
		return trsRulXtncTypeCode;
	}

	public void setTrsRulXtncTypeCode(String trsRulXtncTypeCode) {
		this.trsRulXtncTypeCode = trsRulXtncTypeCode;
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
		return useYnFlag;
	}

	public void setUseYnFlag(boolean useYnFlag) {
		this.useYnFlag = useYnFlag;
	}
}
