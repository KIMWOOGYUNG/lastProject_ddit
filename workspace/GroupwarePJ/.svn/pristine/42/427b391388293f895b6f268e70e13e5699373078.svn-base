package kr.or.ddit.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardFileUploadController {
	@Inject
	WebApplicationContext context;
	ServletContext application;
	@Value("{#appInto.imagePath")
	String imagePath;
	
	@Value("{#appInto.imagePath")
	File saveFolder;
	
	@PostConstruct
	public void init() {
		application = context.getServletContext();
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
	}
	
	@PostMapping(value="/board/image", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> imageUpload(@RequestPart(required = true) MultipartFile upload) throws IllegalStateException, IOException {
		Map<String, Object> result = new HashMap<>();
		if(!upload.isEmpty()) {
			String savename = UUID.randomUUID().toString();
			upload.transferTo(new File(saveFolder, savename));
			String filename = upload.getOriginalFilename();
			int uploaded = 1;
			String url = application.getContextPath() + imagePath + "/" + savename;
			result.put("fileName", filename);
			result.put("uploaded", uploaded);
			result.put("url", url);
		} else {
			String message = "이미지가 없음.";
			int number = 400;
			Map<String, Object> error = new HashMap<>();
			error.put("number", number);
			error.put("message", message);
			error.put("error", error);
		}
		return result;
	}
	
}
