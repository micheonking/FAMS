package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl06_JnlModel implements GridDataModel { 

	private Long    jnlId;
	private Long	oprId;
	private String  jnlDate;
	private Long  	seq;
	private String  drAcntCode;
	private Long    drKrwAmt;
	private Long	drForAmt;
	private Long    drUsdAmt;
	private String  crAcntCode;
	private Long    crKrwAmt;
	private Long    crForAmt;
	private Long	crUsdAmt;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;
	
	@Override
	public void setKeyId(Long id) {
		this.jnlId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getJnlId();
	}

	public Long getJnlId() {
		return jnlId;
	}

	public void setJnlId(Long jnlId) {
		this.jnlId = jnlId;
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

	public String getDrAcntCode() {
		return drAcntCode;
	}

	public void setDrAcntCode(String drAcntCode) {
		this.drAcntCode = drAcntCode;
	}

	public Long getDrKrwAmt() {
		return drKrwAmt;
	}

	public void setDrKrwAmt(Long drKrwAmt) {
		this.drKrwAmt = drKrwAmt;
	}

	public Long getDrForAmt() {
		return drForAmt;
	}

	public void setDrForAmt(Long drForAmt) {
		this.drForAmt = drForAmt;
	}

	public Long getDrUsdAmt() {
		return drUsdAmt;
	}

	public void setDrUsdAmt(Long drUsdAmt) {
		this.drUsdAmt = drUsdAmt;
	}

	public String getCrAcntCode() {
		return crAcntCode;
	}

	public void setCrAcntCode(String crAcntCode) {
		this.crAcntCode = crAcntCode;
	}

	public Long getCrKrwAmt() {
		return crKrwAmt;
	}

	public void setCrKrwAmt(Long crKrwAmt) {
		this.crKrwAmt = crKrwAmt;
	}

	public Long getCrForAmt() {
		return crForAmt;
	}

	public void setCrForAmt(Long crForAmt) {
		this.crForAmt = crForAmt;
	}

	public Long getCrUsdAmt() {
		return crUsdAmt;
	}

	public void setCrUsdAmt(Long crUsdAmt) {
		this.crUsdAmt = crUsdAmt;
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
