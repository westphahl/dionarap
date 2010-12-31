package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.LevelEditorWindow;

public class LevelEditorListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new LevelEditorWindow();
	}

}
