package myApp.server.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.sys.model.Sys04_CmpMenuModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys04_CmpMenu { 
	
	public void selectByCmpCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		List<GridDataModel> menuList = sqlSession.selectList("sys04_cmp_menu.selectByPrntId", request.getParam());

		for(GridDataModel child : menuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;
			List<GridDataModel> childList = getChildByParentId(sqlSession, menuModel.getCmpMenuId(), menuModel.getCmpCode());  
			menuModel.setChildList(childList); 	
		}
		result.setRetrieveResult(menuList.size(), "sys04_cmp_menu.selectByPrntId", menuList);
	}

	private List<GridDataModel> getChildByParentId(SqlSession sqlSession, Long parentId, String cmpCode){
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cmpCode", cmpCode);
		param.put("prntId" , parentId);
		List<GridDataModel> menuList = sqlSession.selectList("sys04_cmp_menu.selectByPrntId", param);

		for(GridDataModel child : menuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;
			List<GridDataModel> childList = getChildByParentId(sqlSession, menuModel.getCmpMenuId(), menuModel.getCmpCode());  
			menuModel.setChildList(childList); 	
		}
		return menuList ; 
	}

	public void insertInitMenu(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		String cmpCode = request.getStringParam("cmpCode");
		Long cnt = sqlSession.selectOne("sys04_cmp_menu.countCmpMenu", cmpCode);
		System.out.println(cmpCode + " cnt : " + cnt);
		if(cnt>0) {
			result.setStatus(-1);
			result.setMessage("이미 메뉴가 존재합니다.");
			return;
		}
		sqlSession.insert("sys04_cmp_menu.insertInitMenu", cmpCode);
		result.setStatus(1);
	}

	public void selectByUsrNo(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		String cmpCode = request.getStringParam("cmpCode");
		String usrNo   = request.getStringParam("usrNo");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cmpCode", cmpCode);
		param.put("usrNo", usrNo);
		param.put("prntId", Long.parseLong("0"));

		List<GridDataModel> rootMenuList = sqlSession.selectList("sys04_cmp_menu.selectByUsrNo", param);

		for(GridDataModel child : rootMenuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;
			
			Map<String, Object> childParam = new HashMap<String, Object>();
			childParam.put("cmpCode", cmpCode);
			childParam.put("usrNo", usrNo); 
			childParam.put("prntId", menuModel.getCmpMenuId());
			
			List<GridDataModel> childList = getChildByUsrNo(sqlSession, childParam);  
			menuModel.setChildList(childList); 	
		}
		result.setRetrieveResult(rootMenuList.size(), "UserRoleMenu 조회", rootMenuList);
	}
	
	private List<GridDataModel> getChildByUsrNo(SqlSession sqlSession, Map<String, Object> param){
		
		List<GridDataModel> menuList = sqlSession.selectList("sys04_cmp_menu.selectByUsrNo", param);

		String cmpCode = (String) param.get("cmpCode");
		String usrNo   = (String) param.get("usrNo");

		for(GridDataModel child : menuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;

			Map<String, Object> childParam = new HashMap<String, Object>();
			childParam.put("cmpCode", cmpCode);
			childParam.put("usrNo", usrNo);
			childParam.put("prntId", menuModel.getMenuId());

//			List<GridDataModel> childList = getChildByRoleId(sqlSession, childParam);  
			List<GridDataModel> childList = getChildByUsrNo(sqlSession, childParam);
			menuModel.setChildList(childList); 	
		}
		
		return menuList ; 
	}

//	private List<GridDataModel> getChildByRoleId(SqlSession sqlSession, Map<String, Object> param){
//		
//		String cmpCode = (String) param.get("cmpCode");
//		Long   roleId  = (Long) param.get("roleId"); 
//		
//		List<GridDataModel> roleMenuList = sqlSession.selectList("sys04_cmp_menu.selectByRoleId", param);
//		
//		for(GridDataModel child : roleMenuList){
//			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;
//			
//			Map<String, Object> childParam = new HashMap<String, Object>();
//			childParam.put("roleId", roleId); 
//			childParam.put("cmpCode", cmpCode);
//			childParam.put("prntId", menuModel.getMenuId());
//			
//			List<GridDataModel> childList = getChildByRoleId(sqlSession, childParam);  
//			menuModel.setChildList(childList); 	
//		}
//		
//		return roleMenuList ; 
//	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		for (GridDataModel model : request.getList()) {
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)model;
			System.out.println("cmpMenuId : " + menuModel.getCmpMenuId());
			System.out.println("cmpCd : " + menuModel.getCmpCode());
			System.out.println("menuId : " + menuModel.getMenuId());
			System.out.println("prntId : " + menuModel.getPrntId());
		}

		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys04_cmp_menu", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys04_cmp_menu", result);
	}
}
