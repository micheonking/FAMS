package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com03_DtlCodeGrpModelProperties extends PropertyAccess<Com03_DtlCodeGrpModel> {
	
	ModelKeyProvider<Com03_DtlCodeGrpModel> keyId();

	ValueProvider<Com03_DtlCodeGrpModel, Long  > dtlCdGrpId() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> cmpCode() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> grpCode() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> comCode() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> dtlCode() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> dtlName() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> rmk() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> insUsrNo() ;
	ValueProvider<Com03_DtlCodeGrpModel, Date  > insDate() ;
	ValueProvider<Com03_DtlCodeGrpModel, String> updUsrNo() ;
	ValueProvider<Com03_DtlCodeGrpModel, Date  > updDate() ;

	ValueProvider<Com03_DtlCodeGrpModel, Boolean> useYnFlag();
}
