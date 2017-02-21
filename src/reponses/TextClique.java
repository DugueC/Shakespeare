package reponses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import controleur.Controleur;
import phrases.Mot;
import phrases.Phrase;

public class TextClique extends JPanel {

	Controleur c;
	
	public TextClique(Controleur c){
		this.c = c;
		setLayout(null);
		validate();
	}
	
	
	public void paintComponent(Graphics g){
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(36,85,255));
		g.drawLine(0, 0, this.getWidth(), 0);
		g.drawLine(0, this.getHeight()-1, this.getWidth(), this.getHeight()-1);
		
		if(c.getModele().getReponse()[0]!=-1 && c.getModele().getReponse()[1]!=-1){
			g.setColor(Color.orange);
			g.fillOval(c.getModele().getReponse()[0]-15,c.getModele().getReponse()[1]-15, 30, 30);
		}
		
		g.setColor(Color.black);
		Phrase p = c.getModele().getPhrase();
		Mot m;
		for(int k=0; k<p.getSize();k++){
			m = p.getMot(k);
			g.drawString(m.toStr(),m.getX(),m.getY());
			
			//souligne
			for(int i : p.getReponses()){
				if(k+1==i){
					g.setColor(Color.red);
					g.drawLine(m.getX(), m.getY()+2, m.getXMax(), m.getY()+2);
					g.setColor(Color.black);
				}
			}
		}
		
		
	}
}
