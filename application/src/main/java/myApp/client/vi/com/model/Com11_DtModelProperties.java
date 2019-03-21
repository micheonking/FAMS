package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com11_DtModelProperties extends PropertyAccess<Com11_DtModel> {
	
	ModelKeyProvider<Com11_DtModel> keyId();

	ValueProvider<Com11_DtModel, Long  >	dtId() ;
	ValueProvider<Com11_DtModel, String>	cmpCode() ;
	ValueProvider<Com11_DtModel, String>	ntnCode() ;
	ValueProvider<Com11_DtModel, String>	stdDate() ;
	ValueProvider<Com11_DtModel, String>	hdayTypeCode() ;
	ValueProvider<Com11_DtModel, String>	hdayName() ;
	ValueProvider<Com11_DtModel, String>	dfwTypeCode() ;
	ValueProvider<Com11_DtModel, String>	insUsrNo() ;
	ValueProvider<Com11_DtModel, Date>		insDate() ;
	ValueProvider<Com11_DtModel, String>	updUsrNo() ;
	ValueProvider<Com11_DtModel, Date>		updDate() ;
}
