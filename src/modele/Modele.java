package modele;

import java.util.Observable;

import phrases.Niveau;
import phrases.Phrase;
import phrases.Regle;
import phrases.StructureNiveaux;

public class Modele extends Observable{
	private StructureNiveaux structure;
	private boolean ouvert; // fenetre ouverte
	private Niveau niveau;
	private Regle regle;
	private Phrase phrase;
	private int reponse[];
	private int modeBandeau; //0 = accueil, 1 = exo, 2 = reponse bonne, 3 = reponse fausse
	
	public Modele(){
		structure = new StructureNiveaux("bdd.csv");
		ouvert = true;
		niveau = null;
		regle = null;
		phrase = null;
		reponse = new int[2];
		reponse[0]=-1;
		reponse[1]=-1;
		modeBandeau = 0;
	}
	
	
	
	// ouvert
	public boolean getOuvert() {
		return ouvert;
	}
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
		setChanged();
		notifyObservers();
	}
	
	//niveau
	public void setNiveau(int num) {
		this.niveau = structure.getNiveau(num-1);
		setPhrase();
		setModeBandeau(1);
		setChanged();
		notifyObservers();
	}
	public int getNiveau(){
		if(niveau == null){
			return 0;
		}
		return niveau.getNiveau();
	}
	
	//regle
	public void setRegle(){
		int x;
		do{
			x = (int)(Math.random()*niveau.getSize());
		}while(this.regle == niveau.getRegle(x));
		
		this.regle = niveau.getRegle(x);
	}
	public String getRegle(){
		return regle.getRegle();
	}
	
	// renvoie un texte au hazard dans le bon niveau avec une regle differente de la derniere
	public void setPhrase(){
		setRegle();
		int x = (int)(Math.random()*regle.getSize());
		this.phrase = regle.getPhrase(x);
		setChanged();
		notifyObservers();
	}
	public Phrase getPhrase(){
		return phrase;
	}
	
	//reponse
	public void setReponse(int x, int y) {
		reponse[0] = x;
		reponse[1] = y;
		boolean bonneReponse = verification(x,y);
		if(bonneReponse){
			 setModeBandeau(2);
		}
		else{
			setModeBandeau(3);
		}
		/*+figer text cliquable
		+afficher erreur sur texte cliquable
		+afficher règle sur panneau en dessous de texte*/
		setChanged();
		notifyObservers();
	}
	public int[] getReponse(){
		return reponse;
	}
	
	//modeBandeau
	public void setModeBandeau(int m) {
		modeBandeau = m;
	}
	public int getModeBandeau(){
		return modeBandeau;
	}
	
	public boolean verification(int x, int y){
		if(x == -1 && y == -1){
			if(phrase.getReponse()==0){
				return true;
			}
			return false;
		}
		else{
			
			return true;
		}
	}
}
