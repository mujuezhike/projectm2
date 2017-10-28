package com.mujuezhike.projectm.test.concurrenttest;

public class EmptyTest {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getThreadGroup());
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println(Runtime.getRuntime().totalMemory());
		System.out.println(Runtime.getRuntime().maxMemory());

	}

}
