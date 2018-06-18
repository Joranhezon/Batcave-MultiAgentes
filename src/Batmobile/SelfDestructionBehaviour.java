package Batmobile;

import jade.core.behaviours.CyclicBehaviour;

public class SelfDestructionBehaviour extends CyclicBehaviour{
	
	private BatmobileAgent batmobileAgent;
	
	public SelfDestructionBehaviour(BatmobileAgent batmobileAgent) {
		this.batmobileAgent = batmobileAgent;
	}
	
	@Override
	public void action() {
		selfDestruct();
	}
	
	private void selfDestruct() {
		System.out.println("BOOOOOOOOOOOOOOM!!Batmobile exploded!!");;
	}
}
