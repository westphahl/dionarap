package net.westphahl.dionarap.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Keypad extends JPanel {
	
	private int rows = 3;
	private int cols = 3;
	private JButton keys[] = new JButton[this.rows * this.cols];
	
	private Dimension keyDimension = new Dimension(50, 50);
	
	public Keypad() {
		super();
		this.setLayout(new GridLayout(this.rows, this.cols));
		
		for (int i = 0; i < (this.rows * this.cols); i++) {
			keys[i] = new JButton("Hello");
		}
		this.setVisible(true);
	}
}
