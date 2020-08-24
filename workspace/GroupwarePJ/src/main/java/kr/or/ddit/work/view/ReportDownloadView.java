package kr.or.ddit.work.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.vo.Report_AttVO;
import kr.or.ddit.vo.WorkLog_AttatchVO;

public class ReportDownloadView extends AbstractView{
	@Inject
	WebApplicationContext context;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Report_AttVO attatch = (Report_AttVO) model.get("attatch");
		
		response.setHeader("Content-Length", attatch.getFile_size()+"");
		// 파일명과 관련된 헤더 설정
		String filename = attatch.getOrg_name();
//		filename = URLEncoder.encode(filename, "UTF-8");
		filename = new String(filename.getBytes(), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");
		String savename = attatch.getSave_name();
		Resource resource = context.getResource(attatchPath+"/"+savename);
		try(
			OutputStream os = response.getOutputStream();
			InputStream is = resource.getInputStream();
		){
			IOUtils.copy(is, os);
		}
		
	}
}
