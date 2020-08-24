package kr.or.ddit.att_admin.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.Com_PolicyVO;
import kr.or.ddit.vo.Com_WorkStdVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.StandardVO;
import kr.or.ddit.vo.Time_AttendVO;

public interface IAdminAttService {
/**
 * 대체얼굴등록하기
 * @param empVO
 * @return
 */
 public ResultState UpdateSubFaceId(EmployeeVO empVO);
/**
 * faceID 리스트 
 * @return
 */
 public List<EmployeeVO> getFaceIdList();
/**
 * 근태입력
 * @param timeVO
 * @return
 */
 public ResultState AddAttendence(Time_AttendVO timeVO);
/**
 * 휴무일 등록 및 업데이트 
 * @param workStdVO
 * @return
 */
 public ResultState AddHoliday(Com_WorkStdVO workStdVO);
/**
 * 회사휴일,공휴일
 * @return
 */
 public List<Com_WorkStdVO> getComVacaList();
/**
 * 상세근태현황 - 클라이언트 사이드 페이징 처리
 * @return
 */
 public List<Time_AttendVO> readAttDetail(Time_AttendVO timeAttVO);

	
/**
 * 출근 여부를 확인하기 위함	
 * @param timeAttVO
 * @return
 */
 public Time_AttendVO readEmpAtt(Time_AttendVO timeAttVO, String checkTime);	
 /**
  * 퇴근 업데이트 
  * @param empVO
  * @return
  */
 public ResultState modifyEmpAtt(Time_AttendVO timeAttVO);
/**
 * 출근 등록	
 * @param timeAttVO
 * @return
 */
 public ResultState createEmpAtt(Time_AttendVO timeAttVO);	
 /**
  * 회원 IP 상세 조회 
  * @param emp_code
  * @return
  */
 public EmployeeVO readEmpIp(String emp_code);
 /**
  * 검색 조건에 맞는 월별 근태 목록 
  * @param 
  * @return
  */
 public List<Time_AttendVO> readAttMonthlyList(Time_AttendVO timeAttVO);
 /**
  * 검색 조건에 맞는 회원 수 
  * @param pagingVO
  * @return
  */
 public int readEmpIpCount(PagingVO<EmployeeVO> pagingVO);
 /**
  * 검색 조건에 맞는 회원 목록 
  * @param pagingVO
  * @return
  */
 public List<EmployeeVO> readEmpIpList(PagingVO<EmployeeVO> pagingVO);
 /**
  * 회원 IP 수정 
  * @param empVO
  * @return
  */
 public ResultState modifyEmpIp(EmployeeVO empVO);
}