package myApp.client.vi.sys;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

import myApp.client.grid.GridBuilder;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.service.TreeGridUpdate;
import myApp.client.utils.GridDataModel;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys04_CmpMenuModel;
import myApp.client.vi.sys.model.Sys04_CmpMenuModelProperties;

public class Sys06_Tree_RoleMenu extends ContentPanel implements InterfaceServiceCall {
	
	private TreeGrid<Sys04_CmpMenuModel> treeGrid = this.buildTreeGrid();
	private Long roleId;

	public Sys06_Tree_RoleMenu(){

		this.setHeaderVisible(false);
		this.add(this.treeGrid);
		
		TextButton retrieveButton = new TextButton("조회");
		retrieveButton.setWidth(60);
		retrieveButton.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				retrieve(); 
			}
		}); 
		this.getButtonBar().add(retrieveButton);
		
		TextButton expandAll = new TextButton("펼치기"); 
		expandAll.setWidth(80);
		expandAll.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				treeGrid.expandAll();
			}
		}); 
		this.getButtonBar().add(expandAll);
		
		TextButton collapseAll = new TextButton("감추기");
		collapseAll.setWidth(80);
		collapseAll.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				treeGrid.collapseAll();
			}
		}); 
		this.getButtonBar().add(collapseAll);
		
		TextButton updateButton = new TextButton("저장");
		updateButton.setWidth(60);
		updateButton.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				update();  
			}
		}); 
		this.getButtonBar().add(updateButton);
		this.setButtonAlign(BoxLayoutPack.CENTER);
	}

	public TreeGrid<Sys04_CmpMenuModel> buildTreeGrid(){
		
		Sys04_CmpMenuModelProperties properties = GWT.create(Sys04_CmpMenuModelProperties.class);
		final GridBuilder<Sys04_CmpMenuModel> gridBuilder = new GridBuilder<Sys04_CmpMenuModel>(properties.keyId());  

		gridBuilder.addText(properties.menuName(), 300, "메뉴명");
		gridBuilder.addBoolean(properties.roleMenuYnFlag(), 40, "권한");
		gridBuilder.addLong(properties.seq(), 80, "조회순서");
		gridBuilder.addText(properties.rmk(),450, "상세설명");

		return gridBuilder.getTreeGrid(1);  
	}

	public void retrieve() {
		if(this.roleId != null) {
			retrieve(this.roleId);
		}
	}

	public void retrieve(Long roleId) {
		this.roleId = roleId;
		
		// 서버에서 전체 트리를 한번에 가져온다.  
		ServiceRequest request = new ServiceRequest("sys.Sys04_CmpMenu.selectByRoleId");
		request.putStringParam("cmpCode", LoginUser.getCmpCode());
		request.putLongParam("roleId", roleId);
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	private void setChildItem(Sys04_CmpMenuModel parentMenu) {
		if(parentMenu.getChildList() != null){
			List<GridDataModel> childList = parentMenu.getChildList();
			for(GridDataModel dataModel : childList){
				Sys04_CmpMenuModel childMenu = (Sys04_CmpMenuModel)dataModel;
				this.treeGrid.getTreeStore().add(parentMenu, childMenu);
				this.setChildItem(childMenu);
			}
		}
	}
	
	private void update() {
		TreeGridUpdate<Sys04_CmpMenuModel> service = new TreeGridUpdate<Sys04_CmpMenuModel>();
		service.addParam("usrNo", LoginUser.getUsrNo());
		service.addParam("roleId", this.roleId);
		service.update(treeGrid.getTreeStore(), "sys.Sys04_CmpMenu.updateRoleMenu", new InterfaceCallbackResult() {
			@Override
			public void execute(Object result) {
				@SuppressWarnings("unchecked")
				List<GridDataModel> list = (List<GridDataModel>)result; 
				for(GridDataModel data : list) {
					Sys04_CmpMenuModel updateData = (Sys04_CmpMenuModel)data;
					
					/* TreeGrid의 자기 아이템을 찾아서 다시 넣는다. 
					 * 이유는 알수 없다. 
					 * 안그러면 expand 안되는 오류가 발생함. 
					 */
					
					treeGrid.getTreeStore().update(treeGrid.getTreeStore().findModel(updateData));
				}
			}
		});
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if(result.getStatus() < 0){
			Info.display("error", result.getMessage());
		}
		else { 
			this.treeGrid.getTreeStore().clear(); // 깨끗이 비운다. 
			
			for (GridDataModel model: result.getResult()) {
				// 서버에서 전체 트리를 한번에 가져온 후 트리를 구성한다.  
				Sys04_CmpMenuModel roleObject = (Sys04_CmpMenuModel)model;
				this.treeGrid.getTreeStore().add(roleObject);
				this.setChildItem(roleObject); // child menu & object setting  
			}
		} 
	}
}
