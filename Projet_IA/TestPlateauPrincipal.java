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
	}

}
