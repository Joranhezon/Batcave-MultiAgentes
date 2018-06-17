package Utils;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Utils {
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
}
