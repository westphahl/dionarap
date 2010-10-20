package net.westphahl.dionarap.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import net.westphahl.dionarap.gui.Navigator;

import net.westphahl.dionarap.gui.Playboard;

public class MainWindow extends JFrame {
	
	private int rows = 10;
	private int cols = 10;
	
	public MainWindow(String title) {
		super(title);
		
		this.setLayout(new BorderLayout());
		
		Playboard playboard = new Playboard(this.rows, this.cols);
		this.add(playboard);
		
		Navigator navigator = new Navigator(this);
		
		/* Exit application when window is closed */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Resize to optimal width and height. */
		this.pack();
		/* Show the JFrame */
		this.setVisible(true);
	}
}
