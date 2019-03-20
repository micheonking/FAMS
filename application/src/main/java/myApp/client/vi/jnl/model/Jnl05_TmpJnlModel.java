package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl05_TmpJnlModel implements GridDataModel { 

	private Long    tmpJnlId;
	private Long	oprId;
	private String  jnlDate;
	private Long  	seq;
	private String  reprAcntCode;
	private String  drcrTypeCode;
	private Long	krwAmt;
	private Long    forAmt;
	private Long    usdAmt;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;
	
	@Override
	public void setKeyId(Long id) {
		this.tmpJnlId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getTmpJnlId();
	}

	public Long getTmpJnlId() {
		return tmpJnlId;
	}

	public void setTmpJnlId(Long tmpJnlId) {
		this.tmpJnlId = tmpJnlId;
	}

	public Long getOprId() {
		return oprId;
	}

	public void setOprId(Long oprId) {
		this.oprId = oprId;
	}

	public String getJnlDate() {
		return jnlDate;
	}

	public void setJnlDate(String jnlDate) {
		this.jnlDate = jnlDate;
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

	public Long getKrwAmt() {
		return krwAmt;
	}

	public void setKrwAmt(Long krwAmt) {
		this.krwAmt = krwAmt;
	}

	public Long getForAmt() {
		return forAmt;
	}

	public void setForAmt(Long forAmt) {
		this.forAmt = forAmt;
	}

	public Long getUsdAmt() {
		return usdAmt;
	}

	public void setUsdAmt(Long usdAmt) {
		this.usdAmt = usdAmt;
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
