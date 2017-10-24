package com.mujuezhike.projectm.test;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;

public class ConcurrentLinkedHashMapTest {

	public static void main(String[] args) {
		 ConcurrentLinkedHashMap<Integer, Integer> map = new ConcurrentLinkedHashMap.Builder<Integer, Integer>()  
	                .maximumWeightedCapacity(2).weigher(Weighers.singleton())  
	                .build();  
	  
	        map.put(1, 1);  
	        map.put(2, 2);  
	        map.put(3, 3);  
	        System.out.println(map.get(1));// null 已经失效了  
	        System.out.println(map.get(2));  

	}

}


