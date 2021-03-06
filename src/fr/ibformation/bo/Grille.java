package fr.ibformation.bo;

import java.util.Arrays;

public class Grille {
	private final int NBCOLONNE = 7;
	private final int NBLIGNE = 6;
	private final int NBPIONSGAGNANTS = 4;
	int[][] grille;

	public Grille() {
		grille = new int[NBCOLONNE][NBLIGNE];
		for (int i = 0; i < NBCOLONNE; i++) {
			for (int j = 0; i < NBLIGNE; i++) {

				grille[i][j] = 0;
			}
		}

	}

	public Grille(int[][] grille) {
		super();
		this.grille = grille;
	}

	/**
	 * @return the grille
	 */
	public int[][] getGrille() {
		return grille;
	}

	/**
	 * @param grille the grille to set
	 */
	public void setGrille(int[][] grille) {
		this.grille = grille;
	}

	/**
	 * @return the nbColonne
	 */
	public int getNbColonne() {
		return NBCOLONNE;
	}

	/**
	 * @return the nbLigne
	 */
	public int getNbLigne() {
		return NBLIGNE;
	}

	/**
	 * @return the nBPIONSGAGNANTS
	 */
	public int getNBPIONSGAGNANTS() {
		return NBPIONSGAGNANTS;
	}

	@Override
	public String toString() {
		String grilleToString = "";
		for (int i = 0; i < this.NBLIGNE; i++) {
			for (int j = 0; j < this.NBCOLONNE; j++) {

				grilleToString += this.grille[j][this.NBLIGNE - i - 1] + " | ";
			}
			grilleToString += "\n";
		}
		return grilleToString;
	}

	/**
	 * PlacerPion(int colonne, int joueur) permet au joueur "joueur" de placer un
	 * pion dans la colonne "colonne" La m�thode v�rifie s'il y a une case vide dans
	 * la colonne et place le pion dans la ligne la plus basse disponible.
	 * 
	 * @param colonne
	 * @param joueur
	 * @return true si la colonne poss�de une case vide et que le pion a �t� plac�.
	 *         false si la colonne est d�j� pleine.
	 */
	public Boolean PlacerPion(int colonne, int joueur) {
		Boolean pionPlace = false;
		for (int i = 0; i < this.NBLIGNE; i++) {
			if (this.grille[colonne][i] == 0 && pionPlace == false) {
				this.grille[colonne][i] = joueur;
				pionPlace = true;
			}
		}
		return pionPlace;
	}

	/**
	 * V�rifie s'il y a suffisament de pions cons�cutifs dans la grille pour
	 * d�clencher la victoire.
	 * 
	 * @return le nombre du joueur gagnant. 0 s'il n'y a pas de victoire.
	 */
	public int VerifierVictoire() {

		for (int joueur = 1; joueur < 3; joueur++) {
			for (int i = 0; i < this.NBCOLONNE; i++) {
				for (int j = 0; j < this.NBLIGNE; j++) {
					if (VerifierVictoire(joueur, i, j) != 0) {
						return VerifierVictoire(joueur, i, j);
					}

				}

			}

		}

		return 0;
	}

	/**
	 * Prend le dernier joueur ayant jou�, ainsi que les coordonn�es du dernier coup.
	 * V�rifie si ce coup d�clenche une victoire.
	 * @param joueur
	 * @param colonne
	 * @param ligne
	 * @return 0 si pas de victoire. 1 si joueur 1 gagne, 2 si joueur 2 gagne.
	 */
	public int VerifierVictoire(int joueur, int colonne, int ligne) {
		int joueurgagnant = 0;
		String streak = "";
		for (int i = 0; i < this.NBPIONSGAGNANTS; i++) {
			streak += String.valueOf(joueur);
		}
		// V�rifier si la ligne contient quatre pions cons�cutifs du joueur
		if (Ligne(ligne).indexOf(streak) != -1) {
			return joueur;
		}
		// V�rifier si la colonne contient quatre pions cons�cutifs du joueur
		if (Colonne(colonne).indexOf(streak) != -1) {
			return joueur;
		}
		// V�rifier si la diagonale slash (/) contient quatre pions cons�cutifs du
		// joueur
		if (DiagonaleSlash(colonne, ligne).indexOf(streak) != -1) {
			return joueur;
		}
		// V�rifier si la diagonale antislash (/) contient quatre pions cons�cutifs du
		// joueur
		if (DiagonaleAntiSlash(colonne, ligne).indexOf(streak) != -1) {
			return joueur;
		}
		return 0;
	}


	/**
	 * DiagonaleSlash(int colonne, int ligne) permet de r�cup�rer en string la diagonale slash (/) contenant la case s�lectionn�e
	 * @param colonne
	 * @param ligne
	 * @return string diagonaleSlash
	 */
	private String DiagonaleSlash(int colonne, int ligne) {
		String diagonaleSlash = "";
		int min = Math.min(colonne, ligne);
		colonne -= min;
		ligne -= min;
		while (colonne < this.NBCOLONNE && ligne < this.NBLIGNE) {
			diagonaleSlash += this.grille[colonne][ligne];
			colonne++;
			ligne++;
		}
		return diagonaleSlash;
	}

	/**
	 * DiagonaleAntiSlash(int colonne, int ligne) permet de r�cup�rer en string la diagonale anti-slash (\) contenant la case s�lectionn�e
	 * @param colonne
	 * @param ligne
	 * @return string diagonaleAntiSlash
	 */
	private String DiagonaleAntiSlash(int colonne, int ligne) {
		String diagonaleAntiSlash = "";
		int min = Math.min(this.NBCOLONNE - (colonne+1), ligne);
		colonne += min;
		ligne -= min;
		while (colonne >= 0 && ligne < this.NBLIGNE) {
			diagonaleAntiSlash += this.grille[colonne][ligne];
			colonne--;
			ligne++;
		}

		return diagonaleAntiSlash;
	}

	/**
	 * Ligne(int ligne) permet de transformer la ligne s�lectionn�e en string
	 * @param ligne
	 * @return un string repr�sentant la ligne de la grille
	 */
	private String Ligne(int ligne) {
		String ligneString = "";
		for (int i = 0; i < this.NBCOLONNE; i++) {
			ligneString += String.valueOf(this.grille[i][ligne]);
		}
		return ligneString;
	}

	/**
	 * Colonne(int colonne) permet de transformer la colonne s�lectionn�e en string
	 * @param colonne
	 * @return un string repr�sentant la colonne de la grille
	 */
	public String Colonne(int colonne) {
		String colonneString = "";
		for (int i = 0; i < this.NBLIGNE; i++) {
			colonneString += String.valueOf(this.grille[colonne][i]);
		}
		return colonneString;
	}
}
