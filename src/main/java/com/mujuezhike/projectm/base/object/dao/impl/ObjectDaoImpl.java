package com.mujuezhike.projectm.base.object.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mujuezhike.projectm.base.cache.CLKeyGenerator;
import com.mujuezhike.projectm.base.cache.Cache;
import com.mujuezhike.projectm.base.object.bean.KVBean;
import com.mujuezhike.projectm.base.object.dao.ObjectDao;
import com.mujuezhike.projectm.base.util.StringUtil;

@Component
public class ObjectDaoImpl implements ObjectDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Cache cache;

	@Override
	public Map<String, Object> getById(String tablename, String id) {

		String key = CLKeyGenerator.getObjectIdKey(tablename,id);
		
		Map<String, Object> cmap = cache.getObject(key, Map.class);
		if(cmap!=null) {
			return cmap;
		}
		
		String sql = "select * from " + tablename + " WHERE id = " + StringUtil.sqlBean(id);
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		
		cache.set(key, map);

		return map;
	}

	@Override
	public List<Map<String, Object>> listByBean(String tablename, Map<String, Object> inmap) {

		StringBuffer sql = new StringBuffer("select * from " + tablename + " WHERE 1 = 1 ");
		List<KVBean> wherelist = new ArrayList<KVBean>();
		List<KVBean> sqllist = new ArrayList<KVBean>();

		for (String key : inmap.keySet()) {

			KVBean kvBean = new KVBean();
			kvBean.setKey(key);
			kvBean.setValue(inmap.get(key).toString());

			if (key.equals("limit") || key.equals("offset") || key.equals("sortby") || key.equals("order")) {

				sqllist.add(kvBean);
			} else {
				wherelist.add(kvBean);
			}
			;
		}

		for (KVBean kvBean : wherelist) {
			StringBuffer bean = new StringBuffer(" and ");
			String key = kvBean.getKey();
			String value = kvBean.getValue();

			String trueValue = "";

			if (value.startsWith("_e_")) {
				trueValue = value.replaceFirst("_e_", "");
				bean.append(key + " = " + StringUtil.sqlBean(trueValue));
			}

			if (value.startsWith("_gt_")) {
				trueValue = value.replaceFirst("_gt_", "");
				bean.append(key + " > " + StringUtil.sqlBean(trueValue));
			}

			if (value.startsWith("_lt_")) {
				trueValue = value.replaceFirst("_lt_", "");
				bean.append(key + " < " + StringUtil.sqlBean(trueValue));
			}

			if (value.startsWith("_n_")) {
				trueValue = value.replaceFirst("_n_", "");
				bean.append(key + " != " + StringUtil.sqlBean(trueValue));
			}

			if (value.startsWith("_l_")) {
				trueValue = value.replaceFirst("_l_", "");
				bean.append(key + " LIKE " + "'%" + trueValue + "%'");
			}

			sql.append(bean);

		}

		/** ORDER **/
		Object sortby = inmap.get("sortby");
		if (sortby != null) {
			sql.append(" ORDER BY " + sortby.toString());
			Object order = inmap.get("order");
			if (order != null) {
				if (order.equals("desc")) {
					sql.append(" desc");
				}
			}
		}

		/** PAGE **/
		Object limit = inmap.get("limit");
		if (limit != null) {
			Object offset = inmap.get("offset");
			if (offset != null) {
				sql.append(" LIMIT " + offset + ", " + limit);
			} else {
				sql.append(" LIMIT " + limit);
			}
		}

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());

		return list;
	}

	@Override
	public Map<String, Object> add(String tablename, Map<String, Object> beanmap) {

		List<String> insertbean = new ArrayList<String>();
		
		List<String> valuebean = new ArrayList<String>();
		
		for(String key:beanmap.keySet()) {
			
			if(key.startsWith("_")) {
				
			}else {
				insertbean.add(key);
				valuebean.add(beanmap.get(key).toString());
			}
			
		}
		
		String insertsql = "INSERT INTO "
		                 + tablename
		                 + " "
		                 + StringUtil.sqlBracketsBean(insertbean)
		                 + " VALUES "
				         + StringUtil.sqlBracketsSqlBean(valuebean);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator preparedStatementCreator = con -> {
			PreparedStatement ps = con.prepareStatement(insertsql, Statement.RETURN_GENERATED_KEYS);
			return ps;
		};

		jdbcTemplate.update(preparedStatementCreator, keyHolder);
		
		String genId = keyHolder.getKey().toString();
		beanmap = getById(tablename,genId);

		return beanmap;
	}

}
