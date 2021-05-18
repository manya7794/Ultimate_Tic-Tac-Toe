package Projet_IA;

public class Valeur {
	//Attributs
	
	//Poids de la zone
	int poids;
	
	//Niveau de difficulte de l'ordinateur
	int niveau;
	
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
}
