package controller;

import java.util.Timer;

import robot.IRobot;

public class Menage implements IMenageService, IRequireDataService{

	private Timer menageClock;
	private IRobot robot;
	
	public Menage(){
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.menageClock = new Timer();
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	
}
