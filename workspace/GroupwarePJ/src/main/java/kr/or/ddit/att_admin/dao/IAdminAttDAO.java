package kr.or.ddit.att_admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.Com_PolicyVO;
import kr.or.ddit.vo.Com_WorkStdVO;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.StandardVO;
import kr.or.ddit.vo.Time_AttendVO;

@Repository
public interface IAdminAttDAO {
	/**
	 * 대체faceid 등록
	 * @param empVO
	 * @return
	 */
	public int updateSubFaceId (EmployeeVO empVO);
	/**
	 * faceID 목록 리스트 
	 * @return
	 */
	public List<EmployeeVO> selectFaceIdList(); 
	/**
	 * 근태입력
	 * @param timeVO
	 * @return
	 */
	public int updateAtt(Time_AttendVO timeVO);
	/**
	 * 휴무일 등록(업데이트)
	 * @param workStdVO
	 * @return
	 */
	public int updateHoliday(Com_WorkStdVO workStdVO);
	/**
	 * 정상출근,휴일,공휴일,휴무일,공휴일 가져오기
	 * @return
	 */
	public List<StandardVO> selectCwsCode();
	/**
	 * 근태 상세조회 (클라이언트사이드 페이징처리)
	 * @return
	 */
	public List<Time_AttendVO> selectAttDetailList(Time_AttendVO timeAttVO);
	/**
	 * 회사휴일,공휴일
	 * @param vo
	 * @return
	 */
	public List<Com_WorkStdVO> selectComVacaList();
	/**
	 * 회사정책
	 * @return
	 */
	public Com_PolicyVO selectCompanyPolicy();
	/**
	 * 회사 휴무일, 정상출근일 등 회사근무기준일 확인하기
	 * @param comVO
	 * @return
	 */
	public Com_WorkStdVO selectCompanyStandard(String cws_code);
	/**
	 * 출근했는지 여부 파악 하기 위함 
	 * @param emp_code, 
	 * @return
	 */
	public Time_AttendVO selectAtt(Time_AttendVO timeAttVO);
	/**
	 * 출근 추가 
	 * @return 성공하면 1 실패하면 0 
	 */
	public int insertAttendence(Time_AttendVO timeAttVO);
	/**
	 * 퇴근 업데이트 
	 * @param timeAttVO
	 * @return
	 */
	public int updateAttendence(Time_AttendVO timeAttVO);
	/**
	 * 회원 IP목록 상세조회 (여기에서 수정도해야함) 
	 * @param emp_code
	 * @return 존재하지 않으면 null 반환 
	 */
	public EmployeeVO selectEmpIP(String emp_code);
	/**
	 * 월별 근태 현황 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<Time_AttendVO> selectAttMonthlyList(Time_AttendVO timeAttVO);
	 /**
	  * 페이징 처리를 위한 Count
	  * @param pagingVO
	  * @return
	  */
	public int selectEmpIpCount(PagingVO<EmployeeVO> pagingVO);
	/**
	 * 페이징 처리가 된 회원 IP목록
	 * @param pagingVO
	 * @return
	 */
	public List<EmployeeVO> selectEmpIpList(PagingVO<EmployeeVO> pagingVO);
	/**
	 * 회원 Ip설정 ! ID 아닙니다 IP에요
	 * @param empIp
	 * @return
	 */
	public int updateEmpIp(EmployeeVO empVO);
	/**
	 * 부서명 가져오기! 
	 * @return
	 */
	public List<Map<String, Object>> selectDeptName();
	/**
	 * 근태구분 가져오기
	 * @return
	 */
	public List<Map<String,Object>> selectCatagCode();
	/**
	 * 휴가면 밤 12시 01분에 time_attend에 휴가코드 들어가는 프로시저실행
	 */
	public void insertVacaAtt();
	/**
	 * 휴무면 밤 12시 02분에 time_attend에 휴무코드 들어가는 프로시저 실행
	 */
	public void insertHoliAtt();
}
