package myApp.client.grid;

import java.util.HashMap;
import java.util.Map;

import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.form.StringComboBox;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.service.InterfaceCallback;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.com.model.Com02_DtlCodeModel;

public class ComboBoxField extends StringComboBox implements InterfaceServiceCall {
	
	private Map<String, Com02_DtlCodeModel> codeMap = new HashMap<String, Com02_DtlCodeModel>();
	private Com02_DtlCodeModel altCodeModel = new Com02_DtlCodeModel(); 
	
	private String kindCode = null;
	private InterfaceCallback callback;
	
	public ComboBoxField(String KindCode){
		this.makeComboBoxField(KindCode);  
  	}
	public ComboBoxField(String KindCode, InterfaceCallback callback){
		this.callback = callback; 
		this.makeComboBoxField(KindCode);
  	}  	
	public ComboBoxField(String KindCode, String code, String codeName){
		// 전체(%)가 필요한 경우.
		this.setAltCode(code, codeName);
		this.makeComboBoxField(KindCode);
	}
	public ComboBoxField(String KindCode, String code, String codeName, InterfaceCallback callback){
		// 전체(%)가 필요한 경우.
		this.callback = callback; 
		this.setAltCode(code, codeName);
		this.makeComboBoxField(KindCode);
   	}  	
	public ComboBoxField(String KindCode, TextField targetField){
		// 콤보선택 시 targetField값을 자동 설정한다. 
		this.setTriggerField(targetField);
		this.makeComboBoxField(KindCode);
   	}  	
	public ComboBoxField(String KindCode,  String code, String codeName, TextField targetField){
		this.setTriggerField(targetField);
		this.setAltCode(code, codeName);
		this.makeComboBoxField(KindCode);
  	}  	
	
	private void setTriggerField(TextField targetField) {
	    // 닫힐때 필드값을 변경한다. 
		this.addCollapseHandler(new CollapseHandler(){
			@Override
			public void onCollapse(CollapseEvent event) {
				targetField.setValue(getCode());
			}
    	}); 
	}
	private void setAltCode(String code, String codeName) {
		this.altCodeModel.setDtlCode(code);
		this.altCodeModel.setDtlName(codeName);
	}
	private void makeComboBoxField(String kindCode) {
		this.kindCode= kindCode; 
		this.setTriggerAction(TriggerAction.ALL);
		this.setEditable(false); // edit을 못하게 한다. 
		this.retrieve();
	}

	public String getCode(){
		Com02_DtlCodeModel code = codeMap.get(this.getCurrentValue()); 
  		if(code != null){
  			return code.getDtlCode(); 
  		}
  		else {
  			return null; 
  		}
  	}
	
	public void retrieve() {
		ServiceRequest request = new ServiceRequest("com.Com02_DtlCode.selectByComCode");
		request.putStringParam("comCode", this.kindCode);
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}
	
	@Override
	public void getServiceResult(ServiceResult result) {
		
		this.getStore().clear();
		this.codeMap.clear();
		
		if(result.getStatus() < 0){
			Info.display("error", result.getMessage());
			return ; 
		}
		
		// 추가코드가 있으면 먼저 넣는다. 
		if(this.altCodeModel.getDtlName() != null) {
			codeMap.put(this.altCodeModel.getDtlName(), this.altCodeModel);
			this.add(altCodeModel.getDtlName());
		}
		
		int i=0;
		String initCodeName = null;
		
		for (GridDataModel model: result.getResult()) {
			Com02_DtlCodeModel code = (Com02_DtlCodeModel)model ;
			
			if(codeMap.get(code.getDtlName()) == null) {
				// 코드명이 같은게 있으면 Skip한다. 
				codeMap.put(code.getDtlName(), code);
				this.add(code.getDtlName());
				
				if(i==0) {
					initCodeName = code.getDtlName();
				}
				i++;
			}
		}
		
		if(this.altCodeModel.getDtlName() == null) {
			this.setText(initCodeName);
		} else {
			this.setText(this.altCodeModel.getDtlName());
		}

		if(this.callback != null) {
			this.callback.execute();
		}
	}
}
