package fin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Controleur;

public class FinNiveau extends JPanel {
	JButton bouton;
	Controleur c;
	
	public FinNiveau(Controleur c){
		setLayout(null);
		this.c = c;
		bouton = new JButton("Home");
		bouton.setBounds(250, 350, 80, 40);
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
		g.fillRect(70,30, this.getWidth()-140, this.getHeight()-60);
		
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		g.drawString("You pass the level "+c.getModele().getNiveau()+ " !", 170, 65);
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		int[] err = c.getModele().getVraiNiveau().getErreurs();
		for(int i=0;i<err.length;i++){
			g.drawString("You made "+err[i]+ " mistakes for the rule : "+c.getModele().getVraiNiveau().getRegle(i).getRegle(), 100, 120+30*i);
		}
	}
}
