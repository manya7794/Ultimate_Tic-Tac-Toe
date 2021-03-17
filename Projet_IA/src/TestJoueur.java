import java.util.Scanner;

public class TestJoueur {

	public static void main(String[] args) {
		//Case c1= new Case();
		/*
		System.out.print(c1.getCaseType());
		System.out.println();
		System.out.println();
		*/
		//PlateauTest.getPlateau()[0][0].setCaseBateau();
		Joueur j2 = new Joueur();
		Joueur j = new Joueur();
		System.out.println("Joueur 1");
		System.out.println(j.toString());
		System.out.println("Joueur 2");
		System.out.println(j2.toString());
		/*
		j.tir(0, 0);
		System.out.println(j.plateauAdverse.toString());
		System.out.println();
		System.out.println();
		System.out.println(j.toString());
		//j.tir(9, 0);
		System.out.println(j.toString());
		*/
		
		
		//Test de tir en boucle
		Scanner sc= new Scanner(System.in);
		boolean sortie=false;
		while(!sortie) {
			System.out.println(j.toString());
			System.out.println("Saisissez les coordonnees ou tirer (ex:A1):");
			System.out.println("Saisissez 'Sortie' pour arreter le programme");
			String cible=sc.next();
			if(cible.equals("Sortie")) {
				sortie=true;
				sc.close();
			}
			else
				j.tir(cible, j2);
		}
		
	}

}
