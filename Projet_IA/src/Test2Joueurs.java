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
			//Cas ou il s'agit du tour du joueur 1
			if(j1.getTour()) {
				//Condition de sortie de la boucle
				boolean sortie=false;
				while(!sortie) {
					//Nombre de cases bateau du joueur adverse
					int nbBateau= j2.nbCaseBateauxAdverse();
					System.out.println("Joueur 1\n");
					//Affichage du plateau de jeu et de la connaissance du plateau adverse
					System.out.println(j1.toString());
					//Instructions de jeu
					System.out.println("Saisissez les coordonnees ou tirer (ex:A1):");
					System.out.println("Saisissez 'Sortie' pour arreter le programme");
					//Recuperation du choix du joueur
					String cible=sc.next();
					//Cas ou le joueur souhaite arreter la partie
					if(cible.equals("Sortie")) {
						sortie=true;
						sc.close();
					}
					else {
						//Cas ou le joueur a entre des coordonnees
						j1.tir(cible, j2);
						sortie=true;
						//Cas ou le tir n'a touche aucun bateau
						if (nbBateau==j2.nbCaseBateauxAdverse()){
							//Desactive le tour du joueur 1
							j1.desactiveTour();
							//Active le tour du joueur 2
							j2.activeTour();
							System.out.println("Case vide touchee\n\n");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else {
							System.out.println("Case bateau touchee\n\n");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
					}
				}
			}
			else {
				//Condition de sortie de la boucle
				boolean sortie=false;
				while(!sortie) {
					//Nombre de bateau du joueur adverse
					int nbBateau= j1.nbCaseBateauxAdverse();
					System.out.println("Joueur 2\n");
					//Affichage du plateau de jeu et de la connaissance du plateau adverse
					System.out.println(j2.toString());
					//Instructions de jeu
					System.out.println("Saisissez les coordonnees ou tirer (ex:A1):");
					System.out.println("Saisissez 'Sortie' pour arreter le programme");
					//Recuperation du choix du joueur
					String cible=sc.next();
					//Cas ou le joueur souhaite arreter la partie
					if(cible.equals("Sortie")) {
						sortie=true;
						sc.close();
					}
					else {
						//Cas ou le joueur a entre des coordonnees
						j2.tir(cible, j1);
						sortie=true;
						//Cas ou le tir n'a touche aucun bateau
						if (nbBateau==j1.nbCaseBateauxAdverse()){
							//Desactive le tour du joueur 2
							j2.desactiveTour();
							//Active le tour du joueur 1
							j1.activeTour();
							System.out.println("Case vide touchee\n\n");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						else {
							System.out.println("Case bateau touchee\n\n");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

	}
}