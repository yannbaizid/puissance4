package fr.ibformation.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.ibformation.service.Puissance4Service;

public class MenuPanel extends JPanel {

	private Puissance4Service puissance4Service = new Puissance4Service();

	public MenuPanel(Puissance4Service puissance4Service2) {

		JButton boutonSaveGame = new JButton("Sauvegarder");
		boutonSaveGame.setBackground(Color.GREEN);

		JButton boutonExitGame = new JButton("Abandonner");
		boutonExitGame.setBackground(Color.RED);
		boutonExitGame.addActionListener(new ClickAbandonner());
		boutonSaveGame.addActionListener(new ClickSauvegarder());
		this.add(boutonSaveGame);
		this.add(boutonExitGame);

		boutonSaveGame.setPreferredSize(new Dimension(120, 50));
		boutonExitGame.setPreferredSize(new Dimension(120, 50));

		int joueur = puissance4Service.getJoueur() % 2 + 1;

	}

	public class ClickAbandonner implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			System.exit(0);

		}
	}

	public class ClickSauvegarder implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Fenetre f1 = (Fenetre)SwingUtilities.getRoot((JButton)e.getSource());
			PionButton[][] cases = f1.getGrillePanel().getCases();
			puissance4Service.createGrille(cases);

		}
	}

}
