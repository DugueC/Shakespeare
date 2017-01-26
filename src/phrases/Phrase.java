package phrases;

import java.util.ArrayList;

public class Phrase {
	int reponse;
	ArrayList<String> mots;

	public Phrase(int reponse){
		this.reponse = reponse;
		mots = new ArrayList<String>();
	}
	
	public void ajouter(String mot){
		mots.add(mot);
	}
	
	public String getText(){
		String phrase="";
		for(String s : mots){
			phrase = phrase + s + " "; 
		}
		phrase = phrase.substring(0,phrase.length()-1);
		return phrase;
	}

	public double getSize() {
		return mots.size();
	}

	public String getMot(int x) {
		return mots.get(x);
	}
	
	public int getReponse(){
		return reponse;
	}
}