package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = w;
    }

    public GUIAnimatinFaceLook() {
    }

    void makeFace(Graphics g, String emotion) {
        if (emotion.equals("normal")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 5);
            makeMouth(g, w / 2);
            makeEyebrowsNormal(g);
        } else if (emotion.equals("smile")) {
            makeEyes(g, w / 5);
            makeNose(g, h / 5);
            makeSmileMouth(g, w / 2);
            makeEyebrowsSmile(g);
        } else if (emotion.equals("angly")) {
            makeAnglyEyes(g, w / 5);
            makeNose(g, h / 5);
            makeAnglyMouth(g, w / 2);
            makeEyebrowsAngly(g);
        }
    }

    void makeEyes(Graphics g, int eyeSize) {
        g.setColor(Color.blue);
        g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 0, 300);
        g.setColor(Color.black);
        g.drawOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.drawOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }

    void makeAnglyEyes(Graphics g, int eyeSize) {
        g.setColor(Color.blue);
        g.fillArc(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 0, 300);
        g.fillArc(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize, 0, 300);
        g.setColor(Color.black);
        g.drawLine(xStart + (h * 2 / 7), yStart + (w * 1 / 3), xStart + (h * 2 / 7) + eyeSize, yStart + (w * 1 / 3) + eyeSize);
        g.drawLine(xStart + (h * 4 / 7), yStart + (w * 1 / 3), xStart + (h * 4 / 7) + eyeSize, yStart + (w * 1 / 3) + eyeSize);
    }

    void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }

    void makeMouth(Graphics g, int mouthSize) {
        int xMiddle = xStart + h / 2;
        int yMiddle = yStart + 3 * w / 4;
        g.drawLine(xMiddle - mouthSize / 2, yMiddle, xMiddle + mouthSize / 2, yMiddle);
    }

    void makeSmileMouth(Graphics g, int mouthSize) {
        g.setColor(Color.black);
        g.drawArc(xStart + (h * 1 / 3), yStart + (w * 2 / 3), mouthSize, mouthSize / 2, 0, -180);
    }

    void makeAnglyMouth(Graphics g, int mouthSize) {
        g.setColor(Color.black);
        g.drawArc(xStart + (h * 1 / 3), yStart + (w * 2 / 3), mouthSize, mouthSize / 2, 0, 180);
    }

    void makeEyebrowsNormal(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(xStart + (h * 2 / 7) - 10, yStart + (w * 1 / 4), xStart + (h * 2 / 7) + 10, yStart + (w * 1 / 4));
        g.drawLine(xStart + (h * 4 / 7) - 10, yStart + (w * 1 / 4), xStart + (h * 4 / 7) + 10, yStart + (w * 1 / 4));
    }

    void makeEyebrowsSmile(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(xStart + (h * 2 / 7) - 10, yStart + (w * 1 / 4) - 5, xStart + (h * 2 / 7) + 10, yStart + (w * 1 / 4));
        g.drawLine(xStart + (h * 4 / 7) - 10, yStart + (w * 1 / 4) - 5, xStart + (h * 4 / 7) + 10, yStart + (w * 1 / 4));
    }

    void makeEyebrowsAngly(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(xStart + (h * 2 / 7) - 10, yStart + (w * 1 / 4) + 5, xStart + (h * 2 / 7) + 10, yStart + (w * 1 / 4));
        g.drawLine(xStart + (h * 4 / 7) - 10, yStart + (w * 1 / 4) + 5, xStart + (h * 4 / 7) + 10, yStart + (w * 1 / 4));
    }
}
