public class TestBateau {

	public static void main(String[] args) {
		Plateau PlateauTest= new Plateau();
		Bateau bateauTest = new Bateau();
		bateauTest.mettreBateauxAleatoire(PlateauTest);
		System.out.println(PlateauTest.toString());	
	}

}