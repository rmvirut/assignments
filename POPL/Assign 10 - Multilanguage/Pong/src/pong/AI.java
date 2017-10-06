package pong;

import java.awt.*;

public class AI implements paddle {
	double DECEL = 0.8;
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	ball b1;
	public static int score;


	public AI(int player, ball b) {
		score = 0;
		b1 = b;
		this.y = 210;
		this.yVel = 0;
		if (player == 1) {
			this.x = 20;
		} else {
			x = 650;
		}

		this.upAccel = false;
		this.downAccel = false;

	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 20, 80);

	}

	public void move() {
		y = b1.getY() - 40;

		if (yVel >= 5) {
			yVel = 5;
		} else if (yVel <= -5) {
			yVel = -5;
		}
		y += yVel;

		if (y < 0) {
			y = 0;
		} else if (y > 420) {
			y = 420;
		}
	}

	public void setUpAccel(boolean input) {
		upAccel = input;
	}

	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int) y;
	}

	@Override
	public int getScore() {
		return score;
	}
	
	public void scored(){
		score++;
	}

	@Override
	public void resetScore() {
		// TODO Auto-generated method stub
		score = 0;
	}

}
