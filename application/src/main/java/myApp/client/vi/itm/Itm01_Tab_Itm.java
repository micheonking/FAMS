package myApp.client.vi.itm;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.resource.ResourceIcon;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.com.Com00_ItmLookupComboBox;
import myApp.client.vi.itm.model.Itm01_ItmModel;

public class Itm01_Tab_Itm extends BorderLayoutContainer {

	private Com00_ItmLookupComboBox  itmLookup;
	private Itm01_Edit_ItmCom        itmComPanel;
	
	public Itm01_Tab_Itm() {

		ButtonBar searchBar = new ButtonBar();
		
		//-------------------------------------------------------------------
		//	종목 Lookup SET
		//-------------------------------------------------------------------
		itmLookup = new Com00_ItmLookupComboBox("주식", 170, new InterfaceCallbackResult2() {
			@Override
			public void execute(Object result) {
				itmComPanel.retrieve(itmLookup.getItmCode());
			}
			@Override
			public void enterKeyDown() {
				if(itmLookup.getItmCode() != null) {
					itmComPanel.retrieve(itmLookup.getItmCode());
				}
			}
			@Override
			public void onCollapse() {
				itmComPanel.setInit();
				if("110".equals(itmLookup.getPrdTypCode())) {
					Info.display("주식","");
				}
				else if("120".equals(itmLookup.getPrdTypCode())) {
					Info.display("수익증권","");
				}
				else if("130".equals(itmLookup.getPrdTypCode())) {
					Info.display("채권","");
				}
				else if("140".equals(itmLookup.getPrdTypCode())) {
					Info.display("단기자금","");
				}
			}
		});
		searchBar.add(itmLookup);

		//-------------------------------------------------------------------
		//	Button SET
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

		TextButton updateButton = new TextButton("수정");
		updateButton.setIcon(ResourceIcon.INSTANCE.update16Button());
		updateButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				if(nullChk(itmLookup.getItmCode())) {
					new SimpleMessage("확인", "선택된 종목이 없습니다.");
					return;
				}
				Itm01_Lookup_ItmInfoEdit lookupItmEdit = new Itm01_Lookup_ItmInfoEdit();
				lookupItmEdit.open(itmLookup.getItmCode(), new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						ServiceResult serviceResult = (ServiceResult)result;
						Itm01_ItmModel itmModel = (Itm01_ItmModel)serviceResult.getResult(0);
						itmComPanel.retrieve(itmModel.getItmCode());
					}
				});
			}
		});
		searchBar.add(updateButton);		

		TextButton insertButton = new TextButton("생성");
		insertButton.setIcon(ResourceIcon.INSTANCE.insert16Button());
		insertButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				Itm01_Lookup_ItmInfoEdit lookupItmEdit = new Itm01_Lookup_ItmInfoEdit();
				lookupItmEdit.open(null, new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						ServiceResult serviceResult = (ServiceResult)result;
						Itm01_ItmModel itmModel = (Itm01_ItmModel)serviceResult.getResult(0);
						itmLookup.setItmCode(itmModel.getItmCode());
						itmLookup.setItmName(itmModel.getItmName());
						itmComPanel.retrieve(itmModel.getItmCode());
					}
				});
			}
		});
		searchBar.add(insertButton);

		TextButton deleteButton = new TextButton("삭제");
		deleteButton.setIcon(ResourceIcon.INSTANCE.delete16Button());
		deleteButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				itmComPanel.delete();
			}
		});
		searchBar.add(deleteButton);
		
		this.setNorthWidget(searchBar, new BorderLayoutData(55));
		
		//-------------------------------------------------------------------
		//	ContentPanel SET
		//-------------------------------------------------------------------
		BorderLayoutData centerLayoutData = new BorderLayoutData();
		centerLayoutData.setMargins(new Margins(2, 0, 0, 0));
		
		itmComPanel = new Itm01_Edit_ItmCom();
		itmComPanel.open(true);
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

	private boolean nullChk(String chk) {
		if((chk == null)||("".equals(chk.replaceAll(" ", "")))) {
			return true;
		} else {
			return false;
		}
	}

}