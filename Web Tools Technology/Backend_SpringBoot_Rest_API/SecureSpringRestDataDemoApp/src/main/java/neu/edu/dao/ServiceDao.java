package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import neu.edu.entity.Service;


@Repository
public interface ServiceDao extends JpaRepository<Service, Integer>{
	
	public List<Service> findByProjectProjectid(Integer projectId);
	
}
