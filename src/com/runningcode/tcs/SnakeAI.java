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
public class SnakeAI {

	public static Direction autoPlay(int[][] map) {
		System.out.println("=======================going....");
		int snakex = 0;
		int snakey = 0;
		int foodx = 0;
		int foody = 0;
		for(int i=1; i<map.length-2;i++){
			for(int j=1; j<map.length-2;j++){
				if(map[i][j] == 2){
					foody = i;
					foodx = j;
				}
				
				if(map[i][j] == 3){
					snakey = i;
					snakex = j;
				}
			}
		}
		
		if(snakex > foodx){
			return Direction.left;
		}else if(snakex < foodx){
			return Direction.right;
		}else{
			if(snakey > foody){
				return Direction.up;
			}else{
				return Direction.down;
			}
		}
		
	}
	
	

}
