package bspFrame;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class UnserGridLayout extends JFrame {

	public UnserGridLayout() {
		super("Beispiel GridLayout");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("/Users/d041670/Development/eclipse/vorlesung/WWI13SEB_UI/assests/thumb3.png");
		this.setLayout(new GridLayout(0, 3));
		
		for(int i = 0; i < 20; i++){
			
			JPanel panel = new JPanel(new FlowLayout());
			panel.add(new JButton(img));
			
			this.add(panel);
			
			//this.add(new JPanel(new FlowLayout()).add(new JButton("Button " + i));
		}
		
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		UnserGridLayout frame = new UnserGridLayout();

	}

}
