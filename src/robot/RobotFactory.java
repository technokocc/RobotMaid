package robot;

import geometrie.Vecteur;
import graphique.SimulationParameters;

public class RobotFactory {

	public static IRobot getRobotMaid(String name, String role){
		return new RobotMaid(name,role,1.0, 
				new Vecteur(SimulationParameters.ROBOT_X_INITIAL, SimulationParameters.ROBOT_Y_INITIAL),
				new Vecteur(190, 400)) ;
	}
}
