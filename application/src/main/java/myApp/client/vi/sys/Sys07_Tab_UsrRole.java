package myApp.client.vi.sys;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.Com00_DptLookupField;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModelProperties;
import myApp.client.vi.sys.model.Sys05_RoleModel;
import myApp.client.vi.sys.model.Sys05_RoleModelProperties;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class Sys07_Tab_UsrRole extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Com00_DptLookupField dptName;
	private TextField usrName = new TextField();
	
	private Grid<Sys02_UsrInfoModel> usrGrid  = this.buildUserGrid();
	private Grid<Sys05_RoleModel> roleGrid = this.buildRoleGrid();
	
	public Sys07_Tab_UsrRole() {

		//--------------------------------------------------------------
		//	SearchBar SET
		//--------------------------------------------------------------
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		dptName = new Com00_DptLookupField(200, true, new InterfaceCallbackResult2() {
			@Override
			public void execute(Object result) {
			}
			@Override
			public void enterKeyDown() {
				retrieve();
			}
			@Override
			public void onCollapse() {
			}
		});
		searchBarBuilder.getSearchBar().add(dptName);
		searchBarBuilder.addTextField(usrName, "사원검색", 200, 60, true);
		searchBarBuilder.addRetrieveButton();

		BorderLayoutData northLayoutData = new BorderLayoutData(50); 
		northLayoutData.setMargins(new Margins(0,0,0,0));
		this.setNorthWidget(searchBarBuilder.getSearchBar(), northLayoutData); 

		//--------------------------------------------------------------
		//	User Grid SET
		//--------------------------------------------------------------
		this.setCenterWidget(this.usrGrid);
		this.usrGrid.addRowClickHandler(new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				retrieveUsrRole();  
			}
		});
		
		//--------------------------------------------------------------
		//	Role Grid SET
		//--------------------------------------------------------------
		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.add(this.roleGrid);
		
		TextButton updateButton = new TextButton("저장"); 
		updateButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				update(); 
			}
		}) ; 
		cp.getButtonBar().add(updateButton);
		cp.setButtonAlign(BoxLayoutPack.CENTER);
  
		BorderLayoutData southLayoutData = new BorderLayoutData(0.4);
		southLayoutData.setSplit(true);
		southLayoutData.setMargins(new Margins(3,0,0,0));
		southLayoutData.setMaxSize(1000);
		
		this.setSouthWidget(cp, southLayoutData);
		
		retrieve();
	}
	
	public Grid<Sys02_UsrInfoModel> buildUserGrid(){
		
		Sys02_UsrInfoModelProperties properties = GWT.create(Sys02_UsrInfoModelProperties.class);
		GridBuilder<Sys02_UsrInfoModel> gridBuilder = new GridBuilder<Sys02_UsrInfoModel>(properties.keyId());
		gridBuilder.setChecked(SelectionMode.SINGLE);

		gridBuilder.addText(properties.usrNo(), 100, "사번");
		gridBuilder.addText(properties.usrName(), 150, "성명");
		gridBuilder.addText(properties.dptName(), 200, "부서명");
		gridBuilder.addText(properties.telNo(), 120, "연락처");
		gridBuilder.addText(properties.email(), 200, "이메일주소");

		return gridBuilder.getGrid(); 
	}

	public Grid<Sys05_RoleModel> buildRoleGrid(){

		Sys05_RoleModelProperties properties = GWT.create(Sys05_RoleModelProperties.class);

		GridBuilder<Sys05_RoleModel> gridBuilder = new GridBuilder<Sys05_RoleModel>(properties.keyId());  
//		gridBuilder.setChecked(SelectionMode.MULTI);
		gridBuilder.addText(properties.roleName(), 250, "권한명");
		gridBuilder.addBoolean(properties.usrRoleYnFlag(), 40, "권한");
		gridBuilder.addLong(properties.seq(), 60, "순서");
		gridBuilder.addText(properties.rmk(), 400, "비고");

		return gridBuilder.getGrid(); 
	}
	
	public void retrieveUsrRole(){
		
		Sys02_UsrInfoModel usrModel = usrGrid.getSelectionModel().getSelectedItem() ; 
		if(usrModel != null){
			GridRetrieveData<Sys05_RoleModel> service = new GridRetrieveData<Sys05_RoleModel>(roleGrid.getStore());
			service.addParam("cmpCode", usrModel.getCmpCode());
			service.addParam("usrNo", usrModel.getUsrNo());
			service.retrieve("sys.Sys05_Role.selectByUsrNo");
		}
		else {
			roleGrid.getStore().clear();
		}
	}

	@Override 
	public void retrieve() {
		GridRetrieveData<Sys02_UsrInfoModel> service = new GridRetrieveData<Sys02_UsrInfoModel>(this.usrGrid.getStore());
		service.addParam("cmpCode", LoginUser.getCmpCode());
		service.addParam("dptName", dptName.getDptName());
		service.addParam("usrName", usrName.getText());  
		service.retrieve("sys.Sys02_UsrInfo.selectByUsrName");
		roleGrid.getStore().clear();
	}

	@Override
	public void update() {
		GridUpdate<Sys05_RoleModel> service = new GridUpdate<Sys05_RoleModel>();
		service.addParam("insertUsrNo", usrGrid.getSelectionModel().getSelectedItem().getUsrNo());
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(roleGrid.getStore(), "sys.Sys05_Role.updateUsrRole");  
	}

	@Override
	public void insertRow() {
	}

	@Override
	public void deleteRow() {
	}
}
