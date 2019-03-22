package myApp.client.vi.com;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.field.LookupTriggerField;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.vi.LoginUser;
import myApp.client.vi.itm.Itm01_Lookup_Itm;
import myApp.client.vi.itm.model.Itm01_ItmModel;

public class Com00_ItmLookupField extends ContentPanel implements InterfaceServiceCall {
	
	private LookupTriggerField itmName = new LookupTriggerField();
	private TextField itmCode = new TextField();
	private String lClassName;
	
	private InterfaceCallbackResult   callBackResult;
	private InterfaceCallbackResult2  callBackResult2;

//	public Com00_ItmLookupField(int width, boolean titleYn, InterfaceCallbackResult callBackResult) {
//		this.callBackResult = callBackResult;
//		this.makeLookupField(width, titleYn);
//	}

	public Com00_ItmLookupField(boolean titleYn, InterfaceCallbackResult2 callBackResult) {
		this.callBackResult2 = callBackResult;
		this.makeLookupField(titleYn);
	}

	public Com00_ItmLookupField(boolean titleYn) {
		this.callBackResult  = null;
		this.callBackResult2 = null;
		this.makeLookupField(titleYn);
	}

	private void makeLookupField(boolean titleYn) {
		
		itmCode.setWidth(150);
		itmCode.setEmptyText("종목");
		itmCode.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				selectOneItmName();
			}
		});

//		if(titleYn) {
//			FieldLabel itmField = new FieldLabel(itmCode, "종목 ");
//			itmField.setLabelWidth(40);
//			itmField.setWidth(200);
//			this.add(itmField);
//		} else {
//			this.add(itmCode);
//		}
		
		itmName.setWidth(300);
		itmName.setEmptyText("종목명");
		itmName.addTriggerClickHandler(new TriggerClickHandler() {
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
				Itm01_Lookup_Itm lookupItm = new Itm01_Lookup_Itm();
				lookupItm.open(lClassName, new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						Itm01_ItmModel data = (Itm01_ItmModel) result;
						itmCode.setText(data.getItmCode());
						itmName.setText(data.getItmName());
						if(callBackResult != null) {
							callBackResult.execute(result);
						}
						if(callBackResult2 != null) {
							callBackResult2.execute(result);
						}
					}
				});
			}
		});
		
		if(callBackResult2 != null) {
			itmName.addKeyDownHandler(new KeyDownHandler() {
				@Override
				public void onKeyDown(KeyDownEvent event) {
					if(event.getNativeKeyCode() == 13){ // enter key down
						callBackResult2.enterKeyDown(); 
					}
				}
			});
		}
		
		HBoxLayoutContainer hBox = new HBoxLayoutContainer();
		hBox.setHeight(32);
		hBox.add(itmCode, new BoxLayoutData(new Margins(0, 2, 0, 0)));
		hBox.add(itmName);
		
		this.add(hBox);

		this.setHeaderVisible(false);
		this.setBorders(false);
	}
	
	protected void selectOneItmName() {
		String itmCode = this.itmCode.getText();
		if((itmCode == null)||("".equals(itmCode))) {
			this.itmName.setText(null);
			return;
		}

		ServiceRequest request = new ServiceRequest("itm.Itm01_Itm.selectOneItmName");
		request.putStringParam("cmpCode", LoginUser.getCmpCode());
		request.putStringParam("itmCode", itmCode);
		
		ServiceCall service = new ServiceCall();
		service.execute(request, this);		
	}

	public String getItmCode() {
		return itmCode.getText();
	}

	public String getItmName() {
		return itmName.getText();
	}

	public void setItmCode(String itmcode) {
		this.itmCode.setText(itmcode);
	}

	public void setItmName(String itmName) {
		this.itmName.setText(itmName);
	}

	public void setLClassName(String lClassName) {
		this.lClassName = lClassName;
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		itmName.setText(result.getMessage());
	}
	
}