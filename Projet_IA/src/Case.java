
public class Case {
	//Attributs
	private int type;
	
	//Constructeurs
	public Case() {
		this.type=0;
	}
	
	//Methodes
	
	//Definit la case sur Mer
	public void setCaseMer() {
		this.type=0;
	}
	
	//Definit la case sur Bateau
	public void setCaseBateau() {
		this.type=1;
	}
	
	//Definit la case i j sur Bateau
	public void setCaseBateau(Plateau plat, int i, int j) {
		Case[][] caseCourant = plat.getPlateau();
		caseCourant[i][j].type = 1;
	}
	
	//Definit la case sur vide apres un tir
	public void setCaseVide() {
		this.type=2;
	}
	
	//Definit la case i j sur vide apres un tir
	public static void setCaseVide(Plateau plat, int i, int j) {
		Case[][] caseCourant = plat.getPlateau();
		caseCourant[i][j].type = 2;
	}
	
	/*
	 * Definit la case correspondant aux coordonnees sur vide apres un tir
	 * @param plateau le plateau de jeu ou se situe la case
	 * @param coordonnees les coordonnes de la case
	 */
	public static void setCaseVide(Plateau plateau, String coordonnees) {
		//Recupere la lettre definissant la colonne
		Character colonne=coordonnees.charAt(0);
		//Cas ou la lettre n'est pas en majuscule
		if(!Character.isUpperCase(colonne))
			colonne=Character.toUpperCase(colonne);
		//Recupere le nombre definissant la ligne
		Character ligne=coordonnees.charAt(1);
		//Permet de verifier si la case correspond a la dixieme ou non
		boolean dix=false;
		if (coordonnees.length()==3) {
			dix=true;
		}
		//Cherche la colonne correspondante
		switch (colonne) {
		case 'A':
			if(dix) {
				plateau.getPlateau()[9][0].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][0].setCaseVide();
			break;
		case 'B':
			if(dix) {
				plateau.getPlateau()[9][1].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][1].setCaseVide();
			break;
		case 'C':
			if(dix) {
				plateau.getPlateau()[9][2].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][2].setCaseVide();
			break;
		case 'D':
			if(dix) {
				plateau.getPlateau()[9][3].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][3].setCaseVide();
			break;
		case 'E':
			if(dix) {
				plateau.getPlateau()[9][4].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][4].setCaseVide();
			break;
		case 'F':
			if(dix) {
				plateau.getPlateau()[9][5].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][5].setCaseVide();
			break;
		case 'G':
			if(dix) {
				plateau.getPlateau()[9][6].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][6].setCaseVide();
			break;
		case 'H':
			if(dix) {
				plateau.getPlateau()[9][7].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][7].setCaseVide();
			break;
		case 'I':
			if(dix) {
				plateau.getPlateau()[9][8].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][8].setCaseVide();
			break;
		case 'J':
			if(dix) {
				plateau.getPlateau()[9][9].setCaseVide();
				break;
			}
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][9].setCaseVide();
			break;
		}
	}
	
	//Definit la case sur detruit apres un tir
	public void setCaseDetruit() {
		this.type=3;
	}
	
	//Definit la case i j sur detruit apres un tir
	public static void setCaseDetruit(Plateau plat, int i, int j) {
		Case[][] caseCourant = plat.getPlateau();
		caseCourant[i][j].type = 3;
	}
	
	/*
	 * Definit la case correspondant aux coordonnees sur detruit apres un tir
	 * @param plateau le plateau de jeu ou se situe la case
	 * @param coordonnees les coordonnes de la case
	 */
	public static void setCaseDetruit(Plateau plateau, String coordonnees) {
		Character colonne=coordonnees.charAt(0);
		if(!Character.isUpperCase(colonne))
			colonne=Character.toUpperCase(colonne);
		Character ligne=coordonnees.charAt(1);
		switch (colonne) {
		case 'A':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][0].setCaseDetruit();
			break;
		case 'B':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][1].setCaseDetruit();
			break;
		case 'C':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][2].setCaseDetruit();
			break;
		case 'D':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][3].setCaseDetruit();
			break;
		case 'E':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][4].setCaseDetruit();
			break;
		case 'F':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][5].setCaseDetruit();
			break;
		case 'G':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][6].setCaseDetruit();
			break;
		case 'H':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][7].setCaseDetruit();
			break;
		case 'I':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][8].setCaseDetruit();
			break;
		case 'J':
			plateau.getPlateau()[Character.getNumericValue(ligne)-1][9].setCaseDetruit();
			break;
		}
	}
	
	public void setCaseInexistante() {
		this.type=3;
	}
	
	//Renvoie le type de la case
	public int getCaseType() {
		return type;
	}
	
	//Renvoie le type de la case i j du plateau courant
	public static int getCaseType(Plateau plat, int i, int j) {
		Case[][] caseCourant = plat.getPlateau();
		return caseCourant[i][j].type;
	}
	
	/*
	 * Renvoie le symbole de la case du plateau joueur
	 * @return le symbole de la case
	 */
	public String getSymboleJoueur() {
		switch(type) {
		case 0:
			return "~";
		case 1:
			return "b";
		case 2:
			return "o";
		case 3:
			return "x";
		default:
			return "~";
		}
	}
	
	/*
	 * Renvoie le symbole de la case du plateau adverse
	 * @return le symbole de la case
	 */
	public String getSymboleAdverse() {
		switch(type) {
		case 0:
			return "~";
		case 1:
			return "~";
		case 2:
			return "o";
		case 3:
			return "x";
		default:
			return "~";
		}
	}
}