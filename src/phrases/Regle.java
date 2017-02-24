package phrases;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class Regle {
	String regle;
	ArrayList<Phrase> phrases;
	int compteur;
	
	public Regle(String regle){
		this.regle = regle;
		this.compteur = 0;
		phrases = new ArrayList<Phrase>();
	}
	
	public void ajouter(String phrase,String reponse, String correction){
		
		Scanner filtre = new Scanner(phrase);
		filtre.useDelimiter(" ");
		Phrase p = new Phrase(reponse, correction);
		while(filtre.hasNext()){
			p.ajouter(new Mot(filtre.next()));
		}
		phrases.add(p);
		filtre.close();
		
		JPanel pan = new JPanel();
		FontMetrics fm = pan.getFontMetrics(new Font("Arial", Font.PLAIN, 12));
		
		int margeH = 60;
		int margeV = 10;
		int width = 584;
		int height = 123;
		
		int larg = width-2*margeH;
		int haut = height-2*margeV;
		
		
		int taille = fm.stringWidth(phrase);
		int hauteurLigne = fm.getHeight();
		int nbLigne = (int)(taille/larg) + 1;	
		haut = margeV+(haut-hauteurLigne*nbLigne)/2;
		
		int x=0;
		int y=haut;
		if(nbLigne>1){
			int num = 0;
			for(int k=0; k<nbLigne; k++){
				x = margeH;
				while(num<p.getSize() && (x+fm.stringWidth(p.getMot(num).toStr()))<larg){
					p.getMot(num).setX(x);	
					p.getMot(num).setY(y+k*hauteurLigne);
					x = x + fm.stringWidth(p.getMot(num).toStr());
					
					p.getMot(num).setXMax(x);	
					p.getMot(num).setYMin(y+(k-1)*hauteurLigne);
					x = x + fm.stringWidth("  ");
					
					num++;
				}
			}
		}
		else{
			x = margeH+(larg-taille)/2;
			for(int k=0; k<p.getSize(); k++){
				p.getMot(k).setX(x);
				p.getMot(k).setY(y);
				x = x + fm.stringWidth(p.getMot(k).toStr());
				p.getMot(k).setXMax(x);	
				p.getMot(k).setYMin(y-hauteurLigne);
				x = x + fm.stringWidth("  ");
			}
		}	
	}

	public String getRegle(){
		return regle;
	}

	public double getSize() {
		return phrases.size();
	}

	public Phrase getPhrase(int x) {
		return phrases.get(x);
	}
	
	public void setCompteur(int x){
		this.compteur = x;
		//System.out.println(regle + " : " + compteur);
	}
	public int getCompteur(){
		return this.compteur;
	}
}
