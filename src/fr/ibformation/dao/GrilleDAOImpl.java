package fr.ibformation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ibformation.ihm.PionButton;
import fr.ibformation.service.Puissance4Service;

public class GrilleDAOImpl implements GrilleDAO {


	@Override
	public void createGrille(int[] grille) {

		try {

			for (int i = 0; i < grille.length; i++) {

				Connection cnx = DAOUtil.getConnexion();
				String requete = "UPDATE Grille SET valeur=? WHERE id_position =?;";
				PreparedStatement pstmt = cnx.prepareStatement(requete);
				pstmt.setInt(1, grille[i]);
				pstmt.setInt(2, i+1);

				pstmt.executeUpdate();

				cnx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public int[] getGrille(int NBCOLONNE,int NBLIGNE) {
		int[] grilles = new int[NBCOLONNE * NBLIGNE];
		// PionButton[][] cases = new
		// PionButton[Puissance4Service.getNBCOLONNE()][Puissance4Service.getNBLIGNE()];
		// PionButton[][] cases = new PionButton[7][6];
		Connection cnx = DAOUtil.getConnexion();
		String requete = "SELECT * FROM Grille";
		int index=0;
		try {
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// PionButton[][] lacase = new PionButton[7][6];
				// int [] grille = new int [0][0];
				int value = (rs.getInt("valeur"));
				
				 grilles[index] = value;
				 index++;

			}

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grilles;
	}

}