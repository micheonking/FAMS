package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com05_AcntCodeModelProperties extends PropertyAccess<Com05_AcntCodeModel> {
	
	ModelKeyProvider<Com05_AcntCodeModel> keyId();

	ValueProvider<Com05_AcntCodeModel, Long  >	acntCodeId() ;
	ValueProvider<Com05_AcntCodeModel, String> 	cmpCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	accCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	accKname() ;
	ValueProvider<Com05_AcntCodeModel, String> 	accEname2() ;
	ValueProvider<Com05_AcntCodeModel, String> 	drCrTypeCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	chdPrntTypeCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	accLvlCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	prntAccCode() ;
	ValueProvider<Com05_AcntCodeModel, String>	accAttCode() ;
	ValueProvider<Com05_AcntCodeModel, String> 	tlgAttCode() ;
	ValueProvider<Com05_AcntCodeModel, String>	seq() ;
	ValueProvider<Com05_AcntCodeModel, String>	prntAccCode1() ;
	ValueProvider<Com05_AcntCodeModel, String>	prntAccCode2() ;
	ValueProvider<Com05_AcntCodeModel, String>	prntAccCode3() ;
	ValueProvider<Com05_AcntCodeModel, String>	prntAccCode4() ;
	ValueProvider<Com05_AcntCodeModel, String>	prntAccCode5() ;
	ValueProvider<Com05_AcntCodeModel, String>	tgtAccCode() ;
	ValueProvider<Com05_AcntCodeModel, String>	ustlYn() ;
	ValueProvider<Com05_AcntCodeModel, String>	balMagYn() ;
	ValueProvider<Com05_AcntCodeModel, String>	accSndYn() ;
	ValueProvider<Com05_AcntCodeModel, String>	insUsrNo() ;
	ValueProvider<Com05_AcntCodeModel, Date>	insDate() ;
	ValueProvider<Com05_AcntCodeModel, String>	updUsrNo() ;
	ValueProvider<Com05_AcntCodeModel, Date>	updDate() ;

	ValueProvider<Com05_AcntCodeModel, Boolean>	ustlYnFlag();
	ValueProvider<Com05_AcntCodeModel, Boolean>	useYnFlag();
	ValueProvider<Com05_AcntCodeModel, Boolean>	balMagYnFlag();
}
