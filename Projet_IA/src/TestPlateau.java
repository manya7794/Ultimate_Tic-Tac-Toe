
public class TestPlateau {

	public static void main(String[] args) {
		Plateau PlateauTest= new Plateau();
		Case c1= new Case();
		System.out.print(c1.getCaseType());
		System.out.println();
		System.out.println();
		System.out.println(PlateauTest.toString());
		PlateauTest.getPlateau()[4][1].setCaseBateau();
		
		System.out.println(PlateauTest.getCase("b5").getCaseType());
	}

}
