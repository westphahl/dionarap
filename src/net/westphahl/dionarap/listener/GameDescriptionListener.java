package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.GameDescription;

/**
 * Listener zur Anzeige der Spielbeschreibung.
 * 
 * @author westphahl
 *
 */
public class GameDescriptionListener implements ActionListener {

	/**
	 * Methode zur Anzeige der Spielbeschreibung, wenn der entsprechende
	 * Menüpunkt ausgewählt wurde.
	 */
	public void actionPerformed(ActionEvent e) {
		new GameDescription();
	}

}
