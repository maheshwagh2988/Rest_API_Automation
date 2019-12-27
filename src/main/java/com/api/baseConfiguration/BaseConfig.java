package com.api.baseConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
//List down all list of Status code and will use it in TestCase to validate Expected and Actual code	

//2xx Success	
public int RESPONCE_STATUS_CODE_200=200;//OK
public int RESPONCE_STATUS_CODE_201=201;//Created
public int RESPONCE_STATUS_CODE_202=202;//Accept
public int RESPONCE_STATUS_CODE_203=203;//No authoritative  information 
public int RESPONCE_STATUS_CODE_204=204;//No content

//3xx Redirection Error 
public int RESPONCE_STATUS_CODE_300=300;//multiple Choice
public int RESPONCE_STATUS_CODE_301=301;//Move permanently 
public int RESPONCE_STATUS_CODE_302=302;//Found 
public int RESPONCE_STATUS_CODE_304=304;//not modified
public int RESPONCE_STATUS_CODE_307=307;//Temp Redirect

//4xx Application/Client Error 
public int RESPONCE_STATUS_CODE_400=400;//Bad Request
public int RESPONCE_STATUS_CODE_401=401;//unauthorized
public int RESPONCE_STATUS_CODE_402=402;//Payment Req
public int RESPONCE_STATUS_CODE_403=403;//URL forbidden
public int RESPONCE_STATUS_CODE_404=404;//Not Found
public int RESPONCE_STATUS_CODE_408=408;//Req Time Out

//5xx Server Error
public int RESPONCE_STATUS_CODE_500=500;//Internal Server Error
public int RESPONCE_STATUS_CODE_501=501;//Not Implemented
public int RESPONCE_STATUS_CODE_502=502;//Bad GateWay
public int RESPONCE_STATUS_CODE_503=503;//Service Unavailable
public int RESPONCE_STATUS_CODE_504=504;//GateWay TimeOut

	public Properties prop;
	
	public BaseConfig(){
		
		try {
			prop = new Properties();
			FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/api/config/config.properties");
			prop.load(fn);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}

}
