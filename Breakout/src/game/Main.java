package game;

public class Main {
	public static int x;
	public static void main(String[] args) {
		DrawingPanel p = new DrawingPanel(1024, 576);
		GameGraphics breakout = new GameGraphics(p);
		breakout.runGame();
		while(true) {
			breakout.runIndefinetly();
		}
	}
}
