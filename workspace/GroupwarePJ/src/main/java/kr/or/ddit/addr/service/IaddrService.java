package kr.or.ddit.addr.service;

import java.util.List;

import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.Address_favoriteVO;
import kr.or.ddit.vo.Address_groupVO;
import kr.or.ddit.vo.AjaxdataAddressLineVO;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.Image_AttatchVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;

public interface IaddrService {
	//left사내주소록 
	public  List<AddressVO> leftAddr();
	//사내주소록 리스트 보이기 
	public List<EmployeeVO> addrList(PagingVO<EmployeeVO> pagingVO);
	//주소록 수량 출력
	public int selectaddrCount(PagingVO<EmployeeVO> pagingVO);
	/////상세보기 내가한거 
	public EmployeeVO selectAddress(String emp_code);
	//부서 리스트 조회
	public List<EmployeeVO> deptList(PagingVO<EmployeeVO> pagingVO);
	//부서 인원 수 출력
	public int selectDeptCount(PagingVO<EmployeeVO> pagingVO);
	///팀 리스트 조회
	public List<EmployeeVO> teamAddress(PagingVO<EmployeeVO> pagingVO);
	
	//팀 개개별 리스트를 출력
	public List<EmployeeVO> teamList(PagingVO<EmployeeVO>pagingVO);
	//팀 개개별 인원 수 출력
	public int teamCount(PagingVO<EmployeeVO>pagingVO);
	
	//거래처의 개별 리스트
	public List<AddressVO> customerList(PagingVO<AddressVO> pagingVO);
	//거래처의 수 출력
	public int customerCount(PagingVO<AddressVO> pagingVO);
	
	//팀 인원 수 출력
	public int selectTeamCount(PagingVO<EmployeeVO> pagingVO);
	//그룹 개개별 카운트
	public int groupCount(PagingVO<EmployeeVO> pagingVO);
	//그룹 상세보기
	public AjaxdataAddressLineVO readGroupList(String add_code);
	//////////////////////7/23일작성///////////////////////////////////////
	//내 주소록  리스트 출력
	public List<AjaxdataAddressLineVO> myaddressList(PagingVO<AjaxdataAddressLineVO> pagingVO);
   ///내 주소록 카운트
	public int selectmyaddCount(PagingVO<AjaxdataAddressLineVO> pagingVO);
	//내 주소록 상세보기
	public AddressVO myselectAddress(String add_code);
	///내 주소록의 즐겨찾기 리스트 leftmenu
	public List<Address_favoriteVO> myfavoriteList(String emp_code);
	//내 주소록의 거래처 리스트 leftmenu
	public List<Address_groupVO> mycustomergroupaddr(String emp_code);
	//내 주수록의 즐겨찾기 & 거래처 카운트
	public int selectmyfavoriteCount(PagingVO<EmployeeVO>pagingVO);
	//내 주소록 거래처 등록
	public ResultState insertEmp(AddressVO address);
	//내 주소록 상세보기에서 수정
	public int updatemyaddress(AddressVO add_code);
	//내 주소록 완전 삭제
	public ResultState deleteMyaddress(String add_code);
	
	
	
//////////////////////7/23일작성///////////////////////////////////////
	
	
	//주소록 상세보기 
//	public EmployeeVO selectaddr(String emp_code);
//	public List<EmployeeVO> addrList(PagingVO<EmployeeVO>)
	
	
	///////////////////////dynaTree//////////////////////
	
	/**
	 * 사내주소록 검색 조건에 맞는 사내 주소록 사원목록
	 */
	public List<EmployeeVO> readAddrList(PagingVO<EmployeeVO> pagingVO);
	
	
	/**
	 * 부서를 리스트로 출력
	 * @return
	 */
	public List<DepartmentVO> readDepartmentList();
	
	
	/**
	 * 해당부서에 속해있는 팀을 리스트로 출력
	 * @param dept_code 부서코드
	 * @return
	 */
	public List<TeamVO> readTeamList(String dept_code);
	//////////////////////////////////////////////////////////////////
	public ResultState updateCustomAddr(AddressVO addressVO);
}