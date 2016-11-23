package controller;

import java.util.Timer;
import java.util.TimerTask;

import data.IData;
import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;

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
		// TODO Auto-generated method stub
		this.menageClock = new Timer();			
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		this.menageClock.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println(data.getRobotPosition().toString());
				
				double x = data.getRobotPosition().getX()+10 ;
				x = (x <= 1045) ? x : 1040 ;
				
				double y = data.getRobotPosition().getY()+5 ;				
				
				next = new Vecteur(y,x) ;
				
				if(TerrainTools.isRunnable(data.getTerrain(next)))
					data.setRobotPosition(new Vecteur(data.getRobotPosition().getX()+5,data.getRobotPosition().getY())) ;
				else
					System.out.println("Obstacle rencontré "+ data.getTerrain((int)next.getX(), (int)next.getY()));
			}
		},0,100);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		menageClock.cancel();
	}

	
}
