package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.Navigator;

public class WeaponListener implements KeyListener, ActionListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		MainWindow mainWindow = (MainWindow) e.getSource();
		int cmd = (int) e.getKeyChar() - 48;
		
		if ((cmd == 5)) {
			mainWindow.getDRController().shoot();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Navigator navigator = (Navigator) (
				(JComponent) e.getSource()).getTopLevelAncestor();
		MainWindow mainWindow = navigator.getMainWindow();
		
		mainWindow.getDRController().shoot();
		mainWindow.requestFocus();
	}

}
