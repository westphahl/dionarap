package net.westphahl.dionarap.gui;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JWindow;

import net.westphahl.dionarap.gui.Keypad;

public class Navigator extends JWindow {
	
	private Keypad keypad;
	public JTextField score = new JTextField("0");
	public JButton startButton = new JButton("New Game");
	
	public Navigator(MainWindow mainWindow) {
		super(mainWindow);
		
		this.add(new Keypad());
		
		this.pack();
		this.setSize(200, 150);
		this.setVisible(true);
	}
}
