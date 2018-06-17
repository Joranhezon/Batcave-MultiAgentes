package Batmobile;

import jade.core.Agent;
import Utils.Constants;

public class BatmobileAgent extends Agent {
	
	private String pilot = null; 
	private DriveBehavior driveBehavior;
	private RendezvousBehavior rendezvousBehavior;
	private ChangePilotBehavior changePilotBehavior;
	private ReturnToBatcaveBehavior returnToBatcaveBehavior;
	
	/* Serves as the initializer of the class */
	protected void ignition() {
		this.pilot = Constants.CHANGE_PILOT_TO_BATMAN;
		
		driveBehavior = new DriveBehavior(this)
		
		insertYellowPages();
		
		addBehaviour(driveBehavior);
	}
}
