package pong;

import java.awt.*;

public interface paddle {
	public void draw(Graphics g);
	public void move();
	public int getY();
	public int getScore();
	public void scored();
	public void resetScore();
}
