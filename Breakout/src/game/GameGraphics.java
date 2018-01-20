package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

import game.DrawingPanel.DPMouseEventHandler;

public class GameGraphics {
	private Ball ball;
	private Graphics g;
	private Scroller s;
	private Collision ballC, scrollC, blockC;
	private int level;
	private DrawingPanel p;
	private MouseListen mL;
	private ArrayList<Block> b;
	private double x = 288, constant = 1, y = 512;
	//private MouseListener mL;
	public GameGraphics(DrawingPanel p) {
		ball = new Ball();
		ball.setX(501);
		ball.setY(278);
		level = 1;
		this.p = p;
		mL = new MouseListen(p);
		g = p.getGraphics();
		//p.addMouseListener(mL);
		s = new Scroller(g, level);
		b = new ArrayList<Block>();
		Color c = Color.GREEN;
		for(int i = 0; i < 112; i++) {
			switch(i) {
			case 28:
				c = Color.BLUE;
				break;
			case 56:
				c = Color.RED;
				break;
			case 84:
				c = Color.ORANGE;
				break;
			}
			b.add(new Block(g, c, 65, 20));
		}
		ballC = new Collision(8, 8, 505, 280, "Ball");
		scrollC = new Collision(120, 10, s.getX(), s.getY(), "Scroller");
		blockC = new Collision(b.get(0).getWidth(), b.get(0).getHeight(), 0, 0, "Block");
	}
	public Graphics getGraphics() {
		return g;
	}
	public void runGame() {
		p.setVisible(true);
		p.setBackground(Color.BLACK);
		int a = 4, counter = 0, y = 60, maxH = 0;
		for(Block i : b) {
			if(maxH < i.getHeight()) {
				maxH = i.getHeight();
			}
			if(counter == 14) {
				a = 4;
				counter = 0;
				y += maxH + 8;
				maxH = 0;
			}
			g.setColor(i.getColor());
			g.fillRect(a, y, i.getWidth(), i.getHeight());
			i.setX(a);
			i.setY(y);
			a += i.getWidth() + 8;
			counter++;
		}
	}
	public void runIndefinetly() {

		s.draw(mL.getX(), 536);
		p.sleep(2);
		ball.setY((int)(x + constant));
		x += constant;
		ball.drawBall(g, false, -1, b);
		ballC = new Collision(10, 10, 512, (int)(x), "Ball");
		scrollC = new Collision(10, 120, s.getX(), s.getY(), "Scroller");
		if(ball.getY() <= 0) {
			constant = 1;
			ball.setCollided(false);
		}
		if(ballC.isCollided(scrollC)) {
			ball.setCollided(true);
			System.out.println("h");
			constant = -1;
			ball.setX((int)(512 + constant));
			y += constant;
		}
		for(int i = 0; i < b.size(); i++) {
			blockC = new Collision(b.get(i).getHeight(), b.get(i).getWidth(), b.get(i).getX(), b.get(i).getY(), "Block");
			if(blockC.isCollided(ballC)) {
				ball.setCollided(false);
				constant = 1;
				g.setColor(Color.BLACK);
				g.fillRect(b.get(i).getX(), b.get(i).getY(), b.get(i).getWidth(), b.get(i).getHeight());
				b.remove(i);
				//score += 200;
			}
		}
	}
}
