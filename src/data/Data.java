package data;

import java.util.ArrayList;

import algorithme.IStrategy;
import appart.IAppart;
import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import robot.IRobot;
import robot.RobotException;

public class Data implements IData{
	private IRobot robot;
	private IAppart plan;
	private String lienPlan;
	private IStrategy strategie ;
	private ArrayList<Vecteur> trajet ;
	private boolean state ;
	private double percent ;

	public Data(){
		trajet = new ArrayList<Vecteur>();
	}

	@Override
	public void init(IRobot robot, IAppart plan,IStrategy strategie) {
		this.robot = robot ; 
		this.plan = plan ;
		this.strategie = strategie ;
		state = true ;
		percent = 0 ;
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
	public void setRobotPosition(Vecteur position) {
		this.robot.setPosition(position);		
	}
	@Override
	public void setRobotDirection(Vecteur direction) {
		robot.setDirection(direction);
	}
	@Override
	public void setRobotName(String name) {

	}

	@Override
	public void setRobotRole(String role) {

	}

	@Override
	public void setRobotVitesse(double vitesse) {

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


	/*###################################################################################################################"*/

	@Override
	public IStrategy getStrategie() {
		// TODO Auto-generated method stub
		return this.strategie;
	}

	@Override
	public void doAction() throws RobotException {	
		this.percent += (16*10) ;
		this.robot.action(this.strategie.getCommande());
	}

	@Override
	public ArrayList<Vecteur> getTrajet() {		
		return robot.getTrajet();
	}

	@Override
	public void addTrajet(Vecteur v) {		
		robot.setTrajet(v);

	}

	@Override
	public ArrayList<String> getRobotLogs() {
		return this.robot.getLog();
	}

	@Override
	public void addRobotLog(String message) {
		this.robot.setLog(message);		
	}

	@Override
	public double getRobotBatterie() {
		return robot.getBatterie() ;
	}

	@Override
	public void setRobotBatterie(double batterie) {
		robot.setBatterie(batterie);
	}

	@Override
	public boolean dataPlay() {
		return state ;
	}

	@Override
	public void setdataPlay(boolean state) {
		this.state = state ;
	}

	@Override
	public double getPourcentage() {
		return (this.percent * 100 / plan.getPourtencage()) ;
	}

	@Override
	public void setPourcentage(double pourcentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public IAppart getAppart() {
		return plan ;
	}

}
