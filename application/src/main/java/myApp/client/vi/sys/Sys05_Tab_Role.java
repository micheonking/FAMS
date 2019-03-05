package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.LongField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys05_RoleModel;
import myApp.client.vi.sys.model.Sys05_RoleModelProperties;

public class Sys05_Tab_Role extends VerticalLayoutContainer implements InterfaceGridOperate {
	
	private TextField roleName = new TextField();
	private Grid<Sys05_RoleModel> grid = this.buildGrid();
	
	public Sys05_Tab_Role() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		roleName.setEmptyText("전체");
		searchBarBuilder.addTextField(roleName, "권한명", 300, 50, true);
		searchBarBuilder.addRetrieveButton(); 
		searchBarBuilder.addUpdateButton();
		searchBarBuilder.addInsertButton();
		searchBarBuilder.addDeleteButton();
		
		this.add(searchBarBuilder.getSearchBar()); 
		this.add(this.grid, new VerticalLayoutData(1, 1));

		this.retrieve();
	}
	
	public Grid<Sys05_RoleModel> buildGrid(){

		Sys05_RoleModelProperties properties = GWT.create(Sys05_RoleModelProperties.class);

		GridBuilder<Sys05_RoleModel> gridBuilder = new GridBuilder<Sys05_RoleModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.roleName(), 150, "권한명", new TextField());
		gridBuilder.addLong(properties.seq(), 70, "조회순서", new LongField()) ;
		gridBuilder.addText(properties.rmk(), 800, "권한설명", new TextField());
	
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
		GridUpdate<Sys05_RoleModel> service = new GridUpdate<Sys05_RoleModel>(); 
		service.update(grid.getStore(), "sys.Sys05_Role.update"); 
	}

	@Override
	public void insertRow() {
		Sys05_RoleModel insertModel = new Sys05_RoleModel();
		insertModel.setCmpCode(LoginUser.getCmpCode());
		GridInsertRow<Sys05_RoleModel> service = new GridInsertRow<Sys05_RoleModel>();
		service.insertRow(grid, insertModel);
	}

	@Override
	public void deleteRow() {
		GridDeleteData<Sys05_RoleModel> service = new GridDeleteData<Sys05_RoleModel>();
		List<Sys05_RoleModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "sys.Sys05_Role.delete");
	}
}