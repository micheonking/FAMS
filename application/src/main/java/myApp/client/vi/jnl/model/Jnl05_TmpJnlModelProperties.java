package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl05_TmpJnlModelProperties extends PropertyAccess<Jnl05_TmpJnlModel> {

	ModelKeyProvider<Jnl05_TmpJnlModel> keyId();

	ValueProvider<Jnl05_TmpJnlModel, Long  >	tmpJnlId() ;
	ValueProvider<Jnl05_TmpJnlModel, Long>		oprId() ;
	ValueProvider<Jnl05_TmpJnlModel, String>	jnlDate() ;
	ValueProvider<Jnl05_TmpJnlModel, Long>		seq() ;
	ValueProvider<Jnl05_TmpJnlModel, String>	reprAcntCode() ;
	ValueProvider<Jnl05_TmpJnlModel, String>	drcrTypeCode() ;
	ValueProvider<Jnl05_TmpJnlModel, Long>		krwAmt() ;
	ValueProvider<Jnl05_TmpJnlModel, Long>		forAmt() ;
	ValueProvider<Jnl05_TmpJnlModel, Long>		usdAmt() ;
	ValueProvider<Jnl05_TmpJnlModel, String>	insUsrNo() ;
	ValueProvider<Jnl05_TmpJnlModel, Date>		insDate() ;
	ValueProvider<Jnl05_TmpJnlModel, String>	updUsrNo() ;
	ValueProvider<Jnl05_TmpJnlModel, Date>		updDate() ;
}
