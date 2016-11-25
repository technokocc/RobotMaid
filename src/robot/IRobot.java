package robot;

import java.util.ArrayList;

import geometrie.Vecteur;

public interface IRobot {
	
	public void action(Commande c) throws RobotException;
	
	public double getVitesse();
		
    public Vecteur getPosition();    
    
    public void setPosition(Vecteur position) ;
    
    public void setVitesse(Double vitesse) ;
    
    public void setDirection(Vecteur direction) ;
    
    public double getMaxTurn() ;
    
    public Vecteur getDirection();
       
    public ArrayList<String> getLog() ;
    
    public void setLog(String message) ;
    
    public ArrayList<Vecteur> getTrajet();
    
    public void setTrajet(Vecteur position) ;
    
    public double getBraquage();
    
    public String getName();
    
    public String getRole();
    
    public double getBatterie();
    
    public void setBatterie(double batterie) ;
}
