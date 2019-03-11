package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.field.LookupTriggerField;
import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridDeleteData;
import myApp.client.service.GridInsertRow;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.GridUpdate;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModelProperties;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;

public class Sys02_Tab_UsrInfo extends BorderLayoutContainer implements InterfaceGridOperate {
	
	private Grid<Sys02_UsrInfoModel> grid = this.buildGrid();
	private TextField searchText = new TextField();
	private LookupTriggerField dptName = new LookupTriggerField();
	private TextField usrName = new TextField();
	
	public Sys02_Tab_UsrInfo() {
		
		SearchBarBuilder searchBarBuilder = new SearchBarBuilder(this);
		searchBarBuilder.addLookupTriggerField(dptName, "부서", 300,40);
		dptName.addTriggerClickHandler(new TriggerClickHandler() {
			
			@Override
			public void onTriggerClick(TriggerClickEvent event) {
			openLookupDptInfo();	
			}
		});
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
	
	protected void openLookupDptInfo() {
		Sys08_Lookup_DptInfo lookupDpt = new Sys08_Lookup_DptInfo();
		lookupDpt.open(new InterfaceCallbackResult() {
			
			@Override
			public void execute(Object result) {
				Sys08_DptInfoModel data = (Sys08_DptInfoModel) result;
				dptName.setText(data.getDptName());
			}
		});
	}

	private Grid<Sys02_UsrInfoModel> buildGrid(){
		Sys02_UsrInfoModelProperties properties = GWT.create(Sys02_UsrInfoModelProperties.class);
		GridBuilder<Sys02_UsrInfoModel> gridBuilder = new GridBuilder<Sys02_UsrInfoModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.usrNo(), 100, "사번", new TextField());
		gridBuilder.addText(properties.usrName(), 250, "사원명", new TextField());
		gridBuilder.addText(properties.dptCode(), 250, "부서", new TextField());
		gridBuilder.addText(properties.telNo(), 250, "연락처", new TextField());
		gridBuilder.addText(properties.email(), 250, "Email", new TextField());
		gridBuilder.addText(properties.useYn(), 250, "사용여부", new TextField());
		ActionCell<String> tmpPwdUpdButton = new ActionCell<String>("변경하기", new ActionCell.Delegate<String>() {

			@Override
			public void execute(String object) {
				Sys02_UsrInfoModel userInfoModel = grid.getSelectionModel().getSelectedItem();
				Sys02_Lookup_userPw pwUpd = new Sys02_Lookup_userPw();
				pwUpd.open(userInfoModel.getTmpPwd(), userInfoModel.getUsrInfoId(), new InterfaceCallbackResult() {
					
					@Override
					public void execute(Object result) {
						retrieve();
					}
				});
			}
		});
		
		gridBuilder.addCell(properties.tmpPwd(), 150, "임시비밀번호", tmpPwdUpdButton);
		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Sys02_UsrInfoModel> service = new GridRetrieveData<Sys02_UsrInfoModel>(grid.getStore()); 
		service.addParam("cmpCode", LoginUser.getCmpCode());
		String dptName = searchText.getText().replaceAll(" ", "");
		if(dptName == null) {
			dptName = "%";
		} else {
			dptName = "%" + dptName + "%";
		}
		service.addParam("dptName", dptName);
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
		GridDeleteData<Sys02_UsrInfoModel> service = new GridDeleteData<Sys02_UsrInfoModel>();
		List<Sys02_UsrInfoModel> checkedList = grid.getSelectionModel().getSelectedItems() ; 
		service.delete(grid.getStore(), checkedList, "sys.Sys02_UsrInfo.delete");
	}
}