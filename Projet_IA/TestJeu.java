package Projet_IA;

public class TestJeu {

	public static void main(String[] args) {
		
		//Test de la classe Jeu :
		//Joueur versus Joueur
		//Jeu newGame = new Jeu();
		//newGame.joueurVersusJoueur();
		
		Jeu newGame = new Jeu(3);
		newGame.joueurVersusIA();
		
		
		//Test de la classe JeuBis :
		//Joueur versus IA de niveau 1
		//JeuBis newGameIA = new JeuBis(1);
		//newGameIA.joueurVersusJoueur();

	}

}
