package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Listener für das Theme-Menü
 * 
 * @author westphahl
 *
 */
public class ThemeMenuListener implements ActionListener {

	/**
	 */
	private MainWindow mainWin;
	
	/**
	 * Konstruktor des ThemeMenuListeners
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public ThemeMenuListener(MainWindow mw) {
		this.mainWin = mw;
	}

	/**
	 * Reaktion auf Auswahl eines Themes.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		MainWindow mw = (MainWindow) ((JMenuItem) ae.getSource()).getTopLevelAncestor();
		/*MainWindow mw = (MainWindow)
			((JMenu)
				((JPopupMenu)
						((JMenu) 
								((JPopupMenu) 
										((JMenuItem) ae.getSource()).getParent()
								).getInvoker()
						).getParent()
				).getInvoker()
			).getTopLevelAncestor();
			*/
		System.out.println(mw);
		this.mainWin.setCurrentTheme(ae.getActionCommand());
	}

}
