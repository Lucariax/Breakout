package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ball {
	private int x, y;
	public Ball() {
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void drawBall(Graphics g, boolean isCollided, int condition, ArrayList<Block> b) {
		int xChange = 1, yChange = 0;
		if(isCollided && condition == 1) {
			xChange = -1;
			yChange = 0;
		}
		g.setColor(Color.WHITE);
		g.drawRect(xChange, yChange, 3, 3);
	}
}
