package myApp.server.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.client.vi.sys.model.Sys03_MenuModel;
import myApp.client.vi.sys.model.Sys04_CmpMenuModel;
import myApp.client.vi.sys.model.Sys05_RoleModel;
import myApp.client.vi.sys.model.Sys06_RoleMenuModel;
import myApp.client.vi.sys.model.Sys07_UsrRoleModel;
import myApp.client.vi.sys.model.Sys08_DptInfoModel;
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
		String usrNo = request.getStringParam("usrNo");

		Long cnt = sqlSession.selectOne("sys04_cmp_menu.countCmpMenu", cmpCode);
		if(cnt>0) {
			result.setStatus(-1);
			result.setMessage("이미 메뉴가 존재합니다.");
			return;
		}

		//-----------------------------------------------------------
		//	MASTER USER 생성 (sys02_usr_info)
		//-----------------------------------------------------------
		Sys02_UsrInfoModel usrModel = new Sys02_UsrInfoModel();
		usrModel.setUsrInfoId(sqlSession.selectOne("getSeq"));
		usrModel.setUsrNo("00000");
		usrModel.setUsrName("관리자");
		usrModel.setCmpCode(cmpCode);
		usrModel.setDptCode("000");
		usrModel.setUseYn("Y");
		usrModel.setTmpPwd("11");
		usrModel.setInsUsrNo("00000");
		usrModel.setInsDate(new Date());

		List<GridDataModel> usrList = new ArrayList<GridDataModel>();
		usrList.add(usrModel);
		UpdateDataModel<GridDataModel> usrInfoUpdateData = new UpdateDataModel<GridDataModel>(); 
		usrInfoUpdateData.updateModel(sqlSession, usrList, "sys02_usr_info", usrNo, result);

		//-----------------------------------------------------------
		//	MASTER 부서정보 생성 (sys08_dpt_info)
		//-----------------------------------------------------------
		Sys08_DptInfoModel dptModel = new Sys08_DptInfoModel();
		dptModel.setDptInfoId(sqlSession.selectOne("getSeq"));
		dptModel.setCmpCode(usrModel.getCmpCode());
		dptModel.setDptCode(usrModel.getDptCode());
		dptModel.setDptName("시스템관리");
		dptModel.setUseYn("Y");
		dptModel.setInsUsrNo(usrNo);
		dptModel.setInsDate(new Date());

		List<GridDataModel> dptList = new ArrayList<GridDataModel>();
		dptList.add(dptModel);
		UpdateDataModel<GridDataModel> dptInfoUpdateData = new UpdateDataModel<GridDataModel>(); 
		dptInfoUpdateData.updateModel(sqlSession, dptList, "sys08_dpt_info", usrNo, result);

		//-----------------------------------------------------------
		//	시스템관리자 Role 생성 (sys05_role)
		//-----------------------------------------------------------
		Sys05_RoleModel roleModel = new Sys05_RoleModel();
		roleModel.setRoleId(sqlSession.selectOne("getSeq"));
		roleModel.setRoleName("시스템 관리자");
		roleModel.setSeq((long)999);
		roleModel.setCmpCode(usrModel.getCmpCode());
		roleModel.setRmk("시스템 관리자");
		roleModel.setInsUsrNo(usrNo);
		roleModel.setInsDate(new Date());

		List<GridDataModel> roleList = new ArrayList<GridDataModel>();
		roleList.add(roleModel);
		UpdateDataModel<GridDataModel> roleUpdateData = new UpdateDataModel<GridDataModel>(); 
		roleUpdateData.updateModel(sqlSession, roleList, "sys05_role", usrNo, result);

		//-----------------------------------------------------------
		//	시스템관리자 Role MASTER USER 등록 (sys07_usr_role)
		//-----------------------------------------------------------
		Sys07_UsrRoleModel usrRoleModel = new Sys07_UsrRoleModel();
		usrRoleModel.setUsrRoleId(sqlSession.selectOne("getSeq"));
		usrRoleModel.setCmpCode(usrModel.getCmpCode());
		usrRoleModel.setUsrNo(usrModel.getUsrNo());
		usrRoleModel.setRoleId(roleModel.getRoleId());
		usrRoleModel.setRmk(roleModel.getRoleName());
		usrRoleModel.setInsUsrNo(usrNo);
		usrRoleModel.setInsDate(new Date());

		List<GridDataModel> usrRoleList = new ArrayList<GridDataModel>();
		usrRoleList.add(usrRoleModel);
		UpdateDataModel<GridDataModel> usrRoleUpdateData = new UpdateDataModel<GridDataModel>(); 
		usrRoleUpdateData.updateModel(sqlSession, usrRoleList, "sys07_usr_role", usrNo, result);

		//-----------------------------------------------------------
		//	메뉴생성 (sys04_cmp_menu)
		//-----------------------------------------------------------
		List<GridDataModel> cmpMenuList = new ArrayList<GridDataModel>();
		List<GridDataModel> menuList = sqlSession.selectList("sys03_menu.selectByPrntId", (long)0);
		for(GridDataModel child : menuList) {
			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;

			Sys04_CmpMenuModel cmpMenuModel = new Sys04_CmpMenuModel();
			cmpMenuModel.setCmpMenuId(sqlSession.selectOne("getSeq"));
			cmpMenuModel.setCmpCode(usrModel.getCmpCode());
			cmpMenuModel.setMenuId(menuModel.getMenuId());
			cmpMenuModel.setMenuName(menuModel.getMenuName());
			cmpMenuModel.setPrntId((long)0);
			cmpMenuModel.setSeq(menuModel.getSeq());
			cmpMenuModel.setUseYn("Y");
			cmpMenuModel.setInsUsrNo(usrNo);
			cmpMenuModel.setInsDate(new Date());
			cmpMenuList.add(cmpMenuModel);

			createChildByParentId(sqlSession, menuModel.getMenuId(), cmpMenuModel, result);
		}
		UpdateDataModel<GridDataModel> cmpMenuUpdateData = new UpdateDataModel<GridDataModel>(); 
		cmpMenuUpdateData.updateModel(sqlSession, cmpMenuList, "sys04_cmp_menu", usrNo, result);

		//-----------------------------------------------------------
		//	시스템관리자 Role 기본메뉴 등록 (sys06_role_menu)
		//-----------------------------------------------------------
		List<GridDataModel> roleMenuList = new ArrayList<GridDataModel>();
		List<GridDataModel> roleCmpMenuList = sqlSession.selectList("sys04_cmp_menu.selectByCmpCode", usrModel.getCmpCode());
		for(GridDataModel child : roleCmpMenuList) {
			Sys04_CmpMenuModel cmpMenuModel = (Sys04_CmpMenuModel)child;

			Sys06_RoleMenuModel roleMenuModel = new Sys06_RoleMenuModel();
			roleMenuModel.setRoleMenuId(sqlSession.selectOne("getSeq"));
			roleMenuModel.setRoleId(roleModel.getRoleId());
			roleMenuModel.setCmpMenuId(cmpMenuModel.getCmpMenuId());
			roleMenuModel.setUseYn(cmpMenuModel.getUseYn());
			roleMenuModel.setRmk(cmpMenuModel.getMenuName());
			roleMenuModel.setInsUsrNo(usrNo);
			roleMenuModel.setInsDate(new Date());
			roleMenuList.add(roleMenuModel);
		}
		UpdateDataModel<GridDataModel> roleMenuUpdateData = new UpdateDataModel<GridDataModel>(); 
		roleMenuUpdateData.updateModel(sqlSession, roleMenuList, "sys06_role_menu", usrNo, result);
		
		result.setStatus(1);
	}

	private void createChildByParentId(SqlSession sqlSession, Long menuParentId, Sys04_CmpMenuModel cmpMenuParentModel, ServiceResult result) {

		List<GridDataModel> cmpMenuList = new ArrayList<GridDataModel>();
		List<GridDataModel> menuList = sqlSession.selectList("sys03_menu.selectByPrntId", menuParentId);
		for(GridDataModel child : menuList) {
			Sys03_MenuModel menuModel = (Sys03_MenuModel)child;

			Sys04_CmpMenuModel cmpMenuModel = new Sys04_CmpMenuModel();
			cmpMenuModel.setCmpMenuId(sqlSession.selectOne("getSeq"));
			cmpMenuModel.setCmpCode(cmpMenuParentModel.getCmpCode());
			cmpMenuModel.setMenuId(menuModel.getMenuId());
			cmpMenuModel.setMenuName(menuModel.getMenuName());
			cmpMenuModel.setPrntId(cmpMenuParentModel.getCmpMenuId());
			cmpMenuModel.setSeq(menuModel.getSeq());
			cmpMenuModel.setUseYn("Y");
			cmpMenuModel.setInsUsrNo(cmpMenuParentModel.getInsUsrNo());
			cmpMenuModel.setInsDate(new Date());
			cmpMenuList.add(cmpMenuModel);

			createChildByParentId(sqlSession, menuModel.getMenuId(), cmpMenuModel, result);
		}
		UpdateDataModel<GridDataModel> cmpMenuUpdateData = new UpdateDataModel<GridDataModel>(); 
		cmpMenuUpdateData.updateModel(sqlSession, cmpMenuList, "sys04_cmp_menu", cmpMenuParentModel.getInsUsrNo(), result);
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
			childParam.put("prntId", menuModel.getCmpMenuId());

			List<GridDataModel> childList = getChildByUsrNo(sqlSession, childParam);
			menuModel.setChildList(childList); 	
		}
		
		return menuList ; 
	}

	public void selectByRoleId(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		String cmpCode = request.getStringParam("cmpCode") ;
		Long   roleId  = request.getLongParam("roleId") ;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cmpCode", cmpCode);
		param.put("roleId", roleId); 
		param.put("prntId", Long.parseLong("0"));
		
		List<GridDataModel> roleMenuList = sqlSession.selectList("sys04_cmp_menu.selectByRoleId", param);
		for(GridDataModel child : roleMenuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;

			Map<String, Object> childParam = new HashMap<String, Object>();
			childParam.put("cmpCode", cmpCode);
			childParam.put("roleId", roleId); 
			childParam.put("prntId", menuModel.getCmpMenuId());

			List<GridDataModel> childList = getChildByRoleId(sqlSession, childParam);
			menuModel.setChildList(childList); 	
		}
		result.setRetrieveResult(roleMenuList.size(), "sys04_cmp_menu.selectByRoleId", roleMenuList);
	}

	private List<GridDataModel> getChildByRoleId(SqlSession sqlSession, Map<String, Object> param){

		String cmpCode = (String) param.get("cmpCode");
		Long   roleId  = (Long) param.get("roleId"); 
		
		List<GridDataModel> roleMenuList = sqlSession.selectList("sys04_cmp_menu.selectByRoleId", param);
		for(GridDataModel child : roleMenuList){
			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)child;
			
			Map<String, Object> childParam = new HashMap<String, Object>();
			childParam.put("cmpCode", cmpCode);
			childParam.put("roleId", roleId); 
			childParam.put("prntId", menuModel.getCmpMenuId());
			
			List<GridDataModel> childList = getChildByRoleId(sqlSession, childParam);  
			menuModel.setChildList(childList); 	
		}
		
		return roleMenuList ; 
	}

	public void updateRoleMenu(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
	
	Long roleId = request.getLongParam("roleId");
	String usrNo = request.getStringParam("usrNo");
	
	List<GridDataModel> updateList = new ArrayList<GridDataModel>();
	List<GridDataModel> deleteList = new ArrayList<GridDataModel>();
	
	for(GridDataModel dataModel : request.getList()) {
		Sys04_CmpMenuModel cmpMenuModel = (Sys04_CmpMenuModel)dataModel;
		if(cmpMenuModel.getRoleMenuYn().equals("Y")) {
			Sys06_RoleMenuModel roleMenuModel = new Sys06_RoleMenuModel();
			roleMenuModel.setRoleMenuId(sqlSession.selectOne("getSeq"));
			roleMenuModel.setRoleId(roleId);
			roleMenuModel.setCmpMenuId(cmpMenuModel.getCmpMenuId());
			roleMenuModel.setUseYn("Y");
			roleMenuModel.setRmk(cmpMenuModel.getMenuName());
			updateList.add(roleMenuModel);
		}
		else {
			deleteList.add(cmpMenuModel.getRoleMenuModel());
		}
	}

	UpdateDataModel<GridDataModel> updateData = new UpdateDataModel<GridDataModel>(); 
	if(updateList.size() > 0) {
		updateData.updateModel(sqlSession, updateList, "sys06_role_menu", usrNo, result);
	}
	if(deleteList.size() > 0) {
		updateData.deleteModel(sqlSession, deleteList, "sys06_role_menu", result);
	}

	// 처리가 완료되면(오류가 없으면...) 다시 넘겨준다.  
	// 다시 조회하면 트리가 깨진다. 
	result.setResult(request.getList());
}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

//		for (GridDataModel model : request.getList()) {
//			Sys04_CmpMenuModel menuModel = (Sys04_CmpMenuModel)model;
//			System.out.println("cmpMenuId : " + menuModel.getCmpMenuId());
//			System.out.println("cmpCd : " + menuModel.getCmpCode());
//			System.out.println("menuId : " + menuModel.getMenuId());
//			System.out.println("prntId : " + menuModel.getPrntId());
//		}

		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys04_cmp_menu", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys04_cmp_menu", result);
	}

}
