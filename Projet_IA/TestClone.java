package Projet_IA;

public class TestClone {

	public static void main(String[] args) {
		PlateauPrincipal plat = new PlateauPrincipal();
		for(int i=0; i<9;i++) {
			PlateauSub platSub = new PlateauSub(i);
			for(int j=0; j<9; j++) {
				Case c = new Case(j);
				platSub.getPlateau().add(c);
			}
			plat.plateau.add(platSub);
		}
		System.out.println("Plateau principal : \n");
		System.out.println(plat.toString());
		
		//Ajout de symbole
		plat.getPlateau().get(2).getCase(1).setCross();
		plat.getPlateau().get(2).getCase(2).setCross();
		plat.getPlateau().get(7).getCase(7).setCircle();
		System.out.println(plat.toString());
		System.out.println(plat.getPlateau().get(7).affiche());
		
		
		//Creation du plateau clone
		
		PlateauPrincipal platClone = plat.clone();
		//PlateauPrincipal platClone = new PlateauPrincipal(plat);
		System.out.println("Plateau clone : \n");
		System.out.println(platClone.toString());
		
		//Ajout de symbole dans le plateau clone
		platClone.getPlateau().get(2).getCase(3).setCircle();
		platClone.getPlateau().get(2).getCase(4).setCircle();
		platClone.getPlateau().get(3).getCase(5).setCircle();
		System.out.println(platClone.toString());
		System.out.println(platClone.getPlateau().get(2).affiche());
		
		System.out.println("Re affichage du plateau principal : \n");
		System.out.println(plat.toString());

	}

}
