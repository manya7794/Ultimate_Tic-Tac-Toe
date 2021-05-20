package Projet_IA;

public class AlphaBeta {
	
	//Attributs
	private int profondeur;
	private int valeurZone=0;
	
	//Constructeur
	
	/**
	 * Constructeur de la classe alphaBeta
	 * @param profondeur Nombre de recherches restantes
	 */
	public AlphaBeta(int profondeur) {
		this.profondeur=profondeur;
	}
	
	/**
	 * Methode appliquant l'elagage beta de depart de l'elagage alpha-beta
	 * 
	 * @param platP Plateau de jeu principal
	 * @param zone Numero de la zone a etudier
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Numero de la case a cocher
	 */
	public int firstBeta(PlateauPrincipal platP, int zone, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poidsFinal=500;
		//Case finale a cocher
		int caseFinale=-1;
		//Verification que la valeur n'est pas inferieure au poids actuel
		boolean sortie=false;
		
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(sortie) {
				if(platSubClone.getPlateau().get(i).verifContenu()) {
					//Simuler cochage
					platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
					
					//Verification de la profondeur
					if(profondeur>0) {
						//Recuperation du poids min de la zone
						//Changement de signe
						int poidsTmp = 0;
						if(symboleJoueur==-1) {
							poidsTmp = alpha(platClone, i,0, i, profondeur-1, 1);
						}
						if(symboleJoueur==1) {
							poidsTmp = alpha(platClone, i,0, i, profondeur-1, -1);
						}
						//Comparaison de ce poids au poids final actuel
						if(poidsTmp>poidsFinal) {
							poidsFinal=poidsTmp;
						}
					}
					//Cas ou il s'agit de la derniere profondeur a analyser
					else {
						//Verifier valeur
						//Appel de la fonction calculant le poids de la zone
						platSubClone.majValeur(symboleJoueur, platClone);	
						
						//Recuperation du poids
						int poidsZone=platSubClone.getValeur().getPoids();
						//Cas ou le poids de la zone est superieur au poids final en memoire
						if(poidsZone<poidsFinal) {
							poidsFinal=poidsZone;
						}
						//Cas ou il ne s'agit pas de la premiere branche exploree
						if(i>0) {
							//Activation de l'elagage
							if(poidsZone>poidsFinal) {
								//Active la sortie pour ne pas comparer les autres valeurs
								sortie=true;
							}
						}
					}
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return caseFinale;
	}
	
	/**
	 * Methode appliquant l'elagage alpha sur la zone de jeu
	 * @param platP Plateau de jeu principal
	 * @param zone Numero de la zone a etudier
	 * @param brancheSup Numero de la branche superieure
	 * @param branche Numero de la branche etudiee
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Le poids max trouve suite a l'elagage
	 */
	public int alpha(PlateauPrincipal platP, int zone, int brancheSup, int branche, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poidsFinal=-500;
		//Verification que la valeur n'est pas inferieure au poids actuel
		boolean sortie=false;
		
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(sortie) {
				if(platSubClone.getPlateau().get(i).verifContenu()) {
					//Simuler cochage
					platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
					
					//Verification de la profondeur
					if(profondeur>0) {
						//Recuperer le poids max de la zone
						//Changement de symbole joueur
						int poidsTmp=0;
						if(symboleJoueur==-1) {
							poidsTmp = beta(platClone, i, branche, branche+i, profondeur-1, 1);
						}
						if(symboleJoueur==1) {
							poidsTmp = beta(platClone, i, branche, branche+i, profondeur-1, -1);
						}
						//Comparaison de ce poids au poids final actuel
						if(poidsTmp>poidsFinal) {
							poidsFinal=poidsTmp;
						}
					}
					
					//Cas ou il s'agit de la derniere profondeur a analyser
					else {
						//Verifier valeur
						//Appel de la fonction calculant le poids de la zone
						platSubClone.majValeur(symboleJoueur, platClone);	
						
						//Recuperation du poids
						int poidsZone=platSubClone.getValeur().getPoids();
						
						//Comparaison de toutes les valeurs s'il s'agit de la première branche
						if((branche==0)&(profondeur==0)) {
							//Cas ou le poids de la zone est superieur au poids final en memoire
							if(poidsZone>poidsFinal) {
								poidsFinal=poidsZone;
							}
						}

						//Cas ou il ne s'agit pas de la premiere branche exploree
						if(branche>0) {
							//Comparaison des valeurs
							if(poidsZone>poidsFinal) {
								poidsFinal=poidsZone;
							}
							//Valeur inferieure a celle en memoire
							//Activation de l'elagage
							if(poidsZone<poidsFinal) {
								//Active la sortie pour ne pas comparer les autres valeurs
								sortie=true;
							}
						}
					}
				}
			}
		}
		//Retourne le poids de la case ayant la plus haute valeur
		return poidsFinal;
	}
	
	/**
	 * Methode apppliquant l'élagage beta sur la zone de jeu
	 * 
	 * @param platP Plateau de jeu principal sur lequel se déroule la partie
	 * @param zone Numero de la zone a etudier
	 * @param brancheSup Numero de la branche superieure
	 * @param branche Numero de la branche etudiee
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Valeur de la zone apres application de l'elagage
	 */
	public int beta(PlateauPrincipal platP, int zone, int brancheSup, int branche, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poidsFinal=500;
		//Verification que la valeur n'est pas inferieure au poids actuel
		boolean sortie=false;
		
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(sortie) {
				if(platSubClone.getPlateau().get(i).verifContenu()) {
					//Simuler cochage
					platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
					
					//Verification de la profondeur
					if(profondeur>0) {
						//Recuperer le poids min de la zone
						int poidsTmp =0;
						//Changement du symbole joueur
						if(symboleJoueur==-1) {
							poidsTmp = alpha(platClone, i, branche, branche+i, profondeur-1, 1);
						}
						if(symboleJoueur==1) {
							poidsTmp = alpha(platClone, i, branche, branche+i, profondeur-1, -1);
						}
						//Comparaison de ce poids au poids final actuel
						if(poidsTmp>poidsFinal) {
							poidsFinal=poidsTmp;
						}
					}
					//Cas ou il s'agit de la derniere profondeur a analyser
					else {
						//Verifier valeur
						//Appel de la fonction calculant le poids de la zone
						platSubClone.majValeur(symboleJoueur, platClone);	
						
						//Recuperation du poids
						int poidsZone=platSubClone.getValeur().getPoids();
						
						//Comparaison de toutes les valeurs s'il s'agit de la première branche
						if((branche==0)&(profondeur==0)) {
							//Cas ou le poids de la zone est inferieur au poids final en memoire
							if(poidsZone<poidsFinal) {
								poidsFinal=poidsZone;
							}
						}

						//Cas ou il ne s'agit pas de la premiere branche exploree
						if(branche>0) {
							//Comparaison des valeurs
							if(poidsZone<poidsFinal) {
								poidsFinal=poidsZone;
							}
							//Valeur superieure a celle en memoire
							//Activation de l'elagage
							if(poidsZone>poidsFinal) {
								//Active la sortie pour ne pas comparer les autres valeurs
								sortie=true;
							}
						}
					}
				}
			}
		}
		//Retourne le poids de la case ayant la plus faible valeur
		return poidsFinal;
	}
	
	/**
	 * Methode renvoyant la profondeur du minimax
	 * @return la profondeur
	 */
	public int getProfondeur() {
		return profondeur;
	}
	
	/**
	 * Methode renvoyant la valeur de la zone
	 * @return la valeur de la zone
	 */
	public int getValeurZone() {
		return valeurZone;
	}
}
