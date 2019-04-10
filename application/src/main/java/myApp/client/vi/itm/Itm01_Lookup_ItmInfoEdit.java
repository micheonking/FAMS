package myApp.client.vi.itm;

import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.resource.ResourceIcon;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.itm.model.Itm01_ItmModel;

public class Itm01_Lookup_ItmInfoEdit extends Window {

	private InterfaceCallbackResult callbackResult;
	
	Itm01_ItmModel itmModel = new Itm01_ItmModel();
	Itm01_Edit_ItmCom itmComPanel = new Itm01_Edit_ItmCom();
	
	public void open (String itmCode, InterfaceCallbackResult callback) {

		this.callbackResult = callback;

		this.setModal(false);
		this.setResizable(true);
		this.setPixelSize(1100, 650);
		this.setHeading("종목정보");
		this.setButtonAlign(BoxLayoutPack.CENTER);

//		this.getButtonBar().clear();
		//-------------------------------------------------------------------
		//	조회 Button SET
		//-------------------------------------------------------------------
		TextButton updateButton = new TextButton("저장");
		updateButton.setIcon(ResourceIcon.INSTANCE.save16Button());
		updateButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				itmComPanel.update();
			}
		});
		this.buttonBar.add(updateButton);

		TextButton closeButton = new TextButton("닫기");
		closeButton.setIcon(ResourceIcon.INSTANCE.close16Button());
		closeButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				hide();
			}
		});
		this.buttonBar.add(closeButton);

		//-------------------------------------------------------------------
		//	ContentPanel SET
		//-------------------------------------------------------------------
		itmComPanel.open(itmCode, false, new InterfaceCallbackResult() {
			@Override
			public void execute(Object result) {
				callbackResult.execute(result);
				hide();
			}
		});
		this.add(itmComPanel);
		
		this.show();
	}

}
