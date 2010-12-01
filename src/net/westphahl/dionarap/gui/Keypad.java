package net.westphahl.dionarap.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.westphahl.dionarap.listener.MovementListener;

/**
 * The keypad which holds the buttons for in game navigation.
 * 
 * @author westphahl
 *
 */
public class Keypad extends JPanel {
	
	private JButton keys[] = new JButton[9];
	private Dimension keyDimension = new Dimension(50, 50);
	
	/**
	 * Constructor for the keypad
	 * 
	 * Creates the numbered buttons.
	 */
	public Keypad() {
		/* Use a grid layout for the keypad */
		this.setLayout(new GridLayout(3, 3));
		
		for (int i = 3; i > 0; i--) {
			for (int k = 2; k >= 0; k--) {
				keys[i * 3 - k - 1] = new JButton(Integer.toString(i * 3 - k));
				keys[i * 3 - k -1].setActionCommand((Integer.toString(i * 3 - k)));
				keys[i * 3 - k -1].addActionListener(new MovementListener());
				this.add(keys[i * 3 - k - 1]);
			}
		}
		this.setVisible(true);
	}
}
