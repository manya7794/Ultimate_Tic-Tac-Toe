package Projet_IA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {
	
	//Attributs
	private PlateauPrincipal plateauP;
	
	private Joueur j1;
	
	private Joueur ia;
	
	private Minimax minimax;
	
	private AlphaBeta alphabeta;
	
	private int niveau;
	
	private Scanner sc;
	
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
		plateauP = new PlateauPrincipal(niveau);

		//Joueur j1 commence la partie, avec le symbole "X"
		j1 = new Joueur(true, -1);
		//IA, joue en deuxieme, avec le sylbole "O"
		ia = new Joueur(false,1);
		
		this.niveau=niveau;
		//La profondeur de recherche du minimax depend du niveau
		
		//Niveau facile
		if(niveau == 1) 
			minimax = new Minimax(1);
		else if(niveau == 2) {
			minimax = new Minimax(4);
			alphabeta = new AlphaBeta(4);
		}
			
		else {
			minimax = new Minimax(8);
			alphabeta = new AlphaBeta(8);
		}
			
		
		//Initialise la valeur correspondant au niveau de jeu
		//val = new Valeur(niveau);
		
		sc = new Scanner(System.in);
	}
	
	//Methodes
	
	/**
	 * Methode lancant la partie contre un deuxieme joueur
	 */
	public void joueurVersusJoueur() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case par rapport a la zone de depart
		int choixCase = choixZone;
		//Booleen servent a la boucle pour choisir une case / une zone
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
				//Affecte la croix a la zone et a la case choisit par le joueur 1
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur 1
				j1.setTour(false);
				System.out.println("Tour de O\n");
			}
			
			//Tour du joueur 2
			else {
				//Affecte le cercle a la zone et a la case choisit par le joueur 2
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				//Active le tour du joueur 1
				j1.setTour(true);
				System.out.println("Tour de X\n");
			}
				
		}
	}
	
	/**
	 * Methode lancant la partie contre l'IA
	 */
