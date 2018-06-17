package Batman;

import Utils.Constants;
import Utils.Utils;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class RequestVillainInfoBehaviour extends CyclicBehaviour {
	
	private BatmanAgent batmanAgent;
	
	public RequestVillainInfoBehaviour(BatmanAgent batmanAgent) {
		this.batmanAgent = batmanAgent;
	}
	
	@Override
	public void action() {
		requestVillainInfo();
	}
	
	/* Used to send a message to the Batcomputer */
	private void requestVillainInfo() {
		AID batcomputerAID = Utils.getBatcomputerAID(this.batmanAgent);

		if(batcomputerAID != null) {
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
			aclMessage.setConversationId(Constants.BATMAN_TO_BATCOMPUTER);
			aclMessage.addReceiver(batcomputerAID);
			aclMessage.setContent(Constants.BATCOMPUTER_VILLAIN_INFO_REQUEST);
			System.out.println(aclMessage);
			this.batmanAgent.send(aclMessage);
		}
	}
}
