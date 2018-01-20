package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListen {
	private int x;
	public MouseListen(DrawingPanel p) {
		x = 0;
		p.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
			}
		});
	}
	public int getX() {
		return x;
	}
}
