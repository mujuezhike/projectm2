package com.mujuezhike.projectm.base.cache;

public class CLKeyGenerator {
	
	public static String getObjectIdKey(String tablename, String id) {
		
		return "o_"+tablename+"_"+id;
		
	}

}
