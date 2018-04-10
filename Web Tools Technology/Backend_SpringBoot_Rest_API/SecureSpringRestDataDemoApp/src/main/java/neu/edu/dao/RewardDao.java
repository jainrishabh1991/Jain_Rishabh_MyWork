package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import neu.edu.entity.Reward;

@Repository
public interface RewardDao extends JpaRepository<Reward, Integer>{
	
	public List<Reward> findByProjectProjectid(Integer projectId);
	
}
