package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl04_RealAcntMapModelProperties extends PropertyAccess<Jnl04_RealAcntMapModel> {

	ModelKeyProvider<Jnl04_RealAcntMapModel> keyId();

	ValueProvider<Jnl04_RealAcntMapModel, Long  >	realAcntMapId() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	compCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	reprAcntCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	dealPrpsTypeCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	itmMclass() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	astTypeCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	krwForTypeCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	etcTypeCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	AcntCode() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	insUsrNo() ;
	ValueProvider<Jnl04_RealAcntMapModel, Date>		insDate() ;
	ValueProvider<Jnl04_RealAcntMapModel, String>	updUsrNo() ;
	ValueProvider<Jnl04_RealAcntMapModel, Date>		updDate() ;
}
