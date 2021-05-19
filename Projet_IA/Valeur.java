package Projet_IA;

import java.util.ArrayList;

/**
 * 
 * Classe permettant
 *
 */
public class Valeur {
	//Attributs
	
	//Poids de la zone
	private int poids;
	
	//Niveau de difficulte de l'ordinateur
	private int niveau;
	
	//Constructeur
	/**
	 * Constructeur
	 * @param niveau
	 */
	public Valeur(int niveau) {
		this.poids=0;
		this.niveau=niveau;
	}
	
	public Valeur() {
		this.poids=0;
		this.niveau=0;
	}
	
	//Methodes
	
	//Getters
	
	/**
	 * Methode renvoyant le poids de la zone
	 * 
	 * @return le poids de la zone
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * Methode renvoyant le niveau choisit par l'utilisateur
	 * 
	 * @return le niveau choisit
	 */
	public int getNiveau() {
		return niveau;
	}

	//Setters
	
	public void setPoids(int poids) {
		this.poids=poids;
	}
	
	public void setNiveau(int niveau) {
		this.niveau=niveau;
	}
	
	/**
	 * Methode augmentant la valeur de la zone si une case adverse est presente
	 * @param symboleJoueur Symbole du joueur utilsant la methode
	 * @param c Case a analyser
	 */
	public void caseAdversePresente(int symboleJoueur, Case c) {
			//S'il s'agit d'une case adverse
		if(c.getContenu()!=symboleJoueur) {
			poids+=1;
		}
	}
	
