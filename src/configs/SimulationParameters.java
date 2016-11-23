package configs;

public class SimulationParameters {

	public final static double WINDOW_WIDTH 		= 1500 ;
	public final static double WINDOW_HEIGHT 		= 900 ;
	public final static boolean WINDOW_RESIZABLE	= false ;
	public final static String WINDOW_TILE			= "YAMADO : Robot Maid" ;
	
	public final static double LOG_POSITION_X 		= 1060 ;
	public final static double LOG_POSITION_Y 		= 320 ;
	public final static double LOG_RECT_WIDTH 		= 400 ;
	public final static double LOG_RECT_HEIGHT 		= 500 ;
	
	public final static double INFOS_POSITION_X 	= 1060 ;
	public final static double INFOS_POSITION_Y 	= 10 ;
	public final static double INFOS_RECT_WIDTH 	= 400 ;
	public final static double INFOS_RECT_HEIGHT 	= 300 ;
	
	public final static double ROBOT_X_INITIAL		= 15 ;
	public final static double ROBOT_Y_INITIAL		= 170 ;
	
	//public final static double [] theta = {0 ,-Math.PI,-Math.PI/2,-Math.PI/3, -Math.PI/6, -Math.PI/12,-Math.PI/20,-Math.PI/25,-Math.PI/30,Math.PI/30, 
	//		-Math.PI/25,Math.PI/20, Math.PI/12, Math.PI/6, Math.PI/3,Math.PI/2,Math.PI };
	
	public final static double [] theta = {-Math.PI,0,Math.PI };
}
