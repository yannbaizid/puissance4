package fr.ibformation.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.ibformation.service.Puissance4Service;
public class GrillePanel extends JPanel implements ActionListener {
	private PionButton[][] cases;
	JLabel afficheJoueur = new JLabel("au tour de :");
	private Puissance4Service puissance4Service;
	private JLabel afficheEtat=new JLabel("au tour de:");

	public GrillePanel(Puissance4Service puissance4service,int nbColonne, int nbLigne, String joueur1, String joueur2) {
		this.puissance4Service=puissance4service;
		// initialisation du nom des joueurs:
		puissance4Service.setJoueur1(joueur1);
		puissance4Service.setJoueur2(joueur2);
		// initialisation de la grille:
		cases = new PionButton[nbColonne][nbLigne];
		this.setSize(500, 550);
		this.setLayout(new GridLayout(nbLigne + 1, nbColonne));
		this.setVisible(true);
		for (int i = 0; i < nbColonne; i++) {
			for (int j = 0; j < nbLigne; j++) {
				PionButton pion = new PionButton(i, j);
				pion.addActionListener(this);
				cases[i][j] = pion;
			}
		}
		for (int i = (nbLigne - 1); i >= 0; i--) {
			for (int j = (nbColonne - 1); j >= 0; j--) {
				this.add(cases[j][i]);
			}

		}
//afficher le joueur:
		if (puissance4Service.getJoueur()==1) {
			afficheJoueur.setText(puissance4Service.getJoueur1());
			
		}
		else {
			afficheJoueur.setText(puissance4Service.getJoueur2());
		}
this.add(this.afficheEtat);
		this.add(afficheJoueur);

	}
	
	/**
	 * charger une partie
	 */
	public GrillePanel(Puissance4Service puissance4Service, int nbColonne, int nbLigne, String joueur1, String joueur2,PionButton[][] casesLoaded) {
		this(puissance4Service,nbColonne,nbLigne,joueur1,joueur2);
		this.setCases(casesLoaded);
		for (int i = 0; i <nbColonne; i++) {
			for (int j = 0; j <nbLigne ; j++) {
				cases[i][j].setForeground(casesLoaded[i][j].getForeground());
			}

		}
		repaint();
	}


	/**
	 * @return the cases
	 */
	public PionButton[][] getCases() {
		return cases;
	}

	/**
	 * @param cases the cases to set
	 */
	public void setCases(PionButton[][] cases) {
		this.cases = cases;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PionButton pion = (PionButton) e.getSource();
if(!puissance4Service.getVictoire()) {
	int lignePlace=puissance4Service.PlacerPion(cases, pion.getColonne(), pion.getLigne());
	if (lignePlace!=-1) {
		System.out.println("colonne"+pion.getColonne()+" ligne:"+pion.getLigne());
		puissance4Service.VerifierVictoire(cases, pion.getColonne(),lignePlace);
		
		if (puissance4Service.getVictoire()) {
			String joueurvainqueur;
			if (puissance4Service.getJoueur()==1) {
				joueurvainqueur=puissance4Service.getJoueur1();
				
			}
			else {
				joueurvainqueur=puissance4Service.getJoueur2();
			}
			/*
			JFrame victoire = new JFrame();
			victoire.setSize(300, 100);
			victoire.setLocationRelativeTo(null);
			// On cache la fenetre d'acceuil après le click
			victoire.add(new JLabel("Victoire!!!! bravo "+joueurvainqueur));
			victoire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			victoire.setVisible(true);*/
			FenetreVictoire fenetreVictoire=new FenetreVictoire(joueurvainqueur,this);
		}
		puissance4Service.setJoueur((puissance4Service.getJoueur() % 2) + 1);
		//puissance4Service.createGrille(cases);
	}
}
		
		if (puissance4Service.getJoueur()==1) {
			afficheJoueur.setText(puissance4Service.getJoueur1());
			
		}
		else {
			afficheJoueur.setText(puissance4Service.getJoueur2());
		}


	}

}
