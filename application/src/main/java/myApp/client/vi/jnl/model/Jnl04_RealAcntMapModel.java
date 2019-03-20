package myApp.client.vi.jnl.model;

import java.util.Date;

import myApp.client.utils.GridDataModel;

public class Jnl04_RealAcntMapModel implements GridDataModel { 

	private Long    trMapId;
	private String  compCode;
	private String  trCode;
	private String  abrotypeCode;
	private String  itmLcalss;
	private String  jnlGrpCode;
	private String  tgtTrTypeCode;
	private String  liqdtTypeCode;
	private String  liqdtIoTypeCode;
	private String  plAmtTypeCode;
	private String  drcrChgPsbYn;
	private String  bokProcTypeCode;
	private String  useYn;
	private String  insUsrNo;
	private Date    insDate;
	private String  updUsrNo;
	private Date    updDate;

	private boolean useYnFlag;
	
	@Override
	public void setKeyId(Long id) {
		this.trMapId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getTrMapId();
	}
	
	public Long getTrMapId() {
		return trMapId;
	}

	public void setTrMapId(Long trMapId) {
		this.trMapId = trMapId;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getTrCode() {
		return trCode;
	}

	public void setTrCode(String trCode) {
		this.trCode = trCode;
	}

	public String getAbrotypeCode() {
		return abrotypeCode;
	}

	public void setAbrotypeCode(String abrotypeCode) {
		this.abrotypeCode = abrotypeCode;
	}

	public String getItmLcalss() {
		return itmLcalss;
	}

	public void setItmLcalss(String itmLcalss) {
		this.itmLcalss = itmLcalss;
	}

	public String getJnlGrpCode() {
		return jnlGrpCode;
	}

	public void setJnlGrpCode(String jnlGrpCode) {
		this.jnlGrpCode = jnlGrpCode;
	}

	public String getTgtTrTypeCode() {
		return tgtTrTypeCode;
	}

	public void setTgtTrTypeCode(String tgtTrTypeCode) {
		this.tgtTrTypeCode = tgtTrTypeCode;
	}

	public String getLiqdtTypeCode() {
		return liqdtTypeCode;
	}

	public void setLiqdtTypeCode(String liqdtTypeCode) {
		this.liqdtTypeCode = liqdtTypeCode;
	}

	public String getLiqdtIoTypeCode() {
		return liqdtIoTypeCode;
	}

	public void setLiqdtIoTypeCode(String liqdtIoTypeCode) {
		this.liqdtIoTypeCode = liqdtIoTypeCode;
	}

	public String getPlAmtTypeCode() {
		return plAmtTypeCode;
	}

	public void setPlAmtTypeCode(String plAmtTypeCode) {
		this.plAmtTypeCode = plAmtTypeCode;
	}

	public String getDrcrChgPsbYn() {
		return drcrChgPsbYn;
	}

	public void setDrcrChgPsbYn(String drcrChgPsbYn) {
		this.drcrChgPsbYn = drcrChgPsbYn;
	}

	public String getBokProcTypeCode() {
		return bokProcTypeCode;
	}

	public void setBokProcTypeCode(String bokProcTypeCode) {
		this.bokProcTypeCode = bokProcTypeCode;
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
