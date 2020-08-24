/*
 * Copyright (c) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package kr.or.ddit.event.controller;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Tokeninfo;

import kr.or.ddit.event.dao.IOauthDAO;
import kr.or.ddit.vo.EmployeeVO;


@Controller
@RequestMapping("/oauth")
public class OAuthController {

	@Inject
	IOauthDAO dao;
	
	@Value("#{appInfo.datastore}")
	public String dataStore;
	
  /**
   * Be sure to specify the name of your application. If the application name is {@code null} or
   * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
   */
  private  final String APPLICATION_NAME = "GroupWare";

  /** Directory to store user credentials. */
  private java.io.File DATA_STORE_DIR;
  
  /**
   * Global instance of the {@link DataStoreFactory}. The best practice is to make it a single
   * globally shared instance across your application.
   */
  private FileDataStoreFactory dataStoreFactory;

  /** Global instance of the HTTP transport. */
  private HttpTransport httpTransport;

  /** Global instance of the JSON factory. */
  private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  /** OAuth 2.0 scopes. */
  private final List<String> SCOPES = Arrays.asList(
        "https://mail.google.com/",
        "https://www.googleapis.com/auth/userinfo.profile",
        "https://www.googleapis.com/auth/gmail.modify",
        "https://www.googleapis.com/auth/gmail.compose",
        "https://www.googleapis.com/auth/gmail.readonly",
        "https://www.googleapis.com/auth/gmail.metadata");

  
  private Oauth2 oauth2;
  private GoogleClientSecrets clientSecrets;

  /** Authorizes the installed application to access user's protected data. */
  @GetMapping
  public RedirectView authorize(HttpSession session) throws Exception {
	  DATA_STORE_DIR = new java.io.File(dataStore);
	dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
	httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
        new InputStreamReader(OAuthController.class.getResourceAsStream("/client_secrets.json")));
    if (clientSecrets.getDetails().getClientId().startsWith("Enter")
        || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
      System.out.println("Enter Client ID and Secret from https://code.google.com/apis/console/ "
          + "into oauth2-cmdline-sample/src/main/resources/client_secrets.json");
      System.exit(1);
    }

    GoogleAuthorizationCodeFlow	flow = new GoogleAuthorizationCodeFlow.Builder(
    		httpTransport, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(dataStoreFactory).setAccessType("offline").build();
         
    RedirectView view = new RedirectView();
    	String redirectUri = "http://localhost/GroupwarePJ/oauth/check";
	    AuthorizationCodeRequestUrl authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUri);
	    view = new RedirectView(authorizationUrl.build());  
	    
	    Credential credential = (Credential) session.getAttribute("credential");
	    if (credential != null
	          && (credential.getRefreshToken() != null || 
	              credential.getExpiresInSeconds() == null || 
	              credential.getExpiresInSeconds() > 60)) {
	    	  view.setUrl("http://localhost/GroupwarePJ/mail/entiremailbox");
	    }
	    
    return view;
  }

  @GetMapping("/check")
	public String main(@RequestParam String code,HttpSession session) throws Exception {
	  EmployeeVO empVO = (EmployeeVO)session.getAttribute("authUser");
	  Credential credential = (Credential) session.getAttribute("credential");
	  
	  String emp_code = empVO.getEmp_code();
	   
	  if(credential == null) {
		  DATA_STORE_DIR = new java.io.File(dataStore);
		  dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
		  httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
					new InputStreamReader(OAuthController.class.getResourceAsStream("/client_secrets.json")));
			 GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
			    		httpTransport, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(dataStoreFactory).setAccessType("offline").build();
			
			String redirectUri = "http://localhost/GroupwarePJ/oauth/check";
			TokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
			credential = flow.createAndStoreCredential(response, emp_code);
			
			Map<String, String> data = new HashMap<String, String>();
			data.put("access_code", response.getAccessToken());
			data.put("refresh_code", response.getRefreshToken());
			data.put("emp_code",emp_code);
			
			dao.modifyCode(data);
	  }else {
		  credential.refreshToken();
		  Map<String, String> data = new HashMap<String, String>();
		  data.put("access_code", credential.getAccessToken());
		  data.put("emp_code",emp_code);
		  dao.modifyCode(data);
		  
	  }

		
		return "redirect:/mail/entiremailbox";
	}

  

}
