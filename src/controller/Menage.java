package controller;

import java.util.Timer;
import java.util.TimerTask;

import data.IData;
import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import robot.RobotException;

public class Menage implements IMenageService, IRequireDataService{

	private Timer menageClock;
	private IData data ;
	private Vecteur next ;
	
	public Menage(){	
		next = new Vecteur(0,0) ;
	}
	
	public void bindDataService(IData data){
		this.data = data ;
	}
	
	@Override
	public void init() {
		this.menageClock = new Timer();			
		
	}

	@Override
	public void start() {
	
		this.menageClock.schedule(new TimerTask() {
			
			@Override
			public void run() {							
				
				try {
					
					double x = data.getRobotPosition().getX() ;
					x = (x <= 1045) ? x : 1040 ;
					
					double y = data.getRobotPosition().getY() ;				
					
					next = new Vecteur(y,x) ;
					
					if(TerrainTools.isRunnable(data.getTerrain(next)))
						data.doAction();
					else
						System.out.println("Obstacle rencontré "+ data.getTerrain((int)next.getX(), (int)next.getY()));
					
				} catch (RobotException e) {

					e.printStackTrace();
				}				
			}
		},0,100);
	}

	@Override
	public void stop() {
		menageClock.cancel();
	}

	
}
