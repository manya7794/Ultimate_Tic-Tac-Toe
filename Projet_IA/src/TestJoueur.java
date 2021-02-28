
public class TestJoueur {

	public static void main(String[] args) {
		Plateau PlateauTest= new Plateau();
		Case c1= new Case();
		System.out.print(c1.getCaseType());
		System.out.println();
		System.out.println();
		PlateauTest.getPlateau()[0][0].setCaseBateau();
		Joueur j = new Joueur(PlateauTest);
		j.Tir(0, 0);
		System.out.println(j.plateauAdverse.toString());
		System.out.println();
		System.out.println();
		System.out.println(j.toString());
	}

}
