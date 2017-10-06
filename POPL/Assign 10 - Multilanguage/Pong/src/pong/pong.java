package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class pong extends Applet implements Runnable, KeyListener {

	final int WIDTH = 700, HEIGHT = 500;

	Thread thread;
	humanPaddle p1;
	AI p2;
	ball b1;
	boolean gameStarted = false;
	boolean playGame = true;
	Graphics gfx;
	Image img;
	Integer p1Score = 0;
	Integer p2Score = 0;

	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		p1 = new humanPaddle(1);
		b1 = new ball();
		p2 = new AI(2, b1);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {

		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);

		if (!winner(p1, p2)) {
			p1.draw(gfx);
			b1.draw(gfx);
			p2.draw(gfx);
			gfx.drawString(String.valueOf(p1.getScore()), 300, 480);
			gfx.drawString(String.valueOf(p2.getScore()), 400, 480);

			if (!gameStarted) {
				gfx.setColor(Color.white);
				gfx.drawString("God mode pong", 340, 100);
				gfx.drawString("Press Enter to begin...", b1.getX() - 20, b1.getY() - 100);
			}
		} else {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over.", 250, 250);
			this.resetGame(p1, p2);
			gameStarted = false;
		}


		g.drawImage(img, 0, 0, this);

	}

	public void update(Graphics g) {
		paint(g);
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public void run() {
		while (playGame) {
			if (gameStarted) {
				p1.move();
				b1.move();
				p2.move();
				b1.checkPaddle(p1, p2);

			}
			repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameStarted = true;
			playGame = true;
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {// exit game when
															// escape key is
															// pressed
			playGame =false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean winner(paddle p1, paddle p2) {
		return p1.getScore() == 5 || p2.getScore() == 5;
	}
	
	public void resetGame(paddle p1, paddle p2){
		p1.resetScore(); p2.resetScore();
	}

}
