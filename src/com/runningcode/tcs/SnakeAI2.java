package com.runningcode.tcs;

import java.util.Arrays;

import com.runningcode.tcs.Game.Direction;

/**
 * 完成贪吃蛇的AI算法，让贪吃蛇能自行寻找食物
 * 此实现只是一个简单样例
 * 
 * map中，0代表空白，1代表边界，2代表食物，3代表贪吃蛇的头部，4代表贪吃蛇的身体
 * 
 * 返回Direction.left表示贪吃蛇向左走，Direction.right向右，Direction.up向上，Direction.down向下
 * 
 * @author obj
 * @email oubijie@139.com
 * @vserion 2019年7月24日
 *
 */
public class SnakeAI2 {

	public static Direction autoPlay(int[][] map) {
		int[][] nodes = new int[400][2];  //存储遍历过的节点
		int[] food = new int[2];          //食物的位置
		int[] snake = new int[2];         //蛇头的位置
		int[][] snakeBody = new int[400][2]; //蛇的身体
		int bodyLen = 0;
		for(int i=1; i<map.length-1;i++){
			for(int j=1; j<map.length-1;j++){
				if(map[i][j] == 2){
					food[0] = i;
					food[1] = j;
				}
				
				if(map[i][j] == 3){
					snake[0] = i;
					snake[1] = j;
				}
				
				if(map[i][j] == 4){
					int[] body = new int[2];
					body[0] = i;
					body[1] = j;
					snakeBody[bodyLen++] = body;
				}
			}
		}
		System.out.println("食物所处位置：" + food[0] + "," + food[1]);
		System.out.println("蛇头所处位置：" + snake[0] + "," + snake[1]);
		
		//从食物开始广度优先找蛇头，找过的节点放到集合中，避免重复查找
		nodes[0] = food;
		int i = 0;
		int nodeLen = 1;
		while(i<nodeLen){
			int[] parent = nodes[i];
			
			int[] up = new int[2];
			up[0] = parent[0]-1;
			up[1] = parent[1];
			if(isValid(up, map.length, map[0].length)){
				if(isSnakeHead(snake, up)){
					System.out.println(Arrays.toString(parent));
					return Direction.down;
				}
				if(check(nodes, snakeBody, up)){
					nodes[nodeLen++] = up;
				}
			}
			
			int[] down = new int[2];
			down[0] = parent[0]+1;
			down[1] = parent[1];
			if(isValid(down, map.length, map[0].length)){
				if(isSnakeHead(snake, down)){
					System.out.println(Arrays.toString(parent));
					return Direction.up;
				}
				if(check(nodes, snakeBody, down)){
					nodes[nodeLen++] = down;
				}
			}
			
			int[] left = new int[2];
			left[0] = parent[0];
			left[1] = parent[1]-1;
			if(isValid(left, map.length, map[0].length)){
				if(isSnakeHead(snake, left)){
					System.out.println(Arrays.toString(parent));
					return Direction.right;
				}
				if(check(nodes, snakeBody, left)){
					nodes[nodeLen++] = left;
				}
			}
			
			int[] right = new int[2];
			right[0] = parent[0];
			right[1] = parent[1]+1;
			if(isValid(right, map.length, map[0].length)){
				if(isSnakeHead(snake, right)){
					System.out.println(Arrays.toString(parent));
					return Direction.left;
				}
				if(check(nodes, snakeBody, right)){
					nodes[nodeLen++] = right;
				}
			}
			
			i++;
			System.out.println("nodeLen:" + nodeLen);
			System.out.println("i:" + i);
		}
		System.out.println("没路了T_T");
		
		return noway(map, snake);
	}
	
	private static boolean isSnakeHead(int[] snake, int[] node){
		if(snake[0] == node[0] && snake[1] == node[1]){
			return true;
		}
		return false;
	}
	
	//检查节点是否已检查过，如果没有检查过再看是否属于蛇的身体节点，都不是就返回true
	private static boolean check( int[][] nodes, int[][] snakeBody, int[] node){
		if(!isExists(nodes, node) && !isExists(snakeBody, node)){
			return true;
		}
		return false;
	}
	
	public static boolean isValid(int[] node, int row, int col){
		if(node[0] >= 1 && node[0] <= row-2 && node[1] >= 1 && node[1] <= row-2){
			return true;
		}
		return false;
	}
	
	//检查节点是否已在列表中
	private static boolean isExists(int[][] nodes, int[] node){
		for(int[] temp : nodes){
			if(temp[0] == node[0] && temp[1] == node[1]){
				return true;
			}
		}
		return false;
	}
	
	//临时无法找到路，那边有空白走哪边
	private static Direction noway(int[][] map, int[] snake){
		if(map[snake[0]-1][snake[1]] == 0){
			return Direction.up;
		}else if(map[snake[0]+1][snake[1]] == 0){
			return Direction.down;
		}else if(map[snake[0]][snake[1]-1] == 0){
			return Direction.left;
		}else{
			return Direction.right;
		}
	}
}


