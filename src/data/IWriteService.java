package data;

import geometrie.Vecteur;

public interface IWriteService {

	public void setdataPlay(boolean state);
	public void setRobotPosition(Vecteur position);
	public void setRobotDirection(Vecteur direction);
	public void setRobotName(String name);
	public void setRobotRole(String role);
	public void setRobotVitesse(double vitesse);
	public void addRobotLog(String message);
	public void addTrajet(Vecteur v) ;
	public void setPourcentage(double pourcentage);
}
