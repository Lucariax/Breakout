package game;

import java.awt.Color;
import java.awt.Graphics;

public class Scroller {
	private Graphics g;
	private int level, prevX, prevY, currX, currY;
	public Scroller(Graphics g, int l) {
		this.g = g;
		//System.out.println(g == null);
		level = l;
	}
	public void draw(int x, int y) {
		currX = x;
		currY = y;
		g.setColor(Color.BLACK);
		g.fillRect(prevX, prevY, 120*(1/level), 10);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 120*(1/level), 10);
		prevX = x;
		prevY = y;
	}
	public int getX() {
		return currX;
	}
	public int getY() {
		return currY;
	}
}
