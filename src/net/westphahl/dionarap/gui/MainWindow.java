package net.westphahl.dionarap.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import net.westphahl.dionarap.listener.ChangeStateListener;
import net.westphahl.dionarap.listener.MainWindowListener;
import net.westphahl.dionarap.listener.MovementListener;
import net.westphahl.dionarap.listener.WeaponListener;
import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Ammo;
import de.fhwgt.dionarap.model.objects.Destruction;
import de.fhwgt.dionarap.model.objects.Obstacle;
import de.fhwgt.dionarap.model.objects.Opponent;
import de.fhwgt.dionarap.model.objects.Player;
import de.fhwgt.dionarap.model.objects.Vortex;

/**
 * The DionaRap main window
 * 
 * Holds the playboard of the game.
 * 
 * @author westphahl
 *
 */
public class MainWindow extends JFrame {
	
	private int rows = 10;
	private int cols = 10;
	public Playboard playboard;
	public Navigator navigator;
	public DionaRapModel drModel;
	public DionaRapController drController;
	
	/**
	 * Constructor of the main window
	 *
	 * Adds the playboard as the only component
	 * @param title
	 */
	public MainWindow(String title) {
		super(title);
		
		/* Add the playboard */
		this.playboard = new Playboard(this.rows, this.cols);
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
	
	/**
	 * Function for (re)drawing the pawns.
	 */
	public void drawPawns() {
		int numPawns = this.drModel.getAllPawns().length;
		AbstractPawn aPawns[] = new AbstractPawn[numPawns];
		aPawns = this.drModel.getAllPawns();
		
		this.playboard.eraseFields();
		
		for (int i = 0; i < numPawns; i++) {
			if (aPawns[i] instanceof Player) {
				 this.playboard.drawPlayer(aPawns[i]);
			} else if (aPawns[i] instanceof Destruction) {
				this.playboard.drawDestroyedField(aPawns[i]);
			} else if (aPawns[i] instanceof Opponent) {
				this.playboard.drawEnemy(aPawns[i]);
			} else if (aPawns[i] instanceof Obstacle) {
				this.playboard.drawBarrier(aPawns[i]);
			} else if (aPawns[i] instanceof Vortex) {
				this.playboard.drawVortex(aPawns[i]);
			} else if (aPawns[i] instanceof Ammo) {
				this.playboard.drawAmmo(aPawns[i]);
			}
		}
	}
	
	public void startGame() {
		this.drModel = new DionaRapModel();
		this.drController = new DionaRapController(drModel);
		this.drModel.addModelChangedEventListener(
				new ChangeStateListener(this));
		this.drawPawns();
		this.navigator.startButton.setEnabled(false);
	}
}
