package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Startup;

@Repository
public interface StartupDao extends JpaRepository<Startup, Integer>{
	
	public List<Startup> findByCategoryCategoryId(Integer categoryId);
	
}
