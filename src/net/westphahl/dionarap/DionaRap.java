package net.westphahl.dionarap;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Class for running DionaRap
 * 
 * @author westphahl
 *
 */
public class DionaRap {

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
	    catch (UnsupportedLookAndFeelException e) {
	    	System.exit(1);
	    }
	    catch (ClassNotFoundException e) {
	    	System.exit(1);
	    }
	    catch (InstantiationException e) {
	    	System.exit(1);
	    }
	    catch (IllegalAccessException e) {
	    	System.exit(1);
	    }
		MainWindow mwindow = new MainWindow("DionaRap");
	}

}
