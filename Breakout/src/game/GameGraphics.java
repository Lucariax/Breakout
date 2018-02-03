package game;

import java.awt.Color;
import java.awt.Font;
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
	private int level, score;
	private DrawingPanel p;
	private MouseListen mL;
	private ArrayList<Block> b;
	private double x = 288, constant = 1, y = 512.0, constantX = 1;
	public boolean inverted;
	//private MouseListener mL;
	public GameGraphics(DrawingPanel p) {
		inverted = false;
		constantX = 0;
		score = 0;
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
		//ballC = new Collision(8, 8, 505, 280, "Ball");
		//scrollC = new Collision(120, 10, s.getX(), s.getY(), "Scroller");
		blockC = new Collision(b.get(0).getWidth(), b.get(0).getHeight(), 0, 0, "Block");
		ballC = new Collision(10, 10, 512, (int)(x), "Ball");
		scrollC = new Collision(10, 120, s.getX(), s.getY(), "Scroller");
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
		
		for(int i = 0; i < b.size(); i++) {
			blockC = new Collision(b.get(i).getHeight(), b.get(i).getWidth(), b.get(i).getX(), b.get(i).getY(), "Block");
			if(blockC.isCollided(ballC)) {
				ball.setCollided(false);
				constant = 1;
				g.setColor(Color.BLACK);
				g.fillRect(b.get(i).getX(), b.get(i).getY(), b.get(i).getWidth(), b.get(i).getHeight());
				b.remove(i);
				score += 200;
			}
		}
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		g.setColor(Color.BLACK);
		g.fillRect(10, 540, 90, 50);
		g.setColor(Color.WHITE);
		g.drawString("" + score, 10, 570);
		
	}
	public void ballPosition() {
		if(ball.getY() <= 0) {
			constant = 1;
			//ball.setCollided(false);
			inverted = !inverted;
		}
		if(ballC.isCollided(scrollC)) {
			//ball.setCollided(true);
			constant = -1;
			//ball.setX((int)(y + 0.5*constant));
			inverted = !inverted;
		}
		if(inverted && y > 0.0) {
			g.setColor(Color.BLACK);
			g.fillRect(ball.getX() + 120, ball.getY(), 8, 8);
			g.setColor(Color.GRAY);
			ball.setX((int)(y + 0.5*constant));
			ball.setY((int)(x - 0.5*constantX));
			g.fillRect(ball.getX() + 120, ball.getY(), 8, 8);
			y += 0.5*constant;
			x -= 0.5*constantX;
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(ball.getX() + 120, ball.getY(), 8, 8);
			g.setColor(Color.GRAY);
			ball.setX((int)(y - 0.5*constant));
			ball.setY((int)(x + 0.5*constantX));
			y -= 0.5*constant;
			x += 0.5*constantX;
			g.fillRect(ball.getX() + 120, ball.getY(), 8, 8);
		}
	}
}
