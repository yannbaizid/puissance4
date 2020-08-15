package fr.ibformation.service;

import fr.ibformation.dao.GrilleDAO;
import fr.ibformation.dao.GrilleDAOImpl;

public class GrilleServiceImpl implements GrilleService {

	@Override
	public void createGrille(int[] grille) {

		GrilleDAO grilleDAO = new GrilleDAOImpl();
		grilleDAO.createGrille(grille);	
	}

}
