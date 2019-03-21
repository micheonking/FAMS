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
import myApp.client.vi.com.model.Com09_TaxRtModel;
import myApp.client.vi.com.model.Com09_TaxRtModelProperties;

public class Com10_TaxSys extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com09_TaxRtModel> grid = this.buildGrid();
	private ComboBoxField taxRtCombo = new ComboBoxField("");
	
	public Com10_TaxSys() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addComboBox(taxRtCombo,"세 제",200,100);
		taxRtCombo.setValue("전체");
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
	
	private Grid<Com09_TaxRtModel> buildGrid(){
		Com09_TaxRtModelProperties properties = GWT.create(Com09_TaxRtModelProperties.class);
		GridBuilder<Com09_TaxRtModel> gridBuilder = new GridBuilder<Com09_TaxRtModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.taxRtTypeCode(), 150, "세율구분", new TextField());
		gridBuilder.addText(properties.apySdd(), 150, "적응 초일", new TextField());
		gridBuilder.addText(properties.apyEdd(), 200, "적용 말일", new TextField());
		gridBuilder.addText(properties.apyTaxRt(), 200, "세율(%)", new TextField());
		gridBuilder.addText(properties.raxApyPosTypeCode(), 150, "적용 구분", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 200, "활성화 구분");
		gridBuilder.addDate(properties.insDate(), 200, "적용", new TextField());
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com09_TaxRtModel> service = new GridRetrieveData<Com09_TaxRtModel>(grid.getStore()); 
//		service.addParam("searText", trCodeNameField.getText());
		service.retrieve("com.Com09_TaxRate.selectBySearText");
	}

	@Override
	public void update(){
		GridUpdate<Com09_TaxRtModel> service = new GridUpdate<Com09_TaxRtModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com09_TaxRate.update"); 
	}
	
	@Override
	public void insertRow(){
		Com09_TaxRtModel insertModel = new Com09_TaxRtModel();
		GridInsertRow<Com09_TaxRtModel> service = new GridInsertRow<Com09_TaxRtModel>();
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
		GridDeleteData<Com09_TaxRtModel> service = new GridDeleteData<Com09_TaxRtModel>();
		List<Com09_TaxRtModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com09_TaxRate.delete");
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