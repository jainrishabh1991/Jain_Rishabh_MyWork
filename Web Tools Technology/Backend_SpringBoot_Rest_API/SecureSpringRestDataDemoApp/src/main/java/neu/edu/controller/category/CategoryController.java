package neu.edu.controller.category;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.service.CategoryService;

@RestController
@RequestMapping(path="/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryModel> findAll() {
		
		return categoryService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createCategory(
			@RequestBody CategoryModel categoryModel) {
		
		ResponseEntity<String> response = new ResponseEntity<String>("Category Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (categoryService.createCategory(categoryModel) != null) {
			response = new ResponseEntity<String>("Role Created", HttpStatus.OK);
		}

		return response;
	}


	@RequestMapping(path = "/{categoryId:[0-9]+}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("categoryId") Integer categoryId) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.deleteCategory(categoryId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/{categoryId:[0-9]+}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRole(@PathVariable("categoryId") Integer categoryId, @RequestBody @Valid CategoryModel newCategory) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.updateCategory(categoryId, newCategory);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
}
