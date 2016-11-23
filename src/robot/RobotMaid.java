package robot;

import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;


public class RobotMaid implements IRobot {

	private double[] tabVitesse;
	private double[] tabTurn; 
	private double vmax ;
	private final double alpha_c;
	private final double braquage;
	private final double alpha_f;
	private final double beta_f ;

	private String name ;
	private String role ;
	private double vitesse ;
	private Vecteur position;
	private Vecteur direction;

	public RobotMaid(String name, String role, double vitesse, Vecteur position, Vecteur direction,double[] tabVitesse, double[] tabTurn, double vmax,
			double alpha_c, double braquage, double alpha_f, double beta_f) {

		super();
		this.name = name;
		this.role = role;
		this.vitesse = vitesse;
		this.position = position;
		this.direction = direction;
		this.tabVitesse = tabVitesse;
		this.tabTurn = tabTurn;
		this.vmax = vmax;
		this.alpha_c = alpha_c;
		this.braquage = braquage;
		this.alpha_f = alpha_f;
		this.beta_f = beta_f;
	}

	public void action(Commande c) throws RobotException{
		
		
		// VERIFICATIONS !!!

		// 1) Est ce que la rotation et l'accélération sont entre -1 et 1

		if(c.getTurn() < -1 || c.getTurn() > 1) throw new RobotException("") ;

		if(c.getAcc() < -1 || c.getAcc() > 1) throw new RobotException("");

		// 2) Est ce que la rotation demandée est compatible avec la vitesse actuelle
		//System.out.println(getMaxTurn()+" "+c.getTurn());
		if( getMaxTurn() < Math.abs(c.getTurn())) throw new RobotException("") ;

		// approche normale
		// 1) gestion du volant

		direction.autoRotat(c.getTurn() * braquage); // modif de direction

		// 2.1) gestion des frottements

		vitesse -= alpha_f;
		vitesse -= beta_f*vitesse;

		// 2.2) gestion de l'acceleration/freinage

		vitesse += c.getAcc() * alpha_c;

		// 2.3) garanties, bornes...
		direction.toUnitVec(); // modif de direction

		vitesse = Math.max(0., vitesse); // pas de vitesse négative
		vitesse = Math.min(vmax, vitesse);

		// 3) mise à jour de la position

		position.additionCour(direction.scalaireMult(vitesse));
							
		
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
		return this.braquage ;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getRole() {
		return this.role;
	}

	@Override
	public void setPosition(Vecteur position) {
		this.position = position ;		
	}

	@Override
	public void setVitesse(Double vitesse) {
		// TODO Auto-generated method stub
		this.vitesse = vitesse ;
	}

	@Override
	public void setDirection(Vecteur direction) {
		// TODO Auto-generated method stub
		this.direction = direction ;
	}

	@Override
	public double getMaxTurn() {

		double res = 0 ;

		for(int i = 0 ; i < tabVitesse.length ; i++) 
			if(this.vitesse < tabVitesse[i]*vmax) return tabTurn[i] ;

		return res ;	
	}

}
