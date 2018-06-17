package Batcomputer;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveBatmanRequestBehaviour extends CyclicBehaviour{
	
	private BatcomputerAgent batcomputerAgent;
	
	public ReceiveBatmanRequestBehaviour(BatcomputerAgent batcomputerAgent) {
		this.batcomputerAgent = batcomputerAgent;
	}
	
	@Override
	public void action() {
		String message = searchForBatmanRequest();
		
		if(message != null) {
			
		}
	}
	
	/* Search for a request from the Batman agent */
	private String searchForBatmanRequest() {
		ACLMessage aclMessage = this.batcomputerAgent.receive();

		String message = null;
		if(aclMessage != null) {
			message = aclMessage.getContent();
			return message;
		}
		else {
			block();
			return null;
		}
		
	}
}
