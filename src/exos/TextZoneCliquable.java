package exos;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class TextZoneCliquable extends JPanel implements Observer {
	Controleur c;
	
	public TextZoneCliquable(Controleur c){
		this.c = c;
		c.getModele().addObserver(this);
		setLayout(null);
		addMouseListener(c);
		validate();
	}
	
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		
		FontMetrics fm = g.getFontMetrics();
		String text = c.getModele().getPhrase().getText();
		
		int margeH = 50;
		int margeV = 10;
		int larg = this.getWidth()-2*margeH;
		int haut = this.getHeight()-2*margeV;
		
		int taille = fm.stringWidth(text);
		int hauteurLigne = fm.getHeight();
		int nbLigne = (int)(taille/larg) + 1;	
		haut = margeV+(haut-hauteurLigne*nbLigne)/2;
	
		// s'il y a plus d'une ligne on ajuste à gauche
		if(nbLigne>1){
			int num = 0;
			for(int k=0; k<nbLigne; k++){
				text = "";
				while(num<c.getModele().getPhrase().getSize() && fm.stringWidth(text+c.getModele().getPhrase().getMot(num))<larg){
					text = text + c.getModele().getPhrase().getMot(num) + " ";
					num++;
				}
				g.drawString(text,margeH,haut+k*hauteurLigne);
			}
		}
		// sinon on centre
		else{
			g.drawString(text,margeH+(larg-taille)/2,haut);
		}
		
		// on affiche un rond quand on clique
		if((c.getModele().getReponse()[0]!=-1)&&(c.getModele().getReponse()[1]!=-1)){
			g.drawOval(c.getModele().getReponse()[0]-15,c.getModele().getReponse()[1]-15, 30, 30);
		}
	}
}
