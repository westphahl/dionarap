package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import net.westphahl.dionarap.gui.MainWindow;

public class ToggleNavigatorMenuListener implements ActionListener {

	private boolean navigatorVisibe = true;
	private MainWindow mainWin;
	
	public ToggleNavigatorMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

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
