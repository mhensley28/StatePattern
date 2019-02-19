package StatePackage;

public class RobotNotHoldingPartState implements State{
	RoboticCell roboticCell;
	 
	public RobotNotHoldingPartState(RoboticCell roboticCell) {
		this.roboticCell = roboticCell;
	}
	
	public void partAtInfeed() {
		System.out.println("Sensor detects part at infeed.");
	}
	  
	public void moveToInfeed() {
		System.out.println("Robot moving to infeed.");
	}
	
	public void moveToOutfeed() {
		System.out.println("Robot cannot move to outfeed yet.");
	}
	
	public void outfeedClear() {
		System.out.println("Sensor detects no part at outfeed.");
	}
	
	public void closeGripper() {
		System.out.println("Part gripped.");
		roboticCell.setState(roboticCell.getRobotHoldingPartState());
	}
	
	public void openGripper() {
		System.out.print("Gripper is already open.");
		roboticCell.setState(roboticCell.getRobotNotHoldingPartState());
	}
	
	public void resetThroughput() {};
	
	public String toString() {
		return "Robot waiting for part at infeed.";
	}
}
