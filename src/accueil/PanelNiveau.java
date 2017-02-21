package accueil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import controleur.Controleur;

@SuppressWarnings("serial")
public class PanelNiveau extends JPanel {
	
	private Font gras = new Font("Times New Roman", Font.BOLD, 17);
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

		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		g.setColor(new Color(0, 22, 100));
		g.drawLine(0, this.getHeight()-3, this.getWidth(), this.getHeight()-3);
		
		g.setColor(new Color(0, 16, 60));
		g.drawLine(0, this.getHeight()-2, this.getWidth(), this.getHeight()-2);
		
		g.setColor(Color.black);
		g.drawLine(0, this.getHeight()-1, this.getWidth(), this.getHeight()-1);
		
		g.setColor(new Color(230, 230, 255));
		g.setFont(gras);
		g.drawString("LEVEL  "+numero,50,30);
		g.setFont(italic);
		g.drawString("(explication du theme travaillé)",50,50);
	}
}
