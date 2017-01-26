package exos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class TextZoneBouton extends JPanel {
	
	public TextZoneBouton(Controleur c){
		setLayout(null);
		setPreferredSize(new Dimension(this.getWidth(),35));
		
		//bouton
		JButton b = new JButton("No error");
		b.setBounds(230, 5, 120, 25);
		b.addActionListener(c);
		add(b);
	}
	
	public void paintComponent(Graphics g){	
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
