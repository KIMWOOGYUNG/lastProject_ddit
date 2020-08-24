package kr.or.ddit.project.view;

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

import kr.or.ddit.vo.Task_AttVO;

public class TaskDownloadView extends AbstractView{

	@Inject
	WebApplicationContext context;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Task_AttVO attatch = (Task_AttVO) model.get("attatch");
		
		response.setHeader("Content-Length", attatch.getFile_size()+"");
		//파일명과 관련된 헤더 설정
		String filename = attatch.getOrg_name();
//		filename = URLEncoder.encode(filename, "UTF-8");
		filename = new String(filename.getBytes(), "ISO-8859-1");	//1바이트 단위로 쪼개서 보내면 브라우저가 조합한다. (UTF-8로 나옴)
		
		response.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");	//공백이 파일명에 포함된 경우때문에 필요
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
