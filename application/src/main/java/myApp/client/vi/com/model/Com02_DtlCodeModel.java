package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com02_DtlCodeModel implements GridDataModel { 

	private Long    dtlCdId ;
	private String  comCode ;
	private String  dtlCode ;
	private String  dtlName ;
	private String  useYn ;
	private String  rmk ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;

	private boolean useYnFlag;

	@Override
	public void setKeyId(Long id) {
		this.dtlCdId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getDtlCdId(); 
	}

	public Long getDtlCdId() {
		return dtlCdId;
	}

	public void setDtlCdId(Long dtlCdId) {
		this.dtlCdId = dtlCdId;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getDtlCode() {
		return dtlCode;
	}

	public void setDtlCode(String dtlCode) {
		this.dtlCode = dtlCode;
	}

	public String getDtlName() {
		return dtlName;
	}

	public void setDtlName(String dtlName) {
		this.dtlName = dtlName;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
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
