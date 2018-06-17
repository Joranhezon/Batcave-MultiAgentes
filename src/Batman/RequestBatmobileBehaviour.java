package Batman;

import jade.core.behaviours.CyclicBehaviour;

public class RequestBatmobileBehaviour extends CyclicBehaviour{
	private BatmanAgent batmanAgent;
	
	public RequestBatmobileBehaviour(BatmanAgent batmanAgent) {
		this.batmanAgent = batmanAgent;
	}
	
	@Override
	public void action() {
		requestBatmobile();
	}
	
	private void requestBatmobile() {
		
	}
}
