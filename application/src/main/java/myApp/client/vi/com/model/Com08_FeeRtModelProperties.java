package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com08_FeeRtModelProperties extends PropertyAccess<Com08_FeeRtModel> {
	
	ModelKeyProvider<Com08_FeeRtModel> keyId();

	ValueProvider<Com08_FeeRtModel, Long  >	feeRtId() ;
	ValueProvider<Com08_FeeRtModel, String>	cmpCode() ;
	ValueProvider<Com08_FeeRtModel, String>	feeCode() ;
	ValueProvider<Com08_FeeRtModel, String>	trCoCode() ;
	ValueProvider<Com08_FeeRtModel, String>	sttAmt() ;
	ValueProvider<Com08_FeeRtModel, String>	endAmt() ;
	ValueProvider<Com08_FeeRtModel, String>	feeRt() ;
	ValueProvider<Com08_FeeRtModel, String>	addAmt() ;
	ValueProvider<Com08_FeeRtModel, String>	useYn() ;
	ValueProvider<Com08_FeeRtModel, String>	insUsrNo() ;
	ValueProvider<Com08_FeeRtModel, Date>	insDate() ;
	ValueProvider<Com08_FeeRtModel, String>	updUsrNo() ;
	ValueProvider<Com08_FeeRtModel, Date>	updDate() ;
	
	ValueProvider<Com08_FeeRtModel, Boolean>	useYnFlag() ;
}
