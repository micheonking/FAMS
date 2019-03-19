package myApp.server.com;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.com.model.Com01_ComCodeModel;
import myApp.server.utils.db.UpdateDataModel;

public class Com02_DtlCode {

	public void selectByComCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("com02_dtl_cd.selectByComCode", request.getStringParam("comCode"));
		result.setRetrieveResult(1, "select ok", list);
	}

	public void selectByComCodeAll(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("com02_dtl_cd.selectByComCodeAll", request.getStringParam("comCode"));
		result.setRetrieveResult(1, "select ok", list);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<Com01_ComCodeModel> updateModel = new UpdateDataModel<Com01_ComCodeModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "com02_dtl_cd", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Com01_ComCodeModel> updateModel = new UpdateDataModel<Com01_ComCodeModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "com02_dtl_cd", result);
	}
}
