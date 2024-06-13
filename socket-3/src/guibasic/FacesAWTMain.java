//FacesAWTMain.java
//FacesAWTMain 目標 インナークラスのFaceObjクラスを作ってみよう。描画処理を移譲してください。
//3x3　の顔を描画してください。色などもぬってオリジナルな楽しい顔にしてください。

package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class FacesAWTMain {

	public static void main(String[] args) {
		new FacesAWTMain();
	}

	FacesAWTMain() {
		FaceFrame f = new FaceFrame();
		f.setSize(800, 800);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setVisible(true);
	}

	// インナークラスを定義
	class FaceFrame extends Frame {
		FaceObj[][] fObjs = new FaceObj[3][3];

		// private FaceObj fobj1;
		int xStart0 = 50;
		int yStart0 = 50;

		FaceFrame() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					fObjs[i][j] = new FaceObj();
				}
			}
		}

		public void paint(Graphics g) {
			// この中には、g.drawLine というのは入ってこない
			// Graphicsクラス(型のようなもの---今は--)のgという変数はメソッドに渡す

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					fObjs[i][j].setPositon(xStart0 + 200 * i, yStart0 + 200 * j);
					fObjs[i][j].drawFace(g);
				}

			}
			// FaceObj fobj1 = new FaceObj();
			// fobj1.setPositon(xStart0,yStart0);
			// fobj1.drawFace(g);
			// FaceObj fobj2 = new FaceObj();
			// fobj2.setPositon(xStart0+200,yStart0+200);
			// fobj2.drawFace(g);

		}

	}// FaceFrame end

	// Faceクラスを作ってみよう。
	private class FaceObj {
		private int w = 200;
		private int h = 200;
		private int xStart = 50;
		private int yStart = 50;

		public void drawRim(Graphics g) { // wが横幅、hが縦幅
			g.setColor(Color.BLACK);
			g.drawLine(xStart, yStart, xStart + w, yStart);
			g.drawLine(xStart, yStart, xStart, yStart + h);
			g.drawLine(xStart, yStart + h, xStart + w, yStart + h);
			g.drawLine(xStart + w, yStart, xStart + w, yStart + h);
		}

		public void setPositon(int xStart0, int yStart0) {
			this.xStart = xStart0;
			this.yStart = yStart0;
		}

		public void drawFace(Graphics g) {
			Random rand = new Random();
			drawRim(g);
			drawBrow(g, rand.nextInt(50) + 20); // ランダムな眉の幅
			drawEye(g, rand.nextInt(20) + 15); // ランダムな目の半径
			drawNose(g, rand.nextInt(100) + 50); // ランダムな鼻の位置
			drawMouth(g, rand.nextInt(100) + 50);
		}

		public void drawBrow(Graphics g, int bx) { // xは目の幅 呼ばれる方(=定義する方)
			g.setColor(Color.BLUE);
			g.drawLine(xStart + 20, yStart + 20, xStart + 50, yStart + 50);
			g.drawLine(xStart + 50, yStart + 50, xStart + 80, yStart + 20);
			g.drawLine(xStart + 120, yStart + 20, xStart + 150, yStart + 50);
			g.drawLine(xStart + 150, yStart + 50, xStart + 180, yStart + 20);
		}

		public void drawNose(Graphics g, int nx) { // xは鼻の長さ
			g.setColor(Color.GREEN);
			g.drawLine(xStart + 100, yStart + 75, xStart + 75, yStart + 150);
		}

		public void drawEye(Graphics g, int r) { // rは目の半径
			g.setColor(Color.RED);
			g.drawOval(xStart + 45, yStart + 65, r, r);
			g.drawOval(xStart + 120, yStart + 65, r, r);
		}

		public void drawMouth(Graphics g, int mx) { // xは口の幅
			int xMiddle = xStart + w / 2;
			int yMiddle = yStart + h - 30;
			g.setColor(Color.yellow);
			g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
		}
	}

}// Faces class end
