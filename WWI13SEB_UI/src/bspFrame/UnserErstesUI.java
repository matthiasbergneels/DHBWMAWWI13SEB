package bspFrame;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UnserErstesUI {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Unser erstes UI");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel text = new JLabel("Hallo Klaus!");
		
		
		
		//frame.add(text);
		
		frame.getContentPane().add(new JLabel("Tschüss Gabi!"));
		frame.getContentPane().add(text);
		
		
		
		//frame.setBounds(200, 200, 300, 150);
		frame.pack();
		frame.setVisible(true);
		

	}

}
