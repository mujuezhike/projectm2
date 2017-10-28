package com.mujuezhike.projectm.base.object.service;

import java.util.List;
import java.util.Map;

public interface ObjectService{
	
	Map<String,Object> head(String tablename);
	
	Map<String,Object> headByTableId(String tableid);
	
	Map<String,Object> headAdd(Map<String, Object> beanmap);
	
	//@单层数据
	Map<String,Object> getOri(String tablename,String id);
	
	//@双层数据
	Map<String,Object> get(String tablename,String id);
	
	//@Max层数据
	Map<String, Object> getUlti(String tablename, String id, Map<String, Object> ultiMap);
	
	
	Map<String,Object> getByTableId(String tableid,String id);
	
	//@单层数据
	List<Map<String,Object>> listOri(String tablename,Map<String,Object> beanmap);
	
	//@双层数据
	List<Map<String,Object>> list(String tablename,Map<String,Object> beanmap);
	
	//@Max层数据
	List<Map<String, Object>> listUlti(String tableName, Map<String, Object> beanmap, Map<String, Object> ultiMap);
	
	/**
	 *  @20171019 
	 *  describe : 获取数据的关联信息   (单层 => 双层)
	 *  param    : map     对象的数据
	 *             headmap 对象的结构
	 *         
	 *  return   : 读取关联数据  并改动对象map 返回map 
	 */
	Map<String,Object> getAddtion(Map<String,Object> map,Map<String,Object> headmap);
	
	/**
	 *  @20171026 
	 *  describe : 获取数据的关联信息   (单层 => Max层)
	 *  param    : map     对象的数据
	 *             headmap 对象的结构
	 *         
	 *  return   : 读取关联数据  并改动对象map 返回map 
	 */
	Map<String,Object> getAddtionUlti(Map<String,Object> map ,Map<String,Object> headmap , Map<String, Object> ultiMap);
	
	Map<String,Object> add(String tablename,Map<String,Object> beanmap);
	
    List<Map<String,Object>> addlist(String tablename,List<Map<String,Object>> beanmaplist);

	

	

}
