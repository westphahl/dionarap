package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.TokenHelp;

public class TokenHelpListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem toggleMenuItem = (JMenuItem) ae.getSource();
		
		MainWindow mainWindow = (MainWindow) ((JMenu) ((JPopupMenu)
				toggleMenuItem.getParent()).getInvoker()).getTopLevelAncestor();
		
		new TokenHelp(mainWindow);
	}

}
