package fr.ibformation.ihm;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.awt.*;

public class FenetreVictoire extends JFrame {
	// constructeur
	public FenetreVictoire(String nom, GrillePanel grillePanel) {

		this.setTitle("Victoire");
		this.setSize(500, 500);

		// écouteur pour le bouton nouvelle partie
		ActionListener listener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fenetre f1 = (Fenetre) SwingUtilities.getRoot(grillePanel);
				f1.dispose();
				Joueur fenetreJoueur = new Joueur();
				setVisible(false);
				fenetreJoueur.setVisible(true);
			}
		};

		// création des boutons nouvelle partie et quitter

		JButton boutonPartie = new JButton("Nouvelle partie");

		// ajout des écouteurs
		boutonPartie.addActionListener(listener1);

		// Création du JPanel qui contiendra les boutons et ajout des boutons
		JPanel boutonAjout = new JPanel();
		boutonAjout.setBackground(Color.red);
		boutonAjout.add(boutonPartie);

		// Création des JLabel contenant le texte de victoire
		/*
		 * if (i == 1) nom = fenetrePrincipal.joueur.joueur1; else nom =
		 * fenetrePrincipal.joueur.joueur2;
		 */
		JLabel jlabel = new JLabel("Félicitations " + nom + ", vous avez gagné !");

		// Création des JPanel
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.setBackground(Color.red);

		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("photofunky.gif");
			Image image = ImageIO.read(input);
			Icon icon = new ImageIcon(image);
			JLabel image1 = new JLabel(icon);
			panel2.add(image1, BorderLayout.CENTER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel2.setVisible(true);

		panel2.add(jlabel, BorderLayout.NORTH);
		panel2.add(boutonAjout, BorderLayout.SOUTH);

		// réunion des deux JPanel
		panel.add(panel2, BorderLayout.CENTER);

		this.setLocationRelativeTo(null);
		jlabel.setSize(500, 100);
		// affectation du JPanel à la JFrame
		this.setContentPane(panel2);
		this.setVisible(true);
	}

}