package myApp.client.vi.itm.model;

import java.util.Date;

import myApp.client.utils.ClientDateUtil;
import myApp.client.utils.GridDataModel;

public class Itm01_ItmModel implements GridDataModel { 

	private Long    itmId ;
	private String  cmpCode ;
	private String  itmCode ;
	private String  infoSttDate ;
	private String  infoEndDate ;
	private String  lclassCode ;
	private String  mclassCode ;
	private String  itmName ;
	private String  itmAbbr ;
	private String  itmEName ;
	private String  itmEAbbr ;
	private String  isin ;
	private String  itmShtCode ;
	private String  cusip ;
	private String  sedol ;
	private String  issDate ;
	private String  matDate ;
	private String  listDate ;
	private String  listTypeCode ;
	private String  ntnCode ;
	private String  areaCode ;
	private String  krxTypeCode ;
	private String  taxTypeCode ;
	private String  issCorpCode ;
	private String  orgIssCorpCode ;
	private String  mngCoCode ;
	private String  grtTypeCode ;
	private String  grtCorpCode ;
	private String  whTypeCode ;
	private String  abroWhTypeCode ;
	private String  cloMonth ;
	private String  payCurCode ;
	private String  rcvCurCode ;
	private String  evlCurCode ;
	private String  pubPrvTypeCode ;
	private String  dataRcvYn ;
	private String  dataRcvPayUntCode ;
	private String  dataRcvCode ;
	private String  dataRcvCo ;
	private String  dealUnt ;
	private Long    par ;
	private String  evlTypeCode ;
	private String  rdmPlCalcTypeCode ;
	private String  newRegDate ;
	private String  mktPrcApyFrmlCode ;
	private String  taxPosTypeCode ;
	private String  rcvbIntCalcFrmlCode ;
	private String  astMngFrmlCode ;
	private String  evlFrmlCode ;
	private String  dtlClassCode ;
	private String  insUsrNo ;
	private Date    insDate ;
	private String  updUsrNo ;
	private Date    updDate ;

	private String  lclassName ;
	private String  mclassName ;
	private String  listTypeName ;
	private String  ntnName ;
	private String  areaName ;
	private String  krxTypeName ;
	private String  taxTypeName ;
	private String  grtTypeName ;
	private String  whTypeName ;
	private String  abroWhTypeName ;
	private String  pubPrvTypeName ;
	private String  dataRcvPayUntName ;
	private String  dataRcvCoName ;
	private String  dealUntName ;
	private String  evlTypeName ;
	private String  rdmPlCalcTypeName ;
	private String  mktPrcApyFrmlName ;
	private String  taxPosTypeName ;
	private String  rcvbIntCalcFrmlName ;
	private String  astMngFrmlName ;
	private String  evlFrmlName ;
	private String  dtlClassName ;
	
	private Date  	infoSttDateConv ;
	private Date  	infoEndDateConv ;
	private Date  	issDateConv ;
	private Date  	matDateConv ;
	private Date  	listDateConv ;
	private Date  	newRegDateConv ;
	
	@Override
	public void setKeyId(Long id) {
		this.itmId = id;
	}

	@Override
	public Long getKeyId() {
		return this.getItmId(); 
	}

	public Long getItmId() {
		return itmId;
	}

