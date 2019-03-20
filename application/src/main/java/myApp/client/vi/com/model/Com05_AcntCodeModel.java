package myApp.client.vi.com.model;

import java.util.Date;
import java.util.List;

import myApp.client.utils.GridDataModel;

public class Com05_AcntCodeModel implements GridDataModel { 

	private Long    acntCodeId ;
	private String  cmpCode ;
	private String  accCode ;
	private String  accKname ;
	private String  accEname2 ;
	private String  drCrTypeCode ;
	private String  chdPrntTypeCode ;
	private Long  	accLvlCode ;
	private String  prntAccCode ;
	private String  accAttCode ;
	private String  tlgAttCode ;
	private Long  	seq ;
	private String  prntAccCode1 ;
	private String  prntAccCode2 ;
	private String  prntAccCode3 ;
	private String  prntAccCode4 ;
	private String  prntAccCode5 ;
	private String  tgtAccCode ;
	private String  ustlYn ;
	private String  useYn ;
	private String  balMagYn ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;
	
	private boolean  ustlYnFlag ;
	private boolean  useYnFlag ;
	private boolean  balMagYnFlag ;
	
	@Override
	public void setKeyId(Long id) {
		this.acntCodeId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getAcntCodeId(); 
	}

	public Long getAcntCodeId() {
		return acntCodeId;
	}

	public void setAcntCodeId(Long acntCodeId) {
		this.acntCodeId = acntCodeId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getAccKname() {
		return accKname;
	}

	public void setAccKname(String accKname) {
		this.accKname = accKname;
	}

	public String getAccEname2() {
		return accEname2;
	}

	public void setAccEname2(String accEname2) {
		this.accEname2 = accEname2;
	}

	public String getDrCrTypeCode() {
		return drCrTypeCode;
	}

	public void setDrCrTypeCode(String drCrTypeCode) {
		this.drCrTypeCode = drCrTypeCode;
	}

	public String getChdPrntTypeCode() {
		return chdPrntTypeCode;
	}

	public void setChdPrntTypeCode(String chdPrntTypeCode) {
		this.chdPrntTypeCode = chdPrntTypeCode;
	}

	public Long getAccLvlCode() {
		return accLvlCode;
	}

	public void setAccLvlCode(Long accLvlCode) {
		this.accLvlCode = accLvlCode;
	}

	public String getPrntAccCode() {
		return prntAccCode;
	}

	public void setPrntAccCode(String prntAccCode) {
		this.prntAccCode = prntAccCode;
	}

	public String getAccAttCode() {
		return accAttCode;
	}

	public void setAccAttCode(String accAttCode) {
		this.accAttCode = accAttCode;
	}

	public String getTlgAttCode() {
		return tlgAttCode;
	}

	public void setTlgAttCode(String tlgAttCode) {
		this.tlgAttCode = tlgAttCode;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getPrntAccCode1() {
		return prntAccCode1;
	}

	public void setPrntAccCode1(String prntAccCode1) {
		this.prntAccCode1 = prntAccCode1;
	}

	public String getPrntAccCode2() {
		return prntAccCode2;
	}

	public void setPrntAccCode2(String prntAccCode2) {
		this.prntAccCode2 = prntAccCode2;
	}

	public String getPrntAccCode3() {
		return prntAccCode3;
	}

	public void setPrntAccCode3(String prntAccCode3) {
		this.prntAccCode3 = prntAccCode3;
	}

	public String getPrntAccCode4() {
		return prntAccCode4;
	}

	public void setPrntAccCode4(String prntAccCode4) {
		this.prntAccCode4 = prntAccCode4;
	}

	public String getPrntAccCode5() {
		return prntAccCode5;
	}

	public void setPrntAccCode5(String prntAccCode5) {
		this.prntAccCode5 = prntAccCode5;
	}

	public String getTgtAccCode() {
		return tgtAccCode;
	}

	public void setTgtAccCode(String tgtAccCode) {
		this.tgtAccCode = tgtAccCode;
	}

	public String getUstlYn() {
		return ustlYn;
	}

	public void setUstlYn(String ustlYn) {
		this.ustlYn = ustlYn;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getBalMagYn() {
		return balMagYn;
	}

	public void setBalMagYn(String balMagYn) {
		this.balMagYn = balMagYn;
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

	public boolean isUstlYnFlag() {
		if("Y".equals(getUstlYn())) {
			return true;
		} else {
			return false;
		}
	}

	public void setUstlYnFlag(boolean ustlYnFlag) {
		if(ustlYnFlag) {
			this.ustlYn = "Y";
		} else {
			this.ustlYn = "N";
		}
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

	public boolean isBalMagYnFlag() {
		if("Y".equals(getBalMagYn())) {
			return true;
		} else {
			return false;
		}
	}

	public void setBalMagYnFlag(boolean balMagYnFlag) {
		if(balMagYnFlag) {
			this.balMagYn = "Y";
		} else {
			this.balMagYn = "N";
		}
	}

}
