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
		if(checkRequest()) {
			System.out.println("Sending Batmobile to Batman Location");
		}
		else {
			System.out.println("Request denied!");
		}
	}
	
	private boolean checkRequest() {
		if()
	}
}
