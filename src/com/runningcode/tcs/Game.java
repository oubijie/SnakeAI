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
	private LinkedList<Point> snake;
	/**
	 * @游戏得分
	 */
	private int score=0;
	/**
	 * @当前游戏状态
	 * -1，0,1,2  = 输，正常，暂停，胜利
	 */
	private int gameState=0;
	
	/**
	 * @当前按键
	 */
	private GetKey nowkey;
	
	/**
	 * @地图数组
	 */
	private int[][] map;
	/**
	 * @方向枚举类型定义
	 */
	private enum Direction {up,down,left,right,stop};
	/**
	 * @表示当前运动方向
	 */
	private Direction nowDirection = Direction.stop;
	
	//这个类继承接口的线程
	private Thread t;
	
	/**
	 * @Game类的构造函数
	 * @param mapwidth 地图宽度
	 * @param maplength 地图长度
	 * @param nowkey 按键对象
	 */
	public Game(int mapwidth,int maplength,GetKey nowkey){
		map = new int[maplength][mapwidth];
		this.nowkey = nowkey;
	}
	
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
