import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	
	/*JPanel mp = new JPanel();
	JFrame mf = new JFrame();
	JButton up = new JButton();
	JButton down = new JButton();
	JButton left = new JButton();
	JButton right = new JButton();*/
			
	int time;
	int maxTime = 3;
	int speed = 30;
	Timer timer;

	int acel = 30000;
	
	int x = 2;
	int y = 2;
	
	int tx;
	int ty;
	
	int points;

	Random gen = new Random();
	
	public static void main(String[] args) {
		Bome_Defusal backup_plan = new Bome_Defusal();
		backup_plan.start();
		
}
	
	
	public void start() {
		
		tx = gen.nextInt(5);
		ty = gen.nextInt(5);
		
		
		//mp.add(up);
		//mp.add(down);
		//mp.add(left);
		//mp.add(right);

		//up.setText("Up");
		//down.setText("Down");
		//left.setText("Left");
		//right.setText("Right");

		//mf.add(mp);
		//mf.pack();
		//mf.show();

		//up.addActionListener(this);
		//down.addActionListener(this);
		//left.addActionListener(this);
		//right.addActionListener(this);

		
		gf.addKeyListener(this);
	
		
		gp.add(gl);

		gf.add(gp);
		gf.pack();
		gf.show();
		
		gf.setPreferredSize(new Dimension(100,125));
		
		

		gl.setText("<html>- - - - -<br>- - - - -<br>- - X - -<br>- - - - -<br>- - - - -</html>");
	
		gf.pack();
		
	
		
		time = maxTime;
timer = new Timer(acel/speed, this);
timer.start();

		
		
	}


	
	
	
	
	//Up = y + 1
	//Down = y - 1
	//Left = x - 1
	//Right = x + 1
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(time);
		
		time-=1;
		if(time<=0) {
			time=maxTime;
			timer.stop();
			if(acel<=7500) {
				timer.stop();
				System.out.println("You Win!");
			}else {
				
				timer.stop();
				System.out.println("You Lose!");
				
				/*acel-=1000;
			timer = new Timer(acel/speed, this);
			timer.start();
			tx = gen.nextInt(5);
			ty = gen.nextInt(5);*/
				
			}
			

		}

		
		/*	
		if(e.getSource()==up){
			y-=1;
			if(y<0) {
				y=0;
			}
		}
		if(e.getSource()==down){
			y+=1;
			if(y>4) {
				y=4;
			}
		}	
		if(e.getSource()==left){
			x-=1;
			if(x<0) {
				x=0;
			}
		}
		if(e.getSource()==right){
			x+=1;
			if(x>4) {
				x=4;
			}
		}
		*/
		
		
		
		
		updateMap();

		
		
		
		
		
	}
	
	
	public void updateMap() {
	
		String map = "<html>";
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				if(x==j && y==i) {
					map+=" X ";
				}else if(tx==j && ty==i){
					if(tx==x && ty==y) {
					tx = gen.nextInt(5);
					ty = gen.nextInt(5);
					}else {
					map+=" " + time + " ";
					}
				}else {
					map+=" - ";
				}
				
				
			}
			map+="<br>";
		}
		
		gl.setText(map);

		gf.pack();

		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==38) {
			y-=1;
			if(y<0) {
				y=0;
			}
		}
		if(e.getKeyCode()==40) {
			y+=1;
			if(y>4) {
				y=4;
			}
		}
		if(e.getKeyCode()==37) {
			x-=1;
			if(x<0) {
				x=0;
			}
		}
		if(e.getKeyCode()==39) {
			x+=1;
			if(x>4) {
				x=4;
			}
		}
		
		if(tx==x && ty==y) {
			tx = gen.nextInt(5);
			ty = gen.nextInt(5);
			points+=1;
			//timer.restart();
			acel-=1000;
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
