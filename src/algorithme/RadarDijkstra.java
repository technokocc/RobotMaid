package algorithme;

import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import robot.IRobot;
import appart.IAppart;

public class RadarDijkstra implements IRadar{

	private IRobot robot ;
	private IAppart appart ;
	private double[] faisceauAngle; 
	private final double eps = 0.1;


	public RadarDijkstra(IRobot robot, IAppart appart, double[] faisceauAngle) {

		super();
		this.robot = robot;
		this.appart = appart;
		this.faisceauAngle = faisceauAngle;
	}



	private double calcScores(double angle){

		Vecteur p = robot.getPosition().clone();

		Vecteur d = robot.getDirection().clone();

		Vecteur next = new Vecteur(p.getY(),p.getX()) ;
		
		p = next ;
		
		d.autoRotat(angle);

		int i , j ;

		double smin ;

		double score = Double.POSITIVE_INFINITY;

		while(TerrainTools.isRunnable(appart.getTerrain(p))){	

			p = p.additionNewVect((d.scalaireMult(eps)));		
			
			if(appart.getTerrain(p) == Terrain.Canape )
				return Double.POSITIVE_INFINITY ; 

			i = (int) p.getX();
			j = (int) p.getY();

			smin = appart.getDist(i, j);

			if(score >= smin) score = smin ;

		}	
		return score;
	}

	public double[] scores() {

		double [] res = new double[faisceauAngle.length] ;

		for(int i = 0 ; i < faisceauAngle.length ; i++ )
			res[i] = calcScores(faisceauAngle[i]);

		return res;
	}

	public int getBestIndex() {

		int index=0;
		double score [] = scores();
		double min = Double.POSITIVE_INFINITY ;

		for(int i = 0 ; i < faisceauAngle.length ; i++){

			if(score[i] < min){
				index = i ;
				min = score[i] ;
			}
		}
		return index;
	}

	public double[] thetas() {

		return faisceauAngle;
	}



	@Override
	public double[] distancesInPixels() {

		double res [] = this.scores();

		for(int i = 0 ; i < scores().length ; i++ )
			res[i]= res[i] * eps ;	

		return res;
	}
}



