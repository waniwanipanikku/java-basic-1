package guichat;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovingBallAWT {
	public static void main(String[] args) {
		FFrame f = new FFrame();
		f.setSize(500, 500);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.show();
	}

	static class FFrame extends Frame implements Runnable {

		Thread th;
		Ball[] balls;
		private boolean enable = true;
		private int counter = 0;

		FFrame() {
			balls = new Ball[5];
			for (int i = 0; i < balls.length; i++) {
				balls[i] = new Ball();
			}
			th = new Thread(this);
			th.start();
		}

		public void run() {
			Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA};
			int[][] positions = {{50, 50}, {150, 150}, {250, 250}, {350, 350}, {450, 450}};
			int[] radii = {10, 15, 20, 25, 30};

			for (int i = 0; i < balls.length; i++) {
				balls[i].setPosition(positions[i][0], positions[i][1]);
				balls[i].setR(radii[i]);
				balls[i].setColor(colors[i]);
			}

			while (enable) {
				try {
					Thread.sleep(100);
					counter++;
					if (counter >= 200) enable = false;
				} catch (InterruptedException e) {
				}

				for (Ball ball : balls) {
					ball.move();
				}

				repaint();
			}
		}

		public void paint(Graphics g) {
			for (Ball ball : balls) {
				ball.draw(g);
			}
		}

		class Ball {
			int x;
			int y;
			int r;
			Color c = Color.RED;

			int xDir = 1;
			int yDir = 1;

			void setColor(Color c) {
				this.c = c;
			}

			void move() {
				if ((xDir == 1) && (x >= getWidth() - r * 2)) {
					xDir = -1;
				}
				if ((xDir == -1) && (x <= 0)) {
					xDir = 1;
				}

				if (xDir == 1) {
					x = x + 10;
				} else {
					x = x - 10;
				}

				if ((yDir == 1) && (y >= getHeight() - r * 2)) {
					yDir = -1;
				}
				if ((yDir == -1) && (y <= 0)) {
					yDir = 1;
				}

				if (yDir == 1) {
					y = y + 10;
				} else {
					y = y - 10;
				}
			}

			void setPosition(int x, int y) {
				this.x = x;
				this.y = y;
			}

			void setR(int r) {
				this.r = r;
			}

			void draw(Graphics g) {
				g.setColor(c);
				g.fillOval(x, y, 2 * r, 2 * r);
			}
		}
	}
}
