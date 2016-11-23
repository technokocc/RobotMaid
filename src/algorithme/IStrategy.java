package algorithme;

import robot.Commande;

public interface IStrategy {
	
    public Commande getCommande();
    public String nomStrategie();
      
}
