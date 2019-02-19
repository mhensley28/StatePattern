package StatePackage;

public class RobotPickAndPlace_main {

	public static void main(String[] args) {
		RoboticCell roboticCell = new RoboticCell(0);
		
		System.out.println(roboticCell);
		
		for(int i=0; i<3; i++) {
			roboticCell.partAtInfeed();
			roboticCell.outfeedClear();
		}
		
		System.out.println(roboticCell);
		
		roboticCell.resetThroughput();
		
		System.out.println(roboticCell);

	}
}
