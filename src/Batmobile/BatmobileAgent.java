package Batmobile;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.Constants;
import Utils.Utils;

public class BatmobileAgent extends Agent {
	
	private String pilot = null; 
	private DriveBehaviour driveBehaviour;
	private RendezvousBehaviour rendezvousBehaviour;
	private ReceiveBatmanRequestBehaviour receiveBatmanRequestBehaviour;


	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	
	protected void setup() {
		this.pilot = Constants.CHANGE_PILOT_TO_BATMAN;
		
		this.driveBehaviour = new DriveBehaviour(this);
		this.rendezvousBehaviour = new RendezvousBehaviour(this);
		this.receiveBatmanRequestBehaviour = new ReceiveBatmanRequestBehaviour(this);
		
		insertInYellowPages();
		
		addBehaviour(driveBehaviour);
		addBehaviour(receiveBatmanRequestBehaviour);
	}
	
	/* Used to make sure the agent is visible and can be accessed by other agents */
	private void insertInYellowPages() {
		try {
			Utils.insertAgentInYellowPages(this, getAID(), Constants.BATMOBILE_AGENT_NAME,
					Constants.BATMOBILE_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addDriveBehaviour() {
		this.addBehaviour(driveBehaviour);
	}
	
	public void removeDriveBehaviour() {
		this.removeBehaviour(driveBehaviour);
	}
	
	public void callRendezvousBehaviour() {
		this.rendezvousBehaviour.action();
	}
}
