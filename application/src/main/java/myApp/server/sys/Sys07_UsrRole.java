package myApp.server.sys;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.sys.model.Sys07_UsrRoleModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys07_UsrRole { 
	
//	String mapperName = "sys05_user_role"; 
//	
//	public void selectByUserId(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		
//		Long userId = request.getLongParam("userId");
//		
//		System.out.println("userid is " + userId); 
//		
//		/* 
//		 * sys04_role에서 조회한다. ************************************************************ 
//		 */
//		List<GridDataModel> list  = sqlSession.selectList("sys04_role.selectByUserId", userId) ;
//		result.setRetrieveResult(1, "사용자별 메뉴권한 조회", list);
//	}
//
//	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		UpdateDataModel<Sys07_UsrRoleModel> updateModel = new UpdateDataModel<Sys07_UsrRoleModel>(); 
//		updateModel.updateModel(sqlSession, request.getList(), mapperName, result);
//	}
//	
//	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		UpdateDataModel<Sys07_UsrRoleModel> updateModel = new UpdateDataModel<Sys07_UsrRoleModel>(); 
//		updateModel.deleteModel(sqlSession, request.getList(), mapperName, result);
//	}
}