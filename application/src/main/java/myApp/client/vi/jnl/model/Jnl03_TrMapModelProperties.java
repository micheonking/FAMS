package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl03_TrMapModelProperties extends PropertyAccess<Jnl03_TrMapModel> {

	ModelKeyProvider<Jnl03_TrMapModel> keyId();

	ValueProvider<Jnl03_TrMapModel, Long  >	trMapId() ;
	ValueProvider<Jnl03_TrMapModel, String>	compCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	trCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	abrotypeCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	itmLcalss() ;
	ValueProvider<Jnl03_TrMapModel, String>	jnlGrpCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	tgtTrTypeCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	liqdtTypeCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	plAmtTypeCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	drcrChgPsbYn() ;
	ValueProvider<Jnl03_TrMapModel, String>	bokProcTypeCode() ;
	ValueProvider<Jnl03_TrMapModel, String>	useYn() ;
	ValueProvider<Jnl03_TrMapModel, String>	insUsrNo() ;
	ValueProvider<Jnl03_TrMapModel, Date>	insDate() ;
	ValueProvider<Jnl03_TrMapModel, String>	updUsrNo() ;
	ValueProvider<Jnl03_TrMapModel, Date>	updDate() ;
}
