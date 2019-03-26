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
import myApp.client.vi.com.model.Com10_TaxSysModel;
import myApp.client.vi.com.model.Com10_TaxSysModelProperties;

public class Com10_Tab_TaxSystem extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Com10_TaxSysModel> grid = this.buildGrid();
	private ComboBoxField taxSysCombo = new ComboBoxField("");
	ComboBoxField taxRtTypCdComboBox = new ComboBoxField("TAX_RT_TYP_CD"); //세율구분
	ComboBoxField taxSysTypCdComboBox = new ComboBoxField("TAX_SYS_TYP_CD"); //세제구분
	ComboBoxField trsRulApyTypCdComboBox = new ComboBoxField("TRS_RUL_APY_TYP_CD"); //결과규정 적용구분
	ComboBoxField trsRulTgtTypCdComboBox = new ComboBoxField("TRS_RUL_TGT_TYP_CD"); //결과규정 대상
	ComboBoxField trsRulXtncTypCdComboBox = new ComboBoxField("TRS_RUL_XTNC_TYP_CD"); //결과규정 소멸 구분
	
	
	public Com10_Tab_TaxSystem() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addComboBox(taxSysCombo,"세 제",300,100);
		taxSysCombo.setValue("전체");
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
	
	private Grid<Com10_TaxSysModel> buildGrid(){
		Com10_TaxSysModelProperties properties = GWT.create(Com10_TaxSysModelProperties.class);
		GridBuilder<Com10_TaxSysModel> gridBuilder = new GridBuilder<Com10_TaxSysModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		

		ComboBoxField taxSysTypCdComboBox  = new ComboBoxField("TAX_SYS_TYP_CD"); //세제구분 
		taxSysTypCdComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTaxSysTypeCode(taxSysTypCdComboBox.getCode());
				grid.getView().refresh(true );
			}
		});
		gridBuilder.addText(properties.taxRtTypeCodeName(), 200, "세제구분",taxSysTypCdComboBox );
		
		ComboBoxField taxRtTypCdComboBox  = new ComboBoxField("TAX_RT_TYP_CD"); //세율구분
		taxRtTypCdComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTaxRtTypeCode(taxRtTypCdComboBox.getCode());
				grid.getView().refresh(true );
			}
		});
		gridBuilder.addText(properties.taxSysTypeCodeName(), 150, "세율구분", taxRtTypCdComboBox);
		
		gridBuilder.addText(properties.appSdd(), 150, "적용 초일", new TextField());
		gridBuilder.addText(properties.apyEdd(), 200, "적용 말일", new TextField());
		
		
		ComboBoxField trsRulApyTypCdComboBox = new ComboBoxField("TRS_RUL_APY_TYP_CD"); //경과규정 적용구분
		trsRulApyTypCdComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTrsRulApyTypeCode(trsRulApyTypCdComboBox.getCode());
				grid.getView().refresh(true );
			}
		});
		gridBuilder.addText(properties.trsRulApyTypeCodeName(), 150, "경과규정 적용구분", trsRulApyTypCdComboBox);
		
		ComboBoxField trsRulTgtTypCdComboBox = new ComboBoxField("TRS_RUL_TGT_TYP_CD"); //경과규정 대상l
		trsRulTgtTypCdComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTrsRulTgtTypCode(trsRulTgtTypCdComboBox.getCode());
				grid.getView().refresh(true );
			}
		});
		gridBuilder.addText(properties.trsRulTgtTypCodeName(), 150, "결과규정 대상", trsRulTgtTypCdComboBox);
		
		ComboBoxField trsRulXtncTypCdComboBox   = new ComboBoxField("TRS_RUL_XTNC_TYP_CD"); //경과규정 소멸 구분
		trsRulXtncTypCdComboBox .addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				grid.getSelectionModel().getSelectedItem().setTrsRulXtncTypeCode(trsRulXtncTypCdComboBox .getCode());
				grid.getView().refresh(true );
			}
		});
		gridBuilder.addText(properties.trsRulXtncTypeCodeName(), 200, "경과규정 소멸 구분",trsRulXtncTypCdComboBox);
//		gridBuilder.addText(properties.trsRulApyTypeCode(), 200, "경과규정 소멸 구분2",new TextField());
		return gridBuilder.getGrid();  
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Com10_TaxSysModel> service = new GridRetrieveData<Com10_TaxSysModel>(grid.getStore());
		service.addParam("taxSysTypeCode "		, taxRtTypCdComboBox.getCode());
		service.addParam("taxRtTypeCode"	 	, taxSysTypCdComboBox.getCode());
		service.addParam("trsRulApyTypeCode"	, trsRulApyTypCdComboBox.getCode());
		service.addParam("trsRulTgtTypCode"		, trsRulTgtTypCdComboBox.getCode());
		service.addParam("trsRulXtncTypeCode"   , trsRulXtncTypCdComboBox.getCode());
		service.retrieve("com.Com10_TaxSys.selectBySearText");
	}

	@Override
	public void update(){
		GridUpdate<Com10_TaxSysModel> service = new GridUpdate<Com10_TaxSysModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "com.Com10_TaxSys.update"); 
	}
	
	@Override
	public void insertRow(){
		Com10_TaxSysModel insertModel = new Com10_TaxSysModel();
		GridInsertRow<Com10_TaxSysModel> service = new GridInsertRow<Com10_TaxSysModel>();
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
		GridDeleteData<Com10_TaxSysModel> service = new GridDeleteData<Com10_TaxSysModel>();
		List<Com10_TaxSysModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "com.Com10_TaxSys.delete");
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