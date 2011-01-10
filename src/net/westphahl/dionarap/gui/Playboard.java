package net.westphahl.dionarap.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Ammo;
import de.fhwgt.dionarap.model.objects.Destruction;
import de.fhwgt.dionarap.model.objects.Obstacle;
import de.fhwgt.dionarap.model.objects.Opponent;
import de.fhwgt.dionarap.model.objects.Player;
import de.fhwgt.dionarap.model.objects.Vortex;

/**
 * Spielfeld, welches die Felder und Spielfiguren enthält.
 * 
 * @author Simon Westphahl
 */
@SuppressWarnings("serial")
public class Playboard extends JPanel {
	
	private int rows;
	private int cols;
	private JLabel fields[][];
	private MainWindow mainWindow;
	private Dimension fieldDimension = new Dimension(50, 50);
	private ImageIcon playerIcons[] = new ImageIcon[10];
	private ImageIcon enemyIcon;
	private ImageIcon vortexIcon;
	private ImageIcon destructionIcon;
	private ImageIcon barrierIcon;
	private ImageIcon ammoIcon;
	private ImageIcon gameOverIcon;
	private ImageIcon gameWonIcon;
	private String themePath;
	
	/**
	 * Konstruktor für das Spielfeld.
	 * 
	 * Erzeugt ein schachbrettartiges Muster in der angegebenen Größe.
	 * Verwendung eines GridLayouts.
	 * 
	 * @param mWin  Referenz auf das Hauptfenster
	 * @param rows  Anzahl der Zeilen
	 * @param cols  Anzahl der Spalten
	 * @param themeName  Name des zu verwendenden Themes
	 */
	public Playboard(MainWindow mWin, int rows, int cols, String themeName) {
		this.rows = rows;
		this.cols = cols;
		
		this.mainWindow = mWin;
		
		this.fields = new JLabel[this.rows][this.cols];
		
		/* Set the default theme */
		this.setTheme(themeName);
		
		/* Use a grid layout */
		this.setLayout(new GridLayout(this.rows, this.cols));
		
		for (int i = 0; i < this.rows; i++) {
			for (int k = 0; k < this.cols; k++) {
				this.fields[k][i] = new JLabel();
				this.fields[k][i].setOpaque(true);
				this.fields[k][i].setPreferredSize(this.fieldDimension);
				this.fields[k][i].setHorizontalAlignment(SwingConstants.CENTER);
				this.fields[k][i].setVerticalAlignment(SwingConstants.CENTER);
				
				/* Toggle between two colors. */
				if (((i + k) % 2) == 0) {
					this.fields[k][i].setBackground(Color.RED);
				} else {
					this.fields[k][i].setBackground(Color.WHITE);
				}
				this.add(this.fields[k][i]);
			}
		}
		this.setVisible(true);
	}
	
	/**
	 * Methode zum Zeichnen der Spielfiguren.
	 */
	public void drawPawns() {
		int numPawns = this.mainWindow.getDRModel().getAllPawns().length;
		AbstractPawn aPawns[] = new AbstractPawn[numPawns];
		aPawns = this.mainWindow.getDRModel().getAllPawns();
		
		this.eraseFields();
		
		for (int i = 0; i < numPawns; i++) {
			if (aPawns[i] instanceof Player) {
				 this.drawPlayer(aPawns[i]);
			} else if (aPawns[i] instanceof Destruction) {
				this.drawDestroyedField(aPawns[i]);
			} else if (aPawns[i] instanceof Opponent) {
				this.drawEnemy(aPawns[i]);
			} else if (aPawns[i] instanceof Obstacle) {
				this.drawBarrier(aPawns[i]);
			} else if (aPawns[i] instanceof Vortex) {
				this.drawVortex(aPawns[i]);
			} else if (aPawns[i] instanceof Ammo) {
				this.drawAmmo(aPawns[i]);
			}
		}
	}
	
