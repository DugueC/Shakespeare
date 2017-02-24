package phrases;

import java.util.ArrayList;

public class Niveau {
	private int niveau;
	private ArrayList<Regle> regles;
	private int sommeCompteurs;
	private int[] erreurs;
	
	public Niveau(int niveau){
		this.niveau = niveau;
		regles = new ArrayList<Regle>();
		sommeCompteurs=0;
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
	
	public int getSommeCompteurs(){
		return sommeCompteurs;
	}
	public void majSommeCompteurs(){
		sommeCompteurs = 0;
		for(Regle r : regles){
			sommeCompteurs += r.getCompteur();
		}
	}
	public void resetCompteurs(){
		sommeCompteurs = 0;
		for(Regle r : regles){
			r.setCompteur(0);
		}
	}
	
	public void initialiseErreurs(){
		this.erreurs = new int[regles.size()];
		for(int i : erreurs){
			i=0;
		}
	}
	
	public void AjoutErreur(String regle){
		for(int i = 0; i<regles.size();i++){
			if(regles.get(i).getRegle().equals(regle)){
				erreurs[i]++;
				System.out.println(regle + " : " + erreurs[i]);
			}
		}
	}
	
	public int[] getErreurs(){
		return erreurs;
	}
}
