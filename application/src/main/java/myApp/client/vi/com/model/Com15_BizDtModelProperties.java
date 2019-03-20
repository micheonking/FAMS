package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com15_BizDtModelProperties extends PropertyAccess<Com15_BizDtModel> {
	
	ModelKeyProvider<Com15_BizDtModel> keyId();

	ValueProvider<Com15_BizDtModel, Long  >	bizDtId() ;
	ValueProvider<Com15_BizDtModel, String>	cmpCode() ;
	ValueProvider<Com15_BizDtModel, String>	bizDate() ;
	ValueProvider<Com15_BizDtModel, String>	insUsrNo() ;
	ValueProvider<Com15_BizDtModel, Date>	insDate() ;
	ValueProvider<Com15_BizDtModel, String>	updUsrNo() ;
	ValueProvider<Com15_BizDtModel, Date>	updDate() ;
}
