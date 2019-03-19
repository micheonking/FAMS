package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com01_ComCodeModelProperties extends PropertyAccess<Com01_ComCodeModel> {
	
	ModelKeyProvider<Com01_ComCodeModel> keyId();

	ValueProvider<Com01_ComCodeModel, Long  >		comCdId() ;
	ValueProvider<Com01_ComCodeModel, String> 	 	comCode() ;
	ValueProvider<Com01_ComCodeModel, String  >		comName() ;
	ValueProvider<Com01_ComCodeModel, String> 		useYn() ;
	ValueProvider<Com01_ComCodeModel, String  >		rmk() ;
	ValueProvider<Com01_ComCodeModel, String  >		insUsrNo() ;
	ValueProvider<Com01_ComCodeModel, Date>			insDate() ;
	ValueProvider<Com01_ComCodeModel, String>		updUsrNo() ;
	ValueProvider<Com01_ComCodeModel, Date  >		updDate() ;

	ValueProvider<Com01_ComCodeModel, Boolean> useYnFlag();


}
