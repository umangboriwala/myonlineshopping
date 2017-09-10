package com.umang.myonlineshoppingbackend.dao;

import java.util.List;

import com.umang.myonlineshoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);
}
