package Projet_IA;

public class TestPlateauPrincipal {

	public static void main(String[] args) {
		PlateauPrincipal plat = new PlateauPrincipal();
		for(int i=0; i<9;i++) {
			PlateauSub platSub = new PlateauSub();
			for(int j=0; j<9; j++) {
				Case c = new Case();
				platSub.getPlateau().add(c);
			}
			plat.plateau.add(platSub);
		}
		System.out.println(plat.toString());
		
		//Ajout de symbole
		plat.getPlateau().get(2).getCase(1).setCross();
		plat.getPlateau().get(2).getCase(2).setCross();
		plat.getPlateau().get(7).getCase(7).setCircle();
		System.out.println(plat.toString());
		System.out.println(plat.getPlateau().get(7).affiche());
	}

}
