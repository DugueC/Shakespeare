package accueil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class PanelNiveau extends JPanel {
	
	private Font gras = new Font("Times New Roman", Font.BOLD, 15);
	private Font italic = new Font("Times New Roman", Font.ITALIC, 15);
	private int numero;
	
	public PanelNiveau(Controleur c, int i){
		setLayout(null);
		setPreferredSize(new Dimension(this.getWidth(),80));
		numero = i+1;
		add(new BoutonLetsGo(c,i));	
		validate();
	}

	
	public void paintComponent(Graphics g){	
		try{
			Image img = ImageIO.read(new File("img/bleu_clair.png"));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		g.setColor(Color.black);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
		g.setFont(gras);
		g.drawString("LEVEL  "+numero,50,40);
		g.setFont(italic);
		g.drawString("(explication du theme travaillé)",150,40);
	}
}
