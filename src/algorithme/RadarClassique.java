package algorithme;

import appart.IAppart;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import robot.IRobot;

public class RadarClassique implements IRadar {

	private IRobot robot ;
	private IAppart appart ;
	private double [] faisceauAngle ;
	private final double eps = 0.1;
	
	public RadarClassique(IRobot robot, IAppart appart, double [] faisceauAngle) {
		super();
		this.robot = robot;
		this.appart = appart;
		this.faisceauAngle = faisceauAngle ;
	}
	
	public double calcScores(double angle){	
		
		Vecteur p = robot.getPosition().clone();
		
		Vecteur d = robot.getDirection().clone();			
		
		d.autoRotat(angle);
		
		Vecteur next = new Vecteur(p.getY(),p.getX()) ;
		
		System.out.println("Position : "+p.toString());
		
		p = next ;
		
		int cpt = 0 ;
		
		while(TerrainTools.isRunnable(appart.getTerrain(p))){	
			cpt++;
			p = p.additionNewVect((d.scalaireMult(eps)));					
		}	

		return cpt ;
	}

	@Override
	public double[] scores() {
		
		double [] res = new double[faisceauAngle.length] ;
		
		for(int i = 0 ; i < faisceauAngle.length ; i++ )
			
			res[i] = calcScores(faisceauAngle[i]);
		
		return res;
	}

	@Override
	public double[] distancesInPixels() {
		
		double res [] = this.scores();
		
		for(int i = 0 ; i < scores().length ; i++ )
			
			res[i]= res[i] * eps ;	
		
		return res;
	}

	@Override
	public int getBestIndex() {
		
		int index=0;
		double max = 0 ;
		double [] score = scores();
		
		for(int i = 0 ; i < faisceauAngle.length ; i++){
			
			if(score[i] > max){
				index = i ;
				max = score[i] ;
			}
		}
		return index;
	}

	@Override
	public double[] thetas() {
		
		return faisceauAngle;
	}

}
