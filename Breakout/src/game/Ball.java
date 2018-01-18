package game;

public class Ball {
	private int size, level, speed, x, y;
	public Ball(int s, int l) {
		size = s;
		level = l;
		speed = 10;
	}
	public int getXDirection() {
		return x;
	}
	public int getYDirection() {
		return y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int s) {
		speed = s;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
