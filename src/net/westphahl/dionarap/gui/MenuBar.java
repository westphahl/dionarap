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
import net.westphahl.dionarap.listener.LookAndFeelMenuListener;
import net.westphahl.dionarap.listener.ThemeMenuListener;
import net.westphahl.dionarap.listener.ToggleNavigatorMenuListener;
import net.westphahl.dionarap.listener.TokenHelpListener;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private ConfigMenu configMenu;
	private HelpMenu helpMenu;
	
	public MenuBar() {
		this.configMenu = new ConfigMenu();
		this.helpMenu = new HelpMenu();
		
		this.add(this.configMenu);
		this.add(this.helpMenu);
	}
}

@SuppressWarnings("serial")
class ConfigMenu extends JMenu {
	
	private ThemeMenu themeMenu;
	private LookAndFeelMenu lookAndFeelMenu;
	private ToggleNavigatorMItem toggleNavigatorMItem;
	
	public ConfigMenu() {
		super("Konfiguration");
		this.themeMenu = new ThemeMenu();
		this.lookAndFeelMenu = new LookAndFeelMenu();
		this.toggleNavigatorMItem = new ToggleNavigatorMItem();
		
		this.add(this.themeMenu);
		this.add(this.lookAndFeelMenu);
		this.add(this.toggleNavigatorMItem);
	}
	
}

@SuppressWarnings("serial")
class ThemeMenu extends JMenu {
	
	public ThemeMenu() {
		super("Themes");
		ButtonGroup themeButtonGroup = new ButtonGroup();
		ActionListener themeMenuListener = new ThemeMenuListener();
		
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
	
	public LookAndFeelMenu() {
		super("Look & Feel");
		ButtonGroup LAFButtonGroup = new ButtonGroup();
		ActionListener lookAndFeelMenuListener = new LookAndFeelMenuListener();
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
	
	public ToggleNavigatorMItem() {
		super("Navigator ausblenden");		
		this.setSelected(true);
		this.addActionListener(new ToggleNavigatorMenuListener());
	}
}

@SuppressWarnings("serial")
class HelpMenu extends JMenu {
	
	private TokenHelpMItem tokenHelpMItem;
	private GameDescriptionMItem gameDescriptionMItem;
	
	public HelpMenu() {
		super("Hilfe");
		
		this.tokenHelpMItem = new TokenHelpMItem();
		this.gameDescriptionMItem = new GameDescriptionMItem();
		
		this.add(this.tokenHelpMItem);
		this.add(this.gameDescriptionMItem);
	}
}


@SuppressWarnings("serial")
class TokenHelpMItem extends JMenuItem {
	
	public TokenHelpMItem() {
		super("Spielfiguren anzeigen");
		
		this.addActionListener(new TokenHelpListener());
	}
}

@SuppressWarnings("serial")
class GameDescriptionMItem extends JMenuItem {
	
	public GameDescriptionMItem() {
		super("Spielbeschreibung");
		
		this.addActionListener(new GameDescriptionListener());
	}
}