package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com03_DtlCdGrpModelProperties extends PropertyAccess<Com03_DtlCdGrpModel> {
	
	ModelKeyProvider<Com03_DtlCdGrpModel> keyId();

	ValueProvider<Com03_DtlCdGrpModel, Long  >			dtlCdGrpId() ;
	ValueProvider<Com03_DtlCdGrpModel, String> 	 		cmpCode() ;
	ValueProvider<Com03_DtlCdGrpModel, String  >		grpCode() ;
	ValueProvider<Com03_DtlCdGrpModel, String> 			comCode() ;
	ValueProvider<Com03_DtlCdGrpModel, String  >		comDtlCode() ;
	ValueProvider<Com03_DtlCdGrpModel, String  >		dtlName() ;
	ValueProvider<Com03_DtlCdGrpModel, String  >		rmk() ;
	ValueProvider<Com03_DtlCdGrpModel, String  >		insUsrNo() ;
	ValueProvider<Com03_DtlCdGrpModel, Date>			insDate() ;
	ValueProvider<Com03_DtlCdGrpModel, String>			updUsrNo() ;
	ValueProvider<Com03_DtlCdGrpModel, Date  >			updDate() ;

	ValueProvider<Com03_DtlCdGrpModel, Boolean> useYnFlag();


}
