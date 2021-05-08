package Projet_IA;

public class Case {
	//Attributs
	private String contenu;
	
	//Constructeurs
	public Case() {
		contenu = "";
	}
	
	//Méthodes 
	/**
	 * Renvoie le contenu de la case "", "O" ou "X"
	 * 
	 * @return contenu le contenu de la case
	 */
	public String getContenu() {
		return contenu;
	}
}
