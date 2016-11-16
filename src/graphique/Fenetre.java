package graphique;

import java.awt.CardLayout;
import java.awt.Robot;

import appart.IAppart;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Fenetre {

	private IAppart a ;
	private ImageView im, robotAvatar;
	private Image robotImage ;
	private Group panel ;
	
	public Fenetre(IAppart a, Image im) {
		super();
		this.a = a;
		this.im = new ImageView(im) ;
		panel = new Group() ;
		this.robotImage = new Image("file:ImageAppart/aspirateur.jpg") ;
		this.robotAvatar = new ImageView(this.robotImage) ;
	}

	public Parent getPanel(){				
		Circle robot = new Circle(500, 500, 20, Color.YELLOW) ;	
		
		robotAvatar.setTranslateX(500);
		robotAvatar.setTranslateY(500);
	    robotAvatar.setScaleX(0.35);
	    robotAvatar.setScaleY(0.35);
		
		Text infosTitle = new Text(SimulationParameters.INFOS_POSITION_X+100,50, "Informations");
		infosTitle.setFont(new Font(30));
		
		Text logTitle = new Text(SimulationParameters.INFOS_POSITION_X+130,SimulationParameters.LOG_POSITION_Y+50, "Les Logs");
		logTitle.setFont(new Font(30));
		
		
		this.panel.getChildren().addAll(im,robotAvatar,getInfos(),getLog(),infosTitle,logTitle) ;		
		return this.panel ;
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
