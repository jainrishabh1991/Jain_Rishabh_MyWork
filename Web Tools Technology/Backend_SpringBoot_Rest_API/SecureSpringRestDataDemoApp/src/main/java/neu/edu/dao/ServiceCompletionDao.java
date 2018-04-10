package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Servicecompletion;

@Repository
public interface ServiceCompletionDao extends JpaRepository<Servicecompletion, Integer>{
	
	public Servicecompletion findTop1ByServicebidServiceBidIdOrderByProgressDesc(Integer serviceBid);
	
	public List<Servicecompletion> findByServicebidServiceBidIdOrderByProgressDesc(Integer serviceBid);
	
}
