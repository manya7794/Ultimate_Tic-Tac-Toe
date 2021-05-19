package Projet_IA;

public class Minimax {
	
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
			PlateauPrincipal platClone = new PlateauPrincipal(platP);
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(platSubClone.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids de la zone
					poids = max(platP, i, profondeur-1, symboleJoueur);
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
	
	//Reprendre en partie le first min
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
			PlateauPrincipal platClone = new PlateauPrincipal(platP);
			//Recuperation de la zone
			PlateauSub platSubClone=platClone.getPlateau().get(zone); 
			//Verifier que la case n'est pas deja remplie
			if(platSubClone.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				platSubClone.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids de la zone
					poidsFinal = max(platP, i, profondeur-1, symboleJoueur);
				}
				
				//Verifier valeur
				int poidsZone=platSubClone.getValeur().getPoids();
				if(poidsZone>poidsFinal) {
					poidsFinal=poidsZone;
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return poidsFinal;
	}
}