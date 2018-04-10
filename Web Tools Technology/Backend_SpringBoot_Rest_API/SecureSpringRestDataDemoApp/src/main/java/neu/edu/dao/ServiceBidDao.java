package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Servicebid;

@Repository
public interface ServiceBidDao extends JpaRepository<Servicebid, Integer>{

	public List<Servicebid> findByStartupStartupIdAndIsAssigned(Integer startupId, Integer isAssigned);
	
	public List<Servicebid> findByServiceServiceId(Integer servicebid);
}
