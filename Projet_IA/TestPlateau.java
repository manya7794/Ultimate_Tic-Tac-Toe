package Projet_IA;

public class TestPlateau {

	public static void main(String[] args) {
		Plateau plat = new Plateau();
		System.out.println(plat.toString());
		
		PlateauSub plateau = new PlateauSub(1);
		System.out.println(plateau.affiche());
	}

}