	public void setItmId(Long itmId) {
		this.itmId = itmId;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getItmCode() {
		return itmCode;
	}

	public void setItmCode(String itmCode) {
		this.itmCode = itmCode;
	}

	public String getLclassCode() {
		return lclassCode;
	}

	public void setLclassCode(String lclassCode) {
		this.lclassCode = lclassCode;
	}

	public String getMclassCode() {
		return mclassCode;
	}

	public void setMclassCode(String mclassCode) {
		this.mclassCode = mclassCode;
	}

	public String getItmName() {
		return itmName;
	}

	public void setItmName(String itmName) {
		this.itmName = itmName;
	}

	public String getItmAbbr() {
		return itmAbbr;
	}

	public void setItmAbbr(String itmAbbr) {
		this.itmAbbr = itmAbbr;
	}

	public String getItmEName() {
		return itmEName;
	}

	public void setItmEName(String itmEName) {
		this.itmEName = itmEName;
	}

	public String getItmEAbbr() {
		return itmEAbbr;
	}

	public void setItmEAbbr(String itmEAbbr) {
		this.itmEAbbr = itmEAbbr;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getItmShtCode() {
		return itmShtCode;
	}

	public void setItmShtCode(String itmShtCode) {
		this.itmShtCode = itmShtCode;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getSedol() {
		return sedol;
	}

	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	public String getIssDate() {
		return issDate;
	}

	public void setIssDate(String issDate) {
		this.issDate = issDate;
	}

	public String getMatDate() {
		return matDate;
	}

	public void setMatDate(String matDate) {
		this.matDate = matDate;
	}

	public String getListDate() {
		return listDate;
	}

	public void setListDate(String listDate) {
		this.listDate = listDate;
	}

	public String getListTypeCode() {
		return listTypeCode;
	}

	public void setListTypeCode(String listTypeCode) {
		this.listTypeCode = listTypeCode;
	}

	public String getNtnCode() {
		return ntnCode;
	}

	public void setNtnCode(String ntnCode) {
		this.ntnCode = ntnCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getKrxTypeCode() {
		return krxTypeCode;
	}

	public void setKrxTypeCode(String krxTypeCode) {
		this.krxTypeCode = krxTypeCode;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public String getIssCorpCode() {
		return issCorpCode;
	}

	public void setIssCorpCode(String issCorpCode) {
		this.issCorpCode = issCorpCode;
	}

	public String getOrgIssCorpCode() {
		return orgIssCorpCode;
	}

	public void setOrgIssCorpCode(String orgIssCorpCode) {
		this.orgIssCorpCode = orgIssCorpCode;
	}

	public String getMngCoCode() {
		return mngCoCode;
	}

	public void setMngCoCode(String mngCoCode) {
		this.mngCoCode = mngCoCode;
	}

	public String getGrtTypeCode() {
		return grtTypeCode;
	}

	public void setGrtTypeCode(String grtTypeCode) {
		this.grtTypeCode = grtTypeCode;
	}

	public String getGrtCorpCode() {
		return grtCorpCode;
	}

	public void setGrtCorpCode(String grtCorpCode) {
		this.grtCorpCode = grtCorpCode;
	}

	public String getWhTypeCode() {
		return whTypeCode;
	}

	public void setWhTypeCode(String whTypeCode) {
		this.whTypeCode = whTypeCode;
	}

	public String getAbroWhTypeCode() {
		return abroWhTypeCode;
	}

	public void setAbroWhTypeCode(String abroWhTypeCode) {
		this.abroWhTypeCode = abroWhTypeCode;
	}

	public String getCloMonth() {
		return cloMonth;
	}

	public void setCloMonth(String cloMonth) {
		this.cloMonth = cloMonth;
	}

	public String getPayCurCode() {
		return payCurCode;
	}

	public void setPayCurCode(String payCurCode) {
		this.payCurCode = payCurCode;
	}

	public String getRcvCurCode() {
		return rcvCurCode;
	}

	public void setRcvCurCode(String rcvCurCode) {
		this.rcvCurCode = rcvCurCode;
	}

	public String getEvlCurCode() {
		return evlCurCode;
	}

	public void setEvlCurCode(String evlCurCode) {
		this.evlCurCode = evlCurCode;
	}

	public String getPubPrvTypeCode() {
		return pubPrvTypeCode;
	}

	public void setPubPrvTypeCode(String pubPrvTypeCode) {
		this.pubPrvTypeCode = pubPrvTypeCode;
	}

	public String getDataRcvYn() {
		return dataRcvYn;
	}

	public void setDataRcvYn(String dataRcvYn) {
		this.dataRcvYn = dataRcvYn;
	}

	public String getDataRcvPayUntCode() {
		return dataRcvPayUntCode;
	}

	public void setDataRcvPayUntCode(String dataRcvPayUntCode) {
		this.dataRcvPayUntCode = dataRcvPayUntCode;
	}

	public String getDataRcvCode() {
		return dataRcvCode;
	}

	public void setDataRcvCode(String dataRcvCode) {
		this.dataRcvCode = dataRcvCode;
	}

	public String getDataRcvCo() {
		return dataRcvCo;
	}

	public void setDataRcvCo(String dataRcvCo) {
		this.dataRcvCo = dataRcvCo;
	}

	public String getDealUnt() {
		return dealUnt;
	}

	public void setDealUnt(String dealUnt) {
		this.dealUnt = dealUnt;
	}

	public Long getPar() {
		return par;
	}

	public void setPar(Long par) {
		this.par = par;
	}

	public String getEvlTypeCode() {
		return evlTypeCode;
	}

	public void setEvlTypeCode(String evlTypeCode) {
		this.evlTypeCode = evlTypeCode;
	}

	public String getRdmPlCalcTypeCode() {
		return rdmPlCalcTypeCode;
	}

	public void setRdmPlCalcTypeCode(String rdmPlCalcTypeCode) {
		this.rdmPlCalcTypeCode = rdmPlCalcTypeCode;
	}

	public String getNewRegDate() {
		return newRegDate;
	}

	public void setNewRegDate(String newRegDate) {
		this.newRegDate = newRegDate;
	}

	public String getMktPrcApyFrmlCode() {
		return mktPrcApyFrmlCode;
	}

	public void setMktPrcApyFrmlCode(String mktPrcApyFrmlCode) {
		this.mktPrcApyFrmlCode = mktPrcApyFrmlCode;
	}

	public String getTaxPosTypeCode() {
		return taxPosTypeCode;
	}

	public void setTaxPosTypeCode(String taxPosTypeCode) {
		this.taxPosTypeCode = taxPosTypeCode;
	}

	public String getRcvbIntCalcFrmlCode() {
		return rcvbIntCalcFrmlCode;
	}

	public void setRcvbIntCalcFrmlCode(String rcvbIntCalcFrmlCode) {
		this.rcvbIntCalcFrmlCode = rcvbIntCalcFrmlCode;
	}

	public String getAstMngFrmlCode() {
		return astMngFrmlCode;
	}

	public void setAstMngFrmlCode(String astMngFrmlCode) {
		this.astMngFrmlCode = astMngFrmlCode;
	}

	public String getEvlFrmlCode() {
		return evlFrmlCode;
	}

	public void setEvlFrmlCode(String evlFrmlCode) {
		this.evlFrmlCode = evlFrmlCode;
	}

	public String getDtlClassCode() {
		return dtlClassCode;
	}

	public void setDtlClassCode(String dtlClassCode) {
		this.dtlClassCode = dtlClassCode;
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

	public String getInfoSttDate() {
		return infoSttDate;
	}

	public void setInfoSttDate(String infoSttDate) {
		this.infoSttDate = infoSttDate;
	}

	public String getInfoEndDate() {
		return infoEndDate;
	}

	public void setInfoEndDate(String infoEndDate) {
		this.infoEndDate = infoEndDate;
	}

	public Date getInfoSttDateConv() {
		return ClientDateUtil.toDate("yyyyMMdd", getInfoSttDate());
	}

	public void setInfoSttDateConv(Date infoSttDateConv) {
		this.infoSttDate = ClientDateUtil.toDate("yyyyMMdd", infoSttDateConv);
	}

	public Date getInfoEndDateConv() {
		return ClientDateUtil.toDate("yyyyMMdd", getInfoEndDate());
	}

	public void setInfoEndDateConv(Date infoEndDateConv) {
		this.infoEndDate = ClientDateUtil.toDate("yyyyMMdd", infoEndDateConv);
	}

	public Date getIssDateConv() {
		if(getIssDate() == null) {
			return null;
		}
		return ClientDateUtil.toDate("yyyyMMdd", getIssDate());
	}

	public void setIssDateConv(Date issDateConv) {
		if(issDateConv != null) {
			this.issDate = ClientDateUtil.toDate("yyyyMMdd", issDateConv);
		}
	}

	public Date getMatDateConv() {
		if(getMatDate() == null) {
			return null;
		}
		return ClientDateUtil.toDate("yyyyMMdd", getMatDate());
	}

	public void setMatDateConv(Date matDateConv) {
		if(matDateConv != null) {
			this.matDate = ClientDateUtil.toDate("yyyyMMdd", matDateConv);
		}
	}

	public Date getListDateConv() {
		if(getListDate() == null) {
			return null;
		}
		return ClientDateUtil.toDate("yyyyMMdd", getListDate());
	}

	public void setListDateConv(Date listDateConv) {
		if(listDateConv != null) {
			this.listDate = ClientDateUtil.toDate("yyyyMMdd", listDateConv);
		}
	}

	public Date getNewRegDateConv() {
		if (getNewRegDate() == null) {
			return null;
		}
		return ClientDateUtil.toDate("yyyyMMdd", getNewRegDate());
	}

	public void setNewRegDateConv(Date newRegDateConv) {
		if(newRegDateConv != null) {
			this.newRegDate = ClientDateUtil.toDate("yyyyMMdd", newRegDateConv);
		}
	}

	public String getLclassName() {
		return lclassName;
	}

	public void setLclassName(String lclassName) {
		this.lclassName = lclassName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getMclassName() {
		return mclassName;
	}

	public void setMclassName(String mclassName) {
		this.mclassName = mclassName;
	}

	public String getListTypeName() {
		return listTypeName;
	}

	public void setListTypeName(String listTypeName) {
		this.listTypeName = listTypeName;
	}

	public String getNtnName() {
		return ntnName;
	}

	public void setNtnName(String ntnName) {
		this.ntnName = ntnName;
	}

	public String getKrxTypeName() {
		return krxTypeName;
	}

	public void setKrxTypeName(String krxTypeName) {
		this.krxTypeName = krxTypeName;
	}

	public String getTaxTypeName() {
		return taxTypeName;
	}

	public void setTaxTypeName(String taxTypeName) {
		this.taxTypeName = taxTypeName;
	}

	public String getGrtTypeName() {
		return grtTypeName;
	}

	public void setGrtTypeName(String grtTypeName) {
		this.grtTypeName = grtTypeName;
	}

	public String getWhTypeName() {
		return whTypeName;
	}

	public void setWhTypeName(String whTypeName) {
		this.whTypeName = whTypeName;
	}

	public String getAbroWhTypeName() {
		return abroWhTypeName;
	}

	public void setAbroWhTypeName(String abroWhTypeName) {
		this.abroWhTypeName = abroWhTypeName;
	}

	public String getPubPrvTypeName() {
		return pubPrvTypeName;
	}

	public void setPubPrvTypeName(String pubPrvTypeName) {
		this.pubPrvTypeName = pubPrvTypeName;
	}

	public String getDataRcvPayUntName() {
		return dataRcvPayUntName;
	}

	public void setDataRcvPayUntName(String dataRcvPayUntName) {
		this.dataRcvPayUntName = dataRcvPayUntName;
	}

	public String getDataRcvCoName() {
		return dataRcvCoName;
	}

	public void setDataRcvCoName(String dataRcvCoName) {
		this.dataRcvCoName = dataRcvCoName;
	}

	public String getDealUntName() {
		return dealUntName;
	}

	public void setDealUntName(String dealUntName) {
		this.dealUntName = dealUntName;
	}

	public String getEvlTypeName() {
		return evlTypeName;
	}

	public void setEvlTypeName(String evlTypeName) {
		this.evlTypeName = evlTypeName;
	}

	public String getRdmPlCalcTypeName() {
		return rdmPlCalcTypeName;
	}

	public void setRdmPlCalcTypeName(String rdmPlCalcTypeName) {
		this.rdmPlCalcTypeName = rdmPlCalcTypeName;
	}

	public String getMktPrcApyFrmlName() {
		return mktPrcApyFrmlName;
	}

	public void setMktPrcApyFrmlName(String mktPrcApyFrmlName) {
		this.mktPrcApyFrmlName = mktPrcApyFrmlName;
	}

	public String getTaxPosTypeName() {
		return taxPosTypeName;
	}

	public void setTaxPosTypeName(String taxPosTypeName) {
		this.taxPosTypeName = taxPosTypeName;
	}

	public String getRcvbIntCalcFrmlName() {
		return rcvbIntCalcFrmlName;
	}

	public void setRcvbIntCalcFrmlName(String rcvbIntCalcFrmlName) {
		this.rcvbIntCalcFrmlName = rcvbIntCalcFrmlName;
	}

	public String getAstMngFrmlName() {
		return astMngFrmlName;
	}

	public void setAstMngFrmlName(String astMngFrmlName) {
		this.astMngFrmlName = astMngFrmlName;
	}

	public String getEvlFrmlName() {
		return evlFrmlName;
	}

	public void setEvlFrmlName(String evlFrmlName) {
		this.evlFrmlName = evlFrmlName;
	}

	public String getDtlClassName() {
		return dtlClassName;
	}

	public void setDtlClassName(String dtlClassName) {
		this.dtlClassName = dtlClassName;
	}

}
