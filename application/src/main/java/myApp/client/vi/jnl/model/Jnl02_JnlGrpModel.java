package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl02_JnlGrpModel implements GridDataModel { 

	private Long    jnlGrpId;
	private String  compCode;
	private String  jnlGrpCode;
	private Long  seq;
	private String  reprAcntCode;
	private String  drcrTypeCode;
	private String  krwCalc;
	private String  forCalc;
	private String  usdCalc;
	private String  useYn;
	private String  rmk;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;

	private boolean useYnFlag;
	
	@Override
	public void setKeyId(Long id) {
		this.jnlGrpId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getJnlGrpId();
	}

	public Long getJnlGrpId() {
		return jnlGrpId;
	}

	public void setJnlGrpId(Long jnlGrpId) {
		this.jnlGrpId = jnlGrpId;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getJnlGrpCode() {
		return jnlGrpCode;
	}

	public void setJnlGrpCode(String jnlGrpCode) {
		this.jnlGrpCode = jnlGrpCode;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getReprAcntCode() {
		return reprAcntCode;
	}

	public void setReprAcntCode(String reprAcntCode) {
		this.reprAcntCode = reprAcntCode;
	}

	public String getDrcrTypeCode() {
		return drcrTypeCode;
	}

	public void setDrcrTypeCode(String drcrTypeCode) {
		this.drcrTypeCode = drcrTypeCode;
	}

	public String getKrwCalc() {
		return krwCalc;
	}

	public void setKrwCalc(String krwCalc) {
		this.krwCalc = krwCalc;
	}

	public String getForCalc() {
		return forCalc;
	}

	public void setForCalc(String forCalc) {
		this.forCalc = forCalc;
	}

	public String getUsdCalc() {
		return usdCalc;
	}

	public void setUsdCalc(String usdCalc) {
		this.usdCalc = usdCalc;
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
