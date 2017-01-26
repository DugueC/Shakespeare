package phrases;

import java.util.ArrayList;
import java.util.Scanner;

public class Regle {
	String regle;
	ArrayList<Phrase> phrases;
	
	public Regle(String regle){
		this.regle = regle;
		phrases = new ArrayList<Phrase>();
	}
	
	public void ajouter(String phrase,int reponse){
		Scanner filtre = new Scanner(phrase);
		filtre.useDelimiter(" ");
		Phrase p = new Phrase(reponse);
		while(filtre.hasNext()){
			p.ajouter(filtre.next());
		}
		phrases.add(p);
		filtre.close();
	}
	
	public String getRegle(){
		return regle;
	}

	public double getSize() {
		return phrases.size();
	}

	public Phrase getPhrase(int x) {
		return phrases.get(x);
	}
	
}
