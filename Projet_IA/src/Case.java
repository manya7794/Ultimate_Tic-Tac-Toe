
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
	
	//Definit la case sur detruit apres un tir
	public void setCaseDetruit() {
		this.type=3;
	}
	
	//Definit la case i j sur detruit apres un tir
	public static void setCaseDetruit(Plateau plat, int i, int j) {
		Case[][] caseCourant = plat.getPlateau();
		caseCourant[i][j].type = 3;
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
	
	//Renvoie le symbole de la case
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