package net.westphahl.dionarap.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import net.westphahl.dionarap.listener.ChangeStateListener;
import net.westphahl.dionarap.listener.MainWindowListener;
import net.westphahl.dionarap.listener.MovementListener;
import net.westphahl.dionarap.listener.WeaponListener;
import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;

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
	
	private int rows = 10;
	private int cols = 10;
	private MenuBar menuBar;
	private Playboard playboard;
	private Navigator navigator;
	private DionaRapModel drModel;
	private DionaRapController drController;
	
	/**
	 * Constructor of the main window
	 *
	 * Adds the playboard as the only component
	 * @param title
	 */
	public MainWindow(String title) {
		super(title);
		
		this.menuBar = new MenuBar();
		this.setJMenuBar(this.menuBar);
		
		/* Add the playboard */
		this.playboard = new Playboard(this, this.rows, this.cols);
		this.add(this.playboard, BorderLayout.CENTER);
		
		/* Exit application when window is closed */
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Add listeners */
		this.addComponentListener(new MainWindowListener());
		this.addWindowListener(new MainWindowListener());
		this.addKeyListener(new MovementListener());
		this.addKeyListener(new WeaponListener());
		
		/* Resize to optimal width and height. */
		this.pack();
		
		/* Show the navigator */
		this.navigator = new Navigator(this);
	
		this.startGame();
		
		this.navigator.setScore(
				this.drModel.getScore());
		
		/* Show the main window */
		this.setVisible(true);
	}
	
	public void startGame() {
		this.drModel = new DionaRapModel();
		this.drController = new DionaRapController(drModel);
		this.drModel.addModelChangedEventListener(
				new ChangeStateListener(this));
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
}
