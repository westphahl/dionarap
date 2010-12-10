package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.Navigator;

public class NewGameListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = ((Navigator) (
				(JComponent) e.getSource()).getTopLevelAncestor()).getMainWindow();
		mainWindow.startGame();
		mainWindow.requestFocus();
	}

}
