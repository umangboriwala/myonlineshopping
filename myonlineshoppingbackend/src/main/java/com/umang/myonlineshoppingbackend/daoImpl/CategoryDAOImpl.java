package com.umang.myonlineshoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.umang.myonlineshoppingbackend.dao.CategoryDAO;
import com.umang.myonlineshoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//adding first category
		category.setId(1); 
		category.setName("Television");
		category.setDescription("description for television");
		category.setImageURL("CAT_01.png");
		
		categories.add(category);
		

		//adding second category
		category = new Category();
		category.setId(2); 
		category.setName("Laptop");
		category.setDescription("description for laptop");
		category.setImageURL("CAT_02.png");
		
		categories.add(category);
		
		//adding Third category
		category = new Category();
		category.setId(3); 
		category.setName("Mobile");
		category.setDescription("description for mobile");
		category.setImageURL("CAT_03.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
