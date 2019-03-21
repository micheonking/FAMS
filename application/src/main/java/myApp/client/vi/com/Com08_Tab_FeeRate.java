package myApp.client.vi.com;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.grid.ComboBoxField;
import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.model.Com08_FeeRtModel;
import myApp.client.vi.com.model.Com08_FeeRtModelProperties;

public class Com08_Tab_FeeRate extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com08_FeeRtModel> grid = this.buildGrid();
	private TextField trCodeNameField = new TextField();
	private ComboBoxField feeRateCombo = new ComboBoxField("");
	
	public Com08_Tab_FeeRate() {
		
//		LabelToolItem code = new LabelToolItem("수수료율 관리");
//		code.setWidth(60);
//		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addComboBox(feeRateCombo,"수수료 구분",300,100);
		feeRateCombo.setValue("전체");
//		searchBarBuilder.getSearchBar().add(code);
		searchBarBuilder.addTextField(trCodeNameField, "매매처 ", 300, 60, true);
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
	
	private Grid<Com08_FeeRtModel> buildGrid(){
		Com08_FeeRtModelProperties properties = GWT.create(Com08_FeeRtModelProperties.class);
		GridBuilder<Com08_FeeRtModel> gridBuilder = new GridBuilder<Com08_FeeRtModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.cmpCode(), 150, "회사코드", new TextField());
		gridBuilder.addText(properties.trCoCode(), 150, "매매처코드", new TextField());
		gridBuilder.addText(properties.sttAmt(), 200, "시작금액", new TextField());
		gridBuilder.addText(properties.endAmt(), 200, "종료금액", new TextField());
		gridBuilder.addText(properties.feeCode(), 150, "수수료코드", new TextField());
		gridBuilder.addText(properties.feeRt(), 200, "수수료율", new TextField());
		gridBuilder.addText(properties.addAmt(), 200, "가산금액", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 70, "말소여부");
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com08_FeeRtModel> service = new GridRetrieveData<Com08_FeeRtModel>(grid.getStore()); 
		service.addParam("searText", trCodeNameField.getText());
		service.retrieve("com.Com08_FeeRate.selectBySearText");
	}

	@Override
	public void update(){
		GridUpdate<Com08_FeeRtModel> service = new GridUpdate<Com08_FeeRtModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com08_FeeRate.update"); 
	}
	
	@Override
	public void insertRow(){
		Com08_FeeRtModel insertModel = new Com08_FeeRtModel();
		GridInsertRow<Com08_FeeRtModel> service = new GridInsertRow<Com08_FeeRtModel>();
		service.insertRow(grid, insertModel);
	}

	@Override
	public void deleteRow(){
		final ConfirmMessageBox msgBox = new ConfirmMessageBox("삭제확인", "선택한 정보를 삭제하시겠습니까?");
		msgBox.addDialogHideHandler(new DialogHideHandler() {
			@Override
			public void onDialogHide(DialogHideEvent event) {
				switch (event.getHideButton()) {
				case YES:
		GridDeleteData<Com08_FeeRtModel> service = new GridDeleteData<Com08_FeeRtModel>();
		List<Com08_FeeRtModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com08_FeeRate.delete");
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