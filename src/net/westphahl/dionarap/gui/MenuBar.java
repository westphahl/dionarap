package net.westphahl.dionarap.gui;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;

import net.westphahl.dionarap.listener.GameDescriptionListener;
import net.westphahl.dionarap.listener.LevelEditorListener;
import net.westphahl.dionarap.listener.LevelReaderListener;
import net.westphahl.dionarap.listener.LookAndFeelMenuListener;
import net.westphahl.dionarap.listener.ThemeMenuListener;
import net.westphahl.dionarap.listener.ToggleNavigatorMenuListener;
import net.westphahl.dionarap.listener.TokenHelpListener;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private ConfigMenu configMenu;
	private HelpMenu helpMenu;
	private LevelMenu levelMenu;
	private MainWindow mainWin;
	
	public MenuBar(MainWindow mw) {
		this.mainWin = mw;
		this.configMenu = new ConfigMenu(this.mainWin);
		this.helpMenu = new HelpMenu(this.mainWin);
		this.levelMenu = new LevelMenu(this.mainWin);
		
		this.add(this.configMenu);
		this.add(this.levelMenu);
		this.add(this.helpMenu);
	}
}

@SuppressWarnings("serial")
class ConfigMenu extends JMenu {
	
	private ThemeMenu themeMenu;
	private LookAndFeelMenu lookAndFeelMenu;
	private ToggleNavigatorMItem toggleNavigatorMItem;
	private MainWindow mainWin;
	
	public ConfigMenu(MainWindow mw) {
		super("Konfiguration");
		this.mainWin = mw;
		this.themeMenu = new ThemeMenu(this.mainWin);
		this.lookAndFeelMenu = new LookAndFeelMenu(this.mainWin);
		this.toggleNavigatorMItem = new ToggleNavigatorMItem(this.mainWin);
		
		this.add(this.themeMenu);
		this.add(this.lookAndFeelMenu);
		this.add(this.toggleNavigatorMItem);
	}
	
}

@SuppressWarnings("serial")
class ThemeMenu extends JMenu {
	
	private MainWindow mainWin;
	
	public ThemeMenu(MainWindow mw) {
		super("Themes");
		this.mainWin = mw;
		ButtonGroup themeButtonGroup = new ButtonGroup();
		ActionListener themeMenuListener = new ThemeMenuListener(this.mainWin);
		
		File themeDir = new File(System.getProperty("user.dir") 
			+ File.separator + "themes");
		
		for (File dirEntry : themeDir.listFiles()) {
			if (dirEntry.isDirectory()) {
				JMenuItem themeMenuItem = new JRadioButtonMenuItem(dirEntry.getName());
				themeMenuItem.setActionCommand(dirEntry.getName());
				themeMenuItem.addActionListener(themeMenuListener);
				
				if ("Dracula".equals(themeMenuItem.getActionCommand())) {
					themeMenuItem.setSelected(true);
				}
				this.add(themeMenuItem);
				themeButtonGroup.add(themeMenuItem);
			}
		}
	}
}

@SuppressWarnings("serial")
class LookAndFeelMenu extends JMenu {
	
	private JMenuItem[] LAFItems;
	private MainWindow mainWin;
	
	public LookAndFeelMenu(MainWindow mw) {
		super("Look & Feel");
		this.mainWin = mw;
		ButtonGroup LAFButtonGroup = new ButtonGroup();
		ActionListener lookAndFeelMenuListener = new LookAndFeelMenuListener(this.mainWin);
		UIManager.LookAndFeelInfo[] installedLookAndFeels;
		installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		
		this.LAFItems = new JMenuItem[installedLookAndFeels.length];
		
		int i = 0;
		for (UIManager.LookAndFeelInfo lafi : installedLookAndFeels) {
			LAFItems[i] = new JRadioButtonMenuItem(lafi.getName());
			LAFItems[i].setActionCommand(lafi.getClassName());
			LAFItems[i].addActionListener(lookAndFeelMenuListener);
			if (lafi.getClassName().equals(
					UIManager.getSystemLookAndFeelClassName())) {
				LAFItems[i].setSelected(true);
			}
			this.add(LAFItems[i]);
			LAFButtonGroup.add(LAFItems[i]);
			i++;
		}
	}
}

@SuppressWarnings("serial")
class ToggleNavigatorMItem extends JCheckBoxMenuItem {
	
	private MainWindow mainWin;
	
	public ToggleNavigatorMItem(MainWindow mw) {
		super("Navigator ausblenden");
		this.mainWin = mw;
		this.setSelected(true);
		this.addActionListener(new ToggleNavigatorMenuListener(this.mainWin));
	}
}

@SuppressWarnings("serial")
class HelpMenu extends JMenu {
	
	private TokenHelpMItem tokenHelpMItem;
	private GameDescriptionMItem gameDescriptionMItem;
	private MainWindow mainWin;
	
	public HelpMenu(MainWindow mw) {
		super("Hilfe");
		this.mainWin = mw;
		
		this.tokenHelpMItem = new TokenHelpMItem(this.mainWin);
		this.gameDescriptionMItem = new GameDescriptionMItem();
		
		this.add(this.tokenHelpMItem);
		this.add(this.gameDescriptionMItem);
	}
}


@SuppressWarnings("serial")
class TokenHelpMItem extends JMenuItem {
	
	private MainWindow mainWin;
	
	public TokenHelpMItem(MainWindow mw) {
		super("Spielfiguren anzeigen");
		this.mainWin = mw;
		
		this.addActionListener(new TokenHelpListener(this.mainWin));
	}
}

@SuppressWarnings("serial")
class GameDescriptionMItem extends JMenuItem {
	
	public GameDescriptionMItem() {
		super("Spielbeschreibung");
		
		this.addActionListener(new GameDescriptionListener());
	}
}

@SuppressWarnings("serial")
class LevelReaderMItem extends JMenuItem {
	
	private MainWindow mainWin;
	
	public LevelReaderMItem(MainWindow mw) {
		super("Level einlesen");
		this.mainWin = mw;
		
		this.addActionListener(new LevelReaderListener(this.mainWin));
	}
}

@SuppressWarnings("serial")
class LevelEditorMItem extends JMenuItem {
	
	public LevelEditorMItem(MainWindow mw) {
		super("Level erstellen");
		
		this.addActionListener(new LevelEditorListener());
	}
}

@SuppressWarnings("serial")
class LevelMenu extends JMenu {
	
	private JMenuItem levelReaderMItem;
	private JMenuItem levelEditorMItem;
	private MainWindow mainWin;
	
	public LevelMenu(MainWindow mw) {
		super("Levels");
		this.mainWin = mw;
		
		this.levelReaderMItem = new LevelReaderMItem(this.mainWin);
		this.levelEditorMItem = new LevelEditorMItem(this.mainWin);
		
		this.add(this.levelReaderMItem);
		this.add(this.levelEditorMItem);
	}
}