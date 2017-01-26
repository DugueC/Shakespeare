package accueil;

import javax.swing.JButton;

import controleur.Controleur;

@SuppressWarnings("serial")
public class BoutonLetsGo extends JButton {
	int numero;

	public BoutonLetsGo(Controleur c,int n){
		super("Let's go!");
		numero = n+1;
		setBounds(450, 20, 100, 40);
		addActionListener(c);
	}
	
	public int getNum(){
		return numero;
	}
}
