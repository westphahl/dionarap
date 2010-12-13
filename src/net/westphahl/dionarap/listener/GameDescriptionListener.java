package net.westphahl.dionarap.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.westphahl.dionarap.gui.GameDescription;

public class GameDescriptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new GameDescription();
	}

}
