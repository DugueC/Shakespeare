package phrases;

import java.util.ArrayList;

public class Niveau {
	int niveau;
	ArrayList<Regle> regles;
	
	public Niveau(int niveau){
		this.niveau = niveau;
		regles = new ArrayList<Regle>();
	}
	
	public void ajouter(Regle regle){
		regles.add(regle);
	}
	
	public int getNiveau(){
		return niveau;
	}
	public int getSize(){
		return regles.size();
	}
	public ArrayList<Regle> getRegles(){
		return regles;
	}
	public Regle getRegle(int num){
		return regles.get(num);
	}
}
