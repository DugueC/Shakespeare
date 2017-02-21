package reponses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.Controleur;


public class ExplicationsImage extends JPanel {
	Image explications;
	
	public ExplicationsImage(Image img){
		explications = img;
		setLayout(null);	
		setPreferredSize(new Dimension(this.getWidth(),250));
	
		validate();
	}
	
	public void paintComponent(Graphics g){	
		//l'image fait 500 x 200
		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(0, 46, 204));
		g.drawRect((this.getWidth()-500)/2, 30, 500, 200);
		g.drawImage(explications, (this.getWidth()-500)/2, 30,this);
	}

}