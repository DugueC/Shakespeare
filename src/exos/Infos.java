package exos;

import java.awt.Color;
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
public class Infos extends JPanel {
	Controleur c;
	
	public Infos(Controleur c){
		this.c = c;
		setPreferredSize(new Dimension(this.getWidth(),30));
	}
	
	public void paintComponent(Graphics g)
	{	
		/*try{
			Image img = ImageIO.read(new File("img/bleu2.png"));
			g.drawImage(img, -5, 0, this.getWidth()+10, this.getHeight(), this);
		}
		catch (IOException e){
			e.printStackTrace();
		}*/
		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
}
