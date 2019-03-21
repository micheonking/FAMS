package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl01_ReprAcntCodeModel implements GridDataModel {
	
	private Long   reprAcntCodeId;
	private String reprAcntCode;
	private String reprAcntName;
	private String acntAttCode;
	private String tgtReprAcntCode;
	private String bokMagYn;
	private String exrtApyTypeCode;
	private String rmk;
	private String insUsrNo;
	private Date   insDate;
	private String updUsrNo;
	private Date   updDate;

	@Override
	public void setKeyId(Long id) {
		this.reprAcntCodeId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getReprAcntCodeId();
	}

	public Long getReprAcntCodeId() {
		return reprAcntCodeId;
	}

	public void setReprAcntCodeId(Long reprAcntCodeId) {
		this.reprAcntCodeId = reprAcntCodeId;
	}

	public String getReprAcntCode() {
		return reprAcntCode;
	}

	public void setReprAcntCode(String reprAcntCode) {
		this.reprAcntCode = reprAcntCode;
	}

	public String getReprAcntName() {
		return reprAcntName;
	}

	public void setReprAcntName(String reprAcntName) {
		this.reprAcntName = reprAcntName;
	}

	public String getAcntAttCode() {
		return acntAttCode;
	}

	public void setAcntAttCode(String acntAttCode) {
		this.acntAttCode = acntAttCode;
	}

	public String getTgtReprAcntCode() {
		return tgtReprAcntCode;
	}

	public void setTgtReprAcntCode(String tgtReprAcntCode) {
		this.tgtReprAcntCode = tgtReprAcntCode;
	}

	public String getBokMagYn() {
		return bokMagYn;
	}

	public void setBokMagYn(String bokMagYn) {
		this.bokMagYn = bokMagYn;
	}

	public String getExrtApyTypeCode() {
		return exrtApyTypeCode;
	}

	public void setExrtApyTypeCode(String exrtApyTypeCode) {
		this.exrtApyTypeCode = exrtApyTypeCode;
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
