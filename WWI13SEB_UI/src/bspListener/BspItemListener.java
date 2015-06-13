package bspListener;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BspItemListener extends JFrame implements ActionListener{

	protected static final String ACTION_CLOSE = "ACTION_CLOSE";
	protected static final String ACTION_READ = "ACTION_READ";

	private JComboBox<String>  myBox; 
	
	public BspItemListener(String title){
	super(title);
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	this.setLayout(new BorderLayout());
	
	JPanel northPanel = new JPanel(new FlowLayout());
	JPanel southPanel = new JPanel(new FlowLayout());
	JPanel centerPanel = new JPanel(new FlowLayout());
	JPanel westPanel = new JPanel(new FlowLayout());
	JPanel eastPanel = new JPanel(new FlowLayout());
	
	
	
	myBox = new JComboBox<String>();
	myBox.addItem("Klaus");
	myBox.addItem("Hans");
	myBox.addItem("Moni");
	
	JButton ostButton = new JButton("Auslesen");
	ostButton.setActionCommand(ACTION_READ);
	JButton suedButton = new JButton("Zu mache");
	suedButton.setActionCommand(ACTION_CLOSE);
	
	//ActionListener buttonAction = new ButtonAction(myBox);
	
	/*
	ActionListener buttonAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(e.getActionCommand());
			//((JButton)e.getSource()).setText("Gedrückt!");
			//System.out.println("Action");
			
			//if(e.getSource().equals(suedButton)){
			//	System.exit(0);
			//}
			
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals(ACTION_CLOSE)){
				System.exit(0);
			}else if(actionCommand.equals(ACTION_READ)){
				System.out.println(myBox.getSelectedItem());
			}
			
			
			
		}
	};*/
	
	ostButton.addActionListener(this);
	suedButton.addActionListener(this);
	
	ItemListener boxListener = new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){
				System.out.println(e.getItem());
				System.out.println("State changed! - Selected");
			}
			
		}
	};
	
	myBox.addItemListener(boxListener);
	
	northPanel.add(new JButton("Norden"));
	southPanel.add(suedButton);
	centerPanel.add(myBox);
	westPanel.add(new JButton("Westen"));
	eastPanel.add(ostButton);
	
	this.add(northPanel, BorderLayout.NORTH);
	this.add(southPanel, BorderLayout.SOUTH);
	this.add(centerPanel, BorderLayout.CENTER);
	this.add(westPanel, BorderLayout.WEST);
	this.add(eastPanel, BorderLayout.EAST);
	
	
	this.pack();
	this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals(ACTION_CLOSE)){
			System.exit(0);
		}else if(actionCommand.equals(ACTION_READ)){
			System.out.println(myBox.getSelectedItem());
		}
		
	}
	
	
	public static void main(String[] args){
		new BspItemListener("Listener Beispiel");
	}
}
