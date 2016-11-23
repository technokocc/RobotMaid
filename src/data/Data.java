package data;

import java.util.ArrayList;

import appart.IAppart;
import geometrie.Terrain;
import geometrie.Vecteur;
import robot.IRobot;

public class Data implements IData{
	private IRobot robot;
	private IAppart plan;
	private String lienPlan;
	
	public Data(){
		
	}
	
	@Override
	public void init(IRobot robot, IAppart plan) {
		this.robot = robot ; 
		this.plan = plan ;
	}
		
	@Override
	public Vecteur getRobotPosition() {
		return robot.getPosition();
	}
	@Override
	public Vecteur getRobotDirection() {
		return robot.getDirection();
	}
	@Override
	public String getRobotName() {
		return robot.getName();
	}
	@Override
	public String getRobotRole() {
		return robot.getRole();
	}
	@Override
	public double getRobotVitesse() {
		return robot.getVitesse();
	}
	@Override
	public Vecteur setRobotPosition(Vecteur position) {
		// TODO Auto-generated method stub
		this.robot.setPosition(position);
		return null;
	}
	@Override
	public Vecteur setRobotDirection(Vecteur direction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setRobotName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setRobotRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double setRobotVitesse(double vitesse) {
		// TODO Auto-generated method stub
		return 0;
	}
//################################# Getter AppartImpl ###########################""""
	@Override
	public Terrain getTerrain(int i, int j) {
		return plan.getTerrain(i, j);
	}

	@Override
	public Terrain getTerrain(Vecteur v) {
		return plan.getTerrain(v);
	}

	@Override
	public Vecteur getPointDepart() {
		return plan.getPointDepart();
	}

	@Override
	public Vecteur getDirectionDepart() {
		return plan.getDirectionDepart();
	}

	@Override
	public Vecteur getDirectionArrivee() {
		return plan.getDirectionArrivee();
	}

	@Override
	public int getWidth() {
		return plan.getWidth();
	}

	@Override
	public int getHeight() {
		return plan.getHeight();
	}

	@Override
	public ArrayList<Vecteur> getArrivees() {
		return plan.getArrivees();
	}

	@Override
	public double getDist(int i, int j) {
		return plan.getDist(i, j);
	}

	@Override
	public Terrain[][] getMatrix() {
		return plan.getMatrix();
	}

	@Override
	public String getName() {
		return plan.getName();
	}
	
	public String getLienPlan() {
		return lienPlan;
	}
	
	public void setLienPlan(String s) {
		lienPlan = s;
	}

}
