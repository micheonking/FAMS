package myApp.server.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.com.model.Com01_ComCdModel;
import myApp.server.utils.db.UpdateDataModel;

public class Com02_DtlCode {
	

	public void selectByComCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		System.out.println("comCode    : ["+ request.getStringParam("comCode")+"]");
		List<GridDataModel> list = sqlSession.selectList("com02_dtl_cd.selectByComCode", request.getStringParam("comCode"));
		System.out.println("listSize is   :  " +list.size());
		result.setRetrieveResult(1, "select ok", list);
	}
	
	
	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		System.out.println("usrNo  : [" + usrNo+"]");
		UpdateDataModel<Com01_ComCdModel> updateModel = new UpdateDataModel<Com01_ComCdModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "com02_dtl_cd",usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Com01_ComCdModel> updateModel = new UpdateDataModel<Com01_ComCdModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "com02_dtl_cd", result);
	}
}
