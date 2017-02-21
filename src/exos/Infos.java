package exos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Infos extends JPanel {
	Controleur c;
	
	public Infos(Controleur c){
		this.c = c;
		setPreferredSize(new Dimension(this.getWidth(),35));
	}
	
	public void paintComponent(Graphics g){	
		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		int nb = c.getModele().getVraiNiveau().getSize();
		for(int i=0; i<nb;i++){
			g.setColor(Color.black);
			int cpt = c.getModele().getVraiNiveau().getRegle(i).getCompteur();
			if(cpt == 4){
				g.setColor(Color.yellow);
			}
			g.fillOval((this.getWidth()-(nb*35)+15)/2+35*i, 5, 20, 20);
		}
	}
	
}
