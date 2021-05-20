package Projet_IA;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Classe permettant de lancer une partie d'Ultimate Tic-Tac-Toe
 *
 */
public class Main {


	public static void main(String[] args) {
		System.out.println("*************************");
		System.out.println("Ultimate Tic-Tac-Toe");
		Scanner sc=new Scanner(System.in);
		//Choix du mode jeu 2 joueurs ou 1 joueur
		int choix=choixPrincipal(sc);
		//Cas ou l'utilisateur veut jouer contre l'ordinateur
		if(choix==1) {
			//Choix du niveau de difficulte
			choix=choixDifficulte(sc);
			//Creation d'une nouvelle partie selon le niveau de difficulte choisit
			Jeu j1 = new Jeu(choix);
			//Lancement de la partie contre l'IA
			j1.joueurVersusIA();
			
		}
		//Cas ou l'utilisateur veut jouer contre un autre humain	
		else if(choix==2) {
			//Creation d'une nouvelle partie
			Jeu j2=new Jeu();
			//Lancement de la partie contre un autre joueur
			j2.joueurVersusJoueur();
		}
	}
	
	/**
	 * Methode recuperant le choix de l'utilisateur 
	 * au niveau du menu principal
	 * @param sc Scanner recuperant le choix
	 * @return Choix de l'utilisateur
	 */
	public static int choixPrincipal(Scanner sc) {
		boolean sortie=false;
		String choix = null;
		System.out.println("Selectionnez votre mode de jeu :");
		while(!sortie) {
			afficheMenuPrincipal();
			try {
				choix=sc.nextLine();
			}catch (InputMismatchException exception) {
				System.out.println(choix+" n'est pas une entree valide");
			}
			
			if((choix.equals("1"))||(choix.equals("2"))) {
				sortie=true;
			}
			else {
				System.out.println(choix+" n'est pas une entree valide.\n");
				System.out.println("Selectionnez votre mode de jeu :");
			}
		}
		return Integer.valueOf(choix);
	}
	
	/**
	 * Methode affichant le menu principal
	 */
	public static void afficheMenuPrincipal() {
		System.out.println("1.Mode 1 joueur");
		System.out.println("2.Mode 2 joueurs");
	}

	/**
	 * Methode recuperant le choix de l'utilisateur
	 * au niveau du menu de choix du niveau de l'IA
	 * @param sc Scanner recuperant le choix
	 * @return
	 */
	public static int choixDifficulte(Scanner sc) {
		boolean sortie=false;
		String choix =null;
		System.out.println("Selectionnez le niveau de difficulte de l'IA que vous voulez affronter :");
		while(!sortie) {
			afficheMenuDifficulte();
			try {
				choix=sc.nextLine();
			}catch (InputMismatchException exception) {
				System.out.println(choix+" n'est pas une entree valide");
			}
			
			if((choix.equals("1"))||(choix.equals("2"))||(choix.equals("3"))) {
				sortie=true;
			}
			else {
				System.out.println(choix+" n'est pas une entree valide.\n");
				System.out.println("Selectionnez le niveau de difficulte de l'IA que vous voulez affronter :");
			}
		}
		return Integer.valueOf(choix);
	}
	
	/**
	 * Methode affichant le menu de choix de la difficulte
	 */
	public static void afficheMenuDifficulte() {
		System.out.println("1.Mode facile");
		System.out.println("2.Mode intermediaire");
		System.out.println("3.Mode difficile");
	}
}