package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.westphahl.dionarap.gui.MainWindow;

public class LookAndFeelMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem lookAndFeelItem = (JMenuItem) ae.getSource();

		/* FUCK YOU Java! */
		MainWindow mainWindow = (MainWindow)
			((JMenu)
				((JPopupMenu)
					((JMenu) 
						((JPopupMenu)
							lookAndFeelItem.getParent()
						).getInvoker()
					).getParent()
				).getInvoker()
			).getTopLevelAncestor();
		
		try {
			UIManager.setLookAndFeel(lookAndFeelItem.getActionCommand());
			SwingUtilities.updateComponentTreeUI(mainWindow);
			SwingUtilities.updateComponentTreeUI(mainWindow.getNavigator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
