package mains;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import algorithme.IRadar;
import algorithme.IStrategy;
import algorithme.RadarClassique;
import algorithme.RadarDijkstra;
import algorithme.StrategyRadar;
import appart.AppartFactoryFromFile;
import appart.IAppart;
import configs.SimulationParameters;
import controller.IMenageService;
import controller.Menage;
import data.Data;
import data.IData;
import geometrie.TerrainTools;
import geometrie.Vecteur;
import graphique.Fenetre;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import robot.IRobot;
import robot.RobotException;
import robot.RobotFactory;

public class TestIHM extends Application{

	private static AnimationTimer timer;
	private static IAppart appartement ;
	private static IRobot robot ;
	private static Fenetre fen ;
	private static IData data ;
	private static IMenageService menage ;
	private static IRadar radar ;	
	private static IStrategy strategie ;
	
	public static void main(String[] args) throws RobotException, IOException {
		
		
		System.out.println("after start !");
		
		appartement = AppartFactoryFromFile.build("fichiers/planAppart.txt") ;
		robot = RobotFactory.getRobotMaid("YAMADO", "Robot Maid") ;	
		fen = new Fenetre(appartement,TerrainTools.imageFromAppart(appartement.getMatrix()));	
		data = new Data() ;
		menage =  new Menage() ;
		
		radar = new RadarClassique(robot, appartement, SimulationParameters.theta) ;
		strategie= new StrategyRadar(robot,radar);			
		
		((Menage)menage).bindDataService(data);
		fen.dataReadService(data);
		
		data.init(robot,appartement,strategie);
		menage.init();


		ThreadSocket thread = new ThreadSocket(menage);
		thread.start();
		
		launch(args);
		

		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		
		final Scene scene = new Scene(fen.getPanel());
		primaryStage.setScene(scene);
		
		primaryStage.setWidth(SimulationParameters.WINDOW_WIDTH);
		primaryStage.setHeight(SimulationParameters.WINDOW_HEIGHT);
		primaryStage.setResizable(SimulationParameters.WINDOW_RESIZABLE);
		primaryStage.setTitle(SimulationParameters.WINDOW_TILE);

		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		      @Override
		        public void handle(KeyEvent event) {
		          if (event.getCode()==KeyCode.LEFT)((Menage)menage).changeRobotDirection(new Vecteur(-1,0));
		          if (event.getCode()==KeyCode.RIGHT) ((Menage)menage).changeRobotDirection(new Vecteur(1,0));
		          if (event.getCode()==KeyCode.UP) ((Menage)menage).changeRobotDirection(new Vecteur(0,-1));
		          if (event.getCode()==KeyCode.DOWN) ((Menage)menage).changeRobotDirection(new Vecteur(0,1));
		          if (event.getCode()==KeyCode.P) ((Menage)menage).pauseResume();	
		          if (event.getCode()==KeyCode.R) ((Menage)menage).setRapidite();			          
		          event.consume();
		        }
		    });
		
		primaryStage.setOnShown(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				menage.start();
			}
		});

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {				
				menage.stop();
			}
		});
		
		primaryStage.show();
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				scene.setRoot(fen.getPanel());
			}
		};
		timer.start();
	}
	

	


}
