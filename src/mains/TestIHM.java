package mains;

import java.io.IOException;

import algorithme.IRadar;
import algorithme.IStrategy;
import algorithme.RadarClassique;
import algorithme.StrategyRadar;
import appart.AppartFactoryFromFile;
import appart.IAppart;
import configs.SimulationParameters;
import controller.IMenageService;
import controller.Menage;
import data.Data;
import data.IData;
import geometrie.TerrainTools;
import graphique.Fenetre;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
		appartement = AppartFactoryFromFile.build("fichiers/terrain.txt") ;
		robot = RobotFactory.getRobotMaid("YAMADO", "Robot Maid") ;	
		fen = new Fenetre(appartement,TerrainTools.imageFromAppart(appartement.getMatrix()));	
		data = new Data() ;
		menage =  new Menage() ;
		
		radar = new RadarClassique(robot, appartement, SimulationParameters.theta) ;
		strategie= new StrategyRadar(robot,radar);
		
		data.init(robot,appartement,strategie);
		menage.init();
		
		((Menage)menage).bindDataService(data);
		fen.dataReadService(data);
		
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
