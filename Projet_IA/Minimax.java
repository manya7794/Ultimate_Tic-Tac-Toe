package Projet_IA;

public class Minimax {
	
	/**
	 * Methode appliquant le min de depart de l'algorithme minimax
	 * @param platP
	 * @param plat
	 * @param profondeur
	 * @param symboleJoueur
	 * @return
	 */
	public int firstMin(PlateauPrincipal platP, PlateauSub plat, int profondeur, int symboleJoueur) {
		//Poids de depart a comparer
		int poids=500;
		//Case final a cocher
		int caseFinale;
		//On parcourt chaque case de la zone
		for(int i=0; i<plat.getPlateau().size();i++) {
			//Verifier que la case n'est pas deja remplie
			
			if(plat.getPlateau().get(i).verifContenu()) {
				//Simuler cochage
				plat.getPlateau().get(i).setSymbole(symboleJoueur);
				
				//Verification de la profondeur
				if(profondeur>0) {
					//Recuperer le poids de la zone
					poids = max(platP, platP.getPlateau().get(i), profondeur-1, symboleJoueur);
				}
				
				//Verifier valeur
				int poidsZone=plat.getValeur().getPoids();
				if(poidsZone<poids) {
					poids=poidsZone;
					caseFinale=i;
				}
			}
		}
		//Retourne la case ayant la plus faible valeur
		return caseFinale;
	}
	
	public void max(PlateauPrincipal platP, PlateauSub plat, int profondeur, int symboleJoueur) {
		
	}
}
