package Projet_IA;

import java.util.Scanner;

public class Jeu {
	
	//Attributs
	private PlateauPrincipal plateauP;
	//private PlateauSub plateauS;
	private Joueur j1;
	//private Case x;
	
	private Joueur j2;
	//private Case o;
	
	private Scanner sc;
	
	//Constructeur
	public Jeu() {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();
		//Petit plateau contenant les 9 cases
		//plateauS = new PlateauSub();
		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//Joueur j2, joue en deuxieme, avec le sylbole "O"
		j2 = new Joueur(false,1);
		
		//x = new Case();
		//x.addSymbole(-1);
		
	//	o = new Case();
	//	o.addSymbole(1);
		
		sc = new Scanner(System.in);
	}
	
	//Methodes
	
	/**
	 * 
	 */
	public void joueurVersusJoueur() {
		affichageChoixZone();
		System.out.println("\nTour de X\n");
		int choixZone = sc.nextInt()-1;
		int choixCase = choixZone;
		boolean choixC = false;
		boolean choixZ = false;
		//Tant que le plateau principal est jouable, la partie n'est pas terminee
		while(!plateauP.verifZone() || !plateauP.verifZoneRemplie()) {

			//Verifie si la prochaine Zone, est une zone libre, donc jouable
			if( !plateauP.getPlateau().get(choixCase).verifZone() || plateauP.getPlateau().get(choixCase).verifZoneRemplie()) {
				choixZone = choixCase;
				choixZ = true;
			}
			else {
				choixZ = false;
			}
			
			while(!choixZ) {
				affichageChoixZone();
				choixZone = sc.nextInt()-1;
				//Verifie si la Zone choisie est libre, donc jouable
				if( !plateauP.getPlateau().get(choixZone).verifZone() || plateauP.getPlateau().get(choixZone).verifZoneRemplie()) {
					choixZ = true;
				}
				else {
					choixZ = false;
				}
			}
			choixZ = false;
			
			while(!choixC) {
				affichageZone(choixZone);
				choixCase = sc.nextInt()-1;
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
				System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j1.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur 1
				j1.tour = false;
				System.out.println("\nTour de O\n");
			}
			
			//Tour du joueur 2
			else {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j2.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				//Active le tour du joueur 1
				j1.tour = true;
				System.out.println("\nTour de X\n");
			}
			
			
			
		}
	}
	
	/**
	 * Methode affichant le plateau principal 
	 */
	public void affichageChoixZone() {
		//Affichage du plateau de jeu complet
		System.out.println(plateauP.toString());
		//Instructions
		System.out.println("\nVeuillez choisir la zone sur lequel vous voulez jouer (1-9) : \n");
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
		System.out.println("\nVeuillez choisir la case sur lequel vous voulez jouer (1-9) : \n");
	}
	
	
}
