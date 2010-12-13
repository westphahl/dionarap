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
 * The playboard which contains the fields for the tokens.
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
	
	/**
	 * Creates a playboard according to the supplied
	 * number of rows and columns.
	 * 
	 * @param rows Number of rows.
	 * @param cols Number of columns.
	 */
	public Playboard(MainWindow mWin, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		this.mainWindow = mWin;
		
		this.fields = new JLabel[this.rows][this.cols];
		
		/* Set the default theme */
		this.setTheme("Dracula");
		
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
	 * Function for (re)drawing the pawns.
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
	 * Draws the vortexes in the four corners.
	 */
	public void drawVortex(AbstractPawn vortex) {
		this.fields[vortex.getX()][vortex.getY()].setIcon(this.vortexIcon);
	}
	
	/**
	 * Draws the player.
	 * 
	 * @param player
	 */
	public void drawPlayer(AbstractPawn p) {
		Player player = (Player) p;
		this.fields[player.getX()][player.getY()].setIcon(
				this.playerIcons[player.getViewDirection()]);
	}
	
	/**
	 * Draws the given enemy.
	 * 
	 * @param enemy
	 */
	public void drawEnemy(AbstractPawn enemy) {
		this.fields[enemy.getX()][enemy.getY()].setIcon(this.enemyIcon);
	}

	/**
	 * Draws a destroyed field.
	 * 
	 * @param destruction
	 */
	public void drawDestroyedField(AbstractPawn destruction) {
		this.fields[destruction.getX()][destruction.getY()].setIcon(
				this.destructionIcon);
	}

	/**
	 * Draws a barrier.
	 * 
	 * @param barrier
	 */
	public void drawBarrier(AbstractPawn barrier) {
		this.fields[barrier.getX()][barrier.getY()].setIcon(this.barrierIcon);
	}
	
	/**
	 * Draws ammo field.
	 * 
	 * @param ammo
	 */
	public void drawAmmo(AbstractPawn ammo) {
		this.fields[ammo.getX()][ammo.getY()].setIcon(this.ammoIcon);
	}
	
	/**
	 * Erase all fields.
	 */
	public void eraseFields() {
		for (int i = 0; i < this.cols; i++) {
			for (int k = 0; k < this.rows; k++) {
				this.fields[i][k].setIcon(null);
			}
		}
	}
	
	public void setTheme(String themeName) {
		String themePath = System.getProperty("user.dir") 
			+ File.separator + "themes"
			+ File.separator + themeName + File.separator;
		
		this.playerIcons[0] = new ImageIcon(themePath + "player.gif");
		for (int i = 1; i < this.playerIcons.length; i++) {
			this.playerIcons[i] = new ImageIcon(themePath +
					"player" + Integer.toString(i) + ".gif");
		}
		this.enemyIcon = new ImageIcon(themePath + "opponent.gif");
		this.vortexIcon = new ImageIcon(themePath + "vortex.gif");
		this.destructionIcon = new ImageIcon(themePath + "destruction.gif");
		this.barrierIcon = new ImageIcon(themePath + "obstacle.gif");
		this.ammoIcon = new ImageIcon(themePath + "ammo.png");
		this.gameOverIcon = new ImageIcon(themePath + "loss.gif");
		this.gameWonIcon = new ImageIcon(themePath + "win.gif");
	}

	public Icon getGameWonIcon() {
		return this.gameWonIcon;
	}

	public Icon getGameOverIcon() {
		return this.gameOverIcon;
	}


}