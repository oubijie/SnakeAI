package com.runningcode.tcs;

/**
 * @author Nightcat
 *@基础坐标类
 *包含整形类型 x，y坐标
 */
public class Point {
	
	private int x;
	private int y;
	

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {

	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
