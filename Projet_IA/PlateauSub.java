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
	 * Methode ajoutant le symbole à la position donnée
	 * 
	 * @param pos : la position de la case dans le plateau
	 * @param symbole : le symbole "X" (-1) ou "O" (1)
	 */
	public void setCase(int pos, int symbole) {
		plateau.get(pos).addSymbole(symbole);
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
	
	/**
	 * Methode affichant la zone de jeu pour permettre au joueur de choisir sa case
	 * 
	 * @return String Zone de jeu avec les symboles pour les cases remplies et des chiffres pour les cases non remplies
	 */
	public String affiche() {
		StringBuilder tmp= new StringBuilder();
		
		//tmp.append("__________\n");
		tmp.append(" "+addNumber(plateau.get(0),1)+"|"+addNumber(plateau.get(1),2)+"|"+addNumber(plateau.get(2),3)+"\n");
		tmp.append(" -+-+-\n");
		tmp.append(" "+addNumber(plateau.get(3),4)+"|"+addNumber(plateau.get(4),5)+"|"+addNumber(plateau.get(5),6)+"\n");
		tmp.append(" -+-+-\n");
		tmp.append(" "+addNumber(plateau.get(6),7)+"|"+addNumber(plateau.get(7),8)+"|"+addNumber(plateau.get(8),9)+"\n");
		
		
		tmp.append("\n");
		return tmp.toString();
	}
	/**
	 * Methode renvoyant un String correspondant au symbole ou a la position de la case dans la zone
	 * 
	 * @param c Case dont le contenu est examine
	 * @param pos Position de la case dans la zone
	 * @return Un String correspondant au numero de la case dans la zone ou de son symbole
	 */
	public String addNumber(Case c, int pos) {
		if (c.getContenu()==0) {
			String tmp = Integer.toString(pos);
			return tmp;
		}
		else
			if(c.getContenu()==-1)
				return "X";
			else
				return "O";
			
	}
}
