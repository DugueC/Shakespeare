package phrases;

import java.util.ArrayList;
import java.util.Scanner;

public class Phrase {
	ArrayList<Integer> reponses;
	ArrayList<Mot> mots;
	
	public Phrase(String reponses){
		this.reponses = parse(reponses);
		mots = new ArrayList<Mot>();
	}
	
	private ArrayList<Integer> parse(String reponses) {
		Scanner filtre = new Scanner(reponses);
		filtre.useDelimiter(",");
		ArrayList<Integer> r = new ArrayList<Integer>();
		while(filtre.hasNext()){
			r.add(filtre.nextInt());
		}
		filtre.close();
		return r;
	}

	public void ajouter(Mot mot){
		mots.add(mot);
	}

	public double getSize() {
		return mots.size();
	}

	public Mot getMot(int x) {
		return mots.get(x);
	}
	
	public ArrayList<Integer> getReponses(){
		return reponses;
	}
	
	public int getNumMot(int x, int y){
		Mot m;
		for(int k=0;k<mots.size();k++){
			m = mots.get(k);
			if((m.getX()<x)&&(x<m.getXMax())&&(m.getYMin()<y)&&(y<m.getY()+5)){
				return k+1;
			}
		}
		return -1;
	}
}