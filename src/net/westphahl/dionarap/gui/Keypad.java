package net.westphahl.dionarap.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.westphahl.dionarap.listener.MovementListener;
import net.westphahl.dionarap.listener.WeaponListener;

/**
 * The keypad which holds the buttons for in game navigation.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class Keypad extends JPanel {
	
	private JButton keys[] = new JButton[9];
	/**
	 * Constructor for the keypad
	 * 
	 * Creates the numbered buttons.
	 */
	public Keypad() {
		/* Use a grid layout for the keypad */
		this.setLayout(new GridLayout(3, 3));
		int index;
		
		for (int i = 3; i > 0; i--) {
			for (int k = 2; k >= 0; k--) {
				index = i * 3 - k -1;
				keys[index] = new JButton(Integer.toString(index + 1));
				keys[index].setActionCommand((Integer.toString(index + 1)));
				if (index == 4) {
					keys[index].addActionListener(new WeaponListener());
				} else {
					keys[index].addActionListener(new MovementListener());
				}
				
				this.add(keys[index]);
			}
		}
		this.setVisible(true);
	}
}
