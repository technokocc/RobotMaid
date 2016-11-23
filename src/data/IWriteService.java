package data;

import geometrie.Vecteur;

public interface IWriteService {

	public Vecteur setRobotPosition(Vecteur position);
	public Vecteur setRobotDirection(Vecteur direction);
	public String setRobotName(String name);
	public String setRobotRole(String role);
	public double setRobotVitesse(double vitesse);	
	
}
