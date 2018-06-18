package Batman;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RequestBatmobileSelfDestructionBehaviour extends CyclicBehaviour {
	
	private BatmanAgent batmanAgent;
	
	public RequestBatmobileSelfDestructionBehaviour(BatmanAgent batmanAgent) {
		this.batmanAgent = batmanAgent;
	}
	
	@Override
	public void action(){
		requestBatmobileSelfDestructionBehaviour();
	}
	
	private void requestBatmobileSelfDestructionBehaviour() {
		AID batmobileAID = Utils.getBatmobileAID(this.batmanAgent);

		if(batmobileAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.BATMAN_TO_BATMOBILE);
			aclMessage.addReceiver(batmobileAID);
			aclMessage.setContent(Constants.BATMAN_BATMOBILE_SELFDESTRUCTION_REQUEST);
			
			this.batmanAgent.send(aclMessage);
		}
	}
}
