package robot;

import configs.SimulationParameters;
import geometrie.Vecteur;

public class RobotFactory {

	static final double[] tabVitesse     = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 4, 5};
    static final double[] tabTurn        = {1.,  0.9, 0.75, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05};
    static final double vmax = 4;
    static final double alpha_c =  0.005;
    static final double braquage = 0.1;
    static final double alpha_f = 0.0002;
    static final double beta_f = 0.0005;

    double vitesse = 0; // vitesse initiale

	public static IRobot getRobotMaid(String name, String role){
		return new RobotMaid(name,role,4, 
				new Vecteur(SimulationParameters.ROBOT_X_INITIAL, SimulationParameters.ROBOT_Y_INITIAL),
				new Vecteur(-1,0),tabVitesse, tabTurn,vmax,
				 alpha_c, braquage, alpha_f,beta_f) ;
	}
}
