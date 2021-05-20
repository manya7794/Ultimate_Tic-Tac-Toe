package Projet_IA;

import java.util.Scanner;

public class Joueur {
	//Attributs
	public boolean tour;
	public int symbole;
	
	//Constructeur
	public Joueur(boolean tour, int symbole) {
		this.tour=tour;
		this.symbole=symbole;
	}
	
	//Methodes
	
	/**
	 * Methode cochant la case choisie par l'utilisateur
	 * @param plat plateau subsidiaire sur lequel se deroule le tour actuel
	 */
	public void cocheCase(PlateauSub plat) {
		boolean sortie = false;
		while(!sortie) {
			//Affichage des instructions
			System.out.println("Cochez une case :\n");
			System.out.println("1|2|3\n");
			System.out.println("_____\n");
			System.out.println("4|5|6\n");
			System.out.println("_____\n");
			System.out.println("7|8|9\n");
			
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
			
			//Verifie que la case est libre
			boolean libre =	plat.getCase(choix).verifContenu();
			if(libre) {
				//Ajoute le symbole
				plat.getCase(choix).setSymbole(symbole);
				//Met en memoire la position de la case
				plat.setDerniereCase(choix);
				//Sortie de la boucle
				sortie=true;
				//Desactive le tour du joueur
				tour=false;
				sc.close();
			}
		}

		
	}
	
	/**
	 * Methode retournant un boolean indiquant si c'est au tour du joueur ou non
	 * @return true si c'est le tour du joueur, false sinon
	 */
	public boolean getTour() {
		return tour;
	}
	
	/**
	 * Methode pour set le tour a true ou false
	 * @param tour le tour
	 */
	public void setTour(boolean tour) {
		this.tour = tour;
	}
}