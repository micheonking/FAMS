package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com04_TrCdGrpModelProperties extends PropertyAccess<Com04_TrCdModel> {
	
	ModelKeyProvider<Com04_TrCdModel> keyId();

	ValueProvider<Com04_TrCdModel, Long  >			trCdId() ;
	ValueProvider<Com04_TrCdModel, String> 	 		trCode() ;
	ValueProvider<Com04_TrCdModel, String  >		trName() ;
	ValueProvider<Com04_TrCdModel, String> 			trOccTypeCode() ;
	ValueProvider<Com04_TrCdModel, String  >		seq() ;
	ValueProvider<Com04_TrCdModel, String  >		applProcYn() ;
	ValueProvider<Com04_TrCdModel, String  >		accSndYn() ;
	ValueProvider<Com04_TrCdModel, String  >		insUsrNo() ;
	ValueProvider<Com04_TrCdModel, Date>			insDate() ;
	ValueProvider<Com04_TrCdModel, String>			updUsrNo() ;
	ValueProvider<Com04_TrCdModel, Date  >			updDate() ;

	ValueProvider<Com04_TrCdModel, Boolean> applProcYnFlag();


}
