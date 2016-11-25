package controller;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import data.IData;
import geometrie.Terrain;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import robot.RobotException;

public class Menage implements IMenageService, IRequireDataService{

	private Timer menageClock;
	private IData data ;
	private Vecteur next ;
	private boolean pause ;
	private boolean alert ;
	private int rapidite = 100 ;
	
	public Menage(){	
		next = new Vecteur(0,0) ;
		pause = false ;
		alert = false ;
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

				if(!pause){

					try {
						
						if(data.getPourcentage() >= 85 && !alert){
							JOptionPane.showMessageDialog(null, "RobotMaid : J'AI ATTEINT LES 85% DU PLAN.");
							alert = true ;
						}

						if(data.getTrajet().size() % 300 == 0 && data.getTrajet().size() >= 300){
							data.setRobotBatterie(data.getRobotBatterie()-1);
						}
						
						double x = data.getRobotPosition().getX() ;
						x = (x <= 1045) ? x : 1040 ;

						double y = data.getRobotPosition().getY() ;				

						next = new Vecteur(y,x) ;																															

						if(TerrainTools.isRunnable(data.getTerrain(next))){						
							data.doAction();
						}

						else{
							System.out.println("Obstacle rencontré "+ data.getTerrain((int)next.getX(), (int)next.getY()));

							if(data.getRobotDirection().equals(new Vecteur(1,0)))
								data.setRobotDirection(new Vecteur(-1, 0)); 

							else if(data.getRobotDirection().equals(new Vecteur(-1,0)))
								data.setRobotDirection(new Vecteur(1, 0));

							else if (data.getRobotDirection().equals(new Vecteur(0,1)))
								data.setRobotDirection(new Vecteur(0, -1));

							else if (data.getRobotDirection().equals(new Vecteur(0,-1)))
								data.setRobotDirection(new Vecteur(0, 1));
						}


					} catch (RobotException e) {

						e.printStackTrace();
					}			
				}

			}
		},0,this.rapidite);
	}

	public void setRapidite(){
		this.rapidite = this.rapidite+ 10 ;
	}
	
	public int getRapidite(){
		return this.rapidite ;
	}
	
	
	@Override
	public void stop() {		
		menageClock.cancel();
	}

	public void changeRobotDirection(Vecteur direction){
		data.setRobotDirection(direction) ;
	}

	public void pauseResume(){				
		
		if(!pause)
			pause = true ;
		
		else
			pause = false ;
		
		data.setdataPlay(!pause);
	}


}
