package net.westphahl.dionarap.listener;

import javax.swing.JOptionPane;

import net.westphahl.dionarap.gui.MainWindow;
import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;

/**
 * Event listener for model and status change events.
 * 
 * @author Simon Westphahl
 *
 */
public class ChangeStateListener implements DionaRapListener {

	private MainWindow mainWindow;
	
	/**
	 * Constructor for the ChangeListener.
	 * Saves a reference of the main window for further use.
	 * 
	 * @param mainWin
	 */
	public ChangeStateListener(MainWindow mWin) {
		this.mainWindow = mWin;
	}
	
	/**
	 * Redraws the pawns in case of a model change event.
	 */
	@Override
	public void modelChanged(DionaRapChangedEvent e) {
		this.mainWindow.getPlayboard().drawPawns();
		this.mainWindow.getNavigator().setScore(
				this.mainWindow.getDRModel().getScore());
	}

	/**
	 * Handles the situation when a game is won/lost.
	 */
	@Override
	public void statusChanged(GameStatusEvent e) {
		if (e.isGameWon() || e.isGameOver()) {
			if (e.isGameWon()) {
				JOptionPane.showMessageDialog(this.mainWindow, "Winner!",
						"You won ...", JOptionPane.INFORMATION_MESSAGE, 
						this.mainWindow.getPlayboard().getGameWonIcon());
			} else {
				JOptionPane.showMessageDialog(this.mainWindow, "Game Over!",
						"You lost ...", JOptionPane.INFORMATION_MESSAGE, 
						this.mainWindow.getPlayboard().getGameOverIcon());
			}
			
			this.mainWindow.getNavigator().setScore(
					this.mainWindow.getDRModel().getScore());
			this.mainWindow.getNavigator().getStartButton().setEnabled(true);
		}
	}

}
