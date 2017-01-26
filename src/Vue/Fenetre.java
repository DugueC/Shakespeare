package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import accueil.Accueil;
import controleur.Controleur;
import exos.Exo;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements Observer {

	private Controleur c;
	private JPanel panneau;
	
	public Fenetre(Controleur controleur)  {
		super("Projet Shakespear");	 
		c = controleur;
		c.getModele().addObserver(this);
		
		setLayout(new BorderLayout());
		
		//bandeau
		add(new Bandeau(c),BorderLayout.NORTH);
		panneau = new Accueil(c);
		add(panneau, BorderLayout.CENTER);
		
		//menu
		JMenuBar barreMenu = new JMenuBar();
		JMenuItem quitter = new JMenuItem("Quit");
		quitter.setName("MenuQuitter");
		quitter.addActionListener(c);
		JMenu file = new JMenu("File");
		file.add(quitter);
		barreMenu.add(file);
		setJMenuBar(barreMenu);
		
		//fenetre
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}


	public void setPanel(JPanel p) {
			this.remove(panneau);
			panneau = p;
			this.add(panneau);
			this.revalidate();
	}


	@Override
	public void update(Observable o, Object arg) {
		if(c.getModele().getNiveau()==0){
			Accueil p = new Accueil(c);
			this.setPanel(p);
		}
		else{
			Exo p = new Exo(c);
			this.setPanel(p);
		}
		
		if(!c.getModele().getOuvert()){
			this.dispose();
		}
	}
	
}