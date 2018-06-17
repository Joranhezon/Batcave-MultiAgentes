package Batmobile;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.Constants;
import Utils.Utils;

public class BatmobileAgent extends Agent {
	
	private String pilot = null; 
	private DriveBehaviour driveBehaviour;


	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	
	/* Serves as the initializer of the class */
	protected void ignition() {
		this.pilot = Constants.CHANGE_PILOT_TO_BATMAN;
		
		driveBehaviour = new DriveBehaviour(this);
		
		insertInYellowPages();
		
		addBehaviour(driveBehaviour);
	}
	
	private void insertInYellowPages() {
		try {
			Utils.insertAgentInYellowPages(this, getAID(), Constants.BATMOBILE_AGENT_NAME,
					Constants.BATMOBILE_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
