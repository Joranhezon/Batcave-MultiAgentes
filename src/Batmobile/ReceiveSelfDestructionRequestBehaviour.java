package Batmobile;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveSelfDestructionRequestBehaviour extends CyclicBehaviour{
	
	private BatmobileAgent batmobileAgent;
	
	public ReceiveSelfDestructionRequestBehaviour(BatmobileAgent batmobileAgent) {
		this.batmobileAgent = batmobileAgent;
	}
	
	@Override
	public void action() {
		String message = searchForSelfDestructionRequest();
		
		if(message != null){
			this.batmobileAgent.callSelfDestructionBehaviour();
		}
	}

	/* Search for a request from the Batman agent */
	private String searchForSelfDestructionRequest() {
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
}
