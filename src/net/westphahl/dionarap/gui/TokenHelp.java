package net.westphahl.dionarap.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JDialog;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TokenHelp extends JDialog {
	
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

@SuppressWarnings("serial")
class TokenPanel extends JPanel {
	
	private Image tokenImage;
	private String tokenLabel;
	
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