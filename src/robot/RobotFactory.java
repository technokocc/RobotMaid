package robot;

import geometrie.Vecteur;

public class RobotFactory {

	public static IRobot getRobotMaid(String name, String role){
		return new RobotMaid(name,role,1.0, new Vecteur(190, 400), new Vecteur(190, 400)) ;
	}
}
