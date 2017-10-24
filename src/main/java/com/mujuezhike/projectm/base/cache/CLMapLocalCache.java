package com.mujuezhike.projectm.base.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;

@Component
public class CLMapLocalCache implements Cache{
	
	private static ConcurrentLinkedHashMap<String, Object> instance;  
	private CLMapLocalCache (){}
	public static synchronized ConcurrentLinkedHashMap<String, Object> getInstance() {  
		if (instance == null) {  
			instance = new ConcurrentLinkedHashMap.Builder<String, Object>()  
	                .maximumWeightedCapacity(1024*10).weigher(Weighers.singleton())  
	                .build();    
		}  
		return instance;  
	}  

	@Override
	public String get(String key) {
		Object o = getInstance().get(key);
		if(null == o) {
			return null;
		}
		return o.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObject(String key, Class<T> cls) {
		Object o = getInstance().get(key);
		if(null == o) {
			return null;
		}
		return (T)o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getList(String key, Class<T> clz) {
		Object o = getInstance().get(key);
		if(null == o) {
			return null;
		}
		return (List<T>)o;
	}

	@Override
	public String set(String key, String value) {
		getInstance().put(key,value);
		return value;
	}

	@Override
	public Object set(String key, Object value) {
		getInstance().put(key,value);
		return value;
	}

	@Override
	public <T> T setObject(String key, Class<T> cls, T value) {
		getInstance().put(key,value);
		return value;
	}

}
