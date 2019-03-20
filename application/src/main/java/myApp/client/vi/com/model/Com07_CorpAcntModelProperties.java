package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com07_CorpAcntModelProperties extends PropertyAccess<Com07_CorpAcntModel> {
	
	ModelKeyProvider<Com07_CorpAcntModel> keyId();

	ValueProvider<Com07_CorpAcntModel, Long  >	com08_fee_rt_id() ;
	ValueProvider<Com07_CorpAcntModel, String> 	cmpCode() ;
	ValueProvider<Com07_CorpAcntModel, String> 	corpCode() ;
	ValueProvider<Com07_CorpAcntModel, String> 	acntNo() ;
	ValueProvider<Com07_CorpAcntModel, String> 	acntName() ;
	ValueProvider<Com07_CorpAcntModel, String> 	bnkCode() ;
	ValueProvider<Com07_CorpAcntModel, String> 	brnCode() ;
	ValueProvider<Com07_CorpAcntModel, String> 	tel() ;
	ValueProvider<Com07_CorpAcntModel, String> 	fax() ;
	ValueProvider<Com07_CorpAcntModel, String>	acntKndCode() ;
	ValueProvider<Com07_CorpAcntModel, String> 	mng() ;
	ValueProvider<Com07_CorpAcntModel, String>	rmk() ;
	ValueProvider<Com07_CorpAcntModel, String>	insUsrNo() ;
	ValueProvider<Com07_CorpAcntModel, Date>	insDate() ;
	ValueProvider<Com07_CorpAcntModel, String>	updUsrNo() ;
	ValueProvider<Com07_CorpAcntModel, Date>	updDate() ;
}
