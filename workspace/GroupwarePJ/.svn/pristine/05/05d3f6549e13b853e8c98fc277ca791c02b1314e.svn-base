package kr.or.ddit.login_logout.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nimbusds.oauth2.sdk.util.StringUtils;

import exception.DataNotFoundException;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.login_logout.dao.ILoginDAO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.FaceIdentifyResult;

@Service
public class LoginServiceImpl implements ILoginService {
	@Inject
	ILoginDAO dao;
	@Inject
	AzurePersonService personService;
	@Inject
	AzureFaceService faceService;
	@Value("#{appInfo.personGroupId}")
	String personGroupId;
	
	//아이디,비번 로그인
	@Override
	public EmployeeVO checkEmployeeCode(EmployeeVO employeeVO) {
		EmployeeVO empVO = dao.selectEmpLoginCheck(employeeVO);
		return empVO;
	}
	//face로그인을 위한 회원정보가져오기(emp_code, emp_pass, emp_kor정도) 
	@Override
	public EmployeeVO getEmpLoginInfo(EmployeeVO employeeVO) {
		try {
			Map<String, Object> responseBody = new HashMap<>();
			MultipartFile faceimg = employeeVO.getImg1();//클라이언트에서입력된이미지
			byte[] faceImage = faceimg.getBytes();
			//입력한 faceimage로 faceid 추출 
			int sc = faceService.detectFaceSimple(faceImage, responseBody);
			if(sc==200) {
				String faceId = (String)responseBody.get("faceId");//클라이언트에서입력된이미지
				//추출한 faceid로 해당하는 personid찾기
				int cnt = faceService.faceIdentify(faceId, personGroupId, responseBody);
				if(cnt==200) {
					FaceIdentifyResult result = ((FaceIdentifyResult[]) responseBody.get("results"))[0];
					if(result.getCandidates().length > 0 ) { //성공!! 
						String searchedPersonId = result.getCandidates()[0].getPersonId();
						employeeVO = dao.selectEmpLoginInfo(searchedPersonId); //최종목표!!controller로 보내면 emp_code와 pass를 담는다 
					}else {
						employeeVO = null;
					}
				}else {
					employeeVO = null;
				}
			}else {
				employeeVO = null;
			}
			} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return employeeVO;
	}
		
	@Override
	public EmployeeVO checkEmpMail(String emp_code) {
		EmployeeVO employeeVO = dao.selectEmpMail(emp_code);
		if(employeeVO==null) {
			throw new DataNotFoundException("이메일 불일치");
		}
		return employeeVO;
	}

	@Override 
	public ResultState changeEmpPassword(EmployeeVO employeeVO) {
		ResultState state = ResultState.FAIL;
		int cnt = dao.updateEmpPassword(employeeVO);
		if(cnt!=0) {
			state = ResultState.SUCCESSES;
		}
		return state;
	}
	
	//강현철
	@Override
	public EmployeeVO getEmpInfo(EmployeeVO employeeVO) {
		return dao.selectEmployee(employeeVO);
	}

}
