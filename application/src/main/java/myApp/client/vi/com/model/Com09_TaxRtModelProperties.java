package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com09_TaxRtModelProperties extends PropertyAccess<Com09_TaxRtModel> {
	
	ModelKeyProvider<Com09_TaxRtModel> keyId();

	ValueProvider<Com09_TaxRtModel, Long  >	taxRtId() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtTypeCode() ;
	ValueProvider<Com09_TaxRtModel, String>	whCoTypeCode() ;
	ValueProvider<Com09_TaxRtModel, String>	apySdd() ;
	ValueProvider<Com09_TaxRtModel, String>	apyEdd() ;
	ValueProvider<Com09_TaxRtModel, String>	endAmt() ;
	ValueProvider<Com09_TaxRtModel, String>	apyTaxRt() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtApyPosTypeCode() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtApyTypeCode() ;
	ValueProvider<Com09_TaxRtModel, String>	useYn() ;
	ValueProvider<Com09_TaxRtModel, String>	insUsrNo() ;
	ValueProvider<Com09_TaxRtModel, Date>	insDate() ;
	ValueProvider<Com09_TaxRtModel, String>	updUsrNo() ;
	ValueProvider<Com09_TaxRtModel, Date>	updDate() ;
	
	ValueProvider<Com09_TaxRtModel,Boolean>	useYnFlag() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtTypeName() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtApyTypeName() ;
	ValueProvider<Com09_TaxRtModel, String>	taxRtApyPosTypeName() ;
	ValueProvider<Com09_TaxRtModel, String>	whCoTypeName() ;
}
