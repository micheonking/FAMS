package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com04_TrCodeModelProperties extends PropertyAccess<Com04_TrCodeModel> {
	
	ModelKeyProvider<Com04_TrCodeModel> keyId();

	ValueProvider<Com04_TrCodeModel, Long  >			trCdId() ;
	ValueProvider<Com04_TrCodeModel, String> 	 		trCode() ;
	ValueProvider<Com04_TrCodeModel, String  >		trName() ;
	ValueProvider<Com04_TrCodeModel, String> 			trOccTypeCode() ;
	ValueProvider<Com04_TrCodeModel, String  >		seq() ;
	ValueProvider<Com04_TrCodeModel, String  >		applProcYn() ;
	ValueProvider<Com04_TrCodeModel, String  >		accSndYn() ;
	ValueProvider<Com04_TrCodeModel, String  >		insUsrNo() ;
	ValueProvider<Com04_TrCodeModel, Date>			insDate() ;
	ValueProvider<Com04_TrCodeModel, String>			updUsrNo() ;
	ValueProvider<Com04_TrCodeModel, Date  >			updDate() ;

	ValueProvider<Com04_TrCodeModel, Boolean> applProcYnFlag();
	ValueProvider<Com04_TrCodeModel, Boolean> accSndYnFlag();


}
