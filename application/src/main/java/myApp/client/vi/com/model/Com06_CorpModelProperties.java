package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com06_CorpModelProperties extends PropertyAccess<Com06_CorpModel> {
	
	ModelKeyProvider<Com06_CorpModel> keyId();

	ValueProvider<Com06_CorpModel, Long  >	corpId() ;
	ValueProvider<Com06_CorpModel, String> 	cmpCode() ;
	ValueProvider<Com06_CorpModel, String> 	corpCode() ;
	ValueProvider<Com06_CorpModel, String> 	corpName() ;
	ValueProvider<Com06_CorpModel, String> 	corpTypeCode() ;
	ValueProvider<Com06_CorpModel, String> 	bizRegNo() ;
	ValueProvider<Com06_CorpModel, String> 	corpRegNo() ;
	ValueProvider<Com06_CorpModel, String> 	grpCorpCode() ;
	ValueProvider<Com06_CorpModel, String> 	stlBnkCode() ;
	ValueProvider<Com06_CorpModel, String>	stlBnkAcntNo() ;
	ValueProvider<Com06_CorpModel, String> 	kscCorpCode() ;
	ValueProvider<Com06_CorpModel, String>	stnIndClassCode() ;
	ValueProvider<Com06_CorpModel, String>	estDate() ;
	ValueProvider<Com06_CorpModel, String>	reprName() ;
	ValueProvider<Com06_CorpModel, String>	telNo() ;
	ValueProvider<Com06_CorpModel, String>	addr() ;
	ValueProvider<Com06_CorpModel, String>	intTypeCode() ;
	ValueProvider<Com06_CorpModel, String>	abroTypeCode() ;
	ValueProvider<Com06_CorpModel, String>	dshTypeCode() ;
	ValueProvider<Com06_CorpModel, String>	insUsrNo() ;
	ValueProvider<Com06_CorpModel, Date>	insDate() ;
	ValueProvider<Com06_CorpModel, String>	updUsrNo() ;
	ValueProvider<Com06_CorpModel, Date>	updDate() ;

	ValueProvider<Com06_CorpModel, Boolean>	useYnFlag();
}
