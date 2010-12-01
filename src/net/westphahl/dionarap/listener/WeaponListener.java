package net.westphahl.dionarap.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.westphahl.dionarap.gui.MainWindow;

public class WeaponListener implements KeyListener {

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
			mainWindow.drController.shoot();
		}
	}

}
