package net.westphahl.dionarap.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Dialogfenster für die Figurenhilfe.
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
public class TokenHelp extends JDialog {
	
	/**
	 * Konstruktor für die Hilfe zu den Spielfiguren.
	 * 
	 * Dient als Container für die Panels der einzelnen Spielfiguren.
	 * Positionierung der Panels über ein FlowLayout.
	 * 
	 * @param mainWindow  Referenz auf das Hauptfenster
	 */
	public TokenHelp(MainWindow mainWindow) {
		String themePath = mainWindow.getPlayboard().getThemePath();
		MediaTracker mediaTracker = new MediaTracker(this);
		
		Image playerImage = this.getToolkit().getImage(themePath + "player.gif");
		Image enemyImage = this.getToolkit().getImage(themePath + "opponent.gif");
		Image barrierImage = this.getToolkit().getImage(themePath + "obstacle.gif");
		
		mediaTracker.addImage(playerImage, 1);
		mediaTracker.addImage(enemyImage, 1);
		mediaTracker.addImage(barrierImage, 1);
		
		try {
			mediaTracker.waitForID(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(new TokenPanel(playerImage, "Player"));
		this.add(new TokenPanel(enemyImage, "Enemy"));
		this.add(new TokenPanel(barrierImage, "Barrier"));
		
		this.pack();
		this.setVisible(true);
	}
}

/**
 * Containerelement für eine Spielfigur
 * 
 * @author westphahl
 *
 */
@SuppressWarnings("serial")
class TokenPanel extends JPanel {
	
	private Image tokenImage;
	private String tokenLabel;
	
	/**
	 * Konstruktor für den Container.
	 * 
	 * Die Spielfigur sowie die Beschriftung werden in das
	 * Panel hineingezeichnet.
	 * 
	 * @param i  Bild der Spielfigur
	 * @param label  Beschriftung der Spielfigur
	 */
	public TokenPanel(Image i, String label) {
		this.tokenImage = i;
		this.tokenLabel = label;
		this.setPreferredSize(new Dimension(80, 100));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.tokenImage, 15, 10, this);
		g2d.drawString(this.tokenLabel, 15, 90);
	}
}