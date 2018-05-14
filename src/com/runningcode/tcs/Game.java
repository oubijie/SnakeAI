package com.runningcode.tcs;

import java.util.LinkedList;

/**
 * @author 作者名
 * 
 *@游戏核心类
 *主要是游戏的核心算法
 */

public class Game implements Runnable {

	/**
	 * @蛇的主体链表
	 */
	LinkedList<Point> snake;
	/**
	 * @游戏得分
	 */
	int score=0;
	/**
	 * @当前游戏状态
	 * -1，0,1,2  = 输，正常，暂停，胜利
	 */
	int gameState=0;
	/**
	 * @方向枚举类型定义
	 */
	enum Direction {up,down,left,right,stop};
	/**
	 * @表示当前运动方向
	 */
	Direction nowDirection = Direction.stop;
	
	//这个类继承接口的线程
	private Thread t;
	
	
	
	//函数部分
	//...

	

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
	         t = new Thread (this,"game");
	         t.start ();
	      }
	}
}
