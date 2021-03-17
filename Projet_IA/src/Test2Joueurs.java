import java.util.Scanner;

public class Test2Joueurs {

	public static void main(String[] args) {
		//Creation du premier joueur
		Joueur j1 = new Joueur();
		//Creation du second joueur
		Joueur j2 = new Joueur(j1.plateauJoueur);
		//Ajout du plateau du second joueur pour le premier joueur
		j1.setPlateauAdverse(j2.plateauJoueur);
		Scanner sc= new Scanner(System.in);
		
		//Active le tour du joueur 1
		j1.activeTour();
		
		while(j1.resteBateau()||j2.resteBateau()) {
			if(j1.getTour()) {
				boolean sortie=false;
				while(!sortie) {
					int nbBateau= j2.nbCaseBateauxAdverse();
					System.out.println("Joueur 1");
					System.out.println(j1.toString());
					System.out.println("Saisissez les coordonnees ou tirer (ex:A1):");
					System.out.println("Saisissez 'Sortie' pour arreter le programme");
					String cible=sc.next();
					if(cible.equals("Sortie")) {
						sortie=true;
						sc.close();
					}
					else {
						j1.tir(cible, j2);
						sortie=true;
						if (nbBateau==j2.nbCaseBateauxAdverse()){
							j1.desactiveTour();
							j2.activeTour();
						}
					}
				}
			}
			else {
				boolean sortie=false;
				while(!sortie) {
					int nbBateau= j1.nbCaseBateauxAdverse();
					System.out.println("Joueur 2");
					System.out.println(j2.toString());
					System.out.println("Saisissez les coordonnees ou tirer (ex:A1):");
					System.out.println("Saisissez 'Sortie' pour arreter le programme");
					String cible=sc.next();
					if(cible.equals("Sortie")) {
						sortie=true;
						sc.close();
					}
					else {
						j2.tir(cible, j1);
						sortie=true;
						if (nbBateau==j1.nbCaseBateauxAdverse()){
							j2.desactiveTour();
							j1.activeTour();
						}
					}
				}
			}
		}

	}
}