package exos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Explications extends JPanel implements Observer {
	Controleur c;
	
	public Explications(Controleur c){
		this.c = c;
		c.getModele().addObserver(this);
		setLayout(null);
		setPreferredSize(new Dimension(this.getWidth(),270));
		
		validate();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{	
		try{
			Image img = ImageIO.read(new File("img/bleu_clair.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	
}
