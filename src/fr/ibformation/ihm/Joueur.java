package fr.ibformation.ihm;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

class Joueur extends JFrame {
	String joueur1, joueur2;
	JTextField saisieJoueur1;
	JTextField saisieJoueur2;
	Joueur joueur;

	public Joueur() {

		joueur = this;
		this.setTitle("Joueurs");

		// initialisation nom des joueurs

		saisieJoueur1 = new JTextField(30);
		saisieJoueur2 = new JTextField(30);

		JLabel jlabel1 = new JLabel("Joueur 1 : ");
		JLabel jlabel2 = new JLabel("Joueur 2 : ");

		// évènement de click sur bouton
		ActionListener listen = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// on récupère les noms des deux joueurs
				joueur1 = saisieJoueur1.getText();
				joueur2 = saisieJoueur2.getText();

				// on cache la fenêtre courante
				setVisible(false);
				Fenetre fen = new Fenetre(joueur1,joueur2);
			}
		};

		// création du bouton
		JButton bouton1 = new JButton("Let's go");
		bouton1.addActionListener(listen);

		// Création des JPanel
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		// ajout des différents éléments dans les JPanel
		panel1.add(jlabel1);
		panel1.add(saisieJoueur1);
		panel2.add(jlabel2);
		panel2.add(saisieJoueur2);
		panel3.add(bouton1);

		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		// Ajout des JPanel dans la JFrame
		this.getContentPane().add(panel1, BorderLayout.NORTH);
		this.getContentPane().add(panel2, BorderLayout.CENTER);
		this.getContentPane().add(panel3, BorderLayout.SOUTH);
	}
}