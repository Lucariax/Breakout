package game;

import java.awt.Color;
import java.awt.Graphics;

public class Scroller {
	private Graphics g;
	private int level, prevX, prevY;
	public Scroller(Graphics g, int l) {
		this.g = g;
		//System.out.println(g == null);
		level = l;
	}
	public void draw(int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(prevX - 60, prevY, 120*(1/level), 10);
		g.setColor(Color.WHITE);
		g.fillRect(x - 60, y, 120*(1/level), 10);
		prevX = x;
		prevY = y;
	}
}
