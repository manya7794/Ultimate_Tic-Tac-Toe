
public class Joueur {
	//Attributs
	//Plateau contenant les bateaux du joueur
	public Plateau plateauJoueur;
	//Plateau contenant la connaissance du joueur sur le plateau adverse
	public Plateau plateauAdverse;
	//Liste des bateaux du joueur
	public Bateau listeBateau;
	
	//Constructeur
	
	//Cree un profil joueur avec un plateau adverse vide
	public Joueur() {
		this.listeBateau= new Bateau();
		this.plateauJoueur= new Plateau(listeBateau);
		this.plateauAdverse= new Plateau();
	}
	
	/*
	 * Cree un profil joueur avec un plateau adverse identique a celui de l'adversaire
	 * @param adv le plateau de l'adversaire
	 */
	public Joueur(Plateau adv) {
		this.listeBateau= new Bateau();
		this.plateauJoueur= new Plateau(listeBateau);
		this.plateauAdverse= adv;
	}
	
	//Setter
	
	public void setPlateauAdverse(Plateau adv) {
		this.plateauAdverse=adv;
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
	
	/*
	 * Affiche les plateaux de jeu du joueur actuel et sa connaissance du plateau adverse
	 */
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		tmp.append(" Plateau joueur\t\t\t Plateau adverse\n");
		//Parcourt les lignes
		for(int i=0;i<plateauJoueur.getPlateau().length;i++) {
			//Parcourt les colonnes du plateau joueur
			for(int j=0; j<plateauJoueur.getPlateau()[i].length;j++) {
				//Ajoute le contenu de chaque case
				tmp.append(plateauJoueur.getPlateau()[i][j].getSymboleJoueur()+" ");
			}
			//Ajout d'un separateur entre les deux plateaux
			tmp.append("\t*\t");
			
			//Parcourt les colonnes du plateau adverse
			for(int j=0;j<plateauAdverse.getPlateau()[i].length;j++) {
				//Ajoute le contenu de chaque case
				tmp.append(plateauAdverse.getPlateau()[i][j].getSymboleAdverse()+" ");
			}
			tmp.append("\n");
		}
		return tmp.toString();
	}
}
