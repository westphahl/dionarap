package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import net.westphahl.dionarap.gui.MainWindow;
import net.westphahl.dionarap.gui.Navigator;

public class MovementListener implements KeyListener, ActionListener {

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		MainWindow mainWindow = (MainWindow) e.getSource();
		int cmd = (int) e.getKeyChar() - 48;
		
		if ((cmd >= 0) && (cmd < 10) && (cmd != 5)) {
			mainWindow.drController.movePlayer(cmd);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Navigator navigator = (Navigator) (
				(JComponent) e.getSource()).getTopLevelAncestor();
		MainWindow mainWindow = navigator.getMainWindow();
		
		int command = Integer.valueOf(e.getActionCommand());
		
		if (command == 5) {
			mainWindow.drController.shoot();
		} else {
			mainWindow.drController.movePlayer(command);
		}
		
		mainWindow.drawPawns();
		mainWindow.requestFocus();
	}

}
