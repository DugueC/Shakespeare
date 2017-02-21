package reponses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Controleur;

public class ExplicationsReponseBouton extends JPanel {
	String correction;
	JButton bouton;
	
	public ExplicationsReponseBouton(Controleur c){
		setLayout(null);
		setPreferredSize(new Dimension(this.getWidth(),60));
		
		correction = "il faut ecrire ... comme ça";
		
		bouton = new JButton("Next");
		bouton.setBounds(465, 5, 80, 40);
		bouton.setBackground(Color.lightGray);
		bouton.setForeground(Color.black);
		bouton.addActionListener(c);
		add(bouton);
		
		validate();
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.white);
		g.fillRect(40, 5, 415, this.getHeight()-20);
		
		g.setColor(new Color(36,85,255));
		g.drawRect(40, 5, 415, this.getHeight()-20);
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.setColor(Color.black);
		//g.drawString(correction,20,40);
		g.drawString(correction,45,40);

	}
}
