package myApp.server.com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.com.model.Com09_TaxRtModel;
import myApp.server.utils.db.UpdateDataModel;

public class Com09_TaxRate {

	public void selectBySearText(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		String taxRtTypeCode 	  = request.getStringParam("taxRtTypeCode") ;
		Map<String, Object> param = new HashMap<String, Object>();
		System.out.println("taxRtTypeCode  : 입니다. " + taxRtTypeCode); 
		param.put("taxRtTypeCode", taxRtTypeCode);
		List<GridDataModel> list = sqlSession.selectList("com09_tax_rt.selectBySearText", param);
		result.setRetrieveResult(1, "select ok", list);
		
	}
	
	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<Com09_TaxRtModel> updateModel = new UpdateDataModel<Com09_TaxRtModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "com09_tax_rt", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Com09_TaxRtModel> updateModel = new UpdateDataModel<Com09_TaxRtModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "com09_tax_rt", result);
	}
}
