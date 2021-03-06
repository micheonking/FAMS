package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.field.LookupTriggerField;
import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.Com00_DptLookupField;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModelProperties;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;

public class Sys02_Tab_UsrInfo extends BorderLayoutContainer implements InterfaceGridOperate {

	private  Sys02_UsrInfoModelProperties properties = GWT.create(Sys02_UsrInfoModelProperties.class);
	private Grid<Sys02_UsrInfoModel> grid = this.buildGrid();
	private Com00_DptLookupField dptName;
	private TextField usrName = new TextField();

	public Sys02_Tab_UsrInfo() {

		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		dptName = new Com00_DptLookupField(200, true, new InterfaceCallbackResult2() {
			@Override
			public void execute(Object result) {
			}
			@Override
			public void enterKeyDown() {
				retrieve();
			}
			@Override
			public void onCollapse() {
			}
		});
		searchBarBuilder.getSearchBar().add(dptName);
		searchBarBuilder.addTextField(usrName, "사원검색", 200, 60, true);
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

	private Grid<Sys02_UsrInfoModel> buildGrid(){
		GridBuilder<Sys02_UsrInfoModel> gridBuilder = new GridBuilder<Sys02_UsrInfoModel>(properties.keyId());
		gridBuilder.setChecked(SelectionMode.SINGLE);
		
		LookupTriggerField dptName = new LookupTriggerField();
			dptName.addTriggerClickHandler(new TriggerClickHandler(){
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
				openLookupDptInfoGrid();
			}
		}); 
		gridBuilder.addText(properties.usrNo(), 100, "사번");
		gridBuilder.addText(properties.usrName(), 150, "사원명", new TextField());
		gridBuilder.addText(properties.dptName(), 150, "부서", dptName);
		gridBuilder.addText(properties.telNo(), 150, "연락처", new TextField());
		gridBuilder.addText(properties.email(), 150, "Email", new TextField());
		gridBuilder.addBoolean(properties.useYnFlag(), 70, "사용여부");
		ActionCell<String> tmpPwdUpdButton = new ActionCell<String>("변경하기", new ActionCell.Delegate<String>() {
			@Override
			public void execute(String object) {
				Sys02_UsrInfoModel userInfoModel = grid.getSelectionModel().getSelectedItem();
				Sys02_Lookup_UsrPwChg pwUpd = new Sys02_Lookup_UsrPwChg();
				pwUpd.open(userInfoModel.getTmpPwd(), userInfoModel.getUsrInfoId(), new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						retrieve();
					}
				});
			}
		});
		
		gridBuilder.addCell(properties.tmpPwd(), 100, "임시비밀번호", tmpPwdUpdButton);
		return gridBuilder.getGrid(); 
	}
	
	protected void openLookupDptInfoGrid() {
		Sys08_Lookup_DptInfo lookupDpt = new Sys08_Lookup_DptInfo();
		lookupDpt.open(new InterfaceCallbackResult() {
			@Override
			public void execute(Object result) {
				Sys08_DptInfoModel data = (Sys08_DptInfoModel) result;
				Sys02_UsrInfoModel usrInfoModel = grid.getSelectionModel().getSelectedItem();
				grid.getStore().getRecord(usrInfoModel).addChange(properties.dptCode(), data.getDptCode());
				grid.getStore().getRecord(usrInfoModel).addChange(properties.dptName(), data.getDptName());
			}
		});		
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Sys02_UsrInfoModel> service = new GridRetrieveData<Sys02_UsrInfoModel>(grid.getStore()); 
		service.addParam("cmpCode", LoginUser.getCmpCode());
		service.addParam("dptName", dptName.getDptName());
		service.addParam("usrName",usrName.getText());
		service.retrieve("sys.Sys02_UsrInfo.selectByUsrName");
	}

	@Override
	public void update(){
		GridUpdate<Sys02_UsrInfoModel> service = new GridUpdate<Sys02_UsrInfoModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.update(grid.getStore(), "sys.Sys02_UsrInfo.update"); 
	}
	
	@Override
	public void insertRow(){
		Sys02_UsrInfoModel insertModel = new Sys02_UsrInfoModel();
		insertModel.setCmpCode(LoginUser.getCmpCode());
		GridInsertRow<Sys02_UsrInfoModel> service = new GridInsertRow<Sys02_UsrInfoModel>(); 
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
					GridDeleteData<Sys02_UsrInfoModel> service = new GridDeleteData<Sys02_UsrInfoModel>();
					List<Sys02_UsrInfoModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
					service.delete(grid.getStore(), checkedList, "sys.Sys02_UsrInfo.delete");
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