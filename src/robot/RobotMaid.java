package robot;

import java.util.ArrayList;

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

	private double batterie ;
	
	private ArrayList<String> log ;
	private static ArrayList<Vecteur> trajet ;
	static int cmpt = 0 ;
	
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
		this.log = new ArrayList<String>();
		trajet = new ArrayList<Vecteur>();
		batterie = 100 ;
	}

	public void action(Commande c) throws RobotException{
		
		
		// VERIFICATIONS !!!

		// 1) Est ce que la rotation et l'accÃ©lÃ©ration sont entre -1 et 1

		if(c.getTurn() < -1 || c.getTurn() > 1) throw new RobotException("Turn -1 < turn < 1") ;

		if(c.getAcc() < -1 || c.getAcc() > 1) throw new RobotException("Accélération -1 < acc < 1");

		// 2) Est ce que la rotation demandÃ©e est compatible avec la vitesse actuelle
		//System.out.println(getMaxTurn()+" "+c.getTurn());
		if( getMaxTurn() < Math.abs(c.getTurn())) throw new RobotException("La rotation n'est pas compatible avec le vitesse actuelle") ;

		// approche normale
		// 1) gestion du braquage		

		direction.autoRotat(c.getTurn() * braquage); // modif de direction

		if(position.getX() == 188 && position.getY() == 610 )
			goUp();
		
		if(position.getX() == 188 && position.getY() == 574 )
			goRight();
		
		if(position.getX() == 700 && position.getY() == 574 )
			goUp();
		
		if(position.getX() == 700 && position.getY() == 570 )
			goLeft();
		
		if(position.getX() == 188 && position.getY() == 570 )
			goUp();
		
		if(position.getX() == 188 && position.getY() == 530 )
			goRight();
		
		if(position.getX() == 576 && position.getY() ==530)
			goUp();
		
		if(position.getX() == 576 && position.getY() == 490 )
			goLeft();		
		
		if(position.getX() == 188 && position.getY() == 490 )
			goUp();		
		
		if(position.getX() == 188 && position.getY() == 442 )
			goLeft();
		
		if(position.getX() == 8 && position.getY() == 442 )
			goUp();
		
		if(position.getX() == 8 && position.getY() == 430 )
			goRight();
		
		if(position.getX() == 700 && position.getY() == 430 )
			goUp();
		
		if(position.getX() == 700 && position.getY() == 390 )
			goLeft();
		
		if(position.getX() == 8 && position.getY() == 390 )
			goUp();
		
		if(position.getX() == 8 && position.getY() == 350 )
			goRight();
		
		if(position.getX() == 700 && position.getY() == 350 )
			goUp();
		
		if(position.getX() == 700 && position.getY() == 310 )
			goLeft();
		
		if(position.getX() == 8 && position.getY() == 310 )
			goUp();
		
		if(position.getX() == 8 && position.getY() == 294 )
			goRight();
		
		if(position.getX() == 700 && position.getY() == 294 )
			goUp();
		
		if(position.getX() == 700 && position.getY() == 270 )
			goLeft();
		
		if(position.getX() ==  520 && position.getY() == 270 )
			goUp();
		
		if(position.getX() ==  520 && position.getY() == 250 )
			goRight();
		
		if(position.getX() ==  700 && position.getY() == 250 )
			goUp();
		
		if(position.getX() ==  700 && position.getY() == 210 )
			goLeft();
		
		if(position.getX() ==  520 && position.getY() == 210 )
			goUp();
		
		if(position.getX() ==  520 && position.getY() == 190 )
			goRight();
		
		if(position.getX() ==  700 && position.getY() == 190 )
			goUp();
		
		if(position.getX() ==  700 && position.getY() == 154 )
			goLeft();
		
		if(position.getX() ==  688 && position.getY() == 154 )
			goUp();
		
		if(position.getX() ==  688 && position.getY() == 18 )
			goLeft();
		
		if(position.getX() ==  560 && position.getY() == 18 )
			goDown();
	
		if(position.getX() ==  560 && position.getY() == 38 )
			goRight();
	
		if(position.getX() ==  640 && position.getY() == 38 )
			goDown();
	
		if(position.getX() ==  640 && position.getY() == 78 )
			goLeft();
		
		if(position.getX() ==  560 && position.getY() == 78 )
			goDown();
		
		if(position.getX() ==  560 && position.getY() == 98 )
			goRight();
		
		if(position.getX() ==  640 && position.getY() == 98 )
			goDown();
		
		if(position.getX() ==  640 && position.getY() == 118 )
			goLeft();
		
		if(position.getX() ==  560 && position.getY() == 118 )
			goDown();
		
		if(position.getX() ==  560 && position.getY() == 138 )
			goRight();
		
		if(position.getX() ==  640 && position.getY() == 138 )
			goDown();
		
		if(position.getX() ==  640 && position.getY() == 154 )
			goLeft();
		
		if(position.getX() ==  400 && position.getY() == 154 )
			goDown();
		
		if(position.getX() ==  400 && position.getY() == 174 )
			goRight();
		
		if(position.getX() ==  560 && position.getY() == 174 )
			goDown();

		if(position.getX() ==  560 && position.getY() == 186 )
			goLeft();
		
		if(position.getX() ==  144 && position.getY() == 186 )
			goDown();
		
		if(position.getX() ==  144 && position.getY() == 190 )
			goLeft();
		
		if(position.getX() ==  8 && position.getY() == 190 )
			goDown();		

		if(position.getX() ==  8 && position.getY() == 230 )
			goRight();
		
		if(position.getX() ==  360 && position.getY() == 230 )
			goDown();
		
		if(position.getX() ==  360 && position.getY() == 270 )
			goLeft();
		
		if(position.getX() ==  8 && position.getY() == 270 )
			goUp();
		
		if(position.getX() ==  8 && position.getY() == 190 )
			goRight();
		
		if(position.getX() ==  148 && position.getY() == 190 )
			goUp();
		
		// 2.1) gestion des frottements

		vitesse -= alpha_f;
		vitesse -= beta_f*vitesse;

		// 2.2) gestion de l'acceleration/freinage

		vitesse += c.getAcc() * alpha_c;

		// 2.3) garanties, bornes...
		direction.toUnitVec(); // modif de direction

		vitesse = Math.max(0., vitesse); // pas de vitesse nÃ©gative
		vitesse = Math.min(vmax, vitesse);

		// 3) mise Ã  jour de la position
		
		position.additionCour(direction.scalaireMult(vitesse));						
		setTrajet(position);
		setLog(cmpt++ +" : Je vais tout droit :) Pas d'obstacle");
		removeOldLogs();		
	}

	private void goDown(){
		this.direction = new Vecteur (0,1) ;
		setLog(cmpt++ +" : Je vais en bas !!! Obstacle");
	}
	
	private void goUp(){
		this.direction = new Vecteur (0,-1) ;
		setLog(cmpt++ +" : Je vais en haut !!! Obstacle");
	}
	
	private void goRight(){
		this.direction = new Vecteur (1,0) ;
		setLog(cmpt++ +" : Je tourne à droite !!! Obstacle");
	}
	
	private void goLeft(){
		this.direction = new Vecteur (-1,0) ;
		setLog(cmpt++ +" : Je tourne à gauche !!! Obstacle");
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

	@Override
	public ArrayList<String> getLog() {
		return this.log;
	}

	@Override
	public void setLog(String message) {
		this.log.add(message) ;
	}

	@Override
	public ArrayList<Vecteur> getTrajet() {		
		return trajet;
	}

	@Override
	public void setTrajet(Vecteur position) {
		Vecteur nouv = position.clone() ;
		if(!trajet.contains(nouv)){
				trajet.add(nouv) ;			
		}				
	}

	@Override
	public double getBatterie() {
	return this.batterie ;
	}

	@Override
	public void setBatterie(double batterie) {
		this.batterie = batterie ;		
	} 

	private void removeOldLogs(){
		if(log.size() == 25)
			log = new ArrayList<String>();
		if(cmpt == 1000)
			cmpt = 0 ;
	}
	
}
