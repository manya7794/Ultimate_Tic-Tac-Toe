import java.util.Scanner;

public class Plateau {
	//Attributs
	//Nombre de lignes du plateau
	private int hauteur;
	//Nombre de colonnes du plateau
	private int largeur;
	//Plateau
	private Case[][] plateau;

	
	//Constructeur
	public Plateau() {
		this.hauteur=10;
		this.largeur=10;
		this.plateau= new Case[hauteur][largeur];
		initValeur();
	}
	
	public Plateau(Bateau listeBateau) {
		this.hauteur=10;
		this.largeur=10;
		this.plateau= new Case[hauteur][largeur];
		initValeur();
		listeBateau.mettreBateauxAleatoire(this);
	}
	
	//Methodes
	
	//Renvoie le plateau
	public Case[][] getPlateau() {
		return plateau;
	}
	
	//Renvoie la hauteur du plateau
	public int getHauteur() {
		return hauteur;
	}
	
	//Renvoie la largeur du plateau
	public int getLargeur() {
		return largeur;
	}
	
	//Initialise les cases du plateau
	public void initValeur() {
		for(int i=0;i<plateau.length;i++) {
			for(int j=0; j<plateau[i].length;j++) {
				plateau[i][j]= new Case();
			}
		}
	}
	
	/*
	 * Renvoie la case en fonction des coordonnees passees en entree
	 * @param coordonnees les coordonnes de la case au format "A1" ou "a1"
	 * @return La case correspondante
	 */
	public Case getCase(String coordonnees) {
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
				return plateau[9][0];
			}
			return plateau[Character.getNumericValue(ligne)-1][0];
		case 'B':
			if(dix) {
				return plateau[9][1];
			}
			return plateau[Character.getNumericValue(ligne)-1][1];
		case 'C':
			if(dix) {
				return plateau[9][2];
			}
			return plateau[Character.getNumericValue(ligne)-1][2];
		case 'D':
			if(dix) {
				return plateau[9][3];
			}
			return plateau[Character.getNumericValue(ligne)-1][3];
		case 'E':
			if(dix) {
				return plateau[9][4];
			}
			return plateau[Character.getNumericValue(ligne)-1][4];
		case 'F':
			if(dix) {
				return plateau[9][5];
			}
			return plateau[Character.getNumericValue(ligne)-1][5];
		case 'G':
			if(dix) {
				return plateau[9][6];
			}
			return plateau[Character.getNumericValue(ligne)-1][6];
		case 'H':
			if(dix) {
				return plateau[9][7];
			}
			return plateau[Character.getNumericValue(ligne)-1][7];
		case 'I':
			if(dix) {
				return plateau[9][8];
			}
			return plateau[Character.getNumericValue(ligne)-1][8];
		case 'J':
			if(dix) {
				return plateau[9][9];
			}
			return plateau[Character.getNumericValue(ligne)-1][9];
		default:
			//Cas ou la colonne entree n'existe pas
			System.out.println("Saisissez une colonne valide");
			//Relance une entree
			Scanner sc= new Scanner(System.in);
			String tmp=sc.next();
			return getCase(tmp);
		}
	}
	
	//Renvoie l'affichage du plateau de jeu
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		for(int i=0;i<plateau.length;i++) {
			for(int j=0; j<plateau[i].length;j++) {
				tmp.append(plateau[i][j].getSymboleJoueur()+" ");
			}
			tmp.append("\n");
		}
		return tmp.toString();
	}
}