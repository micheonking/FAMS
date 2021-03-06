package myApp.server.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.LoginUser;
import myApp.client.vi.sys.model.Sys01_CmpInfoModel;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;
import myApp.server.utils.db.UpdateDataModel;

public class Sys02_UsrInfo {
	
	public void getLoginInfo(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		String otpNumber = request.getStringParam("otpNumber");
		if ((otpNumber == null)||("".equals(otpNumber))) {
			result.fail(-1, "OTP인증번호를 입력하여 주십시오.");
			return;
		}
		Sys02_UsrInfoModel usrInfo = sqlSession.selectOne("sys02_usr_info.selectByUsrNo", request.getParam()) ;
		if(usrInfo != null) {
			result.setModel(1, "login OK", usrInfo);
		} else {
			result.fail(-1, "등록된 사용자 정보가 아닙니다.<br> 입력정보를 확인하여 주십시요.");
		}
		return ; 
	}

	public void selectByUsrName(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		String usrName = request.getStringParam("usrName");
		if(usrName == null){
			usrName = "";
		}
		usrName = "%" + usrName + "%";
		
		String dptName = request.getStringParam("dptName");
		if(dptName == null){
			dptName = "";
		}
		dptName = "%" + dptName + "%";
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("cmpCode", request.getStringParam("cmpCode"));
		param.put("usrName", usrName); 
		param.put("dptName", dptName);
		
		System.out.println("dptName    : "   + dptName);
		System.out.println("usrName    : "   + usrName);

		List<GridDataModel> list = sqlSession.selectList("sys02_usr_info.selectByUsrName", param);
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void userPw(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("usrInfoId", request.getLongParam("usrInfoId"));
		param.put("tmpPwd", request.getStringParam("newPw"));
		
		sqlSession.update("sys02_usr_info.userPw", param);
		result.setStatus(1); //1:정상
		
	}
	

	public void selectByCmpCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList("sys02_usr_info.selectByCmpCode", LoginUser.getCmpCode());
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		String usrNo = request.getStringParam("usrNo");
		UpdateDataModel<Sys02_UsrInfoModel> updateModel = new UpdateDataModel<Sys02_UsrInfoModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), "sys02_usr_info", usrNo, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Sys02_UsrInfoModel> updateModel = new UpdateDataModel<Sys02_UsrInfoModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), "sys02_usr_info", result);
	}
}
