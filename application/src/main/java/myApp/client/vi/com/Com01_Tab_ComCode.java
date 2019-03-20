package myApp.client.vi.com;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.model.Com01_ComCdModel;
import myApp.client.vi.com.model.Com01_ComCdModelProperties;

public class Com01_Tab_ComCode extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com01_ComCdModel> grid = this.buildGrid();
	private TextField codeNameField = new TextField();
	private Com02_Grid_DtlCode dtlCodeGrid = new Com02_Grid_DtlCode();
	
	public Com01_Tab_ComCode() {
		
		LabelToolItem code = new LabelToolItem("공통코드/공통코드명");
		code.setWidth(90);
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.getSearchBar().add(code);
		searchBarBuilder.addTextField(codeNameField, " ", 300, 60, true);
		searchBarBuilder.addRetrieveButton();
		searchBarBuilder.addUpdateButton();
		searchBarBuilder.addInsertButton();
		searchBarBuilder.addDeleteButton();
		
		VerticalLayoutContainer vlc = new VerticalLayoutContainer(); 
		vlc.add(searchBarBuilder.getSearchBar(), new VerticalLayoutData(1, 50));
		vlc.add(this.grid, new VerticalLayoutData(1, 1));
		
		BorderLayoutData westLayoutData = new BorderLayoutData(0.5);
		westLayoutData.setMargins(new Margins(0, 4, 0, 0)); 
		westLayoutData.setSplit(true);
		westLayoutData.setMaxSize(1000);  

		this.setWestWidget(vlc, westLayoutData);
		this.setCenterWidget(dtlCodeGrid);
		
		grid.addRowClickHandler(new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				Com01_ComCdModel dtlCode = grid.getSelectionModel().getSelectedItem();
				dtlCodeGrid.retrieveCode(dtlCode); //.getComCode());
			}
		});
		this.retrieve();
	}
	
	private Grid<Com01_ComCdModel> buildGrid(){
		Com01_ComCdModelProperties properties = GWT.create(Com01_ComCdModelProperties.class);
		GridBuilder<Com01_ComCdModel> gridBuilder = new GridBuilder<Com01_ComCdModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.comCode(), 150, "공통코드", new TextField());
		gridBuilder.addText(properties.comName(), 200, "공통코드명", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 70, "사용여부");
		gridBuilder.addText(properties.rmk(), 300, "비고", new TextField());
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com01_ComCdModel> service = new GridRetrieveData<Com01_ComCdModel>(grid.getStore()); 
		service.addParam("searText", codeNameField.getText());
		service.retrieve("com.Com01_ComCode.selectBySearText");
	}

	@Override
	public void update(){
		GridUpdate<Com01_ComCdModel> service = new GridUpdate<Com01_ComCdModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com01_ComCode.update"); 
	}
	
	@Override
	public void insertRow(){
		Com01_ComCdModel insertModel = new Com01_ComCdModel();
		GridInsertRow<Com01_ComCdModel> service = new GridInsertRow<Com01_ComCdModel>();
		service.insertRow(grid, insertModel);
	}

	@Override
	public void deleteRow(){
		final ConfirmMessageBox msgBox = new ConfirmMessageBox("삭제확인", "선택한 사원의 정보를삭제하시겠습니까?");
		msgBox.addDialogHideHandler(new DialogHideHandler() {
			@Override
			public void onDialogHide(DialogHideEvent event) {
				switch (event.getHideButton()) {
				case YES:
		GridDeleteData<Com01_ComCdModel> service = new GridDeleteData<Com01_ComCdModel>();
		List<Com01_ComCdModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com01_ComCode.delete");
					break;
				case NO:
				default:
					break;
				}
			}

		});
			msgBox.setWidth(300);
			msgBox.show();
	}
}