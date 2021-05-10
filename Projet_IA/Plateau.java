package Projet_IA;

import java.util.ArrayList;

public class Plateau<T> {
	//Attributs
	protected ArrayList<T> plateau;
	
	//Constructeurs
	public Plateau() {
		plateau = new ArrayList<T>();
	}
	
	//Methodes
	
	/**
	 * Renvoie le plateau de jeu actuel
	 * 
	 * @return plateau, le plateau de jeu actuel
	 */
	public ArrayList<T> getPlateau(){
		return plateau;
	}
	
	/**
	 * Vérifie qu'un joueur a rempli une ligne
	 * 
	 * @return boolean, true si une ligne est remplie par un męme symbole, false sinon
	 */
	public boolean verifZone() {
		//Premiere ligne
		if(plateau.get(0).equals(plateau.get(1)) && plateau.get(0).equals(plateau.get(2)))
			return true;
		//Deuxieme ligne
		if(plateau.get(3).equals(plateau.get(4)) && plateau.get(3).equals(plateau.get(5)))
			return true;
		//Troisieme ligne
		if(plateau.get(6).equals(plateau.get(7)) && plateau.get(6).equals(plateau.get(7)))
			return true;
		//Premiere colonne
		if(plateau.get(0).equals(plateau.get(3)) && plateau.get(0).equals(plateau.get(6)))
			return true;
		//Deuxieme colonne
		if(plateau.get(1).equals(plateau.get(4)) && plateau.get(1).equals(plateau.get(7)))
			return true;
		//Troisieme colonne
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
	
	/**
	 * Verifie si la zone est remplie ou non
	 * 
	 * @return boolean, true si la zone est remplie donc si les 9 cases contiennent un symbole, false sinon
	 */
	public boolean verifZoneRemplie() {
		//Verifie que toutes les cases sont remplies, donc non vide
		if(	plateau.get(0).equals(0) || plateau.get(1).equals(0) || plateau.get(2).equals(0) ||
			plateau.get(0).equals(3) || plateau.get(4).equals(0) || plateau.get(5).equals(0) ||
			plateau.get(0).equals(6) || plateau.get(7).equals(0) || plateau.get(8).equals(0) 
		)
			return false;
		else
			return true;
	}
	
	/**
	 * Renvoie le plateau sous forme de String
	 */
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		
		for(int i=0; i<plateau.size();i++) {
			tmp.append(plateau.get(i).toString());
			if((i!=2)||(i!=5)||(i!=8)) {
				tmp.append("|");
			}
			else
				if((i==2)||(i==5)) {
					tmp.append("\n_____\n");
				}
		}
		tmp.append("\n");
		return tmp.toString();
	}
}
