
public class Joueur {
	//Attributs
	//Plateau contenant les bateaux du joueur
	public Plateau plateauJoueur;
	//Plateau contenant la connaissance du joueur sur le plateau adverse
	public Plateau plateauAdverse;
	
	//Constructeur
	public Joueur() {
		this.plateauJoueur= new Plateau();
		this.plateauAdverse= new Plateau();
	}
	
		public Joueur(Plateau adv) {
		this.plateauJoueur= new Plateau();
		this.plateauAdverse= adv;
	}
	//Methodes
	
	/*
	 * Effectue un tir sur une case definie par le joueur
	 * @param i l'abscisse de la case
	 * @param j l'ordonnee de la case 
	 */
	public void Tir(int i, int j) {
		switch (Case.getCaseType(plateauAdverse, i, j)) {
		//Case Mer
		case 0:
			//Remplace par une case vide
			Case.setCaseVide(plateauAdverse, i, j);
			break;
		//Case Bateau
		case 1:
			//Remplace par une case detruite
			Case.setCaseDetruit(plateauAdverse, i, j);
			break;
		//Tire deja effectue sur la case
		default:
			System.out.println("Un tir a deja ete effectue sur la case. Choisissez une autre case.");
			break;
		}
	}
}
