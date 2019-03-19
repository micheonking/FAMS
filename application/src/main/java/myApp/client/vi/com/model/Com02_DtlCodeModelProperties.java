package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com02_DtlCodeModelProperties extends PropertyAccess<Com02_DtlCodeModel> {
	
	ModelKeyProvider<Com02_DtlCodeModel> keyId();

	ValueProvider<Com02_DtlCodeModel, Long  > dtlCdId() ;
	ValueProvider<Com02_DtlCodeModel, String> comCode() ;
	ValueProvider<Com02_DtlCodeModel, String> dtlCode() ;
	ValueProvider<Com02_DtlCodeModel, String> dtlName() ;
	ValueProvider<Com02_DtlCodeModel, String> useYn() ;
	ValueProvider<Com02_DtlCodeModel, String> rmk() ;
	ValueProvider<Com02_DtlCodeModel, String> insUsrNo() ;
	ValueProvider<Com02_DtlCodeModel, Date  > insDate() ;
	ValueProvider<Com02_DtlCodeModel, String> updUsrNo() ;
	ValueProvider<Com02_DtlCodeModel, Date  > updDate() ;

	ValueProvider<Com02_DtlCodeModel, Boolean> useYnFlag();
}
