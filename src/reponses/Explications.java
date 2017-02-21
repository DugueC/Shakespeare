package reponses;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controleur.Controleur;

public class Explications extends JPanel{

	public Explications(Controleur c){
		setLayout(new BorderLayout());
		
		add(new ExplicationsImage(c.getModele().getExplications()),BorderLayout.NORTH);
		add(new ExplicationsReponseBouton(c),BorderLayout.SOUTH);	
		
		validate();
	}
}
