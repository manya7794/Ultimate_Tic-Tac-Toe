package Projet_IA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JeuBis {
	
	//Attributs
	private PlateauPrincipal plateauP;
	//private PlateauSub plateauS;
	private Joueur j1;
	//private Case x;
	
	//private Joueur j2;
	//private Case o;
	
	private Joueur ia;
	
	private Scanner sc;
	
	//Valeur qui sera donner a chaque case / plateau
	private Valeur val;
	
	//Constructeur
	
	//Constructeur utilise pour le JVJ
	public JeuBis() {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();

		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//Joueur j2, joue en deuxieme, avec le sylbole "O"
		//j2 = new Joueur(false,1);
		
		sc = new Scanner(System.in);
	}
	
	//Constructeur utilise pour le jouer contre l'IA
	public JeuBis(int niveau) {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();

		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//Joueur j2, joue en deuxieme, avec le sylbole "O"
		//j2 = new Joueur(false, 1);
		ia = new Joueur(false, 1);
		
		//Initialise la valeur correspondant au niveau de jeu
		val = new Valeur(niveau);
		
		sc = new Scanner(System.in);
	}
	
	//Methodes
	
	/**
	 * 
	 */
	public void joueurVersusJoueur() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		int choixZone = choix();
		int choixCase = choixZone;
		boolean choixC = false;
		boolean choixZ = false;
		
		//Tant que le plateau principal est jouable, la partie n'est pas terminee
		while(!plateauP.verifZone() || !plateauP.verifZoneRemplie()) {

			//Verifie si la prochaine Zone, est une zone libre, donc jouable
			if( choixZ = zoneLibre(choixCase))
				choixZone = choixCase;
			
			//Si le choix de la zone n'est pas bonne, alors demande a l'utilisateur de choisir la zone
			while(!choixZ) {
				affichageChoixZone();
				//Demande a l'utilisateur de choisir la zone dans lequel il veut jouer
				choixZone = choix();
				//Verifie si la Zone choisie est libre, donc jouable
				choixZ = zoneLibre(choixZone);
			}
			choixZ = false;
			
			//Si le choix de la case n'est pas bonne, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				affichageZone(choixZone);
				
				// Demande a l'utilisateur de choisir la case dans lequel il veut jouer
				choixCase = choix();
				
				//Verifie que la case est vide
				if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
					choixC = true;
				}
				//Case deja remplie
				else
					choixC = false;
			}
			choixC = false;
			
			//Tour du joueur 1
			if(j1.tour) {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				//System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j1.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				
				// Affectation d'une valeur a la caseAlliee
				val.caseAdversePresente(j1.symbole, plateauP.getPlateau().get(choixZone).getCase(choixCase));
				System.out.println(val);
				
				//Desactive le tour du joueur 1
				j1.tour = false;
				System.out.println("Tour de O\n");
			}
			
			//Tour du joueur 2
			else {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				//System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j2.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				
				// Affectation d'une valeur a la caseAdverse
				val.caseAllieePresente(ia.symbole, plateauP.getPlateau().get(choixZone).getCase(choixCase));
				System.out.println(val);
				
				//Active le tour du joueur 1
				j1.tour = true;
				System.out.println("Tour de X\n");
			}
				
		}
	}
	
	/**
	 * Methode demandant a l'utilisateur de choisir la prochaine zone/case dans lequel il souhaite jouer
	 * 
	 * @return le numero de la zone/case que l'utilisateur a choisit
	 */
	private int choix() {
		int choix = -2;
		boolean loop = true;
		while(loop) {
			choix = sc.nextInt()-1;
			if(choix > -1 && choix < 9)
				return choix;
			else
				System.err.println("\nValeur invalide, veuillez choisir entre 1 et 9\n");
		}
		return choix;
	}
	
	/**
	 * Methode verifiant si une zone est libre
	 * 
	 * @param choixZone la zone devant etre verifiee
	 * @return true si la zone est libre, false sinon
	 */
	private boolean zoneLibre(int choixZone) {
		if( !plateauP.getPlateau().get(choixZone).verifZone() || plateauP.getPlateau().get(choixZone).verifZoneRemplie()) 
			return true;
		else
			return false;
	}
	
	/**
	 * Methode affichant le plateau principal 
	 */
	public void affichageChoixZone() {
		//Affichage du plateau de jeu complet
		System.out.println(plateauP.toString());
		//Instructions
		System.out.println("Veuillez choisir la zone sur lequel vous voulez jouer (1-9) : \n");
	}
	
	/**
	 * Methode affichant la zone
	 * 
	 * @param choix : la zone que l'on veut afficher
	 */
	public void affichageZone(int choix) {
		int affiche = choix + 1;
		//Affichage du plateau de jeu complet
		System.out.println(plateauP.toString());
		//Numero de la zone affichee
		System.out.println("\nZone "+affiche+"\n");
		System.out.println(plateauP.getPlateau().get(choix).affiche());
		System.out.println("Veuillez choisir la case sur lequel vous voulez jouer (1-9) : \n");
	}
	
}