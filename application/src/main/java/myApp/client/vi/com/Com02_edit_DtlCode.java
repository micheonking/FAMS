package myApp.client.vi.com;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
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
import myApp.client.vi.com.model.Com01_ComCdModel;
import myApp.client.vi.com.model.Com02_DtlCdModel;
import myApp.client.vi.com.model.Com02_DtlCdModelProperties;

public class Com02_edit_DtlCode extends VerticalLayoutContainer implements InterfaceGridOperate {
	private String comCode;
	private Grid<Com02_DtlCdModel> grid = this.buildGrid();
	private TextButton updateButton, insertButton, deleteButton;
	
	public Com02_edit_DtlCode() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addRetrieveButton(); 
		this.updateButton = searchBarBuilder.addUpdateButton();
		this.insertButton = searchBarBuilder.addInsertButton();
		this.deleteButton = searchBarBuilder.addDeleteButton();
		
		this.add(searchBarBuilder.getSearchBar(), new VerticalLayoutData(1, 50));
		this.add(this.grid, new VerticalLayoutData(1, 1));
		
	}
	
	private Grid<Com02_DtlCdModel> buildGrid(){
		Com02_DtlCdModelProperties properties = GWT.create(Com02_DtlCdModelProperties.class);
		GridBuilder<Com02_DtlCdModel> gridBuilder = new GridBuilder<Com02_DtlCdModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.comDtlCode(), 100, "상세코드", new TextField());
		gridBuilder.addText(properties.dtlName(), 200, "상세 코드명", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 150, "사용여부");
		gridBuilder.addText(properties.rmk(), 250, "비고", new TextField());
		return gridBuilder.getGrid(); 
	}
	
	public void retrieveCode(Com01_ComCdModel dtlCode){
			this.comCode = dtlCode.getComCode();
			this.retrieve();
	}
	
	@Override
	public void retrieve() {
		grid.getStore().clear();
		GridRetrieveData<Com02_DtlCdModel> service = new GridRetrieveData<Com02_DtlCdModel>(grid.getStore()); 
		service.addParam("comCode", this.comCode);
		service.retrieve("com.Com02_DtlCode.selectByComCode");
	}

	@Override
	public void update(){
		GridUpdate<Com02_DtlCdModel> service = new GridUpdate<Com02_DtlCdModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com02_DtlCode.update"); 
	}
	
	@Override
	public void insertRow(){
		// 초기값 설정. 
		GridInsertRow<Com02_DtlCdModel> service = new GridInsertRow<Com02_DtlCdModel>();
		Com02_DtlCdModel dtlCodeModel = new Com02_DtlCdModel();
		dtlCodeModel.setComCode(this.comCode);
		service.insertRow(grid, dtlCodeModel);
		
	}

	@Override
	public void deleteRow(){
		GridDeleteData<Com02_DtlCdModel> service = new GridDeleteData<Com02_DtlCdModel>();
		List<Com02_DtlCdModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com02_DtlCode.delete");
	}
}