package data;

import java.util.ArrayList;

import algorithme.IStrategy;
import appart.IAppart;
import geometrie.Terrain;
import geometrie.Vecteur;

public interface IReadService {
	
	public boolean dataPlay() ;
	
	//getter RObotMaid
	public Vecteur getRobotPosition();
	public Vecteur getRobotDirection();
	public String getRobotName();
	public String getRobotRole();
	public double getRobotVitesse();
	public double getRobotBatterie();
	public void setRobotBatterie(double batterie);
	public ArrayList<String> getRobotLogs();
	//getter AppartImpl
	public IAppart getAppart();
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
	public ArrayList<Vecteur> getTrajet();
	public double getPourcentage();
	// Strategie
	public IStrategy getStrategie() ;
	
}
