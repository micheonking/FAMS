package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com01_ComCdModelProperties extends PropertyAccess<Com01_ComCdModel> {
	
	ModelKeyProvider<Com01_ComCdModel> keyId();

	ValueProvider<Com01_ComCdModel, Long  >		comCdId() ;
	ValueProvider<Com01_ComCdModel, String> 	 	comCode() ;
	ValueProvider<Com01_ComCdModel, String  >		comName() ;
	ValueProvider<Com01_ComCdModel, String> 		useYn() ;
	ValueProvider<Com01_ComCdModel, String  >		rmk() ;
	ValueProvider<Com01_ComCdModel, String  >		insUsrNo() ;
	ValueProvider<Com01_ComCdModel, Date>			insDate() ;
	ValueProvider<Com01_ComCdModel, String>		updUsrNo() ;
	ValueProvider<Com01_ComCdModel, Date  >		updDate() ;

	ValueProvider<Com01_ComCdModel, Boolean> useYnFlag();


}
