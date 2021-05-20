package Projet_IA;

public class AlphaBeta {
	
	/**
	 * Methode appliquant l'elagage alpha sur la zone de jeu
	 * @param platP Plateau de jeu principal
	 * @param zone Numero de la zone a etudier
	 * @param branche Numero de la branche etudiee
	 * @param profondeur Nombre de recherches restantes
	 * @param symboleJoueur Symbole du joueur a cocher dans la case
	 * @return Le poids max trouve suite a l'elagage
	 */
	public int alpha(PlateauPrincipal platP, int zone, int branche, int profondeur, int symboleJoueur) {
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
						//Recuperer le poids min de la zone
						int poidsTmp = beta(platClone, i, branche, profondeur-1, symboleJoueur);
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
						//Cas ou il ne s'agit pas de la premiere branche exploree
						if(branche>0) {
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
		//Retourne la case ayant la plus faible valeur
		return poidsFinal;
	}
	
	public int beta(PlateauPrincipal platP, int zone, int branche, int profondeur, int symboleJoueur) {
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
						int poidsTmp = alpha(platClone, i, branche, profondeur-1, symboleJoueur);
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
						if(branche>0) {
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
		return poidsFinal;
	}
}
