package kr.or.ddit.addr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.Address_favoriteVO;
import kr.or.ddit.vo.Address_groupVO;
import kr.or.ddit.vo.AjaxdataAddressLineVO;
import kr.or.ddit.vo.DepartmentVO;
import kr.or.ddit.vo.EmployeeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TeamVO;
@Repository
public interface IAddressDAO{
	
//left사내주소록 
public  List<AddressVO> leftAddr();	
//사내주소록 리스트 
public List<EmployeeVO> addrList(PagingVO<EmployeeVO>pagingVO);
//검색 조건에 맞는 주소록 수량 출력
public int selectaddrCount(PagingVO<EmployeeVO> pagingVO);
//상세보기 내가한거 
public EmployeeVO readAddressList(String emp_code);
//부서 인원 리스트 
public List<EmployeeVO> deptAddress(PagingVO<EmployeeVO>pagingVO);
//부서 인원 수 출력
public int selectDeptCount(PagingVO<EmployeeVO>pagingVO);
//팀인원 리스트 
public List<EmployeeVO> teamAddress(PagingVO<EmployeeVO> pagingVO);
//팀 개개별 리스트를 출력
public List<EmployeeVO> teamList(PagingVO<EmployeeVO>pagingVO);
//팀 개개별 인원 수 출력
public int teamCount(PagingVO<EmployeeVO>pagingVO);
//팀 인원 수 출력
public int selectTeamCount(PagingVO<EmployeeVO> pagingVO);
///그룹 개개별 카운트
public int groupCount(PagingVO<EmployeeVO> pagingVO);
//그룹 상세보기
public AjaxdataAddressLineVO readGroupList(String add_code);



///내 주소록의 즐겨찾기 리스트 leftmenu
public List<Address_favoriteVO> myfavoriteList(String emp_code);
//내 주소록의 거래처 리스트 leftmenu
public List<Address_groupVO> mycustomergroupaddr(String emp_code);

//내 주소록 리스트(즐찾의 폴더)
public List<AjaxdataAddressLineVO> myaddressList(PagingVO<AjaxdataAddressLineVO> pagingVO);
//내 주소록 거래처 리스트
public List<AddressVO> customerList(PagingVO<AddressVO> pagingVO);
public int customerCount (PagingVO<AddressVO> pagingVO);
//내 주소록 카운트
public int selectmyaddCount(PagingVO<AjaxdataAddressLineVO> pagingVO);
//내 주소록 상세보기-2
public AddressVO myselectAddress(String add_code );


//내 주소록의 즐겨찾기 & 거래처 카운트
public int selectmyfavoriteCount(PagingVO<EmployeeVO>pagingVO);
//내 주수록 거래처 등록(모달창)
public int insertEmp(AddressVO address);
//내 주소록 상세보기에서 수정
public int updatemyaddress(AddressVO add_code);
//내 주소록 완전 삭제
public int deleteMyaddress(String add_code);














////////////////////////////////dynaTree////////////////////////////	
	/**
	 * 검색 조건에 맞는 사내 주소록 사원 목록 조회
	 * @param pagingVO 
	 * @return
	 * 
	 */
	public List<EmployeeVO> selectAddrList(PagingVO<EmployeeVO> pagingVO);
	
	/**
	 * 전체 부서 정보를 가져온다.
	 * @return
	 */
	public List<DepartmentVO> selectDepartmentList();
	
	/**
	 * 부서에 속해있는 팀의 전체 정보를 가져온다.
	 * @param dept_code 부서코드
	 * @return
	 */
	public List<TeamVO> selectTeamList(String dept_code);
	public int updateCustomAddr(AddressVO addressVO);
	
	
	//////////////////////////////////////////////////////////////////
}