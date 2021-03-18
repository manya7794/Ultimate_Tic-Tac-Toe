
public class Joueur {
	//Attributs
	//Plateau contenant les bateaux du joueur
	public Plateau plateauJoueur;
	//Plateau contenant la connaissance du joueur sur le plateau adverse
	public Plateau plateauAdverse;
	//Liste des bateaux du joueur
	public Bateau listeBateau;
	//Definit si le joueur doit jouer son tour ou non
	public boolean tour;
	//Constructeur
	
	//Cree un profil joueur avec un plateau adverse vide
	public Joueur() {
		this.listeBateau= new Bateau();
		this.plateauJoueur= new Plateau(listeBateau);
		this.plateauAdverse= new Plateau();
		this.tour= false;
	}
	
	/*
	 * Cree un profil joueur avec un plateau adverse identique a celui de l'adversaire
	 * @param adv le plateau de l'adversaire
	 */
	public Joueur(Plateau adv) {
		this.listeBateau= new Bateau();
		plateauJoueur= new Plateau(listeBateau);
		this.plateauAdverse= adv;
		this.tour= false;
	}
	
	//Setter
	
	/*
	 * Definit les cases du plateau adverse
	 * @param adv le plateau adverse
	 */
	public void setPlateauAdverse(Plateau adv) {
		this.plateauAdverse=adv;
	}
	
	//Methodes
	
	/*
	 * Effectue un tir sur une case definie par le joueur
	 * @param i l'abscisse de la case
	 * @param j l'ordonnee de la case 
	 */
	public void tir(int i, int j, Joueur adversaire) {
		switch (Case.getCaseType(plateauAdverse, i, j)) {
		
		//Case Mer
		case 0:
			//Remplace par une case vide
			Case.setCaseVide(plateauAdverse, i, j);
			Case.setCaseVide(adversaire.getPlateau(), i, j);
			break;
		//Case Bateau
		case 1:
			//Remplace par une case detruite
			Case.setCaseDetruit(plateauAdverse, i, j);
			Case.setCaseDetruit(adversaire.getPlateau(), i, j);
			break;
		//Tire deja effectue sur la case
		default:
			System.out.println("Un tir a deja ete effectue sur la case. Choisissez une autre case.");
			break;
		}
	}
	
	/*
	 * Effectue un tir sur une case definie par le joueur
	 * @param coordoonnees les coordonnes de la case
	 */
	public void tir(String coordonnees, Joueur adversaire) {
		//Recupere le type de la case ciblee
		int typeCaseCible =plateauAdverse.getCase(coordonnees).getCaseType();
		switch(typeCaseCible) {
		//Case Mer
		case 0:
			//Cas ou les coordonnes ont plus de 3 caracteres
			if(coordonnees.length()>=3) {
				//Cas ou la ligne est egale a 10
				if((coordonnees.charAt(1)==1)&&(coordonnees.charAt(2)==0)) {
					Case.setCaseVide(plateauAdverse, coordonnees);
					Case.setCaseVide(adversaire.getPlateau(), coordonnees);
					break;
				}
				//Cas ou la ligne n'existe pas
				else {
					System.out.println("La case selectionnee n'existe pas.");
				}
			}
			//Remplace par une case vide
			//Case.setCaseVide(plateauAdverse, coordonnees);
			Case.setCaseVide(adversaire.getPlateau(), coordonnees);
			break;
		//Case Bateau
		case 1:
			//Cas ou les coordonnes ont plus de 3 caracteres
			if(coordonnees.length()>=3) {
				//Cas ou la ligne est egale a 10
				if((coordonnees.charAt(1)==1)&&(coordonnees.charAt(2)==0)) {
					Case.setCaseDetruit(plateauAdverse, coordonnees);
					Case.setCaseDetruit(adversaire.getPlateau(), coordonnees);
					break;
				}
				//Cas ou la ligne n'existe pas
				else {
					System.out.println("La case selectionnee n'existe pas.");
				}
			}
			//Remplace par une case detruite
			Case.setCaseDetruit(plateauAdverse, coordonnees);
			Case.setCaseDetruit(adversaire.getPlateau(), coordonnees);
			break;
		//Tire deja effectue sur la case
		default:
			//Gerer le cas >10
			if((coordonnees.length()>=3)) {
				System.out.println("La case selectionnee n'existe pas.");
				break;
			}
			//Cas ou un tir a deja ete fait sur la case
			System.out.println("Un tir a deja ete effectue sur la case. Choisissez une autre case.");
			break;
		}
	}
	
	/*
	 * Definit s'il reste des bateaux sur le plateau adverse
	 */
	public boolean resteBateau() {
		boolean reste=false;
		
		for(int i=0; i<plateauJoueur.getLargeur(); i++) {
			for(int j=0; j<plateauJoueur.getHauteur();j++) {
				if (Case.getCaseType(plateauJoueur, i, j)==1)
					reste=true;
			}
		}
		return reste;
	}
	
	/*
	 * Renvoie le nombre de cases bateau sur le plateau adverse
	 */
	public int nbCaseBateauxAdverse() {
		int nb=0;
		
		for(int i=0; i<plateauJoueur.getLargeur(); i++) {
			for(int j=0; j<plateauJoueur.getHauteur();j++) {
				if (Case.getCaseType(plateauJoueur, i, j)==1)
					nb++;
			}
		}
		return nb;
	}
	
	/*
	 * Active le tour du joueur
	 */
	public void activeTour() {
		tour= true;
	}
	
	/*
	 * Desactive le tour du joueur
	 */
	public void desactiveTour() {
		tour= false;
	}
	
	/*
	 * Renvoie la valeur du tour
	 */
	public boolean getTour() {
		return tour;
	}
	
	/*
	 * 
	 */
	public Plateau getPlateau() {
		return plateauJoueur;
	}
	
	/*
	 * Affiche les plateaux de jeu du joueur actuel et sa connaissance du plateau adverse
	 * @return les plateaux de jeu du joueur et sa connaissance du plateau adverse
	 */
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		tmp.append("     Plateau joueur \t\t     Plateau adverse\n\n");
		//Ajoute les indices des colonnes
		tmp.append("   A B C D E F G H I J\t\t   A B C D E F G H I J\n");
		//Parcourt les lignes
		for(int i=0;i<plateauJoueur.getPlateau().length;i++) {
			//Ajout des numeros des lignes
			if(i<plateauJoueur.getPlateau().length-1)
				tmp.append(i+1+"  ");
			else
				tmp.append(i+1+" ");
			
			//Parcourt les colonnes du plateau joueur
			for(int j=0; j<plateauJoueur.getPlateau()[i].length;j++) {
				//Ajoute le contenu de chaque case
				tmp.append(plateauJoueur.getPlateau()[i][j].getSymboleJoueur()+" ");
			}
			
			//Ajout d'un separateur entre les deux plateaux
			if(i<plateauJoueur.getPlateau().length-1)
				tmp.append("   *\t"+(i+1)+"  ");
			else
				tmp.append("   *\t"+(i+1)+" ");
			
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
