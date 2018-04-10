package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Category;
import neu.edu.entity.Role;

@Repository
public interface CategoryDao  extends JpaRepository<Category, Integer>{
	
	public List<Category> findByCategory(String categoryName);
	public List<Category> findByCategoryId(Integer categoryId);
}
