package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.westphahl.dionarap.gui.MainWindow;

public class LookAndFeelMenuListener implements ActionListener {
	
	private MainWindow mainWin;
	
	public LookAndFeelMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem lookAndFeelItem = (JMenuItem) ae.getSource();

		try {
			UIManager.setLookAndFeel(lookAndFeelItem.getActionCommand());
			SwingUtilities.updateComponentTreeUI(this.mainWin);
			SwingUtilities.updateComponentTreeUI(this.mainWin.getNavigator());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
