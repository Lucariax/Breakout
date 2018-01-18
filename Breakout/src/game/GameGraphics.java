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
	//private MouseListener mL;
	private int x;
	public GameGraphics(DrawingPanel p) {
		ballC = new Collision(3, 3, );
		ball = new Ball();
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
	}
	public Graphics getGraphics() {
		return g;
	}
	public void runGame() {
		p.sleep(1);
		p.setVisible(true);
		p.setBackground(Color.BLACK);
		s.draw(mL.getX(), 536);
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
			a += i.getWidth() + 8;
			counter++;
		}
		
		ball.drawBall(g, () );
	}
}
