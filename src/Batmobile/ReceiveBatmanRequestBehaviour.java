package Batmobile;

import Utils.Constants;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveBatmanRequestBehaviour extends CyclicBehaviour{
	
	private BatmobileAgent batmobileAgent;
	
	public ReceiveBatmanRequestBehaviour(BatmobileAgent batmobileAgent) {
		this.batmobileAgent = batmobileAgent;
	}
	
	@Override
	public void action() {
		String message = searchForBatmanRequest();
		
		if(message != null) {
			this.batmobileAgent.callRendezvousBehaviour();
		}
		
	}
	
	/* Search for a request from the Batman agent */
	private String searchForBatmanRequest() {
		ACLMessage aclMessage = this.batmobileAgent.receive();

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
	
	private boolean checkIfItsRendezvousRequest(String message) {
		if(message == Constants.BATMAN_BATMOBILE_RENDEZVOUS_REQUEST) {
			return true;
		}
		else {
			return false;
		}
	}
}
