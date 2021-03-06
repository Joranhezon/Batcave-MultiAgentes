package Batcomputer;

import jade.core.Agent;
import jade.domain.FIPAException;
import Utils.Constants;
import Utils.Utils;

public class BatcomputerAgent extends Agent{
	
	private final static String requestID = Constants.BATCOMPUTER_REQUEST;
	private ReceiveBatmanRequestBehaviour receiveBatmanRequestBehaviour;
	private SendVillainInfoBehaviour sendVillainInfoBehaviour;
	
	protected void setup() {
		this.sendVillainInfoBehaviour = new SendVillainInfoBehaviour(this);
		this.receiveBatmanRequestBehaviour = new ReceiveBatmanRequestBehaviour(this);
		
		insertInYellowPages();
		
		addBehaviour(receiveBatmanRequestBehaviour);
	}
	
	/* Used to make sure the agent is visible and can be accessed by other agents */
	private void insertInYellowPages() {
		try {
			Utils.insertAgentInYellowPages(this, getAID(), Constants.BATCOMPUTER_AGENT_NAME,
					Constants.BATCOMPUTER_AGENT_TYPE);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void callSendVillaInfoBehaviour() {
		this.sendVillainInfoBehaviour.action();
	}
}
