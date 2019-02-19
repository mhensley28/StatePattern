package StatePackage;

public class RobotHoldingPartState implements State{
	RoboticCell roboticCell;
	 
	public RobotHoldingPartState(RoboticCell roboticCell) {
		this.roboticCell = roboticCell;
	}
	
	public void partAtInfeed() {
		System.out.println("Sensor detects part at infeed.");
	}
	  
	public void moveToInfeed() {
		System.out.println("Robot must place part at outfeed first.");
	}
	
	public void moveToOutfeed() {
		System.out.println("Robot moving to outfeed.");
	}
	
	public void outfeedClear() {
		System.out.println("Sensor detects no part at outfeed.");
	}
	
	public void closeGripper() {
		System.out.println("Gripper is already closed.");
	}
	
	public void openGripper() {
		System.out.print("Part released.");
		roboticCell.setState(roboticCell.getRobotNotHoldingPartState());
	}
	
	public void resetThroughput() {};
	
	public String toString() {
		return "Robot waiting for part at infeed.";
	}
}
