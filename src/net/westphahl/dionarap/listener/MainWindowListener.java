package net.westphahl.dionarap.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import net.westphahl.dionarap.gui.MainWindow;

public class MainWindowListener implements ComponentListener, WindowListener {

	private void setNavigatorVisible(ComponentEvent e, boolean visible) {
		MainWindow mWin = (MainWindow) e.getComponent();
		mWin.getNavigator().setVisible(visible);
	}
	
	@Override
	public void componentHidden(ComponentEvent e) {
		this.setNavigatorVisible(e, false);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		MainWindow mWin = (MainWindow) e.getComponent();
		mWin.getNavigator().setPosition();
 	}

	@Override
	public void componentResized(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {
		this.setNavigatorVisible(e, true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		this.setNavigatorVisible(e, true);	
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {
		this.setNavigatorVisible(e, false);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		this.setNavigatorVisible(e, true);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		this.setNavigatorVisible(e, false);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

}
