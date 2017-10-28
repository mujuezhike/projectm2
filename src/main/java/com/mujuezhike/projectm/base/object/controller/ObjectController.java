package com.mujuezhike.projectm.base.object.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.mujuezhike.projectm.base.object.service.ObjectService;
import com.mujuezhike.projectm.base.util.StringUtil;

/**
 * ObjectController 通用控制类
 * @author mujuezhike
 * @date   20170927
 */
@RestController
public class ObjectController {
	
	   @Autowired
	   private ObjectService objectService;
	   
	   //private static final String ORITABLE = "s_object_table";
	   //private static final String ORICOLUMN = "s_object_table_column";
	
	   /** 获取表元信息  **/
	   @RequestMapping(value = "/o/h/{TABLENAME&TABLEID}")
	   public String head( HttpServletRequest request
			              ,HttpServletResponse response
			 			  ,@PathVariable("TABLENAME&TABLEID") String tableIdOrtableName){
		   Map<String,Object> map = null;
		   if(StringUtil.isNumeric(tableIdOrtableName)) {
			   /** TABLEID **/
			   map = objectService.headByTableId(tableIdOrtableName);
		   }else {
			   /** TABLENAME **/
			   map = objectService.head(tableIdOrtableName);
		   }
		   
		   return JSON.toJSONString(map);
	   }
	
	   /** 添加表元信息  **/
	   /**
	    * json 测试数据
	    * {"name":"fefewfwe","structure_type":"1","_table_columns":[{"name":"fewfew","column_type":"2"},{"name":"fefew","column_type":"2"}]}
	    */
	   @RequestMapping(value = "/o/ha")
	   public String headadd( HttpServletRequest request
			              	 ,HttpServletResponse response
			              	 ,@RequestBody Map<String,Object> map){

		   objectService.headAdd(map);

		   return JSON.toJSONString(map);
	   }
	
	    /** 获取列表信息 **/
		/**
		 * @author mujuezhike
		 * @date   20170927
		 * 固定  搜索参数
		 * ?limit=10
		 * ?offset=10
		 * ?page=2           *
		 * ?perpage=100      *
		 * ?sortby=name
		 * ?order=asc
		 * 参数  搜索参数  都以 and 关联
		 * ?oid=_e_312312      oid =  312312
		 * ?oid=_gt_1233       oid >  1233
		 * ?oid=_lt_1233       oid <  1233
		 * ?oid=_n_1233        oid != 1233
		 * ?oid=_l_1233        oid LIKE '%1233%'
		 * ?ned.emmd=_e_312312 ned.emmd = 312312 //关联表  *
		 */
		@RequestMapping(value = "/o/lo/{TABLENAME}")
		public String listori( HttpServletRequest request
				              ,HttpServletResponse response
				 			  ,@PathVariable("TABLENAME") String tableName){
			Map<String,String[]> pmap = request.getParameterMap();
			Map<String,Object> beanmap = new HashMap<String,Object>();
			
			for(String key:pmap.keySet()) {
				
				beanmap.put(key,pmap.get(key)[0]);
				//System.out.println(key+":"+pmap.get(key)[0]);
			}
			
			List<Map<String,Object>> list = objectService.listOri(tableName, beanmap);
			
			return JSON.toJSONString(list);
		}
	   
		/** 获取列表信息 **/
		/**
		 * @author mujuezhike
		 * @date   20170927
		 * 固定  搜索参数
		 * ?limit=10
		 * ?offset=10
		 * ?page=2           *
		 * ?perpage=100      *
		 * ?sortby=name
		 * ?order=asc
		 * 参数  搜索参数  都以 and 关联
		 * ?oid=_e_312312      oid =  312312
		 * ?oid=_gt_1233       oid >  1233
		 * ?oid=_lt_1233       oid <  1233
		 * ?oid=_n_1233        oid != 1233
		 * ?oid=_l_1233        oid LIKE '%1233%'
		 * ?ned.emmd=_e_312312 ned.emmd = 312312 //关联表  *
		 */
		@RequestMapping(value = "/o/l/{TABLENAME}")
		public String list(    HttpServletRequest request
				              ,HttpServletResponse response
				 			  ,@PathVariable("TABLENAME") String tableName){
			Map<String,String[]> pmap = request.getParameterMap();
			Map<String,Object> beanmap = new HashMap<String,Object>();
			
			for(String key:pmap.keySet()) {				
				beanmap.put(key,pmap.get(key)[0]);
				//System.out.println(key+":"+pmap.get(key)[0]);
			}
			
			List<Map<String,Object>> list = objectService.list(tableName, beanmap);
			
			return JSON.toJSONString(list);
		}
		
		/** 获取列表信息 **/
		/**
		 * @author mujuezhike
		 * @date   20170927
		 * 固定  搜索参数
		 * ?limit=10
		 * ?offset=10
		 * ?page=2           *
		 * ?perpage=100      *
		 * ?sortby=name
		 * ?order=asc
		 * 参数  搜索参数  都以 and 关联
		 * ?oid=_e_312312      oid =  312312
		 * ?oid=_gt_1233       oid >  1233
		 * ?oid=_lt_1233       oid <  1233
		 * ?oid=_n_1233        oid != 1233
		 * ?oid=_l_1233        oid LIKE '%1233%'
		 * ?ned.emmd=_e_312312 ned.emmd = 312312 //关联表  *
		 */
		@RequestMapping(value = "/o/lu/{TABLENAME}")
		public String listUlti(    HttpServletRequest request
				              ,HttpServletResponse response
				 			  ,@PathVariable("TABLENAME") String tableName){
			Map<String,String[]> pmap = request.getParameterMap();
			Map<String,Object> beanmap = new HashMap<String,Object>();
			
			for(String key:pmap.keySet()) {				
				beanmap.put(key,pmap.get(key)[0]);
				//System.out.println(key+":"+pmap.get(key)[0]);
			}
			
			List<Map<String,Object>> list = objectService.listUlti(tableName, beanmap,null);
			
			return JSON.toJSONString(list);
		}
	
		/** 获取单条信息  单层**/
		@RequestMapping(value = "/o/go/{TABLENAME}/{ID}")
	    public String getOri(     HttpServletRequest request
	            		      ,HttpServletResponse response
	    		              ,@PathVariable("ID") String id
	    		              ,@PathVariable("TABLENAME") String tableName){
			Map<String, Object> map = objectService.getOri(tableName, id);
			return JSON.toJSONString(map);
	    }
		
	 	/** 获取单条信息  两层**/
		@RequestMapping(value = "/o/g/{TABLENAME}/{ID}")
	    public String get(     HttpServletRequest request
	            		      ,HttpServletResponse response
	    		              ,@PathVariable("ID") String id
	    		              ,@PathVariable("TABLENAME") String tableName){
			Map<String, Object> map = objectService.get(tableName, id);
			return JSON.toJSONString(map);
	    }
		
		/** 获取单条信息  max层 **/
		@RequestMapping(value = "/o/gu/{TABLENAME}/{ID}")
	    public String getUlti(     HttpServletRequest request
	            		      ,HttpServletResponse response
	    		              ,@PathVariable("ID") String id
	    		              ,@PathVariable("TABLENAME") String tableName){
			Map<String, Object> map = objectService.getUlti(tableName, id, null);
			return JSON.toJSONString(map);
	    }
		
		/** 添加单条信息  **/
		@RequestMapping(value = "/o/a/{TABLENAME}")
	    public String add(     HttpServletRequest request
	            		      ,HttpServletResponse response
	    		              ,@PathVariable("TABLENAME") String tableName){
			//TODO
	        return "ok"+tableName;
	    }

}
