package data;

import algorithme.IStrategy;
import appart.IAppart;
import robot.IRobot;
import robot.RobotException;

public interface IData extends IReadService, IWriteService{
	public void init(IRobot robot,IAppart appart,IStrategy strategie);
	public void doAction() throws RobotException ;	
}
