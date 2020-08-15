package fr.ibformation.ihm;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.ibformation.service.Puissance4Service;

public class Fenetre extends JFrame {
	//JPanel pan = new JPanel();
	private FenetreJeu fenJ = new FenetreJeu();
	public Puissance4Service puissance4Service=new Puissance4Service();
	private GrillePanel grillePanel;
	private MenuPanel menuPanel;
	public Fenetre(String joueur1, String joueur2) {
		grillePanel=new GrillePanel(puissance4Service,7,6,joueur1,joueur2);
		menuPanel=new MenuPanel(puissance4Service);
		this.setSize(500,600);
		this.setTitle("Mon puissance 4 super Puissant!");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fenJ.setBackground(Color.ORANGE);
		
		//this.setContentPane(fenJ);
		BorderLayout borderLayout = new BorderLayout();
		JPanel container = new JPanel();
		this.setContentPane(container);
		container.setLayout(borderLayout);
		container.add(grillePanel);
		container.add(menuPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	
	}
	/**
	 * @return the puissance4Service
	 */
	public Puissance4Service getPuissance4Service() {
		return puissance4Service;
	}
	/**
	 * @param puissance4Service the puissance4Service to set
	 */
	public void setPuissance4Service(Puissance4Service puissance4Service) {
		this.puissance4Service = puissance4Service;
	}
	/**
	 * @return the grillePanel
	 */
	public GrillePanel getGrillePanel() {
		return grillePanel;
	}
	/**
	 * @param grillePanel the grillePanel to set
	 */
	public void setGrillePanel(GrillePanel grillePanel) {
		this.grillePanel = grillePanel;
	}
	/**
	 * @return the menuPanel
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	/**
	 * @param menuPanel the menuPanel to set
	 */
	public void setMenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

}
