package myApp.client.vi.sys;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys05_RoleModel;
import myApp.client.vi.sys.model.Sys05_RoleModelProperties;

public class Sys06_Tab_RoleMenu extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private TextField roleName = new TextField();	
	private Grid<Sys05_RoleModel> grid = this.buildGrid();
	private Sys06_Tree_RoleMenu tree = new Sys06_Tree_RoleMenu();
	
	public Sys06_Tab_RoleMenu() {

		//---------------------------------------------------------
		//	SearchBar SET
		//---------------------------------------------------------
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		roleName.setEmptyText("전체");
		searchBarBuilder.addTextField(roleName, "권한명", 250, 50, true); 
		searchBarBuilder.addRetrieveButton(); 
		
		BorderLayoutData northLayoutData = new BorderLayoutData(50); 
		northLayoutData.setMargins(new Margins(0,0,0,0));
		this.setNorthWidget(searchBarBuilder.getSearchBar(), northLayoutData); 

		//---------------------------------------------------------
		//	권한그룹 Grid SET
		//---------------------------------------------------------
		BorderLayoutData westLayoutData = new BorderLayoutData(0.4); 
		westLayoutData.setSplit(true);
		westLayoutData.setMargins(new Margins(0,2,0,0));
		westLayoutData.setMaxSize(1000);

		this.setWestWidget(this.grid, westLayoutData);
		this.grid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<Sys05_RoleModel>(){
			@Override
			public void onSelectionChanged(SelectionChangedEvent<Sys05_RoleModel> event) {
				Sys05_RoleModel role = grid.getSelectionModel().getSelectedItem();   
				tree.retrieve(role.getRoleId());
			}
		}); 
		
		//---------------------------------------------------------
		//	권한그룹별 메뉴 Tree SET
		//---------------------------------------------------------
		this.setCenterWidget(tree); 

		this.retrieve();
	}
	
	public Grid<Sys05_RoleModel> buildGrid(){
		Sys05_RoleModelProperties properties = GWT.create(Sys05_RoleModelProperties.class);	
		GridBuilder<Sys05_RoleModel> gridBuilder = new GridBuilder<Sys05_RoleModel>(properties.keyId());  
		
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.roleName(), 150, "권한명");
		gridBuilder.addLong(properties.seq(), 80, "순서");
		gridBuilder.addText(properties.rmk(), 300, "상세설명");

		return gridBuilder.getGrid(); 
	}
	
	@Override
	public void retrieve() {
		GridRetrieveData<Sys05_RoleModel> service = new GridRetrieveData<Sys05_RoleModel>(grid.getStore());
		String roleName = this.roleName.getText() ; 
		if(roleName == null) {
			roleName = "%" ;
		}
		roleName = "%" + roleName + "%";
		
		service.addParam("roleName", roleName);
		service.addParam("cmpCode", LoginUser.getCmpCode());
		service.retrieve("sys.Sys05_Role.selectByName");
	}

	@Override
	public void update() {
	}

	@Override
	public void insertRow() {
	}

	@Override
	public void deleteRow() {
	}
}