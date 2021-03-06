package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

import myApp.client.grid.CommonComboBoxField;
import myApp.client.grid.GridBuilder;
import myApp.client.service.DBUtil;
import myApp.client.service.GridDeleteData;
import myApp.client.service.InterfaceCallback;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys04_CmpMenuModel;
import myApp.client.vi.sys.model.Sys04_CmpMenuModelProperties;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;

public class Sys04_Tree_CmpMenu extends VerticalLayoutContainer implements InterfaceServiceCall {
	
	private TreeGrid<Sys04_CmpMenuModel> treeGrid = this.buildTreeGrid();
	private String actionName;
	
	CommonComboBoxField cmpComboBox;

	public Sys04_Tree_CmpMenu(){

		ButtonBar buttonBar = new ButtonBar();
		
		cmpComboBox = new CommonComboBoxField("sys.Sys00_Common.selectCmpCombo", new InterfaceCallback() {
			@Override
			public void execute() {
				retrieve();
			}
		});
		cmpComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				retrieve();				
			}
		});
		FieldLabel cmpField = new FieldLabel(cmpComboBox, "회사선택 ");
		cmpField.setWidth(300);
		cmpField.setLabelWidth(70);
		buttonBar.add(cmpField);
		
		TextButton retrieveButton = new TextButton("메뉴 조회");
		retrieveButton.setWidth(90);
		retrieveButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				retrieve();
			}
		});
		buttonBar.add(retrieveButton);
		
		TextButton createInitButton = new TextButton("메뉴초기화");
		createInitButton.setWidth(120);
		createInitButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				final ConfirmMessageBox msgBox = new ConfirmMessageBox("확인", "메뉴초기화시 메뉴 및 메뉴권한그룹, 부서정보, 사용자정보등이 삭제됩니다. 초기화하시겠습니까?");
				msgBox.addDialogHideHandler(new DialogHideHandler() {
					@Override
					public void onDialogHide(DialogHideEvent event) {
						switch (event.getHideButton()) {
						case YES:
							insertInitMenu();
						case NO:
						default:
							break;
						}
					}
				});
				msgBox.setWidth(300);
				msgBox.show();
			}
		});
		buttonBar.add(createInitButton);

		TextButton createRootButton = new TextButton("루트메뉴 등록");
		createRootButton.setWidth(120);
		createRootButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				// root menu는 parentId가 0 이다. 
				insertMenu(Long.parseLong("0"));
			}
		});
		buttonBar.add(createRootButton);

		TextButton createSubButton = new TextButton("하위메뉴 등록");
		createSubButton.setWidth(120);
		createSubButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				insertSubMenu();
			}
		});
		buttonBar.add(createSubButton);
		this.add(buttonBar, new VerticalLayoutData(1, 50));
		
		treeGrid.getTreeStore().setAutoCommit(true);
		this.add(treeGrid, new VerticalLayoutData(1,1));
	}

	private TreeGrid<Sys04_CmpMenuModel> buildTreeGrid() {

		Sys04_CmpMenuModelProperties properties = GWT.create(Sys04_CmpMenuModelProperties.class);
		final GridBuilder<Sys04_CmpMenuModel> gridBuilder = new GridBuilder<Sys04_CmpMenuModel>(properties.keyId());
		
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.menuName(), 250, "메뉴명");

		ActionCell<String> editCell = new ActionCell<String>("Edit", new ActionCell.Delegate<String>() {
			@Override
			public void execute(String arg0) {
				Sys04_CmpMenuModel cmpMenuModel = treeGrid.getSelectionModel().getSelectedItem();
				editMenu(cmpMenuModel);
			}
		});
		gridBuilder.addCell(properties.editCell(), 60, "수정", editCell);

		ActionCell<String> moveCell = new ActionCell<String>("Move", new ActionCell.Delegate<String>() {
			@Override
			public void execute(String arg0) {
				moveMenu();
			}
		});
		gridBuilder.addCell(properties.moveCell(), 60, "이동", moveCell);

		gridBuilder.addText(properties.seqStr(), 60, "순서");
		gridBuilder.addBoolean(properties.useYnFlag(), 40, "사용");
		gridBuilder.addText(properties.className(), 200, "클래스명");
		gridBuilder.addText(properties.rmk(), 200, "비고");
		
		return gridBuilder.getTreeGrid(2);
	}

	protected void insertInitMenu() {
		actionName = "insertInitMenu";
		ServiceRequest request = new ServiceRequest("sys.Sys04_CmpMenu.insertInitMenu");
		request.addParam("cmpCode", cmpComboBox.getCode());
		request.addParam("usrNo", LoginUser.getUsrNo());
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	protected void moveMenu() {
		Sys04_Lookup_MoveMenu moveMenu = new Sys04_Lookup_MoveMenu();
		moveMenu.open(treeGrid, treeGrid.getSelectionModel().getSelectedItem());
	}

	protected void editMenu(Sys04_CmpMenuModel menuModel) {
		Sys04_Lookup_EditMenu editMenu = new Sys04_Lookup_EditMenu();
		editMenu.open(treeGrid, menuModel);
	}

	protected void retrieve() {
		actionName = "retrieve";
		ServiceRequest request = new ServiceRequest("sys.Sys04_CmpMenu.selectByCmpCode");
		request.addParam("cmpCode", cmpComboBox.getCode());
		request.addParam("prntId", Long.parseLong("0"));
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	protected void insertMenu(long parentId) {
		Sys04_CmpMenuModel cmpMenuModel = new Sys04_CmpMenuModel();
		DBUtil dbUtil = new DBUtil();
		dbUtil.setSeq(cmpMenuModel, new InterfaceCallback() {
			@Override
			public void execute() {
				cmpMenuModel.setPrntId(parentId);
				cmpMenuModel.setCmpCode(cmpComboBox.getCode());
				cmpMenuModel.setUseYn("Y");
				editMenu(cmpMenuModel);
			}
		});
	}

	protected void insertSubMenu() {
		Sys04_CmpMenuModel prntModel = treeGrid.getSelectionModel().getSelectedItem();
		if(prntModel == null) {
			new SimpleMessage("확인", "선택된 상위 메뉴가 없습니다. ");
			return;
		}
		
		if(prntModel.getMenuModel().getClassName() != null) {
			new SimpleMessage("확인", "오브젝트에는 하위 메뉴를 등록할 수 없습니다.", 400);
			return;
		}
		
		treeGrid.setExpanded(prntModel, true);
		insertMenu(prntModel.getCmpMenuId());
	}

	private void setSubMenuItem(Sys04_CmpMenuModel parentMenu) {
		if(parentMenu.getChildList() != null) {
			List<GridDataModel> subList = parentMenu.getChildList();
			for(GridDataModel sub : subList) {
				Sys04_CmpMenuModel subObject = (Sys04_CmpMenuModel) sub;
				treeGrid.getTreeStore().add(parentMenu, subObject);
				setSubMenuItem(subObject);
			}
		}
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if(result.getStatus() < 0) {
			new SimpleMessage("확인", result.getMessage(), 300);
		}
		else if ("insertInitMenu".equals(actionName)) {
			retrieve();
		}
		else {
			treeGrid.getTreeStore().clear();
			for(GridDataModel model : result.getResult()) {
				Sys04_CmpMenuModel object = (Sys04_CmpMenuModel)model;
				treeGrid.getTreeStore().add(object);
				setSubMenuItem(object);
			}
		}
	}

}
