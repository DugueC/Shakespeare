package accueil;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Accueil extends JPanel {
	int tailleListe = 10;
	JPanel liste;
	JScrollPane scroll;
	
	public Accueil(Controleur c){
		
		setLayout(new BorderLayout());
		
		//liste
		liste = new JPanel();
		liste.setLayout(new GridLayout(tailleListe,1));
		for(int i=0 ; i<tailleListe ; i++){
			liste.add(new PanelNiveau(c,i));
		}
		
		//scroll
		scroll = new JScrollPane(liste);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		add(scroll,BorderLayout.CENTER);
		
		
		this.validate();
	}	
}
