package net.westphahl.dionarap.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.fhwgt.dionarap.model.objects.AbstractPawn;
import de.fhwgt.dionarap.model.objects.Player;

/**
 * The playboard which contains the fields for the tokens.
 * 
 * @author Simon Westphahl
 */
public class Playboard extends JPanel {
	
	private int rows;
	private int cols;
	private JLabel fields[][];
	private Dimension fieldDimension = new Dimension(50, 50);
	private ImageIcon playerIcons[] = new ImageIcon[10];
	private ImageIcon enemyIcon;
	private ImageIcon vortexIcon;
	private ImageIcon destructionIcon;
	private ImageIcon barrierIcon;
	private ImageIcon ammoIcon;
	public ImageIcon gameOverIcon;
	public ImageIcon gameWonIcon;
	
	/**
	 * Creates a playboard according to the supplied
	 * number of rows and columns.
	 * 
	 * @param rows Number of rows.
	 * @param cols Number of columns.
	 */
	public Playboard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		this.fields = new JLabel[this.rows][this.cols];
		
		/* Set the default theme (Dracula) */
		this.setDefaultTheme();
		
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
	
	public void setDefaultTheme() {
		String themePath = System.getProperty("user.dir") 
			+ File.separator + "themes"
			+ File.separator + "dracula" + File.separator;
		
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
		this.gameOverIcon = new ImageIcon(themePath + "gameover.gif");
		this.gameWonIcon = new ImageIcon(themePath + "player.gif");
	}


}