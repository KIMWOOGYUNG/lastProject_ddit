package kr.or.ddit.community.view;

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

import kr.or.ddit.vo.Board_AttatchVO;

public class DownloadView extends AbstractView{
	@Inject
	WebApplicationContext context;
	
	@Value("#{appInfo.attatchPath}")
	String attatchPath;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Board_AttatchVO attatch = (Board_AttatchVO)model.get("attatch");
		
		response.setHeader("Content-Length", attatch.getFile_size()+"");
		
		String filename = attatch.getOrg_name();
		filename = new String(filename.getBytes(), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");
		String savename = attatch.getSave_name();
		Resource resource = context.getResource(attatchPath + "/" + savename);
		try(
			OutputStream os = response.getOutputStream();
			InputStream is = resource.getInputStream();
		){
			IOUtils.copy(is, os);
		}
	}

}