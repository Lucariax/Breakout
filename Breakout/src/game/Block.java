package game;
import java.awt.Color;
import java.awt.Graphics;
public class Block {
	private Graphics g;
	private Color c;
	private int w, h, x, y;
	public Block(Graphics g, Color c, int w, int h) {
		this.g = g;
		this.c = c;
		this.w = w;
		this.h = h;
	}
	public void Draw(int x, int y) {
		g.setColor(c);
		g.fillRect(x, y, w, h); //TODO: Find block size.
	}
	public Color getColor() {
		return c;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	public void setX(int a) {
		x = a;
	}
	public void setY(int b) {
		y = b;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
