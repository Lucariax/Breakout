package game;

public class Collision {
	private int h, w, x, y;
	public Collision(int h, int w, int x, int y, String type) {
		this.h = h;
		this.w = w;
		this.x = x;
		this.y = y;
	}
	public boolean isCollided(Collision c) {
		for(int i = x; i < x + w; i++) {
			for(int j = y; j < y + h; j++) {
				for(int k = c.getX(); k < c.getX() + c.getWidth(); k++) {
					for(int l = c.getY(); l < c.getY() + c.getHeight(); l++) {
						if(l == j && i == k) {
							return true;
						}
					}
				}
			}
		}
		return false;
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
}