/*	public void joueurVersusIA() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case par rapport a la zone de depart
		int choixCase = choixZone;
		//Booleen servent a la boucle pour choisir une case / une zone
		boolean choixC = false;
		boolean choixZ = false;
		//Booleen activant l'elagage alphaBeta si l'ordinateur l'utilise
		boolean activeAlphaBeta=false;
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
					//Verifie si la Zone choisie par l'IA est libre, donc jouable
					choixZ = zoneLibre(choixZone);
				}
			}
			choixZ = false;

			//Si le choix de la case n'est pas bonne, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				//Le joueur choisit la case
				if(j1.getTour()) {
					affichageZone(choixZone);
					
					//Demande a l'utilisateur de choisir la case dans lequel il veut jouer
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
					
					//IA de niveau 1
					if(niveau==1) {
						//L'IA choisit une case en utilisant l'algorithme minimax
						choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
						//Verifie que la case est vide
						if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
							choixC = true;
						}
						//Case deja remplie
						else
							choixC = false;
					}
					
					//IA de niveau 2
					if(niveau==2) {

					}
					
					//IA de niveau 3
					else {
						//Verification que pour chaque zone 2 cases sont moins cochees	
						if(!activeAlphaBeta) {
							//Verification de chaque zone
							for(PlateauSub platS : plateauP.getPlateau()) {
								//Nombre de cases cochees par zone
								int nbCasesCochees=0;
								//Verification de la case
								for(Case c : platS.getPlateau()) {
									if(c.getContenu()!=0) {
										nbCasesCochees+=1;
									}
									if(nbCasesCochees>=2) {
										activeAlphaBeta=true;
									}
								}
							}
						}
						
						//Recherche MiniMax si l'elagage n'est pas active
						if(!activeAlphaBeta) {
							//L'IA choisit une case en utilisant l'algorithme minimax
							choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
							//Verifie que la case est vide
							if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
								choixC = true;
							}
							//Case deja remplie
							else
								choixC = false;
						}
						//Elagage active
						else {
							// L'IA choisit une case en utilisant l'elagage
							choixCase = alphabeta.firstBeta(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
							//Verifie que la case est vide
							if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
								choixC = true;
							}
							//Case deja remplie
							else
								choixC = false;
						}
					}
				}
			}
			choixC = false;
			
			//Tour du joueur 1
			if(j1.getTour()) {
				//Affecte la croix a la zone et a la case choisit par le joueur 1
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur
				j1.setTour(false);
			}
			
			//Tour de l'IA
			else {
				//Choisit la case en fonction de l'algorithme minimax 
				choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
				//Affectation de la case par l'IA
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				
				System.out.println("L'IA a joue sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
				//Active le tour du joueur 
				j1.setTour(true);
				//System.out.println("Tour de X\n");
				System.out.println("\nC'est a votre tour de jouer (X : Vous, O : IA)\n");
			}
				
		}
	}
	*/
	
	public void joueurVersusIA() {
		
		switch(niveau) {
		case 1:
			iaFacile();
			break;
		case 2:
			iaInter();
			break;
		case 3:
			iaDifficile();
			break;
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
		//Tant que le choix de l'utilisateur n'est pas valide
		while(!sortie) {
			//Recupere le choix entre par l'utilisateur
			int choixTmp=recupChoix();
			//Verifie qu'il est bien valide
			if(choixTmp!=-2) {
				choix=choixTmp;
				sortie=true;
			}
		}
		//Retourne le choix de l'utilisateur
		return choix;
	}
	
	/**
	 * Methode gerant les exceptions du choix entre par l'utilisateur
	 * 
	 * @return le choix de l'utilisateur
	 */
	private int recupChoix() {
		boolean sortie=false;
		String choix = null;
		
		int choixTmp=0;
		//Tant que le choix n'est pas bon
		while(!sortie) {
			
			//Recupere le choix de l'utilisateur
			try {
				choix=sc.nextLine();
			}catch (InputMismatchException exception) {
				System.out.println(choix+" n'est pas une entree valide");
			}

			//Verification qu'il s'agit bien d'un nombre
			boolean isNumeric =  choix.matches("[+-]?\\d*(\\.\\d+)?");
			if(isNumeric) {
				
				//Tente de recuperer l'entier
				try {
					choixTmp=(Integer.valueOf(choix)-1);

					//Verifie que l'entier est compris entre 0 et 8 (donc 1 et 9 pour l'utilisateur)
					if((choixTmp>-1)&&(choixTmp<9)) {
						sortie=true;
					}
					else {
						System.out.println((choixTmp+1)+" n'est pas une valeur valide.\n");
						System.out.println("Veuillez choisir une valeur entre 1 et 9 svp.\n");
					}
				}	catch(NumberFormatException exception){
						System.out.println(choix+" n'est pas une entree valide");
						return -2;
					}
			}
			else {
				System.out.println(choix+" n'est pas une entree valide.\n");
				System.out.println("Veuillez choisir une valeur entre 1 et 9 svp.\n");
			}
		}
		//Retourne le choix de l'utilisateur
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
		//Affiche la zone
		System.out.println(plateauP.getPlateau().get(choix).affiche());
		System.out.println("Veuillez choisir la case sur lequel vous voulez jouer (1-9) : \n");
	}
	
	/**
	 * Methode lancant une partie en mode Joueur vs IA de niveau facile
	 */
	public void iaFacile() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case par rapport a la zone de depart
		int choixCase = choixZone;
		//Booleen servent a la boucle pour choisir une case / une zone
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
					//Verifie si la Zone choisie par l'IA est libre, donc jouable
					choixZ = zoneLibre(choixZone);
				}
			}
			choixZ = false;

			//Si le choix de la case n'est pas bonne, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				//Le joueur choisit la case
				if(j1.getTour()) {
					affichageZone(choixZone);
					
					//Demande a l'utilisateur de choisir la case dans lequel il veut jouer
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
					//L'IA choisit une case en utilisant l'algorithme minimax
					choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
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
				//Affecte la croix a la zone et a la case choisit par le joueur 1
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur
				j1.setTour(false);
				//System.out.println("Tour de l'IA");
				//System.out.println(plateauP.toString());
			}
			
			//Tour de l'IA
			else {
				//Choisit la case en fonction de l'algorithme minimax 
				choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
				//Affectation de la case par l'IA
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				
				System.out.println("L'IA a joue sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
				//Active le tour du joueur 
				j1.setTour(true);
				//System.out.println("Tour de X\n");
				System.out.println("C'est a votre tour de jouer\n");
			}
			
		}
	}
	
	/**
	 * Methode lancant une partie en mode Joueur vs IA de niveau intermediaire
	 */
	public void iaInter() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case par rapport a la zone de depart
		int choixCase = choixZone;
		//Booleen servent a la boucle pour choisir une case / une zone
		boolean choixC = false;
		boolean choixZ = false;
		//Booleen activant l'elagage alphaBeta si l'ordinateur l'utilise
		boolean activeAlphaBeta=false;
		
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
					//Verifie si la Zone choisie par l'IA est libre, donc jouable
					choixZ = zoneLibre(choixZone);
				}
			}
			choixZ = false;

			//Si le choix de la case n'est pas bon, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				//Le joueur choisit la case
				if(j1.getTour()) {
					affichageZone(choixZone);
					
					//Demande a l'utilisateur de choisir la case dans lequel il veut jouer
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
					
					//Verification que pour chaque zone 2 cases sont moins cochees	
					if(!activeAlphaBeta) {
						//Verification de chaque zone
						//Nombre de zone validant le prerequis
						int nbZonesValidees=0;
						for(PlateauSub platS : plateauP.getPlateau()) {
							//Nombre de cases cochees par zone
							int nbCasesCochees=0;
							//Verification de la case
							for(Case c : platS.getPlateau()) {
								if(c.getContenu()!=0) {
									nbCasesCochees+=1;
								}
								if(nbCasesCochees>=2) {
									nbZonesValidees+=1;
								}
							}
						}
						//Active l'elagage si toutes les zones correspondent au pre-requis
						if(nbZonesValidees==9) {
							activeAlphaBeta=true;
						}
					}
					
					//Elagage non actif
					if(!activeAlphaBeta) {
						//L'IA choisit une case en utilisant l'algorithme minimax
						choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
						//Verifie que la case est vide
						if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
							choixC = true;
						}
						//Case deja remplie
						else {
							choixC = false;
						}
					}
					//Elagage actif
					else {
						// L'IA choisit une case en utilisant l'elagage
						choixCase = alphabeta.firstBeta(plateauP, choixZone, alphabeta.getProfondeur(), ia.symbole);
						//Verifie que la case est vide
						if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
							choixC = true;
						}
						//Case deja remplie
						else
							choixC = false;
					}
				}
			}
			choixC = false;
			
			
			
			//Tour du joueur 1
			if(j1.getTour()) {
				//Affecte la croix a la zone et a la case choisit par le joueur 1
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur
				j1.setTour(false);
				//System.out.println("Tour de l'IA");
				//System.out.println(plateauP.toString());
			}
			
			//Tour de l'IA
			else {
				//Choisit la case en fonction de l'algorithme minimax 
				choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
				//Affectation de la case par l'IA
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
				
				System.out.println("L'IA a joue sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
				//Active le tour du joueur 
				j1.setTour(true);
				//System.out.println("Tour de X\n");
				System.out.println("C'est a votre tour de jouer\n");
			}
			
		}
	}
	
	/**
	 * Methode lancant une partie en mode Joueur vs IA de niveau difficile
	 */
	public void iaDifficile() {
		System.out.println("Tour de X\n");
		affichageChoixZone();
		//Choix de la zone de depart
		int choixZone = choix();
		//Initialisation de la case par rapport a la zone de depart
		int choixCase = choixZone;
		//Booleen servent a la boucle pour choisir une case / une zone
		boolean choixC = false;
		boolean choixZ = false;
		//Booleen activant l'elagage alphaBeta si l'ordinateur l'utilise
		boolean activeAlphaBeta=false;
		
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
					//Verifie si la Zone choisie par l'IA est libre, donc jouable
					choixZ = zoneLibre(choixZone);
				}
			}
			choixZ = false;

			//Si le choix de la case n'est pas bon, alors demande a l'utilisateur de choisir la case
			while(!choixC) {
				//Le joueur choisit la case
				if(j1.getTour()) {
					affichageZone(choixZone);
					
					//Demande a l'utilisateur de choisir la case dans lequel il veut jouer
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
					
					//Verification que pour chaque zone 2 cases sont moins cochees	
					if(!activeAlphaBeta) {
						//Verification de chaque zone
						//Nombre de zone validant le prerequis
						int nbZonesValidees=0;
						for(PlateauSub platS : plateauP.getPlateau()) {
							//Nombre de cases cochees par zone
							int nbCasesCochees=0;
							//Verification de la case
							for(Case c : platS.getPlateau()) {
								if(c.getContenu()!=0) {
									nbCasesCochees+=1;
								}
								if(nbCasesCochees>=2) {
									nbZonesValidees+=1;
								}
							}
						}
						//Active l'elagage si toutes les zones correspondent au pre-requis
						if(nbZonesValidees==9) {
							activeAlphaBeta=true;
						}
					}
					
					//Elagage non actif
					if(!activeAlphaBeta) {
						//L'IA choisit une case en utilisant l'algorithme minimax
						choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
						//Verifie que la case est vide
						if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
							choixC = true;
						}
						//Case deja remplie
						else {
							choixC = false;
						}
					}
					//Elagage actif
					else {
						// L'IA choisit une case en utilisant l'elagage
						choixCase = alphabeta.firstBeta(plateauP, choixZone, alphabeta.getProfondeur(), ia.symbole);
						//Verifie que la case est vide
						if(plateauP.getPlateau().get(choixZone).getCase(choixCase).verifContenu()) {
							choixC = true;
						}
						//Case deja remplie
						else
							choixC = false;
					}
				}
			}
			choixC = false;
			
			
			
			//Tour du joueur 1
			if(j1.getTour()) {
				//Affecte la croix a la zone et a la case choisit par le joueur 1
				plateauP.getPlateau().get(choixZone).getCase(choixCase).setCross();
				//Desactive le tour du joueur
				j1.setTour(false);
				//System.out.println("Tour de l'IA");
				//System.out.println(plateauP.toString());
			}
			
			//Tour de l'IA
			else {
				if(!activeAlphaBeta) {
					//Verification de chaque zone
					//Nombre de zone validant le prerequis
					int nbZonesValidees=0;
					for(PlateauSub platS : plateauP.getPlateau()) {
						//Nombre de cases cochees par zone
						int nbCasesCochees=0;
						//Verification de la case
						for(Case c : platS.getPlateau()) {
							if(c.getContenu()!=0) {
								nbCasesCochees+=1;
							}
							if(nbCasesCochees>=2) {
								nbZonesValidees+=1;
							}
						}
					}
					//Active l'elagage si toutes les zones correspondent au pre-requis
					if(nbZonesValidees==9) {
						activeAlphaBeta=true;
					}
				}
				
				//Elagage non actif
				if(!activeAlphaBeta) {
					//Choisit la case en fonction de l'algorithme alphabeta
					choixCase = alphabeta.firstBeta(plateauP, choixZone, alphabeta.getProfondeur(), ia.symbole);
					//Affectation de la case par l'IA
					plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
					
					System.out.println("L'IA a joue sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
					//Active le tour du joueur 
					j1.setTour(true);
					//System.out.println("Tour de X\n");
					System.out.println("C'est a votre tour de jouer\n");
				}
				else {
					
					//Choisit la case en fonction de l'algorithme minimax 
					choixCase = minimax.firstMin(plateauP, choixZone, minimax.getProfondeur(), ia.symbole);
					//Affectation de la case par l'IA
					plateauP.getPlateau().get(choixZone).getCase(choixCase).setCircle();
					
					System.out.println("L'IA a joue sur la case : "+(choixCase+1)+" de la zone : "+(choixZone+1));
					//Active le tour du joueur 
					j1.setTour(true);
					//System.out.println("Tour de X\n");
					System.out.println("C'est a votre tour de jouer\n");
				}
			}
			
		}
	}
}