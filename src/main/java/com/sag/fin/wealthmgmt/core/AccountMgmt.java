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

public class AccountMgmt {
	private static AccountMgmt instance = null;
	private static HashMap<String,Account> list = new HashMap<String, Account>();
	   protected AccountMgmt() {
	      // Exists only to defeat instantiation.
	   }
	   public static AccountMgmt getInstance() {
	      if(instance == null) {
	         instance = new AccountMgmt();
	         instance.loadData();
	      }
	      return instance;
	   }

	   private void loadData(){
		   Account acct = new Account("AF98405","94452345", "401K", 43590, 33450);
		   list.put("94452345", acct);
		   Holding hld1 = new Holding("Vabguard Wellington Admiral VWENX", 40, 49951 );
		   Holding hld2 = new Holding("Core Bond Enhanced Index/PGIM Fund", 60, 74927 );
		   Holding[] hld = { hld1,hld2};
		   acct = new Account("AC8424D","84920324", "403", 124879, 124879,hld);
		   list.put("84920324", acct);
	   }
	   
	   
	   public String createAccount(Request request){
		   Account acct = jsontoObj(request.body());
		   if ( acct.getUserID().isEmpty() ){
			   ApiError err = new ApiError();
			   err.setCode(438);
			   err.setMessage("Mandatory field User ID missing");
			   return jsonHelper.objtojson(err);
		   }
		   String id = random.randomID();
		   list.put(id, acct);
		   ApiResponse resp = new ApiResponse("Success", "Account with ID "+id+" created.", "",acct);
		   return jsonHelper.objtojson(resp);
	   }
	   
	   private Account jsontoObj(String json){
		   		Account obj = null;
		        try {
		        	ObjectMapper mapper = new ObjectMapper();
		        	obj = mapper.readValue(json, Account.class);
		        } catch (IOException e){
		        	e.printStackTrace(System.out);
		        	throw new RuntimeException("IOException from a StringWriter?");
		        }
	   		return obj;
	   }
	   	   
	   public String getAccountDetail(Request request){
		   String id = request.params("id");
		   Account acct = list.get(id);
		   if ( acct == null ){
			   ApiError err = new ApiError();
			   err.setCode(495);
			   err.setMessage("Account Not found");
			   return jsonHelper.objtojson(err);
		   }
		   return jsonHelper.objtojson(acct);
	   }
	   public String getAccountSummary(Request request){
		   String id = request.params("id");
		   Account acct = list.get(id);
		   if ( acct == null ){
			   ApiError err = new ApiError();
			   err.setCode(495);
			   err.setMessage("Account Not found");
			   return jsonHelper.objtojson(err);
		   }
		   acct.setPortfolio(null);
		   return jsonHelper.objtojson(acct);
	   }

}
