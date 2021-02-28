import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bateau {

	//Attributs
	//Les differents type de bateau avec leur taille
	
	private static String porte_avion = "Porte Avion";
	private static String croiseur = "Croiseur";
	private static String contre_torpilleur = "Contre Torpilleur";
	private static String torpilleur = "Torpilleur";
	private static HashMap <String, Integer[]> listBateau;
	
	//Constructeur
	
	public Bateau() {
		listBateau = new HashMap<String, Integer[]>();
		initListBateau();
	}
	
	//Methode
	
	//Initialise la liste des bateaux qui seront disponible ainsi que leurs nombres
	private static void initListBateau() {
		//Liste position 0 : taille du bateau, position 1 : quantite du bateau
		Integer[]listPA = {5, 1};
		listBateau.put(porte_avion, listPA);
		
		Integer[]listC = {4, 1};
		listBateau.put(croiseur, listC);
		
		Integer[]listCT = {3, 2};
		listBateau.put(contre_torpilleur, listCT);
		
		Integer[]listT = {2, 1};
		listBateau.put(torpilleur, listT);
	}
	
	/*
	 * Placement des bateaux aleatoirement sur le terrain
	 * @param plat : le plateau 
	 */
	public void mettreBateauxAleatoire(Plateau plat) {
		Random rand = new Random();
		Case caseCourant = new Case();
		
		//Parcourir toutes les cles (bateau) de la HashMap listBateau
		for(Map.Entry n : listBateau.entrySet()) {
			//Recupere le nom du bateau
			String nomBateau = (String) n.getKey();

			//Recuperer la taille (0) et la quantite (1) du bateau
			Integer[] tailleQuantiteBateau = listBateau.get(nomBateau);
			
			//Boucle autant de fois qu'il y a de nombre du bateau courant
			for(int quantite = 0 ; quantite < tailleQuantiteBateau[1] ; quantite++) {
				
				boolean caseLibre = true;
				
				//Coordonnee i j de la case (debut du bateau), orientation (k) du bateau 
				int i = 0, j = 0, k = 0;
				//Coordonnee temporaire de i et j afin de verifier si les coordonnees choisies sont acceptables
				int tmpi = 0, tmpj = 0;
				
				//Boucle tant que l'emplacement du bateau choisi n'est pas bon (depassement du plateau ou collision)
				do {
					//On selectionne une case i j aleatoirement qui represente le debut du bateau
					i = rand.nextInt(plat.getLargeur());
					j = rand.nextInt(plat.getHauteur());
					//On choisit une direction pour le bateau (4 possibles) aleatoirement
					k = rand.nextInt(4);
					
					tmpi = i;
					tmpj = j;
					caseLibre = true;
					//listBateau.get(n) a changer par la taille du bateau donc faut faire un get de la cle pour savoir quel bateau
					for(int m = 0 ; m < tailleQuantiteBateau[0] && caseLibre ; m++) {
						
						switch(k) {
						//Vers la gauche
						case 0 : 
							tmpi += 1;
							//Test si la case fait toujours partie du plateau
							if(tmpi <= 0 || tmpi >= plat.getLargeur()) {
								caseLibre = false;
							}
							else if(tmpj <= 0 || tmpj >= plat.getHauteur()) {
								caseLibre = false;
							}
							
							//Test si la case est une case "mer" (=0)
							else if(caseCourant.getCaseType(plat, tmpi, tmpj) != 0) {
								caseLibre = false;
							}
							break;
						//Vers le haut
						case 1 :
							tmpj += 1;
							if(tmpi <= 0 || tmpi >= plat.getLargeur()) {
								caseLibre = false;
							}
							else if(tmpj <= 0 || tmpj >= plat.getHauteur()) {
								caseLibre = false;
							}
							
							else if(caseCourant.getCaseType(plat, tmpi, tmpj) != 0) {
								caseLibre = false;
							}
							break;
						//Vers la droite
						case 2 :
							tmpi -= 1;
							if(tmpi <= 0 || tmpi >= plat.getLargeur()) {
								caseLibre = false;
							}
							else if(tmpj <= 0 || tmpj >= plat.getHauteur()) {
								caseLibre = false;
							}
							
							else if(caseCourant.getCaseType(plat, tmpi, tmpj) != 0) {
								caseLibre = false;
							}
							
							break;
						//Vers le bas
						case 3 :
							tmpj -= 1;
							if(tmpi <= 0 || tmpi >= plat.getLargeur()) {
								caseLibre = false;
							}
							else if(tmpj <= 0 || tmpj >= plat.getHauteur()) {
								caseLibre = false;
							}
							
							else if(caseCourant.getCaseType(plat, tmpi, tmpj) != 0) {
								caseLibre = false;
							}
							break;
						}
						
					}
				} while(!caseLibre);
				
				//listBateau.get(n) a changer par la taille du bateau donc faut faire un get de la cle pour savoir quel bateau
				for(int m = 0 ; m < tailleQuantiteBateau[0] ; m++) {
					switch(k) {
					//Vers la gauche
					case 0 : 
						i += 1;
						caseCourant.setCaseBateau(plat, i, j);
						break;
					//Vers le haut
					case 1 :
						j += 1;
						caseCourant.setCaseBateau(plat, i, j);
						break;
					//Vers la droite
					case 2 :
						i -=1;
						caseCourant.setCaseBateau(plat, i, j);
						break;
					//Vers le bas
					case 3 :
						j -= 1;
						caseCourant.setCaseBateau(plat, i, j);
						break;
					}
				}
				
			}
		}
	}
	
	/*
	 * Le joueur place les bateaux manuellement sur le terrain
	 */
	public static void mettreBateauxManuel(Plateau plat) {
		
	}

}