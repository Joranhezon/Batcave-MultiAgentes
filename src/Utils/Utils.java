package Utils;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Utils {
	
	/* Used to make an agent visible for other agents */
	public static void insertAgentInYellowPages(Agent agent, AID aid, String name,
			String type) throws FIPAException {
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		dfAgentDescription.setName(aid);

		ServiceDescription serviceDescription = new ServiceDescription();
		
		serviceDescription.setName(name);
		serviceDescription.setType(type);

		dfAgentDescription.addServices(serviceDescription);

		DFService.register(agent, dfAgentDescription);

	}
	
	/* Generic code used to search for an agent */
	public static AID searchForAgent(Agent agent, String name,
			String type) throws FIPAException {
		
		DFAgentDescription dfAgentDescription = new DFAgentDescription();
		ServiceDescription serviceDescription = new ServiceDescription();

		serviceDescription.setType(type);
		serviceDescription.setName(name);

		dfAgentDescription.addServices(serviceDescription);

		DFAgentDescription[] result = DFService.search(agent, dfAgentDescription);
		
		AID agentsAID = result[0].getName();
		
		if(agentsAID == null) {
			System.out.println("Null AID:" + name + " and " + type);
		}
		

		return result[0].getName();
	}
	
	/* Used to search and return the Batmobile agent */
	public static AID getBatmobileAID(Agent agent) {
		AID batmobileAID = null;
		
		try {
			batmobileAID = 
					Utils.searchForAgent(
							agent,
							Constants.BATMOBILE_AGENT_NAME,
							Constants.BATMOBILE_AGENT_TYPE);
			
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return batmobileAID;
	}
}
