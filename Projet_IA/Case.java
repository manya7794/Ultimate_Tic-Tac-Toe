package Projet_IA;

public class Case {
	//Attributs
	private int contenu;
	
	//Constructeurs
	public Case() {
		this.contenu = 0;
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
	public void setSymbole(int symbole) {
		this.contenu=symbole;
	}
	
	/**
	 * Ecrit un symbole croix dans la case
	 */
	public void setCross() {
		this.contenu=-1;
	}
	
	/**
	 * Ecrit un symbole cercle dans la case
	 */
	public void setCircle() {
		this.contenu=1;
	}
	
	/**
	 * Si le contenu est egal a 1 renvoie "O"
	 * Si le contenu est egal a -1 renvoie "X"
	 * Sinon renvoie " "
	 */
	public String toString() {
		if(contenu==1)
			return "O";
		else if(contenu==-1)
			return "X";
			else
				return " ";
	}
}
