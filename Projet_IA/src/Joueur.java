import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {
	//Attributs
	public HashMap<String,ArrayList<Case>> plateauJoueur;
	public HashMap<String,ArrayList<Case>> plateauAdverse;
	
	//Constructeur
	public Joueur() {
		this.plateauJoueur= new HashMap<String, ArrayList<Case>>(10);
		this.plateauAdverse= new HashMap<String, ArrayList<Case>>(10);
	}
}
