package myApp.client.vi.com;

import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.grid.ComboBoxField;
import myApp.client.service.InterfaceCallback;
import myApp.client.utils.InterfaceCallbackResult2;

public class Com00_ItmLookupComboBox extends ButtonBar {
	
	private ComboBoxField itmLClassComboBox;
	private Com00_ItmLookupField itmLookupField;
	private InterfaceCallbackResult2  callBackResult2 = null;

	public Com00_ItmLookupComboBox(String itmLClassNm, int comboWidth, InterfaceCallbackResult2 callBackResult) {
		this.callBackResult2 = callBackResult;
		makeLookupComboBox(itmLClassNm, comboWidth);
	}

	public Com00_ItmLookupComboBox(String itmLClassNm, int comboWidth) {
		this.callBackResult2 = null;
		makeLookupComboBox(itmLClassNm, comboWidth);
	}
	
	private void makeLookupComboBox(String itmLClassNm, int comboWidth) {

		itmLClassComboBox = new ComboBoxField("LCLASS_CD", new InterfaceCallback() {
			@Override
			public void execute() {
				itmLClassComboBox.setText(itmLClassNm);
			}
		});
		itmLClassComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				itmLookupField.setLClassName(itmLClassComboBox.getText());
				itmLookupField.setItmCode(null);
				itmLookupField.setItmName(null);
				if(callBackResult2 != null) {
					callBackResult2.onCollapse();
				}
			}
		});

		FieldLabel itmLClass = new FieldLabel(itmLClassComboBox, "상품 ");
		itmLClass.setWidth(comboWidth);
		itmLClass.setLabelWidth(40);
		this.add(itmLClass);
		itmLookupField = new Com00_ItmLookupField(false, callBackResult2);
		itmLookupField.setLClassName(itmLClassNm);
		this.add(itmLookupField);
	}
	
	public String getItmCode() {
		return itmLookupField.getItmCode();
	}

	public String getItmName() {
		return itmLookupField.getItmName();
	}

	public void setItmCode(String itmCode) {
		itmLookupField.setItmCode(itmCode);
	}

	public void setItmName(String itmName) {
		itmLookupField.setItmName(itmName);
	}

	public String getPrdTypCode() {
		return itmLClassComboBox.getCode();
	}

	public String getPrdTypName() {
		return itmLClassComboBox.getText();
	}

}