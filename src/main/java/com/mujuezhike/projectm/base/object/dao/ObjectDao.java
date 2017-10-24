package com.mujuezhike.projectm.base.object.dao;

import java.util.List;
import java.util.Map;

public interface ObjectDao {
	
	public Map<String,Object> getById(String tablename,String id);
	
	public List<Map<String,Object>> listByBean(String tablename,Map<String,Object> inmap);
	
	public Map<String,Object> add(String tablename,Map<String,Object> beanmap);

}
