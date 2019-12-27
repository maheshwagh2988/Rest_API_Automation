package com.api.testGET;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.baseConfiguration.BaseConfig;
import com.api.client.GETMethod;
import com.api.utility.JsonParseUtility;

public class TestGetMethod extends BaseConfig {
	BaseConfig base;
	String appurl;
	String appResoiceURL;
	String url;
	CloseableHttpResponse httpresponce;
	GETMethod restClient;
	JSONObject responsejson;
	
	@BeforeMethod
	public void setUP() throws ClientProtocolException, IOException{
		 base = new BaseConfig();
		 appurl =prop.getProperty("URL");
		 appResoiceURL =prop.getProperty("ServiceURL");
		 url= appurl+appResoiceURL;
		
	}
	@Test
	public void test() throws ClientProtocolException, IOException{
		

		restClient = new GETMethod();
		httpresponce=restClient.getApi(url);

		 //a.Get Status Code
		 int StatusCode=httpresponce.getStatusLine().getStatusCode();
		 System.out.println("Status Code is-->"+StatusCode);
		 
		 
		 
		Assert.assertEquals(StatusCode, RESPONCE_STATUS_CODE_200,"Status code does not match as expected"); 
		 
		 //b.Get JSON String
		 String ResponceString=EntityUtils.toString(httpresponce.getEntity(), "UTF-8");
		 
		 JSONObject responseJson = new JSONObject(ResponceString);
		 System.out.println("Json Responce-->"+responseJson);
		 
		 	//single value assertion:
			//per_page:
			String perPageValue = JsonParseUtility.getValueByJPath(responseJson, "/per_page");
			System.out.println("value of per page is-->"+ perPageValue);
			Assert.assertEquals(Integer.parseInt(perPageValue), 6);
			
			//total:
			String totalValue = JsonParseUtility.getValueByJPath(responseJson, "/total");
			System.out.println("value of total is-->"+ totalValue);		
			Assert.assertEquals(Integer.parseInt(totalValue), 12);

			//get the value from JSON ARRAY:
			String lastName = JsonParseUtility.getValueByJPath(responseJson, "/data[0]/last_name");
			String id = JsonParseUtility.getValueByJPath(responseJson, "/data[0]/id");
			String avatar = JsonParseUtility.getValueByJPath(responseJson, "/data[0]/avatar");
			String firstName = JsonParseUtility.getValueByJPath(responseJson, "/data[0]/first_name");

			System.out.println(lastName);
			System.out.println(id);
			System.out.println(avatar);
			System.out.println(firstName);
		 
		 //c.Get All Header information 
		 org.apache.http.Header[] AllHeaderArray =httpresponce.getAllHeaders();
		 
		 HashMap<String, String> headerinformation= new HashMap<String,String>();
		 for(org.apache.http.Header headinfor:AllHeaderArray){
			 headerinformation.put(headinfor.getName(), headinfor.getValue());
		 }
		 System.out.println("Header information is--->"+headerinformation);
		 	
		
		
		
	}
	

}
