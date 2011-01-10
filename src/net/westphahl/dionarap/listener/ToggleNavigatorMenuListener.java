package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Listener zum Ein-/Ausschalten des Navigators
 * 
 * @author westphahl
 *
 */
public class ToggleNavigatorMenuListener implements ActionListener {

	private boolean navigatorVisibe = true;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor des Toggle-Listeners.
	 * 
	 * @param mw  Referenz auf das Hauptfenster.
	 */
	public ToggleNavigatorMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

	/**
	 * Ein-/Ausblenden des Navigators bei Auswahl des
	 * entsprechenden Menüpunktes.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem toggleMenuItem = (JMenuItem) e.getSource();
		
		if (this.navigatorVisibe) {
			this.mainWin.getNavigator().setVisible(false);
			this.navigatorVisibe = false;
			toggleMenuItem.setText("Navigator einblenden");
		} else {
			this.mainWin.getNavigator().setVisible(true);
			this.navigatorVisibe = true;
			toggleMenuItem.setText("Navigator ausblenden");
		}
	}
}
