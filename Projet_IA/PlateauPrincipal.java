package Projet_IA;

import java.util.ArrayList;

public class PlateauPrincipal extends Plateau<PlateauSub> {
	
	//public ArrayList<PlateauSub> plateau;
	
	//Constructeur
	public PlateauPrincipal() {
		plateau= new ArrayList<PlateauSub>();
		initialisation();
	}
	
	public PlateauPrincipal(int niveau) {
		plateau=new ArrayList<PlateauSub>();
		initialisation(niveau);
	}
	
	//Methodes
	
	public PlateauPrincipal clone() {
		PlateauPrincipal plateauPclone = new PlateauPrincipal();
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				plateauPclone.getPlateau().get(i).getCase(j).setSymbole(plateau.get(i).getCase(j).getContenu());
			}
		}
		return plateauPclone;
	}
	
	/**
	 * Methode ajoutant les 9 plateaux dans le plateau principal
	 */
	public void initialisation() {
		for(int i = 0 ; i < 9 ; i++) {
			PlateauSub platSub = new PlateauSub(i);
			plateau.add(platSub);
		}
	}
	
	/**
	 * Methode ajoutant les 9 plateaux dans le plateau principal
	 * dans le cas ou la partie se deroule avec une IA
	 * @param niveau
	 */
	public void initialisation(int niveau) {
		for(int i = 0 ; i < 9 ; i++) {
			PlateauSub platSub = new PlateauSub(i, niveau);
			plateau.add(platSub);
		}
	}
	
	/**
	 * Methode verifiant si un plateau n'est plus utilisable (gagne ou rempli)
	 */
	public void verifPlateau() {
		//Parcourt tous les plateaux
		for(int i = 0 ; i < 9 ; i++) {
			//Condition verifiant si le plateau est gagnante ou remplie
			if(plateau.get(i).verifZone() || plateau.get(i).verifZoneRemplie()) {
				//TODO : Regarder comment "neutraliser" la zone
			}
		}
	}
	
	/**
	 * Renvoie le plateau sous forme de String
	 */
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		tmp.append("|¯¯¯T¯¯¯T¯¯¯TT¯¯¯T¯¯¯T¯¯¯TT¯¯¯T¯¯¯T¯¯¯|\n");
		tmp.append(plateau.get(0).afficheLigne(1)+plateau.get(1).afficheLigne(1)+plateau.get(2).afficheLigne(1)+"\n");
		tmp.append(plateau.get(0).afficheLigne(2)+plateau.get(1).afficheLigne(2)+plateau.get(2).afficheLigne(2)+"\n");
		tmp.append(plateau.get(0).afficheLigne(3)+plateau.get(1).afficheLigne(3)+plateau.get(2).afficheLigne(3)+"\n");
		tmp.append("|___|___|___||___|___|___||___|___|___|\n");
		tmp.append("|¯¯¯|¯¯¯|¯¯¯||¯¯¯|¯¯¯|¯¯¯||¯¯¯|¯¯¯|¯¯¯|\n");
		tmp.append(plateau.get(3).afficheLigne(1)+plateau.get(4).afficheLigne(1)+plateau.get(5).afficheLigne(1)+"\n");
		tmp.append(plateau.get(3).afficheLigne(2)+plateau.get(4).afficheLigne(2)+plateau.get(5).afficheLigne(2)+"\n");
		tmp.append(plateau.get(3).afficheLigne(3)+plateau.get(4).afficheLigne(3)+plateau.get(5).afficheLigne(3)+"\n");
		tmp.append("|___|___|___||___|___|___||___|___|___|\n");
		tmp.append("|¯¯¯|¯¯¯|¯¯¯||¯¯¯|¯¯¯|¯¯¯||¯¯¯|¯¯¯|¯¯¯|\n");
		tmp.append(plateau.get(6).afficheLigne(1)+plateau.get(7).afficheLigne(1)+plateau.get(8).afficheLigne(1)+"\n");
		tmp.append(plateau.get(6).afficheLigne(2)+plateau.get(7).afficheLigne(2)+plateau.get(8).afficheLigne(2)+"\n");
		tmp.append(plateau.get(6).afficheLigne(3)+plateau.get(7).afficheLigne(3)+plateau.get(8).afficheLigne(3)+"\n");
		tmp.append("|___|___|___||___|___|___||___|___|___|");
		return tmp.toString();
	}
}