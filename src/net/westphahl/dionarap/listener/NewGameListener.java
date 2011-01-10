package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.Navigator;

/**
 * Listener zum Starten eines neuen Spiels.
 * @author westphahl
 *
 */
public class NewGameListener implements ActionListener {
	
	/**
	 * Starten eines neuen Spiels.
	 * 
	 * Initialisierung des default Models, initialisierung der GUI und
	 * Start eines neuen Spiels.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = ((Navigator) (
				(JComponent) e.getSource()).getTopLevelAncestor()).getMainWindow();
		
		mainWindow.initDefaultModel();
		mainWindow.initGUI();
		mainWindow.startGame();
		mainWindow.requestFocus();
	}

}
