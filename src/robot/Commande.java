package robot;

public class Commande {

	private double acc ;
	private double turn ;
	
	public Commande(double acc, double turn) {
		
		this.acc = acc;
		this.turn = turn;
	}
	
	public double getAcc() {
		return acc;
	}
	
	public double getTurn() {
		return turn;
	}
}
