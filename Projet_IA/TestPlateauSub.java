package Projet_IA;

public class TestPlateauSub {

	public static void main(String[] args) {
		PlateauSub plat = new PlateauSub(1);
		for(int i=0; i<9; i++) {
			Case c = new Case(i);
			plat.getPlateau().add(c);
		}
		System.out.println(plat.affiche());
		//plat.setCase(2, -1);
		plat.getCase(2).setCross();
		System.out.println(plat.affiche());
		plat.getCase(3).setCircle();
		System.out.println(plat.affiche());
		
		System.out.println(plat.getCase(2).toString());
		System.out.println(plat.getCase(3).toString());
	}

}
