package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import net.westphahl.dionarap.gui.MainWindow;

public class LevelReaderListener implements ActionListener {
	
	private MainWindow mainWin;
	private String levelDefaultPath;
	private JFileChooser fileChooser;
	
	public LevelReaderListener(MainWindow mw) {
		this.mainWin = mw;
		this.levelDefaultPath = System.getProperty("user.dir") 
			+ File.separator + "levels" + File.separator;
		this.fileChooser = new JFileChooser(this.levelDefaultPath);
		this.fileChooser.addActionListener(new LevelFileListener(this.mainWin));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.fileChooser.showOpenDialog(this.mainWin);
		
	}

}
