
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
	
	//Renvoie l'affichage du plateau de jeu
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		for(int i=0;i<plateau.length;i++) {
			for(int j=0; j<plateau[i].length;j++) {
				tmp.append(plateau[i][j].getSymbole()+" ");
			}
			tmp.append("\n");
		}
		return tmp.toString();
	}
}
