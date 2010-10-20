package net.westphahl.dionarap.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A playboard which looks like a checkerboard.
 * 
 * @author Simon Westphahl
 */
public class Playboard extends JPanel {
	
	private int rows;
	private int cols;
	private JLabel fields[][];
	private Dimension fieldDimension = new Dimension(50, 50);
	
	/**
	 * Creates a playboard according to the supplied rows and columns.
	 * 
	 * @param rows Number of rows.
	 * @param cols Number of columns.
	 */
	public Playboard(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		
		fields = new JLabel[this.rows][this.cols];
		
		this.setLayout(new GridLayout(this.rows, this.cols));
		
		for (int i = 0; i < this.cols; i++) {
			for (int k = 0; k < this.rows; k++) {
				fields[i][k] = new JLabel();
				fields[i][k].setOpaque(true);
				fields[i][k].setPreferredSize(this.fieldDimension);
				
				/* Toggle between two colors. */
				if (((i + k) % 2) == 0) {
					fields[i][k].setBackground(Color.RED);
				} else {
					fields[i][k].setBackground(Color.WHITE);
				}
				this.add(fields[i][k]);
			}
		}
		this.setVisible(true);
	}
}
