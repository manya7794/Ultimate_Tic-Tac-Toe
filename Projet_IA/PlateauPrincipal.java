package Projet_IA;

import java.util.ArrayList;

public class PlateauPrincipal extends Plateau<PlateauSub>{
		
	//Constructeur
	public PlateauPrincipal() {
		plateau= new ArrayList<PlateauSub>();
	}
	
	//Methodes
	/**
	 * Methode ajoutant les 9 plateaux dans le plateau principal
	 */
	public void initialisation() {
		PlateauSub platSub = new PlateauSub();
		for(int i = 0 ; i < 9 ; i++) {
			plateau.add(platSub);
		}
	}
	
	/**
	 * Methode verifiant si un plateau n'est plus utilisable (gagne ou rempli)
	 */
	public void verifPlateau() {
		//Parcours tous les plateaux
		for(int i = 0 ; i < 9 ; i++) {
			//Condition verifiant si le plateau est gagnante ou remplie
			if(plateau.get(i).verifZone() || plateau.get(i).verifZoneRemplie()) {
				//TODO : Regarder comment "neutraliser" la zone
			}
		}
	}

}
