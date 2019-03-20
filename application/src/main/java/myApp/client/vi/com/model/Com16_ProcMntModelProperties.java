package myApp.client.vi.com.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Com16_ProcMntModelProperties extends PropertyAccess<Com16_ProcMntModel> {
	
	ModelKeyProvider<Com16_ProcMntModel> keyId();

	ValueProvider<Com16_ProcMntModel, Long  >	procMntId();
	ValueProvider<Com16_ProcMntModel, String>	cmpCode();
	ValueProvider<Com16_ProcMntModel, String>	stdDate();
	ValueProvider<Com16_ProcMntModel, String>	fndCode();
	ValueProvider<Com16_ProcMntModel, String>	bizSttYn();
	ValueProvider<Com16_ProcMntModel, String>	tdyRghYn();
	ValueProvider<Com16_ProcMntModel, String>	printRcvYn();
	ValueProvider<Com16_ProcMntModel, String>	trCloYn();
	ValueProvider<Com16_ProcMntModel, String>	mktPrcYn();
	ValueProvider<Com16_ProcMntModel, String>	cloChkYn();
	ValueProvider<Com16_ProcMntModel, String>	cloYn();
	ValueProvider<Com16_ProcMntModel, String>	bizEndYn();
	ValueProvider<Com16_ProcMntModel, String>	insUsrNo();
	ValueProvider<Com16_ProcMntModel, Date>		insDate();
	ValueProvider<Com16_ProcMntModel, String>	updUsrNo();
	ValueProvider<Com16_ProcMntModel, Date>		updDate();
	
	ValueProvider<Com16_ProcMntModel, Boolean> bizSttYnFlag();
}
