package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl02_JnlGrpModelProperties extends PropertyAccess<Jnl02_JnlGrpModel> {

	ModelKeyProvider<Jnl02_JnlGrpModel> keyId();

	ValueProvider<Jnl02_JnlGrpModel, Long  >	jnlGrpId() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	compCode() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	jnlGrpCode() ;
	ValueProvider<Jnl02_JnlGrpModel, Long>		seq() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	reprAcntCode() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	drcrTypeCode() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	krwCalc() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	forCalc() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	usdCalc() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	useYn() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	rmk() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	insUsrNo() ;
	ValueProvider<Jnl02_JnlGrpModel, Date>		insDate() ;
	ValueProvider<Jnl02_JnlGrpModel, String>	updUsrNo() ;
	ValueProvider<Jnl02_JnlGrpModel, Date>		updDate() ;
}
