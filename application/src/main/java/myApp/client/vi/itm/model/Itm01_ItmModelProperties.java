package myApp.client.vi.itm.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Itm01_ItmModelProperties extends PropertyAccess<Itm01_ItmModel> {
	
	ModelKeyProvider<Itm01_ItmModel> keyId();

	ValueProvider<Itm01_ItmModel, Long  > itmId();
	ValueProvider<Itm01_ItmModel, String> cmpCode();
	ValueProvider<Itm01_ItmModel, String> itmCode();
	ValueProvider<Itm01_ItmModel, String> infoSttDate();
	ValueProvider<Itm01_ItmModel, String> infoEndDate();
	ValueProvider<Itm01_ItmModel, String> lclassCode();
	ValueProvider<Itm01_ItmModel, String> mclassCode();
	ValueProvider<Itm01_ItmModel, String> itmName();
	ValueProvider<Itm01_ItmModel, String> itmAbbr();
	ValueProvider<Itm01_ItmModel, String> itmEName();
	ValueProvider<Itm01_ItmModel, String> itmEAbbr();
	ValueProvider<Itm01_ItmModel, String> isin();
	ValueProvider<Itm01_ItmModel, String> itmShtCode();
	ValueProvider<Itm01_ItmModel, String> cusip();
	ValueProvider<Itm01_ItmModel, String> sedol();
	ValueProvider<Itm01_ItmModel, String> issDate();
	ValueProvider<Itm01_ItmModel, String> matDate();
	ValueProvider<Itm01_ItmModel, String> listDate();
	ValueProvider<Itm01_ItmModel, String> listTypeCode();
	ValueProvider<Itm01_ItmModel, String> ntnCode();
	ValueProvider<Itm01_ItmModel, String> areaCode();
	ValueProvider<Itm01_ItmModel, String> krxTypeCode();
	ValueProvider<Itm01_ItmModel, String> taxTypeCode();
	ValueProvider<Itm01_ItmModel, String> issCorpCode();
	ValueProvider<Itm01_ItmModel, String> orgIssCorpCode();
	ValueProvider<Itm01_ItmModel, String> mngCoCode();
	ValueProvider<Itm01_ItmModel, String> grtTypeCode();
	ValueProvider<Itm01_ItmModel, String> grtCorpCode();
	ValueProvider<Itm01_ItmModel, String> whTypeCode();
	ValueProvider<Itm01_ItmModel, String> abroWhTypeCode();
	ValueProvider<Itm01_ItmModel, String> cloMonth();
	ValueProvider<Itm01_ItmModel, String> payCurCode();
	ValueProvider<Itm01_ItmModel, String> rcvCurCode();
	ValueProvider<Itm01_ItmModel, String> evlCurCode();
	ValueProvider<Itm01_ItmModel, String> pubPrvTypeCode();
	ValueProvider<Itm01_ItmModel, String> dataRcvYn();
	ValueProvider<Itm01_ItmModel, String> dataRcvPayUntCode();
	ValueProvider<Itm01_ItmModel, String> dataRcvCode();
	ValueProvider<Itm01_ItmModel, String> dataRcvCo();
	ValueProvider<Itm01_ItmModel, String> dealUnt();
	ValueProvider<Itm01_ItmModel, Long  > par();
	ValueProvider<Itm01_ItmModel, String> evlTypeCode();
	ValueProvider<Itm01_ItmModel, String> rdmPlCalcTypeCode();
	ValueProvider<Itm01_ItmModel, String> newRegDate();
	ValueProvider<Itm01_ItmModel, String> mktPrcApyFrmlCode();
	ValueProvider<Itm01_ItmModel, String> taxPosTypeCode();
	ValueProvider<Itm01_ItmModel, String> rcvbIntCalcFrmlCode();
	ValueProvider<Itm01_ItmModel, String> astMngFrmlCode();
	ValueProvider<Itm01_ItmModel, String> evlFrmlCode();
	ValueProvider<Itm01_ItmModel, String> dtlClassCode();
	ValueProvider<Itm01_ItmModel, String> insUsrNo();
	ValueProvider<Itm01_ItmModel, Date  > insDate();
	ValueProvider<Itm01_ItmModel, String> updUsrNo();
	ValueProvider<Itm01_ItmModel, Date  > updDate();
}
