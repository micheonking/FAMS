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
import com.sencha.gxt.widget.core.client.info.Info;
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

public class Com09_Tab_TaxRate extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com09_TaxRtModel> grid = this.buildGrid();
	private ComboBoxField taxRtCombo = new ComboBoxField("TAX_RT_TYP_CD",null," ");
	ComboBoxField taxRtTypeCodeComboBox = new ComboBoxField("TAX_RT_TYP_CD");
	ComboBoxField taxRtApyTypeCodeComboBox = new ComboBoxField("TAX_RT_APY_TYP_CD");
	ComboBoxField taxRtApyPosTypeCodeComboBox = new ComboBoxField("TAX_RT_APY_POS_TYP_CD");
	ComboBoxField whCoTypeCodeComboBox = new ComboBoxField("WH_CO_TYP_CD");
	
	public Com09_Tab_TaxRate() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addComboBox(taxRtCombo,"세 율",300,60);
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
		ComboBoxField taxRtTypeCodeComboBox = new ComboBoxField("TAX_RT_TYP_CD");
		taxRtTypeCodeComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTaxRtTypeCode(taxRtTypeCodeComboBox.getCode());
				grid.getView().refresh(true);
			}
		});
		gridBuilder.addText(properties.taxRtTypeName(), 200, "세율구분", taxRtTypeCodeComboBox);
		gridBuilder.addText(properties.taxRtTypeCode(), 100, "세율구분코드");
		gridBuilder.addText(properties.apySdd(), 130, "적응 초일", new TextField());
		gridBuilder.addText(properties.apyEdd(), 130, "적용 말일", new TextField());
		gridBuilder.addText(properties.apyTaxRt(), 100, "세율(%)", new TextField());
		ComboBoxField taxRtApyTypeCodeComboBox = new ComboBoxField("TAX_RT_APY_TYP_CD");
		taxRtApyTypeCodeComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTaxRtApyTypeCode(taxRtApyTypeCodeComboBox.getCode());
				grid.getView().refresh(true);
			}
		});
		gridBuilder.addText(properties.taxRtApyTypeName(), 200, "적용구분",taxRtApyTypeCodeComboBox);
		ComboBoxField taxRtApyPosTypeCodeComboBox = new ComboBoxField("TAX_RT_APY_POS_TYP_CD");
		taxRtApyPosTypeCodeComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTaxRtApyPosTypeCode(taxRtApyPosTypeCodeComboBox.getCode());
				grid.getView().refresh(true);
			}
		});
		gridBuilder.addText(properties.taxRtApyPosTypeName(), 200, "세율적용시점구분",taxRtApyPosTypeCodeComboBox);
		ComboBoxField whCoTypeCodeComboBox = new ComboBoxField("WH_CO_TYP_CD");
		whCoTypeCodeComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setWhCoTypeCode(whCoTypeCodeComboBox.getCode());
				grid.getView().refresh(true);
			}
		});
		gridBuilder.addText(properties.whCoTypeName(), 170, "원천징수처 구분",whCoTypeCodeComboBox);
		gridBuilder.addBoolean(properties.useYnFlag(), 70, "사용여부");
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com09_TaxRtModel> service = new GridRetrieveData<Com09_TaxRtModel>(grid.getStore()); 
		service.addParam("taxRtTypeCode"	 	, taxRtTypeCodeComboBox.getCode());
		service.addParam("taxRtApyTypeCode"	 	, taxRtApyTypeCodeComboBox.getCode());
		service.addParam("taxRtApyPosTypeCode"	, taxRtApyPosTypeCodeComboBox.getCode());
		service.addParam("whCoTypeCode"		    , whCoTypeCodeComboBox.getCode());
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
		Info.display("taxRtTypeCodeComboBox",""+insertModel.getTaxRtTypeCode());
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