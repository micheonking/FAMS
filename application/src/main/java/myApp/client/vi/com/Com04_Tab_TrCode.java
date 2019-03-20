package myApp.client.vi.com;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.ComboBoxField;
import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.model.Com04_TrCodeModel;
import myApp.client.vi.com.model.Com04_TrCodeModelProperties;

public class Com04_Tab_TrCode extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com04_TrCodeModel> grid = this.buildGrid();
	private TextField trNameField = new TextField();
	private ComboBoxField trOccTypeComboBox = new ComboBoxField("TR_OCC_TYP_CD");
	
	public Com04_Tab_TrCode() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addTextField(trNameField, "거래코드명 ", 300, 80, true);
		searchBarBuilder.addComboBox (trOccTypeComboBox, "거래 발생 구분", 200, 100      );
		trOccTypeComboBox.setValue("전체");
		searchBarBuilder.addRetrieveButton();
		searchBarBuilder.addUpdateButton();
		searchBarBuilder.addInsertButton();
		searchBarBuilder.addDeleteButton();
		
		BorderLayoutData northLayoutData = new BorderLayoutData(50);
		northLayoutData.setMargins(new Margins(0, 4, 0, 0)); 
		this.setNorthWidget(searchBarBuilder.getSearchBar(), northLayoutData); 
		this.setCenterWidget(grid);
		this.retrieve();
	}
	
	private Grid<Com04_TrCodeModel> buildGrid(){
		Com04_TrCodeModelProperties properties = GWT.create(Com04_TrCodeModelProperties.class);
		GridBuilder<Com04_TrCodeModel> gridBuilder = new GridBuilder<Com04_TrCodeModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.trCode(), 150, "거래코드", new TextField());
		gridBuilder.addText(properties.trName(), 200, "거래코드명", new TextField());
		
		ComboBoxField trOccTypeComboBox = new ComboBoxField("TR_OCC_TYP_CD");
		trOccTypeComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTrOccTypeCode(trOccTypeComboBox.getCode());
				grid.getView().refresh(true);
				
			}
		});
		gridBuilder.addText(properties.trOccTypeCode(),150, "거래발생구분", trOccTypeComboBox);
		gridBuilder.addText(properties.seq(), 150, "조회순서",new TextField());
		gridBuilder.addBoolean(properties.applProcYnFlag(), 150, "승인여부");
		gridBuilder.addBoolean(properties.accSndYnFlag(),150, "회계전송여부");
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com04_TrCodeModel> service = new GridRetrieveData<Com04_TrCodeModel>(grid.getStore()); 
		service.addParam("searText", trNameField.getText());
		service.retrieve("com.Com04_TrCode.selectBySearText");
	}

	@Override
	public void update(){
		GridUpdate<Com04_TrCodeModel> service = new GridUpdate<Com04_TrCodeModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com04_TrCode.update"); 
	}
	
	@Override
	public void insertRow(){
		Com04_TrCodeModel insertModel = new Com04_TrCodeModel();
		GridInsertRow<Com04_TrCodeModel> service = new GridInsertRow<Com04_TrCodeModel>();
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
		GridDeleteData<Com04_TrCodeModel> service = new GridDeleteData<Com04_TrCodeModel>();
		List<Com04_TrCodeModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com04_TrCode.delete");
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