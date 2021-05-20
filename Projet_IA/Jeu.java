package Projet_IA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {
	
	//Attributs
	private PlateauPrincipal plateauP;
	//private PlateauSub plateauS;
	private Joueur j1;
	//private Case x;
	
	private Joueur ia;
	//private Case o;
	
	private Minimax minimax;
	
	private Scanner sc;
	
	//Valeur qui sera donner a chaque case / plateau
	//private Valeur val;
	
	//Constructeur
	
	//Constructeur utilise pour le JVJ
	public Jeu() {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();

		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//Joueur j2, joue en deuxieme, avec le sylbole "O"
		//j2 = new Joueur(false,1);
		
		sc = new Scanner(System.in);
	}
	
	//Constructeur utilise pour le jouer contre l'IA
	public Jeu(int niveau) {
		//Grand Plateau contenant les 9 petits plateaux
		plateauP = new PlateauPrincipal();

		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//IA, joue en deuxieme, avec le sylbole "O"
		//j2 = new Joueur(false,1);
		ia = new Joueur(false,1);
		
		//La profondeur de recherche du minimax depend du niveau
		if(niveau == 1) 
			minimax = new Minimax(1);
		else if(niveau == 2) 
			minimax = new Minimax(4);
		else
			minimax = new Minimax(8);
		
		//Initialise la valeur correspondant au niveau de jeu
		//val = new Valeur(niveau);
		
		sc = new Scanner(System.in);
	}
	
	//Methodes
	
	/**
	 * 
	 */
	public void joueurVersusJoueur() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case de depart, par rapport a la zone choisit, 
		int choixCase = choixZone;
		boolean choixC = false;
		boolean choixZ = false;
		
		//Tant que le plateau principal est jouable, la partie n'est pas terminee
		while(!plateauP.verifZone() || !plateauP.verifZoneRemplie()) {

			//Verifie si la prochaine Zone, est une zone libre, donc jouable, si pas jouable choixZ = false
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
			if(j1.getTour()) {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				//System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j1.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur 1
				j1.setTour(false);
				System.out.println("Tour de O\n");
			}
			
			//Tour du joueur 2
			else {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				//System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j2.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				//Active le tour du joueur 1
				j1.setTour(true);
				System.out.println("Tour de X\n");
			}
				
		}
	}
	
	/**
	 * 
	 */
	public void joueurVersusIA() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		int choixZone = choix();
		int choixCase = choixZone;
		boolean choixC = false;
		boolean choixZ = false;
		
		//Tant que le plateau principal est jouable, la partie n'est pas terminee
		while(!plateauP.verifZone() || !plateauP.verifZoneRemplie()) {

			//Verifie si la prochaine Zone, est une zone libre, donc jouable, si pas jouable choixZ = false
			if( choixZ = zoneLibre(choixCase))
				choixZone = choixCase;
			
			//Si le choix de la zone n'est pas bonne, alors demande a l'utilisateur de choisir la zone
			while(!choixZ) {
				//Le joueur choisit la zone si c'est son tour
				if(j1.getTour()) {
					affichageChoixZone();
					//Demande a l'utilisateur de choisir la zone dans lequel il veut jouer
					choixZone = choix();
					//Verifie si la Zone choisie est libre, donc jouable
					choixZ = zoneLibre(choixZone);
				}
				//Sinon l'ia choisit la zone
				else {
					//choixZoneTmp sert pour comparer a choixZone
					int choixZoneTmp = 500;
					//Parcours les 9 zones
					for(int i = 0 ; i < 9 ; i++) {
						//Choix de la zone selon l'algorithme minimax
						choixZone = minimax.firstMin(plateauP, i, minimax.getProfondeur(), ia.symbole);
						//Compare choixZone a choixZoneTmp si plus petit alors on conserve, si identique alors on garde dans l'ordre d'arrive
						if(minimax.getValeurZone() < choixZoneTmp) {
							choixZoneTmp = minimax.getValeurZone();
							choixZone = i;
						}
					}
					choixZ = zoneLibre(choixZone);
				}
			}
			choixZ = false;

			//Si le choix de la case n'est pas bonne, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				//Le joueur choisit la case
				if(j1.getTour()) {
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
				//L'IA choisit la case
				else {
					// L'IA choisit une case en utilisant l'algorithme minimax
					choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
					System.out.println(choixCase);
					//Verifie que la case est vide
					if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
						choixC = true;
					}
					//Case deja remplie
					else
						choixC = false;
				}
			}
			choixC = false;
			
			//Tour du joueur 1
			if(j1.getTour()) {
				//Affiche la zone en cours et le choix de la case du joueur en cours
				//System.out.println("choixZ : "+choixZone+" choixC : "+ choixCase);
				//plateauP.getPlateau().get(choixZone).setCase(choixCase, j1.symbole);
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur
				j1.setTour(false);
				//System.out.println("Tour de O\n");
				System.out.println(plateauP.toString());
			}
			
			//Tour de l'IA
			else {
				//Choisit la case en fonction de l'algorithme minimax 
				choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
				//Affectation de la case par l'IA
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				
				System.out.println("L'IA a jouer sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
				//Active le tour du joueur 
				j1.setTour(true);
				//System.out.println("Tour de X\n");
				System.out.println("C'est a votre tour de jouer\n");
			}
				
		}
	}
	
	/**
	 * Methode demandant a l'utilisateur de choisir la prochaine zone/case dans lequel il souhaite jouer
	 * 
	 * @return le numero de la zone/case que l'utilisateur a choisit
	 */
	private int choix() {
		boolean sortie=false;
		int choix=0;
		while(!sortie) {
			int choixTmp=recupChoix();
			if(choixTmp!=-2) {
				choix=choixTmp;
				sortie=true;
			}
		}
		return choix;
	}

	private int recupChoix() {
		boolean sortie=false;
		String choix = null;
		
		int choixTmp=0;
		while(!sortie) {
			try {
				choix=sc.nextLine();
			}catch (InputMismatchException exception) {
				System.out.println(choix+" n'est pas une entree valide");
			}

			//Verification qu'il s'agit bien d'un nombre
			boolean isNumeric =  choix.matches("[+-]?\\d*(\\.\\d+)?");
			if(isNumeric) {
				
				try {
					choixTmp=(Integer.valueOf(choix));
					//choixTmp=(Integer.valueOf(choix)-1);
				}
				 catch(NumberFormatException exception){
					 System.out.println(choix+" n'est pas une entree valide");
					 return -2;
					}
				//Verification que le chiffre est present dans le domaine defini
				if((choixTmp>-1)&&(choixTmp<9)) {
					sortie=true;
				}
			}
			else {
				System.out.println(choix+" n'est pas une entree valide.\n");
				System.out.println("Veuillez choisir une valeur entre 1 et 9 svp.\n");
			}
		}
		return choixTmp;
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