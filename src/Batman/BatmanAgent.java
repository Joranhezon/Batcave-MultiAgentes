package Batman;

import Utils.Constants;
import Utils.Utils;
import jade.core.Agent;
import jade.domain.FIPAException;

public class BatmanAgent extends Agent{
	
	private final static String requestID = Constants.BATMAN_REQUEST;
	private RequestBatmobileBehaviour requestBatmobileBehaviour;
	
	protected void setup() {
		requestBatmobileBehaviour = new RequestBatmobileBehaviour(this);
		
		insertInYellowPages();
	}
	
	/* Used to make sure the agent is visible and can be accessed by other agents */
	private void insertInYellowPages() {
		try {
			Utils.insertAgentInYellowPages(this, getAID(), Constants.BATMAN_AGENT_NAME,
					Constants.BATMAN_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
