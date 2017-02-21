package exos;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import accueil.Accueil;
import controleur.Controleur;

@SuppressWarnings("serial")
public class Exo extends JPanel{
	
	public Exo(Controleur c){
		
		setLayout(new BorderLayout());
		
		add(new Infos(c),BorderLayout.NORTH);
		add(new Text(c),BorderLayout.CENTER);
		add(new Decor(),BorderLayout.SOUTH);
		
		validate();
	}

}