	/**
	 * Methode augmentant la valeur de la zone si l'adversaire a une ligne possible
	 * @param symboleJoueur Symbole du joueur utilisant la methode
	 * @param c Case a tester
	 * @param plat Zone de jeu ou se situe la case
	 * @param verifDispo ArrayList permettant de verifier que la ligne n'a pas deja ete verifiee
	 */
	public void ligneAdversePossible(int symboleJoueur, Case c, PlateauSub plat, ArrayList<Boolean> verifDispo) {
		if(c.getContenu()!=symboleJoueur) {
			switch(c.getPosition()) {
			case 0:
				//ligne 1
				if(plat.getCase(1).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				//Colonne 1
				if(plat.getCase(3).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 1:
				//ligne 1
				if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(7).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 2:
				//ligne 1
				if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(1).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(5).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 3:
				//Colonne 1
				if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Ligne 2
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(5).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 4:
				//ligne 2
				if(plat.getCase(3).getContenu()!=symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(5).getContenu()!=symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(1).getContenu()!=symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(7).getContenu()!=symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				break;
			case 5:
				//ligne 2
				if(plat.getCase(3).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				break;
			case 6:
				//ligne 3
				if(plat.getCase(7).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				}
				//Colonne 1
				if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(3).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 7:
				//ligne 3
				if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(8).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(1).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				break;
			case 8:
				//ligne 3
				if(plat.getCase(6).getContenu()!=symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(7).getContenu()!=symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(2).getContenu()!=symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(5).getContenu()!=symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(4).getContenu()!=symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(0).getContenu()!=symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			}
		}
	}
	
	/**
	 * Methode diminuant la valeur de la zone si une case alliee est presente
	 * 
	 * @param symboleJoueur Symbole du joueur utilsant la methode
	 * @param c Case a analyser
	 */
	public void caseAllieePresente(int symboleJoueur, Case c) {
		//Niveau facile
		if(niveau==1) {
			//S'il s'agit d'une case adverse
			if(c.getContenu()==symboleJoueur) {
				poids-=1;
			}
		}
	}
	
	/**
	 * Methode diminuant la valeur de la zone si le joueur a une ligne possible
	 * @param symboleJoueur Symbole du joueur utilisant la methode
	 * @param c Case a tester
	 * @param plat Zone de jeu ou se situe la case
	 * @param verifDispo ArrayList permettant de verifier que la ligne n'a pas deja ete verifiee
	 */
	public void ligneAllieePossible(int symboleJoueur, Case c, PlateauSub plat, ArrayList<Boolean> verifDispo) {
		if(c.getContenu()==symboleJoueur) {
			switch(c.getPosition()) {
			case 0:
				//ligne 1
				if(plat.getCase(1).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				//Colonne 1
				if(plat.getCase(3).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 1:
				//ligne 1
				if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(7).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 2:
				//ligne 1
				if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(1).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(5).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 3:
				//Colonne 1
				if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Ligne 2
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(5).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 4:
				//ligne 2
				if(plat.getCase(3).getContenu()==symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(5).getContenu()==symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(1).getContenu()==symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(7).getContenu()==symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				break;
			case 5:
				//ligne 2
				if(plat.getCase(3).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				break;
			case 6:
				//ligne 3
				if(plat.getCase(7).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				}
				//Colonne 1
				if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(3).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(3).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 2
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			case 7:
				//ligne 3
				if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(8).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(8).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				//Colonne 2
				if(plat.getCase(1).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(1).getContenu()==0) {
					poids-=5;
				}
				break;
			case 8:
				//ligne 3
				if(plat.getCase(6).getContenu()==symboleJoueur && plat.getCase(7).getContenu()==0) {
					poids-=5;
				}
				else if(plat.getCase(7).getContenu()==symboleJoueur && plat.getCase(6).getContenu()==0) {
					poids-=5;
				}
				//Colonne 3
				if(plat.getCase(2).getContenu()==symboleJoueur && plat.getCase(5).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(5).getContenu()==symboleJoueur && plat.getCase(2).getContenu()==0) {
					poids-=5;
				}
				//Diagonale 1
				if(plat.getCase(4).getContenu()==symboleJoueur && plat.getCase(0).getContenu()==0) {
					poids-=5;
				} 
				else if(plat.getCase(0).getContenu()==symboleJoueur && plat.getCase(4).getContenu()==0) {
					poids-=5;
				}
				break;
			}
		}
	}
	
	/**
	 * Methode ajoutant de la valeur aux zones voisines
	 * @param pos Position de la zone sur le plateau de jeu principal
	 * @param plat Plateau de jeu principal ou se situe la zone
	 */
	public void zoneValideeAdversaire(int pos, PlateauPrincipal plat) {
		if (pos==0) {
			//Changement de valeur de la zone 1
			int poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 3
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if(pos==2) {
			//Changement de valeur de la zone 1
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 5
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if(pos==6) {
			//Changement de valeur de la zone 3
			int poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la case 7
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
		}
		if(pos==8) {
			//Changement de valeur de la zone 5
			int poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la case 7
			poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
		}
		if (pos==1) {
			//Changement de valeur de la zone 0
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 2
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 4
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if (pos==7) {
			//Changement de valeur de la zone 6
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 8
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 4
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==3) {
			//Changement de valeur de la zone 4
			int poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 6
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 0
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==5) {
			//Changement de valeur de la zone 4
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 8
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 2
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==4) {
			//Changement de valeur de la zone 3
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 5
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 7
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 1
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
	}
	
	/**
	 * Methode soustrayant de la valeur aux zones voisines
	 * @param pos Position de la zone sur le plateau de jeu principal
	 * @param plat Plateau de jeu principal ou se situe la zone
	 */
	public void zoneValideeAlliee(int pos, PlateauPrincipal plat) {
		if (pos==0) {
			//Changement de valeur de la zone 1
			int poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 3
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if(pos==2) {
			//Changement de valeur de la zone 1
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 5
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if(pos==6) {
			//Changement de valeur de la zone 3
			int poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la case 7
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
		}
		if(pos==8) {
			//Changement de valeur de la zone 5
			int poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la case 7
			poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
		}
		if (pos==1) {
			//Changement de valeur de la zone 0
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 2
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 4
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
		}
		if (pos==7) {
			//Changement de valeur de la zone 6
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 8
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 4
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==3) {
			//Changement de valeur de la zone 4
			int poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 6
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 0
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==5) {
			//Changement de valeur de la zone 4
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 8
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 2
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
		if (pos==4) {
			//Changement de valeur de la zone 3
			int poidsTmp=plat.getPlateau().get(pos-1).getValeur().getPoids();
			poidsTmp+=5;
			plat.getPlateau().get(pos-1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 5
			poidsTmp=plat.getPlateau().get(pos+1).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+1).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 7
			poidsTmp=plat.getPlateau().get(pos+3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos+3).getValeur().setPoids(poidsTmp);
			//Changement de valeur de la zone 1
			poidsTmp=plat.getPlateau().get(pos-3).getValeur().getPoids();
			poidsTmp-=5;
			plat.getPlateau().get(pos-3).getValeur().setPoids(poidsTmp);
		}
	}
	
	/**
	 * Methode ajoutant du poids a la zone si une case adverse se trouve sur un bord
	 * Utilisee dans les modes intermediaires et difficiles
	 * @param symboleJoueur Symbole du joueur utilisant la methode
	 * @param c Case a analyser
	 */
	public void caseAdverseBord(int symboleJoueur, Case c) {
		//Verification du niveau (intermediaire ou difficile)
		if(niveau>2) {
			//Verification de la position de la case
			if((c.getPosition()==0)||(c.getPosition()==2)||(c.getPosition()==6)||(c.getPosition()==8)) {
				//Verification du contenu de la case
				if(c.getContenu()!=symboleJoueur) {
					poids+=1;
				}
			}
		}
	}
	
	/**
	 * Methode soustrayant du poids a la zone si une case alliee se trouve sur un bord
	 * Utilisee dans les modes intermediaires et difficiles
	 * @param symboleJoueur Symbole du joueur utilisant la methode
	 * @param c Case a analyser
	 */
	public void caseAllieeBord(int symboleJoueur, Case c) {
		//Verification du niveau (intermediaire ou difficile)
		if(niveau>2) {
			//Verification de la position de la case
			if((c.getPosition()==0)||(c.getPosition()==2)||(c.getPosition()==6)||(c.getPosition()==8)) {
				//Verification du contenu de la case
				if(c.getContenu()==symboleJoueur) {
					poids-=1;
				}
			}	
		}
	}
	
	
	public String toString() {
		return "Valeur de la zone : "+getPoids();
	}
}
