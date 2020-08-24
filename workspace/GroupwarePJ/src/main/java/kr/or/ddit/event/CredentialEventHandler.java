package kr.or.ddit.event;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import kr.or.ddit.vo.EmployeeVO;

@Component
public class CredentialEventHandler {
	@Value("#{appInfo.datastore}")
	public String dataStore;
	 
	private  java.io.File DATA_STORE_DIR;
	private  FileDataStoreFactory dataStoreFactory;
	private  HttpTransport httpTransport;
    private  final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private  final List<String> SCOPES = Arrays.asList(
	        "https://mail.google.com/",
	        "https://www.googleapis.com/auth/userinfo.profile",
	        "https://www.googleapis.com/auth/gmail.modify",
	        "https://www.googleapis.com/auth/gmail.compose",
	        "https://www.googleapis.com/auth/gmail.readonly",
	        "https://www.googleapis.com/auth/gmail.metadata");
	private GoogleClientSecrets clientSecrets;
	
	@Async
	@EventListener(classes = CredentialEvent.class)
	public void checkCredential(CredentialEvent event) throws IOException {
		HttpSession session  = event.getHttpSession();
		DATA_STORE_DIR = new java.io.File(dataStore);
		dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
		EmployeeVO vo = (EmployeeVO)session.getAttribute("authUser");
		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		        httpTransport, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(
		        dataStoreFactory).setAccessType("offline").build();
		
		Credential credential = flow.loadCredential(vo.getEmp_code());
		session.setAttribute("credential", credential);
	}
}
