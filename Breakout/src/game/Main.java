package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
	public static int x;
	public static void main(String[] args) {
		DrawingPanel p = new DrawingPanel(1024, 576);
		GameGraphics breakout = new GameGraphics(p);
		while(true) {
			breakout.runGame();
		}
	}
}
