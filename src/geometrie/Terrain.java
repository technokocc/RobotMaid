package geometrie;

import java.awt.Color;

public enum Terrain {
	
		Canape, Siege, Table, Buffet, Visualisation,Jacozi,Mur,Espace,Endline;

	   public static char[] conversion =
	            {'c', 's', 't', 'b', 'v','j','m','e','a'};

	   public static Color[] convColor = {Color.BLACK, Color.YELLOW,
		       Color.black, Color.ORANGE,Color.MAGENTA,Color.BLUE,Color.RED,Color.LIGHT_GRAY,Color.GREEN};	   
		 	
}
