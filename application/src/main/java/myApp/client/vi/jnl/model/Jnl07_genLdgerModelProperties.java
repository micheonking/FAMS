package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl07_genLdgerModelProperties extends PropertyAccess<Jnl07_genLdgerModel> {

	ModelKeyProvider<Jnl07_genLdgerModel> keyId();

	ValueProvider<Jnl07_genLdgerModel, Long  >	genIdgerId() ;
	ValueProvider<Jnl07_genLdgerModel, String>	cmpCode() ;
	ValueProvider<Jnl07_genLdgerModel, String>	evlDate() ;
	ValueProvider<Jnl07_genLdgerModel, String>	fndCode() ;
	ValueProvider<Jnl07_genLdgerModel, String>	acntCode() ;
	ValueProvider<Jnl07_genLdgerModel, String>	evlCloTypeCode() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	drTdyBal() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	drTdydiff() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	drPdyBal() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	crTdyBal() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	crTdyDiff() ;
	ValueProvider<Jnl07_genLdgerModel, Long>	crPdyBal() ;
	ValueProvider<Jnl07_genLdgerModel, String>	insUsrNo() ;
	ValueProvider<Jnl07_genLdgerModel, Date>	insDate() ;
	ValueProvider<Jnl07_genLdgerModel, String>	updUsrNo() ;
	ValueProvider<Jnl07_genLdgerModel, Date>	updDate() ;
}
