package net.westphahl.dionarap;

import javax.swing.UIManager;
import net.westphahl.dionarap.gui.MainWindow;

/**
 * DionaRap "Main-Klasse" zum Starten des Spiels
 * 
 * @author westphahl
 *
 */
public class DionaRap {

	/**
	 * Starten/Erzeugen des DionaRap-Hauptfensters
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		    /* Set system look and feel */
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception e) {
	    	System.exit(1);
	    }
		new MainWindow("DionaRap");
	}
}
