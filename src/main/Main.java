package main;

import Vue.Fenetre;
import controleur.Controleur;
import modele.Modele;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Modele m = new Modele();
		Controleur c = new Controleur(m);
		Fenetre f = new Fenetre(c);
	}	
}