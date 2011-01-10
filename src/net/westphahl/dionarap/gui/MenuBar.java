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

/**
 * Menüleiste des Hauptfensters.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	private ConfigMenu configMenu;
	private HelpMenu helpMenu;
	private LevelMenu levelMenu;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor der Hauptmenüleiste
	 * 
	 * Erzeugt die Untermenüs für Konfiguration, Hilfe und Levels.
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
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

/**
 * Menü für die Konfiguration.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class ConfigMenu extends JMenu {
	
	private ThemeMenu themeMenu;
	private LookAndFeelMenu lookAndFeelMenu;
	private ToggleNavigatorMItem toggleNavigatorMItem;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor des Konfigurations-Menüs.
	 * 
	 * Erzeugt Untermenüs zur Auswahl des Look&Feel sowie des Themes.
	 * Zusätzlich enthält es einen Menüpunkt um den Navigator ein- oder
	 * auszublenden.
	 * 
	 * @param mw  Instanz des Hauptfensters
	 */
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
/**
 * Menü zur Auswahl der verfügbaren Themes.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class ThemeMenu extends JMenu {
	
	private MainWindow mainWin;
	
	/**
	 * Konstruktor des Theme-Menüs.
	 * 
	 * Der Konstruktor erzeugt für alle Unterordner im Theme-Verzeichnis
	 * einen neuen Menüpunkt mit jeweiligem Namen. 
	 * @param mw
	 */
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

/**
 * Menü zur Auswahl der installierten Look&Feel.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class LookAndFeelMenu extends JMenu {
	
	private JMenuItem[] LAFItems;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor für das Look&Feel-Menü.
	 * 
	 * Erzeugen eines Untermenüpunktes für jedes installierte Look&Feel.
	 * 
	 * @param mw  Referenz des Hauptfensters
	 */
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

/**
 * Menüpunkt zum Ein-/Ausblenden des Navigators.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class ToggleNavigatorMItem extends JCheckBoxMenuItem {
	
	private MainWindow mainWin;
	
	/**
	 * Konstruktur für den Navigator-Menüpunkt.
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public ToggleNavigatorMItem(MainWindow mw) {
		super("Navigator ausblenden");
		this.mainWin = mw;
		this.setSelected(true);
		this.addActionListener(new ToggleNavigatorMenuListener(this.mainWin));
	}
}

/**
 * Hilemenü für die Spielbeschreibung und -figuren.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class HelpMenu extends JMenu {
	
	private JMenuItem tokenHelp;
	private JMenuItem gameDescription;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor für das Hilfemenü.
	 * 
	 * Erzeugt die Menüpunkte für die Spielbeschreibung und
	 * Hilfe zu den Spielfiguren, sowie Registrierung der
	 * zugehörigen Listener.
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public HelpMenu(MainWindow mw) {
		super("Hilfe");
		this.mainWin = mw;
		
		this.tokenHelp = new JMenuItem("Spielfiguren anzeigen");
		this.tokenHelp.addActionListener(
				new TokenHelpListener(this.mainWin));
		this.gameDescription = new JMenuItem("Spielbeschreibung anzeigen");
		this.gameDescription.addActionListener(
				new GameDescriptionListener());
		
		this.add(this.tokenHelp);
		this.add(this.gameDescription);
	}
}

/**
 * Levelmenü
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class LevelMenu extends JMenu {
	
	private JMenuItem levelReader;
	private JMenuItem levelEditor;
	private MainWindow mainWin;
	
	/**
	 * Konstruktor des Levelmenüs.
	 * 
	 * Erzeugen der Untermenüpunkte zum Einlesen und Erstellen
	 * neuer Levels mit zugehörigen Listenern.
	 * 
	 * @param mw  Referenz auf das Hauptfenster
	 */
	public LevelMenu(MainWindow mw) {
		super("Levels");
		this.mainWin = mw;
		
		this.levelReader = new JMenuItem("Level einlesen");
		this.levelReader.addActionListener(
				new LevelReaderListener(this.mainWin));
		this.levelEditor = new JMenuItem("Level erstellen");
		this.levelEditor.addActionListener(
				new LevelEditorListener());
		
		this.add(this.levelReader);
		this.add(this.levelEditor);
	}
}