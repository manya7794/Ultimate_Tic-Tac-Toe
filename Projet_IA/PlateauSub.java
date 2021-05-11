package Projet_IA;

import java.util.ArrayList;

public class PlateauSub extends Plateau<Case>{
	//Attributs
	private int derniereCase;
	
	//Constructeur
	public PlateauSub() {
		plateau = new ArrayList<Case>();
		initialisation();
	}
	
	//Methodes
	
	/**
	 * Methode ajoutant les 9 cases dans le plateau 
	 */
	public void initialisation() {
		Case laCase = new Case();
		for(int i = 0 ; i < 9 ; i++) {
			plateau.add(laCase);
		}
	}
	
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
	
	/**
	 * Renvoie le plateau sous forme de String
	 */
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		
		
		tmp.append("| "+plateau.get(0).toString()+" | "+plateau.get(1).toString()+" | "+plateau.get(2).toString());
		tmp.append(" || "+plateau.get(3).toString()+" | "+plateau.get(4).toString()+" | "+plateau.get(5).toString()+"");
		tmp.append(" || "+plateau.get(6).toString()+" | "+plateau.get(7).toString()+" | "+plateau.get(8).toString()+" |\n");
		return tmp.toString();
	}
}
