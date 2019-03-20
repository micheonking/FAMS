package myApp.client.vi.jnl.model;

import java.util.Date;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface Jnl01_ReprAcntCodeModelProperties extends PropertyAccess<Jnl01_ReprAcntCodeModel> {

	ModelKeyProvider<Jnl01_ReprAcntCodeModel> keyId();

	ValueProvider<Jnl01_ReprAcntCodeModel, Long  >	reprAcntCodeId() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	reprAcntCode() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	reprAcntName() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	acntAttCode() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	tgtReprAcntCode() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	bokMagYn() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	exrtApyTypeCode() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	rmk() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	insUsrNo() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, Date>	insDate() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, String>	updUsrNo() ;
	ValueProvider<Jnl01_ReprAcntCodeModel, Date>	updDate() ;
}
