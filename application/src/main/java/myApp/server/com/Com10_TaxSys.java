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

public class Com10_TaxSys {

	public void selectBySearText(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String searText = request.getStringParam("searText");
		if(searText == null){
			searText = "";
		}
		searText = "%" + searText + "%";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searText", searText); 
		System.out.println("searText  is   :   "+searText);
		List<GridDataModel> list = sqlSession.selectList("com10_tax_sys.selectBySearText", param);
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<Com09_TaxRtModel> updateModel = new UpdateDataModel<Com09_TaxRtModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "com10_tax_sys", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Com09_TaxRtModel> updateModel = new UpdateDataModel<Com09_TaxRtModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "com10_tax_sys", result);
	}
}
