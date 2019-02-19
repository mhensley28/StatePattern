package StatePackage;

public class RoboticCell {
 
	State robotWaitingForInfeedState;
	State robotWaitingForOutfeedState;
	State robotHoldingPartState;
	State robotNotHoldingPartState;

 
	State state;
	int throughput = 0;
	
	public RoboticCell(int systemThroughput) {
		robotWaitingForInfeedState = new RobotWaitingForInfeedState(this);
		robotWaitingForOutfeedState = new RobotWaitingForOutfeedState(this);
		robotHoldingPartState = new RobotHoldingPartState(this);
		robotNotHoldingPartState = new RobotNotHoldingPartState(this);
		
		this.throughput = systemThroughput;
 		if (throughput <= 0) {
			state = robotWaitingForInfeedState;
		}
	}
	
	public void partAtInfeed() {
		state.partAtInfeed();
		state.moveToInfeed();
		state.closeGripper();
	}
 
	public void outfeedClear() {
		state.outfeedClear();
		state.moveToOutfeed();
		state.openGripper();
		this.partComplete();
	}
 
 
	void partComplete() {
		System.out.println("A part has exited the system...");
		throughput += 1;
	}
 
	int getThroughput() {
		return throughput;
	}
 
	void resetThroughput() {
		this.throughput = 0;
		System.out.println("System throughput has been reset; throughput = " + this.throughput);
		state.resetThroughput();
	}

	void setState(State state) {
		this.state = state;
	}
    public State getState() {
        return state;
    }

    public State getRobotWaitingForInfeedState() {
        return robotWaitingForInfeedState;
    }

    public State getRobotWaitingForOutfeedState() {
        return robotWaitingForOutfeedState;
    }

    public State getRobotHoldingPartState() {
        return robotHoldingPartState;
    }

    public State getRobotNotHoldingPartState() {
        return robotNotHoldingPartState;
    }

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nRobotic Pick and Place");
		result.append("\nParts Cycled: " + throughput + "\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
