package Projet_IA;

import java.util.ArrayList;

public class Plateau<T> {
	//Attributs
	protected ArrayList<T> plateau;
	
	//Constructeurs
	public Plateau() {
		plateau = new ArrayList<T>();
	}
	
	//Méthodes
	
	/**
	 * 
	 * @return plateau, le plateau de jeu actuel
	 */
	public ArrayList<T> getPlateau(){
		return plateau;
	}
	
	/**
	 * Vérifie qu'un joueur a rempli une ligne
	 * 
	 * @return boolean, true si une ligne est remplie par un même symbole, false sinon
	 */
	public boolean verifLigne() {
		//Première ligne
		if(plateau.get(0).equals(plateau.get(1)) && plateau.get(0).equals(plateau.get(2)))
			return true;
		//Deuxième ligne
		if(plateau.get(3).equals(plateau.get(4)) && plateau.get(3).equals(plateau.get(5)))
			return true;
		//Troisième ligne
		if(plateau.get(6).equals(plateau.get(7)) && plateau.get(6).equals(plateau.get(7)))
			return true;
		//Première colonne
		if(plateau.get(0).equals(plateau.get(3)) && plateau.get(0).equals(plateau.get(6)))
			return true;
		//Deuxième colonne
		if(plateau.get(1).equals(plateau.get(4)) && plateau.get(1).equals(plateau.get(7)))
			return true;
		//Troisième colonne
		if(plateau.get(2).equals(plateau.get(5)) && plateau.get(0).equals(plateau.get(8)))
			return true;
		//Diagonale gauche
		if(plateau.get(4).equals(plateau.get(0)) && plateau.get(4).equals(plateau.get(8)))
			return true;
		//Diagonale droite
		if(plateau.get(4).equals(plateau.get(2)) && plateau.get(4).equals(plateau.get(6)))
			return true;
		else
			return false;
	}
}
