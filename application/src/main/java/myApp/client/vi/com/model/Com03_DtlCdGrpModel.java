package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com03_DtlCdGrpModel implements GridDataModel { 

	private Long    dtlCdGrpId ;
	private String  cmpCode ;
	private String  grpCode ;
	private String  comCode ;
	private String  comDtlCode ;
	private String  dtlName ;
	private String  rmk ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;


	@Override
	public void setKeyId(Long id) {
		this.dtlCdGrpId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getDtlCdGrpId(); 
	}

	public Long getDtlCdGrpId() {
		return dtlCdGrpId;
	}

	public void setDtlCdGrpId(Long dtlCdGrpId) {
		this.dtlCdGrpId = dtlCdGrpId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComDtlCode() {
		return comDtlCode;
	}

	public void setComDtlCode(String comDtlCode) {
		this.comDtlCode = comDtlCode;
	}

	public String getDtlName() {
		return dtlName;
	}

	public void setDtlName(String dtlName) {
		this.dtlName = dtlName;
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
