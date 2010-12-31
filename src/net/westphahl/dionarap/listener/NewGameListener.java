package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.Navigator;

public class NewGameListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = ((Navigator) (
				(JComponent) e.getSource()).getTopLevelAncestor()).getMainWindow();
		
		mainWindow.initDefaultModel();
		mainWindow.initGUI();
		mainWindow.startGame();
		mainWindow.requestFocus();
	}

}
