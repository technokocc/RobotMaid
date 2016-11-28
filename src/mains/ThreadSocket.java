package mains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import controller.IMenageService;
import controller.Menage;
import geometrie.Vecteur;

public class ThreadSocket implements Runnable{
    
	public enum Action{
        Left, Right, Up, Down, Pause;
    }

	private Thread thread;
	private IMenageService menage;
	
	
	public ThreadSocket(IMenageService menage){
		this.menage = menage;
	}
	
	public void start(){
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void serverSocket() throws IOException {
        ServerSocket listener = new ServerSocket(5000);
        BufferedReader reader =null;
        try {
            while (true) {
                Socket socket = listener.accept();
                System.out.println("je suis là !");
                try {
                	
                	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                	String res =  reader.readLine();
                	System.out.println(res);
                	
	  		        if (res.equals(Action.Left.toString())){
	  		        	System.out.println("gauche");
	  		        	((Menage)menage).changeRobotDirection(new Vecteur(-1,0));
	  		        }
	  		        if (res.equals(Action.Right.toString())){
	  		        	System.out.println("Droite");
	  		        	((Menage)menage).changeRobotDirection(new Vecteur(1,0));
	  		        }
	  		        if (res.equals(Action.Up.toString())){
	  		        	System.out.println("Haut");
	  		        	((Menage)menage).changeRobotDirection(new Vecteur(0,-1));
	  		        }
	  		        if (res.equals(Action.Down.toString())){
	  		        	System.out.println("Bas");
	  		        	((Menage)menage).changeRobotDirection(new Vecteur(0,1));
	  		        }
	  		        if (res.equals(Action.Pause.toString())){
	  		        	System.out.println("Pause");
	  		        	((Menage)menage).pauseResume();
	  		        }
	  		        /*if (event.getCode()==KeyCode.RIGHT) ((Menage)menage).changeRobotDirection(new Vecteur(1,0));
	  		        if (event.getCode()==KeyCode.UP) ((Menage)menage).changeRobotDirection(new Vecteur(0,-1));
	  		        if (event.getCode()==KeyCode.DOWN) ((Menage)menage).changeRobotDirection(new Vecteur(0,1));
	  		        if (event.getCode()==KeyCode.P) ((Menage)menage).pauseResume();	
	  		        if (event.getCode()==KeyCode.R) ((Menage)menage).setRapidite();		
                	*/
                } finally {
                    socket.close();
                    reader.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
	
}
