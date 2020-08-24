package kr.or.ddit.work.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import exception.DataNotFoundException;
import kr.or.ddit.enums.ResultState;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.Report_AttVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;
import kr.or.ddit.vo.Work_ReportVO;
import kr.or.ddit.work.dao.IMyReportDAO;
import kr.or.ddit.work.dao.IWorkAttatchDAO;

@Service
public class MyReportServiceImpl implements IMyReportService {
	
	@Inject
	private IMyReportDAO dao;
	
	@Inject
	private IWorkAttatchDAO attatchDao;
	
	@Inject
	WebApplicationContext context;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	
	@Value("#{appInfo.attatchPath}")
	File saveFolder;
	
	@PostConstruct
	public void init(){
		if(!saveFolder.exists()) saveFolder.mkdirs();
	}
	
	private void deleteBinary(String[] delAttSaveName) {
		if(delAttSaveName == null || delAttSaveName.length == 0)return;
		try {
			for(String delName : delAttSaveName) {
				FileUtils.forceDelete(new File(saveFolder, delName));
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int processAttatches(Work_ReportVO report) {
		int cnt = 0;

		List<WorkLog_AttatchVO> wlattList = report.getWlattList();
		// 일지첨부파일 복사
		if(wlattList != null && !wlattList.isEmpty()){
			for(WorkLog_AttatchVO attch : wlattList) {
				String folderPath = attch.getFile_path();
				String fileName = attch.getSave_name();
				File file = new File(folderPath, fileName);
				File file2 = new File("C:\\Users\\PC-14\\Desktop\\newAtt", fileName);
				
				Report_AttVO attVO = attch.sendDate();
				attVO.setFile_path("C:\\Users\\PC-14\\Desktop\\newAtt");
				attVO.setReport_code(report.getReport_code());
				
				if(file.exists()){
					try {
						FileInputStream fis = new FileInputStream(file);
						FileOutputStream fos = new FileOutputStream(file2);
						
						int filebyte = 0;
						
						while((filebyte = fis.read()) != -1) {
							fos.write(filebyte);
						}
						
						fis.close();
						fos.close();
						
					}catch (FileNotFoundException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
					
					cnt += attatchDao.re_insertAttatchs(attVO);
					
				}else {
					System.out.println("파일 없음");
				}
				
			}
		}
		
		
		List<Report_AttVO> attatchList = report.getReport_attList();
		if(attatchList != null && !attatchList.isEmpty()) {
			try {
				for(Report_AttVO attatch : attatchList) {
					attatch.setReport_code(report.getReport_code());
					cnt += attatchDao.re_insertAttatchs(attatch);
					attatch.getRealFile().transferTo(new File(saveFolder, attatch.getSave_name()));
				}
			}catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e);
			}
		}
		return cnt;
	}
	
	@Transactional
	@Override
	public ResultState createReport(Work_ReportVO reportVO) {
		int cnt = dao.insertReport(reportVO);
		cnt += processAttatches(reportVO);
		ResultState result = null;
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}

	@Override
	public Work_ReportVO readReport(String report_code) {
		return dao.selectReport(report_code);
	}

	@Override
	public int readReportCount(PagingVO<Work_ReportVO> pagingVO) {
		return dao.selectReportCount(pagingVO);
	}

	@Override
	public List<Work_ReportVO> readReportList(PagingVO<Work_ReportVO> pagingVO) {
		return dao.selectReportList(pagingVO);
	}

	@Override
	public Report_AttVO downloadAttatch(String report_attcode) {
		Report_AttVO attatch = attatchDao.re_selectAttatch(report_attcode);
		if(attatch == null) {
			throw new DataNotFoundException(report_attcode + "파일이 없습니다.");
		}
		return attatch;
	}
	
//----------------------------------------------------------------------------------
	// 받은 업무보고

	@Override
	public ResultState completeReceiveReport(Work_ReportVO reportVO) {
		ResultState result = null;
		int cnt = dao.completeReceiveReport(reportVO);
		if(cnt > 0) {
			result = ResultState.OK;
		}else {
			result = ResultState.FAIL;
		}
		return result;
	}
	

}
