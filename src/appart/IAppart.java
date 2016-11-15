package appart;

import java.util.ArrayList;

import geometrie.Terrain;
import geometrie.Vecteur;

public interface IAppart {

	public Terrain getTerrain(int i, int j);
	public Terrain getTerrain(Vecteur v);
	public Vecteur getPointDepart();
	public Vecteur getDirectionDepart();
	public Vecteur getDirectionArrivee();
	public int getWidth();
	public int getHeight();
	public ArrayList<Vecteur> getArrivees();
	public double getDist(int i, int j);
	public Terrain [][] getMatrix();
	public String getName();
	
}
