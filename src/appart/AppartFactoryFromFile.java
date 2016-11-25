package appart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;

public class AppartFactoryFromFile {

	public static AppartImpl build(String filename) throws FileNotFoundException{
		
		Terrain[][] terrain =null;
		int nbColonnes , nbLignes;
		
		Vecteur depart=null ;
		Vecteur dirD = new Vecteur(-1,0) ;
		Vecteur dirA = new Vecteur(-1,0) ;
		
		File fichier = new File(filename);
		InputStream file = new FileInputStream(fichier);
		
		 try {
			 			 
			 InputStreamReader fr = new InputStreamReader(file);
			 BufferedReader in = new BufferedReader(fr);
			 
			 String buf = in.readLine(); 
			 nbColonnes = Integer.parseInt(buf);

			 buf = in.readLine();
			 nbLignes = Integer.parseInt(buf);
			
		   
			 terrain = new Terrain[nbLignes][nbColonnes];
		     
			 for(int i = 0 ; i < nbLignes ; i++){
			   
			   buf = in.readLine();
			   
			   if (buf == null || buf.length() != nbColonnes) throw new LectureException();
			   
			   for(int j = 0 ; j <nbColonnes ; j++){				
				   terrain[i][j] = TerrainTools.terrainFromChar(buf.charAt(j));				   				  
			   }
			 }
			 		 
		   in.close();
		
		 }catch (Exception e) {
		   e.printStackTrace();
		   System.err.println("Invalid Format : " + file
		            + "... Loading aborted");
		 }
		 
		 return new AppartImpl(terrain,depart,dirD,dirA,filename);
		
		}
}
