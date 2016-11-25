package algorithme;


import robot.Commande;
import robot.IRobot;

public class StrategyRadar implements IStrategy {

	private IRadar radar ;
	private IRobot robot ;

	public StrategyRadar(IRobot robot  ,IRadar radar){

		this.robot = robot ;
		this.radar = radar ;

	}


	public Commande getCommande(){

		double angle = radar.thetas()[radar.getBestIndex()];
				
		double alpha = angle/robot.getBraquage() ;
		double maxturn = robot.getMaxTurn() ;

		double acc=1;
		
		double turn = Math.signum(alpha) * Math.min(Math.abs(alpha), maxturn) ;

		if( Math.abs(alpha) < 24*maxturn ){	
			acc = 1 ;
		}
		else
			acc = 0.5;

		if(robot.getVitesse() < 0.2)
			acc = 1;	
		
		return new Commande(acc,turn);
	}

	@Override
	public String nomStrategie() {
		return "Strategie_Radar";
	}

}
