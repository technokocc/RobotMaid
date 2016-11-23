package graphique;

import appart.IAppart;
import configs.SimulationParameters;
import data.IReadService;
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
	private int y = 500 ;
	
	
	private IReadService data ; 

	
	public Fenetre(IAppart a, Image im) {
		super();
		this.a = a;
		this.im = new ImageView(im) ;
		panel = new Group() ;
		this.robotImage = new Image("file:ImageAppart/aspirateur.jpg") ;
		this.robotAvatar = new ImageView(this.robotImage) ;
		
	}

	public void dataReadService(IReadService data){
		this.data = data ;
	}
	
	public Parent getPanel(){				
		
		Circle robot1 = new Circle(data.getRobotPosition().getX(), data.getRobotPosition().getY(), 5, Color.YELLOW) ;			
			
		robotAvatar.setTranslateX(data.getRobotPosition().getY());
		robotAvatar.setTranslateY(data.getRobotPosition().getX());
		
	    robotAvatar.setScaleX(0.35);
	    robotAvatar.setScaleY(0.35);
		
		Text infosTitle = new Text(SimulationParameters.INFOS_POSITION_X+100,SimulationParameters.INFOS_POSITION_Y+50, "Informations");
		infosTitle.setFont(new Font(30));
		
		Text logTitle = new Text(SimulationParameters.INFOS_POSITION_X+130,SimulationParameters.LOG_POSITION_Y+50, "Les Logs");
		logTitle.setFont(new Font(30));
		
		Text batterieInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,SimulationParameters.INFOS_POSITION_Y+100, "Battérie : 100%");
		batterieInfos.setFont(new Font(15));
		
		Text positionInfos = new Text(SimulationParameters.INFOS_POSITION_X+20,
				SimulationParameters.INFOS_POSITION_Y+150, "Position : " + data.getRobotPosition().toString());
		positionInfos.setFont(new Font(15));
		
		panel = new Group();
		panel.getChildren().addAll(im,robot1,getInfos(),getLog(),infosTitle,logTitle,batterieInfos,positionInfos) ;		
		return panel ;
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
