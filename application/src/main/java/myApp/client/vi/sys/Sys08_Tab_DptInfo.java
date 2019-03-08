package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
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
import myApp.client.vi.sys.model.Sys08_DptInfoModel;
import myApp.client.vi.sys.model.Sys08_DptInfoModelProperties;

public class Sys08_Tab_DptInfo extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Sys08_DptInfoModel> grid = this.buildGrid();
	private TextField searchText = new TextField();
	
	public Sys08_Tab_DptInfo() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addTextField(searchText, "부서 검색 ", 300, 80, true); 
		searchBarBuilder.addRetrieveButton();
		searchBarBuilder.addUpdateButton();
		searchBarBuilder.addInsertButton();
		searchBarBuilder.addDeleteButton();

		BorderLayoutData northLayoutData = new BorderLayoutData(50); 
		northLayoutData.setMargins(new Margins(0,0,0,0));
		this.setNorthWidget(searchBarBuilder.getSearchBar(), northLayoutData); 
		this.setCenterWidget(grid); 
		this.retrieve();
	}
	
	private Grid<Sys08_DptInfoModel> buildGrid(){
		Sys08_DptInfoModelProperties properties = GWT.create(Sys08_DptInfoModelProperties.class);
		GridBuilder<Sys08_DptInfoModel> gridBuilder = new GridBuilder<Sys08_DptInfoModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.dptCode(), 100, "부서코드", new TextField());
		gridBuilder.addText(properties.dptName(), 250, "부서명", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 50, "사용");
		gridBuilder.addText(properties.rmk(), 300, "비고", new TextField());
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Sys08_DptInfoModel> service = new GridRetrieveData<Sys08_DptInfoModel>(grid.getStore()); 
		service.addParam("cmpCode", LoginUser.getCmpCode());
		String dptName = searchText.getText().replaceAll(" ", "");
		if(dptName == null) {
			dptName = "%";
		} else {
			dptName = "%" + dptName + "%";
		}
		service.addParam("dptName", dptName);
		service.retrieve("sys.Sys08_DptInfo.selectByName");
	}

	@Override
	public void update(){
		GridUpdate<Sys08_DptInfoModel> service = new GridUpdate<Sys08_DptInfoModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "sys.Sys08_DptInfo.update"); 
	}
	
	@Override
	public void insertRow(){
		Sys08_DptInfoModel insertModel = new Sys08_DptInfoModel();
		insertModel.setCmpCode(LoginUser.getCmpCode());
		GridInsertRow<Sys08_DptInfoModel> service = new GridInsertRow<Sys08_DptInfoModel>(); 
		service.insertRow(grid, insertModel);
	}

	@Override
	public void deleteRow(){
		GridDeleteData<Sys08_DptInfoModel> service = new GridDeleteData<Sys08_DptInfoModel>();
		List<Sys08_DptInfoModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "sys.Sys08_DptInfo.delete");
	}
}