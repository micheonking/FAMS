package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com10_TaxSysModelProperties extends PropertyAccess<Com10_TaxSysModel> {
	
	ModelKeyProvider<Com10_TaxSysModel> keyId();

	ValueProvider<Com10_TaxSysModel, Long  >	taxSysId() ;
	ValueProvider<Com10_TaxSysModel, String>	taxSysTypeCode() ;
	ValueProvider<Com10_TaxSysModel, String>	taxRtTypeCode() ;
	ValueProvider<Com10_TaxSysModel, String>	trsRulApyTypeCode() ;
	ValueProvider<Com10_TaxSysModel, String>	trsRulTgtTypCode() ;
	ValueProvider<Com10_TaxSysModel, String>	appSdd() ;
	ValueProvider<Com10_TaxSysModel, String>	apyEdd() ;
	ValueProvider<Com10_TaxSysModel, String>	trsRulXtncTypeCode() ;
	ValueProvider<Com10_TaxSysModel, String>	insUsrNo() ;
	ValueProvider<Com10_TaxSysModel, Date>		insDate() ;
	ValueProvider<Com10_TaxSysModel, String>	updUsrNo() ;
	ValueProvider<Com10_TaxSysModel, Date>		updDate() ;
}
