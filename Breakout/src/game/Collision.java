package game;

import java.awt.Rectangle;

public class Collision {
	private int h, w, x, y;
	private String t;
	public int condition;
	public Collision(int h, int w, int x, int y, String type) {
		condition = -10;
		this.h = h;
		this.w = w;
		this.x = x;
		this.y = y;
		t = type;
	}
	public boolean isCollided(Collision c) {
		boolean r = false;
		r = (new Rectangle(h, w, x, y).intersects(new Rectangle(c.getHeight(), c.getWidth(), c.getX(), c.getY())));
		if(r && t.equals("Ball") && c.getType().equals("Block")) {
			condition = 1;
			// delete Block and reverse direction of ball
		} else if(r && t.equals("Ball") && c.getType().equals("Scroller")) {
			condition = 2;
		}
		return true;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return h;
	}
	public int getWidth() {
		return w;
	}
	public String getType() {
		return t;
	}
}
