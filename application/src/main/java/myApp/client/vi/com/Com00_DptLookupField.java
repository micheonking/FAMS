package myApp.client.vi.com;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

import myApp.client.field.LookupTriggerField;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.vi.sys.Sys08_Lookup_DptInfo;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;

public class Com00_DptLookupField extends ContentPanel {
	
	private LookupTriggerField dptName = new LookupTriggerField();
	private InterfaceCallbackResult   callBackResult;
	private InterfaceCallbackResult2  callBackResult2;
	
	public Com00_DptLookupField(int width, boolean titleYn, InterfaceCallbackResult callBackResult) {
		this.callBackResult = callBackResult;
		this.makeLookupField(width, titleYn);
	}
	
	public Com00_DptLookupField(int width, boolean titleYn, InterfaceCallbackResult2 callBackResult) {
		this.callBackResult2 = callBackResult;
		this.makeLookupField(width, titleYn);
	}

	public Com00_DptLookupField(int width, boolean titleYn) {
		this.callBackResult  = null;
		this.callBackResult2 = null;
		this.makeLookupField(width, titleYn);
	}
	
	private void makeLookupField(int width, boolean titleYn) {

		dptName.setWidth(width);
		dptName.addTriggerClickHandler(new TriggerClickHandler() {
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
				Sys08_Lookup_DptInfo lookupDpt = new Sys08_Lookup_DptInfo();
				lookupDpt.open(new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						Sys08_DptInfoModel data = (Sys08_DptInfoModel) result;
						dptName.setText(data.getDptName());
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
			dptName.addKeyDownHandler(new KeyDownHandler() {
				@Override
				public void onKeyDown(KeyDownEvent event) {
					if(event.getNativeKeyCode() == 13){ // enter key down
						callBackResult2.enterKeyDown(); 
					}
				}
			});
		}
		
		if(titleYn) {
			FieldLabel dptField = new FieldLabel(dptName, "부서 ");
			dptField.setLabelWidth(40);
			this.add(dptField);
		} else {
			this.add(dptName);
		}

		this.setHeaderVisible(false);
		this.setBorders(false);
	}
	
	public String getDptName() {
		return this.dptName.getText();
	}

	public void setDptName(String dptName) {
		this.dptName.setText(dptName);
	}

}