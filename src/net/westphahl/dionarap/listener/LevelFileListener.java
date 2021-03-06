package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import net.westphahl.dionarap.gui.MainWindow;
import de.fhwgt.dionarap.levelreader.LevelReader;

/**
 * Listener für Reaktion auf eingelesenes Level
 * 
 * @author westphahl
 *
 */
public class LevelFileListener implements ActionListener {
	
	private MainWindow mainWin;
	private LevelReader levelReader;
	
	/**
	 * Konstruktor des LevelFileListeners
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public LevelFileListener(MainWindow mw) {
		this.mainWin = mw;
	}

	/**
	 * Update der Konfiguration mit der des eingelesenen Levels.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.levelReader = new LevelReader(this.mainWin.getMTconf(),
				this.mainWin.getDRModel());
		JFileChooser fileChooser = (JFileChooser) e.getSource();

		if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
			File levelFile = fileChooser.getSelectedFile();
			this.levelReader.readLevel(levelFile.getAbsolutePath());
		} else {
			return;
		}
		
		this.mainWin.initGUI();
		this.mainWin.startGame();
	}

	
}
