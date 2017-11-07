package com.mujuezhike.projectm.test;

public class ThreadLocalTest {
	
	public static void main(String[] args) {
		
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("eqwrqrew");
		System.out.println(tl.get());
		
		BitMap bt = new BitMap(25);
		bt.getBit(11);
	}

}
