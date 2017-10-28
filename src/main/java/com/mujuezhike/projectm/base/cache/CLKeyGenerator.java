package com.mujuezhike.projectm.base.cache;

public class CLKeyGenerator {
	
	public static String getObjectIdKey(String tablename, String id) {
		
		return "o_"+tablename+"_"+id;
		
	}
	
	public static String getHeadKey(String tablename) {
		
		return "h_"+tablename;
		
	}

}
