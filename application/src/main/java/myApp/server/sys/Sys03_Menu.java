package myApp.server.sys;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.sys.model.Sys03_MenuModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys03_Menu { 
	
	public void selectByAll(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		List<GridDataModel> menuList = sqlSession.selectList("sys03_menu.selectByPrntId", Long.parseLong("0"));

		for(GridDataModel child : menuList){
			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;
			List<GridDataModel> childList = getChildByParentId(sqlSession, menuModel.getMenuId());  
			menuModel.setChildList(childList); 	
		}
		result.setRetrieveResult(menuList.size(), "sys03_menu.selectByPrntId", menuList);
	}

	private List<GridDataModel> getChildByParentId(SqlSession sqlSession, Long parentId){
		
		List<GridDataModel> menuList = sqlSession.selectList("sys03_menu.selectByPrntId", parentId);
		for(GridDataModel child : menuList){
			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;
			List<GridDataModel> childList = getChildByParentId(sqlSession, menuModel.getMenuId());  
			menuModel.setChildList(childList); 	
		}
		return menuList ; 
	}

	public void selectByMenuNm(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("sys03_menu.selectByMenuNm", request.getParam());
		result.setRetrieveResult(1, "select ok", list);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys03_menu", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys03_menu", result);
	}
}
