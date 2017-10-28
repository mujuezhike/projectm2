package com.mujuezhike.projectm.base.object.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mujuezhike.projectm.base.cache.CLKeyGenerator;
import com.mujuezhike.projectm.base.cache.Cache;
import com.mujuezhike.projectm.base.object.dao.ObjectDao;
import com.mujuezhike.projectm.base.object.enums.TColumnColumnEnum;
import com.mujuezhike.projectm.base.object.service.ObjectService;

@Component
public class ObjectServiceImpl implements ObjectService{
	
	@Autowired
	private ObjectDao objectDao; 
	
	@Autowired
	private Cache cache;
	
	private static final String ORITABLE = "s_object_table";
	private static final String ORICOLUMN = "s_object_table_column";
	
	@Override
	public Map<String, Object> head(String tablename) {
		
		String key = CLKeyGenerator.getHeadKey(tablename);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> cmap = cache.getObject(key, Map.class);
		if(cmap!=null) {
			return cmap;
		}
		
		//表信息
		Map<String, Object> bmap = new HashMap<String, Object>();
		bmap.put("table_name", "_e_"+tablename);
		bmap.put("limit", "1");
		List<Map<String, Object>> list = objectDao.listByBean(ORITABLE, bmap);
		Map<String, Object> map = list.get(0);
		
		//表字段信息
		Map<String, Object> inmap = new HashMap<String, Object>();
		inmap.put("fid", "_e_"+map.get("id"));
		List<Map<String, Object>> ilist = objectDao.listByBean(ORICOLUMN, inmap);
		map.put("_table_columns", ilist);
		
		cache.set(key, map);
		
		return map;
	}

	@Override
	public Map<String, Object> headByTableId(String tableid) {
		//表信息
		Map<String, Object> map = getOri(ORITABLE, tableid);
		
		//表字段信息
		Map<String, Object> inmap = new HashMap<String, Object>();
		inmap.put("fid", "_e_"+tableid);
		List<Map<String, Object>> list = objectDao.listByBean(ORICOLUMN, inmap);
		map.put("_table_columns", list);
		return map;
	}
	
	@Override
	public Map<String, Object> headAdd(Map<String, Object> beanmap) {
		//TODO
		//插入 s_object_table
	    this.add(ORITABLE,beanmap);
		//插入 s_object_column_table
		
		//建表    create table
		return beanmap;
	}

	@Override
	public Map<String, Object> getOri(String tablename, String id) {
		//数据信息
		Map<String, Object> map = objectDao.getById(tablename, id);
		return map;
	}
	
