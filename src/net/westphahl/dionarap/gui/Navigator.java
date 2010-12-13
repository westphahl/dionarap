package net.westphahl.dionarap.gui;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

import net.westphahl.dionarap.gui.Keypad;
import net.westphahl.dionarap.listener.NewGameListener;

/**
 * Navigator which holds keypad, score and a button to start
 * a new game.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class Navigator extends JWindow {
	
	private Keypad keypad;
	private ScoreArea scoreArea = new ScoreArea();
	private Rectangle bounds;
	private JButton startButton = new JButton("New Game");
	private MainWindow mainWindow;
	
	/**
	 * Constructor for the Navigator
	 * 
	 * Positions the navigator relative to the given JFrame and
	 * adds keypad, score area and button to start a new game.
	 * 
	 * @param mainWindow
	 */
	public Navigator(MainWindow mainWindow) {
		super(mainWindow);
		this.mainWindow = mainWindow;
		
		this.keypad = new Keypad();
		
		this.setPosition();
		
		/* Add all components */
		this.add(keypad, BorderLayout.NORTH);
		this.add(scoreArea, BorderLayout.CENTER);
		this.add(startButton, BorderLayout.SOUTH);
		
		this.pack();
		this.startButton.addActionListener(new NewGameListener());
		
		/* Set size and show navigator */
		this.setSize(200, 150);
		this.setVisible(true);
	}
	
	/**
	 * Function for fetching the main window.
	 *
	 * @return
	 */
	public MainWindow getMainWindow() {
		return this.mainWindow;
	}
	
	/**
	 * Set the position of the navigator relative to
	 * the main window.
	 */
	public void setPosition() {
		bounds = this.mainWindow.getBounds();
		this.setLocation(bounds.width + bounds.x + 25, bounds.y);
	}

	public void setScore(int score) {
		this.scoreArea.score.setText(Integer.toString(score));
	}
	
	public JButton getStartButton() {
		return this.startButton;
	}
}

/**
 * Score area
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class ScoreArea extends JPanel {
	
	public JLabel scoreLabel = new JLabel("Score");
	public JTextField score = new JTextField("0");
	
	/**
	 * Constructor of the score area.
	 * 
	 * Includes a label for the score area and the score.
	 */
	public ScoreArea() {
		/* Use a border layout */
		this.setLayout(new BorderLayout());
		
		/* Add label and score */
		this.add(scoreLabel, BorderLayout.NORTH);
		this.add(score, BorderLayout.CENTER);
		
		/* Disable the text field */
		this.score.setEnabled(false);
		/* Set to visible */
		this.setVisible(true);
	}
	
}
