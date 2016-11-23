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
	
}
