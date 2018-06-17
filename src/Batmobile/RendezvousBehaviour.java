package Batmobile;

import jade.core.behaviours.CyclicBehaviour;
import Utils.Constants;

public class RendezvousBehaviour extends CyclicBehaviour {
	
	private BatmobileAgent batmobileAgent;
	
	public RendezvousBehaviour(BatmobileAgent batmobileAgent) {
		this.batmobileAgent = batmobileAgent; 
	}
	
	@Override
	public void action() {
		rendezvous();
	}
	
	private void rendezvous() {
		System.out.println("Sending Batmobile to Batman Location");
	}
	
}
