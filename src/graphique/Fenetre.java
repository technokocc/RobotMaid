package graphique;

import appart.IAppart;
import configs.SimulationParameters;
import data.IReadService;
import geometrie.Vecteur;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Fenetre {

	private IAppart a ;
	private ImageView im, robotAvatar;
	private Image robotImage ;
	private Group panel ;
	
	private IReadService data ; 
	
	
	public Fenetre(IAppart a, Image im) {
		super();
		this.a = a;
		this.im = new ImageView(im) ;			
	}

	public void dataReadService(IReadService data){
		this.data = data ;
	}
	
	public Parent getPanel(){							
		
		initAvatar();
		this.robotAvatar = new ImageView(this.robotImage) ;
		
		Circle robot1 = new Circle(data.getRobotPosition().getX(), data.getRobotPosition().getY(), 15, Color.BLACK) ;			
			
		
		robotAvatar.setTranslateX(data.getRobotPosition().getX());
		robotAvatar.setTranslateY(data.getRobotPosition().getY());						
		
	    robotAvatar.setScaleX(1);
	    robotAvatar.setScaleY(1);
		
	    Text pauseTexte = (data.dataPlay()) ?
	    		new Text(0,0,"") : 
	    			new Text(SimulationParameters.PAUSE_POSITION_X,SimulationParameters.PAUSE_POSITION_Y, "Pause");
	    		
		pauseTexte.setFont(new Font(120));
		
	    
		Text infosTitle = new Text(SimulationParameters.INFOS_POSITION_X+100,SimulationParameters.INFOS_POSITION_Y+50, "Informations");
		infosTitle.setFont(new Font(30));
		
		Text logTitle = new Text(SimulationParameters.INFOS_POSITION_X+130,SimulationParameters.LOG_POSITION_Y+50, "Les Logs");
		logTitle.setFont(new Font(30));
		
		Text batterieInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,SimulationParameters.INFOS_POSITION_Y+100, "Battérie : "+data.getRobotBatterie()+" %");
		batterieInfos.setFont(new Font(15));
		
		Text positionInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,
				SimulationParameters.INFOS_POSITION_Y+150, "Position : " + data.getRobotPosition().toString());
		positionInfos.setFont(new Font(15));
		
		Text directionInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,
				SimulationParameters.INFOS_POSITION_Y+200, "Direction : " + data.getRobotDirection().toString());
		directionInfos.setFont(new Font(15));			
		
		Text pourcentageInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,
				SimulationParameters.INFOS_POSITION_Y+250, "Pourcentage : " + (int)data.getPourcentage() + " %");
		pourcentageInfos.setFont(new Font(15));		
		
		panel = new Group();						
		panel.getChildren().addAll(im,getInfos(),getLog(),pauseTexte,infosTitle,logTitle,batterieInfos,positionInfos,directionInfos,pourcentageInfos) ;						
		
		int j = 0 ;
		
		for(String message : data.getRobotLogs() ){

			Text logLine = new Text(SimulationParameters.LOG_POSITION_X+20,
					SimulationParameters.LOG_POSITION_Y+100+(15*j++), message);
			logLine.setFont(new Font(15));
			panel.getChildren().add(logLine) ;
		}
		
		for(Vecteur point : data.getTrajet()){
			Rectangle rect = new Rectangle(point.getX(), point.getY(), 49, 49);
			rect.setFill(Color.WHITE);
			panel.getChildren().add(rect) ;
		}
		
		panel.getChildren().add(robotAvatar);
		
		return panel ;
	}
	
	
	public void initAvatar(){
		if(data.getRobotDirection().equals(new Vecteur(-1, 0)))
			this.robotImage = new Image("file:ImageAppart/imageRobotMiroir.jpg") ;
		else
			this.robotImage = new Image("file:ImageAppart/imageRobot.jpg") ;
	}
	
	
	public Rectangle getLog(){
		Rectangle cadreLog = new Rectangle(SimulationParameters.LOG_POSITION_X,SimulationParameters.LOG_POSITION_Y,
				SimulationParameters.LOG_RECT_WIDTH,SimulationParameters.LOG_RECT_HEIGHT) ;
		cadreLog.setFill(Color.WHITE);
		cadreLog.setStroke(Color.BLACK);
		cadreLog.setStrokeWidth(5);
	    cadreLog.setArcWidth(20);
	    cadreLog.setArcHeight(20);
		return cadreLog ;
	}

	public Rectangle getInfos(){			
		
		Rectangle cadreInfos = new Rectangle(SimulationParameters.INFOS_POSITION_X,SimulationParameters.INFOS_POSITION_Y,
				SimulationParameters.INFOS_RECT_WIDTH,SimulationParameters.INFOS_RECT_HEIGHT) ;
		cadreInfos.setFill(Color.WHITE);
		cadreInfos.setStroke(Color.BLACK);
		cadreInfos.setStrokeWidth(5);
		cadreInfos.setArcWidth(20);
		cadreInfos.setArcHeight(20);
				
		return cadreInfos ;
	}
	
	public ImageView getRobot(){
		this.robotAvatar.setFitWidth(20);
		this.robotAvatar.setTranslateX(500);
		this.robotAvatar.setTranslateY(500);
		return this.robotAvatar ;
	}

}
