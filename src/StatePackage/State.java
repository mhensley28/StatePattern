package StatePackage;

public interface State {
	 
	public void partAtInfeed();
	public void moveToInfeed();
	public void moveToOutfeed();
	public void outfeedClear();
	public void closeGripper();
	public void openGripper();
	
	public void resetThroughput();
}
