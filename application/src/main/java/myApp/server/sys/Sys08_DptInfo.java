package myApp.server.sys;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys08_DptInfo { 
	
	public void selectByName(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		System.out.println("cmpCode : " + request.getStringParam("cmpCode"));
		System.out.println("dptName : " + request.getStringParam("dptName"));

		List<GridDataModel> list = sqlSession.selectList("sys08_dpt_info.selectByName", request.getParam()) ; 
		result.setRetrieveResult(list.size(), "sys08_dpt_info.selectByName", list);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys08_dpt_info", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys08_dpt_info", result);
	}
}