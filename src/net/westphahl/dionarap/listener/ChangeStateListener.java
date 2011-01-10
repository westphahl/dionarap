package net.westphahl.dionarap.listener;

import javax.swing.JOptionPane;

import net.westphahl.dionarap.gui.MainWindow;
import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;

/**
 * Listener für Statusänderungen.
 * 
 * @author westphahl
 *
 */
public class ChangeStateListener implements DionaRapListener {

	private MainWindow mainWindow;
	
	/**
	 * Konstruktor für den ChangeStateListener.
	 * 
	 * @param mainWin  Referenz auf das Hauptfenster
	 */
	public ChangeStateListener(MainWindow mWin) {
		this.mainWindow = mWin;
	}
	
	/**
	 * Methode veranlasst das Neuzeichnen der Figuren bei einer
	 * Änderung der Spielerpositionen.
	 */
	@Override
	public void modelChanged(DionaRapChangedEvent e) {
		this.mainWindow.getPlayboard().drawPawns();
		this.mainWindow.getNavigator().setScore(
				this.mainWindow.getDRModel().getScore());
	}

	/**
	 * Methode zur Behandlung des Falls, wenn ein Spiel gewonnen oder
	 * verloren wurde.
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
