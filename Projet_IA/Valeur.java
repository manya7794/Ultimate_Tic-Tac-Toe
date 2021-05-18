package Projet_IA;

public class Valeur {
	//Attributs
	
	//Poids de la zone
	private int poids;
	
	//Niveau de difficulte de l'ordinateur
	private int niveau;
	
	//Constructeur
	
	/**
	 * Cree une entitee valeur avec un niveau d'IA defini
	 * @param niveau niveau de l'IA
	 */
	public Valeur(int niveau) {
		this.poids=0;
		this.niveau=niveau;
	}
	
	/**
	 * Cree
	 */
	public Valeur() {
		this.poids=0;
		this.niveau=0;
	}
	
	//Methodes
	
	/**
	 * Methode renvoyant le poids de la zone
	 * 
	 * @return le poids de la zone
	 */
	public int getPoids() {
		return poids;
	}
	
	/**
	 * Methode renvoyant le niveau choisit par l'utilisateur
	 * 
	 * @return le niveau choisit
	 */
	public int getNiveau() {
		return niveau
	}
}