	@Override
	public Map<String, Object> get(String tablename, String id) {
		
		//数据信息
		Map<String, Object> map = objectDao.getById(tablename, id);
		
		if(map!=null) {
			//表头信息
			Map<String, Object> headmap = head(tablename);
			
			map = getAddtion(map,headmap);
		}
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getUlti(String tablename, String id, Map<String, Object> ultiMap) {
		
		String ultiKey = "ulti_"+ tablename +"_"+ id;
		
		if(ultiMap == null) {
			ultiMap = new HashMap<String, Object>();
		}
		
		Map<String, Object>	map = (Map<String, Object>) ultiMap.get(ultiKey);
		
		if(map != null) {
			return map;
		}
		//数据信息
		map = objectDao.getById(tablename, id);
				
		ultiMap.put(ultiKey, map);
		
		if(map!=null) {
					//表头信息
			Map<String, Object> headmap = head(tablename);
					
			map = getAddtionUlti(map,headmap,ultiMap);
		
		}
				
		return map;
	}
	
	/**
	 *  @20171019 
	 *  describe : 获取数据的关联信息   (单层 => 双层)
	 *  param    : map     对象的数据
	 *             headmap 对象的结构
	 *         
	 *  return   : 读取关联数据  并改动对象map 返回map 
	 */
	@Override
	public Map<String, Object> getAddtion(Map<String, Object> map, Map<String, Object> headmap) {
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> columnlist = (List<Map<String, Object>>)headmap.get("_table_columns");
		
		for(Map<String, Object> column:columnlist) {
			
			Integer columnType = Integer.parseInt(String.valueOf(column.get("column_type")));
			//各种关联情况
			if(columnType == TColumnColumnEnum.KEYVALUE.num()) {
				//需要变成只有键值对
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				Object columnValue = map.get(columnName);
				if(columnValue!=null) {
					
					String columnValueStr = columnValue.toString();
					Map<String, Object> childmap = getOri(relationTableName, columnValueStr);
					map.put("_"+columnName, childmap);
				}
			}
			
			if(columnType == TColumnColumnEnum.CHILD.num()) {
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				Object columnValue = map.get(columnName);
				if(columnValue!=null) {
					
					String columnValueStr = columnValue.toString();
					Map<String, Object> childmap = getOri(relationTableName, columnValueStr);
					map.put("_"+columnName, childmap);
				}
			}
			
			if(columnType == TColumnColumnEnum.LIST.num()) {
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				String relationColumnName = column.get("relation_column_name").toString();
				
				Map<String, Object> inmap = new HashMap<String, Object>();
				inmap.put(relationColumnName, "_e_"+map.get("id").toString());
				List<Map<String, Object>> childlist = list(relationTableName, inmap);
				map.put(columnName, childlist);
			}
		}
		
		return map;
	}

	@Override
	public Map<String, Object> getAddtionUlti(Map<String, Object> map, Map<String, Object> headmap,
			Map<String, Object> ultiMap) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> columnlist = (List<Map<String, Object>>)headmap.get("_table_columns");
		
		for(Map<String, Object> column:columnlist) {
			
			Integer columnType = Integer.parseInt(String.valueOf(column.get("column_type")));
			//各种关联情况
			if(columnType == TColumnColumnEnum.KEYVALUE.num()) {
				//需要变成只有键值对
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				Object columnValue = map.get(columnName);
				if(columnValue!=null) {
					
					String columnValueStr = columnValue.toString();
					Map<String, Object> childmap = getUlti(relationTableName, columnValueStr,ultiMap);
					map.put("_"+columnName, childmap);
				}
			}
			
			if(columnType == TColumnColumnEnum.CHILD.num()) {
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				Object columnValue = map.get(columnName);
				if(columnValue!=null) {
					
					String columnValueStr = columnValue.toString();
					Map<String, Object> childmap = getUlti(relationTableName, columnValueStr,ultiMap);
					map.put("_"+columnName, childmap);
				}
			}
			
			if(columnType == TColumnColumnEnum.LIST.num()) {
				String columnName = column.get("column_name").toString();
				String relationTableName = column.get("relation_table_name").toString();
				String relationColumnName = column.get("relation_column_name").toString();
				
				Map<String, Object> inmap = new HashMap<String, Object>();
				inmap.put(relationColumnName, "_e_"+map.get("id").toString());
				List<Map<String, Object>> childlist = listUlti(relationTableName, inmap,ultiMap);
				map.put(columnName, childlist);
			}
		}
		
		return map;
	}
	
	@Override
	public Map<String, Object> getByTableId(String tableid, String id) {
		//数据信息
		Map<String, Object> map = objectDao.getById(ORITABLE, tableid);
		
		String tableName = map.get("table_name").toString();
		
		return get(tableName,id);
	}

	@Override
	public List<Map<String, Object>> listOri(String tablename, Map<String, Object> beanmap) {
		
		List<Map<String, Object>> list = objectDao.listByBean(tablename, beanmap);
		
		return list;
		
	}
	
	@Override
	public List<Map<String, Object>> list(String tablename, Map<String, Object> beanmap) {
		
		List<Map<String, Object>> list = objectDao.listByBean(tablename, beanmap);
		
		if(list!=null && list.size()>0) {
			//表头信息
			Map<String, Object> headmap = head(tablename);
			
			for(Map<String, Object> map:list) {
				
				map = getAddtion(map,headmap);
				
			}
		}
				
		return list;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> listUlti(String tablename, Map<String, Object> beanmap, Map<String, Object> ultiMap) {
		
		String ultiListKey = "ultilist_"+ tablename +"_[maphash]"+ beanmap.hashCode();
		
		if(ultiMap == null) {
			ultiMap = new HashMap<String, Object>();
		}
		
		List<Map<String, Object>> list = (List<Map<String, Object>>) ultiMap.get(ultiListKey);
		
		if(list != null) {
			return list;
		}
		
		list = objectDao.listByBean(tablename, beanmap);
		
		ultiMap.put(ultiListKey, list);
		
		if(list!=null && list.size()>0) {
			//表头信息
			Map<String, Object> headmap = head(tablename);
			
			for(Map<String, Object> map:list) {
				
//				String id = (String)map.get("id");
//				
//				String ultiKey = "ulti_"+ tablename +"_"+ id;
//				
//				Map<String, Object>	cmap = (Map<String, Object>) ultiMap.get(ultiKey);
//				
//				if(cmap != null) {
//					
//					map = cmap;
//					
//				}else {
//					
//					ultiMap.put(ultiKey, map);
					
					map = getAddtionUlti(map,headmap,ultiMap);
					
//				}
				
			}
		}
				
		return list;
		
	}

	@Override
	public Map<String, Object> add(String tablename, Map<String, Object> beanmap) {
		return objectDao.add(tablename, beanmap);
	}

	@Override
	public List<Map<String, Object>> addlist(String tablename, List<Map<String, Object>> beanmaplist) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
