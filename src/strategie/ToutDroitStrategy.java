package strategie;

import robot.Commande;

public class ToutDroitStrategy implements Strategy{

	@Override
	public Commande getCommande() {		
		return new Commande(1,0);
	}

	public String toString(){
		return "Stratégie : Aller Tout Droit" ;
	}
}
