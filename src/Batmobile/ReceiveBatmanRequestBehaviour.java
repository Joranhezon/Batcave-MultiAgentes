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
		boolean isRendezvousRequest = checkIfItsRendezvousRequest(message);
				
		if(message != null && isRendezvousRequest != false) {
			this.batmobileAgent.callRendezvousBehaviour();
		}
		else {
			System.out.println("Could not send Batmobile to Batman's location");
		}
	}
	
	/* Search for a request from the Batman agent */
	private String searchForBatmanRequest() {
		System.out.print("entrei aqui");
		MessageTemplate messageTemplate = 
				MessageTemplate.MatchConversationId(Constants.BATMAN_TO_BATMOBILE);
		ACLMessage aclMessage = this.batmobileAgent.receive(messageTemplate);

		String message = null;
		if(aclMessage != null) {
			message = aclMessage.getContent();
		}
		else {
			block();
		}

		return message;
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
