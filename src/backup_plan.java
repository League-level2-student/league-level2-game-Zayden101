import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class backup_plan implements ActionListener, KeyListener {

	JPanel gp = new JPanel();
	JFrame gf = new JFrame();
	JButton gb = new JButton();
	
	JPanel mp = new JPanel();
	JFrame mf = new JFrame();
	JButton up = new JButton();
	JButton down = new JButton();
	JButton left = new JButton();
	JButton right = new JButton();
			
	int x = 2;
	int y = 2;

	public static void main(String[] args) {
		backup_plan backup_plan = new backup_plan();
		backup_plan.start();
		
}
	
	
	public void start() {
		
		mp.add(up);
		mp.add(down);
		mp.add(left);
		mp.add(right);


		up.setText("Up");
		down.setText("Down");
		left.setText("Left");
		right.setText("Right");


		mf.add(mp);
		mf.pack();
		mf.show();
	
		

		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);

		
		gf.addKeyListener(this);
	
		
		gp.add(gb);

		gf.add(gp);
		gf.pack();
		gf.show();
		
		

		gb.setText("<html>- - - - -<br>- - - - -<br>- - X - -<br>- - - - -<br>- - - - -</html>");
	
		gf.pack();
		
	
	
	}


	
	
	
	
	
	
	//Up = y + 1
	//Down = y - 1
	//Left = x - 1
	//Right = x + 1
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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
		
		
		
	String map = "<html>";
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				if(x==j && y==i) {
					map+="X ";
				}else {
					map+="- ";
				}
				
			}
			map+="<br>";
		}
		
		gb.setText(map);

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
			if(y>0) {
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
			if(x>0) {
				x=4;
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
	
	
}




//25 x 4 = 100 - 26 = 74
