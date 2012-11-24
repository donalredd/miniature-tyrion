package com.receipt.vault.service;

import com.receipt.vault.model.Category;

public interface CategoryService {
	
	Iterable<Category> findAll();
	
	Category findById(Long id);

	Category findByName(String name);

	Category findByNameAndId(String name, Long id);

	Category saveCategory(Category category);
}
