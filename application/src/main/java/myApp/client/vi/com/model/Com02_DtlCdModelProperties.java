package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com02_DtlCdModelProperties extends PropertyAccess<Com02_DtlCdModel> {
	
	ModelKeyProvider<Com02_DtlCdModel> keyId();

	ValueProvider<Com02_DtlCdModel, Long  >			dtlCdId() ;
	ValueProvider<Com02_DtlCdModel, String> 	 	comCode() ;
	ValueProvider<Com02_DtlCdModel, String  >		comDtlCode() ;
	ValueProvider<Com02_DtlCdModel, String> 		dtlName() ;
	ValueProvider<Com02_DtlCdModel, String  >		useYn() ;
	ValueProvider<Com02_DtlCdModel, String  >		rmk() ;
	ValueProvider<Com02_DtlCdModel, String  >		insUsrNo() ;
	ValueProvider<Com02_DtlCdModel, Date>			insDate() ;
	ValueProvider<Com02_DtlCdModel, String>			updUsrNo() ;
	ValueProvider<Com02_DtlCdModel, Date  >			updDate() ;

	ValueProvider<Com02_DtlCdModel, Boolean> useYnFlag();


}
