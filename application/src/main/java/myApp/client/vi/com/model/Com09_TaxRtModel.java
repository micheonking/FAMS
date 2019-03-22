package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com09_TaxRtModel implements GridDataModel { 

	private Long    taxRtId ;
	private String  taxRtTypeCode ;
	private String  whCoTypeCode ;
	private String  apySdd ;
	private String  apyEdd ;
	private String  apyTaxRt ;
	private String  taxRtApyPosTypeCode ;
	private String  taxRtApyTypeCode ;
	private String  useYn ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  useYnFlag ;
	private String  taxRtTypeName ;
	private String  whCoTypeName ;
	private String  taxRtApyPosTypeName;
	private String  taxRtApyTypeName ;
	
	@Override
	public void setKeyId(Long id) {
		this.taxRtId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getTaxRtId(); 
	}

		public Long getTaxRtId() {
		return taxRtId;
	}

	public void setTaxRtId(Long taxRtId) {
		this.taxRtId = taxRtId;
	}

	public String getTaxRtTypeCode() {
		return taxRtTypeCode;
	}

	public void setTaxRtTypeCode(String taxRtTypeCode) {
		this.taxRtTypeCode = taxRtTypeCode;
	}

	public String getWhCoTypeCode() {
		return whCoTypeCode;
	}

	public void setWhCoTypeCode(String whCoTypeCode) {
		this.whCoTypeCode = whCoTypeCode;
	}

	public String getApySdd() {
		return apySdd;
	}

	public void setApySdd(String apySdd) {
		this.apySdd = apySdd;
	}

	public String getApyEdd() {
		return apyEdd;
	}

	public void setApyEdd(String apyEdd) {
		this.apyEdd = apyEdd;
	}

	public String getApyTaxRt() {
		return apyTaxRt;
	}

	public void setApyTaxRt(String apyTaxRt) {
		this.apyTaxRt = apyTaxRt;
	}

	
	public String getTaxRtApyPosTypeCode() {
		return taxRtApyPosTypeCode;
	}

	public void setTaxRtApyPosTypeCode(String taxRtApyPosTypeCode) {
		this.taxRtApyPosTypeCode = taxRtApyPosTypeCode;
	}

	public String getTaxRtApyTypeCode() {
		return taxRtApyTypeCode;
	}

	public void setTaxRtApyTypeCode(String taxRtApyTypeCode) {
		this.taxRtApyTypeCode = taxRtApyTypeCode;
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

	public String getTaxRtTypeName() {
		return taxRtTypeName;
	}

	public void setTaxRtTypeName(String taxRtTypeName) {
		this.taxRtTypeName = taxRtTypeName;
	}

	public String getWhCoTypeName() {
		return whCoTypeName;
	}

	public void setWhCoTypeName(String whCoTypeName) {
		this.whCoTypeName = whCoTypeName;
	}

	public String getTaxRtApyPosTypeName() {
		return taxRtApyPosTypeName;
	}

	public void setTaxRtApyPosTypeName(String taxRtApyPosTypeName) {
		this.taxRtApyPosTypeName = taxRtApyPosTypeName;
	}

	public String getTaxRtApyTypeName() {
		return taxRtApyTypeName;
	}

	public void setTaxRtApyTypeName(String taxRtApyTypeName) {
		this.taxRtApyTypeName = taxRtApyTypeName;
	}
	
}
