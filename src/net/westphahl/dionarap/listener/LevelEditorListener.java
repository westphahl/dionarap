package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.LevelEditorWindow;

/**
 * Listener zur Anzeige des Level-Editors
 * 
 * @author westphahl
 *
 */
public class LevelEditorListener implements ActionListener {

	/**
	 * Anzeige des Level-Editors, wenn der entsprechende zugehörige
	 * Menüpunkt ausgewählt wurde.
	 */
	public void actionPerformed(ActionEvent e) {
		new LevelEditorWindow();
	}

}
