import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Bome_Defusal implements ActionListener, KeyListener {

	JPanel gp = new JPanel();
	JFrame gf = new JFrame();
	JLabel gl = new JLabel();

	JLabel starttxt = new JLabel();
	JButton startbut = new JButton();

	/*
	 * JPanel mp = new JPanel(); JFrame mf = new JFrame(); JButton up = new
	 * JButton(); JButton down = new JButton(); JButton left = new JButton();
	 * JButton right = new JButton();
	 */

	int time;
	int maxTime = 3;
	int speed = 30;
	Timer timer;

	int acel = 30000;

	int x = 2;
	int y = 2;

	int tx;
	int ty;

	int remain = 25;
	int defused = 25;

	ArrayList<Pos>positions = new ArrayList<Pos>();

	Random gen = new Random();

	public static void main(String[] args) {
		Bome_Defusal backup_plan = new Bome_Defusal();
		backup_plan.start();

	}

	public void start() {

		starttxt.setText("Bomb Defusal");
		startbut.setText("Start");

		gp.add(starttxt);
		gp.add(startbut);

		startbut.addActionListener(this);

		gf.setPreferredSize(new Dimension(100, 125));

		gf.add(gp);

		gf.pack();
		gf.show();

		/*
		 * mp.add(up); mp.add(down); mp.add(left); mp.add(right);
		 * 
		 * up.setText("Up"); down.setText("Down"); left.setText("Left");
		 * right.setText("Right");
		 * 
		 * mf.add(mp); mf.pack(); mf.show();
		 * 
		 * up.addActionListener(this); down.addActionListener(this);
		 * left.addActionListener(this); right.addActionListener(this);
		 */

		updateMap();
		
	}

	// Up = y + 1
	// Down = y - 1
	// Left = x - 1
	// Right = x + 1

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startbut) {

			gf.remove(gp);
			gp.remove(starttxt);
			gp.remove(startbut);

			gp = new JPanel();

			gf.add(gp);

			tx = gen.nextInt(5);
			ty = gen.nextInt(5);

			gf.addKeyListener(this);
			gf.requestFocus();

			gp.add(gl);

			gf.add(gp);
			gf.pack();
			gf.show();

			gf.setPreferredSize(new Dimension(100, 125));

			gl.setText("<html>- - - - -<br>- - - - -<br>- - X - -<br>- - - - -<br>- - - - -</html>");

			gf.pack();

			time = maxTime;
			timer = new Timer(acel / speed, this);
			timer.start();

			time += 1;
			
		}

		System.out.println(time);

		time -= 1;

		if (time <= 0) {
			timer.stop();
			tx = 10;
			ty = 10;
			System.out.println("You Lose!");

			defused-=remain;
			
			gf.remove(gp);
			gp = new JPanel();
			gf.add(gp);
			
			JLabel losetxt = new JLabel();
			
			gp.add(losetxt);
			
			losetxt.setPreferredSize(new Dimension(100, 110));

			losetxt.setText("<html>You Lose!<br><br>You defused " + defused + "<html> bombs with " + remain + "<html> remaining<br>-------------");
			
			gf.pack();
			
		}

		if (acel <= 5000) {
			timer.stop();
			tx = 10;
			ty = 10;
			System.out.println("You Win!");
			
			defused-=remain;
			
			gf.remove(gp);
			gp = new JPanel();
			gf.add(gp);
			
			JLabel wintxt = new JLabel();
			
			gp.add(wintxt);
			
			wintxt.setPreferredSize(new Dimension(100, 75));
			wintxt.setText("<html>You Win!<br><br>You defused all 25 bombs");
			
			gf.pack();

		}

		/*
		 * acel-=1000; timer = new Timer(acel/speed, this); timer.start(); tx =
		 * gen.nextInt(5); ty = gen.nextInt(5);
		 */

		/*
		 * if(e.getSource()==up){ y-=1; if(y<0) { y=0; } } if(e.getSource()==down){
		 * y+=1; if(y>4) { y=4; } } if(e.getSource()==left){ x-=1; if(x<0) { x=0; } }
		 * if(e.getSource()==right){ x+=1; if(x>4) { x=4; } }
		 */

		updateMap();

	}
	
class Pos{
	int x;
	int y;
	Pos(int x, int y){
		this.x=x;
		this.y=y;
	}
}

	public void updateMap() {

		String map = "<html>";
		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {
				if (x == j && y == i) {
					map += " X ";
				} else if (tx == j && ty == i) {
					while (---) {
						if (tx == x && ty == y) {
							tx = gen.nextInt(5);
							ty = gen.nextInt(5);
						}
						for (int i = 0; i < positions.size(); i++) {
						if(position.geti.x == x && position.geti.y == y) {
							tx = gen.nextInt(5);
							ty = gen.nextInt(5);
							}
						}
					}

					map += " " + time + " ";

				} else {
					map += " - ";
				}
			}

			map += "<br>";

		}

		
		gl.setText(map);

		Pos p = new Pos (tx, ty);
		positions.add(p);
		
		
		gf.pack();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
			y -= 1;
			if (y < 0) {
				y = 0;
			}
		}
		if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
			y += 1;
			if (y > 4) {
				y = 4;
			}
		}
		if (e.getKeyCode() == 37 || e.getKeyCode() == 65) {
			x -= 1;
			if (x < 0) {
				x = 0;
			}
		}
		if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
			x += 1;
			if (x > 4) {
				x = 4;
			}
		}

		if (tx == x && ty == y) {
			
			if (tx == x && ty == y) {
				tx = gen.nextInt(5);
				ty = gen.nextInt(5);

				while (tx == x && ty == y) {
					tx = gen.nextInt(5);
					ty = gen.nextInt(5);
				}
			}

			acel -= 1000;

			remain -= 1;
			System.out.println("Bombs remaining: " + remain);

			timer.stop();
			time = maxTime;
			timer = new Timer(acel / speed, this);
			timer.start();

		}

		updateMap();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}

//25 x 4 = 100 - 26 = 74
