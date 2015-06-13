package bspFrame;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class UnserBorderLayout extends JFrame {

	public UnserBorderLayout(String title){
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel(new FlowLayout());
		JPanel southPanel = new JPanel(new FlowLayout());
		JPanel centerPanel = new JPanel(new FlowLayout());
		JPanel westPanel = new JPanel(new FlowLayout());
		JPanel eastPanel = new JPanel(new FlowLayout());
		
		northPanel.add(new JButton("Norden"));
		southPanel.add(new JButton("South"));
		centerPanel.add(new JButton("Mitte"));
		westPanel.add(new JButton("Westen"));
		eastPanel.add(new JButton("Osten"));
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		UnserBorderLayout frame = new UnserBorderLayout("Border Layout Beispiel");

	}

}
