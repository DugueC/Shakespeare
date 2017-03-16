package accueil;

import java.awt.Color;

import javax.swing.JButton;

import controleur.Controleur;

@SuppressWarnings("serial")
public class BoutonLetsGo extends JButton {
	int numero;
	
	public BoutonLetsGo(Controleur c,int n){
		super("Let's go!");
		numero = n+1;
		setBounds(455, 20, 100, 35);
		addActionListener(c);
		setBackground(new Color(230, 230, 255));
		setForeground(Color.black);
	}
	
	public int getNum(){
		return numero;
	}
}
