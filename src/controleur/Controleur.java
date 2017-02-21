package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import accueil.BoutonLetsGo;
import modele.Modele;

public class Controleur implements ActionListener, MouseListener {

	private Modele m;
	
	public Controleur(Modele m){
		this.m = m ;
	}
	
	public Modele getModele(){
		return this.m;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem){
			JMenuItem monItem = (JMenuItem) e.getSource();
			
			if(monItem.getName().equals("MenuQuitter"))
			{
				m.setOuvert(false);	
			}
			if(monItem.getName().equals("MenuHome"))
			{
				m.reset();	
			}
		}
		
		if(e.getSource() instanceof BoutonLetsGo){
			BoutonLetsGo bouton = (BoutonLetsGo) e.getSource();
			m.setNiveau(bouton.getNum());
		}
		
		if(e.getSource() instanceof JButton){
			JButton bouton = (JButton) e.getSource();
			
			if(bouton.getText().equals("No error")){
				m.setReponse(-1,-1);
			}
			
			if(bouton.getText().equals("Next") ){
				m.setNiveau(m.getNiveau());
			}
			
			if( bouton.getText().equals("Home")){
				m.reset();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			m.setReponse(e.getX(),e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}