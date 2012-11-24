package com.receipt.vault.integration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.receipt.vault.dao.CategoryRepository;
import com.receipt.vault.model.Category;

@Ignore
@ContextConfiguration("classpath:spring-beans.xml")
public class CategoryRepositoryTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void saveCategory() throws Exception {

		Category Category = new Category("Kitchen");
		categoryRepository.save(Category);
		assertTrue(Category.getId() != null);
		System.out.println(Category.getId());

	}

	@Test
	public void findsAllCategory() throws Exception {

		Category category1 = new Category("Kitchen");
		categoryRepository.save(category1);
		Category category2 = new Category("Office");
		categoryRepository.save(category2);
		assertTrue(categoryRepository.count() == 2);
	}

	@Test
	public void removeCategory() throws Exception {

		Category category1 = new Category("Kitchen");
		categoryRepository.save(category1);
		Long id = category1.getId();
		categoryRepository.delete(category1);
		assertTrue(null == categoryRepository.findOne(id));

	}

	@Test
	public void findByNameAndId() throws Exception {

		Category category = new Category("Kitchen");
		categoryRepository.save(category);
		Category findByNameAndId = categoryRepository.findByNameAndId(
				category.getName(), category.getId());
		assertEquals("Kitchen", findByNameAndId.getName());

	}
}
