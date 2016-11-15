package graphique;

import appart.IAppart;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fenetre {

	private IAppart a ;
	private ImageView im ;
	private Group panel ;
	
	public Fenetre(IAppart a, Image im) {
		super();
		this.a = a;
		this.im = new ImageView(im) ;
		panel = new Group() ;
	}

	public Parent getPanel(){
				
		this.panel.getChildren().add(im) ;		
		return this.panel ;
	}


}
