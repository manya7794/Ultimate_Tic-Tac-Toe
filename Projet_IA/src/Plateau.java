import java.util.Scanner;

public class Plateau {
	//Attributs
	//Nombre de lignes du plateau
	private int hauteur;
	//Nombre de colonnes du plateau
	private int largeur;
	//Plateau
	private Case[][] plateau;
	//Derniere case en memoire
	private Case caseMemoire;
	//Coordonnees de la derniere case en memoire
	private String coordonneesCaseMemoire;
	
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
	
	//Fixe une case dans la case memoire
	public void setCaseMemoire(Case c) {
		this.caseMemoire=c;
	}
	
	//Fixe les coordonnees de la case memoire
	public void setCoordonneesCaseMemoire(String c) {
		this.coordonneesCaseMemoire=c;
	}
	
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
	
	//Renvoie la case en memoire
	public Case getCaseMemoire() {
		return caseMemoire;
	}
	
	//Renvoie les coordonnees de la case memoire
	public String getCoordonneesCaseMemoire() {
		return coordonneesCaseMemoire;
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
		setCoordonneesCaseMemoire(coordonnees);
		//Recupere la lettre definissant la colonne
		Character colonne=coordonnees.charAt(0);
		//Cas ou la lettre n'est pas en majuscule
		if(!Character.isUpperCase(colonne))
			colonne=Character.toUpperCase(colonne);
		//Recupere le nombre definissant la ligne
		Character ligne=coordonnees.charAt(1);
		//Permet de verifier si la case correspond a la dixieme ou non
		boolean dix=false;
		if (coordonnees.length()>=3) {
			int tmp1= Integer.parseInt(String.valueOf(coordonnees.charAt(1)));
			int tmp2= Integer.parseInt(String.valueOf(coordonnees.charAt(2)));
			
			if((tmp1==1)&&(tmp2==0)) {
				dix=true;	
			}
			else {
				Case c = new Case();
				c.setCaseInexistante();
				setCaseMemoire(c);
				return c;
			}
		}
		//Cherche la colonne correspondante
		switch (colonne) {
		case 'A':
			if(dix) {
				setCaseMemoire(plateau[9][0]);
				return plateau[9][0];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][0]);
			return plateau[Character.getNumericValue(ligne)-1][0];
		case 'B':
			if(dix) {
				setCaseMemoire(plateau[9][1]);
				return plateau[9][1];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][1]);
			return plateau[Character.getNumericValue(ligne)-1][1];
		case 'C':
			if(dix) {
				setCaseMemoire(plateau[9][2]);
				return plateau[9][2];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][2]);
			return plateau[Character.getNumericValue(ligne)-1][2];
		case 'D':
			if(dix) {
				setCaseMemoire(plateau[9][3]);
				return plateau[9][3];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][3]);
			return plateau[Character.getNumericValue(ligne)-1][3];
		case 'E':
			if(dix) {
				setCaseMemoire(plateau[9][4]);
				return plateau[9][4];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][4]);
			return plateau[Character.getNumericValue(ligne)-1][4];
		case 'F':
			if(dix) {
				setCaseMemoire(plateau[9][5]);
				return plateau[9][5];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][5]);
			return plateau[Character.getNumericValue(ligne)-1][5];
		case 'G':
			if(dix) {
				setCaseMemoire(plateau[9][6]);
				return plateau[9][6];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][6]);
			return plateau[Character.getNumericValue(ligne)-1][6];
		case 'H':
			if(dix) {
				setCaseMemoire(plateau[9][7]);
				return plateau[9][7];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][7]);
			return plateau[Character.getNumericValue(ligne)-1][7];
		case 'I':
			if(dix) {
				setCaseMemoire(plateau[9][8]);
				return plateau[9][8];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][8]);
			return plateau[Character.getNumericValue(ligne)-1][8];
		case 'J':
			if(dix) {
				setCaseMemoire(plateau[9][9]);
				return plateau[9][9];
			}
			setCaseMemoire(plateau[Character.getNumericValue(ligne)-1][9]);
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