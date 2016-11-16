package mains;

import java.io.IOException;

import appart.AppartFactoryFromFile;
import appart.IAppart;
import geometrie.TerrainTools;
import graphique.Fenetre;
import graphique.SimulationParameters;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import robot.IRobot;
import robot.RobotException;
import robot.RobotFactory;

public class TestIHM extends Application{

	public static void main(String[] args) throws RobotException, IOException {

		double [] theta = {0 ,-Math.PI/2,-Math.PI/3, -Math.PI/6, -Math.PI/12,-Math.PI/20,-Math.PI/25,-Math.PI/30,Math.PI/30, 
				-Math.PI/25,Math.PI/20, Math.PI/12, Math.PI/6, Math.PI/3,Math.PI/2 };					
				
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		IAppart a = AppartFactoryFromFile.build("fichiers/terrain.txt") ;
		IRobot r = RobotFactory.getRobotMaid("YAMADO", "Robot Maid") ;		
		Fenetre fen = new Fenetre(a,TerrainTools.imageFromAppart(a.getMatrix()));	
		final Scene scene = new Scene(fen.getPanel());
		primaryStage.setScene(scene);
		primaryStage.setWidth(SimulationParameters.WINDOW_WIDTH);
		primaryStage.setHeight(SimulationParameters.WINDOW_HEIGHT);
		primaryStage.setResizable(SimulationParameters.WINDOW_RESIZABLE);
		primaryStage.setTitle(SimulationParameters.WINDOW_TILE);
		primaryStage.show();
	}

}
