package fr.ibformation.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class PionButton extends JButton {
	private int ligne;
	private int colonne;
	public PionButton(int i,int j) {
		this.colonne=i;
		this.ligne=j;
		this.setForeground(Color.WHITE);
		this.setBorder(BorderFactory.createEmptyBorder());
	}

	public void paintComponent(Graphics g) {
		//colorer le fond bleu
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//dessiner le pion
		g.setColor(this.getForeground());
		g.fillOval(5, 5, 60, 60);
		
		//dessiner des cercles pour que ca soit un peu joli ;)
		g.setColor(new Color(0, 0, 0, 150));
		g.drawOval(1,1, 67, 67);
		g.setColor(new Color(255, 255,255, 150));
		if (this.getForeground()==Color.YELLOW) {
			g.setColor(new Color(255, 100,100, 100));
		}
		g.drawOval(10,10, 50, 50);
		g.setColor(new Color(255, 255,255, 80));
		g.drawOval(2,2, 67, 67);
	}

	/**
	 * @return the ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * @return the colonne
	 */
	public int getColonne() {
		return colonne;
	}
	
	public String caseToString() {
		String caseToString="";
		if (this.getForeground() == Color.YELLOW) {
			caseToString = "1";
		} else if (this.getForeground() == Color.RED) {
			caseToString = "2";
		} else {
			caseToString = "0";
		}
		return caseToString;
	}

}
