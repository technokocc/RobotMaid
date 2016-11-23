package mains;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import appart.AppartFactoryFromFile;
import appart.IAppart;
import geometrie.TerrainTools;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class MainImageAppart {

	public static void main(String[] args) throws IOException {


		IAppart c = AppartFactoryFromFile.build("fichiers/terrain.txt") ;
		Image im = TerrainTools.imageFromAppart(c.getMatrix());
		
		BufferedImage bimg =  new BufferedImage((int)im.getWidth(), (int)im.getHeight(), BufferedImage.TYPE_INT_ARGB) ;
		
		SwingFXUtils.fromFXImage(im, bimg) ;
		
		ImageIO.write(bimg, "png", new File("ImageAppart/"+c.getName()+".png"));
		/*Dom : test de mon code (package data classe data ..)
		 * Data d = new Data();
		d.setLienPlan("fichiers/terrain.txt");
		d.init();
		*/

	}

}
