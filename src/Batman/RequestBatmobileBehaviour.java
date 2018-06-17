package Batman;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RequestBatmobileBehaviour extends CyclicBehaviour{
	private BatmanAgent batmanAgent;
	
	public RequestBatmobileBehaviour(BatmanAgent batmanAgent) {
		this.batmanAgent = batmanAgent;
	}
	
	@Override
	public void action() {
		requestBatmobile();
	}
	
	/* Sends a message to Batmobile Agent to request rendezvous with Batman */
	private void requestBatmobile() {
		AID batmobileAID = Utils.getBatmobileAID(this.batmanAgent);

		if(batmobileAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.BATMAN_TO_BATMOBILE);
			aclMessage.addReceiver(batmobileAID);
			aclMessage.setContent(Constants.BATMAN_BATMOBILE_RENDEZVOUS_REQUEST);
			System.out.println(aclMessage);
			this.batmanAgent.send(aclMessage);
		}
	}
}
