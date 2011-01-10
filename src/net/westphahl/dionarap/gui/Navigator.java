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
 * Navigator, welcher die Tastatur, Punktestand und den
 * Start-Button enthält.
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
	 * Konstruktor für den Navigator
	 * 
	 * Positioniert den Navigator relativ zum Hauptfenster und
	 * fügt die Tastatur, Bereich für den Punktestand und den
	 * Start-Button der Content-Pane hinzu.
	 * 
	 * @param mainWindow  Referenz auf das Hauptfenster
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
	 * Getter-Methode für das Hauptfenster
	 *
	 * @return  Referenz auf das Hauptfenster
	 */
	public MainWindow getMainWindow() {
		return this.mainWindow;
	}
	
	/**
	 * Methode zur Positionierung des Navigators relativ zum
	 * Hauptfenster.
	 */
	public void setPosition() {
		bounds = this.mainWindow.getBounds();
		this.setLocation(bounds.width + bounds.x + 25, bounds.y);
	}

	/**
	 * Methode um den Punktestand zu aktualiiseren.
	 * 
	 * @param score  Punktestand
	 */
	public void setScore(int score) {
		this.scoreArea.score.setText(Integer.toString(score));
	}
	
	/**
	 * Getter-Methode für den Start-Button
	 * 
	 * @return  Referenz auf den Start-Button
	 */
	public JButton getStartButton() {
		return this.startButton;
	}
}

/**
 * Bereich für den Punktestand
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class ScoreArea extends JPanel {
	
	public JLabel scoreLabel = new JLabel("Score");
	public JTextField score = new JTextField("0");
	
	/**
	 * Konstruktor für den Punktestand-Bereich
	 *  
	 * Erzeugt die Beschriftung sowie das nicht editierbare 
	 * Feld für den Punktestand. Zur Positionierung wird ein
	 * BorderLayout verwendet.
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
