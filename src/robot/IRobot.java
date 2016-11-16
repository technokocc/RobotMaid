package robot;

import geometrie.Vecteur;

public interface IRobot {
	
	/**
	 * @param c : La commande (la vitesse et l'angle de rotation)
	 * La vitesse est maximale s'il ne detecte pas d'obstacles.
	 * La rotation est nulle si on veut aller tout droit.	
	 */
	public void action(Commande c) ;
	
	
	/**	 
	 * @return : la vitesse courrante du robot.
	 */
	public double getVitesse();
	
	
	/**	
	 * @return : La position du robot.
	 */
    public Vecteur getPosition();
    
    
    /**    
     * @return : La direction : le déplacement est naturel.    
     */
    public Vecteur getDirection();
       
    
    public double getBraquage();
    
    public String getName();
    public String getRole();
}
