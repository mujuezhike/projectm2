package com.mujuezhike.projectm.base.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;

public class StringUtil {
	
	/** 判断字符串是否是数字   **/
	public static boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("-[0-9]+(.[0-9]+)?|[0-9]+(.[0-9]+)?"); 
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
		   return false; 
		} 
		return true; 
	}
	
	/** sqlbean   **/
	public static String sqlBean(String str){ 
		String strpt = "";
		if(StringUtil.isNumeric(str)) {
			strpt = str;
		}else {
			strpt = "'"+ str +"'";
		}
		return strpt;
	}
	
	public static String sqlBracketsSqlBean(List<String> str){ 
		if(str==null || str.size() == 0) {
			
			return "()";
			
		}else if(str.size() == 1){
			
			String sqlBracketsBean = "( " + sqlBean(str.get(0)) + " )";
			
			return sqlBracketsBean;
			
		}else {
			
			String sqlBracketsBean = "( " + sqlBean(str.get(0));

			for(int i=1;i<str.size();i++) {
				sqlBracketsBean += " , " + sqlBean(str.get(i));
			}
			
			sqlBracketsBean += " )";
			
			return sqlBracketsBean;
			
		}
	}
	
	public static String sqlBracketsBean(List<String> str){ 
		if(str==null || str.size() == 0) {
			
			return "()";
			
		}else if(str.size() == 1){
			
			String sqlBracketsBean = "( " + str.get(0) + " )";
			
			return sqlBracketsBean;
			
		}else {
			
			String sqlBracketsBean = "( " + str.get(0);

			for(int i=1;i<str.size();i++) {
				sqlBracketsBean += " , " + str.get(i);
			}
			
			sqlBracketsBean += " )";
			
			return sqlBracketsBean;
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		System.out.println(isNumeric("4"));
		System.out.println(isNumeric("433"));
		System.out.println(isNumeric("44324"));
		System.out.println(isNumeric("33.232"));
		System.out.println(isNumeric("-33.232"));
		System.out.println(isNumeric("-33.2321ss32"));
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Object> list =new ArrayList<Object>();
		list.add("sadass");
		list.add("12121");
		list.add(null);
		list.add("12123");
		list.add("12124");
		map.put("list", list);
		
		String ss = JSON.toJSONString(map);
		
		map = (Map<String,Object>)JSON.parse(ss);
		
		List<Object> ee = (List<Object>)map.get("list");
		System.out.println(ee.get(1));
		
		
	}

}
