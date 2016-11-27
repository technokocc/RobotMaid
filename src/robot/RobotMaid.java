package robot;

import geometrie.Vecteur;

public class RobotMaid implements IRobot {

	private String name ;
	private String role ;
	private double vitesse ;
	private Vecteur position;
	private Vecteur direction;

	public RobotMaid(String name, String role, double vitesse, Vecteur position, Vecteur direction) {
		super();
		this.name = name;
		this.role = role;
		this.vitesse = vitesse;
		this.position = position;
		this.direction = direction;
	}

	public void action(Commande c){
// TODO faire un dessin de l'algo pour determiner le meilleur chemin
		this.vitesse = c.getAcc();
		double turn = c.getTurn();
		Vecteur vec = this.getVecteurAvecTurnCommande(turn);
		this.direction = this.getPosition().additionNewVect(vec);
		//this.direction = vec;
		this.position.additionCour(vec);// deplacement lineaires
	}

	@Override
	public double getVitesse() {
		// TODO Auto-generated method stub
		return this.vitesse;
	}

	@Override
	public Vecteur getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public Vecteur getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	public String toString(){
		return "My name is : "+name+". I am a Robot Maid and my role is : "+role ;
	}

	@Override
	public double getBraquage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getRole() {
		return this.role;
	}
	
	private Vecteur getVecteurAvecTurnCommande(double turn){
		if(turn == 0){
			return new Vecteur(0,0);
		}
		if(turn == 1){
			return new Vecteur(1,0);
		}
		
		return new Vecteur(0,0);		
	}
}
