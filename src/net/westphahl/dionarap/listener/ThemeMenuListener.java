package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.MainWindow;

public class ThemeMenuListener implements ActionListener {

	private MainWindow mainWin;
	
	public ThemeMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		this.mainWin.setCurrentTheme(ae.getActionCommand());
	}

}
