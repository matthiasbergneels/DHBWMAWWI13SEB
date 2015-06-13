package bspListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ButtonAction implements ActionListener {

	private JComboBox box;
	
	public ButtonAction(JComboBox box) {
		this.box = box;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals(BspItemListener.ACTION_CLOSE)){
			System.exit(0);
		}else if(actionCommand.equals(BspItemListener.ACTION_READ)){
			JButton btn = (JButton)e.getSource();
			System.out.println(box.getSelectedItem());
		}

	}

}
