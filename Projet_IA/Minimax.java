package Projet_IA;

public class Minimax {
	
	private int profondeur;
	
	public Minimax(int profondeur) {
		this.profondeur = profondeur;
	}
	
	/**
	 * Methode appliquant le min de depart de l'algorithme minimax
	 * @param platP Plateau de jeu a etudier
	 * @param zone Numero de la zone a etudier
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Le numero de la case a cocher
	 */
	public int firstMin(PlateauPrincipal platP, int zone, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poids=500;
		//Case final a cocher
		int caseFinale=-1;
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//PlateauPrincipal platClone = new PlateauPrincipal(platP);
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(platSubClone.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids de la zone
					poids = max(platClone, i, profondeur-1, symboleJoueur);
				}
				
				//Verifier valeur
				int poidsZone=platSubClone.getValeur().getPoids();
				if(poidsZone<poids) {
					poids=poidsZone;
					caseFinale=i;
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return caseFinale;
	}
	
	/**
	 * Methode renvoyant le plus grand poids trouve pour la zone entree en argument
	 * @param platP Plateau de jeu a etudier
	 * @param zone Numero de la zone a etudier
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Le poids max trouve
	 */
	public int max(PlateauPrincipal platP, int zone, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poidsFinal=-500;
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//PlateauPrincipal platClone = new PlateauPrincipal(platP);
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone);
			//Verifier que la case n'est pas deja remplie
			if(platSubClone.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids min de la zone
					int poidsTmp = min(platClone, i, profondeur-1, symboleJoueur);
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
					if(poidsZone>poidsFinal) {
						poidsFinal=poidsZone;
					}
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return poidsFinal;
	}
	
	/**
	 * Methode renvoyant le plus petit poids trouve pour la zone entree en argument
	 * @param platP Plateau de jeu a etudier
	 * @param zone Numero de la zone a etudier
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Le poids min trouve
	 */
	public int min(PlateauPrincipal platP, int zone, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poidsFinal=500;
		//On parcourt chaque case de la zone
		for(int i=0; i<9;i++) {
			//Creation d'un plateau clone pour effectuer la recherche
			PlateauPrincipal platClone = platP.clone();
			//PlateauPrincipal platClone = new PlateauPrincipal(platP);
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone);
			//Verifier que la case n'est pas deja remplie
			if(platSubClone.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids max de la zone
					int poidsTmp = max(platClone, i, profondeur-1, symboleJoueur);
					//Comparaison de ce poids au poids final actuel
					if(poidsTmp<poidsFinal) {
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
					//Cas ou le poids de la zone est inferieur au poids final en memoire
					if(poidsZone<poidsFinal) {
						poidsFinal=poidsZone;
					}
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return poidsFinal;
	}
}