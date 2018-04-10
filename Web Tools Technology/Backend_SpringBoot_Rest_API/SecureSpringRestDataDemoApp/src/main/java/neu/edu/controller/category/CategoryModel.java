package neu.edu.controller.category;

import javax.validation.constraints.NotNull;

public class CategoryModel {
	
	@NotNull
	private String category;
	
	private Integer categoryId;
	
	
	
	public CategoryModel() {
		
	}

	public CategoryModel(Integer categoryId) {
		// TODO Auto-generated constructor stub
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
