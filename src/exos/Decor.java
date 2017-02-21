package exos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Decor extends JPanel {
	
	public Decor(){
		setLayout(null);	
		setPreferredSize(new Dimension(this.getWidth(),270));
		validate();
	}
	
	public void paintComponent(Graphics g)
	{	
		g.setColor(new Color(0, 33, 153));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

}
