import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
	//Attributs
	public HashMap<String,ArrayList<Case>> plateau;

	
	//Constructeur
	public Plateau() {
		this.plateau= new HashMap<String, ArrayList<Case>>(10);
	}
}
