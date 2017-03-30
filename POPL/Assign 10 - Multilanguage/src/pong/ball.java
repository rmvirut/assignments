package pong;

import java.awt.*;

public class ball {
	double xVel, yVel, x, y;

	public ball() {
		x = 350;
		y = 250;
		xVel = getRandomSpeed() * getRandomDirection();
		yVel = getRandomSpeed() * getRandomDirection();
	}

	public double getRandomSpeed() {
		return Math.random() * 3 + 2;
	}

	public int getRandomDirection() {
		int rand = (int) Math.random() * 2;
		if (rand == 1) {
			return 1;
		} else {
			return -1;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int) x - 10, (int) y - 10, 20, 20);// want (x,y) to
														// represent the ball's
														// center
	}

	public void checkPaddle(paddle p1, paddle p2) {
		if (x <= 50) {
			if (y >= p1.getY() && y <= p1.getY() + 80) {
				xVel = -xVel;
			} else { //when a player has scored, reset the ball and the game
				p2.scored();
				x = 350;
				y = 250;
				xVel = getRandomSpeed() * getRandomDirection();
				yVel = getRandomSpeed() * getRandomDirection();
			}
		} else if (x >= 650) {
			if (y >= p2.getY() && y <= p2.getY() + 80) {
				xVel = -xVel;
			} else {
				p1.scored();
				x = 350;
				y = 250;
				xVel = getRandomSpeed() * getRandomDirection();
				yVel = getRandomSpeed() * getRandomDirection();
			}
		}
	}

	public void move() {
		x += xVel;
		y += yVel;
		if (y < 10) {
			yVel = -yVel;
		}
		if (y > 490) {
			yVel = -yVel;
		}
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}
}
