package Batcomputer;

import jade.core.behaviours.CyclicBehaviour;

public class SendVillainInfoBehaviour extends CyclicBehaviour {
	
	private BatcomputerAgent batcomputerAgent;
	
	public SendVillainInfoBehaviour(BatcomputerAgent batcomputerAgent) {
		this.batcomputerAgent = batcomputerAgent;
	}
	
	@Override
	public void action() {
		sendBatmanTheVillainInfo();
	}
	
	private void sendBatmanTheVillainInfo() {
		System.out.println("Villain Name: Killer Croc");
		System.out.println("Real Name: Waylon Jones");
		System.out.println("Abilities: Super strength, enhanced speed, enhanced agility");
	}
}
