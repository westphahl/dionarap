package net.westphahl.dionarap.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Listener für Events des Hauptfensters.
 * 
 * @author westphahl
 *
 */
public class MainWindowListener implements ComponentListener, WindowListener {

	private MainWindow mWin;
	
	/**
	 * Konstruktor des MainWindowListeners.
	 * 
	 * @param mw  Referenz auf das Hauptfenster.
	 */
	public MainWindowListener(MainWindow mw) {
		this.mWin = mw;
	}
	
	/**
	 * Ausblenden des Navigators, wenn das Hauptfenster.
	 * nicht sichtbar ist.
	 */
	@Override
	public void componentHidden(ComponentEvent e) {
		mWin.getNavigator().setVisible(false);
	}

	/**
	 * Positionierung des Navigators beim Verschieben des Hauptfensters.
	 */
	@Override
	public void componentMoved(ComponentEvent e) {
		this.mWin.getNavigator().setPosition();
 	}

	@Override
	public void componentResized(ComponentEvent e) {}

	/**
	 * Einblenden des Navigators, wenn das Hauptfenster sichtbar ist.
	 */
	@Override
	public void componentShown(ComponentEvent e) {
		this.mWin.getNavigator().setVisible(true);
	}

	/**
	 * Einblenden des Navigators, wenn das Hauptfenster
	 * den Fokus besitzt.
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		this.mWin.getNavigator().setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	/**
	 * Ausblenden des Navigators, wenn das Hauptfenster
	 * deaktiviert wird.
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		this.mWin.getNavigator().setVisible(false);
	}

	/**
	 * Einblenden des Navigators, wenn das Hauptfenster
	 * wiederhergestellt wird.
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		this.mWin.getNavigator().setVisible(true);
	}

	/**
	 * Ausblenden des Navigators, wenn das Hauptfenster
	 * minimiert wurde.
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		this.mWin.getNavigator().setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

}
