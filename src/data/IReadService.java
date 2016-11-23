package data;

import java.util.ArrayList;

import algorithme.IStrategy;
import geometrie.Terrain;
import geometrie.Vecteur;

public interface IReadService {
	
	//getter RObotMaid
	public Vecteur getRobotPosition();
	public Vecteur getRobotDirection();
	public String getRobotName();
	public String getRobotRole();
	public double getRobotVitesse();
	//getter AppartImpl
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
	
	// Strategie
	public IStrategy getStrategie() ;
}
