package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com08_FeeRtModel implements GridDataModel { 

	private Long    feeRtId ;
	private String  cmpCode ;
	private String  feeCode ;
	private String  trCoCode ;
	private String  sttAmt ;
	private String  endAmt ;
	private String  feeRt ;
	private String  addAmt ;
	private String  useYn ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  useYnFlag ;
	
	@Override
	public void setKeyId(Long id) {
		this.feeRtId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getFeeRtId(); 
	}

	public Long getFeeRtId() {
		return feeRtId;
	}

	public void setFeeRtId(Long feeRtId) {
		this.feeRtId = feeRtId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getTrCoCode() {
		return trCoCode;
	}

	public void setTrCoCode(String trCoCode) {
		this.trCoCode = trCoCode;
	}

	public String getSttAmt() {
		return sttAmt;
	}

	public void setSttAmt(String sttAmt) {
		this.sttAmt = sttAmt;
	}

	public String getEndAmt() {
		return endAmt;
	}

	public void setEndAmt(String endAmt) {
		this.endAmt = endAmt;
	}

	public String getFeeRt() {
		return feeRt;
	}

	public void setFeeRt(String feeRt) {
		this.feeRt = feeRt;
	}

	public String getAddAmt() {
		return addAmt;
	}

	public void setAddAmt(String addAmt) {
		this.addAmt = addAmt;
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
