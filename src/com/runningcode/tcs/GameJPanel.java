package com.runningcode.tcs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JPanel;


/**
 * @author Nightcat
 *@自定义画板
 *继承自Jpanel,重写paint();
 */
public class GameJPanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	//这个类继承接口的线程
	private Thread t = null;
	
	/**
	 * @双缓冲用的临时图像画板
	 */
	private Image image = null;
	
	/**
	 * @取得游戏信息对象
	 */
	private Game game = null;
	
	/**
	 * @param game 获取的游戏信息对象
	 */
	public GameJPanel(Game game){
		this.game = game;
	}
	
	//函数部分
	//...
	
	/**
	 * @双缓冲技术应用 绘制缓冲区
	 */
	private void drawBufferedImage() {
		// 创建缓冲区对象
	    image = createImage(this.getWidth(), this.getHeight());
	    // 获取图像上下文对象
	    Graphics g = image.getGraphics();
	    
	    int xp=1;
	    int yp=20;
	    
	    //绘制得分
	    g.drawString("当前得分："+game.getScore(), xp, yp-8);

	    //地图绘制部分
	    int[][] map = game.getMap();
	    int drawx=0;
	    int drawy=0;
	    for(int m=0;m<map.length;m++) {
	    	for(int n =0;n<map[0].length;n++) {
	    		drawx = m*(20+2)+xp;
	    		drawy = n*(20+2)+yp;
	    		g.setColor(Color.GRAY);
	    		g.fillRect(drawx, drawy, 20, 20);
	    	}
	    }
	    
	    //蛇绘制部分
	    LinkedList<Point> snake = game.getSnake();
	    for(int m=0;m<snake.size();m++) {
	    	if(m==0) {
	    		g.setColor(Color.BLUE);
	    		g.fillRect(snake.get(0).getX()*(20+2)+xp, snake.get(0).getY()*(20+2)+yp, 20, 20);
	    	}
	    	else {
		    	g.setColor(Color.GREEN);
		    	g.fillRect(snake.get(m).getX()*(20+2)+xp, snake.get(m).getY()*(20+2)+yp, 20, 20);
	    	}
	    }
	    
	    //食物绘制部分
	    g.setColor(Color.RED);
    	g.fillRect(game.getFood().getX()*(20+2)+xp,game.getFood().getY()*(20+2)+yp, 20, 20);
	    
	    
	    
	}
	/**
	 * @双缓冲技术应用 重写paint函数
	 */
	public void paint(Graphics g){
		drawBufferedImage();
	    g.drawImage(image, 0, 0, this);
	}

		

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
	
	@SuppressWarnings("deprecation")
	public void stop () {
		if (t == null) {
	         t.stop();
	      }
	}

}
