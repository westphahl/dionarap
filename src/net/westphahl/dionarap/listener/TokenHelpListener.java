package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.TokenHelp;

/**
 * Listener zur Anzeige der Hilfe zu den Spielfiguren.
 * 
 * @author westphahl
 *
 */
public class TokenHelpListener implements ActionListener {

	private MainWindow mainWin;
	
	/**
	 * Konstruktor für den Spielfigurenhilfe-Listener.
	 * 
	 * @param mw  Referenz auf das Hauptfenster.
	 */
	public TokenHelpListener(MainWindow mw) {
		this.mainWin = mw;
	}

	/**
	 * Anzeige der Hilfe bei Auswahl des entsprechenden Menüpunktes.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		new TokenHelp(this.mainWin);
	}

}
