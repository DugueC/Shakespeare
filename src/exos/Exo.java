package exos;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Exo extends JPanel {
	
	public Exo(Controleur c){
		setLayout(new BorderLayout());
	
		add(new Infos(c),BorderLayout.NORTH);
		add(new Text(c),BorderLayout.CENTER);
		add(new Explications(c),BorderLayout.SOUTH);
		
		validate();
	}

}
