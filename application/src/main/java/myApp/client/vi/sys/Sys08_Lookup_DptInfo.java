package myApp.client.vi.sys;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent.CellDoubleClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.InterfaceCallback;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys03_MenuModel;
import myApp.client.vi.sys.model.Sys03_MenuModelProperties;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;
import myApp.client.vi.sys.model.Sys08_DptInfoModelProperties;

public class Sys08_Lookup_DptInfo extends Window implements InterfaceServiceCall{

	private TextField dptName = new TextField();
	private Grid<Sys08_DptInfoModel> grid = this.buildGrid();
	private InterfaceCallbackResult callback;
	
	public void open (InterfaceCallbackResult callback) {

		this.callback = callback;

		this.setModal(false);
		this.setHeading("부서정보");
		this.setResizable(false);
		this.setPixelSize(450, 400);
		
		ButtonBar searchBar = new ButtonBar(); 

		FieldLabel searchField = new FieldLabel(dptName, "부서명 검색 ");
		dptName.setEmptyText("전체");
		dptName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == 13) {
					retrieve();
				}
			}
		});
		searchField.setLabelWidth(80);
		searchField.setWidth(300);
		searchBar.add(searchField);
		
		TextButton retrieveButton = new TextButton("조회");
		retrieveButton.setWidth(50);
		retrieveButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				retrieve();
			}
		});
		searchBar.add(retrieveButton);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(searchBar, new VerticalLayoutData(1, 50));
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
		this.retrieve();
	}

	private Grid<Sys08_DptInfoModel> buildGrid() {
		Sys08_DptInfoModelProperties properties = GWT.create(Sys08_DptInfoModelProperties.class);
		GridBuilder<Sys08_DptInfoModel> gridBuilder = new GridBuilder<Sys08_DptInfoModel>(properties.keyId());
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.dptCode(), 100, "부서코드");
		gridBuilder.addText(properties.dptName(), 230, "부서명");
		return gridBuilder.getGrid();
	}

	private void retrieve() {
		
		grid.mask("Loading");
		
		GridRetrieveData<Sys08_DptInfoModel> service = new GridRetrieveData<Sys08_DptInfoModel>(grid.getStore());
		String dptName = this.dptName.getText() ; 
		if(dptName != null) {
			dptName = "%" + dptName + "%";  
		}
		else {
			dptName = "%"; 
		}
		service.addParam("dptName", dptName);
		service.addParam("cmpCode", LoginUser.getCmpCode());
		service.retrieve("sys.Sys08_DptInfo.selectByName", new InterfaceCallback() {
			@Override
			public void execute() {
				grid.unmask();
			}
		});
	}
	
	protected void confirm() {
		if(this.callback != null) {
			Sys08_DptInfoModel selectModel = this.grid.getSelectionModel().getSelectedItem(); 
			if(selectModel != null) {
				this.callback.execute(selectModel);
			}
			else {
				new SimpleMessage("선택한 화면이 없습니다."); 
				return; 
			}
		}
		this.hide(); 
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if(result.getStatus() > 0 ) {
			callback.execute(null);
			this.hide(); 
		}
		else {
			new SimpleMessage("error"); 
		}
	}
}
