package exos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.Controleur;
import phrases.Mot;
import phrases.Phrase;

@SuppressWarnings("serial")
public class TextZoneCliquable extends JPanel {
	Phrase p;
	
	public TextZoneCliquable(Controleur c){
		p = c.getModele().getPhrase();;
		setLayout(null);
		addMouseListener(c);
		validate();
	}

	
	public void paintComponent(Graphics g){
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);	
		Mot m;
		for(int k=0; k<p.getSize();k++){
			m = p.getMot(k);
			g.drawString(m.toStr(),m.getX(),m.getY());
		}
	}
}
