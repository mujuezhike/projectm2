package com.mujuezhike.projectm.base.cache;

import java.util.List;

/**
 * @author   : mujuezhike 
 * @date     : 20171019
 */
public interface Cache {
	
	/**
     * @describe  获取缓存值
     * @param     key 键  字符串形式
     * @return    字符串形式
     */
	String get(String key);
	
	/**
     * @describe  获取缓存值
     * @param     key 键  字符串形式
     *            cls 值类型
     * @return    对象形式
     */
	<T> T getObject(String key,Class<T> cls);
	
	/**
     * @describe  获取缓存值
     * @param     key 键  字符串形式
     *            cls 值类型
     * @return    列表形式
     */
	<T> List<T> getList(String key,Class<T> clz);
	
	/**
     * @describe  设置缓存值
     * @param     key 键  字符串形式  
     *            value 值  对象形式
     * @return    字符串形式
     */
	String set(String key,String value);
	
	/**
     * @describe    设定值 对象方式
     * @param key   
     * @param value
     * 
     * @return      对象形式
     */
    Object set(String key,Object value);
	
    /**
     * @describe    设定值 对象方式
     * @param key   键
     *        value 值
     *        cls   值类型
     * 
     * @return      模板形式
     */
	<T> T setObject(String key,Class<T> cls,T value);

}
