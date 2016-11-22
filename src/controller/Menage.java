package controller;

import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import appart.AppartFactoryFromFile;
import appart.IAppart;
import geometrie.Terrain;
import geometrie.Vecteur;
import robot.Commande;
import robot.IRobot;
import robot.RobotFactory;
import robot.RobotMaid;
import strategie.Strategy;

public class Menage implements IMenageService, IRequireDataService{

	private Timer menageClock;
	private IRobot robot;
	private IAppart appart;
	private Strategy strategy;

	
	public Menage(){
		
	}
	
	@Override
	public void init() {

		this.menageClock = new Timer();
		this.robot = RobotFactory.getRobotMaid("R2-D2", "menage");
		try {
			this.appart = AppartFactoryFromFile.build("fichiers/terrain.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void start() {
		
		this.menageClock.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO action a affectuer pour le robot
				//strategy.getCommande();
				Vecteur robotVec = robot.getPosition();
				robot.action(new Commande(1, 1));// tout droit vitesse constante
				
				Terrain ter =  appart.getTerrain(robotVec);
				System.out.println(ter);
				System.out.println(robotVec);
				
				//appart.get
				
			}
		}, 0,100);// penser a mettre 0 avant 100

	}

	@Override
	public void stop() {
		
		this.menageClock.cancel();
		
	}
	
	public void allerAgauche(){
		
		Vecteur v = robot.getPosition();
		v.setX(v.getX() - 1);
		Terrain ter =  appart.getTerrain(v);
		if(ter == Terrain.Couloir){
			
		}
		
	}
	
//	public void bindDataService(IDataService service){}

	
}
