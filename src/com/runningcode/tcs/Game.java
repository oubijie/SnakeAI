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
	private LinkedList<Point> snake = null;
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
	private GetKey nowkey = null;
	
	/**
	 * @食物位置
	 */
	private Point food = null;
	
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
	private Thread t = null;
	
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
	
	public LinkedList<Point> getSnake() {
		return snake;
	}



	public void setSnake(LinkedList<Point> snake) {
		this.snake = snake;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getGameState() {
		return gameState;
	}



	public void setGameState(int gameState) {
		this.gameState = gameState;
	}



	public GetKey getNowkey() {
		return nowkey;
	}



	public void setNowkey(GetKey nowkey) {
		this.nowkey = nowkey;
	}



	public Point getFood() {
		return food;
	}



	public void setFood(Point food) {
		this.food = food;
	}



	public int[][] getMap() {
		return map;
	}



	public void setMap(int[][] map) {
		this.map = map;
	}



	public Direction getNowDirection() {
		return nowDirection;
	}



	public void setNowDirection(Direction nowDirection) {
		this.nowDirection = nowDirection;
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
