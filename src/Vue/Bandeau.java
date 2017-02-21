package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Bandeau extends JPanel implements Observer {
	
	private Font ecrit = new Font("Times New Roman", Font.PLAIN, 30);
	private Controleur c;
	
	public Bandeau(Controleur c){
		this.c = c;
		c.getModele().addObserver(this);
		setPreferredSize(new Dimension(700,80));
		validate();
	}
	
	public void paintComponent(Graphics g)
	{	
		g.drawImage(c.getModele().getImgBandeau(), 0, 0, this.getWidth(), this.getHeight(), this);
		g.setFont(ecrit);
		g.setColor(Color.white);
		
		FontMetrics fm = g.getFontMetrics();
		String message = c.getModele().getMessagebandeau();
		int taille = fm.stringWidth(message);
		
		g.drawString(c.getModele().getMessagebandeau(), (this.getWidth()-taille)/2, 50);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
}
