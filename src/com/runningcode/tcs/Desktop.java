package com.runningcode.tcs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Nightcat
 *@窗口主类 负责承载整体
 */
public class Desktop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desktop frame = new Desktop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Desktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//==============================================
		//测试数据部分
		//==============================================
		GetKey getkey = new GetKey();
		
		Game game = new Game(10, 10, getkey);
		
		LinkedList<Point> snake = new LinkedList<Point>();
		snake.add(new Point(1,1));
		snake.add(new Point(1,2));
		snake.add(new Point(1,3));
		snake.add(new Point(1,3));
		game.setSnake(snake);
		
		game.setFood(new Point(5,5));
		
		GameJPanel gameJpanel = new GameJPanel(game);
		
		contentPane.add(gameJpanel);
		
		gameJpanel.start();
		//==============================================
	}

}
