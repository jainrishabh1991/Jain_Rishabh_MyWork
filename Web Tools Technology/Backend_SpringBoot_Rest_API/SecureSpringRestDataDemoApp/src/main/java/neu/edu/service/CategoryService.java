package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.category.CategoryModel;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.User;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		
		return categoryDao.findAll().stream().map(x -> {
			CategoryModel temp = new CategoryModel(x.getCategoryId());
			temp.setCategory(x.getCategory());
			return temp;
		}).collect(Collectors.toList());
	}
	
	@Transactional
	public Integer createCategory(CategoryModel categoryModel) {
		
			Category category=new Category();
			category.setCategory(categoryModel.getCategory());
			category=categoryDao.save(category);
			System.out.println("ID Created " + category.getCategoryId());
			return category.getCategoryId();

	}
	
	@Transactional
	public boolean deleteCategory(Integer categoryId) {
		
		Category toBeDeleted = categoryDao.findOne(categoryId);
		
		if (toBeDeleted!=null && toBeDeleted.getProjects().size() <= 0 && toBeDeleted.getStartups().size()<= 0){
			categoryDao.delete(toBeDeleted);
			return true;
		}
		return false;
		
	}
	
	@Transactional
	public boolean updateCategory(Integer categoryId, CategoryModel newCategory) {
		
		Category toBeUpdated = categoryDao.findOne(categoryId);
		
		if (toBeUpdated!=null){
			toBeUpdated.setCategory(newCategory.getCategory());
			categoryDao.save(toBeUpdated);
			return true;
		}
		return false;
		
	}
	
}
