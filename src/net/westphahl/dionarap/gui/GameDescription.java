package net.westphahl.dionarap.gui;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GameDescription extends JDialog {

	private JEditorPane editorPane;
	private JScrollPane scrollPane;
	
	public GameDescription() {
		String fileURL = "file:///" + System.getProperty("user.dir") + 
			"/help/game_description.html";
		
		try {
			this.editorPane = new JEditorPane(fileURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.editorPane.setEditable(false);
		this.editorPane.setVisible(true);

		this.scrollPane = new JScrollPane(this.editorPane);
		this.scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.scrollPane.setPreferredSize(new Dimension(650, 600));
		this.scrollPane.setVisible(true);
		
		this.add(this.scrollPane);
		this.pack();
		this.setVisible(true);
	}
}
