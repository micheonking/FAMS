package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl07_genLdgerModel implements GridDataModel { 

	private Long    genIdgerId;
	private String	cmpCode;
	private String  evlDate;
	private String  fndCode;
	private String  acntCode;
	private String  evlCloTypeCode;
	private Long	drTdyBal;
	private Long    drTdydiff;
	private Long	drPdyBal;
	private Long    crTdyBal;
	private Long    crTdyDiff;
	private Long	crPdyBal;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;
	
	@Override
	public void setKeyId(Long id) {
		this.genIdgerId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getGenIdgerId();
	}

	public Long getGenIdgerId() {
		return genIdgerId;
	}

	public void setGenIdgerId(Long genIdgerId) {
		this.genIdgerId = genIdgerId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getEvlDate() {
		return evlDate;
	}

	public void setEvlDate(String evlDate) {
		this.evlDate = evlDate;
	}

	public String getFndCode() {
		return fndCode;
	}

	public void setFndCode(String fndCode) {
		this.fndCode = fndCode;
	}

	public String getAcntCode() {
		return acntCode;
	}

	public void setAcntCode(String acntCode) {
		this.acntCode = acntCode;
	}

	public String getEvlCloTypeCode() {
		return evlCloTypeCode;
	}

	public void setEvlCloTypeCode(String evlCloTypeCode) {
		this.evlCloTypeCode = evlCloTypeCode;
	}

	public Long getDrTdyBal() {
		return drTdyBal;
	}

	public void setDrTdyBal(Long drTdyBal) {
		this.drTdyBal = drTdyBal;
	}

	public Long getDrTdydiff() {
		return drTdydiff;
	}

	public void setDrTdydiff(Long drTdydiff) {
		this.drTdydiff = drTdydiff;
	}

	public Long getDrPdyBal() {
		return drPdyBal;
	}

	public void setDrPdyBal(Long drPdyBal) {
		this.drPdyBal = drPdyBal;
	}

	public Long getCrTdyBal() {
		return crTdyBal;
	}

	public void setCrTdyBal(Long crTdyBal) {
		this.crTdyBal = crTdyBal;
	}

	public Long getCrTdyDiff() {
		return crTdyDiff;
	}

	public void setCrTdyDiff(Long crTdyDiff) {
		this.crTdyDiff = crTdyDiff;
	}

	public Long getCrPdyBal() {
		return crPdyBal;
	}

	public void setCrPdyBal(Long crPdyBal) {
		this.crPdyBal = crPdyBal;
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
