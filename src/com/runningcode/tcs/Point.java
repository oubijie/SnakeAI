package com.runningcode.tcs;

/**
 * @author Nightcat
 *@基础坐标类
 *包含整形类型 x，y坐标
 */
public class Point {
	
	private int x;
	private int y;
	
	/**
	 * @表明当前节点的状态
	 * 借鉴数字小键盘
	 * 7 8 9 
	 * 4 5 6 
	 * 1 2 3 
	 * 有效参数为 7,9,1,3分别表示蛇主体转弯时，那个折点的状态
	 */
	private int nodeState;
	

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {

	}
	
	public int getNodeState() {
		return nodeState;
	}

	public void setNodeState(int nodeState) {
		this.nodeState = nodeState;
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
