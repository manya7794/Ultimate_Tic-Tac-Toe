package Projet_IA;

public class Case {
	//Attributs
	private int contenu;
	
	//Constructeurs
	public Case() {
		contenu = 0;
	}
	
	//Méthodes 
	/**
	 * Renvoie le contenu de la case 0, -1 ou 1
	 * 
	 * @return contenu le contenu de la case
	 */
	public int getContenu() {
		return contenu;
	}
	/**
	 * Verifie que la case est vide
	 * 
	 * @return true si la case est vide, false sinon
	 */
	public boolean verifContenu() {
		if (contenu==0)
			return true;
		else 
			return false;
	}
	
	/**
	 * Ecrit le symbole du joueur en cours dans la case
	 * 
	 * @param Symbole le symbole du joueur en cours
	 */
	public void addSymbole(int symbole) {
		contenu=symbole;
	}
	
	public String toString() {
		if(contenu==1)
			return "O";
		else if(contenu==-1)
			return "X";
			else
				return " ";
	}
}
