package Projet_IA;

import java.util.Scanner;

public class Jeu {
	
	//Attributs
	private PlateauPrincipal plateauP;
	//private PlateauSub plateauS;
	private Joueur j1;
	private Case x;
	
	//private Joueur j2;
	private Case o;
	
	private Scanner sc;
	
	//Constructeur
	public Jeu() {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();
		//Petit plateau contenant les 9 cases
		//plateauS = new PlateauSub();
		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//Joueur j2, joue en deuxième, avec le sylbole "O"
		//j2 = new Joueur(false,1);
		
		x = new Case();
		x.addSymbole(-1);
		
		o = new Case();
		o.addSymbole(1);
		
		sc = new Scanner(System.in);
	}
	
	//Methodes
	
	/**
	 * 
	 */
	public void joueurVersusJoueur() {
		affichageChoixZone();
		int choixZone = sc.nextInt()-1;
		int choixCase;
		//Tant que le plateau principal est jouable, la partie n'est pas terminee
		while(plateauP.verifZone() || plateauP.verifZoneRemplie()) {
			affichageZone(choixZone);
			choixCase = sc.nextInt()-1;
			
			if(j1.tour) {
				plateauP.plateau.get(choixZone).setCase(choixCase, -1);
				j1.tour = false;
			}
			else {
				plateauP.plateau.get(choixZone).setCase(choixCase, 1);
				j1.tour = true;
			}
			
			if(plateauP.plateau.get(choixCase).verifZone() || plateauP.plateau.get(choixCase).verifZoneRemplie()) {
				
			}
		}
	}
	
	/**
	 * Methode affichant le plateau principal 
	 */
	public void affichageChoixZone() {
		System.out.println(plateauP.toString());
		System.out.println("\nVeuillez choisir la zone sur lequel vous voulez jouer (1-9) : \n");
	}
	
	/**
	 * Methode affichant la zone
	 * 
	 * @param choix : la zone que l'on veut afficher
	 */
	public void affichageZone(int choix) {
		System.out.println(plateauP.plateau.get(choix).affiche());
		System.out.println("\nVeuillez choisir la case sur lequel vous voulez jouer (1-9) : \n");
	}
	
	
}
