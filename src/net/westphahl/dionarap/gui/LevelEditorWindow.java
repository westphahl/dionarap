package net.westphahl.dionarap.gui;

import javax.swing.JDialog;

import de.dionarap.leveleditor.gui.LevelEditor;
import de.dionarap.leveleditor.model.GameSettingsModel;

/**
 * Dialogfenster in welchem der Level-Editor geladen wird.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class LevelEditorWindow extends JDialog {
	
	private LevelEditor levelEditor;
	private GameSettingsModel gameSettingsModel;
	
	/**
	 * Konstruktor des Dialogfenster.
	 * 
	 * Der Konstruktur erzeugt eine neue Instanz eines Level-Editors
	 * und zeigt diesen in seiner "ContentPane" an.
	 * Zusätzlich wird eine Instanz für die Spieleeinstellungen erzeugt,
	 * welche dem Level-Editor bei der instanziierung übergeben wird.
	 */
	public LevelEditorWindow() {
		this.gameSettingsModel = new GameSettingsModel();
		this.levelEditor = new LevelEditor(this.gameSettingsModel);
		
		this.add(this.levelEditor);
		this.pack();
		this.setVisible(true);
	}

}
