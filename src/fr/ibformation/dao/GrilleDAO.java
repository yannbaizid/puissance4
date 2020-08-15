package fr.ibformation.dao;

public interface GrilleDAO {

	void createGrille(int[] grille);

	int[] getGrille(int NBCOLONNE,int NBLIGNE);
}