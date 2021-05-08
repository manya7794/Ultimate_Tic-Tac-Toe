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
	 * @return plateau le plateau de jeu actuel
	 */
	public ArrayList<T> getPlateau(){
		return plateau;
	}
}
