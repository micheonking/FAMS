package myApp.server.itm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.itm.model.Itm01_ItmModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.server.utils.db.UpdateDataModel;

public class Itm01_Itm {

	public void selectBySearchText(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String searchText = request.getStringParam("searchText");
		if(searchText == null){
			searchText = "";
		}
		searchText = "%" + searchText + "%";
		request.putStringParam("searchText", searchText);
		
		System.out.println("cmpCode     : " + request.getStringParam("cmpCode"));
		System.out.println("lClassCode  : " + request.getStringParam("lClassCode"));
		System.out.println("abroTypCode : " + request.getStringParam("abroTypCode"));
		System.out.println("searchText  : " + request.getStringParam("searchText"));

		List<GridDataModel> list = sqlSession.selectList("itm01_itm.selectBySearchText", request.getParam());
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void selectOneItmName(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String itmName = sqlSession.selectOne("itm01_itm.selectOneItmName", request.getParam());
		if(itmName == null) {
			request.putStringParam("cmpCode", "00000");
			itmName = sqlSession.selectOne("itm01_itm.selectOneItmName", request.getParam());
		}
		if(itmName == null) {
			result.setMessage("등록된 종목이 아닙니다.");
		} else {
			result.setMessage(itmName);
		}
	}

	public void selectByItmCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("itm01_itm.selectByItmCode", request.getParam());
		if(list.size() == 0) {
			request.putStringParam("cmpCode", "00000");
			list = sqlSession.selectList("itm01_itm.selectByItmCode", request.getParam());
		}
		result.setRetrieveResult(list.size(), "select ok", list);
	}

	public void rowUpdate(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		String usrNo = request.getStringParam("usrNo");

		Itm01_ItmModel itmModel = (Itm01_ItmModel)request.getModelParam("itmModel");
		if(itmModel.getItmId() == null) {
			itmModel.setItmId(sqlSession.selectOne("getSeq"));
		}

		List<GridDataModel> list = new ArrayList<GridDataModel>();
		list.add(itmModel);

		UpdateDataModel<GridDataModel> updateData = new UpdateDataModel<GridDataModel>(); 
		updateData.updateModel(sqlSession, list, "itm01_itm", usrNo, result);
	}

	public void rowDelete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
//		Itm01_ItmModel itmModel = (Itm01_ItmModel)request.getModelParam("itmModel");
//		if(itmModel.getItmId() == null) {
//			itmModel.setItmId(sqlSession.selectOne("getSeq"));
//		}

		List<GridDataModel> list = new ArrayList<GridDataModel>();
		list.add(request.getModelParam("itmModel"));

		UpdateDataModel<GridDataModel> updateData = new UpdateDataModel<GridDataModel>(); 
		updateData.deleteModel(sqlSession, list, "itm01_itm", result);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>();
		updateModel.updateModel(sqlSession, request.getList(), "itm01_itm", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<GridDataModel> updateModel = new UpdateDataModel<GridDataModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "itm01_itm", result);
	}
}
