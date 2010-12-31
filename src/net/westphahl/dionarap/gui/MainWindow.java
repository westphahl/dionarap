package net.westphahl.dionarap.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import net.westphahl.dionarap.listener.ChangeStateListener;
import net.westphahl.dionarap.listener.MainWindowListener;
import net.westphahl.dionarap.listener.MovementListener;
import net.westphahl.dionarap.listener.WeaponListener;
import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.data.Grid;
import de.fhwgt.dionarap.model.data.MTConfiguration;

/**
 * The DionaRap main window
 * 
 * Holds the playboard of the game.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private MenuBar menuBar;
	private Playboard playboard;
	private Navigator navigator;
	private DionaRapModel drModel;
	private DionaRapController drController;
	private MTConfiguration conf;
	private String currentTheme = "Dracula";
	
	/**
	 * Constructor of the main window
	 *
	 * Adds the playboard as the only component
	 * @param title
	 */
	public MainWindow(String title) {
		super(title);
		
		this.menuBar = new MenuBar(this);
		this.setJMenuBar(this.menuBar);
		
		/* Exit application when window is closed */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Add listeners */
		this.addComponentListener(new MainWindowListener());
		this.addWindowListener(new MainWindowListener());
		this.addKeyListener(new MovementListener());
		this.addKeyListener(new WeaponListener());
		
		/* Use multi-threading */
		this.configMT();
		/* Initialize the game logic */
		this.initDefaultModel();
		/* Initialize the GUI */
		this.initGUI();
		
		/* Show the navigator */
		this.navigator = new Navigator(this);
		this.navigator.setScore(
				this.drModel.getScore());
		
		/* Show the main window */
		this.setVisible(true);
		
		this.startGame();
	}
	
	public void configMT() {
		this.conf = new MTConfiguration();
		this.conf.setAlgorithmAStarActive(true);
		this.conf.setAvoidCollisionWithObstacles(true);
		this.conf.setAvoidCollisionWithOpponent(false);
		this.conf.setMinimumTime(800); // 0,8 Sekunden
		this.conf.setShotGetsOwnThread(true); // nicht unbegrenzte Anzahl Schüsse
		this.conf.setOpponentStartWaitTime(5000); // 5 Sekunden am Anfang Schlaf
		this.conf.setOpponentWaitTime(2000); // Gegner warten vor jedem Zug 2 Sekunden
		this.conf.setShotWaitTime(500); // ein Schuss benötigt eine halbe Sekunde
		this.conf.setRandomOpponentWaitTime(false); // keine zufällige Wartezeit
		this.conf.setDynamicOpponentWaitTime(false); // immer gleichlang warten
	}
	
	public void initDefaultModel() {
		this.drModel = new DionaRapModel();
		this.drModel.addModelChangedEventListener(
				new ChangeStateListener(this));
	}
	
	public void initGUI() {
		Grid grid = this.drModel.getGrid();
		
		/* 
		 * Remove the old playboard from the content pane
		 * and add a new one.
		 */
		if (this.playboard != null) {
			this.remove(this.playboard);
		}
		this.playboard = new Playboard(this, grid.getGridSizeX(), grid.getGridSizeY(),
				this.currentTheme );
		this.add(this.playboard, BorderLayout.CENTER);
		
		/* Resize to optimal width and height. */
		this.pack();
		
		/* Set navigator position */
		if (this.navigator != null) {
			this.navigator.setPosition();
		}
	}
	
	public void startGame() {		
		this.drController = new DionaRapController(this.drModel);
		this.drController.setMultiThreaded(this.conf);
		
		this.playboard.drawPawns();
		this.navigator.getStartButton().setEnabled(false);
	}
	
	public Navigator getNavigator() {
		return this.navigator;
	}
	
	public Playboard getPlayboard() {
		return this.playboard;
	}

	public DionaRapModel getDRModel() {
		return this.drModel;
	}

	public DionaRapController getDRController() {
		return this.drController;
	}
	
	public MTConfiguration getMTconf() {
		return this.conf;
	}

	public void setCurrentTheme(String themeName) {
		this.currentTheme = themeName;
		this.playboard.setTheme(this.currentTheme);
		this.playboard.drawPawns();
	}
}
