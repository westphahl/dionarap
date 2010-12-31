package net.westphahl.dionarap;

import javax.swing.UIManager;
import net.westphahl.dionarap.gui.MainWindow;

/**
 * Class for running DionaRap
 * 
 * @author westphahl
 *
 */
public class DionaRap {
	
	private static MainWindow mainWindow = null;

	/**
	 * Run DionaRap
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
		DionaRap.mainWindow = new MainWindow("DionaRap");
	}
	
	public static MainWindow getMainWindow() {
		return DionaRap.mainWindow;
	}

}
