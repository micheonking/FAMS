package myApp.server.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.com.model.Com04_TrCodeModel;
import myApp.server.utils.db.UpdateDataModel;

public class Com04_TrCode {

	public void selectBySearText(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String searText = request.getStringParam("searText");
		if(searText == null){
			searText = "";
		}
		searText = "%" + searText + "%";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searText", searText); 
		System.out.println("searText  is   :   "+searText);
		List<GridDataModel> list = sqlSession.selectList("com04_tr_cd.selectBySearText", param);
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<Com04_TrCodeModel> updateModel = new UpdateDataModel<Com04_TrCodeModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "com04_tr_cd", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Com04_TrCodeModel> updateModel = new UpdateDataModel<Com04_TrCodeModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "com04_tr_cd", result);
	}
}
