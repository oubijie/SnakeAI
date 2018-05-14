package com.runningcode.tcs;

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
	private Thread t;
	
	private Image image;
	
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
	         t = new Thread (this,"gamepanel");
	         t.start ();
	      }
	}

}
