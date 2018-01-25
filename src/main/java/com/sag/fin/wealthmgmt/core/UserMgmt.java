package com.sag.fin.wealthmgmt.core;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sag.fin.wealthmgmt.model.*;
import com.sag.fin.wealthmgmt.util.*;

import spark.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class UserMgmt {
	private static UserMgmt instance = null;
	private static HashMap<String,User> list = new HashMap<String, User>();
	   protected UserMgmt() {
	      // Exists only to defeat instantiation.
	   }
	   public static UserMgmt getInstance() {
	      if(instance == null) {
	         instance = new UserMgmt();
	         instance.loadData();
	      }
	      
	      return instance;
	   }
	   
	   public void loadData(){
		   list.put("AF98405", new User("Sam", "Matthew", "4 Cornell Dr", "Jacksonville", "FL","USA", "32003"));
		   list.put("AC8424D", new User("Sara","Johnson","6 Hollywood Dr","LA","CA","USA","90001"));
	   }
	   public String createUser(Request request){
		   User usr = jsontoObj(request.body());
		   if ( usr.getFirstName().isEmpty() ){
			   ApiError err = new ApiError();
			   err.setCode(945);
			   err.setMessage("Mandatory field First Name missing");
			   return jsonHelper.objtojson(err);
		   }
		   String id = random.randomID();
		   list.put(id, usr);
		   ApiResponse resp = new ApiResponse("Success", "User with ID "+id+" created.", "",usr);
		   return jsonHelper.objtojson(resp);
	   }
	   
	   private User jsontoObj(String json){
		   		User obj = null;
		        try {
		        	ObjectMapper mapper = new ObjectMapper();
		        	obj = mapper.readValue(json, User.class);
		        } catch (IOException e){
		        	e.printStackTrace(System.out);
		        	throw new RuntimeException("IOException from a StringWriter?");
		        }
	   		return obj;
	   }
	   	   
	   public String getUser(Request request){
		   String id = request.params("id");
		   User usr = list.get(id);
		   if ( usr == null ){
			   ApiError err = new ApiError();
			   err.setCode(983);
			   err.setMessage("User Not found");
			   return jsonHelper.objtojson(err);
		   }
		   return jsonHelper.objtojson(usr);
	   }
}
