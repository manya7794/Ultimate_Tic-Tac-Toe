package Projet_IA;

public class Valeur {
	//Attributs
	
	//Poids de la zone
	private int poids;
	
	//Niveau de difficulte de l'ordinateur
	private int niveau;
	
	//Constructeur
	/**
	 * Constructeur
	 * @param niveau
	 */
	public Valeur(int niveau) {
		this.poids=0;
		this.niveau=niveau;
	}
	
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
}
