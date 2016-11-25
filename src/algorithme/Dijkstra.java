package algorithme;

import geometrie.TerrainTools;
import geometrie.Vecteur;
import javafx.scene.image.Image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

import appart.IAppart;

public class Dijkstra {

	private IAppart appart ;
	private double[][] dist ;
	private Vecteur current ;
	private ComparatorDijk comp ;
	private ArrayList <Vecteur> q ;

	public Dijkstra(IAppart appart ) {
		
		super();
		this.appart = appart;
		this.dist = new double [appart.getWidth()][appart.getHeight()];
		this.comp =  new ComparatorDijk(dist);
		this.q = new ArrayList <Vecteur> (1000);
	}

	public void compute(){

		Vecteur s ;
		Image ima = TerrainTools.imageFromAppart(appart.getMatrix());

		for(int i=0 ; i < dist.length ; i++ )
			for(int j=0 ; j < dist[0].length ; j++) 
				dist[i][j] = Double.POSITIVE_INFINITY;

		for(Vecteur p : appart.getArrivees()){
			dist[(int) p.getX()][(int)p.getY()] = 0 ;
			q.add(p);
		}

		while(!q.isEmpty()) {

			current = Collections.min(q, comp);	

			for(int i = (int) (current.getX()-1) ; i <= (int) current.getX()+1 ; i++){
				for(int j = (int) (current.getY()-1) ; j <= (int) current.getY()+1 ; j++){

					s= new Vecteur(i,j);

					Vecteur delta = new Vecteur(current,s);

					if(!TerrainTools.isRunnable(appart.getTerrain(s))) continue ;

					if(dist[(int)current.getX()][(int)current.getY()] == 0 && delta.produitScalaire(appart.getDirectionArrivee()) > 0 ) continue ;

					double score = dist[(int)current.getX()][(int)current.getY()] + delta.norme();// 10 ou 14

					if(dist[i][j] > score){
						if(dist[i][j] == Double.POSITIVE_INFINITY) q.add(s);
						dist[i][j] = score;
					}
				}
			}

			q.remove(current);
		}

//		for(int i = 0 ; i < dist.length ; i++)
//			for(int j = 0 ; j < dist[0].length ; j++)
//				if(TerrainTools.isRunnable(c.getTerrain(new Vecteur(i,j))))
//					im.setRGB(j,i, new Color((int)dist[i][j]%255, 0 , 0).getRGB());

//		ImageIO.write(im, "png", new File("ImageCircuit/Circuit3_Dijkstra.png"));
	}
	
	public double getTabdist(int i , int j){
		return dist[i][j];
	}

}