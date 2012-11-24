package com.receipt.vault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receipt.vault.dao.CategoryRepository;
import com.receipt.vault.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	CategoryRepository categoryRepository;
	
	@Autowired
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id);
	}

	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	public Category findByNameAndId(String name, Long id) {
		return categoryRepository.findByNameAndId(name,id);
	}

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

}
