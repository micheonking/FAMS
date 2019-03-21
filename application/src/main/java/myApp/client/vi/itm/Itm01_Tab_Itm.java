package myApp.client.vi.itm;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import myApp.client.resource.ResourceIcon;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.com.Com00_ItmLookupComboBox;

public class Itm01_Tab_Itm extends BorderLayoutContainer {

	Com00_ItmLookupComboBox itmLookup;
	Itm01_Edit_ItmCom       itmComPanel;
	
	public Itm01_Tab_Itm() {

		ButtonBar searchBar = new ButtonBar();
		
		//-------------------------------------------------------------------
		//	종목 Lookup SET
		//-------------------------------------------------------------------
		itmLookup = new Com00_ItmLookupComboBox("주식", 170, new InterfaceCallbackResult2() {
			@Override
			public void execute(Object result) {
			}
			@Override
			public void enterKeyDown() {
			}
			@Override
			public void onCollapse() {
			}
		});
		searchBar.add(itmLookup);

		//-------------------------------------------------------------------
		//	조회 Button SET
		//-------------------------------------------------------------------
		TextButton retrieveButton = new TextButton("조회");
		retrieveButton.setIcon(ResourceIcon.INSTANCE.search16Button());
		retrieveButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				retrieve();
			}
		});
		searchBar.add(retrieveButton);		
		this.setNorthWidget(searchBar, new BorderLayoutData(55));
		
		BorderLayoutData centerLayoutData = new BorderLayoutData();
		centerLayoutData.setMargins(new Margins(2, 0, 0, 0));
		
		itmComPanel = new Itm01_Edit_ItmCom();
		itmComPanel.open();
		this.setCenterWidget(itmComPanel, centerLayoutData);

	}

	protected void retrieve() {
		
		String itmCode = itmLookup.getItmCode();
		if((itmCode == null)||("".equals(itmCode))) {
            new SimpleMessage("확인", "종목코드를 입력하여 주십시오.");
            return;
		}
		
		itmComPanel.retrieve(itmCode);
	}

}