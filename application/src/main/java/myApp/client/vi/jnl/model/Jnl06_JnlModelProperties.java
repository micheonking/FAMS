package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl06_JnlModelProperties extends PropertyAccess<Jnl06_JnlModel> {

	ModelKeyProvider<Jnl06_JnlModel> keyId();

	ValueProvider<Jnl06_JnlModel, Long  >	jnlId() ;
	ValueProvider<Jnl06_JnlModel, Long>		oprId() ;
	ValueProvider<Jnl06_JnlModel, String>	jnlDate() ;
	ValueProvider<Jnl06_JnlModel, Long>		seq() ;
	ValueProvider<Jnl06_JnlModel, String>	drAcntCode() ;
	ValueProvider<Jnl06_JnlModel, Long>		drKrwAmt() ;
	ValueProvider<Jnl06_JnlModel, Long>		drForAmt() ;
	ValueProvider<Jnl06_JnlModel, Long>		drUsdAmt() ;
	ValueProvider<Jnl06_JnlModel, String>	crAcntCode() ;
	ValueProvider<Jnl06_JnlModel, Long>		crKrwAmt() ;
	ValueProvider<Jnl06_JnlModel, Long>		crForAmt() ;
	ValueProvider<Jnl06_JnlModel, Long>		crUsdAmt() ;
	ValueProvider<Jnl06_JnlModel, String>	insUsrNo() ;
	ValueProvider<Jnl06_JnlModel, Date>		insDate() ;
	ValueProvider<Jnl06_JnlModel, String>	updUsrNo() ;
	ValueProvider<Jnl06_JnlModel, Date>		updDate() ;
}
