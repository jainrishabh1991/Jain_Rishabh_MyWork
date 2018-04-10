package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import neu.edu.entity.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
	
	public List<Project> findByCategoryCategoryIdOrderByStartDateAsc(Integer categoryId);
	
	public List<Project> findByUserUserId(Integer userId);
	
}
