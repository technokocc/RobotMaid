package data;

import appart.IAppart;
import robot.IRobot;

public interface IData extends IReadService, IWriteService{
	public void init(IRobot robot,IAppart appart);
}
