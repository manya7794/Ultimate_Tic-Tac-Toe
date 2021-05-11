package Projet_IA;

public class TestPlateauSub {

	public static void main(String[] args) {
		PlateauSub plat = new PlateauSub();
		for(int i=0; i<9; i++) {
			Case c = new Case();
			plat.getPlateau().add(c);
		}
		System.out.println(plat.affiche());
	}

}
