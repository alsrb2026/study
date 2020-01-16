package study;
/*package study;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawCircle101 extends JPanel {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	int x,y;
	int a = 10; //움직이는 거리 speed
	public DrawCircle101() {
			new Thread(){
				public void run(){
					while(true){
					x+=a;
					System.out.println(DrawCircle101.this.getWidth());
					if(x+100>=DrawCircle101.this.getWidth()){
						a = -a;
					}
					
					if(x < 0){
						a = (-a);
					}
					
					System.out.println(x);
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
			}.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.green);
		g2d.setBackground(Color.blue);
		g2d.fillOval(x, y, 100, 100);
		System.out.println("Graphic");
	}
}
*/