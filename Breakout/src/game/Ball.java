package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ball {
	private int x, y;
	private int x1, y1;
	public Ball() {
		x1 = 1;
		y1 = -8;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void drawBall(Graphics g, boolean isCollided, int condition, ArrayList<Block> b) {
		int xChange = 1, yChange = 0;
		if(isCollided && condition == 1) {
			xChange = 1;
			yChange = 0;
		}
		g.setColor(Color.BLACK);
		g.fillRect(x + x1, y + y1, 8, 8);
		g.setColor(Color.GRAY);
		g.fillRect(x + xChange, y + yChange, 8, 8);
	}
	public void setCollided(boolean b) {
		if(b) {
			x1 = 1;
			y1 = 10;
		} else {
			x1 = 1;
			y1 = -10;
		}
	}
}
