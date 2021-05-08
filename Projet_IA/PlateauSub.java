package Projet_IA;

import java.util.ArrayList;

public class PlateauSub extends Plateau<Case>{
	//Attributs
	private int derniereCase;
	
	//Constructeur
	public PlateauSub() {
		plateau = new ArrayList<Case>();
	}
	
	//Methodes
	
	/**
	 * Methode renvoyant la case choisie par l'utilisateur
	 * 
	 * @param num le numero de la case a recuperer
	 * @return la case choisie par l'utilisateur
	 */
	public Case getCase(int num) {
		return plateau.get(num);
	}
	
	/**
	 * Methode renvoyant la position de la derniere case a avoir ete modifie dans cette zone
	 * 
	 * @return la position de la derniere case de la zone a avoir ete modifie
	 */
	public int getDerniereCase() {
		return derniereCase;
	}
	
	/**
	 * Fixe la position de la derniere case a avoir ete modifie
	 * @param pos numero de la case
	 */
	public void setDerniereCase(int pos) {
		derniereCase=pos;
	}
	
}
