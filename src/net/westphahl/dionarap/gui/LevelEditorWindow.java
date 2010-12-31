package net.westphahl.dionarap.gui;

import javax.swing.JDialog;

import de.dionarap.leveleditor.gui.LevelEditor;
import de.dionarap.leveleditor.model.GameSettingsModel;

@SuppressWarnings("serial")
public class LevelEditorWindow extends JDialog {
	
	private LevelEditor levelEditor;
	private GameSettingsModel gameSettingsModel;
	
	public LevelEditorWindow() {
		this.gameSettingsModel = new GameSettingsModel();
		this.levelEditor = new LevelEditor(this.gameSettingsModel);
		
		this.add(this.levelEditor);
		this.pack();
		this.setVisible(true);
	}

}
