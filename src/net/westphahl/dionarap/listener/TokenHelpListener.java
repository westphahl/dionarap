package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.TokenHelp;

public class TokenHelpListener implements ActionListener {

	private MainWindow mainWin;
	
	public TokenHelpListener(MainWindow mw) {
		this.mainWin = mw;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		new TokenHelp(this.mainWin);
	}

}
