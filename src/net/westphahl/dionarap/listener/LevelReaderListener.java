package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import net.westphahl.dionarap.gui.MainWindow;

/**
 * Listener für Anzeige des Dialogs zum Einlesen eines Levels.
 * 
 * @author westphahl
 *
 */
public class LevelReaderListener implements ActionListener {
	
	private MainWindow mainWin;
	private String levelDefaultPath;
	private JFileChooser fileChooser;
	
	/**
	 * Konstruktor des LevelReaderListeners.
	 * Registriert einen ActionListener zur Reaktion auf einen neues
	 * eingelesenes Level.
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public LevelReaderListener(MainWindow mw) {
		this.mainWin = mw;
		this.levelDefaultPath = System.getProperty("user.dir") 
			+ File.separator + "levels" + File.separator;
		this.fileChooser = new JFileChooser(this.levelDefaultPath);
		this.fileChooser.addActionListener(new LevelFileListener(this.mainWin));
	}

	/**
	 * Anzeige eines "Datei-Öffnen"-Dialoges bei Auswahl des
	 * entsprechenden Menüpunktes.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fileChooser.showOpenDialog(this.mainWin);
		
	}

}
