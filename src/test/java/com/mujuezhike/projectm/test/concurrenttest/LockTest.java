package com.mujuezhike.projectm.test.concurrenttest;

import com.mujuezhike.projectm.test.SpinLock;

public class LockTest implements Runnable{
	
	static int sum;  
	
	private SpinLock lock;  

	public LockTest(SpinLock lock) {  
	        this.lock = lock;  
	} 
	
	public static void main(String[] args) {
		    SpinLock lock = new SpinLock();  
	        for (int i = 0; i < 100; i++) {  
	        	LockTest test = new LockTest(lock);  
	            Thread t = new Thread(test);  
	            t.start();  
	        }  
	          
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
	        System.out.println(sum); 
	        System.out.println(getCount()); 

	}

	@Override
	public void run() {
		 this.lock.lock();  
	     System.out.println(sum++);
	     this.lock.unLock();  
		
	}
	public static int getCount() {
		
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();  
	    while(threadGroup.getParent() != null){  
	        threadGroup = threadGroup.getParent();  
	    }  
	    int totalThread = threadGroup.activeCount();  
	    System.out.println(totalThread);
		return totalThread;
		
	}
}