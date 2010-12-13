package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.dionarap.gui.MainWindow;

public class ToggleNavigatorMenuListener implements ActionListener {

	private boolean navigatorVisibe = true;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem toggleMenuItem = (JMenuItem) e.getSource();
		
		MainWindow mainWindow = (MainWindow) ((JMenu) ((JPopupMenu)
				toggleMenuItem.getParent()).getInvoker()).getTopLevelAncestor();
		
		if (this.navigatorVisibe) {
			mainWindow.getNavigator().setVisible(false);
			this.navigatorVisibe = false;
			toggleMenuItem.setText("Navigator einblenden");
		} else {
			mainWindow.getNavigator().setVisible(true);
			this.navigatorVisibe = true;
			toggleMenuItem.setText("Navigator ausblenden");
		}
	}
}
