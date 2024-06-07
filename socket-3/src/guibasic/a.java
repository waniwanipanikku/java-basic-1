package guibasic;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class a {

    public static void main(String[] args) {
        new a();
    }

    a() {
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

        private FaceObj[][] fObjs = new FaceObj[3][3];

        FaceFrame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fObjs[i][j] = new FaceObj();
                }
            }
        }

        public void paint(Graphics g) {
            int xStart = 50;
            int yStart = 50;
            int xOffset = 250; // 顔の間の間隔（横）
            int yOffset = 250; // 顔の間の間隔（縦）

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fObjs[i][j].setPositon(xStart + j * xOffset, yStart + i * yOffset);
                    fObjs[i][j].drawFace(g);
                }
            }
        }

    }// FaceFrame end

    // Faceクラスを作ってみよう。
    private class FaceObj {
        private int w = 200;
        private int h = 200;
        private int xStart = 50;
        private int yStart = 50;

        public void drawRim(Graphics g) {
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
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 35);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void drawBrow(Graphics g, int bx) {
            g.drawLine(xStart + 20, yStart + 20, xStart + 50, yStart + 50);
            g.drawLine(xStart + 50, yStart + 50, xStart + 80, yStart + 20);
            g.drawLine(xStart + 120, yStart + 20, xStart + 150, yStart + 50);
            g.drawLine(xStart + 150, yStart + 50, xStart + 180, yStart + 20);
        }

        public void drawNose(Graphics g, int nx) {
            g.drawLine(xStart + 100, yStart + 75, xStart + 75, yStart + 150);
        }

        public void drawEye(Graphics g, int r) {
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xStart + 120, yStart + 65, r, r);
        }

        public void drawMouth(Graphics g, int mx) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 30;
            g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
        }
    }

}// Faces class end
