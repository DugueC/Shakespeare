package modele;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.imageio.ImageIO;

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
	private Image imgExplications;
	private Image imgBandeau;
	private String messageBandeau;

	public Modele(){
		structure = new StructureNiveaux("bdd_full.csv");
		ouvert = true;
		reset();
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
		niveau = structure.getNiveau(num);
		niveau.majSommeCompteurs();
		setPhrase();
		setImgBandeau("neutre");
		messageBandeau = "Find the spelling mistake";
		imgExplications = null;
		setChanged();
		notifyObservers();
	}
	public int getNiveau(){
		if(niveau == null){
			return 0;
		}
		return niveau.getNiveau();
	}
	public Niveau getVraiNiveau(){
		return niveau;
	}
	
	//regle
	public void setRegle(){
		ArrayList<Regle> reglesPossibles = new ArrayList<Regle>();

		for(int i=0; i<niveau.getSize();i++){
			if((this.regle != niveau.getRegle(i)) && (niveau.getRegle(i).getCompteur() != 4)){
				reglesPossibles.add(niveau.getRegle(i));
			}
		}
		
		if(reglesPossibles.size()>0){
			this.regle = reglesPossibles.get((int)(Math.random()*reglesPossibles.size()));
		}
	}
	public String getRegle(){
		return regle.getRegle();
	}
	
	// renvoie un texte au hazard dans le bon niveau avec une regle differente de la derniere
	public void setPhrase(){
		setRegle();
		int x = (int)(Math.random()*regle.getSize());
		this.phrase = regle.getPhrase(x);
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
			setImgBandeau("gagne");
			messageBandeau = "Well done !";
			regle.setCompteur(regle.getCompteur()+1);
		}
		else{
			setImgBandeau("perdu");
			messageBandeau = "Nope...";
			regle.setCompteur(0);
			niveau.AjoutErreur(regle.getRegle());
		}
		setExplications(regle.getRegle());
		setChanged();
		notifyObservers();
	}
	
	public Image getExplications(){
		return imgExplications;
	}
	public void setExplications(String regle) {
		try {
			imgExplications = ImageIO.read(new File("img/regles/"+regle+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int[] getReponse(){
		return reponse;
	}
	
	//modeBandeau
	public void setImgBandeau(String img) {
		try {
			imgBandeau = ImageIO.read(new File("img/bandeau/"+img+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Image getImgBandeau(){
		return imgBandeau;
	}
	public String getMessagebandeau() {
		return messageBandeau;
	}
	
	public StructureNiveaux getStruct(){
		return structure;
	}
	
	public boolean verification(int x, int y){
		if(x == -1 && y == -1){
			if(phrase.getReponses().get(0)==0){
				return true;
			}
			return false;
		}
		else{
			for(int r : phrase.getReponses()){
				if(phrase.getNumMot(x, y)==r){
					return true;
				}
			}
			return false;
		}
	}
	
	public void setBandeauFin(){
		setImgBandeau("fin");
		messageBandeau = "Congratulation";
	}

	public void reset() {
		niveau = null;
		regle = null;
		phrase = null;
		reponse = new int[2];
		reponse[0]=-1;
		reponse[1]=-1;
		imgExplications = null;
		setImgBandeau("neutre");
		messageBandeau = "Choose your level";
		for(Niveau n : structure.getNiveaux()){
			n.initialiseErreurs();
			n.resetCompteurs();
		}
		setChanged();
		notifyObservers();
	}

}
