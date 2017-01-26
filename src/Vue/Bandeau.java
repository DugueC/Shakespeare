package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
public class Bandeau extends JPanel implements Observer {
	
	private Font ecrit = new Font("Times New Roman", Font.PLAIN, 30);
	private Controleur c;
	private Image img;
	private String message;
	
	public Bandeau(Controleur c){
		this.c = c;
		c.getModele().addObserver(this);
		try{
			img = ImageIO.read(new File("img/drapeau2.png"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		message = "Chose your level";
		setPreferredSize(new Dimension(700,80));
		validate();
	}
	
	public void paintComponent(Graphics g)
	{	
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setFont(ecrit);
		g.setColor(Color.white);
		g.drawString(message, 200, 50);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		switch (c.getModele().getModeBandeau())
		{
		 case 0:
			  try{
				  img = ImageIO.read(new File("img/drapeau2.png"));
			  }
			  catch (IOException e){
					e.printStackTrace();
			  }
			  message = "Chose your level";
			 break;
		  case 1:
			  try{
				  img = ImageIO.read(new File("img/drapeau2.png"));
			  }
			  catch (IOException e){
					e.printStackTrace();
			  }
			  message = "Find the spelling mistake";
			 break;
		  case 2:
			  try{
				  img = ImageIO.read(new File("img/vert.png"));
			  }
			  catch (IOException e){
					e.printStackTrace();
			  }
			  message = "Well done !";
			 break;
		  case 3:
			  try{
				  img = ImageIO.read(new File("img/rouge.png"));
			  }
			  catch (IOException e){
					e.printStackTrace();
			  }
			  message = "Wrong...";
			 break;
		  default:
			  //??;
		}	
		
		this.repaint();
	}
}
