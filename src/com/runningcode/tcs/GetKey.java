package com.runningcode.tcs;

/**
 * @author 作者名
 *@获取按键的处理类
 */
public class GetKey implements Runnable{
	
	/**
	 * 处理后的按键值
	 * 1,2,3,4,5 = 上，下，左，右,暂停
	 */
	int key=0;
	
	//这个类继承接口的线程
	private Thread t;

	

	@Override
	//run里面包含需要多线程循环执行的代码
	public void run() {
		while(true) {
			//code
				//需要线程调用代码写在这里
			//每次执行后线程休眠时间
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start () {
	      if (t == null) {
	         t = new Thread (this,"getkey");
	         t.start ();
	      }
	}

}
