package geometrie;

import java.awt.Color;

public enum Terrain {
	
		   Couloir, Piece, Mur, Obstacle, BandeTour,Eau;

		   public static char[] conversion =
		            {'c', 'p', 'm', 'o', 't','e'};

		   public static Color[] convColor = {Color.white, Color.gray,
		       Color.black, Color.DARK_GRAY,Color.MAGENTA,Color.BLUE};
		 
	
}
