package myApp.client.vi.com;


import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent.CellDoubleClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.com.model.Com07_CorpAcntModel;
import myApp.client.vi.com.model.Com07_CorpAcntModelProperties;

public class Com08_ReeRateLookupField extends Window implements InterfaceServiceCall{
	
	private Grid<Com07_CorpAcntModel> grid = this.buildGrid();
	private InterfaceCallbackResult callback;
	
	public void open() {
		
		this.callback = callback;
		this.setModal(false);
		this.setResizable(true);
		this.setPixelSize(550, 500);
		
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
//		vlc.add(searchBar, new VerticalLayoutData(1, 50));
		vlc.add(grid, new VerticalLayoutData(1, 1));
		
		this.add(vlc);
		
		TextButton okButton = new TextButton("확인");
		okButton.setWidth(50);
		okButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				confirm();
			}
		});
		this.addButton(okButton);

		TextButton cancelButton = new TextButton("취소");
		cancelButton.setWidth(50);
		cancelButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				hide();
			}
		});
		this.addButton(cancelButton);
		this.setButtonAlign(BoxLayoutPack.CENTER);
		
		this.grid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			@Override
			public void onCellClick(CellDoubleClickEvent event) {
				confirm(); 
			}
		}); 
		
		this.show();
		
	}
	
	protected void confirm() {
		
	}

	private Grid<Com07_CorpAcntModel> buildGrid(){
		Com07_CorpAcntModelProperties properties = GWT.create(Com07_CorpAcntModelProperties.class);
		GridBuilder<Com07_CorpAcntModel> gridBuilder = new GridBuilder<Com07_CorpAcntModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.cmpCode(), 150, "회사코드");
		gridBuilder.addText(properties.corpCode(), 150, "기관코드");
		gridBuilder.addText(properties.acntNo(), 200, "계좌번호");
		gridBuilder.addText(properties.acntName(), 200, "계좌명");
		gridBuilder.addText(properties.bnkCode(), 150, "은행코드");
		gridBuilder.addText(properties.brnCode(), 200, "지점명");
		gridBuilder.addText(properties.tel(), 200, "전화번호");
		gridBuilder.addText(properties.fax(), 70, "FAX번호");
		gridBuilder.addText(properties.acntKndCode(), 70, "계좌종류코드");
		gridBuilder.addText(properties.mng(), 70, "담당자");
		gridBuilder.addText(properties.rmk(), 70, "비고");
		return gridBuilder.getGrid(); 
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		// TODO Auto-generated method stub
		
	}
}