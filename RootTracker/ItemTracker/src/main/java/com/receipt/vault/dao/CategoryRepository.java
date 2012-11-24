package com.receipt.vault.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.receipt.vault.model.Category;
import com.receipt.vault.model.User;

public interface CategoryRepository extends CrudRepository<Category, Long>,
	JpaSpecificationExecutor<User> {

    Category findById(Long id);

    Category findByName(String name);

    Category findByNameAndId(String name, Long id);
}
