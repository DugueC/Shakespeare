package fin;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Controleur;

public class FinNiveau extends JPanel {
	JButton bouton;
	
	public FinNiveau(Controleur c){
		setLayout(null);
		
		bouton = new JButton("Home");
		bouton.setBounds(300, 300, 80, 60);
		bouton.addActionListener(c);
		add(bouton);
		
		c.getModele().getVraiNiveau().resetCompteurs();
		validate();
	}
	
	public void paintComponent(Graphics g){
		try{
			Image img = ImageIO.read(new File("img/bleu2.png"));
			g.drawImage(img, -5, 0, this.getWidth()+10, this.getHeight(), this);
		}
		catch (IOException e){
			e.printStackTrace();
		}

	}
}
