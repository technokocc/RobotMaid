package strategie;

import robot.Commande;

public interface Strategy {

	public Commande getCommande();
	public String toString();
}
