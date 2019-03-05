package myApp.server.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println("menuList.size()" + menuList.size());
		result.setRetrieveResult(menuList.size(), "sys03_menu.selectByPrntId", menuList);
	}

	private List<GridDataModel> getChildByParentId(SqlSession sqlSession, Long parentId){
		
		System.out.println("parentId : " + parentId);
		
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


//	public void selectByCompanyId(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		
//		String sqlId = this.mapperName + ".selectByCompanyId";
//		
//		Long companyId = request.getLongParam("companyId"); 
//		
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("companyId", companyId); 
//		param.put("parentId", Long.parseLong("0"));
//		
//		List<GridDataModel> menuList = sqlSession.selectList(sqlId, param);
//
//		for(GridDataModel child : menuList){
//			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;
//			List<GridDataModel> childList = getChildByCompanyId(sqlSession, companyId, menuModel.getMenuId());  
//			menuModel.setChildList(childList); 	
//		}
//		result.setRetrieveResult(menuList.size(), sqlId, menuList);
//	}
//
//	private List<GridDataModel> getChildByCompanyId(SqlSession sqlSession, Long companyId, Long parentId){
//		
//		String sqlId = this.mapperName + ".selectByCompanyId";
//
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("companyId", companyId); 
//		param.put("parentId", parentId);
//		
//		List<GridDataModel> menuList = sqlSession.selectList(sqlId, param);
//
//		for(GridDataModel child : menuList){
//			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;
//			List<GridDataModel> childList = getChildByCompanyId(sqlSession, companyId, menuModel.getMenuId());  
//			menuModel.setChildList(childList); 	
//		}
//		return menuList ; 
//	}
//
//	
//	public void selectByRoleId(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//
//		Long roleId = request.getLongParam("roleId") ; 
//		Long companyId = request.getLongParam("companyId") ;
//		
//		Map<String, Long> param = new HashMap<String, Long>();
//		param.put("roleId", roleId); 
//		param.put("companyId", companyId);
//		param.put("parentId", Long.parseLong("0"));
//		
//		List<GridDataModel> roleMenuList 
//			= sqlSession.selectList(mapperName + ".selectByRoleId", param);
//
//		for(GridDataModel child : roleMenuList){
//			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;
//			
//			Map<String, Long> childParam = new HashMap<String, Long>();
//			childParam.put("roleId", roleId); 
//			childParam.put("companyId", companyId);
//			childParam.put("parentId", menuModel.getMenuId());
//			
//			List<GridDataModel> childList = getChildByRoleId(sqlSession, childParam);  
//			menuModel.setChildList(childList); 	
//		}
//		result.setRetrieveResult(roleMenuList.size(), "RoleMenu 조회", roleMenuList);
//	}
	


//	public void updateRoleMenu(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		
//		Long roleId = request.getLongParam("roleId"); 
//		
//		List<GridDataModel> updateList = new ArrayList<GridDataModel>(); 
//		List<GridDataModel> deleteList = new ArrayList<GridDataModel>();
//		
//		for(GridDataModel dataModel : request.getList()) {
//			
//			Sys03_MenuModel menuModel = (Sys03_MenuModel)dataModel;
//			
//			if(menuModel.getRoleMenuYn()) {
//
//				Sys06_RoleMenuModel roleMenuModel = new Sys06_RoleMenuModel();
//			
//				Long seq = sqlSession.selectOne("getSeq"); // getSeq cache setting 확인. 
//				roleMenuModel.setRoleMenuId(seq);
//				roleMenuModel.setMenuId(menuModel.getMenuId());
//				roleMenuModel.setRoleId(roleId);
//				roleMenuModel.setUseYn("true");
//				roleMenuModel.setRmk(menuModel.getMenuName());
//				updateList.add(roleMenuModel);
//			}
//			else {
//				deleteList.add(menuModel.getRoleMenuModel()); 	
//			}
//		}
//
//		UpdateDataModel<GridDataModel> updateData = new UpdateDataModel<GridDataModel>(); 
//		if(updateList.size() > 0) {
//			updateData.updateModel(sqlSession, updateList, "sys07_role_menu", result);
//		}
//		if(deleteList.size() > 0) {
//			updateData.deleteModel(sqlSession, deleteList, "sys07_role_menu", result);
//		}
//
//		// 처리가 완료되면(오류가 없으면...) 다시 넘겨준다.  
//		// 다시 조회하면 트리가 깨진다. 
//		result.setResult(request.getList());
//	}
	
	
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
