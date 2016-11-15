package geometrie;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;


public class TerrainTools {

	public TerrainTools(){
		
	}
	
	public static Terrain terrainFromChar(char c) throws TerrainException{
		
		
		int i = 0 ;
		
		while(i < Terrain.conversion.length && Terrain.conversion[i] != c) i++ ;
		
		if( Terrain.conversion[i] != c ) throw new TerrainException();
		
		return Terrain.values()[i] ;
		
	}
	
	public static char charFromTerrain(Terrain c){
		
		return Terrain.conversion[c.ordinal()] ;
	}
	
	public static Color terrainToRGB(Terrain c){
		
		return Terrain.convColor[c.ordinal()];
	}
	
	public static boolean isRunnable(Terrain t){
		
		if(t.equals(Terrain.Piece) || t.equals(Terrain.Mur) || t.equals(Terrain.Obstacle) || t.equals(Terrain.BandeTour) ) return false;
		
		return true;
	}
	
	public static Image imageFromAppart(Terrain[][] track){
		
        int nColonnes = track[0].length;
        int nLignes =  track.length;
        
        BufferedImage im = 
                new BufferedImage(nColonnes, nLignes, BufferedImage.TYPE_INT_ARGB);                      
        
        for(int i = 0; i< nLignes ; i++){
        	
        	for(int j = 0 ; j< nColonnes ; j++){
        		
        		im.setRGB(j, i,  terrainToRGB(track[i][j]).getRGB());
        	
        	}
        }
        
        WritableImage image = new WritableImage(im.getWidth(), im.getHeight()) ;
        
        SwingFXUtils.toFXImage(im, image) ;
       
        System.out.println("Bufff" + image.getHeight());
        
        return image ;
	}
	
}
