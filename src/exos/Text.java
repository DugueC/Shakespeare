package exos;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Text extends JPanel {

	public Text(Controleur c){
		setLayout(new BorderLayout());
		
		add(new TextZoneCliquable(c),BorderLayout.CENTER);
		add(new TextZoneBouton(c),BorderLayout.SOUTH);
		
		validate();
	}

}
