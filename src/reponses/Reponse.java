package reponses;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controleur.Controleur;
import exos.Infos;

public class Reponse extends JPanel {
	
	public Reponse(Controleur c){
		
		setLayout(new BorderLayout());
		
		add(new Infos(c),BorderLayout.NORTH);
		add(new TextClique(c),BorderLayout.CENTER);
		add(new Explications(c),BorderLayout.SOUTH);
		
		validate();
	}
}
