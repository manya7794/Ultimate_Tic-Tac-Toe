import java.util.Random;

public class Ordinateur extends Joueur {
	
	//Constructeurs
	public Ordinateur() {
		super.listeBateau = new Bateau();
		super.plateauJoueur = new Plateau(listeBateau);
		super.plateauAdverse = new Plateau();
		super.tour = false;
	}
	
	public Ordinateur(Plateau adv) {
		super.listeBateau = new Bateau();
		plateauJoueur = new Plateau(listeBateau);
		super.plateauAdverse = adv;
		super.tour = false;
	}
	
	/*
	 * Mode facile
	 * methode permettant a l'ordinateur de tirer sur une case aleatoirement
	 * 
	 * @param adversaire : le joueur adversaire sur lequel on tire
	 */
	public void sequenceTir(Joueur adversaire) {
		//rand permet de generer un chiffre aleatoirement
		Random rand = new Random();
		//Variable permettant de definir la case (i,j) sur lequel on tire
		int i = 0;
		int j = 0;
		
		//Boolean pour savoir si le tire a toucher
		boolean tirer = true;
		
		//Boucle jusqu'a que le tir touche
		do {
			//On genere un nombre aleatoire pour i et j entre la largeur et la hauteur min et max du plateau
			i = rand.nextInt(adversaire.getPlateau().getLargeur());
			j = rand.nextInt(adversaire.getPlateau().getHauteur());
			
			/*
			 * Si le tir touche une case vide ou une case detruite alors recommence, permet d'eviter de tirer au meme endroit
			 * 
			 * A modifier selon le mode de jeu qu'on souhaite, est ce qu'on peut tirer au meme endroit ? si oui il faut enlever la condition if
			 * et si oui alors ca veut dire qu'on peut perdre 1 tour
			 */
			
			if( (Case.getCaseType(adversaire.getPlateau(), i, j) != 2) && (Case.getCaseType(adversaire.getPlateau(), i, j) != 3) ) {
				System.out.println("Tir sur la case (" +i+ "," +j+ ")");
				//Tir sur la case (i,j) du plateau de l'adversaire
				super.tir(i,j,adversaire);
				tirer = true;
			}
			
		}while(!tirer);
	}
	
}
