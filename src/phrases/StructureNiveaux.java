package phrases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class StructureNiveaux {
	
	ArrayList<Niveau> niveaux;

	public StructureNiveaux(String f){
		niveaux = new ArrayList<Niveau>();
		load(f);
	}
	
	private void load(String f){
		int niveau;
		String regle;
		String texte;
		String reponses;
		String correction;
		
		try{
			FileReader fichier = new FileReader(f);
			BufferedReader filtre = new BufferedReader(fichier);
			String ligne = filtre.readLine();
			ligne = filtre.readLine();
			
			// on regarde toutes les lignes
			while (ligne != null) {
				
				//scan
				Scanner filtre2 = new Scanner(ligne);
				filtre2.useDelimiter(";");
				
				//informations
				niveau = Integer.parseInt(filtre2.next());
				regle = filtre2.next();
				texte = filtre2.next();
				reponses =  filtre2.next();
				correction = filtre2.next();
				ajouter(niveau,regle,texte, reponses, correction);
					
				// on lit la prochaine ligne
				ligne = filtre.readLine();
				filtre2.close();
			}
			
			filtre.close();
			fichier.close();
		}
		catch (IOException e){
			System.out.println("error : "+ e);
		}
	}
	
	private void ajouter(int niveau, String regle, String texte, String reponse, String correction) {
		// ajout niveau
		Niveau niv = null;
		for(Niveau n : niveaux){
			if(n.getNiveau() == niveau){
				niv = n;
			}
		}
		if(niv == null){
			niv = new Niveau(niveau);
			niveaux.add(niv);
		}
		
		// ajout regle
		Regle reg = null;
		for(Regle r : niv.getRegles()){
			if(r.getRegle()==regle){
				reg = r;
			}
		}
		if(reg == null){
			reg = new Regle(regle);
			niv.ajouter(reg);
		}
		
		reg.ajouter(texte,reponse,correction);
	}
	
	public Niveau getNiveau(int num){
		return niveaux.get(num);
	}
	
	public ArrayList<Niveau> getNiveaux(){
		return niveaux;
	}

}