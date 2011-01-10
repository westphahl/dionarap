package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Listener für das Theme-Menü
 * 
 * @author westphahl
 *
 */
public class ThemeMenuListener implements ActionListener {

	private MainWindow mainWin;
	
	/**
	 * Konstruktor des ThemeMenuListeners
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public ThemeMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

	/**
	 * Reaktion auf Auswahl eines Themes.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		this.mainWin.setCurrentTheme(ae.getActionCommand());
	}

}
