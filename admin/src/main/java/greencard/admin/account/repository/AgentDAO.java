package greencard.admin.account.repository;

import greencard.admin.account.model.Agent;

public interface AgentDAO {
	
	void save(Agent user);

	Agent findByUserID(int agclid);

	Agent findByEmailID(String email);
}