	/**
	 * Methode zum Zeichnen der Vortex-Objekte.
	 * 
	 * @param vortex  Refernz auf das Vortext-Objekt
	 */
	public void drawVortex(AbstractPawn vortex) {
		this.fields[vortex.getX()][vortex.getY()].setIcon(this.vortexIcon);
	}
	
	/**
	 * Methode zum Zeichnen des Spielers.
	 * 
	 * @param p  Referenz auf die Spielfigur
	 */
	public void drawPlayer(AbstractPawn p) {
		Player player = (Player) p;
		this.fields[player.getX()][player.getY()].setIcon(
				this.playerIcons[player.getViewDirection()]);
	}
	
	/**
	 * Methode zum Zeichnen eines Gegeners.
	 * 
	 * @param enemy  Referenz auf einen Gegner
	 */
	public void drawEnemy(AbstractPawn enemy) {
		this.fields[enemy.getX()][enemy.getY()].setIcon(this.enemyIcon);
	}

	/**
	 * Methode zum Zeichnen eines zerstörten Feldes.
	 * 
	 * @param destruction  Referenz auf ein zerstörtes Feld
	 */
	public void drawDestroyedField(AbstractPawn destruction) {
		this.fields[destruction.getX()][destruction.getY()].setIcon(
				this.destructionIcon);
	}

	/**
	 * Methode zum Zeichnen eines Hindernis.
	 * 
	 * @param barrier  Referenz auf ein Hindernis
	 */
	public void drawBarrier(AbstractPawn barrier) {
		this.fields[barrier.getX()][barrier.getY()].setIcon(this.barrierIcon);
	}
	
	/**
	 * Methode zum Zeichnen eines Munitionsfeldes.
	 * 
	 * @param ammo  Referenz auf Munition
	 */
	public void drawAmmo(AbstractPawn ammo) {
		this.fields[ammo.getX()][ammo.getY()].setIcon(this.ammoIcon);
	}
	
	/**
	 * Methode zum Löschen aller Spielfiguren.
	 */
	public void eraseFields() {
		for (int i = 0; i < this.cols; i++) {
			for (int k = 0; k < this.rows; k++) {
				this.fields[i][k].setIcon(null);
			}
		}
	}
	
	/**
	 * Methode zum Ändern des Themes.
	 * 
	 * Um die das neue Theme zu übernehmen, muss die Methode drawPawns()
	 * aufgerufen werden.
	 * 
	 * @param themeName  Name des neuen Themes
	 */
	public void setTheme(String themeName) {
		this.themePath = System.getProperty("user.dir") 
			+ File.separator + "themes"
			+ File.separator + themeName + File.separator;
		
		this.playerIcons[0] = new ImageIcon(this.themePath + "player.gif");
		for (int i = 1; i < this.playerIcons.length; i++) {
			this.playerIcons[i] = new ImageIcon(this.themePath +
					"player" + Integer.toString(i) + ".gif");
		}
		this.enemyIcon = new ImageIcon(this.themePath + "opponent.gif");
		this.vortexIcon = new ImageIcon(this.themePath + "vortex.gif");
		this.destructionIcon = new ImageIcon(this.themePath + "destruction.gif");
		this.barrierIcon = new ImageIcon(this.themePath + "obstacle.gif");
		this.ammoIcon = new ImageIcon(this.themePath + "ammo.png");
		this.gameOverIcon = new ImageIcon(this.themePath + "loss.gif");
		this.gameWonIcon = new ImageIcon(this.themePath + "win.gif");
	}

	/**
	 * Getter-Methode für das Gewonnen-Icon.
	 * 
	 * @return  Gewonnen-Icon
	 */
	public Icon getGameWonIcon() {
		return this.gameWonIcon;
	}

	/**
	 * Getter-Methode für das Game Over-Icon.
	 * 
	 * @return GameOver-Icon
	 */
	public Icon getGameOverIcon() {
		return this.gameOverIcon;
	}

	/**
	 * Getter-Methode für den Pfad des aktuellen Themes.
	 * 
	 * @return  Theme-Pfad
	 */
	public String getThemePath() {
		return this.themePath;
	}
}