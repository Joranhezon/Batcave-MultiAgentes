package Batmobile;

import jade.core.behaviours.CyclicBehaviour;

public class DriveBehaviour extends CyclicBehaviour {
	
	private BatmobileAgent batmobileAgent;
	
	public DriveBehaviour(BatmobileAgent batmobileAgent) {
		this.batmobileAgent = batmobileAgent;
	}
	
	@Override
	public void action() {
		drive();
	}
	
	private void drive() {
		System.out.println("Na na na na na na na na. Batmobile currently being driven by "
				+ this.batmobileAgent.getPilot());
		this.batmobileAgent.removeDriveBehaviour();
	}
}
