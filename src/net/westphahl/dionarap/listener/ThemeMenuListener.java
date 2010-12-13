package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.dionarap.gui.MainWindow;

public class ThemeMenuListener implements ActionListener {

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
		
		mainWindow.getPlayboard().setTheme(ae.getActionCommand());
		mainWindow.getPlayboard().drawPawns();
	}

}
