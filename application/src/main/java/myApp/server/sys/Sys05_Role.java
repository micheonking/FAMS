package myApp.server.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.sys.model.Sys05_RoleModel;
import myApp.client.vi.sys.model.Sys07_UsrRoleModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys05_Role { 
	
	String mapperName = "sys05_role"; 
	
	public void selectByName(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("sys05_role.selectByName", request.getParam()) ; 
		result.setRetrieveResult(list.size(), "sys05_role.selectByName", list);
	}

	public void selectByUsrNo(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list  = sqlSession.selectList("sys05_role.selectByUsrNo", request.getParam()) ;
		result.setRetrieveResult(1, "sys05_role.selectByUsrNo", list);
	}
	
//	public void selectByNotAssigned(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		Long userId = request.getLongParam("userId"); 
//		List<GridDataModel> userRoleList = sqlSession.selectList(mapperName + ".selectByNotAssigned", userId) ;
//		result.setRetrieveResult(userRoleList.size(), "미등록 권한정보 조회", userRoleList);
//	}

	public void updateUsrRole(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		// delete all by userId
		String insertUsrNo = request.getStringParam("insertUsrNo");
		String usrNo = request.getStringParam("usrNo");
		
		// insert usrRoleYn = true 
		List<GridDataModel> updateList = new ArrayList<GridDataModel>(); 
		List<GridDataModel> deleteList = new ArrayList<GridDataModel>();

		for(GridDataModel dataModel : request.getList()) {
			Sys05_RoleModel roleModel = (Sys05_RoleModel)dataModel;
			if(roleModel.getUsrRoleYn()) { 
				Sys07_UsrRoleModel insertModel = new Sys07_UsrRoleModel();
				insertModel.setUsrRoleId(sqlSession.selectOne("getSeq"));
				insertModel.setCmpCode(roleModel.getCmpCode());
				insertModel.setUsrNo(insertUsrNo);
				insertModel.setRoleId(roleModel.getRoleId());
				insertModel.setRmk(roleModel.getRoleName());
				updateList.add(insertModel);
			} else {
				Sys07_UsrRoleModel deleteModel = roleModel.getUsrRoleModel();
				deleteList.add(deleteModel);
			}
		}
		
		UpdateDataModel<Sys07_UsrRoleModel> updateModel = new UpdateDataModel<Sys07_UsrRoleModel>(); 
		if(updateList.size() > 0) {
			updateModel.updateModel(sqlSession, updateList, "sys07_usr_role", usrNo, result); // update
		}
		
		if(deleteList.size()>0) {
			updateModel.deleteModel(sqlSession, deleteList, "sys05_user_role", result); // delete
		}
		
		Map<String, Object> param = new HashMap<String, Object>(); 
		param.put("usrNo", insertUsrNo); 
		param.put("cmpCode", request.getLongParam("cmpCode"));
		
		List<GridDataModel> list  = sqlSession.selectList("sys05_role.selectByUsrNo", param) ;
		result.setRetrieveResult(1, "sys05_role.selectByUsrNo", list);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys05_role", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Sys05_RoleModel> updateModel = new UpdateDataModel<Sys05_RoleModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys05_role", result);
	}
}